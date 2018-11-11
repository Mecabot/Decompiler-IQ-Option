package com.microblink.secured;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

/* compiled from: line */
public final class IIllIIllll {
    private HttpsURLConnection dWf = null;
    private OutputStream dWg = null;
    private final URL dWh;
    private final String dWi;
    private boolean dWj = false;

    /* compiled from: line */
    public static class llIIlIlIIl extends Exception {
        public llIIlIlIIl(Exception exception) {
            super(exception);
        }

        public final /* bridge */ /* synthetic */ Throwable getCause() {
            return (IOException) super.getCause();
        }
    }

    private IIllIIllll(URL url, String str) {
        this.dWh = url;
        this.dWi = str;
    }

    public static IIllIIllll kC(String str) {
        try {
            return new IIllIIllll(new URL(str), "POST");
        } catch (Exception e) {
            throw new llIIlIlIIl(e);
        }
    }

    private static String kD(String str) {
        try {
            Charset.forName(str);
            return str;
        } catch (UnsupportedCharsetException unused) {
            return "UTF-8";
        }
    }

    private void addHeader(String str, String str2) {
        aPy().setRequestProperty(str, str2);
    }

    public final HttpsURLConnection aPy() {
        if (this.dWf == null) {
            try {
                this.dWf = (HttpsURLConnection) this.dWh.openConnection();
                this.dWf.setRequestMethod(this.dWi);
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.dWf.setSSLSocketFactory(instance.getSocketFactory());
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        return this.dWf;
    }

    public final void G(Map<String, String> map) {
        String str = "UTF-8";
        String kD = kD(str);
        String str2 = "application/x-www-form-urlencoded";
        if (kD == null || kD.length() <= 0) {
            addHeader("Content-Type", str2);
        } else {
            StringBuilder stringBuilder = new StringBuilder("; charset=");
            stringBuilder.append(kD);
            kD = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(kD);
            addHeader("Content-Type", stringBuilder2.toString());
        }
        boolean z = true;
        if (this.dWg == null) {
            try {
                aPy();
                this.dWf.setDoOutput(true);
                this.dWg = new BufferedOutputStream(aPy().getOutputStream(), 8192);
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        if (this.dWg == null) {
            throw new llIIlIlIIl(new NullPointerException("outputStream == null"));
        }
        for (Entry entry : map.entrySet()) {
            if (!z) {
                try {
                    this.dWg.write("&".getBytes(str));
                } catch (Exception e2) {
                    throw new llIIlIlIIl(e2);
                }
            }
            this.dWg.write(URLEncoder.encode((String) entry.getKey(), str).getBytes(str));
            this.dWg.write("=".getBytes(str));
            this.dWg.write(URLEncoder.encode((String) entry.getValue(), str).getBytes(str));
            z = false;
        }
    }

    public final int getResponseCode() {
        if (!this.dWj) {
            this.dWj = true;
            try {
                this.dWg.close();
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        try {
            return aPy().getResponseCode();
        } catch (Exception e2) {
            throw new llIIlIlIIl(e2);
        }
    }
}
