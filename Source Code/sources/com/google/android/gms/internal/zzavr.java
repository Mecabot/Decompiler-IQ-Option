package com.google.android.gms.internal;

import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzavr extends zzm<Result, zzawa> {
    private /* synthetic */ boolean zzeih;

    zzavr(zzavq zzavq, Api api, GoogleApiClient googleApiClient, boolean z) {
        this.zzeih = z;
        super(api, googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzc) ((zzawa) zzb).zzalw()).zzau(this.zzeih);
        setResult(new zzavy(Status.zzftq));
    }

    protected final Result zzb(Status status) {
        return new zzavy(status);
    }
}
