package com.tencent.mm.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class CopyFileToData {
	final static String TARGET_BASE_PATH = "/sdcard/Android/data/";
    public Context context;
	

	public void copyFilesToSdCard(Context context) {
	    copyFileOrDir(context , ""); // copy all files in assets folder in my project
	}

	public void copyFileOrDir(Context context , String path) {
	    AssetManager assetManager = context.getApplicationContext().getAssets();
	    String assets[] = null;
	    try {
	        Log.i("tag", "copyFileOrDir() "+path);
	        assets = assetManager.list(path);
	        if (assets.length == 0) {
	            copyFile(context , path);
	        } else {
	            String fullPath =  TARGET_BASE_PATH + path;
	            Log.i("tag", "path="+fullPath);
	            File dir = new File(fullPath);
	            if (!dir.exists() && !path.startsWith("images") && !path.startsWith("sounds") && !path.startsWith("webkit"))
	                if (!dir.mkdirs())
	                    Log.i("tag", "could not create dir "+fullPath);
	            for (int i = 0; i < assets.length; ++i) {
	                String p;
	                if (path.equals(""))
	                    p = "";
	                else 
	                    p = path + "/";

	                if (!path.startsWith("images") && !path.startsWith("sounds") && !path.startsWith("webkit"))
	                    copyFileOrDir(context , p + assets[i]);
	            }
	        }
	    } catch (IOException ex) {
	        Log.e("tag", "I/O Exception", ex);
	    }
	}

	public void copyFile(Context context , String filename) {
	    AssetManager assetManager = context.getApplicationContext().getAssets();

	    InputStream in = null;
	    OutputStream out = null;
	    String newFileName = null;
	    try {
	        Log.i("tag", "copyFile() "+filename);
	        in = assetManager.open(filename);
	        if (filename.endsWith(".jpg")) // extension was added to avoid compression on APK file
	            newFileName = TARGET_BASE_PATH + filename.substring(0, filename.length()-4);
	        else
	            newFileName = TARGET_BASE_PATH + filename;
	        out = new FileOutputStream(newFileName);

	        byte[] buffer = new byte[1024];
	        int read;
	        while ((read = in.read(buffer)) != -1) {
	            out.write(buffer, 0, read);
	        }
	        in.close();
	        in = null;
	        out.flush();
	        out.close();
	        out = null;
	    } catch (Exception e) {
	        Log.e("tag", "Exception in copyFile() of "+newFileName);
	        Log.e("tag", "Exception in copyFile() "+e.toString());
	    }

	}
}
