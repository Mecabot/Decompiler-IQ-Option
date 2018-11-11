package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

final class zzarl implements UncaughtExceptionHandler {
    private /* synthetic */ zzark zzdzg;

    zzarl(zzark zzark) {
        this.zzdzg = zzark;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        zzarh zzym = this.zzdzg.zzym();
        if (zzym != null) {
            zzym.zze("Job execution failed", th);
        }
    }
}
