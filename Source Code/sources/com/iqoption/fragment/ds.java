package com.iqoption.fragment;

import com.iqoption.fragment.cr.a;
import com.iqoption.view.LocalToast.b;

final /* synthetic */ class ds implements Runnable {
    private final a csj;
    private final b csl;

    ds(a aVar, b bVar) {
        this.csj = aVar;
        this.csl = bVar;
    }

    public void run() {
        this.csj.a(this.csl);
    }
}
