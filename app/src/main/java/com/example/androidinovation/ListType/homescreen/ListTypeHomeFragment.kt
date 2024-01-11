package com.example.androidinovation.ListType.homescreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidinovation.ListType.adapter.ListViewAdapter
import com.example.androidinovation.ListType.fragment.ListViewFragment
import com.example.androidinovation.R
import com.example.androidinovation.databinding.FragmentListTypeHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ListTypeHomeFragment : Fragment() {

    lateinit var binding:FragmentListTypeHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListTypeHomeBinding.inflate(inflater,container,false)

       buttonClickListner()

        return binding.root
    }

    private fun buttonClickListner() {
        binding.listviewbtnid.setOnClickListener {
            ListViewFragment.newInstance(getString(R.string.label_logout), getString(R.string.msg_logout)).show(requireActivity().supportFragmentManager, ListViewFragment.TAG)
        }
    }

}