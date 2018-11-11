package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

/* compiled from: CapturedTypeApproximation.kt */
public final class a<T> {
    private final T eVR;
    private final T eVS;

    public final T aXG() {
        return this.eVR;
    }

    public final T aXH() {
        return this.eVS;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eVS, r3.eVS) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.types.typesApproximation.a;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.types.typesApproximation.a) r3;
        r0 = r2.eVR;
        r1 = r3.eVR;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eVS;
        r3 = r3.eVS;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typesApproximation.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Object obj = this.eVR;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.eVS;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApproximationBounds(lower=");
        stringBuilder.append(this.eVR);
        stringBuilder.append(", upper=");
        stringBuilder.append(this.eVS);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(T t, T t2) {
        this.eVR = t;
        this.eVS = t2;
    }

    public final T bzq() {
        return this.eVR;
    }

    public final T bzr() {
        return this.eVS;
    }
}
