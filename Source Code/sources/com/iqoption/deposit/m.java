package com.iqoption.deposit;

import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.billing.response.b.a;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;

final /* synthetic */ class m implements g {
    private final String arc;
    private final String bVA;
    private final l bVw;
    private final PayMethod bVx;
    private final long bVy;
    private final Double bVz;

    m(l lVar, PayMethod payMethod, long j, Double d, String str, String str2) {
        this.bVw = lVar;
        this.bVx = payMethod;
        this.bVy = j;
        this.bVz = d;
        this.arc = str;
        this.bVA = str2;
    }

    public s aP(Object obj) {
        return this.bVw.a(this.bVx, this.bVy, this.bVz, this.arc, this.bVA, (a) obj);
    }
}
