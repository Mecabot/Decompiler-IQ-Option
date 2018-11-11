package com.iqoption.core.connect.http;

import android.os.Build;
import android.os.Build.VERSION;
import com.iqoption.core.e;
import com.iqoption.core.f;
import io.reactivex.c.k;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.r;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

@i(aXC = {1, 1, 11}, aXD = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002VWB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0016JG\u00107\u001a\u0002H8\"\u0004\b\u0000\u001082\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H80<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\b\u0002\u0010@\u001a\u00020-¢\u0006\u0002\u0010AJH\u0010B\u001a\b\u0012\u0004\u0012\u0002H80C\"\u0004\b\u0000\u001082\u0006\u00109\u001a\u00020:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H80<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\b\u0002\u0010@\u001a\u00020-J\b\u0010D\u001a\u0004\u0018\u00010\"J\u0006\u0010E\u001a\u000206J\u0014\u0010F\u001a\u00020:*\u00020:2\b\b\u0002\u0010G\u001a\u00020\u0004J\u0014\u0010H\u001a\u00020:*\u00020:2\b\b\u0002\u0010G\u001a\u00020\u0004J\u001e\u0010I\u001a\u000206*\u00020(2\u0006\u0010J\u001a\u00020\u00042\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J.\u0010M\u001a\u00020:*\u00020:2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020L0QJ&\u0010M\u001a\u00020:*\u00020:2\u0006\u0010R\u001a\u00020\u00042\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020L0QJ\u0018\u0010S\u001a\u00020\"*\u00020\u00042\n\b\u0002\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010T\u001a\u00020:*\u00020:2\u0006\u0010G\u001a\u00020\u0004J\f\u0010U\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0018\u0010U\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020L0QH\u0002J\f\u00104\u001a\u00020:*\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u001d*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u00020(8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0002\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020-8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0002\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u00020-8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0002\u001a\u0004\b3\u00100R\u0016\u00104\u001a\n \u001d*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, aXE = {"Lcom/iqoption/core/connect/http/Http;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "ACCEPT_ENCODED", "", "ACCEPT_JSON", "AFF", "AFFTRACK", "CONNECT_TIMEOUT", "", "CONTENT_TYPE_JSON", "Lokhttp3/MediaType;", "getCONTENT_TYPE_JSON", "()Lokhttp3/MediaType;", "CONTENT_TYPE_TEXT", "getCONTENT_TYPE_TEXT", "FEATURES", "HEADER_ACCEPT", "HEADER_ACCEPT_X", "HEADER_SESSION_ID", "HEADER_USER_AGENT", "LANG", "PLATFORM", "PLATFORM_VERSION", "READ_TIMEOUT", "RETRACK", "SSID", "STAGING", "TAG", "kotlin.jvm.PlatformType", "WS_ROUTE", "X_ACTION", "appCookies", "", "Lokhttp3/Cookie;", "getAppCookies", "()Ljava/util/List;", "clientBuilderFactory", "Lcom/iqoption/core/connect/http/Http$ClientBuilderFactory;", "cookieJar", "Lcom/iqoption/core/connect/http/cookie/DecoratedCookieJar;", "cookieJar$annotations", "getCookieJar", "()Lcom/iqoption/core/connect/http/cookie/DecoratedCookieJar;", "noRedirectClient", "Lokhttp3/OkHttpClient;", "noRedirectClient$annotations", "getNoRedirectClient", "()Lokhttp3/OkHttpClient;", "secureClient", "secureClient$annotations", "getSecureClient", "userAgent", "clearOnLogout", "", "execute", "T", "builder", "Lokhttp3/Request$Builder;", "parser", "Lkotlin/Function1;", "validator", "Lio/reactivex/functions/Predicate;", "Lokhttp3/Response;", "client", "(Lokhttp3/Request$Builder;Lkotlin/jvm/functions/Function1;Lio/reactivex/functions/Predicate;Lokhttp3/OkHttpClient;)Ljava/lang/Object;", "executeSingle", "Lio/reactivex/Single;", "getSSIDCookie", "refreshAppCookies", "accept", "v", "acceptX", "addCookie", "name", "value", "", "addGetParams", "host", "path", "map", "", "url", "asCookie", "sessionId", "urlEncode", "ClientBuilderFactory", "ClientBuilderFactoryKitKat", "core_release"})
/* compiled from: Http.kt */
public final class b implements com.iqoption.core.f.a.a {
    private static final String TAG = "b";
    private static final MediaType aNF = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType aNG = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final com.iqoption.core.connect.http.cookie.b aNH = new com.iqoption.core.connect.http.cookie.b(new com.iqoption.core.connect.http.cookie.c(new com.iqoption.core.connect.http.cookie.a.c(), new com.iqoption.core.connect.http.cookie.persistence.b(f.RR())));
    private static final List<Cookie> aNI = aNH.St();
    private static final a aNJ;
    private static final OkHttpClient aNK;
    private static final OkHttpClient aNL;
    public static final b aNM;
    private static final String userAgent;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, aXE = {"Lcom/iqoption/core/connect/http/Http$ClientBuilderFactory;", "", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "factory", "Lokhttp3/OkHttpClient$Builder;", "getFactory", "()Lokhttp3/OkHttpClient$Builder;", "noSSLv3Factory", "getNoSSLv3Factory", "secureFactory", "getSecureFactory", "core_release"})
    /* compiled from: Http.kt */
    public static class a {
        private final CookieJar cookieJar;

        public a(CookieJar cookieJar) {
            h.e(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
        }

        public Builder Sr() {
            return Ss();
        }

        private final Builder Ss() {
            Builder readTimeout = new Builder().cookieJar(this.cookieJar).connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS);
            h.d(readTimeout, "OkHttpClient.Builder()\n …IMEOUT, TimeUnit.SECONDS)");
            return readTimeout;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, aXE = {"Lcom/iqoption/core/connect/http/Http$ClientBuilderFactoryKitKat;", "Lcom/iqoption/core/connect/http/Http$ClientBuilderFactory;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "noSSLv3Factory", "Lokhttp3/OkHttpClient$Builder;", "getNoSSLv3Factory", "()Lokhttp3/OkHttpClient$Builder;", "secureFactory", "getSecureFactory", "Companion", "core_release"})
    /* compiled from: Http.kt */
    public static final class b extends a {
        private static final com.iqoption.core.connect.http.a.b aNN = new com.iqoption.core.connect.http.a.b();
        private static com.iqoption.core.connect.http.a.a aNO = new com.iqoption.core.connect.http.a.a(aNN);
        private static com.iqoption.core.connect.http.a.c aNP = new com.iqoption.core.connect.http.a.c();
        public static final a aNQ = new a();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, aXE = {"Lcom/iqoption/core/connect/http/Http$ClientBuilderFactoryKitKat$Companion;", "", "()V", "noSSLv3SocketFactory", "Lcom/iqoption/core/connect/http/ssl/NoSSLv3SocketFactory;", "tlsSocketFactory", "Lcom/iqoption/core/connect/http/ssl/TLSSocketFactory;", "trustManager", "Lcom/iqoption/core/connect/http/ssl/x509TrustManager;", "core_release"})
        /* compiled from: Http.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public b(CookieJar cookieJar) {
            h.e(cookieJar, "cookieJar");
            super(cookieJar);
        }

        public Builder Sr() {
            Builder sslSocketFactory = super.Sr().sslSocketFactory(aNN, aNP);
            h.d(sslSocketFactory, "super.secureFactory\n    …ketFactory, trustManager)");
            return sslSocketFactory;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "T", "subscriber", "Lio/reactivex/SingleEmitter;", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: Http.kt */
    static final class c<T> implements r<T> {
        final /* synthetic */ Request.Builder aNR;
        final /* synthetic */ kotlin.jvm.a.b aNS;
        final /* synthetic */ k aNT;
        final /* synthetic */ OkHttpClient aNU;

        c(Request.Builder builder, kotlin.jvm.a.b bVar, k kVar, OkHttpClient okHttpClient) {
            this.aNR = builder;
            this.aNS = bVar;
            this.aNT = kVar;
            this.aNU = okHttpClient;
        }

        public final void a(p<T> pVar) {
            h.e(pVar, "subscriber");
            try {
                pVar.onSuccess(b.aNM.a(this.aNR, this.aNS, this.aNT, this.aNU));
            } catch (Throwable th) {
                pVar.onError(th);
            }
        }
    }

    static {
        a aVar;
        b bVar = new b();
        aNM = bVar;
        com.iqoption.core.b Dp = f.Dp();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Dp.getAppId());
        stringBuilder.append('/');
        stringBuilder.append(Dp.DL());
        stringBuilder.append('(');
        stringBuilder.append(Dp.getVersionCode());
        stringBuilder.append(")(Android ");
        stringBuilder.append(Build.DEVICE);
        stringBuilder.append('/');
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(")}");
        userAgent = URLEncoder.encode(stringBuilder.toString(), "UTF-8");
        if ((VERSION.SDK_INT >= 21 ? 1 : null) != null) {
            aVar = new a(aNH);
        } else {
            aVar = new b(aNH);
        }
        aNJ = aVar;
        com.iqoption.core.f.a.a(bVar);
        Builder Sr = aNJ.Sr();
        OkHttpClient build = Sr.build();
        h.d(build, "builder.build()");
        aNK = build;
        OkHttpClient build2 = Sr.followRedirects(false).build();
        h.d(build2, "builder.followRedirects(false).build()");
        aNL = build2;
        bVar.So();
    }

    private b() {
    }

    public final MediaType Sm() {
        return aNF;
    }

    public static final com.iqoption.core.connect.http.cookie.b Sn() {
        return aNH;
    }

    public final void So() {
        aNH.Su();
        com.iqoption.core.connect.http.cookie.b bVar = aNH;
        aNM.a(bVar, "platform", Integer.valueOf(f.Dp().DM()));
        aNM.a(bVar, "platform_version", f.Dp().DL());
        aNM.a(bVar, "lang", f.getLocale());
        aNM.a(bVar, "features", com.iqoption.core.f.f.aSE.getIdentity());
        aNM.a(bVar, "aff", f.Dp().DN());
        aNM.a(bVar, "afftrack", f.Dp().DK());
        aNM.a(bVar, "retrack", f.Dp().DO());
        if (f.Dp().DJ()) {
            if (e.aMr.RN()) {
                aNM.a(bVar, "ws_route", e.aMr.RO());
            }
            if (e.aMr.RL()) {
                aNM.a(bVar, "staging", e.aMr.RM());
            }
        }
    }

    private final void a(com.iqoption.core.connect.http.cookie.b bVar, String str, Object obj) {
        if (obj != null) {
            bVar.a(k(str, obj));
        }
    }

    private final Cookie k(String str, Object obj) {
        Cookie build = new Cookie.Builder().name(str).value(String.valueOf(obj)).domain(com.iqoption.core.connect.config.b.Sf().getHost()).build();
        h.d(build, "Cookie.Builder().name(th…n(apiConfig.host).build()");
        return build;
    }

    public static final OkHttpClient Sp() {
        return aNK;
    }

    public void Js() {
        aNH.clear();
    }

    public static /* bridge */ /* synthetic */ Object a(b bVar, Request.Builder builder, kotlin.jvm.a.b bVar2, k kVar, OkHttpClient okHttpClient, int i, Object obj) {
        if ((i & 4) != 0) {
            kVar = a.aNE;
        }
        if ((i & 8) != 0) {
            okHttpClient = aNK;
        }
        return bVar.a(builder, bVar2, kVar, okHttpClient);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x018f A:{Splitter: B:1:0x0021, ExcHandler: com.iqoption.core.connect.http.HttpException (r9_8 'e' com.iqoption.core.connect.http.HttpException)} */
    /* JADX WARNING: Missing block: B:24:0x018f, code:
            r9 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:0x0192, code:
            throw r9;
     */
    public final <T> T a(okhttp3.Request.Builder r9, kotlin.jvm.a.b<? super java.lang.String, ? extends T> r10, io.reactivex.c.k<okhttp3.Response> r11, okhttp3.OkHttpClient r12) {
        /*
        r8 = this;
        r0 = "builder";
        kotlin.jvm.internal.h.e(r9, r0);
        r0 = "parser";
        kotlin.jvm.internal.h.e(r10, r0);
        r0 = "validator";
        kotlin.jvm.internal.h.e(r11, r0);
        r0 = "client";
        kotlin.jvm.internal.h.e(r12, r0);
        r9 = r8.a(r9);
        r9 = r9.build();
        r7 = r9.url();
        r0 = TAG;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1.<init>();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r2 = "out --> HTTP request ";
        r1.append(r2);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r2 = r9.url();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1.append(r2);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r2 = ": ";
        r1.append(r2);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r2 = r9.method();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1.append(r2);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = r1.toString();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        com.iqoption.core.i.d(r0, r1);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = r12.newCall(r9);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = r12.execute();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = r11.test(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        if (r11 != 0) goto L_0x00a4;
    L_0x0055:
        r10 = r12.code();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = r12.message();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = TAG;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0.<init>();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = "in <-- HTTP request ";
        r0.append(r1);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = r9.url();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0.append(r1);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = ": invalid, ";
        r0.append(r1);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0.append(r10);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = 47;
        r0.append(r1);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0.append(r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0 = r0.toString();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        com.iqoption.core.i.d(r12, r0);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = new com.iqoption.core.connect.http.HttpException;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0 = new com.iqoption.core.connect.j;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r0.<init>(r10, r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = r0;
        r1 = (com.iqoption.core.connect.c) r1;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r10 = "url";
        kotlin.jvm.internal.h.d(r7, r10);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r3 = 0;
        r4 = 0;
        r5 = 12;
        r6 = 0;
        r0 = r12;
        r2 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = (java.lang.Throwable) r12;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        throw r12;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
    L_0x00a4:
        r11 = r12.body();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        if (r11 == 0) goto L_0x00af;
    L_0x00aa:
        r11 = r11.string();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        goto L_0x00b0;
    L_0x00af:
        r11 = 0;
    L_0x00b0:
        if (r11 == 0) goto L_0x011d;
    L_0x00b2:
        r12 = TAG;	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r0.<init>();	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r1 = "in <-- HTTP request ";
        r0.append(r1);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r1 = r9.url();	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r0.append(r1);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r1 = ": ";
        r0.append(r1);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r0.append(r11);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        com.iqoption.core.i.d(r12, r0);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        r10 = r10.invoke(r11);	 Catch:{ Throwable -> 0x00d9, HttpException -> 0x018f }
        return r10;
    L_0x00d9:
        r10 = move-exception;
        r4 = r10;
        r10 = TAG;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11.<init>();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = "in <-- HTTP request ";
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = r9.url();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = ": error during parsing body";
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = r11.toString();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        com.iqoption.core.i.d(r10, r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r10 = new com.iqoption.core.connect.http.HttpException;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = com.iqoption.core.connect.i.aMR;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = r11;
        r1 = (com.iqoption.core.connect.c) r1;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = "url";
        kotlin.jvm.internal.h.d(r7, r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r3 = 0;
        r5 = 4;
        r6 = 0;
        r0 = r10;
        r2 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = "error during parsing body";
        com.crashlytics.android.a.log(r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = r10;
        r11 = (java.lang.Throwable) r11;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        com.crashlytics.android.a.c(r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r10 = (java.lang.Throwable) r10;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        throw r10;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
    L_0x011d:
        r10 = TAG;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = new java.lang.StringBuilder;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11.<init>();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = "in <-- HTTP request ";
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = r9.url();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = ": body is null";
        r11.append(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r11 = r11.toString();	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        com.iqoption.core.i.d(r10, r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r10 = new com.iqoption.core.connect.http.HttpException;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r1 = 0;
        r11 = "url";
        kotlin.jvm.internal.h.d(r7, r11);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r3 = 0;
        r11 = new java.lang.Exception;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r12 = "Response body is null";
        r11.<init>(r12);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r4 = r11;
        r4 = (java.lang.Throwable) r4;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r5 = 5;
        r6 = 0;
        r0 = r10;
        r2 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        r10 = (java.lang.Throwable) r10;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
        throw r10;	 Catch:{ HttpException -> 0x018f, Throwable -> 0x015a }
    L_0x015a:
        r10 = move-exception;
        r4 = r10;
        r10 = TAG;
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "in <-- HTTP request ";
        r11.append(r12);
        r9 = r9.url();
        r11.append(r9);
        r9 = ": error";
        r11.append(r9);
        r9 = r11.toString();
        com.iqoption.core.i.d(r10, r9);
        r9 = new com.iqoption.core.connect.http.HttpException;
        r1 = 0;
        r10 = "url";
        kotlin.jvm.internal.h.d(r7, r10);
        r3 = 0;
        r5 = 5;
        r6 = 0;
        r0 = r9;
        r2 = r7;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r9 = (java.lang.Throwable) r9;
        throw r9;
    L_0x018f:
        r9 = move-exception;
        r9 = (java.lang.Throwable) r9;
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.http.b.a(okhttp3.Request$Builder, kotlin.jvm.a.b, io.reactivex.c.k, okhttp3.OkHttpClient):T");
    }

    public static /* bridge */ /* synthetic */ o b(b bVar, Request.Builder builder, kotlin.jvm.a.b bVar2, k kVar, OkHttpClient okHttpClient, int i, Object obj) {
        if ((i & 4) != 0) {
            kVar = a.aNE;
        }
        if ((i & 8) != 0) {
            okHttpClient = aNK;
        }
        return bVar.b(builder, bVar2, kVar, okHttpClient);
    }

    public final <T> o<T> b(Request.Builder builder, kotlin.jvm.a.b<? super String, ? extends T> bVar, k<Response> kVar, OkHttpClient okHttpClient) {
        h.e(builder, "builder");
        h.e(bVar, "parser");
        h.e(kVar, "validator");
        h.e(okHttpClient, "client");
        o<T> a = o.a((r) new c(builder, bVar, kVar, okHttpClient));
        h.d(a, "Single\n                .…      }\n                }");
        return a;
    }

    public final Cookie Sq() {
        String clusterApi = f.RQ().Du().getClusterApi();
        HttpUrl parse = HttpUrl.parse(clusterApi);
        if (parse == null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find SSID because parsing request for coreApi: ");
            stringBuilder.append(clusterApi);
            stringBuilder.append(" is failed");
            com.iqoption.core.i.d(str, stringBuilder.toString());
            return null;
        }
        for (Object next : aNH.loadForRequest(parse)) {
            if (h.E(((Cookie) next).name(), "ssid")) {
                break;
            }
        }
        Object next2 = null;
        return (Cookie) next2;
    }

    private final Request.Builder a(Request.Builder builder) {
        builder = builder.addHeader("User-Agent", userAgent);
        h.d(builder, "addHeader(HEADER_USER_AGENT, userAgent)");
        return builder;
    }

    public static /* bridge */ /* synthetic */ Request.Builder a(b bVar, Request.Builder builder, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "application/json, */*";
        }
        return bVar.a(builder, str);
    }

    public final Request.Builder a(Request.Builder builder, String str) {
        h.e(builder, "$receiver");
        h.e(str, "v");
        builder = builder.addHeader("Accept", str);
        h.d(builder, "addHeader(HEADER_ACCEPT, v)");
        return builder;
    }

    public static /* bridge */ /* synthetic */ Request.Builder b(b bVar, Request.Builder builder, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "bulk";
        }
        return bVar.b(builder, str);
    }

    public final Request.Builder b(Request.Builder builder, String str) {
        h.e(builder, "$receiver");
        h.e(str, "v");
        builder = builder.addHeader("X-Action", str);
        h.d(builder, "addHeader(HEADER_ACCEPT_X, v)");
        return builder;
    }

    public final Request.Builder a(Request.Builder builder, String str, String str2, Map<String, ? extends Object> map) {
        h.e(builder, "$receiver");
        h.e(str, "host");
        h.e(str2, "path");
        h.e(map, "map");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        if ((map.isEmpty() ^ 1) != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append('?');
            stringBuilder2.append(u(map));
            str = stringBuilder2.toString();
        } else {
            str = "";
        }
        stringBuilder.append(str);
        builder = builder.url(stringBuilder.toString());
        h.d(builder, "url(\"$host$path${if (map….urlEncode()}\" else \"\"}\")");
        return builder;
    }

    private final String u(Map<String, ? extends Object> map) {
        Collection arrayList = new ArrayList();
        for (Object next : map.entrySet()) {
            Entry entry = (Entry) next;
            Object obj = null;
            if ((((CharSequence) entry.getKey()).length() > 0 ? 1 : null) != null) {
                if ((((CharSequence) entry.getValue().toString()).length() > 0 ? 1 : null) != null) {
                    obj = 1;
                }
            }
            if (obj != null) {
                arrayList.add(next);
            }
        }
        return gf(u.a((List) arrayList, "&", null, null, 0, null, Http$urlEncode$2.aNV, 30, null));
    }

    private final String gf(String str) {
        str = com.google.common.d.b.vo().escape(str);
        h.d(str, "UrlEscapers.urlPathSegmentEscaper().escape(this)");
        return str;
    }
}
