package com.google.android.gms.common.api.internal;

abstract class zzbj {
    private final zzbh zzfzd;

    protected zzbj(zzbh zzbh) {
        this.zzfzd = zzbh;
    }

    protected abstract void zzajj();

    public final void zzc(zzbi zzbi) {
        zzbi.zzfwa.lock();
        try {
            if (zzbi.zzfyz == this.zzfzd) {
                zzajj();
            }
            zzbi.zzfwa.unlock();
        } catch (Throwable th) {
            zzbi.zzfwa.unlock();
        }
    }
}
