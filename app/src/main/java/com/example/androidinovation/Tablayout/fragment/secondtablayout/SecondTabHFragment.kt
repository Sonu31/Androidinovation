package com.example.androidinovation.Tablayout.fragment.secondtablayout

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.examp.goodmorning.activity.SecondTabAdapter
import com.example.androidinovation.R
import com.example.androidinovation.Tablayout.fragment.firsttablayout.FCallFragment
import com.example.androidinovation.databinding.FragmentSecondTabHBinding
import com.google.android.material.tabs.TabLayout
import com.example.androidinovation.Tablayout.adapter.secondtabadapter.TabsAdapter

class SecondTabHFragment : Fragment() {

    private  lateinit var binding:FragmentSecondTabHBinding
   private lateinit var  secondTabAdapter:SecondTabAdapter

    lateinit var arrlist:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondTabHBinding.inflate(layoutInflater,container,false)

        arrlist = ArrayList()
        arrlist.add("Basic")
        arrlist.add("Advance")
        arrlist.add("Pro")

//        binding.tlSecondid.setupWithViewPager(binding.vpSecondtabid)
//        setUPprepareViewpager(binding.vpSecondtabid,arrlist)
     setUPprepareViewpager2()
        setUPprepareViewpager3()

        return binding.root
    }



    //first
/*
    private fun setUPprepareViewpager(vpSecondtabid: ViewPager, arrlist: java.util.ArrayList<String>) {

        secondTabAdapter = SecondTabAdapter(childFragmentManager)
        secondTabAdapter.contexs(requireContext())
        var fCallFragment = FCallFragment()
        for (i in  0..3){
            var bundle = Bundle()
            bundle.putString("title",arrlist.get(i))
            fCallFragment.arguments= bundle
            secondTabAdapter.addFragment(fCallFragment,arrlist.get(i))
             fCallFragment = FCallFragment()
        }
        vpSecondtabid.adapter = secondTabAdapter

    }
*/
   //Second
    private fun setUPprepareViewpager2() {
        val navIcons = intArrayOf(
            R.drawable.tabicongif,
            R.drawable.tabiconimage,
            R.drawable.tabiconquote
        )
        binding.tablayoutid2.addTab(binding.tablayoutid2.newTab())
        binding.tablayoutid2.addTab(binding.tablayoutid2.newTab())
        binding.tablayoutid2.addTab(binding.tablayoutid2.newTab())
        binding.tablayoutid2.tabGravity = TabLayout.GRAVITY_FILL

        var adapter = getActivity()?.let {
            TabsAdapter(requireContext(), it.getSupportFragmentManager(), binding.tablayoutid2.tabCount)
        }
        binding.vpSecondtabid.adapter = adapter
        binding.tablayoutid2.setupWithViewPager(binding.vpSecondtabid)
        binding.tablayoutid2.apply {
            this.getTabAt(0)?.setIcon(navIcons[0])
            this.getTabAt(1)?.setIcon(navIcons[1]);
            this.getTabAt(2)?.setIcon(navIcons[2]);
            this.getTabAt(0)?.setText("Gif")
            this.getTabAt(1)?.setText("Cards")
            this.getTabAt(2)?.setText("Quotes")?.tabLabelVisibility
            this.setTabTextColors(Color.WHITE, Color.BLACK)
        }
    }

    private fun setUPprepareViewpager3() {
        binding.tablayoutid3.addTab(binding.tablayoutid3.newTab())
        binding.tablayoutid3.addTab(binding.tablayoutid3.newTab())
        binding.tablayoutid3.addTab(binding.tablayoutid3.newTab())
        binding.tablayoutid3.tabGravity = TabLayout.GRAVITY_FILL
        var adapter = getActivity()?.let {
            TabsAdapter(requireContext(), it.getSupportFragmentManager(),    binding.tablayoutid3.tabCount)
        }
        binding.vp3.adapter = adapter
        binding.tablayoutid3.setupWithViewPager(binding.vp3)
        createTabIcons()
    }
        private fun createTabIcons() {
            var tabOne = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null) as TextView
            tabOne.text = "GIF"
            tabOne.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.tabicongif,0,0)
            tabOne.compoundDrawablePadding =5


            binding.tablayoutid3!!.getTabAt(0)!!.customView = tabOne

            val tabTwo = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null) as TextView
            tabTwo.text = "Cards"
            tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.tabiconimage,0,0)
            tabTwo.compoundDrawablePadding = 5


            binding.tablayoutid3!!.getTabAt(1)!!.customView = tabTwo


            val tabThree = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null) as TextView
            tabThree.text = "Quotes"
            tabThree.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.tabiconquote,0,0)
            binding.tablayoutid3!!.getTabAt(2)!!.customView = tabThree
            tabThree.compoundDrawablePadding = 5

//            val tabfour = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null) as TextView
//            tabfour.text = "Frames"
//            tabfour.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.framesiconid,0,0)
//            binding.tablayoutid3!!.getTabAt(3)!!.customView = tabfour
//            tabfour.compoundDrawablePadding = 5
//
//            val tabfive = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null) as TextView
//            tabfive.text = "Wallpaper"
//            tabfive.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.wallpapericonid,0,0)
//            binding.tablayoutid3!!.getTabAt(4)!!.customView = tabfive
//            tabfive.compoundDrawablePadding = 5

        }

}


