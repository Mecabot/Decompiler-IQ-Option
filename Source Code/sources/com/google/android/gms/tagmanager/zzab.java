package com.google.android.gms.tagmanager;

final class zzab implements zzac {
    private /* synthetic */ zzy zzkod;
    private Long zzkoe;
    private /* synthetic */ boolean zzkof;

    zzab(zzy zzy, boolean z) {
        this.zzkod = zzy;
        this.zzkof = z;
    }

    public final boolean zzb(Container container) {
        if (!this.zzkof) {
            return !container.isDefault();
        } else {
            long lastRefreshTime = container.getLastRefreshTime();
            if (this.zzkoe == null) {
                this.zzkoe = Long.valueOf(this.zzkod.zzknu.zzbfw());
            }
            return lastRefreshTime + this.zzkoe.longValue() >= this.zzkod.zzata.currentTimeMillis();
        }
    }
}
