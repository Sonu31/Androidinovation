package com.examp.goodmorning.activity

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.androidinovation.R

class SecondTabAdapter(supportFragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(supportFragmentManager) {
   private lateinit var context :Context
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    private val ssd= arrayOf(R.drawable.tabselectergif ,R.drawable.selectedimageicon,R.drawable.selectedquotesicon)

     fun contexs( contextdd: Context)
     {
         context = contextdd
     }

    override fun getItem(position: Int): Fragment {
        // return a particular fragment page
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        // return the number of tabs
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        // return title of the tab
        var ddrawable: Drawable
        ddrawable = ContextCompat.getDrawable(context,ssd[position])!!
        ddrawable.setBounds(0,0,ddrawable.intrinsicWidth,ddrawable.intrinsicHeight)

        var spannable=SpannableString( " "+mFragmentTitleList.get(position))

        var imageSpan = ImageSpan(ddrawable,ImageSpan.ALIGN_BOTTOM)
        spannable.setSpan(imageSpan,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE )
        return spannable
    }

    fun addFragment(fragment: Fragment, title: String) {
        // add each fragment and its title to the array list
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)

    }

}