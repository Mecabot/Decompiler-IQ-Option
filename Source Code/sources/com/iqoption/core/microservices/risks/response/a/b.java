package com.iqoption.core.microservices.risks.response.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/commission/CommissionsResult;", "", "instrumentType", "", "userGroupId", "", "data", "", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "(Ljava/lang/String;JLjava/util/List;)V", "getData", "()Ljava/util/List;", "getInstrumentType", "()Ljava/lang/String;", "getUserGroupId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: CommissionsResult.kt */
public final class b {
    @SerializedName("instrument_type")
    private final String aXA;
    @SerializedName("items")
    private final List<a> aXq;
    @SerializedName("user_group_id")
    private final long aqq;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (h.E(this.aXA, bVar.aXA)) {
                return ((this.aqq > bVar.aqq ? 1 : (this.aqq == bVar.aqq ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aXq, bVar.aXq);
            }
        }
    }

    public int hashCode() {
        String str = this.aXA;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long j = this.aqq;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        List list = this.aXq;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommissionsResult(instrumentType=");
        stringBuilder.append(this.aXA);
        stringBuilder.append(", userGroupId=");
        stringBuilder.append(this.aqq);
        stringBuilder.append(", data=");
        stringBuilder.append(this.aXq);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final List<a> WC() {
        return this.aXq;
    }
}
