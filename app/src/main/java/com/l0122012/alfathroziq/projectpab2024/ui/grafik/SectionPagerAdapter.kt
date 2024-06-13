package com.l0122012.alfathroziq.projectpab2024.ui.grafik

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionPagerAdapter(fragment : Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = GrafikKiriFragment()
            1 -> fragment = GrafikKananFragment()
        }
        return fragment as Fragment
    }

}