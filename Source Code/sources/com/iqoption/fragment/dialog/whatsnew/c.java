package com.iqoption.fragment.dialog.whatsnew;

import android.support.v4.app.FragmentManager;

final /* synthetic */ class c implements Runnable {
    private final String afd;
    private final FragmentManager cfl;

    c(FragmentManager fragmentManager, String str) {
        this.cfl = fragmentManager;
        this.afd = str;
    }

    public void run() {
        a.show(this.cfl, this.afd);
    }
}
