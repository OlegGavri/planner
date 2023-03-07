package com.riggle.planner.viewmodel

import androidx.lifecycle.ViewModel
import com.riggle.planner.data.Storage

//TODO: use as activityViewModel
class ProjectListFragmentViewModel : ViewModel() {
    fun getProjectsCount() : Int {
        val projects = Storage.getAllProjects()
        return projects.size
    }

    fun getProjectTitle(position: Int): String {
        val projects = Storage.getAllProjects()
        return projects[position].title
    }

    fun getProjectDescription(position: Int): String {
        val projects = Storage.getAllProjects()
        return projects[position].description
    }

    fun getProjectProgress(position: Int): Int {
        // Calculate summary complete of the project jobs

        val projects = Storage.getAllProjects()
        val project = projects[position]
        val jobs = Storage.getProjectJobs(project)

        var result = 0

        if(jobs.isNotEmpty()) {
            val total : Double = jobs.size * 100.0
            var complete = 0.0

            for (job in jobs) {
                complete += job.complete
            }

            result = (complete / total * 100.0).toInt()
        }

        return result
    }

    // This is for UI test only

//    fun getProjectsCount() : Int {
//        return 10
//    }
//
//    fun getProjectTitle(position: Int): String {
//        return "This is Project title"
//    }
//
//    fun getProjectDescription(position: Int): String {
//        return "This is long long long long  long long  long long  " +
//                "long long long long long long long long long description"
//    }
//
//    fun getProjectProgress(position: Int): Int {
//        return 68
//    }
}
