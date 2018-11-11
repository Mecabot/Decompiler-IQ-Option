package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: AbstractTypeAliasDescriptor.kt */
final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements b<ay, Boolean> {
    final /* synthetic */ d this$0;

    AbstractTypeAliasDescriptor$isInner$1(d dVar) {
        this.this$0 = dVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(a((ay) obj));
    }

    public final boolean a(ay ayVar) {
        h.d(ayVar, Param.TYPE);
        if (y.aF(ayVar)) {
            return false;
        }
        d dVar = this.this$0;
        f bbW = ayVar.bwA().bbW();
        Object obj = (!(bbW instanceof an) || (h.E(((an) bbW).bbv(), this.this$0) ^ 1) == 0) ? null : 1;
        if (obj != null) {
            return true;
        }
        return false;
    }
}
