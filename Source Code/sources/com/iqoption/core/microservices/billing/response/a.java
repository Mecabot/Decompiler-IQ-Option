package com.iqoption.core.microservices.billing.response;

import com.google.gson.annotations.SerializedName;
import com.iqoption.core.microservices.billing.response.deposit.b;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0002\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, aXE = {"Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "", "isSuccessful", "", "message", "", "cashboxCounting", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;)V", "getCashboxCounting", "()Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "setCashboxCounting", "(Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;)Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "equals", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: CashboxResult.kt */
public final class a {
    @SerializedName("data")
    private b aTd;
    @SerializedName("isSuccessful")
    private final Boolean isSuccessful;
    @SerializedName("message")
    private final String message;

    public a() {
        this(null, null, null, 7, null);
    }

    /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.aTd, r3.aTd) != false) goto L_0x0029;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0029;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.core.microservices.billing.response.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r3 = (com.iqoption.core.microservices.billing.response.a) r3;
        r0 = r2.isSuccessful;
        r1 = r3.isSuccessful;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0012:
        r0 = r2.message;
        r1 = r3.message;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r2.aTd;
        r3 = r3.aTd;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0029;
    L_0x0027:
        r3 = 0;
        return r3;
    L_0x0029:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.microservices.billing.response.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Boolean bool = this.isSuccessful;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.message;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        b bVar = this.aTd;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CashboxResult(isSuccessful=");
        stringBuilder.append(this.isSuccessful);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", cashboxCounting=");
        stringBuilder.append(this.aTd);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(Boolean bool, String str, b bVar) {
        this.isSuccessful = bool;
        this.message = str;
        this.aTd = bVar;
    }

    public /* synthetic */ a(Boolean bool, String str, b bVar, int i, f fVar) {
        if ((i & 1) != 0) {
            bool = Boolean.valueOf(false);
        }
        if ((i & 2) != 0) {
            str = (String) null;
        }
        if ((i & 4) != 0) {
            bVar = (b) null;
        }
        this(bool, str, bVar);
    }

    public final b Uw() {
        return this.aTd;
    }
}
