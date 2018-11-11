package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzaxs;

final class zze extends zza<zzaxs, zzf> {
    zze() {
    }

    public final /* synthetic */ com.google.android.gms.common.api.Api.zze zza(Context context, Looper looper, zzr zzr, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzaxs(context, looper, zzr, (zzf) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
