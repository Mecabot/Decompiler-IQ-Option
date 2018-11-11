package com.jumio.core.network;

import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class TLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory delegate;

    public TLSSocketFactory(TrustManager[] trustManagerArr) {
        SSLContext instance;
        if (VERSION.SDK_INT >= 16) {
            instance = SSLContext.getInstance("TLSv1.2");
        } else {
            instance = SSLContext.getInstance("TLS");
        }
        instance.init(null, trustManagerArr, null);
        this.delegate = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return enableTLSOnSocket(this.delegate.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return enableTLSOnSocket(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }
}
