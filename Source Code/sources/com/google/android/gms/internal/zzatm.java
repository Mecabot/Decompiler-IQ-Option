package com.google.android.gms.internal;

import android.app.job.JobParameters;

final class zzatm implements zzasr {
    final /* synthetic */ Integer zzeel;
    private /* synthetic */ zzark zzeem;
    final /* synthetic */ zzatd zzeen;
    final /* synthetic */ JobParameters zzeeo;
    final /* synthetic */ zzatl zzeep;

    zzatm(zzatl zzatl, Integer num, zzark zzark, zzatd zzatd, JobParameters jobParameters) {
        this.zzeep = zzatl;
        this.zzeel = num;
        this.zzeem = zzark;
        this.zzeen = zzatd;
        this.zzeeo = jobParameters;
    }

    public final void zze(Throwable th) {
        this.zzeep.mHandler.post(new zzatn(this));
    }
}
