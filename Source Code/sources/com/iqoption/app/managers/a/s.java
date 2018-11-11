package com.iqoption.app.managers.a;

import com.google.common.collect.ImmutableList;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.expiration.Expiration;

/* compiled from: IExpirationHelper */
public interface s {
    Expiration a(a aVar, Expiration expiration);

    String a(a aVar, long j);

    boolean b(a aVar, Expiration expiration);

    long c(a aVar, Expiration expiration);

    com.google.common.util.concurrent.s<ImmutableList<Expiration>> h(a aVar);

    long i(a aVar);

    com.google.common.util.concurrent.s<Expiration> k(a aVar);

    void l(a aVar);
}
