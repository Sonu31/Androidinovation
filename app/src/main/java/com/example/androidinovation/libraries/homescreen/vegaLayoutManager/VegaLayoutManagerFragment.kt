package com.example.androidinovation.libraries.homescreen.vegaLayoutManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.examp.goodmorning.Frame.adpter.TextViewAdapter
import com.example.androidinovation.databinding.FragmentVegaLayoutManagerBinding
import com.example.androidinovation.libraries.homescreen.waterfalltoolbar.adapter.MyModel

class VegaLayoutManagerFragment : Fragment() {

    lateinit var imglist:ArrayList<MyModel>

  lateinit var binding:FragmentVegaLayoutManagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVegaLayoutManagerBinding.inflate(layoutInflater,container,false)
        imglist = ArrayList()

        for (i in 1.. 20)
        {
            imglist.add(MyModel("My Name id ! "))
            imglist.add(MyModel("My Name id 2 "))
            var adpterOneImage = TextViewAdapter(imglist,requireContext())
            binding.rvVegalayoutid.adapter= adpterOneImage

        }
        binding.rvVegalayoutid.layoutManager =

        return binding.root
    }


}