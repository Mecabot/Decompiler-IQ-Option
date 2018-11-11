package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzaxf extends zzawx {
    private zzn<Status> zzelv;

    zzaxf(zzn<Status> zzn) {
        this.zzelv = zzn;
    }

    public final void zze(Status status) {
        this.zzelv.setResult(status);
    }
}
