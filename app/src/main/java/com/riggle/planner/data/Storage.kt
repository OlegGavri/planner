package com.riggle.planner.data

import androidx.room.Room
import com.riggle.planner.PlannerApplication
import com.riggle.planner.data.db.AppDatabase
import java.util.Date
import com.riggle.planner.data.db.Project as DbProject
import com.riggle.planner.data.db.Job as DbJob

object Storage {
    private val baseContext = PlannerApplication.instance
    private val db = Room.databaseBuilder(
        baseContext,
        AppDatabase::class.java, "planner-db"
    ).build()

    private val jobDao = db.jobDao()
    private val projectDao = db.projectDao()

    private class InnerProject(
        val dbProject : DbProject
    ) : Project() {
        override val title: String
            get() = dbProject.title

        override val description: String
            get() = dbProject.description

        override val created: Date
            get() = dbProject.created
    }

    private class InnerJob(val dbJob : DbJob) : Job() {
        override val title: String
            get() = dbJob.title

        override val description: String
            get() = dbJob.description

        override val created: Date
            get() = dbJob.created

        override val closed: Date
            get() = dbJob.closed

        override val complete: Int
            get() = dbJob.complete

        override val isCompleted: Boolean
            get() = dbJob.isCompleted

        override val files: List<String>?
            get() = emptyList()
    }

    // Cached in memory projects and jobs data
    private lateinit var data : Map<DbProject, List<DbJob>>

    // Read data from DB and update cached data in memory
    private suspend fun retrieve() {
        data = projectDao.getProjectsAndJobs()
    }

    fun getAllProjects() : List<Project> {
        val dbProjects = data.keys
        val projects : MutableList<Project> = mutableListOf()

        for(dbProject in dbProjects) {
            val project = InnerProject(
                dbProject
            )

            projects.add(project)
        }

        return projects
    }

    suspend fun addProject(project : Project) {
        val dbProject = DbProject(
            0,
            project.title,
            project.description,
            project.created
        )

        projectDao.insert(dbProject)
        retrieve()
    }

    suspend fun removeProject(project : Project) {
        val innerProject = project as InnerProject
        val dbProject = innerProject.dbProject

        val jobs = data[dbProject]
        if (jobs != null) {
            for(job in jobs) {
                jobDao.delete(job)
            }
        }

        projectDao.delete(dbProject)
        retrieve()
    }

    fun getProjectJobs(project : Project) : List<Job> {
        val dbProject = (project as InnerProject).dbProject

        val dbJobs = data[dbProject]
        if(dbJobs != null) {
            val jobs: MutableList<Job> = mutableListOf()

            for (dbJob in dbJobs) {
                val job = InnerJob(dbJob)
                jobs.add(job)
            }

            return jobs
        }

        return emptyList()
    }

    suspend fun addJob(project: Project, job : Job) {
        val dbProject = (project as InnerProject).dbProject
        val dbJob = DbJob(
            0,
            job.title,
            job.description,
            job.created,
            job.closed,
            job.complete,
            job.isCompleted,
            dbProject.id
        )
        jobDao.insert(dbJob)
        retrieve()
    }

    suspend fun removeJob(job : Job) {
        val dbJob = (job as InnerJob).dbJob
        jobDao.delete(dbJob)
        retrieve()
    }
}