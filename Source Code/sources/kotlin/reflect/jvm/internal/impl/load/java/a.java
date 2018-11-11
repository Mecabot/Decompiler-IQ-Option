package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import java.util.Set;
import kotlin.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class a {
    private static final b eEA = new b("javax.annotation.meta.TypeQualifier");
    private static final b eEB = new b("javax.annotation.meta.TypeQualifierDefault");
    private static final b eEC = new b("kotlin.annotations.jvm.UnderMigration");
    private static final Map<b, k> eED = ad.a(j.D(new b("javax.annotation.ParametersAreNullableByDefault"), new k(new f(NullabilityQualifier.NULLABLE, false, 2, null), l.cr(QualifierApplicabilityType.VALUE_PARAMETER))), j.D(new b("javax.annotation.ParametersAreNonnullByDefault"), new k(new f(NullabilityQualifier.NOT_NULL, false, 2, null), l.cr(QualifierApplicabilityType.VALUE_PARAMETER))));
    private static final Set<b> eEE = aj.I(n.bfE(), n.bfF());
    private static final b eEz = new b("javax.annotation.meta.TypeQualifierNickname");

    private static final boolean x(d dVar) {
        return eEE.contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x((kotlin.reflect.jvm.internal.impl.descriptors.k) dVar)) || dVar.bbQ().k(eEA);
    }
}
