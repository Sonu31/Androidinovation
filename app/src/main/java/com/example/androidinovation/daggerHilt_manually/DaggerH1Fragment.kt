package com.example.androidinovation.daggerHilt_manually

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidinovation.daggerHilt_manually.baseClass.BaseApp
import com.example.androidinovation.databinding.FragmentDaggerH1Binding

class DaggerH1Fragment : Fragment() {


    lateinit var  binding:FragmentDaggerH1Binding
    private lateinit var baseapp:BaseApp

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDaggerH1Binding.inflate(layoutInflater,container,false)

        baseapp = BaseApp()
        baseapp.car.getCar()




        return binding.root
    }

}