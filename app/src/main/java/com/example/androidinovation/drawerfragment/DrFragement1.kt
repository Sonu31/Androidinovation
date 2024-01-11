package com.example.androidinovation.drawerfragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.text.Html
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidinovation.R
import com.example.androidinovation.databinding.CustomDilogdraweritemBinding
import com.example.androidinovation.databinding.FragmentDrFragement1Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.combine

class DrFragement1 : Fragment() {

    private  lateinit var binding: FragmentDrFragement1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     binding = FragmentDrFragement1Binding.inflate(layoutInflater,container,false)
        buttonClick()








        return binding.root
    }

    private fun buttonClick() {

        binding.leftRightbtn1.setOnClickListener {
            custonDilogLeftRight()
        }

        binding.upDownbtn2.setOnClickListener {
            custonDilogUpDown()
        }

        binding.fadeinFadeoutbtn3.setOnClickListener {
            custonDilogFadeInFadout()
        }

        binding.normalAppearbtn4.setOnClickListener {
            normalDilog()
        }
        binding.comeleftGorightbtn5.setOnClickListener {
            custonComeLeftGoRight()
        }
        binding.alertdilog1.setOnClickListener {
            meterialAlertDialog()
        }
        binding.alertdilog2.setOnClickListener {
            alertDilog()
        }

        binding.alertdilog3.setOnClickListener {
            alertDilog2()
        }



    }

    private fun custonDilogUpDown() {

        var diloglayoutBinding=CustomDilogdraweritemBinding.inflate(layoutInflater)
       var customdilog = Dialog(requireContext(),R.style.coustomdialog)
        customdilog.setContentView(diloglayoutBinding.root)
        customdilog.setCancelable(true)
        customdilog?.getWindow()?.getAttributes()?.windowAnimations = R.style.Up_Down_animaiton;
        customdilog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customdilog?.window?.setGravity(Gravity.CENTER)

        customdilog.show()


    }

    private fun custonDilogLeftRight() {

        var diloglayoutBinding=CustomDilogdraweritemBinding.inflate(layoutInflater)
        var customdilog = Dialog(requireContext(),R.style.coustomdialog)
        customdilog.setContentView(diloglayoutBinding.root)
        customdilog.setCancelable(true)
        customdilog?.getWindow()?.getAttributes()?.windowAnimations = R.style.LEFT_RIGHT_Animaiton;
        customdilog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customdilog?.window?.setGravity(Gravity.CENTER)

        customdilog.show()


    }

    private fun custonDilogFadeInFadout() {

        var diloglayoutBinding=CustomDilogdraweritemBinding.inflate(layoutInflater)
        var customdilog = Dialog(requireContext(),R.style.coustomdialog)
        customdilog.setContentView(diloglayoutBinding.root)
        customdilog.setCancelable(true)
        customdilog?.getWindow()?.getAttributes()?.windowAnimations = R.style.FADEIn_FADEOUT_Animaiton;
        customdilog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customdilog?.window?.setGravity(Gravity.CENTER)

        customdilog.show()


    }

    private fun normalDilog() {

        var diloglayoutBinding=CustomDilogdraweritemBinding.inflate(layoutInflater)
        var customdilog = Dialog(requireContext(),R.style.coustomdialog)
        customdilog.setContentView(diloglayoutBinding.root)
        customdilog.setCancelable(true)
        customdilog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customdilog?.window?.setGravity(Gravity.CENTER)

        customdilog.show()


    }

    private fun custonComeLeftGoRight()  {

        var diloglayoutBinding=CustomDilogdraweritemBinding.inflate(layoutInflater)
        var customdilog = Dialog(requireContext(),R.style.coustomdialog)
        customdilog.setContentView(diloglayoutBinding.root)
        customdilog.setCancelable(true)
        customdilog?.getWindow()?.getAttributes()?.windowAnimations = R.style.COMELEFT_GORIGHT;
        customdilog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customdilog?.window?.setGravity(Gravity.CENTER)

        customdilog.show()


    }

    private fun meterialAlertDialog() {
        MaterialAlertDialogBuilder(requireContext(),com.google.android.material.R.style.MaterialAlertDialog_Material3)
            .setTitle("Notification Permission")
            .setMessage("Notification permission is required, Please allow notification permission from setting")
            .setPositiveButton("Ok") { dialogInterface, which ->

            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun alertDilog()  {

        var builder:AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Material Style Dialog");
        builder.setCancelable(true);
        builder.setMessage(getResources().getString(R.string.dilogmessage));
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private fun alertDilog2(){
        val builder = android.app.AlertDialog.Builder(requireContext(), R.style.AlertDialog)
        builder.setTitle(Html.fromHtml("<font color='#100F0F'>Do you want to Remove?</font>"))

        builder.setPositiveButton(Html.fromHtml("<font color='#100F0F'>Yes</font>"))
        { dialogInterface, which ->

            Toast.makeText(requireContext(), "SONU KUMAR", Toast.LENGTH_SHORT).show()

        }

        builder.setNegativeButton(Html.fromHtml("<font color='#100F0F'>No</font>"))
        { dialogInterface, which ->

            Toast.makeText(requireContext(), "No", Toast.LENGTH_SHORT).show()


        }

        val alertDialog: android.app.AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()





    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Dilog"
        super.onViewCreated(view, savedInstanceState)
    }
}