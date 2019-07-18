package com.mastertechsoftware.twine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mastertechsoftware.twine.R
import kotlinx.android.synthetic.main.tab_layout.*

/**
 *
 */
class TabFragment: Fragment() {
    lateinit var adapter: TabbedFragmentPagerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tab_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager.offscreenPageLimit =
            2 // This forces the viewPager to keep the 2 screens in memory instead of reloading

        adapter = TabbedFragmentPagerAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class TabbedFragmentPagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {
        private val tabTitles = arrayOf(getString(R.string.edit), getString(R.string.activity))
        private val tabFragments = arrayListOf<Fragment>()

        override fun getCount(): Int = tabTitles.size

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    if (tabFragments.size > 0) {
                        return tabFragments[0]
                    }
                    tabFragments.add(DepositsFragment())
                    return tabFragments[0]
                }
                else -> {
                    if (tabFragments.size > 1) {
                        return tabFragments[1]
                    }
                    tabFragments.add(ActivityFragment())
                    return tabFragments[1]
                }
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}