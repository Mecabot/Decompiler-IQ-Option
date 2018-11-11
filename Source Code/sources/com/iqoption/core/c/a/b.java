package com.iqoption.core.c.a;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, aXE = {"Lcom/iqoption/core/features/deal/LeveragesLimitParams;", "", "thresold", "", "instruments", "", "", "(ILjava/util/List;)V", "getInstruments", "()Ljava/util/List;", "getThresold", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: LeveragesLimitParams.kt */
public final class b {
    @SerializedName("hide_leverage_threshold")
    private final int aPD;
    @SerializedName("instruments")
    private final List<String> azz;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return (this.aPD == bVar.aPD ? 1 : null) != null && h.E(this.azz, bVar.azz);
        }
    }

    public int hashCode() {
        int i = this.aPD * 31;
        List list = this.azz;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LeveragesLimitParams(thresold=");
        stringBuilder.append(this.aPD);
        stringBuilder.append(", instruments=");
        stringBuilder.append(this.azz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int Ta() {
        return this.aPD;
    }

    public final List<String> Ik() {
        return this.azz;
    }
}
