package com.example.androidinovation.drawerfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentDr2Binding


class DrFragment2 : Fragment() {

    private lateinit var binding:FragmentDr2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDr2Binding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment

        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(requireContext(), R.layout.exposed_dropdownmenu, items)
        (binding.editText as? AutoCompleteTextView)?.setAdapter(adapter)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Sonu Kumar"
        super.onViewCreated(view, savedInstanceState)
    }


}