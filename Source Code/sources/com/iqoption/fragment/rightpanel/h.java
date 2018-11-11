package com.iqoption.fragment.rightpanel;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.risks.response.overnightfee.d;

final /* synthetic */ class h implements Observer {
    private final g cFs;

    h(g gVar) {
        this.cFs = gVar;
    }

    public void onChanged(Object obj) {
        this.cFs.a((d) obj);
    }
}
