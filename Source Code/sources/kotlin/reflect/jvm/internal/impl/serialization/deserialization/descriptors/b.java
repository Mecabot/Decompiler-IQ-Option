package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: DeserializedAnnotations.kt */
public class b implements g {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final e eTx;

    private final List<f> bxS() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eTx, (Object) this, apP[0]);
    }

    public b(h hVar, a<? extends List<f>> aVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(aVar, "compute");
        this.eTx = hVar.i(aVar);
    }

    public boolean k(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.b(this, bVar);
    }

    public boolean isEmpty() {
        return bxS().isEmpty();
    }

    public c j(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        for (Object next : bxS()) {
            Object obj;
            f fVar = (f) next;
            c beh = fVar.beh();
            if (fVar.bei() == null && kotlin.jvm.internal.h.E(beh.bdD(), bVar)) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        f fVar2 = (f) next2;
        if (fVar2 != null) {
            return fVar2.bef();
        }
        return null;
    }

    public List<f> bej() {
        Collection arrayList = new ArrayList();
        for (Object next : bxS()) {
            if ((((f) next).beg() != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public List<f> bek() {
        return bxS();
    }

    public Iterator<c> iterator() {
        return m.f(m.b(u.ac(bxS()), DeserializedAnnotationsWithPossibleTargets$iterator$1.eTy), DeserializedAnnotationsWithPossibleTargets$iterator$2.eTz).iterator();
    }
}
