package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;

/* compiled from: DeserializedAnnotations.kt */
final class DeserializedAnnotationsWithPossibleTargets$iterator$2 extends Lambda implements b<f, c> {
    public static final DeserializedAnnotationsWithPossibleTargets$iterator$2 eTz = new DeserializedAnnotationsWithPossibleTargets$iterator$2();

    DeserializedAnnotationsWithPossibleTargets$iterator$2() {
        super(1);
    }

    /* renamed from: b */
    public final c invoke(f fVar) {
        h.e(fVar, "it");
        return fVar.bef();
    }
}
