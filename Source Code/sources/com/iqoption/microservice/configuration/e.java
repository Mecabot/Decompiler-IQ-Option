package com.iqoption.microservice.configuration;

import com.google.common.base.d;
import com.iqoption.core.i;
import com.iqoption.dto.entity.configuration.Configuration;

final /* synthetic */ class e implements d {
    private final Configuration cQN;

    e(Configuration configuration) {
        this.cQN = configuration;
    }

    public Object apply(Object obj) {
        return i.d(a.TAG, "restored config is used");
    }
}
