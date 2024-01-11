package com.example.androidinovation.drawerfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentDr3Binding


class DrFragment3 : Fragment() {

    private lateinit var binding:FragmentDr3Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDr3Binding.inflate(layoutInflater,container,false)


       /* binding.cardid2.setOnLongClickListener{binding.cardid2.isCheckable(!binding.cardid2.isChecked)
        true}
*/

        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Buttons"
        super.onViewCreated(view, savedInstanceState)
    }


}