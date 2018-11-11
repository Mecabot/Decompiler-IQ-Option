package com.iqoption.system.a;

import com.iqoption.app.IQApp;

/* compiled from: EventHandlerBase */
public class d implements g {
    private boolean drT;

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
