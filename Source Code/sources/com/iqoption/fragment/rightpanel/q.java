package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.ap.a;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class q implements Runnable {
    private final b cFT;
    private final a cFV;

    q(b bVar, a aVar) {
        this.cFT = bVar;
        this.cFV = aVar;
    }

    public void run() {
        this.cFT.a(this.cFV);
    }
}
