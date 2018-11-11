package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.bw.c;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class r implements Runnable {
    private final b cFT;
    private final c cFv;

    r(b bVar, c cVar) {
        this.cFT = bVar;
        this.cFv = cVar;
    }

    public void run() {
        this.cFT.b(this.cFv);
    }
}
