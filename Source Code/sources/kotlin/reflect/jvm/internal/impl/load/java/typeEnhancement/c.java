package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: typeEnhancement.kt */
final class c<T> {
    private final g eIx;
    private final T result;

    public final T aXG() {
        return this.result;
    }

    public final g bhP() {
        return this.eIx;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eIx, r3.eIx) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c) r3;
        r0 = r2.result;
        r1 = r3.result;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eIx;
        r3 = r3.eIx;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Object obj = this.result;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        g gVar = this.eIx;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EnhancementResult(result=");
        stringBuilder.append(this.result);
        stringBuilder.append(", enhancementAnnotations=");
        stringBuilder.append(this.eIx);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public c(T t, g gVar) {
        this.result = t;
        this.eIx = gVar;
    }
}
