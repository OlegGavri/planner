package com.riggle.planner.data

import java.util.Date

//
// This is project. It contain any Job.
//
abstract class Project {
    abstract val title: String
    abstract val description: String
    abstract val created: Date
}