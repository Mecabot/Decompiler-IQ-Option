package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class zzh extends zza {
    private /* synthetic */ zzg zzenr;

    zzh(zzg zzg) {
        this.zzenr = zzg;
    }

    public final void zza(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            zzp.zzbq(this.zzenr.val$context).zza(this.zzenr.zzenq, googleSignInAccount);
        }
        this.zzenr.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
