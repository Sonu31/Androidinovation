package com.example.androidinovation.ListType.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.androidinovation.ListType.adapter.ListViewAdapter
import com.example.androidinovation.R
import com.example.androidinovation.databinding.ListviewDilogBinding

class ListViewFragment: DialogFragment() {

    private val namelist =arrayOf("SONU", "JAVA", "Koltin", "JavaScript", "NotJS", "ROHHHIT", "RALL", "MANGO","SONU", "JAVA", "Koltin", "JavaScript", "NotJS", "ROHHHIT", "RALL", "MANGO")

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String): ListViewFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = ListViewFragment()
            fragment.arguments = args
            return fragment
        }

    }



    lateinit var binding:ListviewDilogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListviewDilogBinding.inflate(layoutInflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCancelable(isCancelable)

        var listViewAdapter = ListViewAdapter(context, R.layout.spinner_row,namelist)
        println("skdls"+namelist)
        binding.lv.adapter = listViewAdapter

        binding.lv.onItemClickListener= AdapterView.OnItemClickListener{parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            Toast.makeText(requireContext(), ""+position, Toast.LENGTH_SHORT).show()
        }
    }
}