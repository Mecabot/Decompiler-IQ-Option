package com.google.android.gms.tagmanager;

final class zzfq implements Runnable {
    private /* synthetic */ zzfo zzktv;

    zzfq(zzfo zzfo) {
        this.zzktv = zzfo;
    }

    public final void run() {
        this.zzktv.zzktk.dispatch();
    }
}
