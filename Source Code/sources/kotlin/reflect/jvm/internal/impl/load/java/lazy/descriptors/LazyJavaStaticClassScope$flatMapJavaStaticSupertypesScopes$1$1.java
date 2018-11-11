package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1 extends Lambda implements b<w, d> {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1 eId = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1();

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1() {
        super(1);
    }

    /* renamed from: X */
    public final d invoke(w wVar) {
        f bbW = wVar.bwA().bbW();
        if (!(bbW instanceof d)) {
            bbW = null;
        }
        return (d) bbW;
    }
}
