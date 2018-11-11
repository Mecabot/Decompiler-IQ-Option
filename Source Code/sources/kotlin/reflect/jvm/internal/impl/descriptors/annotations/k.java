package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: Annotations.kt */
public final class k implements g {
    private final List<g> eBO;

    public k(List<? extends g> list) {
        h.e(list, "delegates");
        this.eBO = list;
    }

    public k(g... gVarArr) {
        h.e(gVarArr, "delegates");
        this(i.A(gVarArr));
    }

    public boolean isEmpty() {
        Iterable<g> iterable = this.eBO;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (g isEmpty : iterable) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean k(b bVar) {
        h.e(bVar, "fqName");
        for (g k : u.ac(this.eBO)) {
            if (k.k(bVar)) {
                return true;
            }
        }
        return false;
    }

    public c j(b bVar) {
        h.e(bVar, "fqName");
        return (c) m.d(m.g(u.ac(this.eBO), new CompositeAnnotations$findAnnotation$1(bVar)));
    }

    public List<f> bej() {
        Collection arrayList = new ArrayList();
        for (g bej : this.eBO) {
            r.a(arrayList, (Iterable) bej.bej());
        }
        return (List) arrayList;
    }

    public List<f> bek() {
        Collection arrayList = new ArrayList();
        for (g bek : this.eBO) {
            r.a(arrayList, (Iterable) bek.bek());
        }
        return (List) arrayList;
    }

    public Iterator<c> iterator() {
        return m.e(u.ac(this.eBO), CompositeAnnotations$iterator$1.eBP).iterator();
    }
}
