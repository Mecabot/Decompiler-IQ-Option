package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzcmh implements Runnable {
    private /* synthetic */ zzcif zzjpj;
    private /* synthetic */ zzcme zzjri;
    private /* synthetic */ AtomicReference zzjrj;

    zzcmh(zzcme zzcme, AtomicReference atomicReference, zzcif zzcif) {
        this.zzjri = zzcme;
        this.zzjrj = atomicReference;
        this.zzjpj = zzcif;
    }

    public final void run() {
        synchronized (this.zzjrj) {
            Object obj;
            try {
                zzcjb zzd = this.zzjri.zzjrc;
                if (zzd == null) {
                    this.zzjri.zzayp().zzbau().log("Failed to get app instance id");
                    this.zzjrj.notify();
                    return;
                }
                this.zzjrj.set(zzd.zzc(this.zzjpj));
                String str = (String) this.zzjrj.get();
                if (str != null) {
                    this.zzjri.zzayd().zzjx(str);
                    this.zzjri.zzayq().zzjlt.zzjy(str);
                }
                this.zzjri.zzyw();
                obj = this.zzjrj;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzjri.zzayp().zzbau().zzj("Failed to get app instance id", e);
                    obj = this.zzjrj;
                } catch (Throwable th) {
                    this.zzjrj.notify();
                }
            }
        }
    }
}
