package com.iqoption.microservice.configuration;

import com.iqoption.dto.entity.configuration.Configuration;

final /* synthetic */ class d implements com.google.common.base.d {
    private final a cQH;
    private final Configuration cQM;

    d(a aVar, Configuration configuration) {
        this.cQH = aVar;
        this.cQM = configuration;
    }

    public Object apply(Object obj) {
        return this.cQH.a(this.cQM, (Configuration) obj);
    }
}
