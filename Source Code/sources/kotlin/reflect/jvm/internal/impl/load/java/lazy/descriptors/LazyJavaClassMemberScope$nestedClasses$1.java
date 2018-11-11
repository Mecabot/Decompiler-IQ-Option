package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.n;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements b<f, g> {
    final /* synthetic */ h $c;
    final /* synthetic */ g this$0;

    LazyJavaClassMemberScope$nestedClasses$1(g gVar, h hVar) {
        this.this$0 = gVar;
        this.$c = hVar;
        super(1);
    }

    /* renamed from: y */
    public final g invoke(f fVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        n nVar = null;
        if (((Set) this.this$0.eHD.invoke()).contains(fVar)) {
            f fVar2;
            kotlin.reflect.jvm.internal.impl.load.java.g bfV = this.$c.bgq().bfV();
            a c = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(this.this$0.bgJ());
            if (c == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            kotlin.reflect.jvm.internal.impl.load.java.structure.g a = bfV.a(c.B(fVar));
            if (a != null) {
                h hVar = this.$c;
                k bgI = this.this$0.bgJ();
                kotlin.jvm.internal.h.d(a, "it");
                f fVar3 = new f(hVar, bgI, a, null, 8, null);
                this.$c.bgq().bgj().a(fVar3);
            } else {
                fVar2 = null;
            }
            return fVar2;
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.n nVar2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.n) ((Map) this.this$0.eHE.invoke()).get(fVar);
        if (nVar2 != null) {
            f fVar4 = fVar;
            nVar = n.a(this.$c.baI(), this.this$0.bgJ(), fVar4, this.$c.baI().i(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this)), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.$c, nVar2), this.$c.bgq().bgc().a(nVar2));
        }
        return nVar;
    }
}
