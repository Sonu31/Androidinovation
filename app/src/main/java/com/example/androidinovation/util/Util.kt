package com.modlueinfotech.allwishesgif.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.TextPaint
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.androidinovation.R
import com.example.androidinovation.util.AppUtils
import java.io.File
import java.io.FileOutputStream


object Util {
    private val GALLERY: Int = 1
    private val CAMERA: Int = 2

    private const val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )





//    fun fullExitScreen(activity: Activity) {
//
////
//
//
//        var dialog= Dialog(activity)
//        val appexitlayout = activity.layoutInflater.inflate(R.layout.exit_dialog, null)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(appexitlayout)
//        val lout = WindowManager.LayoutParams()
//        lout.copyFrom(dialog.getWindow()?.getAttributes())
//        lout.width = WindowManager.LayoutParams.MATCH_PARENT
//        lout.height = WindowManager.LayoutParams.MATCH_PARENT
//        dialog.setCancelable(true)
//        dialog.getWindow()?.setAttributes(lout)
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
//        dialog.getWindow()?.getDecorView()?.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//        dialog.window?.statusBarColor = ContextCompat.getColor(activity,R.color.background_color)
//
//
//
//
//        val title:TextView =  appexitlayout.findViewById(R.id.activitytitle)
//        title.setText(R.string.exit_app)
//
//
//        var backbtn:ImageView = appexitlayout.findViewById(R.id.exitbackid)
//        var cancelbtn:TextView=  appexitlayout.findViewById(R.id.exitcancelbtnid)
//        var exitbtn:TextView = appexitlayout.findViewById(R.id.exitbtnid)
//        var exitadd:LinearLayout = appexitlayout.findViewById<LinearLayout>(R.id.exitscreenadd)
//
//
//        var morebtn:ImageView = appexitlayout.findViewById(R.id.exitmoreappbtnid)
//        var rateusbtn:ImageView = appexitlayout.findViewById(R.id.exitratusbtnid)
//
//
//
//        backbtn.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        cancelbtn.setOnClickListener {view:View?-> dialog.dismiss()  }
//        exitbtn.setOnClickListener { view:View?-> activity.  finishAffinity() }
//
//
//        SmAdds.showNativeAdd(activity,exitadd)
//
//
//        morebtn.setOnClickListener {
//            AppUtils.more(activity)
//
//        }
//
//        rateusbtn.setOnClickListener {
//            AppUtils.rateUs(activity)
//        }
//
//        dialog.show()
//    }



//    fun showDownloadAlert1(activity: Activity,msg1 : String,msg2 : String){
//        val dialog1 = Dialog(activity, R.style.Download_Theme_Dialog)
//        val backgroundDialogBinding = AlertDialogLayoutBinding.inflate(activity.layoutInflater)
//        dialog1.setContentView(backgroundDialogBinding.root)
//        dialog1.apply {
//            show()
//            backgroundDialogBinding.go.setOnClickListener {
//                SmAdds.showFullAd(activity, object : FullAdListener {
//                    override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
//                       activity.startActivity(Intent(activity,Saveditems::class.java))
//                        dismiss()
//                    }
//                })
//            }
//            backgroundDialogBinding.ok.setOnClickListener { dismiss() }
//            backgroundDialogBinding.tvMsg.text = msg1
//            backgroundDialogBinding.msg.text = msg2
//            backgroundDialogBinding.adContainer.let { SmAdds.showNativeAdd(activity,it) }
//        }
//    }


//    fun createTabIcons(context: Context,tabLayout:TabLayout) {
//        var tabOne = LayoutInflater.from(context).inflate(com.modlueinfotech.allwishesgif.R.layout.custom_tab, null) as TextView
//        tabOne.text = "GIF"
//        tabOne.textSize = 12F
//
//        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,com.modlueinfotech.allwishesgif.R.drawable.gif_btn,0,0)
//        tabLayout!!.getTabAt(0)!!.customView = tabOne
//
//        val tabTwo = LayoutInflater.from(context).inflate(com.modlueinfotech.allwishesgif.R.layout.custom_tab, null) as TextView
//        tabTwo.text = "Cards"
//        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,com.modlueinfotech.allwishesgif.R.drawable.cards_btn,0,0)
//        tabTwo.textSize = 12F
//        tabLayout!!.getTabAt(1)!!.customView = tabTwo
//
//
//        val tabThree = LayoutInflater.from(context).inflate(com.modlueinfotech.allwishesgif.R.layout.custom_tab, null) as TextView
//        tabThree.text = "Quotes"
//        tabThree.textSize = 12F
//
//        tabThree.setCompoundDrawablesWithIntrinsicBounds(0,com.modlueinfotech.allwishesgif.R.drawable.quotes_btn,0,0)
//        tabLayout!!.getTabAt(2)!!.customView = tabThree
//
//        val tabfour = LayoutInflater.from(context).inflate(com.modlueinfotech.allwishesgif.R.layout.custom_tab, null) as TextView
//        tabfour.text = "Frames"
//        tabfour.textSize = 12F
//
//        tabfour.setCompoundDrawablesWithIntrinsicBounds(0,com.modlueinfotech.allwishesgif.R.drawable.frams_btn,0,0)
//        tabLayout!!.getTabAt(3)!!.customView = tabfour
//
////        val tabfive = LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as TextView
////        tabfive.text = "Create"
////         tabfive.textSize = 12F
////
////        tabfive.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.create_btn,0,0)
////        tabLayout!!.getTabAt(4)!!.customView = tabfive
//
//
//    }

    fun textColorGradent(view: TextView) {
        val paint: TextPaint = view.paint
        val width: Float = paint.measureText(view.text.toString())
        val shader = LinearGradient(0f, 0f, 0f, view.textSize,Color.parseColor("#D7459F"),Color.parseColor("#FF2929"), Shader.TileMode.CLAMP)
        view.paint.shader = shader
    }

    fun getpicGallery(activity: Activity) {
        val intent = Intent()
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY)
    }

    fun captercamera(activity: Activity) {
        val camera_intent =
            Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Start the activity with camera_intent, and request pic id
        activity.startActivityForResult(camera_intent, CAMERA)
    }

    fun camshow(activity: Activity) {

        if (ContextCompat.checkSelfPermission(
                activity, Manifest.permission.ACCESS_FINE_LOCATION
            ) !== PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.CAMERA
                )
            ) {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CAMERA), 1)
            } else {
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CAMERA), 1)

            }
        }


    }

  //use allwishes
//    fun saveCollection(storefile:String,ob: Any, extension: String, context: Context) {
//
//        com.modlueinfotech.allwishesgif.utils.AppUtils.getInstance().getFile(context, ob)
//        { file ->
//
//            val direct = File(
//                context.getExternalFilesDir(null).toString() + "/$storefile/"
//            )
//            if (!direct.exists()) {
//                direct.mkdirs()
//            }
//            val f = File(direct.absolutePath, "" + System.currentTimeMillis() + extension)
//            file.copyTo(f)
//        }
//    }

//user Allwises
    fun getSaveData(context: Context,getdatastore:String): List<String> {
        val list = ArrayList<String>()
        val file = File(context.getExternalFilesDir(null).toString() + "/$getdatastore")
        if (file.exists()) {
            file.listFiles()?.forEach {
                list.add(it.path)
            }
        }
        return list.reversed()


    }

    //use allwishes
    fun saveQuotesFrames(activity: Activity, view: View, extension: String,storedata:String) {
        val bm: Bitmap? = AppUtils.getInstance().captureScreen(view)
        val file = AppUtils.getInstance().getFile(activity, bm)
        val direct = File(
            activity.getExternalFilesDir(null).toString() + "/$storedata/" + extension
        )
        if (!direct.exists()) {
            direct.mkdirs()
        }
        val f = File(direct.absolutePath, "" + System.currentTimeMillis() + extension)
        file?.copyTo(f)

        Toast.makeText(activity, "Saved", Toast.LENGTH_SHORT).show()
    }

    fun shareGIF(ob: Any, context: Context) {
        getFile(context, ob, object : DownloadFileListener {
            override fun onDownloadComplete(file: File?) {
                val tempFile = File(context.externalCacheDir, "share.gif")
                file?.let {
                    val f: File = file.copyTo(tempFile, true, DEFAULT_BUFFER_SIZE)
                    val uri = getProviderUri(context, f)
                    println("url" + uri)
                    shareImage(context, uri)
                }
            }
        })
    }


    fun shareGif(context: Context, fileName: String) {
        val baseDir: String =
            Environment.getExternalStorageDirectory().toString() + "/YourFolderName/"
        val file = File("$baseDir/$fileName.gif")
        val intent = Intent(Intent.ACTION_SEND)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        val dataString = "MY_DATA_STRING"
        val uri = FileProvider.getUriForFile(
            context,
            context.applicationContext.packageName + ".provider",
            file
        )
        intent.setDataAndType(uri, dataString)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.type = "image/gif"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        context.startActivity(Intent.createChooser(intent, "Share Emoji"))
    }

    fun shareImage(context: Context, uri: Uri?) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        var sAux = """
               Download ${context.getString(R.string.app_name)}
               
               """.trimIndent()
        sAux = """
               ${sAux}https://play.google.com/store/apps/details?id=${context.packageName}
               
               """.trimIndent()
        intent.putExtra(Intent.EXTRA_TEXT, sAux)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        intent.type = "image/png"
        context.startActivity(Intent.createChooser(intent, "Share image via"))
    }



    fun getFile(ctx: Context?, ob: Any?, listener: DownloadFileListener) {
        Glide.with(ctx!!)
            .downloadOnly()
            .load(ob)
            .listener(object : RequestListener<File?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any,
                    target: com.bumptech.glide.request.target.Target<File?>,
                    isFirstResource: Boolean
                ): Boolean {
                    listener.onDownloadComplete(null)
                    return false
                }

                override fun onResourceReady(
                    resource: File?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<File?>?,
                    dataSource: com.bumptech.glide.load.DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    listener.onDownloadComplete(resource)
                    return false
                }


            })
            .submit(
                com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
                com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
            )
    }

    interface DownloadFileListener {
        fun onDownloadComplete(file: File?)
    }

    fun getProviderUri(ctx: Context?, file: File): Uri {
        return FileProvider.getUriForFile(
            ctx!!, ctx.applicationContext.packageName + ".provider",
            file.absoluteFile
        )
    }


    // Share View
    fun OnClickShare(view: View, context: Context) {
        val bitmap = getBitmapFromView(view)
        try {
            val file = File(context.externalCacheDir, "logicchip.gif")
            val fOut = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
            fOut.flush()
            fOut.close()
            file.setReadable(true, false)
            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.provider",
                file
            )
            val intent = Intent(Intent.ACTION_SEND)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.putExtra(
                Intent.EXTRA_TEXT,
                """
                Please Download this application from https://play.google.com/store/apps/details?id=${context.packageName}
                """
                    .trimIndent()
            )
            intent.type = "image/gif"
            context.startActivity(intent)
//                        AdUtils.openOnAdDismiss(intent);
//            AdUtils.showFullAd(getApplicationContext(),intent , getResources().getString(R.string.fb_full_adsUnitID),getResources().getString(R.string.full_screen));
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getBitmapFromView(view: View): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas)
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE)
        }
        view.draw(canvas)
        return returnedBitmap
    }

    fun deleteCollection(item: String, context: Context): Boolean {
        val file = File(item)

        if (file.exists()) {
            file.delete()
        } else {
            Toast.makeText(context, "file does not exist", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun shareGIFS(ob: Any, context: Context) {
        getFile(context, ob, object : DownloadFileListener {
            override fun onDownloadComplete(file: File?) {
                val tempFile = File(context.externalCacheDir, "share.gif")
                file?.let {
                    val f: File = file.copyTo(tempFile, true, DEFAULT_BUFFER_SIZE)
                    val uri = getProviderUri(context, f)
                    println("url" + uri)
                    shareImage(context, uri)
                }
            }
        })
    }
    fun changeFragment1(nav: NavController,fragmentId: Int,activity: Activity){
        nav.navigate(fragmentId)
    }

    fun changeFragmentWithPosition(nav: NavController, fragmentId :Int, activity: Activity, bundle: Bundle){
        nav.navigate(fragmentId, bundle)

//        SmAds.showFullAd(activity, object : FullAdListener {
//            override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
//
//            }
//        })
    }

    fun changeFragmentWithPosition2(nav: NavController, fragmentId :Int, activity: Activity){
        nav.navigate(fragmentId)

//        SmAds.showFullAd(activity, object : FullAdListener {
//            override fun onComplete(isAdDisplay: Boolean, adNetwork: String) {
//
//            }
//        })
    }



    fun openUrl(context: Context, url: String?) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        } catch (e: java.lang.Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }


}