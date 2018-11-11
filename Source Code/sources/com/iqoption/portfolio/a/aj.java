package com.iqoption.portfolio.a;

import com.iqoption.portfolio.component.PortfolioLinearLayoutManager.a;

final /* synthetic */ class aj implements a {
    private final Runnable ddB;

    private aj(Runnable runnable) {
        this.ddB = runnable;
    }

    static a k(Runnable runnable) {
        return new aj(runnable);
    }

    public void awI() {
        this.ddB.run();
    }
}
