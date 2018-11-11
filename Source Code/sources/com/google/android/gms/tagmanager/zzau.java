package com.google.android.gms.tagmanager;

import java.util.List;

final class zzau implements Runnable {
    private /* synthetic */ List zzkox;
    private /* synthetic */ long zzkoy;
    private /* synthetic */ zzat zzkoz;

    zzau(zzat zzat, List list, long j) {
        this.zzkoz = zzat;
        this.zzkox = list;
        this.zzkoy = j;
    }

    public final void run() {
        this.zzkoz.zzb(this.zzkox, this.zzkoy);
    }
}
