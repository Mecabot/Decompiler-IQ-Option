package com.iqoption.billing.repository;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, aXE = {"Lcom/iqoption/billing/repository/CountingArguments;", "", "sessionHost", "", "sessionId", "withKycLimit", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getSessionHost", "()Ljava/lang/String;", "getSessionId", "getWithKycLimit", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "billing_release"})
/* compiled from: CashBoxRepository.kt */
final class c {
    private final String ars;
    private final boolean art;
    private final String uQ;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (h.E(this.ars, cVar.ars) && h.E(this.uQ, cVar.uQ)) {
                if ((this.art == cVar.art ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.ars;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uQ;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.art;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CountingArguments(sessionHost=");
        stringBuilder.append(this.ars);
        stringBuilder.append(", sessionId=");
        stringBuilder.append(this.uQ);
        stringBuilder.append(", withKycLimit=");
        stringBuilder.append(this.art);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(String str, String str2, boolean z) {
        h.e(str, "sessionHost");
        h.e(str2, "sessionId");
        this.ars = str;
        this.uQ = str2;
        this.art = z;
    }
}
