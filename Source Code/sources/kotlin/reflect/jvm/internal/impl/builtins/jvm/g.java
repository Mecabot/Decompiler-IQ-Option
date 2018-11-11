package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ao;
import kotlin.reflect.jvm.internal.impl.types.ao.a;

/* compiled from: mappingUtil.kt */
public final class g {
    public static final ao a(d dVar, d dVar2) {
        h.e(dVar, "from");
        h.e(dVar2, "to");
        Object obj = dVar.bbS().size() == dVar2.bbS().size() ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(dVar);
            stringBuilder.append(" and ");
            stringBuilder.append(dVar2);
            stringBuilder.append(" should have same number of type parameters, ");
            stringBuilder.append("but ");
            stringBuilder.append(dVar.bbS().size());
            stringBuilder.append(" / ");
            stringBuilder.append(dVar2.bbS().size());
            stringBuilder.append(" found");
            throw new AssertionError(stringBuilder.toString());
        }
        a aVar = ao.eVe;
        List bbS = dVar.bbS();
        h.d(bbS, "from.declaredTypeParameters");
        Iterable<an> iterable = bbS;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (an bby : iterable) {
            arrayList.add(bby.bby());
        }
        Iterable iterable2 = (List) arrayList;
        bbS = dVar2.bbS();
        h.d(bbS, "to.declaredTypeParameters");
        iterable = bbS;
        Collection arrayList2 = new ArrayList(n.e(iterable, 10));
        for (an anVar : iterable) {
            h.d(anVar, "it");
            ad bdb = anVar.bdb();
            h.d(bdb, "it.defaultType");
            arrayList2.add(kotlin.reflect.jvm.internal.impl.types.b.a.bk(bdb));
        }
        return a.a(aVar, ad.ae(u.f(iterable2, (Iterable) (List) arrayList2)), false, 2, null);
    }
}
