package com.iqoption.fragment;

final /* synthetic */ class bz implements Runnable {
    private final by cqD;

    bz(by byVar) {
        this.cqD = byVar;
    }

    public void run() {
        this.cqD.onClose();
    }
}
