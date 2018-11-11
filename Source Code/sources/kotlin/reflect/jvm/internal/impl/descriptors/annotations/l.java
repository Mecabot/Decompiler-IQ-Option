package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

/* compiled from: Annotations.kt */
public final class l implements g {
    private final g eBQ;
    private final b<kotlin.reflect.jvm.internal.impl.name.b, Boolean> eBR;

    public l(g gVar, b<? super kotlin.reflect.jvm.internal.impl.name.b, Boolean> bVar) {
        h.e(gVar, "delegate");
        h.e(bVar, "fqNameFilter");
        this.eBQ = gVar;
        this.eBR = bVar;
    }

    public boolean k(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return ((Boolean) this.eBR.invoke(bVar)).booleanValue() ? this.eBQ.k(bVar) : false;
    }

    public c j(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return ((Boolean) this.eBR.invoke(bVar)).booleanValue() ? this.eBQ.j(bVar) : null;
    }

    public List<f> bej() {
        Collection arrayList = new ArrayList();
        for (Object next : this.eBQ.bej()) {
            if (b(((f) next).bef())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public List<f> bek() {
        Collection arrayList = new ArrayList();
        for (Object next : this.eBQ.bek()) {
            if (b(((f) next).bef())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public Iterator<c> iterator() {
        Collection arrayList = new ArrayList();
        for (Object next : this.eBQ) {
            if (b((c) next)) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).iterator();
    }

    public boolean isEmpty() {
        Iterable<c> iterable = this.eBQ;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (c b : iterable) {
            if (b(b)) {
                return true;
            }
        }
        return false;
    }

    private final boolean b(c cVar) {
        kotlin.reflect.jvm.internal.impl.name.b bdD = cVar.bdD();
        return bdD != null && ((Boolean) this.eBR.invoke(bdD)).booleanValue();
    }
}
