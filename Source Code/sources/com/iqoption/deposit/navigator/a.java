package com.iqoption.deposit.navigator;

import com.iqoption.deposit.p;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0014"}, aXE = {"Lcom/iqoption/deposit/navigator/CommonWebPaymentResult;", "Lcom/iqoption/deposit/navigator/WebPaymentResult;", "isSuccess", "", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "(ZLcom/iqoption/deposit/DepositParams;)V", "getDepositParams", "()Lcom/iqoption/deposit/DepositParams;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "deposit_release"})
/* compiled from: DepositNavigatorViewModel.kt */
public final class a extends d {
    private final boolean ajK;
    private final p cbD;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (this.ajK == aVar.ajK ? 1 : null) != null && h.E(this.cbD, aVar.cbD);
        }
    }

    public int hashCode() {
        int i = this.ajK;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        p pVar = this.cbD;
        return i + (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommonWebPaymentResult(isSuccess=");
        stringBuilder.append(this.ajK);
        stringBuilder.append(", depositParams=");
        stringBuilder.append(this.cbD);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(boolean z, p pVar) {
        h.e(pVar, "depositParams");
        super();
        this.ajK = z;
        this.cbD = pVar;
    }

    public final p adL() {
        return this.cbD;
    }

    public final boolean isSuccess() {
        return this.ajK;
    }
}
