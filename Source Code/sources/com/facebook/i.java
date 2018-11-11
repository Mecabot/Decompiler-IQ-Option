package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.o;
import com.facebook.internal.q;
import com.facebook.internal.v;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.dto.Currencies;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GraphRequest */
public class i {
    public static final String TAG = "i";
    private static volatile String userAgent;
    private static final String xU;
    private static String xV;
    private static Pattern xW = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private Object tag;
    private String version;
    private a xX;
    private HttpMethod xY;
    private String xZ;
    private JSONObject ya;
    private String yb;
    private String yc;
    private boolean yd;
    private Bundle ye;
    private b yf;
    private String yg;
    private boolean yh;

    /* compiled from: GraphRequest */
    private static class a {
        private final Object value;
        private final i yo;

        public a(i iVar, Object obj) {
            this.yo = iVar;
            this.value = obj;
        }

        public i jz() {
            return this.yo;
        }

        public Object getValue() {
            return this.value;
        }
    }

    /* compiled from: GraphRequest */
    public interface b {
        void a(l lVar);
    }

    /* compiled from: GraphRequest */
    public interface c {
        void a(JSONObject jSONObject, l lVar);
    }

    /* compiled from: GraphRequest */
    private interface d {
        void t(String str, String str2);
    }

    /* compiled from: GraphRequest */
    public static class f<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<f> CREATOR = new Creator<f>() {
            /* renamed from: e */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            /* renamed from: K */
            public f[] newArray(int i) {
                return new f[i];
            }
        };
        private final String mimeType;
        private final RESOURCE yp;

        public int describeContents() {
            return 1;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public RESOURCE jA() {
            return this.yp;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.yp, i);
        }

        public f(RESOURCE resource, String str) {
            this.mimeType = str;
            this.yp = resource;
        }

        private f(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.yp = parcel.readParcelable(h.getApplicationContext().getClassLoader());
        }
    }

    /* compiled from: GraphRequest */
    public interface e extends b {
        void c(long j, long j2);
    }

    /* compiled from: GraphRequest */
    private static class g implements d {
        private final OutputStream outputStream;
        private final q yq;
        private boolean yr = true;
        private boolean ys = false;

        public g(OutputStream outputStream, q qVar, boolean z) {
            this.outputStream = outputStream;
            this.yq = qVar;
            this.ys = z;
        }

        public void a(String str, Object obj, i iVar) {
            if (this.outputStream instanceof s) {
                ((s) this.outputStream).d(iVar);
            }
            if (i.p(obj)) {
                t(str, i.q(obj));
            } else if (obj instanceof Bitmap) {
                b(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                b(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                a(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                a(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof f) {
                f fVar = (f) obj;
                Parcelable jA = fVar.jA();
                String mimeType = fVar.getMimeType();
                if (jA instanceof ParcelFileDescriptor) {
                    a(str, (ParcelFileDescriptor) jA, mimeType);
                } else if (jA instanceof Uri) {
                    a(str, (Uri) jA, mimeType);
                } else {
                    throw jB();
                }
            } else {
                throw jB();
            }
        }

        private RuntimeException jB() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a(String str, JSONArray jSONArray, Collection<i> collection) {
            if (this.outputStream instanceof s) {
                s sVar = (s) this.outputStream;
                b(str, null, null);
                b("[", new Object[0]);
                int i = 0;
                for (i iVar : collection) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    sVar.d(iVar);
                    if (i > 0) {
                        b(",%s", jSONObject.toString());
                    } else {
                        b(Currencies.REPLACE_CURRENCY_MASK, jSONObject.toString());
                    }
                    i++;
                }
                b("]", new Object[0]);
                if (this.yq != null) {
                    q qVar = this.yq;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("    ");
                    stringBuilder.append(str);
                    qVar.a(stringBuilder.toString(), jSONArray.toString());
                }
                return;
            }
            t(str, jSONArray.toString());
        }

        public void t(String str, String str2) {
            b(str, null, null);
            c(Currencies.REPLACE_CURRENCY_MASK, str2);
            jC();
            if (this.yq != null) {
                q qVar = this.yq;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                qVar.a(stringBuilder.toString(), str2);
            }
        }

        public void b(String str, Bitmap bitmap) {
            b(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
            c("", new Object[0]);
            jC();
            if (this.yq != null) {
                q qVar = this.yq;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                qVar.a(stringBuilder.toString(), "<Image>");
            }
        }

        public void b(String str, byte[] bArr) {
            b(str, str, "content/unknown");
            this.outputStream.write(bArr);
            c("", new Object[0]);
            jC();
            if (this.yq != null) {
                q qVar = this.yq;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                qVar.a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
        }

        public void a(String str, Uri uri, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            b(str, str, str2);
            if (this.outputStream instanceof q) {
                ((q) this.outputStream).s(w.f(uri));
                i = 0;
            } else {
                i = w.a(h.getApplicationContext().getContentResolver().openInputStream(uri), this.outputStream) + 0;
            }
            c("", new Object[0]);
            jC();
            if (this.yq != null) {
                q qVar = this.yq;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                qVar.a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void a(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            b(str, str, str2);
            if (this.outputStream instanceof q) {
                ((q) this.outputStream).s(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = w.a(new AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
            }
            c("", new Object[0]);
            jC();
            if (this.yq != null) {
                q qVar = this.yq;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("    ");
                stringBuilder.append(str);
                qVar.a(stringBuilder.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void jC() {
            if (this.ys) {
                this.outputStream.write("&".getBytes());
                return;
            }
            c("--%s", i.xU);
        }

        public void b(String str, String str2, String str3) {
            if (this.ys) {
                this.outputStream.write(String.format("%s=", new Object[]{str}).getBytes());
                return;
            }
            b("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                b("; filename=\"%s\"", str2);
            }
            c("", new Object[0]);
            if (str3 != null) {
                c("%s: %s", "Content-Type", str3);
            }
            c("", new Object[0]);
        }

        public void b(String str, Object... objArr) {
            if (this.ys) {
                this.outputStream.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
                return;
            }
            if (this.yr) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write(i.xU.getBytes());
                this.outputStream.write("\r\n".getBytes());
                this.yr = false;
            }
            this.outputStream.write(String.format(str, objArr).getBytes());
        }

        public void c(String str, Object... objArr) {
            b(str, objArr);
            if (!this.ys) {
                b("\r\n", new Object[0]);
            }
        }
    }

    static {
        char[] toCharArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(toCharArray[secureRandom.nextInt(toCharArray.length)]);
        }
        xU = stringBuilder.toString();
    }

    public i() {
        this(null, null, null, null, null);
    }

    public i(a aVar, String str, Bundle bundle, HttpMethod httpMethod) {
        this(aVar, str, bundle, httpMethod, null);
    }

    public i(a aVar, String str, Bundle bundle, HttpMethod httpMethod, b bVar) {
        this(aVar, str, bundle, httpMethod, bVar, null);
    }

    public i(a aVar, String str, Bundle bundle, HttpMethod httpMethod, b bVar, String str2) {
        this.yd = true;
        this.yh = false;
        this.xX = aVar;
        this.xZ = str;
        this.version = str2;
        a(bVar);
        a(httpMethod);
        if (bundle != null) {
            this.ye = new Bundle(bundle);
        } else {
            this.ye = new Bundle();
        }
        if (this.version == null) {
            this.version = h.iZ();
        }
    }

    public static i a(a aVar, final c cVar) {
        return new i(aVar, "me", null, null, new b() {
            public void a(l lVar) {
                if (cVar != null) {
                    cVar.a(lVar.jK(), lVar);
                }
            }
        });
    }

    public static i a(a aVar, String str, JSONObject jSONObject, b bVar) {
        i iVar = new i(aVar, str, null, HttpMethod.POST, bVar);
        iVar.d(jSONObject);
        return iVar;
    }

    public static i a(a aVar, String str, b bVar) {
        return new i(aVar, str, null, null, bVar);
    }

    public final JSONObject jk() {
        return this.ya;
    }

    public final void d(JSONObject jSONObject) {
        this.ya = jSONObject;
    }

    public final String jl() {
        return this.xZ;
    }

    public final HttpMethod jm() {
        return this.xY;
    }

    public final void a(HttpMethod httpMethod) {
        if (this.yg == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.xY = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void I(boolean z) {
        this.yh = z;
    }

    public final Bundle jn() {
        return this.ye;
    }

    public final void setParameters(Bundle bundle) {
        this.ye = bundle;
    }

    public final a jo() {
        return this.xX;
    }

    public final b jp() {
        return this.yf;
    }

    public final void a(final b bVar) {
        if (h.a(LoggingBehavior.GRAPH_API_DEBUG_INFO) || h.a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.yf = new b() {
                public void a(l lVar) {
                    JSONObject jK = lVar.jK();
                    jK = jK != null ? jK.optJSONObject("__debug__") : null;
                    JSONArray optJSONArray = jK != null ? jK.optJSONArray("messages") : null;
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            String optString = optJSONObject != null ? optJSONObject.optString("message") : null;
                            String optString2 = optJSONObject != null ? optJSONObject.optString(Param.TYPE) : null;
                            String optString3 = optJSONObject != null ? optJSONObject.optString("link") : null;
                            if (!(optString == null || optString2 == null)) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals("warning")) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!w.bc(optString3)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(optString);
                                    stringBuilder.append(" Link: ");
                                    stringBuilder.append(optString3);
                                    optString = stringBuilder.toString();
                                }
                                q.a(loggingBehavior, i.TAG, optString);
                            }
                        }
                    }
                    if (bVar != null) {
                        bVar.a(lVar);
                    }
                }
            };
        } else {
            this.yf = bVar;
        }
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final l jq() {
        return a(this);
    }

    public final j jr() {
        return b(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{Splitter: B:7:0x0023, ExcHandler: java.io.IOException (e java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b A:{Splitter: B:9:0x0027, ExcHandler: java.io.IOException (e java.io.IOException)} */
    /* JADX WARNING: Missing block: B:12:0x002b, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:13:0x002c, code:
            r0 = r1;
     */
    /* JADX WARNING: Missing block: B:14:0x002e, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:15:0x002f, code:
            com.facebook.internal.w.a(r0);
     */
    /* JADX WARNING: Missing block: B:16:0x0039, code:
            throw new com.facebook.FacebookException("could not construct request body", r2);
     */
    public static java.net.HttpURLConnection b(com.facebook.k r2) {
        /*
        g(r2);
        r0 = r2.size();	 Catch:{ MalformedURLException -> 0x003a }
        r1 = 1;
        if (r0 != r1) goto L_0x0019;
    L_0x000a:
        r0 = 0;
        r0 = r2.get(r0);	 Catch:{ MalformedURLException -> 0x003a }
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x003a }
        r0 = r0.ju();	 Catch:{ MalformedURLException -> 0x003a }
        r1.<init>(r0);	 Catch:{ MalformedURLException -> 0x003a }
        goto L_0x0022;
    L_0x0019:
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x003a }
        r0 = com.facebook.internal.v.mr();	 Catch:{ MalformedURLException -> 0x003a }
        r1.<init>(r0);	 Catch:{ MalformedURLException -> 0x003a }
    L_0x0022:
        r0 = 0;
        r1 = a(r1);	 Catch:{ IOException -> 0x002e, IOException -> 0x002e }
        a(r2, r1);	 Catch:{ IOException -> 0x002b, IOException -> 0x002b }
        return r1;
    L_0x002b:
        r2 = move-exception;
        r0 = r1;
        goto L_0x002f;
    L_0x002e:
        r2 = move-exception;
    L_0x002f:
        com.facebook.internal.w.a(r0);
        r0 = new com.facebook.FacebookException;
        r1 = "could not construct request body";
        r0.<init>(r1, r2);
        throw r0;
    L_0x003a:
        r2 = move-exception;
        r0 = new com.facebook.FacebookException;
        r1 = "could not construct URL for request";
        r0.<init>(r1, r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.i.b(com.facebook.k):java.net.HttpURLConnection");
    }

    public static l a(i iVar) {
        List a = a(iVar);
        if (a != null && a.size() == 1) {
            return (l) a.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<l> a(i... iVarArr) {
        x.a((Object) iVarArr, "requests");
        return a(Arrays.asList(iVarArr));
    }

    public static List<l> a(Collection<i> collection) {
        return c(new k((Collection) collection));
    }

    public static List<l> c(k kVar) {
        Throwable th;
        x.c((Collection) kVar, "requests");
        URLConnection uRLConnection = null;
        try {
            URLConnection b = b(kVar);
            try {
                List<l> a = a((HttpURLConnection) b, kVar);
                w.a(b);
                return a;
            } catch (Throwable th2) {
                th = th2;
                uRLConnection = b;
                w.a(uRLConnection);
                throw th;
            }
        } catch (Throwable e) {
            List a2 = l.a(kVar.jE(), null, new FacebookException(e));
            a(kVar, a2);
            w.a(null);
            return a2;
        } catch (Throwable th3) {
            th = th3;
            w.a(uRLConnection);
            throw th;
        }
    }

    public static j b(i... iVarArr) {
        x.a((Object) iVarArr, "requests");
        return b(Arrays.asList(iVarArr));
    }

    public static j b(Collection<i> collection) {
        return d(new k((Collection) collection));
    }

    public static j d(k kVar) {
        x.c((Collection) kVar, "requests");
        j jVar = new j(kVar);
        jVar.executeOnExecutor(h.getExecutor(), new Void[0]);
        return jVar;
    }

    public static List<l> a(HttpURLConnection httpURLConnection, k kVar) {
        List b = l.b(httpURLConnection, kVar);
        w.a((URLConnection) httpURLConnection);
        if (kVar.size() != b.size()) {
            throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(b.size()), Integer.valueOf(kVar.size())}));
        }
        a(kVar, b);
        c.iD().iH();
        return b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Request: ");
        stringBuilder.append(" accessToken: ");
        stringBuilder.append(this.xX == null ? "null" : this.xX);
        stringBuilder.append(", graphPath: ");
        stringBuilder.append(this.xZ);
        stringBuilder.append(", graphObject: ");
        stringBuilder.append(this.ya);
        stringBuilder.append(", httpMethod: ");
        stringBuilder.append(this.xY);
        stringBuilder.append(", parameters: ");
        stringBuilder.append(this.ye);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static void a(final k kVar, List<l> list) {
        int size = kVar.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            i L = kVar.get(i);
            if (L.yf != null) {
                arrayList.add(new Pair(L.yf, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            Runnable anonymousClass3 = new Runnable() {
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((b) pair.first).a((l) pair.second);
                    }
                    for (com.facebook.k.a a : kVar.getCallbacks()) {
                        a.a(kVar);
                    }
                }
            };
            Handler jD = kVar.jD();
            if (jD == null) {
                anonymousClass3.run();
            } else {
                jD.post(anonymousClass3);
            }
        }
    }

    private static HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", jx());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    private void js() {
        String token;
        if (this.xX != null) {
            if (!this.ye.containsKey("access_token")) {
                token = this.xX.getToken();
                q.bJ(token);
                this.ye.putString("access_token", token);
            }
        } else if (!(this.yh || this.ye.containsKey("access_token"))) {
            token = h.it();
            String jc = h.jc();
            if (w.bc(token) || w.bc(jc)) {
                w.E(TAG, "Warning: Request without access token missing application ID or client token.");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(token);
                stringBuilder.append("|");
                stringBuilder.append(jc);
                this.ye.putString("access_token", stringBuilder.toString());
            }
        }
        this.ye.putString("sdk", "android");
        this.ye.putString("format", "json");
        if (h.a(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.ye.putString("debug", "info");
        } else if (h.a(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.ye.putString("debug", "warning");
        }
    }

    private String a(String str, Boolean bool) {
        if (!bool.booleanValue() && this.xY == HttpMethod.POST) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.ye.keySet()) {
            Object obj = this.ye.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (p(obj)) {
                buildUpon.appendQueryParameter(str2, q(obj).toString());
            } else if (this.xY == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
            }
        }
        return buildUpon.toString();
    }

    final String jt() {
        if (this.yg != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String format = String.format("%s/%s", new Object[]{v.mr(), jv()});
        js();
        Uri parse = Uri.parse(a(format, Boolean.valueOf(true)));
        return String.format("%s?%s", new Object[]{parse.getPath(), parse.getQuery()});
    }

    final String ju() {
        if (this.yg != null) {
            return this.yg.toString();
        }
        String ms;
        if (jm() == HttpMethod.POST && this.xZ != null && this.xZ.endsWith("/videos")) {
            ms = v.ms();
        } else {
            ms = v.mr();
        }
        ms = String.format("%s/%s", new Object[]{ms, jv()});
        js();
        return a(ms, Boolean.valueOf(false));
    }

    private String jv() {
        if (xW.matcher(this.xZ).matches()) {
            return this.xZ;
        }
        return String.format("%s/%s", new Object[]{this.version, this.xZ});
    }

    private void a(JSONArray jSONArray, Map<String, a> map) {
        JSONObject jSONObject = new JSONObject();
        if (this.yb != null) {
            jSONObject.put("name", this.yb);
            jSONObject.put("omit_response_on_success", this.yd);
        }
        if (this.yc != null) {
            jSONObject.put("depends_on", this.yc);
        }
        String jt = jt();
        jSONObject.put("relative_url", jt);
        jSONObject.put(com.google.firebase.analytics.FirebaseAnalytics.b.METHOD, this.xY);
        if (this.xX != null) {
            q.bJ(this.xX.getToken());
        }
        Iterable arrayList = new ArrayList();
        for (String str : this.ye.keySet()) {
            Object obj = this.ye.get(str);
            if (o(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.ya != null) {
            final Iterable arrayList2 = new ArrayList();
            a(this.ya, jt, new d() {
                public void t(String str, String str2) {
                    arrayList2.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private static boolean e(k kVar) {
        for (com.facebook.k.a aVar : kVar.getCallbacks()) {
            if (aVar instanceof com.facebook.k.b) {
                return true;
            }
        }
        Iterator it = kVar.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).jp() instanceof e) {
                return true;
            }
        }
        return false;
    }

    private static void a(HttpURLConnection httpURLConnection, boolean z) {
        if (z) {
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            return;
        }
        httpURLConnection.setRequestProperty("Content-Type", jw());
    }

    private static boolean f(k kVar) {
        Iterator it = kVar.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            for (String str : iVar.ye.keySet()) {
                if (o(iVar.ye.get(str))) {
                    return false;
                }
            }
        }
        return true;
    }

    static final boolean b(i iVar) {
        String version = iVar.getVersion();
        boolean z = true;
        if (w.bc(version)) {
            return true;
        }
        if (version.startsWith("v")) {
            version = version.substring(1);
        }
        String[] split = version.split("\\.");
        if ((split.length < 2 || Integer.parseInt(split[0]) <= 2) && (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4)) {
            z = false;
        }
        return z;
    }

    static final void g(k kVar) {
        Iterator it = kVar.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (HttpMethod.GET.equals(iVar.jm()) && b(iVar)) {
                Bundle jn = iVar.jn();
                if (!jn.containsKey("fields") || w.bc(jn.getString("fields"))) {
                    q.a(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", iVar.jl());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d0  */
    static final void a(com.facebook.k r13, java.net.HttpURLConnection r14) {
        /*
        r6 = new com.facebook.internal.q;
        r0 = com.facebook.LoggingBehavior.REQUESTS;
        r1 = "Request";
        r6.<init>(r0, r1);
        r2 = r13.size();
        r5 = f(r13);
        r0 = 0;
        r1 = 1;
        if (r2 != r1) goto L_0x001c;
    L_0x0015:
        r3 = r13.get(r0);
        r3 = r3.xY;
        goto L_0x001e;
    L_0x001c:
        r3 = com.facebook.HttpMethod.POST;
    L_0x001e:
        r4 = r3.name();
        r14.setRequestMethod(r4);
        a(r14, r5);
        r4 = r14.getURL();
        r7 = "Request:\n";
        r6.append(r7);
        r7 = "Id";
        r8 = r13.getId();
        r6.a(r7, r8);
        r7 = "URL";
        r6.a(r7, r4);
        r7 = "Method";
        r8 = r14.getRequestMethod();
        r6.a(r7, r8);
        r7 = "User-Agent";
        r8 = "User-Agent";
        r8 = r14.getRequestProperty(r8);
        r6.a(r7, r8);
        r7 = "Content-Type";
        r8 = "Content-Type";
        r8 = r14.getRequestProperty(r8);
        r6.a(r7, r8);
        r7 = r13.getTimeout();
        r14.setConnectTimeout(r7);
        r7 = r13.getTimeout();
        r14.setReadTimeout(r7);
        r7 = com.facebook.HttpMethod.POST;
        if (r3 != r7) goto L_0x0071;
    L_0x0070:
        r0 = 1;
    L_0x0071:
        if (r0 != 0) goto L_0x0077;
    L_0x0073:
        r6.log();
        return;
    L_0x0077:
        r14.setDoOutput(r1);
        r0 = 0;
        r1 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00cc }
        r14 = r14.getOutputStream();	 Catch:{ all -> 0x00cc }
        r1.<init>(r14);	 Catch:{ all -> 0x00cc }
        if (r5 == 0) goto L_0x008f;
    L_0x0086:
        r14 = new java.util.zip.GZIPOutputStream;	 Catch:{ all -> 0x008c }
        r14.<init>(r1);	 Catch:{ all -> 0x008c }
        goto L_0x0090;
    L_0x008c:
        r13 = move-exception;
        r14 = r1;
        goto L_0x00ce;
    L_0x008f:
        r14 = r1;
    L_0x0090:
        r0 = e(r13);	 Catch:{ all -> 0x00ca }
        if (r0 == 0) goto L_0x00ba;
    L_0x0096:
        r0 = new com.facebook.q;	 Catch:{ all -> 0x00ca }
        r1 = r13.jD();	 Catch:{ all -> 0x00ca }
        r0.<init>(r1);	 Catch:{ all -> 0x00ca }
        r8 = 0;
        r7 = r13;
        r9 = r2;
        r10 = r4;
        r11 = r0;
        r12 = r5;
        a(r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x00ca }
        r1 = r0.jR();	 Catch:{ all -> 0x00ca }
        r10 = r0.jS();	 Catch:{ all -> 0x00ca }
        r0 = new com.facebook.r;	 Catch:{ all -> 0x00ca }
        r11 = (long) r1;	 Catch:{ all -> 0x00ca }
        r7 = r0;
        r8 = r14;
        r9 = r13;
        r7.<init>(r8, r9, r10, r11);	 Catch:{ all -> 0x00ca }
        r14 = r0;
    L_0x00ba:
        r0 = r13;
        r1 = r6;
        r3 = r4;
        r4 = r14;
        a(r0, r1, r2, r3, r4, r5);	 Catch:{ all -> 0x00ca }
        if (r14 == 0) goto L_0x00c6;
    L_0x00c3:
        r14.close();
    L_0x00c6:
        r6.log();
        return;
    L_0x00ca:
        r13 = move-exception;
        goto L_0x00ce;
    L_0x00cc:
        r13 = move-exception;
        r14 = r0;
    L_0x00ce:
        if (r14 == 0) goto L_0x00d3;
    L_0x00d0:
        r14.close();
    L_0x00d3:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.i.a(com.facebook.k, java.net.HttpURLConnection):void");
    }

    private static void a(k kVar, q qVar, int i, URL url, OutputStream outputStream, boolean z) {
        g gVar = new g(outputStream, qVar, z);
        Map hashMap;
        if (i == 1) {
            i L = kVar.get(0);
            hashMap = new HashMap();
            for (String str : L.ye.keySet()) {
                Object obj = L.ye.get(str);
                if (o(obj)) {
                    hashMap.put(str, new a(L, obj));
                }
            }
            if (qVar != null) {
                qVar.append("  Parameters:\n");
            }
            a(L.ye, gVar, L);
            if (qVar != null) {
                qVar.append("  Attachments:\n");
            }
            a(hashMap, gVar);
            if (L.ya != null) {
                a(L.ya, url.getPath(), (d) gVar);
                return;
            }
            return;
        }
        String h = h(kVar);
        if (w.bc(h)) {
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }
        gVar.t("batch_app_id", h);
        hashMap = new HashMap();
        a(gVar, (Collection) kVar, hashMap);
        if (qVar != null) {
            qVar.append("  Attachments:\n");
        }
        a(hashMap, gVar);
    }

    private static boolean bn(String str) {
        Matcher matcher = xW.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    private static void a(org.json.JSONObject r6, java.lang.String r7, com.facebook.i.d r8) {
        /*
        r0 = bn(r7);
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x001e;
    L_0x0008:
        r0 = ":";
        r0 = r7.indexOf(r0);
        r3 = "?";
        r7 = r7.indexOf(r3);
        r3 = 3;
        if (r0 <= r3) goto L_0x001e;
    L_0x0017:
        r3 = -1;
        if (r7 == r3) goto L_0x001c;
    L_0x001a:
        if (r0 >= r7) goto L_0x001e;
    L_0x001c:
        r7 = 1;
        goto L_0x001f;
    L_0x001e:
        r7 = 0;
    L_0x001f:
        r0 = r6.keys();
    L_0x0023:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0044;
    L_0x0029:
        r3 = r0.next();
        r3 = (java.lang.String) r3;
        r4 = r6.opt(r3);
        if (r7 == 0) goto L_0x003f;
    L_0x0035:
        r5 = "image";
        r5 = r3.equalsIgnoreCase(r5);
        if (r5 == 0) goto L_0x003f;
    L_0x003d:
        r5 = 1;
        goto L_0x0040;
    L_0x003f:
        r5 = 0;
    L_0x0040:
        a(r3, r4, r8, r5);
        goto L_0x0023;
    L_0x0044:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.i.a(org.json.JSONObject, java.lang.String, com.facebook.i$d):void");
    }

    private static void a(String str, Object obj, d dVar, boolean z) {
        Class cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Object[] objArr = new Object[]{str, (String) keys.next()};
                    a(String.format("%s[%s]", objArr), jSONObject.opt((String) keys.next()), dVar, z);
                }
            } else if (jSONObject.has("id")) {
                a(str, jSONObject.optString("id"), dVar, z);
            } else if (jSONObject.has(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                a(str, jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL), dVar, z);
            } else if (jSONObject.has("fbsdk:create_object")) {
                a(str, jSONObject.toString(), dVar, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                a(String.format(Locale.ROOT, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), dVar, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            dVar.t(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            dVar.t(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    private static void a(Bundle bundle, g gVar, i iVar) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (p(obj)) {
                gVar.a(str, obj, iVar);
            }
        }
    }

    private static void a(Map<String, a> map, g gVar) {
        for (String str : map.keySet()) {
            a aVar = (a) map.get(str);
            if (o(aVar.getValue())) {
                gVar.a(str, aVar.getValue(), aVar.jz());
            }
        }
    }

    private static void a(g gVar, Collection<i> collection, Map<String, a> map) {
        JSONArray jSONArray = new JSONArray();
        for (i a : collection) {
            a.a(jSONArray, (Map) map);
        }
        gVar.a("batch", jSONArray, (Collection) collection);
    }

    private static String jw() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{xU});
    }

    private static String jx() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{"FBAndroidSDK", "4.38.0"});
            if (!w.bc(o.mc())) {
                userAgent = String.format(Locale.ROOT, "%s/%s", new Object[]{userAgent, o.mc()});
            }
        }
        return userAgent;
    }

    private static String h(k kVar) {
        if (!w.bc(kVar.jF())) {
            return kVar.jF();
        }
        Iterator it = kVar.iterator();
        while (it.hasNext()) {
            a aVar = ((i) it.next()).xX;
            if (aVar != null) {
                String it2 = aVar.it();
                if (it2 != null) {
                    return it2;
                }
            }
        }
        if (w.bc(xV)) {
            return h.it();
        }
        return xV;
    }

    private static boolean o(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof f);
    }

    private static boolean p(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    private static String q(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}
