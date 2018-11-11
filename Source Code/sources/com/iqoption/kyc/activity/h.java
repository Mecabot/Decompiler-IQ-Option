package com.iqoption.kyc.activity;

import com.google.common.base.d;
import com.iqoption.microservice.a.a.a;

final /* synthetic */ class h implements d {
    private final a cJP;

    private h(a aVar) {
        this.cJP = aVar;
    }

    static d a(a aVar) {
        return new h(aVar);
    }

    public Object apply(Object obj) {
        return this.cJP.fk(((Integer) obj).intValue());
    }
}
