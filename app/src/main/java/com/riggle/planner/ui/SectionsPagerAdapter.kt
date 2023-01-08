package com.riggle.planner.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NumberOfPages = 2

class SectionsPagerAdapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NumberOfPages
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment
        when(position) {
            0 -> fragment = JobsFragment()
            else -> fragment = PlaceholderFragment.newInstance(position + 1)
        }
        return fragment
    }
}