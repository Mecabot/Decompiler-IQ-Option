package com.iqoption.activity;

import com.iqoption.util.ag.a;
import java.lang.ref.WeakReference;

final /* synthetic */ class r implements a {
    private final WeakReference aeE;

    r(WeakReference weakReference) {
        this.aeE = weakReference;
    }

    public void n(Throwable th) {
        TradeRoomActivity.a(this.aeE, th);
    }
}
