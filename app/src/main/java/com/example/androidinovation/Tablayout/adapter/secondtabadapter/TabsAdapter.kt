package com.example.androidinovation.Tablayout.adapter.secondtabadapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FCallFragment
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FChatsFragment
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FHomeFragment

class TabsAdapter(var context: Context,fm: FragmentManager,var totalTabs: Int) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                FCallFragment()
            }
            1 -> {
                FChatsFragment()
            }
            2 -> {
                FHomeFragment()
            }
            else -> getItem(position)
        }
    }
}