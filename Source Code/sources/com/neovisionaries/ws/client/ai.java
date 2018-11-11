package com.neovisionaries.ws.client;

import java.net.Socket;
import java.net.URI;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: WebSocketFactory */
public class ai {
    private int eaA;
    private boolean eaD = true;
    private final ac eaj = new ac();
    private String[] eal;
    private final y ebo = new y(this);

    private static int x(int i, boolean z) {
        return i >= 0 ? i : z ? 443 : 80;
    }

    public int aRi() {
        return this.eaA;
    }

    public ai ij(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout value cannot be negative.");
        }
        this.eaA = i;
        return this;
    }

    public ai fR(boolean z) {
        this.eaD = z;
        return this;
    }

    public af kU(String str) {
        return T(str, aRi());
    }

    public af T(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("The given URI is null.");
        } else if (i >= 0) {
            return a(URI.create(str), i);
        } else {
            throw new IllegalArgumentException("The given timeout value is negative.");
        }
    }

    public af a(URI uri, int i) {
        if (uri == null) {
            throw new IllegalArgumentException("The given URI is null.");
        } else if (i < 0) {
            throw new IllegalArgumentException("The given timeout value is negative.");
        } else {
            return a(uri.getScheme(), uri.getUserInfo(), p.a(uri), uri.getPort(), uri.getRawPath(), uri.getRawQuery(), i);
        }
    }

    private af a(String str, String str2, String str3, int i, String str4, String str5, int i2) {
        boolean kV = kV(str);
        if (str3 == null || str3.length() == 0) {
            throw new IllegalArgumentException("The host part is empty.");
        }
        return a(kV, str2, str3, i, kW(str4), str5, b(str3, i, kV, i2));
    }

    private static boolean kV(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The scheme part is empty.");
        } else if ("wss".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str)) {
            return true;
        } else {
            if ("ws".equalsIgnoreCase(str) || "http".equalsIgnoreCase(str)) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bad scheme: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static String kW(String str) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (str.startsWith("/")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private ab b(String str, int i, boolean z, int i2) {
        i = x(i, z);
        if ((this.ebo.getHost() != null ? 1 : null) != null) {
            return c(str, i, z, i2);
        }
        return d(str, i, z, i2);
    }

    private ab c(String str, int i, boolean z, int i2) {
        int x = x(this.ebo.getPort(), this.ebo.isSecure());
        Socket createSocket = this.ebo.aQx().createSocket();
        aa.a(createSocket, this.ebo.aQy());
        return new ab(createSocket, new a(this.ebo.getHost(), x), i2, new x(createSocket, str, i, this.ebo), z ? (SSLSocketFactory) this.eaj.fQ(z) : null, str, i).fP(this.eaD);
    }

    private ab d(String str, int i, boolean z, int i2) {
        Socket createSocket = this.eaj.fQ(z).createSocket();
        aa.a(createSocket, this.eal);
        return new ab(createSocket, new a(str, i), i2).fP(this.eaD);
    }

    private af a(boolean z, String str, String str2, int i, String str3, String str4, ab abVar) {
        if (i >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(":");
            stringBuilder.append(i);
            str2 = stringBuilder.toString();
        }
        String str5 = str2;
        if (str4 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str3);
            stringBuilder2.append("?");
            stringBuilder2.append(str4);
            str3 = stringBuilder2.toString();
        }
        return new af(this, z, str, str5, str3, abVar);
    }
}
