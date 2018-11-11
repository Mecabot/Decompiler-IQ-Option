package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.d;

final /* synthetic */ class dx implements Runnable {
    private final a csj;
    private final d csp;

    dx(a aVar, d dVar) {
        this.csj = aVar;
        this.csp = dVar;
    }

    public void run() {
        this.csj.a(this.csp);
    }
}
