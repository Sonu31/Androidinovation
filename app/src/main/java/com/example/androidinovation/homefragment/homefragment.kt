package com.example.androidinovation.homefragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.findNavController
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentHomefragmentBinding
import com.example.androidinovation.jetpack.JetpackHomeActivity
import com.example.androidinovation.jetpack.JetpackMainActivity
import com.modlueinfotech.allwishesgif.utils.Util

class homefragment : Fragment() {

    lateinit var binding:FragmentHomefragmentBinding
    lateinit var toggle: ActionBarDrawerToggle




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomefragmentBinding.inflate(inflater,container,false)

         allButtonClick()







        return  binding.root
    }

    private fun allButtonClick() {
        //Thirdparty Libararybtn
        binding.mythiredpartylibararybtnid.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_homefragment_to_librarieshomeFragment,requireActivity())

        }

        //DragleHilt
        binding.dibtnid.setOnClickListener{
            Util.changeFragment1(findNavController(),R.id.action_homefragment_to_daggerH1Fragment,requireActivity())
        }
        // ListView , RecyclerView,ViewPager ,
        binding.listbtnid.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_homefragment_to_listTypeHomeFragment,requireActivity())
        }

        //TabLayout
        binding.tablayoutbtnid.setOnClickListener {
            Util.changeFragment1(findNavController(),R.id.action_homefragment_to_tabHomeFragment,requireActivity())
        }

  binding.jetpackcomp.setOnClickListener {
      startActivity(Intent(requireContext(),JetpackHomeActivity::class.java))
  }

    }


}