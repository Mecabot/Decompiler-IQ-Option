package com.iqoption.core.connect.http.a;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/connect/http/ssl/TLSSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "()V", "internalSSLSocketFactory", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", "s", "", "autoClose", "", "localHost", "enableTLSOnSocket", "socket", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "core_release"})
/* compiled from: TLSSocketFactory.kt */
public final class b extends SSLSocketFactory {
    private final SSLSocketFactory aOh;

    public b() {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, null, null);
        h.d(instance, "context");
        SSLSocketFactory socketFactory = instance.getSocketFactory();
        h.d(socketFactory, "context.socketFactory");
        this.aOh = socketFactory;
    }

    public String[] getDefaultCipherSuites() {
        Object defaultCipherSuites = this.aOh.getDefaultCipherSuites();
        h.d(defaultCipherSuites, "internalSSLSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public String[] getSupportedCipherSuites() {
        Object supportedCipherSuites = this.aOh.getSupportedCipherSuites();
        h.d(supportedCipherSuites, "internalSSLSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    public Socket createSocket() {
        return enableTLSOnSocket(this.aOh.createSocket());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        h.e(socket, "s");
        h.e(str, "host");
        return enableTLSOnSocket(this.aOh.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) {
        h.e(str, "host");
        return enableTLSOnSocket(this.aOh.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        h.e(str, "host");
        h.e(inetAddress, "localHost");
        return enableTLSOnSocket(this.aOh.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        h.e(inetAddress, "host");
        return enableTLSOnSocket(this.aOh.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        h.e(inetAddress, "address");
        h.e(inetAddress2, "localAddress");
        return enableTLSOnSocket(this.aOh.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }
}
