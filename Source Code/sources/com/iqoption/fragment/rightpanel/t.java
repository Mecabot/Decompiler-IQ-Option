package com.iqoption.fragment.rightpanel;

import com.iqoption.fragment.bq.c;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class t implements Runnable {
    private final b cFT;
    private final c cFX;

    t(b bVar, c cVar) {
        this.cFT = bVar;
        this.cFX = cVar;
    }

    public void run() {
        this.cFT.a(this.cFX);
    }
}
