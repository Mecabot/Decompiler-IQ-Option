package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzdkf;

final class zzfa implements Runnable {
    private /* synthetic */ zzey zzksi;
    private /* synthetic */ zzdkf zzksj;

    zzfa(zzey zzey, zzdkf zzdkf) {
        this.zzksi = zzey;
        this.zzksj = zzdkf;
    }

    public final void run() {
        this.zzksi.zzb(this.zzksj);
    }
}
