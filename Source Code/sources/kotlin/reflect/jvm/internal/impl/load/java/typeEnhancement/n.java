package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: signatureEnhancement.kt */
final class n {
    private final d eJf;
    private final w ewu;

    public final w bil() {
        return this.ewu;
    }

    public final d bim() {
        return this.eJf;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eJf, r3.eJf) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n) r3;
        r0 = r2.ewu;
        r1 = r3.ewu;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eJf;
        r3 = r3.eJf;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.n.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        w wVar = this.ewu;
        int i = 0;
        int hashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
        d dVar = this.eJf;
        if (dVar != null) {
            i = dVar.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TypeAndDefaultQualifiers(type=");
        stringBuilder.append(this.ewu);
        stringBuilder.append(", defaultQualifiers=");
        stringBuilder.append(this.eJf);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public n(w wVar, d dVar) {
        h.e(wVar, Param.TYPE);
        this.ewu = wVar;
        this.eJf = dVar;
    }

    public final w bai() {
        return this.ewu;
    }
}
