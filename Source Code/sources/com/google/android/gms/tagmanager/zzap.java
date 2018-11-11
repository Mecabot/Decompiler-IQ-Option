package com.google.android.gms.tagmanager;

import java.util.List;

final class zzap implements zzaq {
    private /* synthetic */ DataLayer zzkor;

    zzap(DataLayer dataLayer) {
        this.zzkor = dataLayer;
    }

    public final void zzal(List<zza> list) {
        for (zza zza : list) {
            this.zzkor.zzaa(DataLayer.zzn(zza.zzbkr, zza.mValue));
        }
        this.zzkor.zzkoq.countDown();
    }
}
