package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

final class zzayj extends zzaxr {
    private /* synthetic */ zzayi zzeme;

    zzayj(zzayi zzayi) {
        this.zzeme = zzayi;
    }

    public final void zza(ProxyResponse proxyResponse) {
        this.zzeme.setResult(new zzayk(proxyResponse));
    }
}
