package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.bw.c;

final /* synthetic */ class i implements Runnable {
    private final a cFu;
    private final c cFv;

    i(a aVar, c cVar) {
        this.cFu = aVar;
        this.cFv = cVar;
    }

    public void run() {
        this.cFu.a(this.cFv);
    }
}
