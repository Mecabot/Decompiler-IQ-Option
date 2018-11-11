package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class zzdo extends BroadcastReceiver {
    private static String zzedv = "com.google.android.gms.tagmanager.zzdo";
    private final zzfn zzkqx;

    zzdo(zzfn zzfn) {
        this.zzkqx = zzfn;
    }

    public static void zzeo(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzedv, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.zzkqx.zzca(bool.booleanValue() ^ 1);
            return;
        }
        if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzedv)) {
            this.zzkqx.zzbhy();
        }
    }
}
