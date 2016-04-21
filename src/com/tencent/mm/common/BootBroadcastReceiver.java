package com.tencent.mm.common;
 
import com.tencent.mm.basicActivity.login.LoginActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
 
/**
 * Created with IntelliJ IDEA.
 * User: 郏高阳
 * Date: 13-6-5
 * Time: 下午8:25
 * To change this template use File | Settings | File Templates.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
 
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Intent LoginActivity = new Intent(context, LoginActivity.class);  // 要启动的Activity
            LoginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(LoginActivity);
        }
    }
}
