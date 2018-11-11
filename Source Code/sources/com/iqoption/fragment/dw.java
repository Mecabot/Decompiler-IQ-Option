package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.e;

final /* synthetic */ class dw implements Runnable {
    private final a csj;
    private final e cso;

    dw(a aVar, e eVar) {
        this.csj = aVar;
        this.cso = eVar;
    }

    public void run() {
        this.csj.a(this.cso);
    }
}
