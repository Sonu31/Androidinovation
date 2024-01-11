package com.example.androidinovation.libraries.homescreen.swipebackLayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentSwipeBackLayoutBinding

class SwipeBackLayoutFragment : Fragment() {

    lateinit var binding:FragmentSwipeBackLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSwipeBackLayoutBinding.inflate(layoutInflater,container,false)
       allbtnclick()
        return binding.root
    }

    private fun allbtnclick() {
        binding.btnCommon.setOnClickListener {

        }
    }

}