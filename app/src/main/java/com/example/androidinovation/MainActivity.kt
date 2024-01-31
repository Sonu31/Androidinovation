package com.example.androidinovation

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.TextPaint
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.androidinovation.databinding.ActivityMainBinding
import com.example.androidinovation.databinding.FragmentExitBinding
import com.example.androidinovation.drawerfragment.DrFragment4
import com.example.androidinovation.util.ApnaUtil
import com.google.android.material.navigation.NavigationView
import com.modlueinfotech.allwishesgif.utils.Util

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener  {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle

    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBar.includedToolBar.toolbar)
        supportActionBar?.title = "MainActivity"
        supportActionBar?.setDisplayShowTitleEnabled(true)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mynav_view) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
//        hideToolbar()


        val navView: NavigationView = findViewById(R.id.nav_view)
//        val vr = navView.findViewById<TextView>(R.id.tv_vr)

        setupToolbar()




    //        getSupportActionBar()?.hide();  //this code used to hide toolbar





    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        if (destination.id == R.id.homefragment){
            Toast.makeText(this,"home fragment",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"not home fragment",Toast.LENGTH_SHORT).show()
        }
    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)){
//            true
//        }
//        return super.onOptionsItemSelected(item)
//    }


//    fun replacefragment( fragment:Fragment){
//        var fragmentManager :FragmentManager = supportFragmentManager
//        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentlayout,fragment)
//        fragmentTransaction.commit()
//
//    }

//    private fun hideToolbar() {
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            when (destination.id) {
//                R.id.homefragment -> binding.toolbarid.visibility = View.GONE
//                else -> binding.toolbarid.visibility = View.VISIBLE
//            }
//        }
//    }


    private fun setupToolbar() {
        binding.appBar.includedToolBar.toolbar.setNavigationOnClickListener {
            val navController = findNavController(R.id.mynav_view)
            val destination = navController.currentDestination
            if (destination?.id == R.id.homefragment){
                binding.drawerLayout.openDrawer(GravityCompat.START)
            } else{
                navController.popBackStack()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun exitDialog(){
        val dialog1 = Dialog(this, R.style.DialogTheme)
        val exitDialogBinding = FragmentExitBinding.inflate(layoutInflater)
        dialog1.setContentView(exitDialogBinding.root)
        dialog1.show()


        exitDialogBinding.tvCancel.setOnClickListener {
            dialog1.dismiss()
        }
        exitDialogBinding.tvYes.setOnClickListener {
            finishAffinity()
        }
    }


    override fun onBackPressed(){
        val navController = findNavController(R.id.mynav_view)
        val destination = navController.currentDestination

        if (destination?.id == R.id.homefragment){
            exitDialog()

        }
        navController.popBackStack()

    }

    override fun onResume() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homefragment -> binding.appBar.includedToolBar.toolbar.setNavigationIcon(R.drawable.baseline_view_headline_24)
                else ->binding.appBar.includedToolBar.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
            }
        }
        super.onResume()
    }
    fun onclickItem1(v: View){
        Util.changeFragmentWithPosition2(navController,R.id.action_homefragment_to_drFragement1,this)

       ApnaUtil.textColorGradent(binding.drawerItem.itme1id,"#8B7DF6","#D7459F")
        binding.drawerLayout.closeDrawer(Gravity.LEFT)
    }
    fun onclickItem2(v: View){
        Util.changeFragmentWithPosition2(navController,R.id.action_homefragment_to_drFragment2,this)
        ApnaUtil.textColorGradent(binding.drawerItem.item2id,"#D7459F","#FF2929")
        binding.drawerLayout.closeDrawer(Gravity.LEFT)
    }

    fun onclickItem3(v: View){
        ApnaUtil.textColorGradent(binding.drawerItem.item3id,"#D7459F","#14A46F")
        Util.changeFragmentWithPosition2(navController,R.id.action_homefragment_to_drFragment3,this)
        binding.drawerLayout.closeDrawer(Gravity.LEFT)
    }

    fun onclickItem4(v: View){
        ApnaUtil.textColorGradent(binding.drawerItem.item4id,"#27A4FF","#0055D6")
    startActivity(Intent(this@MainActivity,DrFragment4::class.java))
    }

    fun onclickItem5(v: View){
        ApnaUtil.textColorGradent(binding.drawerItem.item5id,"#FF5912","#D600C0")
    }



}





