package com.iqoption.deposit;

import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.billing.response.b.a;

final /* synthetic */ class n implements g {
    private final String arc;
    private final long bVB;
    private final l bVw;
    private final Double bVz;
    private final String je;

    n(l lVar, long j, String str, Double d, String str2) {
        this.bVw = lVar;
        this.bVB = j;
        this.je = str;
        this.bVz = d;
        this.arc = str2;
    }

    public s aP(Object obj) {
        return this.bVw.a(this.bVB, this.je, this.bVz, this.arc, (a) obj);
    }
}
