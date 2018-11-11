package com.iqoption.app.managers;

import com.iqoption.util.ag.a;
import java.lang.ref.WeakReference;

final /* synthetic */ class v implements a {
    private final WeakReference aeE;

    v(WeakReference weakReference) {
        this.aeE = weakReference;
    }

    public void n(Throwable th) {
        t.b(this.aeE, th);
    }
}
