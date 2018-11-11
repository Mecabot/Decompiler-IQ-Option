package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.gl.NativeHandler.e;

final /* synthetic */ class du implements Runnable {
    private final a csj;
    private final e csn;

    du(a aVar, e eVar) {
        this.csj = aVar;
        this.csn = eVar;
    }

    public void run() {
        this.csj.a(this.csn);
    }
}
