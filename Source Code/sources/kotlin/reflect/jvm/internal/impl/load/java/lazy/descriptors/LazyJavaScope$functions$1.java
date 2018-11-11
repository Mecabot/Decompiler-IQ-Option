package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.i;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$functions$1 extends Lambda implements b<f, List<? extends ah>> {
    final /* synthetic */ k this$0;

    LazyJavaScope$functions$1(k kVar) {
        this.this$0 = kVar;
        super(1);
    }

    /* renamed from: z */
    public final List<ah> invoke(f fVar) {
        h.e(fVar, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (q qVar : ((b) this.this$0.bgQ().invoke()).r(fVar)) {
            JavaMethodDescriptor c = this.this$0.c(qVar);
            if (this.this$0.a(c)) {
                this.this$0.bgT().bgq().bga().a(qVar, (ah) c);
                linkedHashSet.add(c);
            }
        }
        Collection collection = linkedHashSet;
        i.U(collection);
        this.this$0.a(collection, fVar);
        return u.W(this.this$0.bgT().bgq().bgi().a(this.this$0.bgT(), collection));
    }
}
