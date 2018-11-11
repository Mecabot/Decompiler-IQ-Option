package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.gl.NativeHandler;

final /* synthetic */ class eh implements Runnable {
    private final a csj;
    private final NativeHandler.a cst;

    eh(a aVar, NativeHandler.a aVar2) {
        this.csj = aVar;
        this.cst = aVar2;
    }

    public void run() {
        this.csj.a(this.cst);
    }
}
