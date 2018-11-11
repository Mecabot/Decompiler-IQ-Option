package com.iqoption.fragment.dialog.whatsnew.depositpage;

import android.support.v4.app.FragmentManager;
import com.iqoption.core.microservices.popupserver.response.a;

final /* synthetic */ class d implements Runnable {
    private final FragmentManager cfl;
    private final a csb;

    d(FragmentManager fragmentManager, a aVar) {
        this.cfl = fragmentManager;
        this.csb = aVar;
    }

    public void run() {
        c.a(this.cfl, this.csb);
    }
}
