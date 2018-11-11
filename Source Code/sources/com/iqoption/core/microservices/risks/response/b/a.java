package com.iqoption.core.microservices.risks.response.b;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/markup/Active;", "", "()V", "activeId", "", "markups", "", "Lcom/iqoption/core/microservices/risks/response/markup/SpreadMarkup;", "(JLjava/util/List;)V", "getActiveId", "()J", "getMarkups", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "getMarkup", "", "leverage", "", "hashCode", "toString", "", "core_release"})
/* compiled from: SpreadMarkups.kt */
public final class a {
    @SerializedName("active_id")
    private final long aMI;
    @SerializedName("markups")
    private final List<c> aXB;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return ((this.aMI > aVar.aMI ? 1 : (this.aMI == aVar.aMI ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.aXB, aVar.aXB);
        }
    }

    public int hashCode() {
        long j = this.aMI;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List list = this.aXB;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Active(activeId=");
        stringBuilder.append(this.aMI);
        stringBuilder.append(", markups=");
        stringBuilder.append(this.aXB);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, List<c> list) {
        h.e(list, "markups");
        this.aMI = j;
        this.aXB = list;
    }

    public final long WF() {
        return this.aMI;
    }

    public /* synthetic */ a(long j, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            j = 0;
        }
        if ((i & 2) != 0) {
            list = m.emptyList();
        }
        this(j, list);
    }

    public a() {
        this(0, null, 2, null);
    }

    public final double dO(int i) {
        for (Object next : this.aXB) {
            Object obj;
            c cVar = (c) next;
            if (i < cVar.WG() || i > cVar.WH()) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        c cVar2 = (c) next2;
        return cVar2 != null ? cVar2.getValue() : 0.0d;
    }
}
