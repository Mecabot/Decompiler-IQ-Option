package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

final class zzaxb extends zzawx {
    private /* synthetic */ zzaxa zzelt;

    zzaxb(zzaxa zzaxa) {
        this.zzelt = zzaxa;
    }

    public final void zza(Status status, Credential credential) {
        this.zzelt.setResult(new zzawy(status, credential));
    }

    public final void zze(Status status) {
        this.zzelt.setResult(zzawy.zzf(status));
    }
}
