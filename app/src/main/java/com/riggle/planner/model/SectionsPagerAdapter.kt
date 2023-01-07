package com.riggle.planner.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.riggle.planner.ui.PlaceholderFragment

private const val NumberOfPages = 2

class SectionsPagerAdapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return NumberOfPages
    }

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }
}