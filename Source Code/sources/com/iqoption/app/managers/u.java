package com.iqoption.app.managers;

import com.iqoption.dto.entity.StockRate;
import com.iqoption.util.ag.e;
import java.lang.ref.WeakReference;

final /* synthetic */ class u implements e {
    private final WeakReference aeE;

    u(WeakReference weakReference) {
        this.aeE = weakReference;
    }

    public void aU(Object obj) {
        t.a(this.aeE, (StockRate[]) obj);
    }
}
