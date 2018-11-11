package com.iqoption.dialog;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class g implements Runnable {
    private final FragmentManager cfl;

    g(FragmentManager fragmentManager) {
        this.cfl = fragmentManager;
    }

    public void run() {
        f.a(this.cfl, f.cB(true));
    }
}
