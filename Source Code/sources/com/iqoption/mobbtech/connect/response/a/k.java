package com.iqoption.mobbtech.connect.response.a;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/cashbox/SessionContext;", "", "isRegulated", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: SessionContext.kt */
public final class k {
    private final boolean aMv;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            if ((this.aMv == ((k) obj).aMv ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        boolean z = this.aMv;
        return z ? 1 : z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SessionContext(isRegulated=");
        stringBuilder.append(this.aMv);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public k(boolean z) {
        this.aMv = z;
    }

    public final boolean Dh() {
        return this.aMv;
    }
}
