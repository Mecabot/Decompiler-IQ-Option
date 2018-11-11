package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzr;
import java.util.Collections;
import java.util.List;

final class zzc extends zza<zze, GoogleSignInOptions> {
    zzc() {
    }

    public final /* synthetic */ Api.zze zza(Context context, Looper looper, zzr zzr, @Nullable Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zze(context, looper, zzr, (GoogleSignInOptions) obj, connectionCallbacks, onConnectionFailedListener);
    }

    public final /* synthetic */ List zzr(@Nullable Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzaci();
    }
}
