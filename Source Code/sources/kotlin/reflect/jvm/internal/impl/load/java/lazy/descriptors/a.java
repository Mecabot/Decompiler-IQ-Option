package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.p;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeclaredMemberIndex.kt */
public class a implements b {
    private final Map<f, n> aXa;
    private final b<q, Boolean> eHi = new ClassDeclaredMemberIndex$methodFilter$1(this);
    private final Map<f, List<q>> eHj;
    private final g eHk;
    private final b<p, Boolean> eHl;

    public a(g gVar, b<? super p, Boolean> bVar) {
        h.e(gVar, "jClass");
        h.e(bVar, "memberFilter");
        this.eHk = gVar;
        this.eHl = bVar;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : m.b(u.ac(this.eHk.bht()), this.eHi)) {
            f bdc = ((q) next).bdc();
            ArrayList arrayList = linkedHashMap.get(bdc);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(bdc, arrayList);
            }
            arrayList.add(next);
        }
        this.eHj = linkedHashMap;
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : m.b(u.ac(this.eHk.bhu()), this.eHl)) {
            linkedHashMap.put(((n) next2).bdc(), next2);
        }
        this.aXa = linkedHashMap;
    }

    public Collection<q> r(f fVar) {
        h.e(fVar, "name");
        List list = (List) this.eHj.get(fVar);
        if (list == null) {
            list = m.emptyList();
        }
        return list;
    }

    public Set<f> bgv() {
        Collection linkedHashSet = new LinkedHashSet();
        for (q bdc : m.b(u.ac(this.eHk.bht()), this.eHi)) {
            linkedHashSet.add(bdc.bdc());
        }
        return (Set) linkedHashSet;
    }

    public n s(f fVar) {
        h.e(fVar, "name");
        return (n) this.aXa.get(fVar);
    }

    public Set<f> bgw() {
        Collection linkedHashSet = new LinkedHashSet();
        for (n bdc : m.b(u.ac(this.eHk.bhu()), this.eHl)) {
            linkedHashSet.add(bdc.bdc());
        }
        return (Set) linkedHashSet;
    }
}
