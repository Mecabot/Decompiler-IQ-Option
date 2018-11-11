package com.iqoption.app.helpers;

import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.microservices.tradingengine.response.active.a;

final /* synthetic */ class j implements com.google.common.base.j {
    private final ActiveType alX;

    j(ActiveType activeType) {
        this.alX = activeType;
    }

    public boolean apply(Object obj) {
        return a.a(this.alX, (a) obj);
    }
}
