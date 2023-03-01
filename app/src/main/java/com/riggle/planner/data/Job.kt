package com.riggle.planner.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//
// One Job
//
@Entity
data class Job(
    @PrimaryKey val uid : Int,
    val title: String,
    val description : String,
    val created : Date,

    // Complete status in percent
    val complete : Int,
    val isCompleted : Boolean,

    // Project that contain this Job
    val project : Project
    )
{
    // Binding files. Lists of files
    val notes : List<String> = listOf()
    val images : List<String> = listOf()
    val audio : List<String> = listOf()
}
