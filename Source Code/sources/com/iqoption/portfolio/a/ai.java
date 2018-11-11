package com.iqoption.portfolio.a;

import com.iqoption.portfolio.a.ah.b;
import com.iqoption.portfolio.component.PortfolioLinearLayoutManager;

final /* synthetic */ class ai implements Runnable {
    private final int cgO;
    private final b ddA;
    private final PortfolioLinearLayoutManager ddz;
    private final int jH;

    ai(PortfolioLinearLayoutManager portfolioLinearLayoutManager, int i, b bVar, int i2) {
        this.ddz = portfolioLinearLayoutManager;
        this.jH = i;
        this.ddA = bVar;
        this.cgO = i2;
    }

    public void run() {
        ah.a(this.ddz, this.jH, this.ddA, this.cgO);
    }
}
