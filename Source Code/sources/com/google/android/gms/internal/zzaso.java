package com.google.android.gms.internal;

import android.os.Looper;

final class zzaso implements Runnable {
    private /* synthetic */ zzasn zzebg;

    zzaso(zzasn zzasn) {
        this.zzebg = zzasn;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zzebg.zzdyp.zzya().zzd(this);
            return;
        }
        boolean zzea = this.zzebg.zzea();
        this.zzebg.zzebf = 0;
        if (zzea) {
            this.zzebg.run();
        }
    }
}
