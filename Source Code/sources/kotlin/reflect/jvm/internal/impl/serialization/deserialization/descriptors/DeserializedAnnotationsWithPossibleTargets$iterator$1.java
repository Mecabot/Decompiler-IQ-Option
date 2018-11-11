package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;

/* compiled from: DeserializedAnnotations.kt */
final class DeserializedAnnotationsWithPossibleTargets$iterator$1 extends Lambda implements b<f, Boolean> {
    public static final DeserializedAnnotationsWithPossibleTargets$iterator$1 eTy = new DeserializedAnnotationsWithPossibleTargets$iterator$1();

    DeserializedAnnotationsWithPossibleTargets$iterator$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(a((f) obj));
    }

    public final boolean a(f fVar) {
        h.e(fVar, "it");
        return fVar.beg() == null;
    }
}
