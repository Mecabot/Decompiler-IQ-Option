package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzaxe extends zzaxg<Status> {
    zzaxe(zzawz zzawz, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final void zza(Context context, zzaxn zzaxn) {
        zzaxn.zza(new zzaxf(this));
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
