package com.andipputra.testbareksa.ui.main.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andipputra.testbareksa.ui.main.main.PlaceholderFragment

class SectionsPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

//    override fun getItem(position: Int): Fragment {
//        return PlaceholderFragment.newInstance(position + 1)
//    }

//    override fun getPageTitle(position: Int): CharSequence {
//        return context.resources.getString(TAB_TITLES[position])
//    }
//
//    override fun getCount(): Int {
//        return 2
//    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment()
    }
}