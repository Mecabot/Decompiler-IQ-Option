package com.iqoption.fragment;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class bp implements Runnable {
    private final FragmentManager cfl;
    private final int cgO;
    private final int jH;
    private final int jd;

    bp(FragmentManager fragmentManager, int i, int i2, int i3) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.jd = i2;
        this.cgO = i3;
    }

    public void run() {
        bo.a(this.cfl, this.jH, this.jd, this.cgO);
    }
}
