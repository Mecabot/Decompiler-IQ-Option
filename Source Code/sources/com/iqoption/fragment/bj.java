package com.iqoption.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

final /* synthetic */ class bj implements Runnable {
    private final FragmentManager cfl;
    private final int cgO;
    private final Fragment cpy;
    private final int jH;

    bj(FragmentManager fragmentManager, int i, Fragment fragment, int i2) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.cpy = fragment;
        this.cgO = i2;
    }

    public void run() {
        bh.a(this.cfl, this.jH, this.cpy, this.cgO);
    }
}
