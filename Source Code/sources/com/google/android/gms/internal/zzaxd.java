package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzaxd extends zzaxg<Status> {
    private /* synthetic */ Credential zzelu;

    zzaxd(zzawz zzawz, GoogleApiClient googleApiClient, Credential credential) {
        this.zzelu = credential;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzaxn zzaxn) {
        zzaxn.zza(new zzaxf(this), new zzaxj(this.zzelu));
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
