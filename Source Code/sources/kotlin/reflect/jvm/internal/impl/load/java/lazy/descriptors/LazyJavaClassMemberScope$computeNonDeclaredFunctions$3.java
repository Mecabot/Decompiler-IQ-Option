package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$computeNonDeclaredFunctions$3 extends FunctionReference implements b<f, Collection<? extends ah>> {
    LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(g gVar) {
        super(1, gVar);
    }

    public final d Py() {
        return j.F(g.class);
    }

    public final String getName() {
        return "searchMethodsByNameWithoutBuiltinMagic";
    }

    public final String getSignature() {
        return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    /* renamed from: h */
    public final Collection<ah> invoke(f fVar) {
        h.e(fVar, "p1");
        return ((g) this.receiver).u(fVar);
    }
}
