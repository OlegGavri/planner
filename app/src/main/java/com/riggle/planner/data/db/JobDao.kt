package com.riggle.planner.data.db

import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query

@Entity
interface JobDao {
    @Query("SELECT * FROM job")
    fun getAll() : List<Job>

    @Insert
    suspend fun insert(job : Job)

    @Delete
    suspend fun delete(job : Job)
}