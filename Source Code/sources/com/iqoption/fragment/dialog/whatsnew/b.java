package com.iqoption.fragment.dialog.whatsnew;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class b implements Runnable {
    private final String afd;
    private final FragmentManager cfl;

    b(FragmentManager fragmentManager, String str) {
        this.cfl = fragmentManager;
        this.afd = str;
    }

    public void run() {
        a.show(this.cfl, this.afd);
    }
}
