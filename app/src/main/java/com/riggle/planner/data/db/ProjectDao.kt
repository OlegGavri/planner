package com.riggle.planner.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface ProjectDao {
    @Query("SELECT * FROM project")
    suspend fun getAll() : List<Project>

    @Query("SELECT * FROM project JOIN job ON project.id = job.project_id")
    suspend fun getProjectsAndJobs() : Map<Project, List<Job>>

    @Insert
    suspend fun insert(project: Project)

    @Delete
    suspend fun delete(project: Project)
}