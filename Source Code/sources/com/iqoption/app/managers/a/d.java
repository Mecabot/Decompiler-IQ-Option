package com.iqoption.app.managers.a;

import com.iqoption.core.microservices.tradingengine.response.active.h.b;
import com.iqoption.dto.entity.expiration.Expiration;

final /* synthetic */ class d implements com.google.common.base.d {
    static final com.google.common.base.d $instance = new d();

    private d() {
    }

    public Object apply(Object obj) {
        return Expiration.createCfdExpiration(((b) obj).getExpiration() * 1000, ((b) obj).Xs() * 1000);
    }
}
