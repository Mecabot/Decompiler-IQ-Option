package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzawg;

final class zzk extends zzawg {
    private /* synthetic */ zzc zzejo;

    zzk(zzc zzc) {
        this.zzejo = zzc;
    }

    public final void onFailure(Status status) {
        this.zzejo.zzd(status);
    }

    public final void zzaby() {
        this.zzejo.setResult(null);
    }
}
