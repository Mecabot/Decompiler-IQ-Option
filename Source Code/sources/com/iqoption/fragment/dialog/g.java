package com.iqoption.fragment.dialog;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

final /* synthetic */ class g implements Runnable {
    private final Bundle cAy;
    private final FragmentManager cfl;
    private final int jH;

    g(FragmentManager fragmentManager, int i, Bundle bundle) {
        this.cfl = fragmentManager;
        this.jH = i;
        this.cAy = bundle;
    }

    public void run() {
        f.a(this.cfl, this.jH, this.cAy);
    }
}
