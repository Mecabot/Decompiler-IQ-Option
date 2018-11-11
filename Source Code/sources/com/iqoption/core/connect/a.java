package com.iqoption.core.connect;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/connect/ApiConfigData;", "", "authApi", "", "getAuthApi", "()Ljava/lang/String;", "avatarsApi", "getAvatarsApi", "chatApi", "getChatApi", "clusterApi", "getClusterApi", "clusterWebsocket", "getClusterWebsocket", "eventApi", "getEventApi", "tc", "", "getTc", "()Ljava/lang/Boolean;", "setTc", "(Ljava/lang/Boolean;)V", "userVerifyApi", "getUserVerifyApi", "walletReferralApi", "getWalletReferralApi", "core_release"})
/* compiled from: ApiConfigData.kt */
public interface a {
    String getAuthApi();

    String getAvatarsApi();

    String getChatApi();

    String getClusterApi();

    String getClusterWebsocket();

    String getEventApi();

    void setTc(Boolean bool);
}
