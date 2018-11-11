package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$computeNonDeclaredProperties$1 extends Lambda implements b<f, Collection<? extends ah>> {
    final /* synthetic */ g this$0;

    LazyJavaClassMemberScope$computeNonDeclaredProperties$1(g gVar) {
        this.this$0 = gVar;
        super(1);
    }

    /* renamed from: h */
    public final Collection<ah> invoke(f fVar) {
        h.e(fVar, "it");
        return this.this$0.u(fVar);
    }
}
