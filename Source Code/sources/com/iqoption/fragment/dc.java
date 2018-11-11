package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class dc implements Observer {
    private final cr crY;

    dc(cr crVar) {
        this.crY = crVar;
    }

    public void onChanged(Object obj) {
        this.crY.f((a) obj);
    }
}
