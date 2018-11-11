package com.iqoption.fragment;

import com.iqoption.core.microservices.popupserver.response.a;
import java.lang.ref.WeakReference;

final /* synthetic */ class dg implements Runnable {
    private final WeakReference aeE;
    private final a csb;

    dg(WeakReference weakReference, a aVar) {
        this.aeE = weakReference;
        this.csb = aVar;
    }

    public void run() {
        cr.a(this.aeE, this.csb);
    }
}
