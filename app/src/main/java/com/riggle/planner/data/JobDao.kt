package com.riggle.planner.data

import androidx.room.Entity
import androidx.room.Query

@Entity
interface JobDao {
    @Query("SELECT * FROM job")
    fun getAll() : List<Job>

}