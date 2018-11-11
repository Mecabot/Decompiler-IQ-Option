package com.iqoption.microservice.withdraw.response;

import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "", "cards", "", "Lcom/iqoption/microservice/withdraw/response/Card;", "methods", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethod;", "(Ljava/util/List;Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "getMethods", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CardsAndWithdrawMethods.kt */
public final class d {
    private final List<b> cTu;
    private final List<h> methods;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.methods, r3.methods) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.microservice.withdraw.response.d;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.microservice.withdraw.response.d) r3;
        r0 = r2.cTu;
        r1 = r3.cTu;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.methods;
        r3 = r3.methods;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.microservice.withdraw.response.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.cTu;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List list2 = this.methods;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CardsAndWithdrawMethods(cards=");
        stringBuilder.append(this.cTu);
        stringBuilder.append(", methods=");
        stringBuilder.append(this.methods);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(List<b> list, List<h> list2) {
        h.e(list, "cards");
        h.e(list2, "methods");
        this.cTu = list;
        this.methods = list2;
    }

    public final List<b> atB() {
        return this.cTu;
    }

    public final List<h> atC() {
        return this.methods;
    }
}
