package com.iqoption.fragment.rightpanel;

import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.gl.b;

final /* synthetic */ class ag implements Runnable {
    private final Strike cGP;
    private final Quote cGQ;
    private final Quote cGR;

    ag(Strike strike, Quote quote, Quote quote2) {
        this.cGP = strike;
        this.cGQ = quote;
        this.cGR = quote2;
    }

    public void run() {
        b.aow().glchTabUpdateStrike(this.cGP.getStrikeKey(), Quote.selfAskPrice(this.cGQ), Quote.selfBidPrice(this.cGQ), Quote.selfAskPrice(this.cGR), Quote.selfBidPrice(this.cGR), Quote.isQuoteAvailable(this.cGQ), Quote.isQuoteAvailable(this.cGR));
    }
}
