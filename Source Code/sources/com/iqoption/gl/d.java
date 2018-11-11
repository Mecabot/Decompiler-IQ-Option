package com.iqoption.gl;

import com.iqoption.app.IQApp;
import com.iqoption.gl.NativeHandler.g;

final /* synthetic */ class d implements Runnable {
    private final double cIJ;

    d(double d) {
        this.cIJ = d;
    }

    public void run() {
        IQApp.Dn().aE(new g().setValue(Double.valueOf(this.cIJ)));
    }
}
