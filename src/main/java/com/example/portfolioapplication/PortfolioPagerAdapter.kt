// PortfolioPagerAdapter.kt
package com.example.portfolioapplication  // Make sure this matches your package name

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PortfolioPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4  // Number of tabs/fragments

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AboutFragment()
            1 -> SkillsFragment()
            2 -> ProjectsFragment()
            else -> ContactFragment()
        }
    }
}