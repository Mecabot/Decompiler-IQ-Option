package com.iqoption.vip;

import java.util.Date;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, aXE = {"Lcom/iqoption/vip/WorkingPeriod;", "", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;)V", "getEndDate", "()Ljava/util/Date;", "getStartDate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WorkingPeriod.kt */
public final class j {
    private final Date dLB;
    private final Date dLC;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.dLC, r3.dLC) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.vip.j;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (com.iqoption.vip.j) r3;
        r0 = r2.dLB;
        r1 = r3.dLB;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.dLC;
        r3 = r3.dLC;
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
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.vip.j.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Date date = this.dLB;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.dLC;
        if (date2 != null) {
            i = date2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WorkingPeriod(startDate=");
        stringBuilder.append(this.dLB);
        stringBuilder.append(", endDate=");
        stringBuilder.append(this.dLC);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public j(Date date, Date date2) {
        h.e(date, "startDate");
        h.e(date2, "endDate");
        this.dLB = date;
        this.dLC = date2;
    }

    public final Date getEndDate() {
        return this.dLC;
    }

    public final Date getStartDate() {
        return this.dLB;
    }
}
