package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.zzatk;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzatk zzdtz;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onReceive(Context context, Intent intent) {
        if (this.zzdtz == null) {
            this.zzdtz = new zzatk();
        }
        zzatk.onReceive(context, intent);
    }
}
