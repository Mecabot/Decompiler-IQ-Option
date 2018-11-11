package com.iqoption.microservice.configuration;

import com.google.common.base.j;
import com.iqoption.dto.entity.configuration.Configuration;
import java.util.concurrent.atomic.AtomicInteger;

final /* synthetic */ class b implements j {
    private final a cQH;
    private final AtomicInteger cQI;

    b(a aVar, AtomicInteger atomicInteger) {
        this.cQH = aVar;
        this.cQI = atomicInteger;
    }

    public boolean apply(Object obj) {
        return this.cQH.a(this.cQI, (Configuration) obj);
    }
}
