package com.google.android.gms.internal;

final class zzara implements Runnable {
    private /* synthetic */ int zzdyi;
    private /* synthetic */ zzaqz zzdyj;

    zzara(zzaqz zzaqz, int i) {
        this.zzdyj = zzaqz;
        this.zzdyi = i;
    }

    public final void run() {
        this.zzdyj.zzdyh.zzr(((long) this.zzdyi) * 1000);
    }
}
