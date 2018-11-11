package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;

/* compiled from: context.kt */
public final class k {
    private final f eHe;
    private final Collection<QualifierApplicabilityType> eHf;

    public final f bgt() {
        return this.eHe;
    }

    public final Collection<QualifierApplicabilityType> bgu() {
        return this.eHf;
    }

    /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eHf, r3.eHf) != false) goto L_0x001f;
     */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001f;
    L_0x0002:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r3 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.k) r3;
        r0 = r2.eHe;
        r1 = r3.eHe;
        r0 = kotlin.jvm.internal.h.E(r0, r1);
        if (r0 == 0) goto L_0x001d;
    L_0x0012:
        r0 = r2.eHf;
        r3 = r3.eHf;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.k.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        f fVar = this.eHe;
        int i = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        Collection collection = this.eHf;
        if (collection != null) {
            i = collection.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NullabilityQualifierWithApplicability(nullabilityQualifier=");
        stringBuilder.append(this.eHe);
        stringBuilder.append(", qualifierApplicabilityTypes=");
        stringBuilder.append(this.eHf);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public k(f fVar, Collection<? extends QualifierApplicabilityType> collection) {
        h.e(fVar, "nullabilityQualifier");
        h.e(collection, "qualifierApplicabilityTypes");
        this.eHe = fVar;
        this.eHf = collection;
    }
}
