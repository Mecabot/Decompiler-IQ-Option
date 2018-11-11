package com.iqoption.mobbtech.connect.response.a;

final /* synthetic */ class i implements Runnable {
    private final a cWm;

    i(a aVar) {
        this.cWm = aVar;
    }

    public void run() {
        this.cWm.restart();
    }
}
