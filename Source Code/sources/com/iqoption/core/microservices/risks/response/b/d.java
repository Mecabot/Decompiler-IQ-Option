package com.iqoption.core.microservices.risks.response.b;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.data.model.InstrumentType;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006!"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkupChanged;", "", "()V", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "userGroupId", "", "activeId", "markups", "", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkup;", "(Lcom/iqoption/core/data/model/InstrumentType;JJLjava/util/List;)V", "getActiveId", "()J", "getInstrumentType", "()Lcom/iqoption/core/data/model/InstrumentType;", "getMarkups", "()Ljava/util/List;", "getUserGroupId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getActive", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "hashCode", "", "toString", "", "core_release"})
/* compiled from: SpreadMarkupChanged.kt */
public final class d {
    @SerializedName("active_id")
    private final long aMI;
    @SerializedName("markups")
    private final List<c> aXB;
    @SerializedName("user_group_id")
    private final long aqq;
    @SerializedName("instrument_type")
    private final InstrumentType instrumentType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (h.E(this.instrumentType, dVar.instrumentType)) {
                if ((this.aqq == dVar.aqq ? 1 : null) != null) {
                    return ((this.aMI > dVar.aMI ? 1 : (this.aMI == dVar.aMI ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aXB, dVar.aXB);
                }
            }
        }
    }

    public int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int i = 0;
        int hashCode = (instrumentType != null ? instrumentType.hashCode() : 0) * 31;
        long j = this.aqq;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.aMI;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        List list = this.aXB;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpreadMarkupChanged(instrumentType=");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append(", userGroupId=");
        stringBuilder.append(this.aqq);
        stringBuilder.append(", activeId=");
        stringBuilder.append(this.aMI);
        stringBuilder.append(", markups=");
        stringBuilder.append(this.aXB);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(InstrumentType instrumentType, long j, long j2, List<c> list) {
        h.e(instrumentType, "instrumentType");
        h.e(list, "markups");
        this.instrumentType = instrumentType;
        this.aqq = j;
        this.aMI = j2;
        this.aXB = list;
    }

    public /* synthetic */ d(InstrumentType instrumentType, long j, long j2, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            instrumentType = InstrumentType.UNKNOWN;
        }
        long j3 = 0;
        long j4 = (i & 2) != 0 ? 0 : j;
        if ((i & 4) == 0) {
            j3 = j2;
        }
        if ((i & 8) != 0) {
            list = m.emptyList();
        }
        this(instrumentType, j4, j3, list);
    }

    public d() {
        this(InstrumentType.UNKNOWN, 0, 0, null, 14, null);
    }

    public final a WI() {
        return new a(this.aMI, this.aXB);
    }
}
