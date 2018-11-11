package com.iqoption.gl;

import com.iqoption.app.IQApp;

final /* synthetic */ class m implements Runnable {
    private final double apk;
    private final double cFb;
    private final double cIJ;

    m(double d, double d2, double d3) {
        this.cIJ = d;
        this.cFb = d2;
        this.apk = d3;
    }

    public void run() {
        IQApp.Dn().aE(new com.iqoption.gl.NativeHandler.m(this.cIJ, this.cFb, this.apk));
    }
}
