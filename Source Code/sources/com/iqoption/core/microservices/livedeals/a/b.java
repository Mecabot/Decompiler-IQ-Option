package com.iqoption.core.microservices.livedeals.a;

import com.iqoption.core.data.model.InstrumentType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/params/LiveDealsIntervalParams;", "Lcom/iqoption/core/microservices/livedeals/params/LiveDealsParams;", "activeId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "from", "", "to", "count", "(ILcom/iqoption/core/data/model/InstrumentType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getActiveId", "()I", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrom", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "getTo", "component1", "component2", "component3", "component4", "component5", "copy", "(ILcom/iqoption/core/data/model/InstrumentType;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/iqoption/core/microservices/livedeals/params/LiveDealsIntervalParams;", "equals", "", "other", "", "hashCode", "toString", "", "core_release"})
/* compiled from: LiveDealsIntervalParams.kt */
public final class b implements c {
    private final Long aWI;
    private final Long aWJ;
    private final int activeId;
    private final Integer count;
    private final InstrumentType instrumentType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return (getActiveId() == bVar.getActiveId() ? 1 : null) != null && h.E(getInstrumentType(), bVar.getInstrumentType()) && h.E(this.aWI, bVar.aWI) && h.E(this.aWJ, bVar.aWJ) && h.E(this.count, bVar.count);
        }
    }

    public int hashCode() {
        int activeId = getActiveId() * 31;
        InstrumentType instrumentType = getInstrumentType();
        int i = 0;
        activeId = (activeId + (instrumentType != null ? instrumentType.hashCode() : 0)) * 31;
        Long l = this.aWI;
        activeId = (activeId + (l != null ? l.hashCode() : 0)) * 31;
        l = this.aWJ;
        activeId = (activeId + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.count;
        if (num != null) {
            i = num.hashCode();
        }
        return activeId + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveDealsIntervalParams(activeId=");
        stringBuilder.append(getActiveId());
        stringBuilder.append(", instrumentType=");
        stringBuilder.append(getInstrumentType());
        stringBuilder.append(", from=");
        stringBuilder.append(this.aWI);
        stringBuilder.append(", to=");
        stringBuilder.append(this.aWJ);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(int i, InstrumentType instrumentType, Long l, Long l2, Integer num) {
        h.e(instrumentType, "instrumentType");
        this.activeId = i;
        this.instrumentType = instrumentType;
        this.aWI = l;
        this.aWJ = l2;
        this.count = num;
    }

    public int getActiveId() {
        return this.activeId;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final Long Wf() {
        return this.aWI;
    }

    public final Long Wg() {
        return this.aWJ;
    }

    public final Integer getCount() {
        return this.count;
    }
}
