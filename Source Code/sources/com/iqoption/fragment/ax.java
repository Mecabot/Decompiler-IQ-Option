package com.iqoption.fragment;

import com.iqoption.app.managers.a.k.a;

final /* synthetic */ class ax implements Runnable {
    private final b cpm;
    private final a cpn;

    ax(b bVar, a aVar) {
        this.cpm = bVar;
        this.cpn = aVar;
    }

    public void run() {
        this.cpm.a(this.cpn);
    }
}
