package kotlin.f;

import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, aXE = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
/* compiled from: RangesJVM.kt */
final class a implements b<Float> {
    private final float euB;
    private final float euC;

    public a(float f, float f2) {
        this.euB = f;
        this.euC = f2;
    }

    public /* synthetic */ boolean contains(Comparable comparable) {
        return ag(((Number) comparable).floatValue());
    }

    public boolean ag(float f) {
        return f >= this.euB && f <= this.euC;
    }

    public boolean isEmpty() {
        return this.euB > this.euC;
    }

    /* JADX WARNING: Missing block: B:9:0x0023, code:
            if (r2.euC == r3.euC) goto L_0x0025;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        r0 = r3 instanceof kotlin.f.a;
        if (r0 == 0) goto L_0x0027;
    L_0x0004:
        r0 = r2.isEmpty();
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r3;
        r0 = (kotlin.f.a) r0;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0025;
    L_0x0013:
        r0 = r2.euB;
        r3 = (kotlin.f.a) r3;
        r1 = r3.euB;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 != 0) goto L_0x0027;
    L_0x001d:
        r0 = r2.euC;
        r3 = r3.euC;
        r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r3 != 0) goto L_0x0027;
    L_0x0025:
        r3 = 1;
        goto L_0x0028;
    L_0x0027:
        r3 = 0;
    L_0x0028:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.f.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return isEmpty() ? -1 : (Float.valueOf(this.euB).hashCode() * 31) + Float.valueOf(this.euC).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.euB);
        stringBuilder.append("..");
        stringBuilder.append(this.euC);
        return stringBuilder.toString();
    }
}
