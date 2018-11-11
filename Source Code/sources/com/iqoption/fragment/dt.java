package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.gl.NativeHandler.q;

final /* synthetic */ class dt implements Runnable {
    private final a csj;
    private final q csm;

    dt(a aVar, q qVar) {
        this.csj = aVar;
        this.csm = qVar;
    }

    public void run() {
        this.csj.a(this.csm);
    }
}
