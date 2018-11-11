package com.iqoption.core.microservices.c.a;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResult;", "", "userId", "", "requestedUserId", "countryId", "", "entitiesByCountry", "", "", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfo;", "(JJILjava/util/Map;)V", "getCountryId", "()I", "getEntitiesByCountry", "()Ljava/util/Map;", "getRequestedUserId", "()J", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: LeaderBoardUserInfoResponse.kt */
public final class c {
    @SerializedName("country_id")
    private final int aWA;
    @SerializedName("entries_by_country")
    private final Map<String, a> aWB;
    @SerializedName("requested_user_id")
    private final long aWz;
    @SerializedName("user_id")
    private final long userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if ((this.userId == cVar.userId ? 1 : null) != null) {
                if ((this.aWz == cVar.aWz ? 1 : null) != null) {
                    return (this.aWA == cVar.aWA ? 1 : null) != null && h.E(this.aWB, cVar.aWB);
                }
            }
        }
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.aWz;
        i = (((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.aWA) * 31;
        Map map = this.aWB;
        return i + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LeaderBoardUserInfoResult(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", requestedUserId=");
        stringBuilder.append(this.aWz);
        stringBuilder.append(", countryId=");
        stringBuilder.append(this.aWA);
        stringBuilder.append(", entitiesByCountry=");
        stringBuilder.append(this.aWB);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final Map<String, a> Wd() {
        return this.aWB;
    }
}
