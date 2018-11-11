package com.google.android.gms.tagmanager;

final class zzaw implements Runnable {
    private /* synthetic */ zzat zzkoz;
    private /* synthetic */ String zzkpb;

    zzaw(zzat zzat, String str) {
        this.zzkoz = zzat;
        this.zzkpb = str;
    }

    public final void run() {
        this.zzkoz.zzlp(this.zzkpb);
    }
}
