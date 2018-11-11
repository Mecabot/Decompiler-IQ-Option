package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: typeParameterUtils.kt */
public final class ao {
    public static final List<an> a(g gVar) {
        h.e(gVar, "$receiver");
        List<an> bbS = gVar.bbS();
        if (gVar.bbL() || (gVar.bbv() instanceof a)) {
            Object obj;
            List list;
            k kVar = gVar;
            List f = m.f(m.e(m.d(a.S(kVar), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.eBa), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.eBb));
            Iterator it = a.S(kVar).iterator();
            do {
                list = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
            } while (!(obj instanceof d));
            d dVar = (d) obj;
            if (dVar != null) {
                an bby = dVar.bby();
                if (bby != null) {
                    list = bby.getParameters();
                }
            }
            if (list == null) {
                list = m.emptyList();
            }
            if (f.isEmpty() && list.isEmpty()) {
                List<an> bbS2 = gVar.bbS();
                h.d(bbS2, "declaredTypeParameters");
                return bbS2;
            }
            Iterable<an> b = u.b((Collection) f, (Iterable) list);
            Collection arrayList = new ArrayList(n.e(b, 10));
            for (an anVar : b) {
                h.d(anVar, "it");
                arrayList.add(a(anVar, kVar, bbS.size()));
            }
            f = (List) arrayList;
            h.d(bbS, "declaredParameters");
            return u.b((Collection) bbS, (Iterable) f);
        }
        h.d(bbS, "declaredParameters");
        return bbS;
    }

    private static final b a(an anVar, k kVar, int i) {
        return new b(anVar, kVar, i);
    }

    public static final ab O(w wVar) {
        h.e(wVar, "$receiver");
        f bbW = wVar.bwA().bbW();
        if (!(bbW instanceof g)) {
            bbW = null;
        }
        return a(wVar, (g) bbW, 0);
    }

    private static final ab a(w wVar, g gVar, int i) {
        ab abVar = null;
        if (gVar != null) {
            k kVar = gVar;
            if (!p.W(kVar)) {
                int size = gVar.bbS().size() + i;
                if (gVar.bbL()) {
                    List subList = wVar.bdF().subList(i, size);
                    k bbv = gVar.bbv();
                    if (bbv instanceof g) {
                        abVar = bbv;
                    }
                    return new ab(gVar, subList, a(wVar, (g) abVar, size));
                }
                Object obj = (size == wVar.bdF().size() || c.u(kVar)) ? 1 : null;
                if (!m.etY || obj != null) {
                    return new ab(gVar, wVar.bdF().subList(i, wVar.bdF().size()), null);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(wVar.bdF().size() - size);
                stringBuilder.append(" trailing arguments were found in ");
                stringBuilder.append(wVar);
                stringBuilder.append(" type");
                throw new AssertionError(stringBuilder.toString());
            }
        }
        return null;
    }
}
