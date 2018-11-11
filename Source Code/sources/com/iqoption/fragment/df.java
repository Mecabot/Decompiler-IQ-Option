package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class df implements Observer {
    private final cr crY;

    df(cr crVar) {
        this.crY = crVar;
    }

    public void onChanged(Object obj) {
        this.crY.d((a) obj);
    }
}
