package io.fabric.sdk.android.services.network;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: NetworkUtils */
public final class d {
    public static final SSLSocketFactory b(e eVar) {
        SSLContext instance = SSLContext.getInstance("TLS");
        f fVar = new f(new g(eVar.hG(), eVar.hH()), eVar);
        instance.init(null, new TrustManager[]{fVar}, null);
        return instance.getSocketFactory();
    }
}
