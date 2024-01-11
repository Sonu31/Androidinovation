package com.example.androidinovation.libraries.homescreen.waterfalltoolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.examp.goodmorning.Frame.adpter.TextViewAdapter
import com.example.androidinovation.databinding.FragmentWaterfalltoolbar2Binding
import com.example.androidinovation.databinding.FragmentWaterfalltoolbarListBinding
import com.example.androidinovation.libraries.homescreen.waterfalltoolbar.adapter.MyModel
import com.hugocastelani.waterfalltoolbar.Dp


class WaterfalltoolbarFragment : Fragment() {
//    lateinit var binding:FragmentWaterfalltoolbarBinding

    lateinit var imglist:ArrayList<MyModel>
    lateinit var listbinding:FragmentWaterfalltoolbarListBinding

    lateinit var mybinding:FragmentWaterfalltoolbar2Binding

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        binding = FragmentWaterfalltoolbarBinding.inflate(layoutInflater,container,false)

     /*   listbinding = FragmentWaterfalltoolbarListBinding.inflate(layoutInflater,container,false)
        // Set the adapter
        if ( listbinding.list is RecyclerView) {
            with(listbinding.list) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS)
            }
        }
        return  listbinding.root*/


        mybinding = FragmentWaterfalltoolbar2Binding.inflate(layoutInflater,container,false)
        imglist = ArrayList()

        (activity as AppCompatActivity?)!!.supportActionBar?.setTitle("ncks")
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(requireContext(), com.example.androidinovation.R.drawable.arrow_back_24))
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mybinding.waterfallToolbar.apply {
        this.recyclerView = mybinding.rvWaterfallToolbarid
         this.initialElevation = Dp(1f).toPx()
            this.finalElevation = Dp(30f).toPx()
//            waterfallToolbar.setFinalElevation(new Dp(30).toPx());

        }



        for (i in 1.. 20)
        {
            imglist.add(MyModel("My Name id ! "))
            imglist.add(MyModel("My Name id 2 "))
            var adpterOneImage = TextViewAdapter(imglist,requireContext())
            mybinding.rvWaterfallToolbarid.adapter= adpterOneImage
        }






        return  mybinding.root
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            WaterfalltoolbarFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}