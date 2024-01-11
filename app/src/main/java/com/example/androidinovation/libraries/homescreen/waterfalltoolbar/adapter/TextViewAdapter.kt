package com.examp.goodmorning.Frame.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidinovation.R
import com.example.androidinovation.libraries.homescreen.waterfalltoolbar.adapter.MyModel

class TextViewAdapter(var list: ArrayList<MyModel>, var context: Context
) :
    RecyclerView.Adapter<TextViewAdapter.ViewHolder>() {

    var lastposition: Int = -1
    var animaiton: Animation? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewid.text = list[position].mytext
//        holder.cardview.startAnimation(AnimationUtils.loadAnimation(holder.imageViews.context,R.anim.left_to_right ))

//        setanimation(holder.itemView, position)
    }

    //First Way Size count
//    override fun getItemCount(): Int {
//        return  list.size
//    }

    //Second way  size connt
    override fun getItemCount(): Int = list.size

    class ViewHolder(itemview: View) :
        RecyclerView.ViewHolder(itemview) {
        var textViewid: TextView = itemView.findViewById(R.id.textview_id1)
//        var cardview:CardView= itemView.findViewById(R.id.cardlayotu)
    }


/*
    fun setanimation(viewanimaiton: View, position: Int) {
        if (position > lastposition)


            animaiton = AnimationUtils.loadAnimation(context, R.anim.recyclerview_anim2)
        viewanimaiton.startAnimation(animaiton)
        lastposition = position


    }
*/


}