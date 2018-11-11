package com.iqoption.core.data.c;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/core/data/mediators/BalanceData;", "", "isReal", "", "amount", "", "currencyName", "(ZLjava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "getCurrencyName", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: BalanceMediator.kt */
public final class a {
    private final boolean aOt;
    private final String aOu;
    private final String amount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (this.aOt == aVar.aOt ? 1 : null) != null && h.E(this.amount, aVar.amount) && h.E(this.aOu, aVar.aOu);
        }
    }

    public int hashCode() {
        int i = this.aOt;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        String str = this.amount;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.aOu;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BalanceData(isReal=");
        stringBuilder.append(this.aOt);
        stringBuilder.append(", amount=");
        stringBuilder.append(this.amount);
        stringBuilder.append(", currencyName=");
        stringBuilder.append(this.aOu);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(boolean z, String str, String str2) {
        h.e(str, "amount");
        h.e(str2, "currencyName");
        this.aOt = z;
        this.amount = str;
        this.aOu = str2;
    }

    public final String SA() {
        return this.aOu;
    }

    public final String Sz() {
        return this.amount;
    }

    public final boolean isReal() {
        return this.aOt;
    }
}
