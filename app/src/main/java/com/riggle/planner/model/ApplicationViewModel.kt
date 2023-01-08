package com.riggle.planner.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ApplicationViewModel : ViewModel() {

    lateinit var currentJob: Job
    val jobsCount: Int
    get() {
        TODO("Not yet implemented")
    }

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun jobs(position: Int): Job {
        TODO("Not yet implemented")
    }
}