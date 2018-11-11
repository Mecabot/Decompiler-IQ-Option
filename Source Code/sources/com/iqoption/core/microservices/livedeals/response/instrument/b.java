package com.iqoption.core.microservices.livedeals.response.instrument;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/response/instrument/TopDealsInstrumentResponse;", "", "deals", "", "Lcom/iqoption/core/microservices/livedeals/response/instrument/LiveDealInstrument;", "(Ljava/util/List;)V", "getDeals", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
/* compiled from: TopDealsInstrumentResponse.kt */
public final class b {
    @SerializedName("deals")
    private final List<a> aWQ;

    /* JADX WARNING: Missing block: B:4:0x0010, code:
            if (kotlin.jvm.internal.h.E(r1.aWQ, ((com.iqoption.core.microservices.livedeals.response.instrument.b) r2).aWQ) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015;
    L_0x0002:
        r0 = r2 instanceof com.iqoption.core.microservices.livedeals.response.instrument.b;
        if (r0 == 0) goto L_0x0013;
    L_0x0006:
        r2 = (com.iqoption.core.microservices.livedeals.response.instrument.b) r2;
        r0 = r1.aWQ;
        r2 = r2.aWQ;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.livedeals.response.instrument.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.aWQ;
        return list != null ? list.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TopDealsInstrumentResponse(deals=");
        stringBuilder.append(this.aWQ);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final List<a> Wm() {
        return this.aWQ;
    }
}
