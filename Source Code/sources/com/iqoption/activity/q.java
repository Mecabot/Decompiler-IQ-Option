package com.iqoption.activity;

import com.iqoption.util.ag.e;
import java.lang.ref.WeakReference;

final /* synthetic */ class q implements e {
    private final WeakReference aeE;

    q(WeakReference weakReference) {
        this.aeE = weakReference;
    }

    public void aU(Object obj) {
        TradeRoomActivity.a(this.aeE, obj);
    }
}
