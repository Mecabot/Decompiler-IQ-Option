package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeApproximation.kt */
final class CapturedTypeApproximationKt$toTypeProjection$2 extends Lambda implements b<Variance, Variance> {
    final /* synthetic */ d receiver$0;

    CapturedTypeApproximationKt$toTypeProjection$2(d dVar) {
        this.receiver$0 = dVar;
        super(1);
    }

    /* renamed from: b */
    public final Variance invoke(Variance variance) {
        h.e(variance, "variance");
        return variance == this.receiver$0.bzt().bdd() ? Variance.INVARIANT : variance;
    }
}
