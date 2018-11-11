package com.iqoption.fragment.rightpanel;

import com.iqoption.app.managers.a.k.d;

final /* synthetic */ class ak implements Runnable {
    private final a cHf;
    private final d cHi;

    ak(a aVar, d dVar) {
        this.cHf = aVar;
        this.cHi = dVar;
    }

    public void run() {
        this.cHf.a(this.cHi);
    }
}
