package com.iqoption.app.managers.a;

import com.google.common.base.d;
import com.google.common.collect.i;
import com.iqoption.dto.entity.expiration.Expiration;

final /* synthetic */ class c implements d {
    static final d $instance = new c();

    private c() {
    }

    public Object apply(Object obj) {
        return ((Expiration) i.c((Iterable) obj).sz().w(Expiration.notInitilizedExpiration));
    }
}
