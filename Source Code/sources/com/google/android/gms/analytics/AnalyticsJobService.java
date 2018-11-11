package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzatl;
import com.google.android.gms.internal.zzato;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements zzato {
    private zzatl<AnalyticsJobService> zzdty;

    private final zzatl<AnalyticsJobService> zzvt() {
        if (this.zzdty == null) {
            this.zzdty = new zzatl(this);
        }
        return this.zzdty;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        zzvt().onCreate();
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        zzvt().onDestroy();
        super.onDestroy();
    }

    @Hide
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzvt().onStartCommand(intent, i, i2);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zzvt().onStartJob(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Hide
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
