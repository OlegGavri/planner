package com.riggle.planner.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Project::class, Job::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jobDao() : JobDao
    abstract fun projectDao() : ProjectDao
}