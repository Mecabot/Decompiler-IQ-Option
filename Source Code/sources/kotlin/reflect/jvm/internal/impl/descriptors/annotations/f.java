package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.h;

/* compiled from: AnnotationWithTarget.kt */
public final class f {
    private final c eBD;
    private final AnnotationUseSiteTarget eBE;

    public final c beh() {
        return this.eBD;
    }

    public final AnnotationUseSiteTarget bei() {
        return this.eBE;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eBE, r3.eBE) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.f) r3;
        r0 = r2.eBD;
        r1 = r3.eBD;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eBE;
        r3 = r3.eBE;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        c cVar = this.eBD;
        int i = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        AnnotationUseSiteTarget annotationUseSiteTarget = this.eBE;
        if (annotationUseSiteTarget != null) {
            i = annotationUseSiteTarget.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AnnotationWithTarget(annotation=");
        stringBuilder.append(this.eBD);
        stringBuilder.append(", target=");
        stringBuilder.append(this.eBE);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(c cVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        h.e(cVar, "annotation");
        this.eBD = cVar;
        this.eBE = annotationUseSiteTarget;
    }

    public final c bef() {
        return this.eBD;
    }

    public final AnnotationUseSiteTarget beg() {
        return this.eBE;
    }
}
