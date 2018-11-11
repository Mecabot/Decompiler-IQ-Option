package com.iqoption.fragment.dialog;

import android.support.v4.app.FragmentManager;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class i implements Runnable {
    private final FragmentManager cfl;
    private final a csb;

    i(FragmentManager fragmentManager, a aVar) {
        this.cfl = fragmentManager;
        this.csb = aVar;
    }

    public void run() {
        h.a(this.cfl, this.csb);
    }
}
