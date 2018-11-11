package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra;
            try {
                stringExtra = intent.getStringExtra("referrer");
            } catch (Throwable th) {
                AFLogger.a("error in BroadcastReceiver ", th);
                stringExtra = null;
            }
            if (stringExtra != null) {
                if (stringExtra.contains("AppsFlyer_Test") && intent.getStringExtra("TestIntegrationMode") != null) {
                    h.fA().d(context, intent);
                    return;
                } else if (context.getSharedPreferences("appsflyer-data", 0).getString("referrer", null) != null) {
                    h.fA();
                    h.e(context, stringExtra);
                    return;
                }
            }
            String string = i.fF().getString("referrer_timestamp");
            long currentTimeMillis = System.currentTimeMillis();
            if (string == null || currentTimeMillis - Long.valueOf(string).longValue() >= 2000) {
                AFLogger.an("SingleInstallBroadcastReceiver called");
                h.fA().d(context, intent);
                i.fF().set("referrer_timestamp", String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
