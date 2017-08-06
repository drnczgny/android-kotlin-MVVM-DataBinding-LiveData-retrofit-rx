package com.adrian.project.ui.jsonplaceholder.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.adrian.project.ui.jsonplaceholder.submodules.postspage.PostsPageFragment

/**
 * Created by cadri on 2017. 08. 05..
 */

class JsonPlaceholderViewPagerAdapter
constructor(val fm: FragmentManager, val jsonPlaceholderViewPagerDataModel: JsonPlaceholderViewPagerDataModel) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(0)
            1 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(1)
            2 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(2)
            3 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(3)
            4 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(4)
            5 -> return jsonPlaceholderViewPagerDataModel.fragmentList().get(5)
            else -> throw UnsupportedOperationException() as Throwable
        }
        return PostsPageFragment.newInstance()
    }

    override fun getCount(): Int {
        return jsonPlaceholderViewPagerDataModel.fragmentList().size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return jsonPlaceholderViewPagerDataModel.titleList().get(position)
    }
}