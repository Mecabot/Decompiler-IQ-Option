package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

public final class zzatl<T extends Context & zzato> {
    private static Boolean zzeek;
    private final Handler mHandler = new Handler();
    private final T zzeej;

    @Hide
    public zzatl(T t) {
        zzbq.checkNotNull(t);
        this.zzeej = t;
    }

    private final void zza(Integer num, JobParameters jobParameters) {
        zzark zzbl = zzark.zzbl(this.zzeej);
        zzbl.zzyc().zza(new zzatm(this, num, zzbl, zzbl.zzxy(), jobParameters));
    }

    @Hide
    public static boolean zzbn(Context context) {
        zzbq.checkNotNull(context);
        if (zzeek != null) {
            return zzeek.booleanValue();
        }
        boolean zzp = zzatt.zzp(context, "com.google.android.gms.analytics.AnalyticsService");
        zzeek = Boolean.valueOf(zzp);
        return zzp;
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        zzark.zzbl(this.zzeej).zzxy().zzea("Local AnalyticsService is starting up");
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        zzark.zzbl(this.zzeej).zzxy().zzea("Local AnalyticsService is shutting down");
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (zzatk.sLock) {
                zzcyz zzcyz = zzatk.zzeei;
                if (zzcyz != null && zzcyz.isHeld()) {
                    zzcyz.release();
                }
            }
        } catch (SecurityException unused) {
            zzarh zzxy = zzark.zzbl(this.zzeej).zzxy();
            if (intent == null) {
                zzxy.zzed("AnalyticsService started with null intent");
                return 2;
            }
            String action = intent.getAction();
            zzxy.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                zza(Integer.valueOf(i2), null);
            }
            return 2;
        }
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        zzarh zzxy = zzark.zzbl(this.zzeej).zzxy();
        String string = jobParameters.getExtras().getString("action");
        zzxy.zza("Local AnalyticsJobService called. action", string);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            zza(null, jobParameters);
        }
        return true;
    }
}
