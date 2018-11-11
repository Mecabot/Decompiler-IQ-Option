package com.neovisionaries.ws.client;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: SocketConnector */
class ab {
    private final String dZr;
    private final int dZs;
    private final int eaA;
    private final x eaB;
    private final SSLSocketFactory eaC;
    private boolean eaD;
    private Socket eag;
    private final a eaz;

    ab(Socket socket, a aVar, int i) {
        this(socket, aVar, i, null, null, null, 0);
    }

    ab(Socket socket, a aVar, int i, x xVar, SSLSocketFactory sSLSocketFactory, String str, int i2) {
        this.eag = socket;
        this.eaz = aVar;
        this.eaA = i;
        this.eaB = xVar;
        this.eaC = sSLSocketFactory;
        this.dZr = str;
        this.dZs = i2;
    }

    public Socket getSocket() {
        return this.eag;
    }

    public void connect() {
        try {
            aQH();
        } catch (WebSocketException e) {
            try {
                this.eag.close();
            } catch (IOException unused) {
                throw e;
            }
        }
    }

    ab fP(boolean z) {
        this.eaD = z;
        return this;
    }

    private void aQH() {
        Object obj = this.eaB != null ? 1 : null;
        try {
            this.eag.connect(this.eaz.aQd(), this.eaA);
            if (this.eag instanceof SSLSocket) {
                a((SSLSocket) this.eag, this.eaz.getHostname());
            }
            if (obj != null) {
                aQI();
            }
        } catch (Throwable e) {
            String str = "Failed to connect to %s'%s': %s";
            Object[] objArr = new Object[3];
            objArr[0] = obj != null ? "the proxy " : "";
            objArr[1] = this.eaz;
            objArr[2] = e.getMessage();
            throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, String.format(str, objArr), e);
        }
    }

    private void a(SSLSocket sSLSocket, String str) {
        if (this.eaD && !q.dZS.verify(str, sSLSocket.getSession())) {
            throw new HostnameUnverifiedException(sSLSocket, str);
        }
    }

    private void aQI() {
        try {
            this.eaB.perform();
            if (this.eaC != null) {
                try {
                    this.eag = this.eaC.createSocket(this.eag, this.dZr, this.dZs, true);
                    try {
                        ((SSLSocket) this.eag).startHandshake();
                        if (this.eag instanceof SSLSocket) {
                            a((SSLSocket) this.eag, this.eaB.aQv());
                        }
                    } catch (Throwable e) {
                        throw new WebSocketException(WebSocketError.SSL_HANDSHAKE_ERROR, String.format("SSL handshake with the WebSocket endpoint (%s) failed: %s", new Object[]{this.eaz, e.getMessage()}), e);
                    }
                } catch (Throwable e2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to overlay an existing socket: ");
                    stringBuilder.append(e2.getMessage());
                    throw new WebSocketException(WebSocketError.SOCKET_OVERLAY_ERROR, stringBuilder.toString(), e2);
                }
            }
        } catch (Throwable e3) {
            throw new WebSocketException(WebSocketError.PROXY_HANDSHAKE_ERROR, String.format("Handshake with the proxy server (%s) failed: %s", new Object[]{this.eaz, e3.getMessage()}), e3);
        }
    }

    void aQJ() {
        try {
            this.eag.close();
        } catch (Throwable unused) {
        }
    }
}
