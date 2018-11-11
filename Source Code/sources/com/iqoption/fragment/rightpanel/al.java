package com.iqoption.fragment.rightpanel;

import com.iqoption.app.managers.a.k.a;

final /* synthetic */ class al implements Runnable {
    private final a cHf;
    private final a cpn;

    al(a aVar, a aVar2) {
        this.cHf = aVar;
        this.cpn = aVar2;
    }

    public void run() {
        this.cHf.c(this.cpn);
    }
}
