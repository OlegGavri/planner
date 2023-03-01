package com.riggle.planner.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Job::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jobDao() : JobDao
}