package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.a.e;

/* compiled from: RetryManager */
class v {
    long sJ;
    private e sK;

    public v(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.sK = eVar;
    }

    public boolean h(long j) {
        return j - this.sJ >= this.sK.aVe() * 1000000;
    }

    public void i(long j) {
        this.sJ = j;
        this.sK = this.sK.aVf();
    }

    public void reset() {
        this.sJ = 0;
        this.sK = this.sK.aVg();
    }
}
