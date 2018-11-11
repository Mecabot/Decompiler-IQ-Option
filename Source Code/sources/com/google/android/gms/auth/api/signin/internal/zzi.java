package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzi extends zzm<Status> {
    zzi(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        zze zze = (zze) zzb;
        ((zzv) zze.zzalw()).zzb(new zzj(this), zze.zzaco());
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
