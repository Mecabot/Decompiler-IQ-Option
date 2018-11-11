package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;

final /* synthetic */ class dz implements Runnable {
    private final boolean bVC;
    private final a csj;

    dz(a aVar, boolean z) {
        this.csj = aVar;
        this.bVC = z;
    }

    public void run() {
        this.csj.cZ(this.bVC);
    }
}
