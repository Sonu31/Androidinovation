package com.example.androidinovation.Tablayout.adapter.firsttabadapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FCallFragment
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FChatsFragment
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FHomeFragment

class FirstTabFAdapter(fragment:Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount():Int =3
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->FHomeFragment()
            1->FChatsFragment()
            else -> FCallFragment()

        }
    }

}