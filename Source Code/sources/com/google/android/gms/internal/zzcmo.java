package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzcmo implements Runnable {
    private /* synthetic */ String zziuw;
    private /* synthetic */ zzcif zzjpj;
    private /* synthetic */ String zzjpm;
    private /* synthetic */ String zzjpn;
    private /* synthetic */ zzcme zzjri;
    private /* synthetic */ AtomicReference zzjrj;

    zzcmo(zzcme zzcme, AtomicReference atomicReference, String str, String str2, String str3, zzcif zzcif) {
        this.zzjri = zzcme;
        this.zzjrj = atomicReference;
        this.zziuw = str;
        this.zzjpm = str2;
        this.zzjpn = str3;
        this.zzjpj = zzcif;
    }

    public final void run() {
        synchronized (this.zzjrj) {
            Object zza;
            try {
                zzcjb zzd = this.zzjri.zzjrc;
                if (zzd == null) {
                    this.zzjri.zzayp().zzbau().zzd("Failed to get conditional properties", zzcjj.zzjs(this.zziuw), this.zzjpm, this.zzjpn);
                    this.zzjrj.set(Collections.emptyList());
                    this.zzjrj.notify();
                    return;
                }
                AtomicReference atomicReference;
                if (TextUtils.isEmpty(this.zziuw)) {
                    atomicReference = this.zzjrj;
                    zza = zzd.zza(this.zzjpm, this.zzjpn, this.zzjpj);
                } else {
                    atomicReference = this.zzjrj;
                    zza = zzd.zzk(this.zziuw, this.zzjpm, this.zzjpn);
                }
                atomicReference.set(zza);
                this.zzjri.zzyw();
                zza = this.zzjrj;
                zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzjri.zzayp().zzbau().zzd("Failed to get conditional properties", zzcjj.zzjs(this.zziuw), this.zzjpm, e);
                    this.zzjrj.set(Collections.emptyList());
                    zza = this.zzjrj;
                } catch (Throwable th) {
                    this.zzjrj.notify();
                }
            }
        }
    }
}
