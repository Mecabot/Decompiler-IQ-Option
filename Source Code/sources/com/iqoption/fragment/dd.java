package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class dd implements Observer {
    private final cr crY;

    dd(cr crVar) {
        this.crY = crVar;
    }

    public void onChanged(Object obj) {
        this.crY.e((a) obj);
    }
}
