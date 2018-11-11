package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: CompositePackageFragmentProvider.kt */
public final class i implements y {
    private final List<y> providers;

    public i(List<? extends y> list) {
        h.e(list, "providers");
        this.providers = list;
    }

    public List<x> i(b bVar) {
        h.e(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        for (y i : this.providers) {
            arrayList.addAll(i.i(bVar));
        }
        return u.W(arrayList);
    }

    public Collection<b> a(b bVar, kotlin.jvm.a.b<? super f, Boolean> bVar2) {
        h.e(bVar, "fqName");
        h.e(bVar2, "nameFilter");
        HashSet hashSet = new HashSet();
        for (y a : this.providers) {
            hashSet.addAll(a.a(bVar, bVar2));
        }
        return hashSet;
    }
}
