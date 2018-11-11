package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzaxg<R extends Result> extends zzm<R, zzaxi> {
    zzaxg(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    protected abstract void zza(Context context, zzaxn zzaxn);

    protected final /* synthetic */ void zza(zzb zzb) {
        zzaxi zzaxi = (zzaxi) zzb;
        zza(zzaxi.getContext(), (zzaxn) zzaxi.zzalw());
    }
}
