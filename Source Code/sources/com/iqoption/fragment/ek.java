package com.iqoption.fragment;

import com.iqoption.dto.event.OtnEmissionExecuted;
import com.iqoption.fragment.cr.a;

final /* synthetic */ class ek implements Runnable {
    private final a csj;
    private final OtnEmissionExecuted csw;

    ek(a aVar, OtnEmissionExecuted otnEmissionExecuted) {
        this.csj = aVar;
        this.csw = otnEmissionExecuted;
    }

    public void run() {
        this.csj.a(this.csw);
    }
}
