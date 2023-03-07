package com.riggle.planner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riggle.planner.R
import com.riggle.planner.viewmodel.ProjectListFragmentViewModel

class ProjectListAdapter(
    private val viewModel : ProjectListFragmentViewModel,
    private val context : Context) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ProjectViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val view : View = itemView

        fun setTitle(value : String) {
            val textView = view.findViewById<TextView>(R.id.project_title)
            textView.text = value
        }

        fun setDescription(value : String) {
            val textView = view.findViewById<TextView>(R.id.project_description)
            textView.text = value
        }

        fun setProgress(value : Int, text : String) {
            val progressBar = view.findViewById<ProgressBar>(R.id.project_progress_bar)
            val textView = view.findViewById<TextView>(R.id.project_progress_text_view)

            progressBar.progress = value
            textView.text = text
        }
    }

    override fun getItemCount(): Int {
        return viewModel.getProjectsCount()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.project_list_item, parent, false)
        return ProjectViewHolder(itemView = view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val title = viewModel.getProjectTitle(position)
        val description = viewModel.getProjectDescription(position)
        val progress = viewModel.getProjectProgress(position)
        val progressText = context.getString(R.string.progress_value, progress)

        val vh = holder as ProjectViewHolder
        vh.setTitle(title)
        vh.setDescription(description)
        vh.setProgress(progress, progressText)
    }
}
