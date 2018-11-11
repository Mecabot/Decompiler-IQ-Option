package com.neovisionaries.ws.client;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: SocketFactorySettings */
class ac {
    private SSLSocketFactory eaC;
    private SocketFactory eaE;
    private SSLContext eaF;

    ac() {
    }

    public SocketFactory fQ(boolean z) {
        if (z) {
            if (this.eaF != null) {
                return this.eaF.getSocketFactory();
            }
            if (this.eaC != null) {
                return this.eaC;
            }
            return SSLSocketFactory.getDefault();
        } else if (this.eaE != null) {
            return this.eaE;
        } else {
            return SocketFactory.getDefault();
        }
    }
}
