package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzayi extends zzayg {
    private /* synthetic */ ProxyRequest zzemd;

    zzayi(zzayh zzayh, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        this.zzemd = proxyRequest;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzaxv zzaxv) {
        zzaxv.zza(new zzayj(this), this.zzemd);
    }
}
