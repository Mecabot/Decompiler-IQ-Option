package com.google.android.gms.internal;

import android.os.Build.VERSION;

final class zzatn implements Runnable {
    private /* synthetic */ zzatm zzeeq;

    zzatn(zzatm zzatm) {
        this.zzeeq = zzatm;
    }

    public final void run() {
        if (this.zzeeq.zzeel != null) {
            if (((zzato) this.zzeeq.zzeep.zzeej).callServiceStopSelfResult(this.zzeeq.zzeel.intValue())) {
                this.zzeeq.zzeen.zzea("Local AnalyticsService processed last dispatch request");
            }
            return;
        }
        if (VERSION.SDK_INT >= 24) {
            this.zzeeq.zzeen.zzea("AnalyticsJobService processed last dispatch request");
            ((zzato) this.zzeeq.zzeep.zzeej).zza(this.zzeeq.zzeeo, false);
        }
    }
}
