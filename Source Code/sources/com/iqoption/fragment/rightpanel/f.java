package com.iqoption.fragment.rightpanel;

import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.dto.entity.strike.Strike;

final /* synthetic */ class f implements Runnable {
    private final boolean ajB;
    private final e cFa;
    private final double cFb;
    private final a cFc;
    private final Strike cFd;

    f(e eVar, double d, boolean z, a aVar, Strike strike) {
        this.cFa = eVar;
        this.cFb = d;
        this.ajB = z;
        this.cFc = aVar;
        this.cFd = strike;
    }

    public void run() {
        this.cFa.b(this.cFb, this.ajB, this.cFc, this.cFd);
    }
}
