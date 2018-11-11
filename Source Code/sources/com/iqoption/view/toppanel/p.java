package com.iqoption.view.toppanel;

import com.iqoption.mobbtech.connect.request.api.a.c.b;

final /* synthetic */ class p implements Runnable {
    private final a dKG;
    private final b dKH;

    p(a aVar, b bVar) {
        this.dKG = aVar;
        this.dKH = bVar;
    }

    public void run() {
        this.dKG.a(this.dKH);
    }
}
