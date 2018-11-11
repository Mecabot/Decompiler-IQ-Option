package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzawy implements CredentialRequestResult {
    private final Status mStatus;
    private final Credential zzelr;

    public zzawy(Status status, Credential credential) {
        this.mStatus = status;
        this.zzelr = credential;
    }

    public static zzawy zzf(Status status) {
        return new zzawy(status, null);
    }

    public final Credential getCredential() {
        return this.zzelr;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
