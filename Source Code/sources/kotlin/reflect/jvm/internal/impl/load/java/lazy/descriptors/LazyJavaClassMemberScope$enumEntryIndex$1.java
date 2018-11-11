package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements a<Map<f, ? extends n>> {
    final /* synthetic */ g this$0;

    LazyJavaClassMemberScope$enumEntryIndex$1(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: adu */
    public final Map<f, n> invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.this$0.eHk.bhu()) {
            if (((n) next).bhC()) {
                arrayList.add(next);
            }
        }
        Iterable iterable = (List) arrayList;
        Map<f, n> linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
        for (Object next2 : iterable) {
            linkedHashMap.put(((n) next2).bdc(), next2);
        }
        return linkedHashMap;
    }
}
