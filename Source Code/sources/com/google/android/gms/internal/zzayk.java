package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzayk implements ProxyResult {
    private Status mStatus;
    private ProxyResponse zzemf;

    public zzayk(ProxyResponse proxyResponse) {
        this.zzemf = proxyResponse;
        this.mStatus = Status.zzftq;
    }

    public zzayk(Status status) {
        this.mStatus = status;
    }

    public final ProxyResponse getResponse() {
        return this.zzemf;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
