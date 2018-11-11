package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* compiled from: overridingUtils.kt */
final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements b<H, l> {
    final /* synthetic */ i $conflictedHandles;

    OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(i iVar) {
        this.$conflictedHandles = iVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        bs(obj);
        return l.etX;
    }

    public final void bs(H h) {
        i iVar = this.$conflictedHandles;
        h.d(h, "it");
        iVar.add(h);
    }
}
