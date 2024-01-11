package com.example.androidinovation.Tablayout.tabhomescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentTabhomeBinding
import com.modlueinfotech.allwishesgif.utils.Util

class TabHomeFragment:Fragment() {

    private lateinit var binding: FragmentTabhomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabhomeBinding.inflate(inflater,container,false)
       binding.tabbtnid1.setOnClickListener {
           Util.changeFragment1(findNavController(), R.id.action_tabHomeFragment_to_firstTabFragment,requireActivity())
       }
        binding.tabbtnid2.setOnClickListener {
            Util.changeFragment1(findNavController(), R.id.action_tabHomeFragment_to_secondTabHFragment,requireActivity())

        }



        return  binding.root

    }
}