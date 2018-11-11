package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: AnnotationTypeQualifierResolver.kt */
final class AnnotationTypeQualifierResolver$resolvedNicknames$1 extends FunctionReference implements b<d, c> {
    AnnotationTypeQualifierResolver$resolvedNicknames$1(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(1, annotationTypeQualifierResolver);
    }

    public final kotlin.reflect.d Py() {
        return j.F(AnnotationTypeQualifierResolver.class);
    }

    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    /* renamed from: w */
    public final c invoke(d dVar) {
        h.e(dVar, "p1");
        return ((AnnotationTypeQualifierResolver) this.receiver).t(dVar);
    }
}
