package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.k;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory */
public class b implements c {
    private final k emj;
    private e eoo;
    private boolean eop;
    private SSLSocketFactory sslSocketFactory;

    public b() {
        this(new io.fabric.sdk.android.b());
    }

    public b(k kVar) {
        this.emj = kVar;
    }

    public void a(e eVar) {
        if (this.eoo != eVar) {
            this.eoo = eVar;
            aVp();
        }
    }

    private synchronized void aVp() {
        this.eop = false;
        this.sslSocketFactory = null;
    }

    public HttpRequest a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest b;
        switch (httpMethod) {
            case GET:
                b = HttpRequest.b(str, map, true);
                break;
            case POST:
                b = HttpRequest.c(str, map, true);
                break;
            case PUT:
                b = HttpRequest.I(str);
                break;
            case DELETE:
                b = HttpRequest.J(str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (lJ(str) && this.eoo != null) {
            SSLSocketFactory sSLSocketFactory = getSSLSocketFactory();
            if (sSLSocketFactory != null) {
                ((HttpsURLConnection) b.aVt()).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return b;
    }

    private boolean lJ(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory getSSLSocketFactory() {
        if (this.sslSocketFactory == null && !this.eop) {
            this.sslSocketFactory = aVq();
        }
        return this.sslSocketFactory;
    }

    private synchronized SSLSocketFactory aVq() {
        SSLSocketFactory b;
        this.eop = true;
        try {
            b = d.b(this.eoo);
            this.emj.d("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.emj.e("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return b;
    }
}
