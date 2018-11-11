package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class db implements Observer {
    private final cr crY;

    db(cr crVar) {
        this.crY = crVar;
    }

    public void onChanged(Object obj) {
        this.crY.g((a) obj);
    }
}
