package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzde;
import com.google.android.gms.common.api.internal.zzdf;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzayf extends zzde<zzayb, Void> {
    private TaskCompletionSource<Void> zzejm;

    private zzayf() {
    }

    /* synthetic */ zzayf(zzayd zzayd) {
        this();
    }

    protected final /* synthetic */ void zza(zzb zzb, TaskCompletionSource taskCompletionSource) {
        zzayb zzayb = (zzayb) zzb;
        this.zzejm = taskCompletionSource;
        zza((zzaxx) zzayb.zzalw());
    }

    protected abstract void zza(zzaxx zzaxx);

    protected final void zzh(Status status) {
        zzdf.zza(status, null, this.zzejm);
    }
}
