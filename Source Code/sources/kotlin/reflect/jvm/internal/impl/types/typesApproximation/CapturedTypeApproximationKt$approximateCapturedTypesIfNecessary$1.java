package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c;
import kotlin.reflect.jvm.internal.impl.types.ay;

/* compiled from: CapturedTypeApproximation.kt */
final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 extends Lambda implements b<ay, Boolean> {
    public static final CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 eVT = new CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1();

    CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(a((ay) obj));
    }

    public final boolean a(ay ayVar) {
        h.d(ayVar, "it");
        return c.au(ayVar);
    }
}
