package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;

final class zzatp {
    private long mStartTime;
    private final zze zzata;

    public zzatp(zze zze) {
        zzbq.checkNotNull(zze);
        this.zzata = zze;
    }

    public zzatp(zze zze, long j) {
        zzbq.checkNotNull(zze);
        this.zzata = zze;
        this.mStartTime = j;
    }

    public final void clear() {
        this.mStartTime = 0;
    }

    public final void start() {
        this.mStartTime = this.zzata.elapsedRealtime();
    }

    public final boolean zzu(long j) {
        return this.mStartTime == 0 || this.zzata.elapsedRealtime() - this.mStartTime > j;
    }
}
