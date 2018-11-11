package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.i;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* compiled from: SubpackagesScope.kt */
public class ad extends i {
    private final u eAh;
    private final b eBM;

    public ad(u uVar, b bVar) {
        h.e(uVar, "moduleDescriptor");
        h.e(bVar, "fqName");
        this.eAh = uVar;
        this.eBM = bVar;
    }

    protected final z j(f fVar) {
        h.e(fVar, "name");
        if (fVar.btR()) {
            return null;
        }
        u uVar = this.eAh;
        b C = this.eBM.C(fVar);
        h.d(C, "fqName.child(name)");
        z g = uVar.g(C);
        if (g.isEmpty()) {
            return null;
        }
        return g;
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        if (!dVar.lR(d.eSd.bxb())) {
            return m.emptyList();
        }
        if (this.eBM.isRoot() && dVar.bwO().contains(c.b.eRD)) {
            return m.emptyList();
        }
        Collection<b> a = this.eAh.a(this.eBM, bVar);
        ArrayList arrayList = new ArrayList(a.size());
        for (b btN : a) {
            f btN2 = btN.btN();
            h.d(btN2, "shortName");
            if (((Boolean) bVar.invoke(btN2)).booleanValue()) {
                a.j(arrayList, j(btN2));
            }
        }
        return arrayList;
    }
}
