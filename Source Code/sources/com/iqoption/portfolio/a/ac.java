package com.iqoption.portfolio.a;

import com.iqoption.fragment.bf.a;

final /* synthetic */ class ac implements Runnable {
    private final a ddr;
    private final a dds;

    ac(a aVar, a aVar2) {
        this.ddr = aVar;
        this.dds = aVar2;
    }

    public void run() {
        this.ddr.a(this.dds);
    }
}
