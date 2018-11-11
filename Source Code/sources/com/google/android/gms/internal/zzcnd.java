package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;

public final class zzcnd extends zzcli {
    private Handler handler;
    private long zzjsb = zzxx().elapsedRealtime();
    private final zzcip zzjsc = new zzcne(this, this.zzjev);
    private final zzcip zzjsd = new zzcnf(this, this.zzjev);

    zzcnd(zzckj zzckj) {
        super(zzckj);
    }

    private final void zzbcn() {
        synchronized (this) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
        }
    }

    @WorkerThread
    private final void zzbco() {
        zzwj();
        zzbx(false);
        zzayb().zzaj(zzxx().elapsedRealtime());
    }

    @WorkerThread
    private final void zzbe(long j) {
        zzcip zzcip;
        long j2;
        zzwj();
        zzbcn();
        this.zzjsc.cancel();
        this.zzjsd.cancel();
        zzayp().zzbba().zzj("Activity resumed, time", Long.valueOf(j));
        this.zzjsb = j;
        if (zzxx().currentTimeMillis() - zzayq().zzjmb.get() > zzayq().zzjmd.get()) {
            zzayq().zzjmc.set(true);
            zzayq().zzjme.set(0);
        }
        if (zzayq().zzjmc.get()) {
            zzcip = this.zzjsc;
            j2 = zzayq().zzjma.get();
        } else {
            zzcip = this.zzjsd;
            j2 = 3600000;
        }
        zzcip.zzs(Math.max(0, j2 - zzayq().zzjme.get()));
    }

    @WorkerThread
    private final void zzbf(long j) {
        zzwj();
        zzbcn();
        this.zzjsc.cancel();
        this.zzjsd.cancel();
        zzayp().zzbba().zzj("Activity paused, time", Long.valueOf(j));
        if (this.zzjsb != 0) {
            zzayq().zzjme.set(zzayq().zzjme.get() + (j - this.zzjsb));
        }
    }

    protected final boolean zzazq() {
        return false;
    }

    @WorkerThread
    public final boolean zzbx(boolean z) {
        zzwj();
        zzyk();
        long elapsedRealtime = zzxx().elapsedRealtime();
        zzayq().zzjmd.set(zzxx().currentTimeMillis());
        long j = elapsedRealtime - this.zzjsb;
        if (z || j >= 1000) {
            zzayq().zzjme.set(j);
            zzayp().zzbba().zzj("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzcma.zza(zzayh().zzbcg(), bundle, true);
            zzayd().zzd("auto", "_e", bundle);
            this.zzjsb = elapsedRealtime;
            this.zzjsd.cancel();
            this.zzjsd.zzs(Math.max(0, 3600000 - zzayq().zzjme.get()));
            return true;
        }
        zzayp().zzbba().zzj("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }
}
