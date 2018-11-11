package com.iqoption.deposit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, aXE = {"Lcom/iqoption/deposit/DepositParams;", "Landroid/os/Parcelable;", "amount", "Ljava/math/BigDecimal;", "currency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "(Ljava/math/BigDecimal;Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;)V", "getAmount", "()Ljava/math/BigDecimal;", "getCurrency", "()Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "deposit_release"})
/* compiled from: DepositParams.kt */
public final class p implements Parcelable {
    public static final Creator CREATOR = new a();
    private final BigDecimal aWn;
    private final c bVE;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new p((BigDecimal) parcel.readSerializable(), (c) parcel.readParcelable(p.class.getClassLoader()));
        }

        public final Object[] newArray(int i) {
            return new p[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.bVE, r3.bVE) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.deposit.p;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.deposit.p) r3;
        r0 = r2.aWn;
        r1 = r3.aWn;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.bVE;
        r3 = r3.bVE;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r3 = 0;
        return r3;
    L_0x001f:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.p.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.aWn;
        int i = 0;
        int hashCode = (bigDecimal != null ? bigDecimal.hashCode() : 0) * 31;
        c cVar = this.bVE;
        if (cVar != null) {
            i = cVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DepositParams(amount=");
        stringBuilder.append(this.aWn);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.bVE);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeSerializable(this.aWn);
        parcel.writeParcelable(this.bVE, i);
    }

    public p(BigDecimal bigDecimal, c cVar) {
        h.e(bigDecimal, "amount");
        h.e(cVar, b.CURRENCY);
        this.aWn = bigDecimal;
        this.bVE = cVar;
    }

    public final BigDecimal VZ() {
        return this.aWn;
    }

    public final c aaH() {
        return this.bVE;
    }
}
