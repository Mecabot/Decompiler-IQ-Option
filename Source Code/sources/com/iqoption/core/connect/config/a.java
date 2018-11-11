package com.iqoption.core.connect.config;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0014\u0010!\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 R(\u0010#\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001f8V@VX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0012\u0010*\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0012\u0010,\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005¨\u0006."}, aXE = {"Lcom/iqoption/core/connect/config/ApiConfig;", "Lcom/iqoption/core/connect/ApiConfigData;", "authApi", "", "getAuthApi", "()Ljava/lang/String;", "avatarsApi", "getAvatarsApi", "billingApi", "getBillingApi", "chatApi", "getChatApi", "clusterApi", "getClusterApi", "clusterWebSocket", "getClusterWebSocket", "clusterWebsocket", "getClusterWebsocket", "coreApi", "getCoreApi", "eventApi", "getEventApi", "featuresApi", "getFeaturesApi", "finInfoApi", "getFinInfoApi", "gatewayApi", "getGatewayApi", "host", "getHost", "isAuthorized", "", "()Z", "isUnauthorized", "value", "tc", "getTc", "()Ljava/lang/Boolean;", "setTc", "(Ljava/lang/Boolean;)V", "userVerificationApi", "getUserVerificationApi", "userVerifyApi", "getUserVerifyApi", "walletReferralApi", "getWalletReferralApi", "core_release"})
/* compiled from: ApiConfig.kt */
public interface a extends com.iqoption.core.connect.a {

    @i(aXC = {1, 1, 11})
    /* compiled from: ApiConfig.kt */
    public static final class a {
        public static String a(a aVar) {
            return aVar.getClusterApi();
        }

        public static String b(a aVar) {
            return aVar.Se();
        }
    }

    String Sd();

    String Se();

    String getAuthApi();

    String getAvatarsApi();

    String getChatApi();

    String getClusterApi();

    String getEventApi();

    String getHost();
}
