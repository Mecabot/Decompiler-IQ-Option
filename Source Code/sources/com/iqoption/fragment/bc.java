package com.iqoption.fragment;

final /* synthetic */ class bc implements Runnable {
    private final bb cpx;

    bc(bb bbVar) {
        this.cpx = bbVar;
    }

    public void run() {
        this.cpx.onClose();
    }
}
