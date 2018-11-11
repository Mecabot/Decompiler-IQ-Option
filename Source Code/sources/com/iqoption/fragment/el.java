package com.iqoption.fragment;

import com.iqoption.app.managers.c.g;
import com.iqoption.fragment.cr.a;

final /* synthetic */ class el implements Runnable {
    private final a csj;
    private final g csx;

    el(a aVar, g gVar) {
        this.csj = aVar;
        this.csx = gVar;
    }

    public void run() {
        this.csj.b(this.csx);
    }
}
