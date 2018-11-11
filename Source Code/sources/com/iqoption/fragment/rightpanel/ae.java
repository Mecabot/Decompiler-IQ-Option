package com.iqoption.fragment.rightpanel;

import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;

final /* synthetic */ class ae implements Runnable {
    private final Strike cGP;
    private final Quote cGQ;
    private final Quote cGR;

    ae(Strike strike, Quote quote, Quote quote2) {
        this.cGP = strike;
        this.cGQ = quote;
        this.cGR = quote2;
    }

    public void run() {
        ab.a(this.cGP, this.cGQ, this.cGR);
    }
}
