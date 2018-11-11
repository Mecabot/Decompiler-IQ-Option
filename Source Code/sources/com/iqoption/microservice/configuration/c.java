package com.iqoption.microservice.configuration;

import com.google.common.base.j;
import com.iqoption.dto.entity.configuration.Configuration;
import java.util.concurrent.atomic.AtomicInteger;

final /* synthetic */ class c implements j {
    private final a cQH;
    private final j cQJ;
    private final Configuration cQK;
    private final AtomicInteger cQL;

    c(a aVar, j jVar, Configuration configuration, AtomicInteger atomicInteger) {
        this.cQH = aVar;
        this.cQJ = jVar;
        this.cQK = configuration;
        this.cQL = atomicInteger;
    }

    public boolean apply(Object obj) {
        return this.cQH.a(this.cQJ, this.cQK, this.cQL, (Configuration) obj);
    }
}
