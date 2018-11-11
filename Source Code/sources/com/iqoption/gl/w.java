package com.iqoption.gl;

import com.iqoption.settings.a.c;

final /* synthetic */ class w implements Runnable {
    private final c cIT;

    w(c cVar) {
        this.cIT = cVar;
    }

    public void run() {
        b.aow().glchTabSetHighLowVisible(((Boolean) this.cIT.getValue()).booleanValue());
    }
}
