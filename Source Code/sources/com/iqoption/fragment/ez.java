package com.iqoption.fragment;

import com.iqoption.fragment.ex.b;

final /* synthetic */ class ez implements Runnable {
    private final ex csU;
    private final b csV;

    ez(ex exVar, b bVar) {
        this.csU = exVar;
        this.csV = bVar;
    }

    public void run() {
        this.csU.a(this.csV);
    }
}
