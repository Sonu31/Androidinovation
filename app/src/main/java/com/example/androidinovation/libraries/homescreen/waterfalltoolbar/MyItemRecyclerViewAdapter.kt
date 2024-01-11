package com.example.androidinovation.libraries.homescreen.waterfalltoolbar

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidinovation.R

import com.example.androidinovation.libraries.homescreen.waterfalltoolbar.placeholder.PlaceholderContent.PlaceholderItem
import com.example.androidinovation.databinding.FragmentWaterfalltoolbarBinding


class MyItemRecyclerViewAdapter(private val values: List<PlaceholderItem>) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( FragmentWaterfalltoolbarBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentWaterfalltoolbarBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}