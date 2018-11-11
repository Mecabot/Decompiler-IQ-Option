package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: CapturedTypeApproximation.kt */
final class CapturedTypeApproximationKt$approximateCapturedTypes$1 extends Lambda implements b<w, w> {
    final /* synthetic */ w $type;

    CapturedTypeApproximationKt$approximateCapturedTypes$1(w wVar) {
        this.$type = wVar;
        super(1);
    }

    /* renamed from: am */
    public final w invoke(w wVar) {
        h.e(wVar, "$receiver");
        return au.c(wVar, this.$type.aYp());
    }
}
