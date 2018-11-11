package com.iqoption.fragment;

import com.iqoption.gl.b;
import com.iqoption.settings.a.f;

final /* synthetic */ class ec implements Runnable {
    private final f csr;

    ec(f fVar) {
        this.csr = fVar;
    }

    public void run() {
        b.aow().setLiveDealsEnabled(((Boolean) this.csr.getValue()).booleanValue());
    }
}
