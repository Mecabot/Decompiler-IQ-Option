package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ConstUtil.kt */
public final class i {
    public static final boolean L(w wVar) {
        h.e(wVar, "$receiver");
        return ((g.p(wVar) || k.ezF.I(wVar)) && !au.aW(wVar)) || g.H(wVar);
    }
}
