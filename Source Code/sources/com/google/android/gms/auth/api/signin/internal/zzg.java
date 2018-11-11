package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzg extends zzm<GoogleSignInResult> {
    final /* synthetic */ Context val$context;
    final /* synthetic */ GoogleSignInOptions zzenq;

    zzg(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        this.val$context = context;
        this.zzenq = googleSignInOptions;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzv) ((zze) zzb).zzalw()).zza(new zzh(this), this.zzenq);
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return new GoogleSignInResult(null, status);
    }
}
