package com.iqoption.analytics.sla;

import com.iqoption.app.b.a;

final /* synthetic */ class h implements Runnable {
    private final b ajO;
    private final a ajQ;

    h(b bVar, a aVar) {
        this.ajO = bVar;
        this.ajQ = aVar;
    }

    public void run() {
        this.ajO.a(this.ajQ);
    }
}
