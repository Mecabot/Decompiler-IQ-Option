package com.iqoption.fragment;

import android.view.View;

final /* synthetic */ class l implements Runnable {
    private final View aeQ;
    private final a cnA;

    l(a aVar, View view) {
        this.cnA = aVar;
        this.aeQ = view;
    }

    public void run() {
        this.cnA.aE(this.aeQ);
    }
}
