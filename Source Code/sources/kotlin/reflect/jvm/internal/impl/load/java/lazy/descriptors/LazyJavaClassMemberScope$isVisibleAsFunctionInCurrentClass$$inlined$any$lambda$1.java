package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1 extends Lambda implements b<f, Collection<? extends ah>> {
    final /* synthetic */ ah $function$inlined;
    final /* synthetic */ g this$0;

    LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1(g gVar, ah ahVar) {
        this.this$0 = gVar;
        this.$function$inlined = ahVar;
        super(1);
    }

    /* renamed from: h */
    public final Collection<ah> invoke(f fVar) {
        h.e(fVar, "accessorName");
        if (h.E(this.$function$inlined.bdc(), fVar)) {
            return l.cr(this.$function$inlined);
        }
        return u.b(this.this$0.u(fVar), (Iterable) this.this$0.v(fVar));
    }
}
