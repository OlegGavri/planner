package com.riggle.planner.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//
// One Job
//
@Entity
data class Job(
    @PrimaryKey(autoGenerate = true) val uid : Int,
    val title: String,
    val description : String,
    val created : Date,
    val closed : Date,

    // Complete status in percent
    val complete : Int,
    val isCompleted : Boolean,

    val project_id : Int
    )