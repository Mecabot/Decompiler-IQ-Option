package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: typeEnhancement.kt */
final class b implements g {
    private final kotlin.reflect.jvm.internal.impl.name.b eIw;

    public boolean isEmpty() {
        return false;
    }

    public b(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqNameToMatch");
        this.eIw = bVar;
    }

    public boolean k(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.b(this, bVar);
    }

    /* renamed from: s */
    public a j(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return h.E(bVar, this.eIw) ? a.eIv : null;
    }

    public List<f> bek() {
        Iterable<c> iterable = this;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (c fVar : iterable) {
            arrayList.add(new f(fVar, null));
        }
        return (List) arrayList;
    }

    public List<f> bej() {
        return m.emptyList();
    }

    public Iterator<c> iterator() {
        return m.emptyList().iterator();
    }
}
