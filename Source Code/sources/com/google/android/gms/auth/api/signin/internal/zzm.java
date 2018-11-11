package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

abstract class zzm<R extends Result> extends com.google.android.gms.common.api.internal.zzm<R, zze> {
    public zzm(GoogleApiClient googleApiClient) {
        super(Auth.GOOGLE_SIGN_IN_API, googleApiClient);
    }
}
