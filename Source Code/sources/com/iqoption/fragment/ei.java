package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.gl.NativeHandler.l;

final /* synthetic */ class ei implements Runnable {
    private final a csj;
    private final l csu;

    ei(a aVar, l lVar) {
        this.csj = aVar;
        this.csu = lVar;
    }

    public void run() {
        this.csj.a(this.csu);
    }
}
