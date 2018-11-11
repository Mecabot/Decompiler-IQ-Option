package com.iqoption.system.a;

import com.iqoption.app.IQApp;
import java.lang.ref.WeakReference;

/* compiled from: EventHandlerBaseT */
public class e<T> implements g {
    private boolean drT;
    protected final WeakReference<T> drU;

    public e(T t) {
        this.drU = new WeakReference(t);
    }

    public void register() {
        if (!this.drT) {
            IQApp.Dn().aD(this);
            this.drT = true;
        }
    }

    public void unregister() {
        if (this.drT) {
            IQApp.aW(this);
            this.drT = false;
        }
    }
}
