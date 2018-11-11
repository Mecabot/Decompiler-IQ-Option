package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcmj implements Runnable {
    private /* synthetic */ zzcme zzjri;
    private /* synthetic */ zzclz zzjrk;

    zzcmj(zzcme zzcme, zzclz zzclz) {
        this.zzjri = zzcme;
        this.zzjrk = zzclz;
    }

    public final void run() {
        zzcjb zzd = this.zzjri.zzjrc;
        if (zzd == null) {
            this.zzjri.zzayp().zzbau().log("Failed to send current screen to service");
            return;
        }
        try {
            long j;
            String str;
            String str2;
            String packageName;
            if (this.zzjrk == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzjri.getContext().getPackageName();
            } else {
                j = this.zzjrk.zzjql;
                str = this.zzjrk.zzjqj;
                str2 = this.zzjrk.zzjqk;
                packageName = this.zzjri.getContext().getPackageName();
            }
            zzd.zza(j, str, str2, packageName);
            this.zzjri.zzyw();
        } catch (RemoteException e) {
            this.zzjri.zzayp().zzbau().zzj("Failed to send current screen to the service", e);
        }
    }
}
