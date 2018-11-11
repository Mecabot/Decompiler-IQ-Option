package com.iqoption.app.managers.tab;

final /* synthetic */ class c implements Runnable {
    private final a apj;
    private final double apk;
    private final int jH;

    c(a aVar, int i, double d) {
        this.apj = aVar;
        this.jH = i;
        this.apk = d;
    }

    public void run() {
        this.apj.d(this.jH, this.apk);
    }
}
