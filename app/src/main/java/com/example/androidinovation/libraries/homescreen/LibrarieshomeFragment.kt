package com.example.androidinovation.libraries.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentHomeLibrariesBinding
import com.modlueinfotech.allwishesgif.utils.Util


class LibrarieshomeFragment : Fragment() {

    lateinit var binding:FragmentHomeLibrariesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLibrariesBinding.inflate(inflater,container,false)


        //WaterFall Toolbar
        binding.text1.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_librarieshomeFragment_to_waterfalltoolbarFragment,requireActivity())
        }
        binding.waterfalllinkid.setOnClickListener {
            Util.openUrl(requireContext(),"https://github.com/hcbpassos/waterfall-toolbar")
        }

        //SwipeBackLayout
        binding.text2.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_librarieshomeFragment_to_swipeBackLayoutFragment,requireActivity())

        }
        binding.swipebacklayoutlinkid.setOnClickListener {
            Util.openUrl(requireContext(),"https://github.com/gongwen/SwipeBackLayout")

        }

//        VegaLayoutManager
        binding.text3.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_librarieshomeFragment_to_vegaLayoutManagerFragment,requireActivity())
        }
        binding.vegaLayoutManagerlinkid.setOnClickListener {
            Util.openUrl(requireContext(),"https://github.com/xmuSistone/VegaLayoutManager")
        }




        return  binding.root

    }


}