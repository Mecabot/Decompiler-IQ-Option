package com.iqoption.portfolio.a;

import com.iqoption.dto.event.OtnEmissionExecuted;

final /* synthetic */ class ae implements Runnable {
    private final OtnEmissionExecuted csw;
    private final a ddr;

    ae(a aVar, OtnEmissionExecuted otnEmissionExecuted) {
        this.ddr = aVar;
        this.csw = otnEmissionExecuted;
    }

    public void run() {
        this.ddr.b(this.csw);
    }
}
