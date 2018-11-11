package com.iqoption.core.microservices.c.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResponse;", "", "result", "Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResult;", "(Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResult;)V", "getResult", "()Lcom/iqoption/core/microservices/leaderboard/response/LeaderBoardUserInfoResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
/* compiled from: LeaderBoardUserInfoResponse.kt */
public final class b {
    @SerializedName("result")
    private final c aWy;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aWy, ((com.iqoption.core.microservices.c.a.b) r2).aWy) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.c.a.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.c.a.b) r2;
        r0 = r1.aWy;
        r2 = r2.aWy;
        r2 = kotlin.jvm.internal.h.E(r0, r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0015;
    L_0x0013:
        r2 = 0;
        return r2;
    L_0x0015:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.c.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.aWy;
        return cVar != null ? cVar.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LeaderBoardUserInfoResponse(result=");
        stringBuilder.append(this.aWy);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final c Wc() {
        return this.aWy;
    }
}
