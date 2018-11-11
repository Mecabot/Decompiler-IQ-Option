package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaxa extends zzaxg<CredentialRequestResult> {
    private /* synthetic */ CredentialRequest zzels;

    zzaxa(zzawz zzawz, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        this.zzels = credentialRequest;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzaxn zzaxn) {
        zzaxn.zza(new zzaxb(this), this.zzels);
    }
}
