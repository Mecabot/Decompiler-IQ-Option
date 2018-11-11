package com.iqoption.core.microservices.a.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, aXE = {"Lcom/iqoption/core/microservices/auth/response/Session;", "", "()V", "id", "", "data", "Lcom/iqoption/core/microservices/auth/response/SessionData;", "expiresAt", "", "expiresCacheAt", "(Ljava/lang/String;Lcom/iqoption/core/microservices/auth/response/SessionData;JJ)V", "getData", "()Lcom/iqoption/core/microservices/auth/response/SessionData;", "getExpiresAt", "()J", "getExpiresCacheAt", "getId", "()Ljava/lang/String;", "parsedUserAgentString", "getParsedUserAgentString", "setParsedUserAgentString", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: SessionResponses.kt */
public final class b {
    private String aSP;
    @SerializedName("data")
    private final c aSQ;
    @SerializedName("expires_cache_at")
    private final long aSR;
    @SerializedName("expires_at")
    private final long expiresAt;
    @SerializedName("id")
    private final String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.id, bVar.id) && h.E(this.aSQ, bVar.aSQ)) {
                if ((this.expiresAt == bVar.expiresAt ? 1 : null) != null) {
                    if ((this.aSR == bVar.aSR ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        c cVar = this.aSQ;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        long j = this.expiresAt;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.aSR;
        return hashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Session(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", data=");
        stringBuilder.append(this.aSQ);
        stringBuilder.append(", expiresAt=");
        stringBuilder.append(this.expiresAt);
        stringBuilder.append(", expiresCacheAt=");
        stringBuilder.append(this.aSR);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(String str, c cVar, long j, long j2) {
        h.e(str, "id");
        h.e(cVar, "data");
        this.id = str;
        this.aSQ = cVar;
        this.expiresAt = j;
        this.aSR = j2;
        this.aSP = "";
    }

    public final String getId() {
        return this.id;
    }

    public final c Uq() {
        return this.aSQ;
    }

    public final String Up() {
        return this.aSP;
    }

    public final void gw(String str) {
        h.e(str, "<set-?>");
        this.aSP = str;
    }

    public b() {
        this("", new c(), 0, 0);
    }
}
