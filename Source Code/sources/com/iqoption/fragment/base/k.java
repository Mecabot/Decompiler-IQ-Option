package com.iqoption.fragment.base;

import android.graphics.Rect;
import android.support.v4.app.FragmentManager;

final /* synthetic */ class k implements Runnable {
    private final boolean cgP;
    private final int csi;
    private final FragmentManager cwg;
    private final Rect cwh;
    private final String je;

    k(int i, FragmentManager fragmentManager, String str, Rect rect, boolean z) {
        this.csi = i;
        this.cwg = fragmentManager;
        this.je = str;
        this.cwh = rect;
        this.cgP = z;
    }

    public void run() {
        j.a(this.csi, this.cwg, this.je, this.cwh, this.cgP);
    }
}
