package com.neovisionaries.ws.client;

/* compiled from: WebSocketThread */
abstract class an extends Thread {
    protected final af dpy;
    private final ThreadType ebw;

    protected abstract void aQh();

    an(String str, af afVar, ThreadType threadType) {
        super(str);
        this.dpy = afVar;
        this.ebw = threadType;
    }

    public void run() {
        o aQX = this.dpy.aQX();
        if (aQX != null) {
            aQX.b(this.ebw, (Thread) this);
        }
        aQh();
        if (aQX != null) {
            aQX.c(this.ebw, this);
        }
    }

    public void aRB() {
        o aQX = this.dpy.aQX();
        if (aQX != null) {
            aQX.a(this.ebw, (Thread) this);
        }
    }
}
