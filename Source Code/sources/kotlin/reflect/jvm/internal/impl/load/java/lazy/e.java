package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.a;
import kotlin.reflect.jvm.internal.impl.load.java.structure.d;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.storage.c;

/* compiled from: LazyJavaAnnotations.kt */
public final class e implements g {
    private final c<a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> eGS = this.eGT.bgq().baI().p(new LazyJavaAnnotations$annotationDescriptors$1(this));
    private final h eGT;
    private final d eGU;

    public e(h hVar, d dVar) {
        h.e(hVar, "c");
        h.e(dVar, "annotationOwner");
        this.eGT = hVar;
        this.eGU = dVar;
    }

    public boolean k(b bVar) {
        h.e(bVar, "fqName");
        return g.b.b(this, bVar);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j(b bVar) {
        h.e(bVar, "fqName");
        a r = this.eGU.r(bVar);
        if (r != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) this.eGS.invoke(r);
            if (cVar != null) {
                return cVar;
            }
        }
        return kotlin.reflect.jvm.internal.impl.load.java.components.c.eGc.a(bVar, this.eGU, this.eGT);
    }

    public List<f> bej() {
        return m.emptyList();
    }

    public List<f> bek() {
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterable = this;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c fVar : iterable) {
            arrayList.add(new f(fVar, null));
        }
        return (List) arrayList;
    }

    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        kotlin.sequences.h f = m.f(u.ac(this.eGU.getAnnotations()), this.eGS);
        kotlin.reflect.jvm.internal.impl.load.java.components.c cVar = kotlin.reflect.jvm.internal.impl.load.java.components.c.eGc;
        b bVar = kotlin.reflect.jvm.internal.impl.builtins.g.exC.eyg;
        h.d(bVar, "KotlinBuiltIns.FQ_NAMES.deprecated");
        return m.e(m.a(f, (Object) cVar.a(bVar, this.eGU, this.eGT))).iterator();
    }

    public boolean isEmpty() {
        return this.eGU.getAnnotations().isEmpty() && !this.eGU.bhm();
    }
}
