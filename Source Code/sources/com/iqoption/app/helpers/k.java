package com.iqoption.app.helpers;

import com.google.common.base.j;
import com.iqoption.core.microservices.tradingengine.response.active.a;

final /* synthetic */ class k implements j {
    private final String alY;

    k(String str) {
        this.alY = str;
    }

    public boolean apply(Object obj) {
        return a.a(this.alY, (a) obj);
    }
}
