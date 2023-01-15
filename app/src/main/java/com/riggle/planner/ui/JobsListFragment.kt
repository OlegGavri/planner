package com.riggle.planner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.riggle.planner.R
import com.riggle.planner.databinding.FragmentJobsListBinding
import com.riggle.planner.model.ApplicationViewModel

/**
 * Contain list of jobs
 */
class JobsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentJobsListBinding.bind(view)

        val viewModel: ApplicationViewModel by viewModels()

        val adapter = JobsListAdapter(viewModel)
        binding.recyclerView.adapter = adapter
    }
}