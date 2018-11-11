package com.iqoption.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

final /* synthetic */ class ey implements Runnable {
    private final FragmentManager cfl;
    private final int cgO;
    private final Fragment csN;
    private final int csO;
    private final int csP;
    private final int csQ;
    private final boolean csR;
    private final String csS;
    private final int csT;
    private final int jd;

    ey(FragmentManager fragmentManager, Fragment fragment, int i, int i2, int i3, int i4, int i5, boolean z, String str, int i6) {
        this.cfl = fragmentManager;
        this.csN = fragment;
        this.jd = i;
        this.cgO = i2;
        this.csO = i3;
        this.csP = i4;
        this.csQ = i5;
        this.csR = z;
        this.csS = str;
        this.csT = i6;
    }

    public void run() {
        ex.a(this.cfl, this.csN, this.jd, this.cgO, this.csO, this.csP, this.csQ, this.csR, this.csS, this.csT);
    }
}
