package com.iqoption.mobbtech.connect.response.a;

import com.google.common.base.n;
import com.iqoption.core.microservices.billing.response.b.a;

final /* synthetic */ class j implements n {
    private final a cWm;
    private final a cWn;

    j(a aVar, a aVar2) {
        this.cWm = aVar;
        this.cWn = aVar2;
    }

    public Object get() {
        return this.cWm.h(this.cWn);
    }
}
