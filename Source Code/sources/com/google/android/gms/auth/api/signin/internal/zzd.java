package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzd implements GoogleSignInApi {
    private static GoogleSignInOptions zza(GoogleApiClient googleApiClient) {
        return ((zze) googleApiClient.zza(Auth.zzeim)).zzaco();
    }

    public final Intent getSignInIntent(GoogleApiClient googleApiClient) {
        return zzf.zza(googleApiClient.getContext(), zza(googleApiClient));
    }

    public final GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        return zzf.getSignInResultFromIntent(intent);
    }

    public final PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        return zzf.zzb(googleApiClient, googleApiClient.getContext(), false);
    }

    public final PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return zzf.zza(googleApiClient, googleApiClient.getContext(), false);
    }

    public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        return zzf.zza(googleApiClient, googleApiClient.getContext(), zza(googleApiClient), false);
    }
}
