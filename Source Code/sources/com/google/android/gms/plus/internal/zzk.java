package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzk extends zza {
    private final zzn<Status> zziul;

    public zzk(zzn<Status> zzn) {
        this.zziul = zzn;
    }

    public final void zzk(int i, Bundle bundle) {
        this.zziul.setResult(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
    }
}
