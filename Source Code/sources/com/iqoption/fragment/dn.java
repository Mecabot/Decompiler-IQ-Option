package com.iqoption.fragment;

import com.iqoption.microservice.regulators.response.StatusType;
import io.reactivex.c.e;

final /* synthetic */ class dn implements e {
    private final cr crY;

    dn(cr crVar) {
        this.crY = crVar;
    }

    public void accept(Object obj) {
        this.crY.b((StatusType) obj);
    }
}
