package com.iqoption.verify.status;

import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, aXE = {"Lcom/iqoption/verify/status/PerformVerifyData;", "", "verifyInitResult", "Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "country", "Lcom/iqoption/dto/entity/iqbus/Country;", "(Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;Lcom/iqoption/dto/entity/iqbus/Country;)V", "getCountry", "()Lcom/iqoption/dto/entity/iqbus/Country;", "getVerifyInitResult", "()Lcom/iqoption/dto/entity/iqbus/VerifyInitResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: PerformVerifyViewModel.kt */
public final class f {
    private final VerifyInitResult dyb;
    private final Country dyc;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.dyc, r3.dyc) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.verify.status.f;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.verify.status.f) r3;
        r0 = r2.dyb;
        r1 = r3.dyb;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.dyc;
        r3 = r3.dyc;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.verify.status.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        VerifyInitResult verifyInitResult = this.dyb;
        int i = 0;
        int hashCode = (verifyInitResult != null ? verifyInitResult.hashCode() : 0) * 31;
        Country country = this.dyc;
        if (country != null) {
            i = country.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PerformVerifyData(verifyInitResult=");
        stringBuilder.append(this.dyb);
        stringBuilder.append(", country=");
        stringBuilder.append(this.dyc);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(VerifyInitResult verifyInitResult, Country country) {
        h.e(verifyInitResult, "verifyInitResult");
        h.e(country, "country");
        this.dyb = verifyInitResult;
        this.dyc = country;
    }

    public final VerifyInitResult aHh() {
        return this.dyb;
    }

    public final Country aHi() {
        return this.dyc;
    }
}
