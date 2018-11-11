package com.iqoption.fragment.rightpanel;

import com.iqoption.app.managers.a.k.a;
import com.iqoption.fragment.rightpanel.j.b;

final /* synthetic */ class u implements Runnable {
    private final b cFT;
    private final a cpn;

    u(b bVar, a aVar) {
        this.cFT = bVar;
        this.cpn = aVar;
    }

    public void run() {
        this.cFT.b(this.cpn);
    }
}
