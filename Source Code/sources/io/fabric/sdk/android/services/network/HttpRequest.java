package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
    private static final String[] eor = new String[0];
    private static b eos = b.eoD;
    private int bufferSize = 8192;
    private d eot;
    private boolean eou;
    private boolean eov = true;
    private boolean eow = false;
    private String eox;
    private int eoy;
    private final String requestMethod;
    public final URL url;
    private HttpURLConnection xz = null;

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public interface b {
        public static final b eoD = new b() {
            public HttpURLConnection b(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection a(URL url, Proxy proxy);

        HttpURLConnection b(URL url);
    }

    protected static abstract class c<V> implements Callable<V> {
        protected abstract void done();

        protected abstract V run();

        protected c() {
        }

        public V call() {
            Throwable th;
            Object obj = 1;
            try {
                V run = run();
                try {
                    done();
                    return run;
                } catch (IOException e) {
                    throw new HttpRequestException(e);
                }
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            } catch (Throwable th2) {
                th = th2;
                done();
                throw th;
            }
        }
    }

    public static class d extends BufferedOutputStream {
        private final CharsetEncoder encoder;

        public d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.encoder = Charset.forName(HttpRequest.lK(str)).newEncoder();
        }

        public d lO(String str) {
            ByteBuffer encode = this.encoder.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    protected static abstract class a<V> extends c<V> {
        private final Closeable eoC;
        private final boolean eov;

        protected a(Closeable closeable, boolean z) {
            this.eoC = closeable;
            this.eov = z;
        }

        protected void done() {
            if (this.eoC instanceof Flushable) {
                ((Flushable) this.eoC).flush();
            }
            if (this.eov) {
                try {
                    this.eoC.close();
                } catch (IOException unused) {
                    return;
                }
            }
            this.eoC.close();
        }
    }

    private static String lK(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder b(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder c(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String F(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(host);
                stringBuilder.append(':');
                stringBuilder.append(Integer.toString(port));
                host = stringBuilder.toString();
            }
            try {
                host = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = host.indexOf(63);
                if (indexOf <= 0) {
                    return host;
                }
                indexOf++;
                if (indexOf >= host.length()) {
                    return host;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(host.substring(0, indexOf));
                stringBuilder2.append(host.substring(indexOf).replace("+", "%2B"));
                return stringBuilder2.toString();
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        b(charSequence2, stringBuilder);
        c(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest G(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = a(charSequence, map);
        if (z) {
            charSequence = F(charSequence);
        }
        return G(charSequence);
    }

    public static HttpRequest H(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest c(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = a(charSequence, map);
        if (z) {
            charSequence = F(charSequence);
        }
        return H(charSequence);
    }

    public static HttpRequest I(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest J(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.url = new URL(charSequence.toString());
            this.requestMethod = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy aVr() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.eox, this.eoy));
    }

    private HttpURLConnection aVs() {
        try {
            HttpURLConnection a;
            if (this.eox != null) {
                a = eos.a(this.url, aVr());
            } else {
                a = eos.b(this.url);
            }
            a.setRequestMethod(this.requestMethod);
            return a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method());
        stringBuilder.append(' ');
        stringBuilder.append(url());
        return stringBuilder.toString();
    }

    public HttpURLConnection aVt() {
        if (this.xz == null) {
            this.xz = aVs();
        }
        return this.xz;
    }

    public int code() {
        try {
            aVB();
            return aVt().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected ByteArrayOutputStream aVu() {
        int aVA = aVA();
        if (aVA > 0) {
            return new ByteArrayOutputStream(aVA);
        }
        return new ByteArrayOutputStream();
    }

    public String lL(String str) {
        OutputStream aVu = aVu();
        try {
            b(aVw(), aVu);
            return aVu.toString(lK(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String aVv() {
        return lL(aVy());
    }

    public BufferedInputStream aVw() {
        return new BufferedInputStream(aVx(), this.bufferSize);
    }

    public InputStream aVx() {
        InputStream inputStream;
        if (code() < 400) {
            try {
                inputStream = aVt().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = aVt().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = aVt().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.eow || !"gzip".equals(aVz())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest ja(int i) {
        aVt().setConnectTimeout(i);
        return this;
    }

    public HttpRequest aS(String str, String str2) {
        aVt().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest j(Entry<String, String> entry) {
        return aS((String) entry.getKey(), (String) entry.getValue());
    }

    public String header(String str) {
        aVC();
        return aVt().getHeaderField(str);
    }

    public int lM(String str) {
        return V(str, -1);
    }

    public int V(String str, int i) {
        aVC();
        return aVt().getHeaderFieldInt(str, i);
    }

    public String aT(String str, String str2) {
        return aU(header(str), str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    protected java.lang.String aU(java.lang.String r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x0071;
    L_0x0003:
        r1 = r9.length();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0071;
    L_0x000a:
        r1 = r9.length();
        r2 = 59;
        r3 = r9.indexOf(r2);
        r4 = 1;
        r3 = r3 + r4;
        if (r3 == 0) goto L_0x0070;
    L_0x0018:
        if (r3 != r1) goto L_0x001b;
    L_0x001a:
        goto L_0x0070;
    L_0x001b:
        r5 = r9.indexOf(r2, r3);
        r6 = -1;
        if (r5 != r6) goto L_0x0023;
    L_0x0022:
        r5 = r1;
    L_0x0023:
        if (r3 >= r5) goto L_0x006f;
    L_0x0025:
        r7 = 61;
        r7 = r9.indexOf(r7, r3);
        if (r7 == r6) goto L_0x0066;
    L_0x002d:
        if (r7 >= r5) goto L_0x0066;
    L_0x002f:
        r3 = r9.substring(r3, r7);
        r3 = r3.trim();
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x0066;
    L_0x003d:
        r7 = r7 + 1;
        r3 = r9.substring(r7, r5);
        r3 = r3.trim();
        r7 = r3.length();
        if (r7 == 0) goto L_0x0066;
    L_0x004d:
        r9 = 2;
        if (r7 <= r9) goto L_0x0065;
    L_0x0050:
        r9 = 0;
        r9 = r3.charAt(r9);
        r10 = 34;
        if (r10 != r9) goto L_0x0065;
    L_0x0059:
        r7 = r7 - r4;
        r9 = r3.charAt(r7);
        if (r10 != r9) goto L_0x0065;
    L_0x0060:
        r9 = r3.substring(r4, r7);
        return r9;
    L_0x0065:
        return r3;
    L_0x0066:
        r3 = r5 + 1;
        r5 = r9.indexOf(r2, r3);
        if (r5 != r6) goto L_0x0023;
    L_0x006e:
        goto L_0x0022;
    L_0x006f:
        return r0;
    L_0x0070:
        return r0;
    L_0x0071:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.HttpRequest.aU(java.lang.String, java.lang.String):java.lang.String");
    }

    public String aVy() {
        return aT("Content-Type", "charset");
    }

    public HttpRequest gs(boolean z) {
        aVt().setUseCaches(z);
        return this;
    }

    public String aVz() {
        return header("Content-Encoding");
    }

    public HttpRequest lN(String str) {
        return aV(str, null);
    }

    public HttpRequest aV(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return aS("Content-Type", str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("; charset=");
        stringBuilder.append(str2);
        return aS("Content-Type", stringBuilder.toString());
    }

    public int aVA() {
        return lM("Content-Length");
    }

    protected HttpRequest b(InputStream inputStream, OutputStream outputStream) {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (HttpRequest) new a<HttpRequest>(inputStream, this.eov) {
            /* renamed from: aVF */
            public HttpRequest run() {
                byte[] bArr = new byte[HttpRequest.this.bufferSize];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest aVB() {
        if (this.eot == null) {
            return this;
        }
        if (this.eou) {
            this.eot.lO("\r\n--00content0boundary00--\r\n");
        }
        if (this.eov) {
            try {
                this.eot.close();
            } catch (IOException unused) {
                this.eot = null;
                return this;
            }
        }
        this.eot.close();
    }

    protected HttpRequest aVC() {
        try {
            return aVB();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest aVD() {
        if (this.eot != null) {
            return this;
        }
        aVt().setDoOutput(true);
        this.eot = new d(aVt().getOutputStream(), aU(aVt().getRequestProperty("Content-Type"), "charset"), this.bufferSize);
        return this;
    }

    protected HttpRequest aVE() {
        if (this.eou) {
            this.eot.lO("\r\n--00content0boundary00\r\n");
        } else {
            this.eou = true;
            lN("multipart/form-data; boundary=00content0boundary00").aVD();
            this.eot.lO("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest k(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"");
            stringBuilder.append(str2);
        }
        stringBuilder.append('\"');
        aX("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            aX("Content-Type", str3);
        }
        return K("\r\n");
    }

    public HttpRequest aW(String str, String str2) {
        return l(str, null, str2);
    }

    public HttpRequest l(String str, String str2, String str3) {
        return c(str, str2, null, str3);
    }

    public HttpRequest c(String str, String str2, String str3, String str4) {
        try {
            aVE();
            k(str, str2, str3);
            this.eot.lO(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest b(String str, Number number) {
        return a(str, null, number);
    }

    public HttpRequest a(String str, String str2, Number number) {
        return l(str, str2, number != null ? number.toString() : null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A:{SYNTHETIC, Splitter: B:19:0x0026} */
    public io.fabric.sdk.android.services.network.HttpRequest a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) {
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x001d }
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x001d }
        r2.<init>(r7);	 Catch:{ IOException -> 0x001d }
        r1.<init>(r2);	 Catch:{ IOException -> 0x001d }
        r4 = r3.a(r4, r5, r6, r1);	 Catch:{ IOException -> 0x0018, all -> 0x0015 }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.close();	 Catch:{ IOException -> 0x0014 }
    L_0x0014:
        return r4;
    L_0x0015:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0024;
    L_0x0018:
        r4 = move-exception;
        r0 = r1;
        goto L_0x001e;
    L_0x001b:
        r4 = move-exception;
        goto L_0x0024;
    L_0x001d:
        r4 = move-exception;
    L_0x001e:
        r5 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException;	 Catch:{ all -> 0x001b }
        r5.<init>(r4);	 Catch:{ all -> 0x001b }
        throw r5;	 Catch:{ all -> 0x001b }
    L_0x0024:
        if (r0 == 0) goto L_0x0029;
    L_0x0026:
        r0.close();	 Catch:{ IOException -> 0x0029 }
    L_0x0029:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.HttpRequest.a(java.lang.String, java.lang.String, java.lang.String, java.io.File):io.fabric.sdk.android.services.network.HttpRequest");
    }

    public HttpRequest a(String str, String str2, String str3, InputStream inputStream) {
        try {
            aVE();
            k(str, str2, str3);
            b(inputStream, this.eot);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest aX(String str, String str2) {
        return K(str).K(": ").K(str2).K("\r\n");
    }

    public HttpRequest K(CharSequence charSequence) {
        try {
            aVD();
            this.eot.lO(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL url() {
        return aVt().getURL();
    }

    public String method() {
        return aVt().getRequestMethod();
    }
}
