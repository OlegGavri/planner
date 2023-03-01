package com.riggle.planner.data

import java.util.Date

abstract class Job {
    abstract val title: String
    abstract val description: String

    abstract val created: Date
    abstract val closed: Date

    // Complete status in percent
    abstract val complete: Int
    abstract val isCompleted: Boolean

    // Associated files
    abstract val files: List<String>?
}
