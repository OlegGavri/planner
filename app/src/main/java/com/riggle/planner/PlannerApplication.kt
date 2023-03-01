package com.riggle.planner

import android.app.Application

class PlannerApplication : Application() {

    companion object {
        private var instance_: PlannerApplication? = null

        val instance: PlannerApplication
            get() = instance_!!
    }

    override fun onCreate() {
        super.onCreate()

        instance_ = this
    }
}