package com.riggle.planner.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity
data class Project (
    @PrimaryKey(autoGenerate = true) val id : Int,
    val title : String,
    val description : String,
    val created : Date
)