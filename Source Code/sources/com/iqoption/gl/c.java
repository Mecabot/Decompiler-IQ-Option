package com.iqoption.gl;

import com.iqoption.app.IQApp;
import com.iqoption.gl.NativeHandler.d;

final /* synthetic */ class c implements Runnable {
    private final double cIJ;

    c(double d) {
        this.cIJ = d;
    }

    public void run() {
        IQApp.Dn().aE(new d().setValue(Double.valueOf(this.cIJ)));
    }
}
