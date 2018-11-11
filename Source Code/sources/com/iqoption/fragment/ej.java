package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.gl.NativeHandler.h;

final /* synthetic */ class ej implements Runnable {
    private final a csj;
    private final h csv;

    ej(a aVar, h hVar) {
        this.csj = aVar;
        this.csv = hVar;
    }

    public void run() {
        this.csj.a(this.csv);
    }
}
