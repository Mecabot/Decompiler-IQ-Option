package com.iqoption.system.a;

import com.iqoption.app.IQApp;

/* compiled from: SocketEventHandlerBase */
public class h implements g {
    private boolean drT;

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
