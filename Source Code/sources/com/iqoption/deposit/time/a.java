package com.iqoption.deposit.time;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, aXE = {"Lcom/iqoption/deposit/time/MethodTime;", "", "id", "", "min", "max", "unit", "Lcom/iqoption/deposit/time/MethodTimeUnit;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/iqoption/deposit/time/MethodTimeUnit;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMax", "setMax", "getMin", "setMin", "getUnit", "()Lcom/iqoption/deposit/time/MethodTimeUnit;", "setUnit", "(Lcom/iqoption/deposit/time/MethodTimeUnit;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/iqoption/deposit/time/MethodTimeUnit;)Lcom/iqoption/deposit/time/MethodTime;", "equals", "", "other", "hashCode", "toString", "", "deposit_release"})
/* compiled from: MethodTime.kt */
public final class a {
    private Integer ccp;
    private MethodTimeUnit ccq;
    private Integer id;
    private Integer min;

    public a() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (kotlin.jvm.internal.h.E(r2.ccq, r3.ccq) != false) goto L_0x0033;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0033;
    L_0x0002:
        r0 = r3 instanceof com.iqoption.deposit.time.a;
        if (r0 == 0) goto L_0x0031;
    L_0x0006:
        r3 = (com.iqoption.deposit.time.a) r3;
        r0 = r2.id;
        r1 = r3.id;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0012:
        r0 = r2.min;
        r1 = r3.min;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x001c:
        r0 = r2.ccp;
        r1 = r3.ccp;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = r2.ccq;
        r3 = r3.ccq;
        r3 = kotlin.jvm.internal.h.E(r0, r3);
        if (r3 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r3 = 0;
        return r3;
    L_0x0033:
        r3 = 1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.deposit.time.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.id;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.min;
        hashCode = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        num2 = this.ccp;
        hashCode = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        MethodTimeUnit methodTimeUnit = this.ccq;
        if (methodTimeUnit != null) {
            i = methodTimeUnit.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MethodTime(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", min=");
        stringBuilder.append(this.min);
        stringBuilder.append(", max=");
        stringBuilder.append(this.ccp);
        stringBuilder.append(", unit=");
        stringBuilder.append(this.ccq);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(Integer num, Integer num2, Integer num3, MethodTimeUnit methodTimeUnit) {
        this.id = num;
        this.min = num2;
        this.ccp = num3;
        this.ccq = methodTimeUnit;
    }

    public /* synthetic */ a(Integer num, Integer num2, Integer num3, MethodTimeUnit methodTimeUnit, int i, f fVar) {
        if ((i & 1) != 0) {
            num = (Integer) null;
        }
        if ((i & 2) != 0) {
            num2 = (Integer) null;
        }
        if ((i & 4) != 0) {
            num3 = (Integer) null;
        }
        if ((i & 8) != 0) {
            methodTimeUnit = (MethodTimeUnit) null;
        }
        this(num, num2, num3, methodTimeUnit);
    }

    public final Integer Je() {
        return this.id;
    }

    public final void e(Integer num) {
        this.id = num;
    }

    public final Integer getMin() {
        return this.min;
    }

    public final void setMin(Integer num) {
        this.min = num;
    }

    public final Integer aee() {
        return this.ccp;
    }

    public final void f(Integer num) {
        this.ccp = num;
    }

    public final void a(MethodTimeUnit methodTimeUnit) {
        this.ccq = methodTimeUnit;
    }

    public final MethodTimeUnit aef() {
        return this.ccq;
    }
}
