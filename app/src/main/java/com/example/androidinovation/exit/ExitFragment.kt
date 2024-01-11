package com.example.androidinovation.exit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidinovation.databinding.FragmentExitBinding

class ExitFragment : Fragment() {

    private  lateinit var binding:FragmentExitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExitBinding.inflate(layoutInflater,container,false)




    return binding.root   // Inflate the layout for this fragment

    }

}