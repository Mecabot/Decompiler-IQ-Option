package com.iqoption.core.microservices.risks.response.b;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/markup/Item;", "", "()V", "userGroupId", "", "actives", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "(ILjava/util/List;)V", "getActives", "()Ljava/util/List;", "getUserGroupId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "core_release"})
/* compiled from: SpreadMarkups.kt */
public final class b {
    @SerializedName("user_group_id")
    private final int aXC;
    @SerializedName("actives")
    private final List<a> apX;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return (this.aXC == bVar.aXC ? 1 : null) != null && h.E(this.apX, bVar.apX);
        }
    }

    public int hashCode() {
        int i = this.aXC * 31;
        List list = this.apX;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item(userGroupId=");
        stringBuilder.append(this.aXC);
        stringBuilder.append(", actives=");
        stringBuilder.append(this.apX);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public b(int i, List<a> list) {
        h.e(list, "actives");
        this.aXC = i;
        this.apX = list;
    }

    public /* synthetic */ b(int i, List list, int i2, f fVar) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            list = m.emptyList();
        }
        this(i, list);
    }

    public final List<a> Jj() {
        return this.apX;
    }

    public b() {
        this(0, null, 2, null);
    }
}
