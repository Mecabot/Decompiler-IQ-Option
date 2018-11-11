package com.iqoption.app;

import com.iqoption.mobbtech.connect.RequestManager;

final /* synthetic */ class aa implements Runnable {
    static final Runnable alc = new aa();

    private aa() {
    }

    public void run() {
        RequestManager.initialize();
    }
}
