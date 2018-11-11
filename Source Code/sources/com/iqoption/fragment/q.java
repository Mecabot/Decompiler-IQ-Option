package com.iqoption.fragment;

final /* synthetic */ class q implements Runnable {
    private final String afd;
    private final a cnA;

    q(a aVar, String str) {
        this.cnA = aVar;
        this.afd = str;
    }

    public void run() {
        this.cnA.hz(this.afd);
    }
}
