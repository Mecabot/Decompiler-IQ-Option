package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: specialBuiltinMembers.kt */
final class o {
    private final f eBW;
    private final String signature;

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.signature, r3.signature) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.java.o;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.load.java.o) r3;
        r0 = r2.eBW;
        r1 = r3.eBW;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.signature;
        r3 = r3.signature;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.o.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        f fVar = this.eBW;
        int i = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NameAndSignature(name=");
        stringBuilder.append(this.eBW);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public o(f fVar, String str) {
        h.e(fVar, "name");
        h.e(str, "signature");
        this.eBW = fVar;
        this.signature = str;
    }

    public final f bdc() {
        return this.eBW;
    }

    public final String getSignature() {
        return this.signature;
    }
}
