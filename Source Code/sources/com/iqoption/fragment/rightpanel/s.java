package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.bv.a;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class s implements Runnable {
    private final b cFT;
    private final a cFW;

    s(b bVar, a aVar) {
        this.cFT = bVar;
        this.cFW = aVar;
    }

    public void run() {
        this.cFT.a(this.cFW);
    }
}
