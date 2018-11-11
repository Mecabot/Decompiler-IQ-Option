package com.iqoption.core.microservices.livedeals.a;

import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.livedeals.ExpirationType;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/params/LiveDealsExpirationParams;", "Lcom/iqoption/core/microservices/livedeals/params/LiveDealsParams;", "activeId", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "expirationType", "Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "(ILcom/iqoption/core/data/model/InstrumentType;Lcom/iqoption/core/microservices/livedeals/ExpirationType;)V", "getActiveId", "()I", "getExpirationType", "()Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_release"})
/* compiled from: LiveDealsExpirationParams.kt */
public final class a implements c {
    private final ExpirationType aWH;
    private final int activeId;
    private final InstrumentType instrumentType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (getActiveId() == aVar.getActiveId() ? 1 : null) != null && h.E(getInstrumentType(), aVar.getInstrumentType()) && h.E(this.aWH, aVar.aWH);
        }
    }

    public int hashCode() {
        int activeId = getActiveId() * 31;
        InstrumentType instrumentType = getInstrumentType();
        int i = 0;
        activeId = (activeId + (instrumentType != null ? instrumentType.hashCode() : 0)) * 31;
        ExpirationType expirationType = this.aWH;
        if (expirationType != null) {
            i = expirationType.hashCode();
        }
        return activeId + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveDealsExpirationParams(activeId=");
        stringBuilder.append(getActiveId());
        stringBuilder.append(", instrumentType=");
        stringBuilder.append(getInstrumentType());
        stringBuilder.append(", expirationType=");
        stringBuilder.append(this.aWH);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(int i, InstrumentType instrumentType, ExpirationType expirationType) {
        h.e(instrumentType, "instrumentType");
        this.activeId = i;
        this.instrumentType = instrumentType;
        this.aWH = expirationType;
    }

    public int getActiveId() {
        return this.activeId;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public final ExpirationType We() {
        return this.aWH;
    }
}
