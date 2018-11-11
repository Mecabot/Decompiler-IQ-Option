package com.iqoption.core.microservices.tradingengine.response.c;

import com.google.gson.annotations.SerializedName;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/order/PlaceOrderResult;", "", "id", "", "(Ljava/lang/Long;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/iqoption/core/microservices/tradingengine/response/order/PlaceOrderResult;", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
/* compiled from: PlaceOrderResult.kt */
public final class a {
    @SerializedName("id")
    private final Long id;

    public a() {
        this(null, 1, null);
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.id, ((com.iqoption.core.microservices.tradingengine.response.c.a) r2).id) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.tradingengine.response.c.a;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.tradingengine.response.c.a) r2;
        r0 = r1.id;
        r2 = r2.id;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.c.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Long l = this.id;
        return l != null ? l.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlaceOrderResult(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(Long l) {
        this.id = l;
    }

    public /* synthetic */ a(Long l, int i, f fVar) {
        if ((i & 1) != 0) {
            l = (Long) null;
        }
        this(l);
    }

    public final Long getId() {
        return this.id;
    }
}
