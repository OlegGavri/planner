package com.riggle.planner.data

import java.util.*

//
// One Job
//
data class Job(
    val title: String,
    val description : String,
    val created : Date,

    // Complete status in percent
    val complete : Int,
    val isCompleted : Boolean,

    // Project that contain this Job
    val project : Project

    )
