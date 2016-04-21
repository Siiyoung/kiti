package com.tencent.mm.common;

import android.app.Activity;
import android.graphics.Bitmap;

public class ScreenTool {
	
	 /**

	  * 截屏

	  * @param  activity

	  * @return

	  */

	 public static Bitmap captureScreen(Activity activity) {

	 activity.getWindow().getDecorView().setDrawingCacheEnabled(true);

	 Bitmap bmp=activity.getWindow().getDecorView().getDrawingCache();

	 return bmp;

	 }

}
