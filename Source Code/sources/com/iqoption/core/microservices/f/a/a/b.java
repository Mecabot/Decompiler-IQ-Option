package com.iqoption.core.microservices.f.a.a;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, aXE = {"Lcom/iqoption/core/microservices/topassets/response/spread/SpreadDataResult;", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "data", "Ljava/util/ArrayList;", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "(Lcom/iqoption/core/data/model/InstrumentType;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "component1", "component2", "copy", "equals", "", "other", "getResult", "", "", "hashCode", "toString", "", "core_release"})
/* compiled from: SpreadDataResult.kt */
public final class b {
    @SerializedName("data")
    private final ArrayList<a> aYo;
    @SerializedName("instrument_type")
    private final InstrumentType instrumentType;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aYo, r3.aYo) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.f.a.a.b;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.f.a.a.b) r3;
        r0 = r2.instrumentType;
        r1 = r3.instrumentType;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.aYo;
        r3 = r3.aYo;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.f.a.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int i = 0;
        int hashCode = (instrumentType != null ? instrumentType.hashCode() : 0) * 31;
        ArrayList arrayList = this.aYo;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpreadDataResult(instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(", data=");
        stringBuilder.append(this.aYo);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final Map<Integer, a> Xd() {
        Map<Integer, a> linkedHashMap = new LinkedHashMap();
        Iterator it = this.aYo.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.b(this.instrumentType);
            Integer valueOf = Integer.valueOf(aVar.getActiveId());
            h.d(aVar, "spreadData");
            linkedHashMap.put(valueOf, aVar);
        }
        return linkedHashMap;
    }
}
