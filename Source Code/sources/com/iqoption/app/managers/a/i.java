package com.iqoption.app.managers.a;

import com.google.common.base.d;
import com.iqoption.dto.entity.expiration.Expiration;

final /* synthetic */ class i implements d {
    static final d $instance = new i();

    private i() {
    }

    public Object apply(Object obj) {
        return ((Expiration) com.google.common.collect.i.c((Iterable) obj).sz().w(Expiration.notInitilizedDigitalExpiration));
    }
}
