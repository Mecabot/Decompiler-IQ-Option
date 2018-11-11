package com.google.android.gms.internal;

final class zzarr implements Runnable {
    private /* synthetic */ zzasz zzdzt;
    private /* synthetic */ zzarq zzdzu;

    zzarr(zzarq zzarq, zzasz zzasz) {
        this.zzdzu = zzarq;
        this.zzdzt = zzasz;
    }

    public final void run() {
        if (!this.zzdzu.zzdzq.isConnected()) {
            this.zzdzu.zzdzq.zzeb("Connected to service after a timeout");
            this.zzdzu.zzdzq.zza(this.zzdzt);
        }
    }
}
