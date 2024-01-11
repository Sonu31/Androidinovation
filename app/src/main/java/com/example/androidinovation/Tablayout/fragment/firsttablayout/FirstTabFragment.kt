package com.example.androidinovation.Tablayout.fragment.firsttablayout

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidinovation.R
import com.example.androidinovation.Tablayout.adapter.firsttabadapter.FirstTabFAdapter
import com.example.androidinovation.databinding.FragmentFirstTabBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.roundToInt

class FirstTabFragment : Fragment() {

    private lateinit var binding:FragmentFirstTabBinding
    private val tabTitles= arrayListOf("Home","Call","Chat")

    private val tabTitle= mutableMapOf("Home" to R.drawable.tabselectergif,"Callss" to R.drawable.selectedimageicon,"Chast" to R.drawable.selectedquotesicon)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstTabBinding.inflate(layoutInflater,container,false)
        setUpTabLayoutWithViewpager()
        setUpTabLayoutWithViewpager2()
        setUpTabLayoutWithViewpager3()
        return binding.root
    }



    private fun setUpTabLayoutWithViewpager() {
        binding.viewpager1.adapter = FirstTabFAdapter(this)
        TabLayoutMediator(binding.tablayout1id,binding.viewpager1){ tab, position->
            tab.text= tabTitles[position]
        }.attach()
    }

    private fun setUpTabLayoutWithViewpager2() {
        binding.viewpager2.adapter = FirstTabFAdapter(this)
        TabLayoutMediator(binding.tablayout1id2,binding.viewpager2){ tab, position->
            tab.text= tabTitles[position]
        }.attach()
        for (i in 0..3){
            var textview = LayoutInflater.from(requireContext()).inflate(R.layout.ftabtitle,null) as TextView
            binding.tablayout1id2.getTabAt(i)?.customView= textview
        }
    }

    private fun setUpTabLayoutWithViewpager3() {
        val titles = ArrayList( tabTitle.keys)
        binding.viewpager3.adapter = FirstTabFAdapter(this)
        TabLayoutMediator(binding.tablayout1id3,binding.viewpager3){ tab, position->
            tab.text= titles [position]
        }.attach()

        tabTitle.values.forEachIndexed{ index, imageid ->
            var textview = LayoutInflater.from(requireContext()).inflate(R.layout.ftabtitle,null) as TextView
           textview.setCompoundDrawablesWithIntrinsicBounds(0,imageid,0,0)
            textview.compoundDrawablePadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4f,resources.displayMetrics).roundToInt()
            binding.tablayout1id3.getTabAt(imageid)?.customView= textview

        }




        }
    }







