package com.iqoption.withdrawal.common.history;

import com.iqoption.microservice.withdraw.response.l;
import java.util.List;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, aXE = {"Lcom/iqoption/withdrawal/common/history/AdapterData;", "", "payouts", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "cancellationProgress", "", "", "(Ljava/util/List;Ljava/util/Set;)V", "getCancellationProgress", "()Ljava/util/Set;", "getPayouts", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryAdapter.kt */
public final class a {
    private final List<l> dRb;
    private final Set<Long> dRc;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.dRc, r3.dRc) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.withdrawal.common.history.a;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.withdrawal.common.history.a) r3;
        r0 = r2.dRb;
        r1 = r3.dRb;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.dRc;
        r3 = r3.dRc;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.history.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List list = this.dRb;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Set set = this.dRc;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdapterData(payouts=");
        stringBuilder.append(this.dRb);
        stringBuilder.append(", cancellationProgress=");
        stringBuilder.append(this.dRc);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(List<l> list, Set<Long> set) {
        h.e(list, "payouts");
        h.e(set, "cancellationProgress");
        this.dRb = list;
        this.dRc = set;
    }

    public final List<l> aND() {
        return this.dRb;
    }

    public final Set<Long> aNE() {
        return this.dRc;
    }
}
