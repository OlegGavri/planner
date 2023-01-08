package com.riggle.planner.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riggle.planner.R

class JobsListAdapter : RecyclerView.Adapter<JobsListAdapter.JobViewHolder>()  {
    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item : TextView = itemView.findViewById<TextView>(R.id.jobTitle)
    }

    override fun getItemCount() = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.jobs_list_item, parent, false)
        return JobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        holder.item.text = "The text"
    }

}