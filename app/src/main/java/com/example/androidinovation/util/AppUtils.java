package com.example.androidinovation.util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class AppUtils {
    final String READ = Manifest.permission.READ_EXTERNAL_STORAGE;
    final String WRITE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static AppUtils appUtils;

    private AppUtils() {

    }










    public static AppUtils getInstance() {
        if (appUtils == null) {
         ///   System.out.println("KLOP"+appUtils);
            appUtils = new AppUtils();
        }
        return appUtils;
    }


// AppUtils.getInstance().rateUs(this)

    public static void rateUs(Context context) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("" + context.getPackageName())));
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



// AppUtils.getInstance().moreApps(this)  usr ite
    public void moreApps(Context context) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GIF+%26+Frames+Collection+Apps")));
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void setUpToolbar(final AppCompatActivity activity, String title, boolean isBackEnable) {
        if (title != null && !title.isEmpty()) {
            activity.setTitle(title);
        }
       // Toolbar toolbar = activity.findViewById(R.id.toolbar);
     //   activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(isBackEnable);
     //   toolbar.setNavigationOnClickListener(v -> activity.onBackPressed());
    }


    public void getFile1(Context ctx, Object object, DownloadFileListener listener) {
        Glide.with(ctx)
                .downloadOnly()
                .load(object)
                .listener(new RequestListener<File>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {

                        listener.onDownloadComplete(null);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
                        listener.onDownloadComplete(resource);
                        return false;
                    }

                })
                .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }



    public void getFile2(Context ctx, Object object, DownloadFileListener listener) {
        Glide.with(ctx)
                .downloadOnly()
                .load(object)
                .listener(new RequestListener<File>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
                        listener.onDownloadComplete(null);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
                        listener.onDownloadComplete(resource);
                        return false;
                    }

                })
                .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }



//    public static void  shareApp(Context context) {
//        try {
//            Intent i = new Intent(Intent.ACTION_SEND);
//            i.setType("text/plain");
//            String sAux = "Download\n" + context.getResources().getString(R.id.share_app) + "\n";
//            sAux = sAux + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n";
//            i.putExtra(Intent.EXTRA_TEXT, sAux);
//            context.startActivity(Intent.createChooser(i, "choose one"));
//        } catch (Exception e) {
//            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }

    public static void openUrl(Context context, String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
       try {
          Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
          context.startActivity(intent);
      } catch (Exception e) {
       Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    }



    public void openActivity(Activity ctx, Intent intent) {

//        AdsHandler.INSTANCE.showInterstitialAds(ctx, new FullAdListener() {
//            @Override
//            public void onComplete(boolean isAdDisplay, String which) {
//                ctx.startActivity(intent);
//            }
//        });
    }

    public void showToast(Context ctx, String str) {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
    }

//    public void doStringRequest(String url, VolleyCallback callback) {
//        final String tag_string_req = "volley_req";
//        StringRequest strReq = new StringRequest(Request.Method.GET, url, callback::onSuccessResponse, error -> callback.onVolleyError(getVolleyError(error)));
//        // Adding request to request queue
//
//        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
//    }
//
//    public void cancelRequest() {
//        final String tag_string_req = "volley_req";
//        AppController.getInstance().cancelPendingRequests(tag_string_req);
//    }

//    private String getVolleyError(VolleyError volleyError) {
//        String msg = volleyError.getMessage();
//        if (volleyError instanceof NetworkError) {
//            msg = "Cannot connect to Internet...Please check your connection!";
//        } else if (volleyError instanceof ServerError) {
//            msg = "The server could not be found. Please try again after some time!!";
//        } else if (volleyError instanceof AuthFailureError) {
//            msg = "Cannot connect to Internet...Please check your connection!";
//        } else if (volleyError instanceof ParseError) {
//            msg = "Parsing error! Please try again after some time!!";
//        } else if (volleyError instanceof NoConnectionError) {
//            msg = "Cannot connect to Internet...Please check your connection!";
//        } else if (volleyError instanceof TimeoutError) {
//            msg = "Connection TimeOut! Please check your internet connection.";
//        }
//        return msg;
//    }

    public void setGIFs(Context ctx, String url, ImageView iv) {
        Glide.with(ctx).asGif().load(url).centerCrop().into(iv);
    }

    public void setImage(Context ctx, String url, ImageView iv) {
        Glide.with(ctx).load(url).centerCrop().into(iv);
    }

//    public void shareImage(Context ctx, File file) {
//        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + ctx.getPackageName());
//        shareIntent.setType("image/gif");
//        Uri uri = FileProvider.getUriForFile(ctx, BuildConfig.APPLICATION_ID + ".provider", file);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
//        ctx.startActivity(Intent.createChooser(shareIntent, "Send to"));
//    }

    public void shareImage(Context ctx, Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + ctx.getPackageName());
        shareIntent.setType("image/gif");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        ctx.startActivity(Intent.createChooser(shareIntent, "Send to"));
    }


    public File getFileFromGlide(Context ctx, String str) {
        try {
            return Glide.with(ctx).asFile().load(str).submit().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public Uri loadView(View layout, Context context) {
//        Uri uri = null;
//        Bitmap bitmap = getBitMap(layout);
//        if (bitmap == null)
//            return null;
//        layout.setDrawingCacheEnabled(true);
//        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + "/GifApp/";
//
//        File imageFile = new File(path);
//        if (!imageFile.exists())
//            imageFile.mkdir();
//        try {
//            String filePath = "icon.jpg";
//            File file = new File(imageFile, filePath);
//            layout.setDrawingCacheEnabled(false);
//            FileOutputStream outputStream = new FileOutputStream(file);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();
//            File f = new File(file.getAbsolutePath());
//            uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", f);
//
//        } catch (FileNotFoundException e) {
//            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//        return uri;
//    }

    public Bitmap getBitMap(View view) {
        if (view == null)
            return null;
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable = view.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);

        return bitmap;
    }

    public Bitmap captureScreen(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache());
        Canvas c = new Canvas(bmp);
        c.drawColor(Color.WHITE);
        view.draw(c);
        view.setDrawingCacheEnabled(false);
        return bmp;
    }

    public File saveImage(Context ctx, Bitmap finalBitmap) {
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File(root + "/" );//+ ctx.getString(R.string.app_name)
        if (!myDir.exists())
            myDir.mkdirs();
        File file = new File(myDir, "quotes" + UUID.randomUUID() + ".png");
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Anshu " + e.getMessage());
        }
        MediaScannerConnection.scanFile(ctx, new String[]{file.toString()}, null,
                (path, uri) -> {
                    Log.i("ExternalStorage", "Scanned " + path + ":");
                    Log.i("ExternalStorage", "-> uri=" + uri);
                });
        return file;
//        return getUri(ctx, file.getAbsoluteFile());
    }

//    public Uri getUri(Context ctx, File file) {
//        return FileProvider.getUriForFile(ctx, BuildConfig.APPLICATION_ID + ".provider", file.getAbsoluteFile());
//    }

    public File createFile(File cacheFile, String fileExt) {
        File newfile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/file" + fileExt);
        if (newfile.exists()) {
            newfile.delete();
        }
        try {
            newfile.createNewFile();
            InputStream in = new FileInputStream(cacheFile);
            OutputStream out = new FileOutputStream(newfile);
            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            return newfile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //    public void shareImageToWhatsapp(Context ctx, Uri uri) {
//        try {
//            Intent intent = new Intent(Intent.ACTION_SEND);
//            intent.setPackage("com.whatsapp");
//            intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + ctx.getPackageName());
//            intent.setType("image/*");
//            intent.putExtra(Intent.EXTRA_STREAM, uri);
//            ctx.startActivity(Intent.createChooser(intent, "send..."));
//        } catch (Exception e) {
//            showToast(ctx, "Something went wrong or WhatsApp not installed !");
//        }
//    }
    public void shareImagenew(String url, Context context) {
        new ShareTask(context).execute(url);
    }

    static public void SaveImage(String url, Context context) {
        new SaveTask(context).execute(url);
    }

    static class SaveTask extends AsyncTask<String, Void, File> {
        public Context context;
        String url;

        public SaveTask(Context context) {
            this.context = context;
        }

        @Override
        protected File doInBackground(String... params) {
            url = params[0]; // should be easy to extend to share multiple images at once
            try {

                return Glide
                        .with(context)
                        .downloadOnly()
                        .load(url)
                        .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get()// needs to be called on background thread
                        ;
            } catch (Exception ex) {

                return null;
            }
        }

        @Override
        protected void onPostExecute(File result) {
            if (result == null) {
                return;
            }
            String Name = url.substring(0, url.lastIndexOf("/"));
            Name = Name.substring(Name.lastIndexOf("/") + 1);

            File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File destination= null;
//            if (PreviewActivity.Companion.getType() == 2) {
//            destination = new File(sd.getAbsolutePath() + "/Pictures/" + context.getString(R.string.app_name) + "/GIF/" + Name);
            if (!destination.exists()) {
                destination.mkdirs();
            }
//            Toast.makeText(context, context.getResources().getString(R.string.gifSaved), Toast.LENGTH_SHORT).show();
//            } else {
//                destination = new File(sd.getAbsolutePath() + "/Pictures/" + context.getString(R.string.app_name) + "/IMG/" + Name);
//                Toast.makeText(context, context.getResources().getString(R.string.imageSaved), Toast.LENGTH_SHORT).show();
//            }

            copyFile(result, destination);
            refreshMedia(context, destination);
        }
    }

    public static void refreshMedia(Context context, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            File f1 = new File("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
            Uri contentUri = Uri.fromFile(f1);
            mediaScanIntent.setData(contentUri);
            context.sendBroadcast(mediaScanIntent);
        } else {
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        }
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
    }

    static class ShareTask extends AsyncTask<String, Void, File> {
        public Context context;

        public ShareTask(Context context) {
            this.context = context;
        }

        @Override
        protected File doInBackground(String... params) {
            String url = params[0]; // should be easy to extend to share multiple images at once
            try {

                return Glide
                        .with(context)
                        .downloadOnly()
                        .load(url)
                        .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get()// needs to be called on background thread
                        ;
            } catch (Exception ex) {

                return null;
            }
        }

        @Override
        protected void onPostExecute(File result) {
            if (result == null) {
                return;
            }

            File des = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + ".gif");

            copyFile(result, des);
            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", des);
            share(uri); // startActivity probably needs UI thread
        }

        private void share(Uri result) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setType("image/jpeg");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Shared image");
            intent.putExtra(Intent.EXTRA_TEXT, ".Please Download this application from " + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n");
            intent.putExtra(Intent.EXTRA_STREAM, result);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(intent);

        }
    }

    public static void copyFile(File sourceFile, File destFile) {
        try {

            if (!destFile.getParentFile().exists())
                destFile.getParentFile().mkdirs();


            if (!destFile.exists()) {

                destFile.createNewFile();
            }

            FileChannel source = null;
            FileChannel destination = null;

            try {

                source = new FileInputStream(sourceFile).getChannel();
                destination = new FileOutputStream(destFile).getChannel();
                destination.transferFrom(source, 0, source.size());

            } finally {
                if (source != null) {
                    source.close();
                }
                if (destination != null) {
                    destination.close();
                }

            }
        } catch (Exception e) {

        }
    }

    public void shareToWhatsApp(Context ctx, Uri uri) {
        String type = "image/*";
        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);
        // Set the MIME type
        share.setType(type);
        // Create the URI from the media
        share.setPackage("com.whatsapp");
        share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + ctx.getPackageName());
        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);
        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        PackageManager packageManager = ctx.getPackageManager();
        if (share.resolveActivity(packageManager) != null) {
            ctx.startActivity(share);
            ctx.startActivity(Intent.createChooser(share, "Share to"));
        } else {
            showToast(ctx, "Something went wrong or WhatsApp not installed !");
        }
    }

    public void showAlert(Activity activity, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Alert !")
                .setMessage(str)
                .setPositiveButton("Exit", (dialog, which) -> {
                    activity.finish();
                })
                .setCancelable(false)
                .show();
    }

    public boolean isWriteStoragePermissionGranted(Activity context) {
        return isStoragePermissionGranted(context, new String[]{READ, WRITE});
    }

    private boolean isStoragePermissionGranted(Activity activity, String[] permissionType) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity.checkSelfPermission(READ) == PackageManager.PERMISSION_GRANTED && activity.checkSelfPermission(WRITE) == PackageManager.PERMISSION_GRANTED) {
//                Log.v(TAG,"Permission is granted");
                return true;
            } else {
//                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(activity, permissionType, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
//            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

//    public void showDialogForManualPermission(Activity context) {
//        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
//        builder.setTitle("Need Storage Permission");
//        builder.setMessage("You have previously declined this permission.\n" +
//                "You must approve this permission in \"Permissions\" in the app settings on your device.");
//        builder.setCancelable(false);
//        builder.setPositiveButton("Settings", (dialog, which) -> {
//            dialog.cancel();
//            context.startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
//                    Uri.parse("package:" + BuildConfig.APPLICATION_ID)));
//            context.finish();
//        });
//        builder.setNegativeButton("Exit", (dialog, which) -> {
//            dialog.cancel();
//            context.finish();
//        });
//        builder.show();
//    }

//    public void dorequest(String url, VolleyCallback callback) {
//        AppUtils.getInstance().doStringRequest(url, callback);
//    }

    //    public void fullExitScreen(Activity activity) {
//        Dialog dialog = new Dialog(activity, R.style.DialogTheme);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.exit_dialog);
//        SMUtils.INSTANCE.showNativeAd(activity,dialog.findViewById(R.id.smNativeAdContainer));
//        dialog.findViewById(R.id.canBtn).setOnClickListener(view -> {
//            dialog.dismiss();
//        });
//        dialog.findViewById(R.id.yesBtn).setOnClickListener(view -> {
//            activity.finish();
//        });
//        dialog.findViewById(R.id.rate_us).setOnClickListener(view -> {
//            rateUs(activity);
//        });
//        dialog.findViewById(R.id.more).setOnClickListener(view -> {
//            openUrl(activity, activity.getResources().getString(R.string.moreapps_url));
//        });
//        dialog.show();
//    }
    public File getFile(Context ctx, Bitmap bmp) {
        try {
            File file = new File(ctx.getExternalCacheDir(), "share.png");
            FileOutputStream fOut = fOut = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            return file;
        } catch (IOException e) {
            return null;
        }
    }
//    public void getFile1(Context ctx, Object object, DownloadFileListener listener) {
//        Glide.with(ctx)
//                .downloadOnly()
//                .load(object)
//                .listener(new RequestListener<File>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
//                        listener.onDownloadComplete(null);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
//                        listener.onDownloadComplete(resource);
//                        return false;
//                    }
//
//                })
//                .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
//    }


}
