package com.iqoption.fragment;

import android.arch.lifecycle.Observer;

final /* synthetic */ class dm implements Observer {
    private final cr crY;

    dm(cr crVar) {
        this.crY = crVar;
    }

    public void onChanged(Object obj) {
        this.crY.cY(((Boolean) obj).booleanValue());
    }
}
