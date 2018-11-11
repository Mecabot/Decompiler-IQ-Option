package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf extends zzb<Boolean> {
    private zzck<?> zzfuc;

    public zzf(zzck<?> zzck, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzfuc = zzck;
    }

    public final /* bridge */ /* synthetic */ void zza(@NonNull zzae zzae, boolean z) {
    }

    public final void zzb(zzbo<?> zzbo) {
        zzcr zzcr = (zzcr) zzbo.zzakh().remove(this.zzfuc);
        if (zzcr != null) {
            zzcr.zzftz.zzc(zzbo.zzaix(), this.zzejm);
            zzcr.zzfty.zzaky();
            return;
        }
        this.zzejm.trySetResult(Boolean.valueOf(false));
    }
}
