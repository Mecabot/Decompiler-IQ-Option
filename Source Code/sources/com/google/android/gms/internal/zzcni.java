package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;

final class zzcni {
    private long mStartTime;
    private final zze zzdir;

    public zzcni(zze zze) {
        zzbq.checkNotNull(zze);
        this.zzdir = zze;
    }

    public final void clear() {
        this.mStartTime = 0;
    }

    public final void start() {
        this.mStartTime = this.zzdir.elapsedRealtime();
    }

    public final boolean zzu(long j) {
        return this.mStartTime == 0 || this.zzdir.elapsedRealtime() - this.mStartTime >= 3600000;
    }
}
