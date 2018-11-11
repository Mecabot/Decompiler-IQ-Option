package com.iqoption.service;

import com.iqoption.core.connect.bus.IQBusState;
import io.reactivex.c.f;

final /* synthetic */ class g implements f {
    static final f dnG = new g();

    private g() {
    }

    public Object apply(Object obj) {
        return WebSocketHandler.d((IQBusState) obj);
    }
}
