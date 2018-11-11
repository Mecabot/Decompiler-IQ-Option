package com.iqoption.app.managers;

import com.iqoption.mobbtech.connect.response.options.e;

final /* synthetic */ class f implements Runnable {
    private final c amN;
    private final e amO;

    f(c cVar, e eVar) {
        this.amN = cVar;
        this.amO = eVar;
    }

    public void run() {
        this.amN.k(this.amO);
    }
}
