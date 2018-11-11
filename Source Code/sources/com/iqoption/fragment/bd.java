package com.iqoption.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

final /* synthetic */ class bd implements Runnable {
    private final FragmentManager cfl;
    private final Fragment cpy;
    private final int jH;

    bd(FragmentManager fragmentManager, int i, Fragment fragment) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.cpy = fragment;
    }

    public void run() {
        bb.a(this.cfl, this.jH, this.cpy);
    }
}
