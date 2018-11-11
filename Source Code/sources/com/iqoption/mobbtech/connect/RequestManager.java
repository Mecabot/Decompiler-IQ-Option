package com.iqoption.mobbtech.connect;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.common.base.e;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.connect.http.a.c;
import com.iqoption.core.i;
import com.iqoption.microservice.configuration.f;
import com.iqoption.util.ax;
import com.iqoption.util.k;
import io.card.payment.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestManager {
    private static final String TAG = "com.iqoption.mobbtech.connect.RequestManager";
    public static final long cTJ = TimeUnit.DAYS.toMillis(6);
    private static volatile RequestManager cTK;
    public static String cTN;
    public static final MediaType cTO = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType cTP = MediaType.parse("text/x-markdown; charset=utf-8");
    private final com.iqoption.core.connect.http.cookie.b aNH = com.iqoption.core.connect.http.b.Sn();
    private final a cTL;
    private final OkHttpClient cTM;
    private final OkHttpClient client;

    public enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH,
        MULTIPART,
        POST_JSON
    }

    static class a {
        final CookieJar cookieJar;

        a(CookieJar cookieJar) {
            this.cookieJar = cookieJar;
        }

        Builder atY() {
            return new Builder().cookieJar(this.cookieJar).connectTimeout(60000, TimeUnit.MILLISECONDS).readTimeout(60000, TimeUnit.MILLISECONDS);
        }

        Builder atZ() {
            return atY();
        }

        Builder Sr() {
            return atY();
        }
    }

    static class b extends a {
        private static SSLSocketFactory cTR;
        private static SSLSocketFactory cTS;
        private static X509TrustManager trustManager;

        static {
            try {
                cTR = new com.iqoption.core.connect.http.a.b();
                cTS = new com.iqoption.core.connect.http.a.a(cTR);
                trustManager = new c();
            } catch (Throwable e) {
                k.c(e);
            }
        }

        b(CookieJar cookieJar) {
            super(cookieJar);
        }

        Builder atZ() {
            return super.atZ().sslSocketFactory(cTS, trustManager);
        }

        Builder Sr() {
            return super.Sr().sslSocketFactory(cTR, trustManager);
        }
    }

    private boolean it(String str) {
        return false;
    }

    public static synchronized void initialize() {
        synchronized (RequestManager.class) {
            synchronized (RequestManager.class) {
                cTK = new RequestManager();
            }
        }
    }

    public static synchronized RequestManager atO() {
        RequestManager requestManager;
        synchronized (RequestManager.class) {
            if (cTK == null) {
                synchronized (RequestManager.class) {
                    if (cTK == null) {
                        cTK = new RequestManager();
                    }
                }
            }
            requestManager = cTK;
        }
        return requestManager;
    }

    public RequestManager() {
        if (ax.dws) {
            this.cTL = new a(this.aNH);
        } else {
            this.cTL = new b(this.aNH);
        }
        Builder Sr = this.cTL.Sr();
        this.client = Sr.build();
        this.cTM = Sr.followRedirects(false).build();
    }

    public Builder atP() {
        return this.cTL.atZ();
    }

    public OkHttpClient atQ() {
        return this.client;
    }

    public Response a(Request request, boolean z) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApiPath call ");
        stringBuilder.append(request.url());
        i.v(str, stringBuilder.toString());
        if (z) {
            return this.client.newCall(request).execute();
        }
        return this.cTM.newCall(request).execute();
    }

    private Cookie atR() {
        String in = IQApp.Dl().in("findSSIDCookie");
        List<Cookie> loadForRequest = this.aNH.loadForRequest(HttpUrl.parse(in));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ssid sssing=");
        stringBuilder.append(loadForRequest.toString());
        stringBuilder.append(" for ");
        stringBuilder.append(in);
        i.d(stringBuilder.toString());
        synchronized (this) {
            in = IQApp.Dl().in("findSSIDCookie (sync)");
            for (Cookie cookie : loadForRequest) {
                if (in.contains(cookie.domain()) && cookie.name().equalsIgnoreCase("ssid")) {
                    return cookie;
                }
            }
            return null;
        }
    }

    public String atS() {
        Cookie atR = atR();
        if (atR == null) {
            return null;
        }
        return atR.value();
    }

    public boolean atT() {
        Cookie atR = atR();
        long j = af.getLong("a63e971afa3e");
        return atR != null && (j == 0 || System.currentTimeMillis() - j < cTJ);
    }

    public void ir(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("add cookie -== ");
        stringBuilder.append(str == null ? "null" : str);
        stringBuilder.append(" ==-");
        i.d(str2, stringBuilder.toString());
        str2 = IQApp.Dl().getClusterApi();
        List arrayList = new ArrayList();
        HttpUrl parse = HttpUrl.parse(str2);
        arrayList.add(new Cookie.Builder().name("ssid").value(str).domain(parse.host()).expiresAt(Long.MAX_VALUE).build());
        this.aNH.saveFromResponse(parse, arrayList);
    }

    public void atU() {
        String clusterApi = IQApp.Dl().getClusterApi();
        List arrayList = new ArrayList();
        HttpUrl parse = HttpUrl.parse(clusterApi);
        arrayList.add(new Cookie.Builder().name("is_regulated").value("1").domain(parse.host()).expiresAt(Long.MAX_VALUE).build());
        this.aNH.saveFromResponse(parse, arrayList);
    }

    public void atV() {
        i.d("--- clearAllCookie ---");
        this.aNH.clear();
    }

    public void atW() {
        i.d("--- clearSSIDCookie ---");
        List<Cookie> loadForRequest = this.aNH.loadForRequest(HttpUrl.parse(IQApp.Dl().in("--- clearSSIDCookie ---")));
        synchronized (this) {
            for (Cookie cookie : loadForRequest) {
                if (cookie.name().equalsIgnoreCase("ssid")) {
                    this.aNH.b(cookie);
                    break;
                }
            }
        }
        af.setLong("a63e971afa3e", 0);
    }

    public void is(String str) {
        i.d("--- clearSSIDCookie ---");
        List<Cookie> loadForRequest = this.aNH.loadForRequest(HttpUrl.parse(IQApp.Dl().getClusterApi()));
        synchronized (this) {
            for (Cookie cookie : loadForRequest) {
                if (cookie.name().equalsIgnoreCase(str)) {
                    this.aNH.b(cookie);
                    break;
                }
            }
        }
    }

    public void bB(Context context) {
        if (context != null) {
            f Dl = IQApp.Dl();
            HttpUrl parse = HttpUrl.parse(Dl.arU() ? Dl.getClusterApi() : "https://iqoption.com/");
            Object locale = com.iqoption.core.f.getLocale();
            af aR = af.aR(context);
            Object EF = aR.EF();
            long EG = aR.EG();
            if (!TextUtils.isEmpty(EF) && System.currentTimeMillis() - EG > 86400000) {
                EF = null;
                aR.ez(null);
            }
            Object obj = BuildConfig.PRODUCT_VERSION;
            Object bC = bC(context);
            Object bD = bD(context);
            if (!it("platform")) {
                this.aNH.a(new Cookie.Builder().name("platform").value(Integer.toString(17)).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty(locale) || it("lang"))) {
                this.aNH.a(new Cookie.Builder().name("lang").value(locale).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty(bC) || it("aff"))) {
                this.aNH.a(new Cookie.Builder().name("aff").value(bC).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty(bD) || it("afftrack"))) {
                this.aNH.a(new Cookie.Builder().name("afftrack").value(bD).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty(EF) || it("retrack"))) {
                this.aNH.a(new Cookie.Builder().name("retrack").value(EF).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty(obj) || it("platform_version"))) {
                this.aNH.a(new Cookie.Builder().name("platform_version").value(obj).domain(parse.host()).build());
            }
            if (!(TextUtils.isEmpty("") || it("ws_route"))) {
                this.aNH.a(new Cookie.Builder().name("ws_route").value("").domain(parse.host()).build());
            }
            bD = af.DX().FA();
            if (!TextUtils.isEmpty(bD)) {
                this.aNH.a(new Cookie.Builder().name("features").value(bD).domain(parse.host()).build());
            }
        }
    }

    public static String bC(Context context) {
        if (TextUtils.isEmpty("")) {
            return af.aR(context).DN();
        }
        return "";
    }

    public static String bD(Context context) {
        return af.aR(context).EE();
    }

    public static Request e(String str, Context context) {
        return a(str, null, context);
    }

    public static Request a(String str, HashMap<String, Object> hashMap, Context context) {
        return a(str, null, (HashMap) hashMap, context);
    }

    public static Request a(String str, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Context context) {
        return a(str, (HashMap) hashMap, (HashMap) hashMap2, Method.GET, context);
    }

    public static Request b(String str, HashMap<String, Object> hashMap, Context context) {
        return a(str, null, (HashMap) hashMap, Method.POST, context);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Context context, Class<T> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), (HashMap) hashMap, (HashMap) hashMap2, Method.POST, context), str2);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Context context, Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a(type, a(stringBuilder.toString(), (HashMap) hashMap, (HashMap) hashMap2, Method.POST, context), str2);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, Context context, Class<T> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), null, (HashMap) hashMap, Method.POST, context), str2);
    }

    public static <T> s<T> a(String str, String str2, ImmutableMultimap<String, ?> immutableMultimap, Context context, Class<T> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), (ImmutableMultimap) immutableMultimap, context), str2);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, String str3, Context context, Class<T> cls, @Nullable String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), (HashMap) hashMap, str3, Method.POST, context, str4), str2);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, String str3, Context context, Type type, @Nullable String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a(type, a(stringBuilder.toString(), (HashMap) hashMap, str3, Method.POST, context, str4), str2);
    }

    public static <T> s<T> a(String str, String str2, Context context, Class<T> cls) {
        return b(str, str2, null, context, cls);
    }

    public static <T> s<T> b(String str, String str2, HashMap<String, Object> hashMap, Context context, Class<T> cls) {
        return a(str, str2, (HashMap) hashMap, context, (Class) cls, str2);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, Context context, Class<T> cls, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), (HashMap) hashMap, context), str3);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Context context, Class<T> cls, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a((Class) cls, a(stringBuilder.toString(), (HashMap) hashMap, (HashMap) hashMap2, context), str3);
    }

    public static <T> s<T> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Context context, Type type, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return a(type, a(stringBuilder.toString(), (HashMap) hashMap, (HashMap) hashMap2, context), str3);
    }

    @NonNull
    private static <T> s<T> a(Class<T> cls, Request request, String str) {
        return new com.iqoption.mobbtech.connect.request.a.a.k((Class) cls, request, str).auF();
    }

    @NonNull
    private static <T> s<T> a(Type type, Request request, String str) {
        return new com.iqoption.mobbtech.connect.request.a.a.k(type, request, str).auF();
    }

    private static Request a(String str, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Method method, Context context) {
        atO().bB(context);
        Request.Builder builder = new Request.Builder();
        switch (method) {
            case GET:
                if (!(hashMap2 == null || hashMap2.isEmpty())) {
                    str = String.format("%s?%s", new Object[]{str, e(hashMap2)});
                }
                builder.url(str);
                break;
            case POST:
                builder.url(str);
                builder.post(f(hashMap2));
                break;
            case DELETE:
                builder.url(str);
                builder.delete();
                break;
        }
        builder.addHeader("User-Agent", jx());
        builder.addHeader("Accept", "application/json, */*");
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (String str2 : hashMap.keySet()) {
                builder.addHeader(str2, String.valueOf(hashMap.get(str2)));
            }
        }
        return builder.build();
    }

    private static Request a(String str, HashMap<String, Object> hashMap, String str2, Method method, Context context, String str3) {
        atO().bB(context);
        Request.Builder builder = new Request.Builder();
        if (AnonymousClass1.cTQ[method.ordinal()] != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("json is not supported for ");
            stringBuilder.append(method);
            throw new RuntimeException(stringBuilder.toString());
        }
        builder.url(str);
        builder.post(RequestBody.create(cTO, str2));
        builder.addHeader("User-Agent", jx());
        builder.addHeader("Accept", "application/json, */*");
        if (!TextUtils.isEmpty(str3)) {
            builder.addHeader("Session-Id", str3);
        }
        if (hashMap != null) {
            for (String str22 : hashMap.keySet()) {
                builder.addHeader(str22, String.valueOf(hashMap.get(str22)));
            }
        }
        return builder.build();
    }

    public static Request a(String str, ImmutableMultimap<String, ?> immutableMultimap, Context context) {
        atO().bB(context);
        Request.Builder builder = new Request.Builder();
        builder.url(str);
        builder.post(a(immutableMultimap));
        builder.addHeader("User-Agent", jx());
        builder.addHeader("Accept", "application/json, */*");
        return builder.build();
    }

    public static String ar(String str, String str2) {
        return i(null, str, str2);
    }

    public static String i(String str, String str2, String str3) {
        HttpUrl parse = HttpUrl.parse(IQApp.Dl().in(str2 != null ? str2 : str));
        if (str == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(parse.scheme());
            stringBuilder.append("://");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str2);
        stringBuilder2.append(parse.host());
        stringBuilder2.append("/");
        stringBuilder2.append(str3);
        return stringBuilder2.toString();
    }

    public static String jx() {
        if (TextUtils.isEmpty(cTN)) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("com.iqoption.x");
                stringBuilder.append("/");
                stringBuilder.append(BuildConfig.PRODUCT_VERSION);
                stringBuilder.append("(");
                stringBuilder.append(388);
                stringBuilder.append(")");
                stringBuilder.append("(Android ");
                stringBuilder.append(Build.DEVICE);
                stringBuilder.append("/");
                stringBuilder.append(VERSION.RELEASE);
                stringBuilder.append(")");
                cTN = URLEncoder.encode(stringBuilder.toString(), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return cTN;
            }
        }
    }

    protected static String e(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : hashMap.entrySet()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(String.format("%s=%s", new Object[]{URLEncoder.encode(entry.getKey().toString(), "UTF-8"), URLEncoder.encode(entry.getValue().toString(), "UTF-8")}));
            }
        } catch (Exception unused) {
            return stringBuilder.toString();
        }
    }

    private static RequestBody f(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return atX();
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Entry entry : hashMap.entrySet()) {
            builder.add((String) entry.getKey(), e.h(entry.getValue(), "").toString());
        }
        return builder.build();
    }

    private static RequestBody a(ImmutableMultimap<String, ?> immutableMultimap) {
        if (immutableMultimap == null || immutableMultimap.isEmpty()) {
            return atX();
        }
        FormBody.Builder builder = new FormBody.Builder();
        Iterator sI = immutableMultimap.keySet().iterator();
        while (sI.hasNext()) {
            String str = (String) sI.next();
            Iterator sI2 = immutableMultimap.R(str).iterator();
            while (sI2.hasNext()) {
                builder.add(str, sI2.next().toString());
            }
        }
        return builder.build();
    }

    private static RequestBody atX() {
        return RequestBody.create(cTP, " ");
    }
}
