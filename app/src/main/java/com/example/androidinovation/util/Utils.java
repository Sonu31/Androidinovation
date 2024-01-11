package com.example.androidinovation.util;


import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;


public class Utils {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    public static void setAsStatus(Context context, File file, String setType) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setType(setType);
        intent.setPackage("com.whatsapp");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
        }
    }

    static public void shareImagenew(String url, Context context) {
        new ShareTask(context).execute(url);
    }

    static public void SetStatusImagenew(String url, Context context) {
        new SetStatus(context).execute(url);
    }

    static public void more(Context context) {
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            context.startActivity(goToMarket);

        } catch (ActivityNotFoundException e) {

        }
    }

    public static Intent shareApp(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
//            String sAux = "Download\n" + context.getResources().getString(R.string.app_name) + "\n";
//            sAux = sAux + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n";
//            i.putExtra(Intent.EXTRA_TEXT, sAux);
            return Intent.createChooser(i, "choose one");
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public static Intent openPrivacyPolicy(Context context) {
        try {
//            return new Intent(Intent.ACTION_VIEW, Uri.parse(context.getResources().getString(R.string.pp_url)));
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public static Intent openWebUrl(Context context, String url) {
        try {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
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

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
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
                        .submit(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
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

            //   File sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            File sd = Environment.getExternalStorageDirectory();
            File destination = null;
            //     destination = new File(sd.getAbsolutePath() + "/Pictures/" + context.getString(R.string.app_name) + "/GIF/" + Name);

//            if (!destination.exists()) {
//                destination.mkdirs();
//            }
//            Toast.makeText(context, context.getResources().getString(R.string.gifSaved), Toast.LENGTH_SHORT).show();


            //    if (ImagePreviewActivity.flag == MainActivity.SERVERGIF) {
//                destination = new File(sd.getAbsolutePath() + "/Pictures/" + context.getString(R.string.app_name) + "/GIF/" + Name);
//                Toast.makeText(context, context.getResources().getString(R.string.gifSaved), Toast.LENGTH_SHORT).show();
            //    } else {
//                destination = new File(sd.getAbsolutePath() + "/Pictures/" + context.getString(R.string.app_name) + "/IMG/" + Name);
//                Toast.makeText(context, context.getResources().getString(R.string.imageSaved), Toast.LENGTH_SHORT).show();
            //   }

            copyFile(result, destination);
            refreshMedia(context, destination);
        }
    }

    public static void refreshMedia(Context context, File file) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//            File f1 = new File("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
//            Uri contentUri = Uri.fromFile(f1);
//            mediaScanIntent.setData(contentUri);
//            context.sendBroadcast(mediaScanIntent);
//        } else {
//            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
//        }
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
    }

    public static class ShareTask extends AsyncTask<String, Void, File> {
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
                        .submit(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
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
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Shared image");
            //intent.putExtra(Intent.EXTRA_TEXT, "This Image/GIF is shared with you by " + context.getResources().getString(R.string.app_name) + ".Please Download this application from " + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n");
            intent.putExtra(Intent.EXTRA_STREAM, result);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(Intent.createChooser(intent, "Select"));
        }
    }

    static class SetStatus extends AsyncTask<String, Void, File> {
        public Context context;

        public SetStatus(Context context) {
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
                        .submit(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
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
            setStatus(uri); // startActivity probably needs UI thread
        }

        private void setStatus(Uri result) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setType("image/jpeg");
            intent.setPackage("com.whatsapp");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Shared image");
//            intent.putExtra(Intent.EXTRA_TEXT, context.getResources().getString(R.string.app_name));
            intent.putExtra(Intent.EXTRA_STREAM, result);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(context, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }


}






