package com.iqoption.core.microservices.tradingengine.response.active;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÂ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R[\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r\u0018\u00010\n0\n8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, aXE = {"Lcom/iqoption/core/microservices/tradingengine/response/active/UnderlyingResult;", "", "()V", "type", "Lcom/iqoption/core/data/model/InstrumentType;", "_instruments", "", "Lcom/iqoption/core/microservices/tradingengine/response/active/InstrumentActive;", "(Lcom/iqoption/core/data/model/InstrumentType;Ljava/util/List;)V", "instruments", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getInstruments", "()Ljava/util/HashMap;", "instruments$delegate", "Lkotlin/Lazy;", "getType", "()Lcom/iqoption/core/data/model/InstrumentType;", "component1", "component2", "copy", "equals", "", "other", "fillInstrumentType", "active", "hashCode", "instrumentList", "toString", "", "core_release"})
/* compiled from: UnderlyingResult.kt */
public final class l {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), "instruments", "getInstruments()Ljava/util/HashMap;"))};
    private final transient d aYN;
    @SerializedName("underlying")
    private final List<h> aYO;
    @SerializedName("type")
    private final InstrumentType type;

    public final HashMap<Integer, a> XF() {
        d dVar = this.aYN;
        j jVar = apP[0];
        return (HashMap) dVar.getValue();
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.aYO, r3.aYO) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.tradingengine.response.active.l;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.tradingengine.response.active.l) r3;
        r0 = r2.type;
        r1 = r3.type;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.aYO;
        r3 = r3.aYO;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.tradingengine.response.active.l.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        InstrumentType instrumentType = this.type;
        int i = 0;
        int hashCode = (instrumentType != null ? instrumentType.hashCode() : 0) * 31;
        List list = this.aYO;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UnderlyingResult(type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", _instruments=");
        stringBuilder.append(this.aYO);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public l(InstrumentType instrumentType, List<h> list) {
        h.e(instrumentType, Param.TYPE);
        h.e(list, "_instruments");
        this.type = instrumentType;
        this.aYO = list;
        this.aYN = g.f(new UnderlyingResult$instruments$2(this));
    }

    public final InstrumentType Xw() {
        return this.type;
    }

    public l() {
        this(InstrumentType.UNKNOWN, m.emptyList());
    }

    public final List<h> Xv() {
        Iterable<h> iterable = this.aYO;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (h a : iterable) {
            arrayList.add(a(a, this.type));
        }
        return (List) arrayList;
    }

    private final h a(h hVar, InstrumentType instrumentType) {
        hVar.b(instrumentType);
        return hVar;
    }
}
