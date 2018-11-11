package com.iqoption.core.connect.config;

import com.iqoption.core.connect.config.a.a;
import com.iqoption.core.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0014\u0010$\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0014\u0010&\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0006¨\u0006("}, aXE = {"Lcom/iqoption/core/connect/config/IntConfig;", "Lcom/iqoption/core/connect/config/ApiConfig;", "()V", "authApi", "", "getAuthApi", "()Ljava/lang/String;", "avatarsApi", "getAvatarsApi", "billingApi", "getBillingApi", "chatApi", "getChatApi", "clusterApi", "getClusterApi", "clusterWebSocket", "getClusterWebSocket", "eventApi", "getEventApi", "featuresApi", "getFeaturesApi", "finInfoApi", "getFinInfoApi", "gatewayApi", "getGatewayApi", "host", "getHost", "tc", "", "getTc", "()Ljava/lang/Boolean;", "setTc", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "userVerificationApi", "getUserVerificationApi", "userVerifyApi", "getUserVerifyApi", "walletReferralApi", "getWalletReferralApi", "core_release"})
/* compiled from: ApiConfig.kt */
public final class c implements a {
    private static final String aNi = e.aMr.RK();
    private static final String aNj = e.aMr.RK();
    private static final String aNk = "https://user-verification.int.iqoption.com/";
    private static final String aNl = "https://features.int.iqoption.com/";
    private static final String aNm = "https://fininfo.int.iqoption.com/";
    private static final String aNn = "https://api.int.iqoption.com/";
    private static final String aNo = "https://billing.int.iqoption.com/";
    public static final c aNp = new c();
    private static final String authApi = "https://auth.int.iqoption.com/";
    private static final String avatarsApi = "https://avatars-int.iqoption.com/";
    private static final String chatApi = "https://chat.int.iqoption.com/";
    private static final String eventApi = "event.int.iqoption.com/";
    private static final String host = "int.iqoption.com";
    private static Boolean tc = Boolean.valueOf(false);
    private static final String userVerifyApi = "https://verify.int.iqoption.com/";
    private static final String walletReferralApi = "https://wallet-referral.int.iqoption.com/";

    private c() {
    }

    public String Sd() {
        return a.a(this);
    }

    public String getClusterWebsocket() {
        return a.b(this);
    }

    public String getHost() {
        return host;
    }

    public void setTc(Boolean bool) {
        tc = bool;
    }

    public String getClusterApi() {
        return aNi;
    }

    public String Se() {
        return aNj;
    }

    public String getAuthApi() {
        return authApi;
    }

    public String getAvatarsApi() {
        return avatarsApi;
    }

    public String getEventApi() {
        return eventApi;
    }

    public String getChatApi() {
        return chatApi;
    }
}
