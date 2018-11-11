package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.a;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.g;
import kotlin.reflect.jvm.internal.impl.types.v;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: NewKotlinTypeChecker.kt */
public final class i {
    public static final boolean f(ad adVar) {
        h.e(adVar, "$receiver");
        return adVar.bwA().bbW() instanceof d;
    }

    public static final boolean g(ad adVar) {
        h.e(adVar, "$receiver");
        return (y.aF((w) adVar) || (adVar.bwA().bbW() instanceof am) || (adVar.bwA().bbW() == null && !(adVar instanceof a) && !(adVar instanceof d) && !(adVar instanceof g))) ? false : true;
    }

    public static final boolean h(ad adVar) {
        h.e(adVar, "$receiver");
        return adVar.bwA() instanceof v;
    }
}
