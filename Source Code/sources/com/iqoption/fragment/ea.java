package com.iqoption.fragment;

import com.iqoption.gl.b;
import com.iqoption.settings.a.l;

final /* synthetic */ class ea implements Runnable {
    private final l csq;

    ea(l lVar) {
        this.csq = lVar;
    }

    public void run() {
        b.aow().glchTabSetTradersMoodEnable(((Boolean) this.csq.getValue()).booleanValue());
    }
}
