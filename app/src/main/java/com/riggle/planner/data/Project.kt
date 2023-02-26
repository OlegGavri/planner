package com.riggle.planner.data

import java.util.Date

//
// This is project. It contain any Job.
//
data class Project(
    val title : String,
    val description : String,
    val created : Date,

    // Jobs belonging to this Project
    val jobs : List<Job>
) {
    // Degree of completion in percent
    fun completionStatus() : Int {
        TODO("Not implemented yet")
    }
}
