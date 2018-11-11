package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.EnumMap;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;

/* compiled from: context.kt */
public final class d {
    private final EnumMap<QualifierApplicabilityType, f> eGR;

    public d(EnumMap<QualifierApplicabilityType, f> enumMap) {
        h.e(enumMap, "nullabilityQualifiers");
        this.eGR = enumMap;
    }

    public final EnumMap<QualifierApplicabilityType, f> bgm() {
        return this.eGR;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d c(QualifierApplicabilityType qualifierApplicabilityType) {
        f fVar = (f) this.eGR.get(qualifierApplicabilityType);
        if (fVar != null) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d(fVar.bhX(), null, false, fVar.bhY());
        }
        return null;
    }
}
