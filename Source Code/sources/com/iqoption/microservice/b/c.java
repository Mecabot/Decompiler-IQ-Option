package com.iqoption.microservice.b;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/microservice/operation/TransactionResponse;", "", "()V", "items", "", "Lcom/iqoption/microservice/operation/Transaction;", "count", "", "(Ljava/util/List;I)V", "getCount", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: OperationResponse.kt */
public final class c {
    @SerializedName("total")
    private final int count;
    @SerializedName("items")
    private final List<b> nj;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (h.E(this.nj, cVar.nj)) {
                if ((this.count == cVar.count ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        List list = this.nj;
        return ((list != null ? list.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransactionResponse(items=");
        stringBuilder.append(this.nj);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(List<b> list, int i) {
        h.e(list, "items");
        this.nj = list;
        this.count = i;
    }

    public final List<b> getItems() {
        return this.nj;
    }

    public final int getCount() {
        return this.count;
    }

    public c() {
        List emptyList = Collections.emptyList();
        h.d(emptyList, "Collections.emptyList()");
        this(emptyList, 0);
    }
}
