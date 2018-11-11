package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcmr implements Runnable {
    private /* synthetic */ zzcif zzjpj;
    private /* synthetic */ boolean zzjqb;
    private /* synthetic */ zzcme zzjri;
    private /* synthetic */ AtomicReference zzjrj;

    zzcmr(zzcme zzcme, AtomicReference atomicReference, zzcif zzcif, boolean z) {
        this.zzjri = zzcme;
        this.zzjrj = atomicReference;
        this.zzjpj = zzcif;
        this.zzjqb = z;
    }

    public final void run() {
        synchronized (this.zzjrj) {
            Object obj;
            try {
                zzcjb zzd = this.zzjri.zzjrc;
                if (zzd == null) {
                    this.zzjri.zzayp().zzbau().log("Failed to get user properties");
                    this.zzjrj.notify();
                    return;
                }
                this.zzjrj.set(zzd.zza(this.zzjpj, this.zzjqb));
                this.zzjri.zzyw();
                obj = this.zzjrj;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzjri.zzayp().zzbau().zzj("Failed to get user properties", e);
                    obj = this.zzjrj;
                } catch (Throwable th) {
                    this.zzjrj.notify();
                }
            }
        }
    }
}
