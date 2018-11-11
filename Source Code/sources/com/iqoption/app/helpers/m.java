package com.iqoption.app.helpers;

import com.google.common.base.j;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import java.util.List;

final /* synthetic */ class m implements j {
    private final List ama;

    m(List list) {
        this.ama = list;
    }

    public boolean apply(Object obj) {
        return a.a(this.ama, (a) obj);
    }
}
