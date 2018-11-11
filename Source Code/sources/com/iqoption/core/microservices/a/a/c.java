package com.iqoption.core.microservices.a.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/auth/response/SessionData;", "", "()V", "userId", "", "modified", "platform", "", "ip", "", "userAgent", "(JJILjava/lang/String;Ljava/lang/String;)V", "getIp", "()Ljava/lang/String;", "getModified", "()J", "getPlatform", "()I", "getUserAgent", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: SessionResponses.kt */
public final class c {
    @SerializedName("modified")
    private final long DT;
    @SerializedName("platform")
    private final int aSS;
    @SerializedName("ip")
    private final String aST;
    @SerializedName("user_agent")
    private final String userAgent;
    @SerializedName("user_id")
    private final long userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if ((this.userId == cVar.userId ? 1 : null) != null) {
                if ((this.DT == cVar.DT ? 1 : null) != null) {
                    return (this.aSS == cVar.aSS ? 1 : null) != null && h.E(this.aST, cVar.aST) && h.E(this.userAgent, cVar.userAgent);
                }
            }
        }
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.DT;
        i = (((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.aSS) * 31;
        String str = this.aST;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.userAgent;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SessionData(userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", modified=");
        stringBuilder.append(this.DT);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.aSS);
        stringBuilder.append(", ip=");
        stringBuilder.append(this.aST);
        stringBuilder.append(", userAgent=");
        stringBuilder.append(this.userAgent);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(long j, long j2, int i, String str, String str2) {
        h.e(str, "ip");
        h.e(str2, "userAgent");
        this.userId = j;
        this.DT = j2;
        this.aSS = i;
        this.aST = str;
        this.userAgent = str2;
    }

    public final long ma() {
        return this.DT;
    }

    public final int Ur() {
        return this.aSS;
    }

    public final String Us() {
        return this.aST;
    }

    public final String jx() {
        return this.userAgent;
    }

    public c() {
        this(0, 0, 0, "", "");
    }
}
