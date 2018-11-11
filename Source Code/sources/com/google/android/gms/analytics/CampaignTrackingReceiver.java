package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzarh;
import com.google.android.gms.internal.zzark;
import com.google.android.gms.internal.zzasl;
import com.google.android.gms.internal.zzatt;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    private static Boolean zzdud;

    @Hide
    public static boolean zzbj(Context context) {
        zzbq.checkNotNull(context);
        if (zzdud != null) {
            return zzdud.booleanValue();
        }
        boolean zzb = zzatt.zzb(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        zzdud = Boolean.valueOf(zzb);
        return zzb;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public void onReceive(Context context, Intent intent) {
        zzark zzbl = zzark.zzbl(context);
        zzarh zzxy = zzbl.zzxy();
        if (intent == null) {
            zzxy.zzed("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzxy.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzxy.zzed("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        zzn(context, stringExtra);
        int zzzw = zzasl.zzzw();
        if (stringExtra.length() > zzzw) {
            zzxy.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzzw));
            stringExtra = stringExtra.substring(0, zzzw);
        }
        zzbl.zzyc().zza(stringExtra, new zzc(this, goAsync()));
    }

    @Hide
    protected void zzn(Context context, String str) {
    }
}
