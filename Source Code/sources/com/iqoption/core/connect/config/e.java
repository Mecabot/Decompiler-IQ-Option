package com.iqoption.core.connect.config;

import com.iqoption.core.connect.a.b;
import com.iqoption.core.e.c;
import com.iqoption.core.f;
import com.iqoption.dto.entity.position.Position;
import java.io.File;
import kotlin.e.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import okhttp3.HttpUrl;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001OB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010F\u001a\u00020GJ\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00160IJ\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160IH\u0002J\b\u0010K\u001a\u00020\u0016H\u0002J\b\u0010L\u001a\u00020\u0016H\u0002J\u0010\u0010M\u001a\u00020G2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010N\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168B@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\nR\u0014\u0010+\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\nR\u0014\u0010-\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\nR\u0014\u0010/\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\nR\u001b\u00101\u001a\u00020\u00068VX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b2\u0010\nR\u0014\u00105\u001a\u0002068VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00107R\u0011\u00108\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b8\u00107R\u0014\u00109\u001a\u0002068VX\u0004¢\u0006\u0006\u001a\u0004\b9\u00107R(\u0010;\u001a\u0004\u0018\u0001062\b\u0010:\u001a\u0004\u0018\u0001068V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\nR\u0014\u0010B\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\nR\u0014\u0010D\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\n¨\u0006P"}, aXE = {"Lcom/iqoption/core/connect/config/RealApiConfig;", "Lcom/iqoption/core/connect/config/ApiConfig;", "()V", "CONFIG_FILE", "Ljava/io/File;", "TAG", "", "kotlin.jvm.PlatformType", "authApi", "getAuthApi", "()Ljava/lang/String;", "avatarsApi", "getAvatarsApi", "billingApi", "getBillingApi", "chatApi", "getChatApi", "clusterApi", "getClusterApi", "clusterWebSocket", "getClusterWebSocket", "<set-?>", "Lcom/iqoption/core/connect/dto/Configuration;", "config", "getConfig", "()Lcom/iqoption/core/connect/dto/Configuration;", "setConfig", "(Lcom/iqoption/core/connect/dto/Configuration;)V", "config$delegate", "Lkotlin/properties/ReadWriteProperty;", "coreApi", "getCoreApi", "debugCoreApi", "getDebugCoreApi", "setDebugCoreApi", "(Ljava/lang/String;)V", "default", "getDefault", "()Lcom/iqoption/core/connect/config/ApiConfig;", "default$delegate", "Lkotlin/Lazy;", "eventApi", "getEventApi", "featuresApi", "getFeaturesApi", "finInfoApi", "getFinInfoApi", "gatewayApi", "getGatewayApi", "host", "getHost", "host$delegate", "Lcom/iqoption/core/connect/config/RealApiConfig$HostDelegate;", "isAuthorized", "", "()Z", "isLoaded", "isUnauthorized", "value", "tc", "getTc", "()Ljava/lang/Boolean;", "setTc", "(Ljava/lang/Boolean;)V", "userVerificationApi", "getUserVerificationApi", "userVerifyApi", "getUserVerifyApi", "walletReferralApi", "getWalletReferralApi", "clear", "", "load", "Lio/reactivex/Single;", "loadConfiguration", "loadFromFile", "loadFromServer", "saveToFile", "fix", "HostDelegate", "core_release"})
/* compiled from: ApiConfig.kt */
public final class e implements a {
    private static final String TAG = "e";
    private static final File aNr = new File(f.RR().getFilesDir(), "api.cfg");
    private static String aNs;
    private static final d aNt = c.bg(null);
    private static final kotlin.d aNu = g.f(RealApiConfig$default$2.aNy);
    private static final a aNv = new a();
    public static final e aNw = new e();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "config", "getConfig()Lcom/iqoption/core/connect/dto/Configuration;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), Position.CLOSE_REASON_DEFAULT, "getDefault()Lcom/iqoption/core/connect/config/ApiConfig;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "host", "getHost()Ljava/lang/String;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/connect/config/RealApiConfig$HostDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "", "", "()V", "lastCoreApi", "value", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "core_release"})
    /* compiled from: ApiConfig.kt */
    private static final class a {
        private String aNx;
        private String value;

        public String a(Object obj, j<?> jVar) {
            h.e(obj, "thisRef");
            h.e(jVar, "property");
            if ((h.E(this.aNx, e.aNw.Sd()) ^ 1) != 0) {
                HttpUrl parse = HttpUrl.parse(e.aNw.Sd());
                this.value = parse != null ? parse.host() : null;
                this.aNx = e.aNw.Sd();
            }
            String str = this.value;
            return str != null ? str : e.aNw.Si().getHost();
        }
    }

    private final b Sh() {
        return (b) aNt.b(this, apP[0]);
    }

    private final a Si() {
        kotlin.d dVar = aNu;
        j jVar = apP[1];
        return (a) dVar.getValue();
    }

    public String getHost() {
        return aNv.a(this, apP[2]);
    }

    public void setTc(Boolean bool) {
    }

    private e() {
    }

    public String getClusterWebsocket() {
        return com.iqoption.core.connect.config.a.a.b(this);
    }

    public final String Sg() {
        return aNs;
    }

    private final String ge(String str) {
        if (str == null) {
            return null;
        }
        if (!u.b(str, "/", false, 2, null)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append('/');
            str = stringBuilder.toString();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A:{SYNTHETIC, RETURN} */
    public java.lang.String Sd() {
        /*
        r1 = this;
        r0 = r1.Sh();
        if (r0 == 0) goto L_0x0011;
    L_0x0006:
        r0 = r0.Sl();
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.getUrl();
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        r0 = r1.ge(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r0 = aNs;
        r0 = r1.ge(r0);
    L_0x001f:
        if (r0 == 0) goto L_0x0022;
    L_0x0021:
        goto L_0x002a;
    L_0x0022:
        r0 = r1.Si();
        r0 = r0.Sd();
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.config.e.Sd():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A:{SYNTHETIC, RETURN} */
    public java.lang.String getClusterApi() {
        /*
        r1 = this;
        r0 = r1.Sh();
        if (r0 == 0) goto L_0x0011;
    L_0x0006:
        r0 = r0.Sl();
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.getUrl();
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        r0 = r1.ge(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0021;
    L_0x0019:
        r0 = r1.Si();
        r0 = r0.getClusterApi();
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.config.e.getClusterApi():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:10:? A:{SYNTHETIC, RETURN} */
    public java.lang.String Se() {
        /*
        r1 = this;
        r0 = r1.Sh();
        if (r0 == 0) goto L_0x0011;
    L_0x0006:
        r0 = r0.Sk();
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.getUrl();
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        r0 = r1.ge(r0);
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0021;
    L_0x0019:
        r0 = r1.Si();
        r0 = r0.Se();
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.connect.config.e.Se():java.lang.String");
    }

    public String getAuthApi() {
        b Sh = Sh();
        String ge = ge(Sh != null ? Sh.getAuthApi() : null);
        return ge != null ? ge : Si().getAuthApi();
    }

    public String getAvatarsApi() {
        b Sh = Sh();
        String ge = ge(Sh != null ? Sh.getAvatarsApi() : null);
        return ge != null ? ge : Si().getAvatarsApi();
    }

    public String getEventApi() {
        b Sh = Sh();
        String ge = ge(Sh != null ? Sh.getEventApi() : null);
        return ge != null ? ge : Si().getEventApi();
    }

    public String getChatApi() {
        b Sh = Sh();
        String ge = ge(Sh != null ? Sh.getChatApi() : null);
        return ge != null ? ge : Si().getChatApi();
    }
}
