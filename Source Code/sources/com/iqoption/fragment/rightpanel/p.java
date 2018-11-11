package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.bt.a;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class p implements Runnable {
    private final b cFT;
    private final a cFU;

    p(b bVar, a aVar) {
        this.cFT = bVar;
        this.cFU = aVar;
    }

    public void run() {
        this.cFT.a(this.cFU);
    }
}
