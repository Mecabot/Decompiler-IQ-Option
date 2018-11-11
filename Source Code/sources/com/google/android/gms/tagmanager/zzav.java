package com.google.android.gms.tagmanager;

final class zzav implements Runnable {
    private /* synthetic */ zzat zzkoz;
    private /* synthetic */ zzaq zzkpa;

    zzav(zzat zzat, zzaq zzaq) {
        this.zzkoz = zzat;
        this.zzkpa = zzaq;
    }

    public final void run() {
        this.zzkpa.zzal(this.zzkoz.zzbge());
    }
}
