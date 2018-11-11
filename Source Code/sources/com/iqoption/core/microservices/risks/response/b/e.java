package com.iqoption.core.microservices.risks.response.b;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkups;", "", "()V", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "items", "", "Lcom/iqoption/core/microservices/risks/response/markup/Item;", "(Lcom/iqoption/core/data/model/InstrumentType;Ljava/util/List;)V", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"})
/* compiled from: SpreadMarkups.kt */
public final class e {
    @SerializedName("instrument_type")
    private final InstrumentType instrumentType;
    @SerializedName("items")
    private final List<b> nj;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.nj, r3.nj) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.risks.response.b.e;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.risks.response.b.e) r3;
        r0 = r2.instrumentType;
        r1 = r3.instrumentType;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.nj;
        r3 = r3.nj;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.risks.response.b.e.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int i = 0;
        int hashCode = (instrumentType != null ? instrumentType.hashCode() : 0) * 31;
        List list = this.nj;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpreadMarkups(instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(", items=");
        stringBuilder.append(this.nj);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public e(InstrumentType instrumentType, List<b> list) {
        h.e(instrumentType, "instrumentType");
        h.e(list, "items");
        this.instrumentType = instrumentType;
        this.nj = list;
    }

    public /* synthetic */ e(InstrumentType instrumentType, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            instrumentType = InstrumentType.UNKNOWN;
        }
        if ((i & 2) != 0) {
            list = m.emptyList();
        }
        this(instrumentType, list);
    }

    public final List<b> getItems() {
        return this.nj;
    }

    public e() {
        this(InstrumentType.UNKNOWN, null, 2, null);
    }
}
