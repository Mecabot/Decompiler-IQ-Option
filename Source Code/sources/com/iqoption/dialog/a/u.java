package com.iqoption.dialog.a;

import com.google.common.base.n;
import com.iqoption.microservice.quotes.history.a;
import com.iqoption.mobbtech.connect.response.options.e;
import com.iqoption.util.ag;

final /* synthetic */ class u implements n {
    private final long bVB;
    private final long bVy;
    private final e cgN;
    private final int cgO;
    private final boolean cgP;
    private final long cgQ;

    u(e eVar, long j, long j2, int i, boolean z, long j3) {
        this.cgN = eVar;
        this.bVB = j;
        this.bVy = j2;
        this.cgO = i;
        this.cgP = z;
        this.cgQ = j3;
    }

    public Object get() {
        return ag.a(a.a(this.cgN.getActiveId(), this.bVB, this.bVy, this.cgO), new l(this.cgP, this.cgQ, this.bVy));
    }
}
