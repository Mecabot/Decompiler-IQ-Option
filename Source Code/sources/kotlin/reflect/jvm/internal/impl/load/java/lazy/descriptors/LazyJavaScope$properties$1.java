package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.c;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$properties$1 extends Lambda implements b<f, List<? extends ad>> {
    final /* synthetic */ k this$0;

    LazyJavaScope$properties$1(k kVar) {
        this.this$0 = kVar;
        super(1);
    }

    /* renamed from: z */
    public final List<ad> invoke(f fVar) {
        h.e(fVar, "name");
        ArrayList arrayList = new ArrayList();
        n s = ((b) this.this$0.bgQ().invoke()).s(fVar);
        if (!(s == null || s.bhC())) {
            arrayList.add(this.this$0.a(s));
        }
        Collection collection = arrayList;
        this.this$0.b(fVar, collection);
        if (c.I(this.this$0.bgJ())) {
            return u.W(arrayList);
        }
        return u.W(this.this$0.bgT().bgq().bgi().a(this.this$0.bgT(), collection));
    }
}
