package com.iqoption.fragment;

import android.view.View;

final /* synthetic */ class m implements Runnable {
    private final View aeQ;
    private final a cnA;

    m(a aVar, View view) {
        this.cnA = aVar;
        this.aeQ = view;
    }

    public void run() {
        this.cnA.aD(this.aeQ);
    }
}
