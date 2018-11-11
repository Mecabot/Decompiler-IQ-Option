package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.p;

/* compiled from: LazyJavaStaticClassScope.kt */
final class LazyJavaStaticClassScope$computeMemberIndex$1 extends Lambda implements b<p, Boolean> {
    public static final LazyJavaStaticClassScope$computeMemberIndex$1 eIa = new LazyJavaStaticClassScope$computeMemberIndex$1();

    LazyJavaStaticClassScope$computeMemberIndex$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(b((p) obj));
    }

    public final boolean b(p pVar) {
        h.e(pVar, "it");
        return pVar.isStatic();
    }
}
