package com.iqoption.fragment;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class bu implements Runnable {
    private final FragmentManager cfl;
    private final int cgO;
    private final double cqe;
    private final int jH;
    private final int jd;

    bu(FragmentManager fragmentManager, int i, int i2, int i3, double d) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.jd = i2;
        this.cgO = i3;
        this.cqe = d;
    }

    public void run() {
        bt.a(this.cfl, this.jH, this.jd, this.cgO, this.cqe);
    }
}
