package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: AnnotationsImpl.kt */
public final class h implements g {
    public static final a eBK = new a();
    private final List<c> eBI;
    private final List<f> eBJ;

    /* compiled from: AnnotationsImpl.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c j(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return g.b.a(this, bVar);
    }

    public boolean k(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return g.b.b(this, bVar);
    }

    public h(List<? extends c> list) {
        kotlin.jvm.internal.h.e(list, "annotations");
        this.eBI = list;
        Iterable<c> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (c fVar : iterable) {
            arrayList.add(new f(fVar, null));
        }
        this.eBJ = (List) arrayList;
    }

    public boolean isEmpty() {
        return this.eBJ.isEmpty();
    }

    public List<f> bej() {
        Collection arrayList = new ArrayList();
        for (Object next : this.eBJ) {
            if ((((f) next).beg() != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        Iterable<f> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(n.e(iterable, 10));
        for (f fVar : iterable) {
            c bef = fVar.bef();
            AnnotationUseSiteTarget beg = fVar.beg();
            if (beg == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            arrayList2.add(new f(bef, beg));
        }
        return (List) arrayList2;
    }

    public List<f> bek() {
        return this.eBJ;
    }

    public Iterator<c> iterator() {
        return this.eBI.iterator();
    }

    public String toString() {
        return this.eBI.toString();
    }
}
