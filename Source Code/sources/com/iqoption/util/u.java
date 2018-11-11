package com.iqoption.util;

final /* synthetic */ class u implements Runnable {
    private final t dvf;
    private final Runnable dvg;

    u(t tVar, Runnable runnable) {
        this.dvf = tVar;
        this.dvg = runnable;
    }

    public void run() {
        this.dvf.l(this.dvg);
    }
}
