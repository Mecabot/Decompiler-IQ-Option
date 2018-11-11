package com.iqoption.view.toppanel;

import com.iqoption.app.managers.a.k.a;

final /* synthetic */ class j implements Runnable {
    private final a cpn;
    private final a dKG;

    j(a aVar, a aVar2) {
        this.dKG = aVar;
        this.cpn = aVar2;
    }

    public void run() {
        this.dKG.d(this.cpn);
    }
}
