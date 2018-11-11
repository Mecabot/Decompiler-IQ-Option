package com.iqoption.system.a;

import com.iqoption.app.IQApp;
import java.lang.ref.WeakReference;

/* compiled from: SocketEventHandlerBaseT */
public class i<T> implements g {
    private boolean drT;
    protected final WeakReference<T> drU;

    public i(T t) {
        this.drU = new WeakReference(t);
    }

    public void register() {
        if (!this.drT) {
            IQApp.Dm().aD(this);
            this.drT = true;
        }
    }

    public void unregister() {
        if (this.drT) {
            IQApp.aV(this);
            this.drT = false;
        }
    }
}
