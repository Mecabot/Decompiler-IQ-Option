package com.iqoption.dialog.a;

import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.quotes.history.response.b;

final /* synthetic */ class l implements g {
    private final boolean aoe;
    private final long bVB;
    private final long bVy;

    l(boolean z, long j, long j2) {
        this.aoe = z;
        this.bVB = j;
        this.bVy = j2;
    }

    public s aP(Object obj) {
        return h.a(this.aoe, this.bVB, this.bVy, (b) obj);
    }
}
