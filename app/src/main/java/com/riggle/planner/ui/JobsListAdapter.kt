package com.riggle.planner.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riggle.planner.MainActivity
import com.riggle.planner.R
import com.riggle.planner.model.Job
import com.riggle.planner.model.ApplicationViewModel

class JobsListAdapter(
    private val viewModel : ApplicationViewModel
    ) : RecyclerView.Adapter<JobsListAdapter.JobViewHolder>()  {

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view : View = itemView
        lateinit var job : Job
    }

    override fun getItemCount() = viewModel.jobsCount

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.jobs_list_item, parent, false)
        return JobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job : Job = viewModel.jobs(position)
        holder.job = job

        holder.view.apply {
            setOnClickListener {
                val mainActivity = context as MainActivity
                val navController = mainActivity.navController

                viewModel.currentJob = job
                navController.navigate(R.id.action_jobsFragment_to_taskListFragment)
            }
        }
    }
}