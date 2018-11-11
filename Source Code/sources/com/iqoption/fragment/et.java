package com.iqoption.fragment;

import com.iqoption.service.e.b;

final /* synthetic */ class et implements Runnable {
    private final e csH;
    private final b csI;

    et(e eVar, b bVar) {
        this.csH = eVar;
        this.csI = bVar;
    }

    public void run() {
        this.csH.a(this.csI);
    }
}
