package com.iqoption.app.managers.a;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.core.microservices.tradingengine.response.active.k;
import com.iqoption.dto.entity.expiration.Expiration;

/* compiled from: ExpirationTurboHelper */
public class r extends q {
    public s<ImmutableList<Expiration>> h(a aVar) {
        return o.aR(c((k) aVar));
    }

    public long i(a aVar) {
        return c(aVar, Expiration.notInitilizedExpiration);
    }
}
