package com.google.android.gms.analytics;

import android.util.Log;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.FutureTask;

final class zzm extends FutureTask<T> {
    private /* synthetic */ zza zzdvs;

    zzm(zza zza, Runnable runnable, Object obj) {
        this.zzdvs = zza;
        super(runnable, obj);
    }

    protected final void setException(Throwable th) {
        UncaughtExceptionHandler zzb = zzk.this.zzdvp;
        if (zzb != null) {
            zzb.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 37);
            stringBuilder.append("MeasurementExecutor: job failed with ");
            stringBuilder.append(valueOf);
            Log.e("GAv4", stringBuilder.toString());
        }
        super.setException(th);
    }
}
