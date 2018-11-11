package com.iqoption.util;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class ad implements Runnable {
    private final String afd;
    private final FragmentManager cfl;
    private final int jd;

    ad(FragmentManager fragmentManager, String str, int i) {
        this.cfl = fragmentManager;
        this.afd = str;
        this.jd = i;
    }

    public void run() {
        ac.b(this.cfl, this.afd, this.jd);
    }
}
