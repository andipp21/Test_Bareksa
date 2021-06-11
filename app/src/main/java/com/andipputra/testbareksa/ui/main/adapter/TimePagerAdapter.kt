package com.andipputra.testbareksa.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andipputra.testbareksa.ui.main.chart.ChartFragment

class TimePagerAdapter(fragment: Fragment, private val lengthTitle: Int) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return lengthTitle
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ChartFragment()

        return fragment
    }
}