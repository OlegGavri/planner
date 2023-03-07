package com.riggle.planner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.riggle.planner.R
import com.riggle.planner.adapters.ProjectListAdapter
import com.riggle.planner.databinding.FragmentProjectListBinding
import com.riggle.planner.viewmodel.ProjectListFragmentViewModel

class ProjectListFragment : Fragment() {

    private val viewModel : ProjectListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_project_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentProjectListBinding.bind(view)
        val adapter = ProjectListAdapter(viewModel, requireContext())
        binding.projectsRecycleView.adapter = adapter

        binding.addProjectFab.setOnClickListener {
            addProjectFabOnClick()
        }
    }

    private fun addProjectFabOnClick() {
        val navController = getNavController()
        navController.navigate(R.id.action_project_list_fragment_to_project_edit_fragment)
    }

    private fun getNavController(): NavController {
        val navHostFragment = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        return navHostFragment.navController
    }
}