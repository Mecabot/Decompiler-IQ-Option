package com.iqoption.fragment.rightpanel;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.risks.response.overnightfee.d;

final /* synthetic */ class k implements Observer {
    private final j cFN;

    k(j jVar) {
        this.cFN = jVar;
    }

    public void onChanged(Object obj) {
        this.cFN.b((d) obj);
    }
}
