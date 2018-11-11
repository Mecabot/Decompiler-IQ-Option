package com.iqoption.billing.repository;

import com.iqoption.core.microservices.billing.response.a;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, aXE = {"Lcom/iqoption/billing/repository/CountingCash;", "", "arguments", "Lcom/iqoption/billing/repository/CountingArguments;", "stream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "(Lcom/iqoption/billing/repository/CountingArguments;Lcom/iqoption/core/rx/LiveStreamSupplier;)V", "getArguments", "()Lcom/iqoption/billing/repository/CountingArguments;", "getStream", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "billing_release"})
/* compiled from: CashBoxRepository.kt */
final class d {
    private final com.iqoption.core.h.d<a> aqU;
    private final c aru;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aqU, r3.aqU) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.billing.repository.d;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.billing.repository.d) r3;
        r0 = r2.aru;
        r1 = r3.aru;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.aqU;
        r3 = r3.aqU;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.billing.repository.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.aru;
        int i = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        com.iqoption.core.h.d dVar = this.aqU;
        if (dVar != null) {
            i = dVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CountingCash(arguments=");
        stringBuilder.append(this.aru);
        stringBuilder.append(", stream=");
        stringBuilder.append(this.aqU);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(c cVar, com.iqoption.core.h.d<a> dVar) {
        h.e(cVar, "arguments");
        h.e(dVar, "stream");
        this.aru = cVar;
        this.aqU = dVar;
    }

    public final c JG() {
        return this.aru;
    }

    public final com.iqoption.core.h.d<a> Jv() {
        return this.aqU;
    }
}
