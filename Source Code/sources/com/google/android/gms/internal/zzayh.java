package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzbq;

public final class zzayh implements ProxyApi {
    public final PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        zzbq.checkNotNull(googleApiClient);
        zzbq.checkNotNull(proxyRequest);
        return googleApiClient.zze(new zzayi(this, googleApiClient, proxyRequest));
    }
}
