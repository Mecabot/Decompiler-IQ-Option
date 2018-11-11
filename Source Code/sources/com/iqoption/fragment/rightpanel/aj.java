package com.iqoption.fragment.rightpanel;

import com.iqoption.view.h.b;

final /* synthetic */ class aj implements Runnable {
    private final a cHf;
    private final b cHh;

    aj(a aVar, b bVar) {
        this.cHf = aVar;
        this.cHh = bVar;
    }

    public void run() {
        this.cHf.a(this.cHh);
    }
}
