package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzc<A extends zzm<? extends Result, zzb>> extends zza {
    private A zzftx;

    public zzc(int i, A a) {
        super(i);
        this.zzftx = a;
    }

    public final void zza(@NonNull zzae zzae, boolean z) {
        zzae.zza(this.zzftx, z);
    }

    public final void zza(zzbo<?> zzbo) {
        try {
            this.zzftx.zzb(zzbo.zzaix());
        } catch (RuntimeException e) {
            String simpleName = e.getClass().getSimpleName();
            String localizedMessage = e.getLocalizedMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(simpleName).length() + 2) + String.valueOf(localizedMessage).length());
            stringBuilder.append(simpleName);
            stringBuilder.append(": ");
            stringBuilder.append(localizedMessage);
            this.zzftx.zzu(new Status(10, stringBuilder.toString()));
        }
    }

    public final void zzs(@NonNull Status status) {
        this.zzftx.zzu(status);
    }
}
