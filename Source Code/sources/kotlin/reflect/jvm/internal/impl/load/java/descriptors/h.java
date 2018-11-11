package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ah;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.l;
import kotlin.reflect.jvm.internal.impl.load.kotlin.i;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: util.kt */
public final class h {
    public static final List<aq> a(Collection<i> collection, Collection<? extends aq> collection2, a aVar) {
        Collection<i> collection3 = collection;
        Collection<? extends aq> collection4 = collection2;
        a aVar2 = aVar;
        kotlin.jvm.internal.h.e(collection3, "newValueParametersTypes");
        kotlin.jvm.internal.h.e(collection4, "oldValueParameters");
        kotlin.jvm.internal.h.e(aVar2, "newOwner");
        Object obj = collection.size() == collection2.size() ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Different value parameters sizes: Enhanced = ");
            stringBuilder.append(collection.size());
            stringBuilder.append(", Old = ");
            stringBuilder.append(collection2.size());
            throw new AssertionError(stringBuilder.toString());
        }
        Iterable<Pair> f = u.f((Iterable) collection3, (Iterable) collection4);
        Collection arrayList = new ArrayList(n.e(f, 10));
        for (Pair pair : f) {
            i iVar = (i) pair.aXG();
            aq aqVar = (aq) pair.aXH();
            int index = aqVar.getIndex();
            g bbQ = aqVar.bbQ();
            f bdc = aqVar.bdc();
            kotlin.jvm.internal.h.d(bdc, "oldParameter.name");
            w bai = iVar.bai();
            boolean bfT = iVar.bfT();
            boolean bdU = aqVar.bdU();
            boolean bdV = aqVar.bdV();
            w l = aqVar.bdS() != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.P(aVar2).bdy().l(iVar.bai()) : null;
            ai bbR = aqVar.bbR();
            kotlin.jvm.internal.h.d(bbR, "oldParameter.source");
            arrayList.add(new ah(aVar2, null, index, bbQ, bdc, bai, bfT, bdU, bdV, l, bbR));
        }
        return (List) arrayList;
    }

    public static final l z(d dVar) {
        kotlin.jvm.internal.h.e(dVar, "$receiver");
        dVar = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.L(dVar);
        if (dVar == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx = dVar.bbx();
        if (bbx instanceof l) {
            return (l) bbx;
        }
        return z(dVar);
    }

    public static final b a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        kotlin.jvm.internal.h.e(gVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f bxL = gVar.bxL();
        if (!(bxL instanceof i)) {
            bxL = null;
        }
        i iVar = (i) bxL;
        return iVar != null ? iVar.biv() : null;
    }

    public static final a d(aq aqVar) {
        kotlin.jvm.internal.h.e(aqVar, "$receiver");
        g bbQ = aqVar.bbQ();
        kotlin.reflect.jvm.internal.impl.name.b bVar = kotlin.reflect.jvm.internal.impl.load.java.m.eFx;
        kotlin.jvm.internal.h.d(bVar, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
        c j = bbQ.j(bVar);
        if (j != null) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.f m = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(j);
            if (m != null) {
                if (!(m instanceof s)) {
                    m = null;
                }
                s sVar = (s) m;
                if (sVar != null) {
                    String str = (String) sVar.getValue();
                    if (str != null) {
                        return new g(str);
                    }
                }
            }
        }
        g bbQ2 = aqVar.bbQ();
        kotlin.reflect.jvm.internal.impl.name.b bVar2 = kotlin.reflect.jvm.internal.impl.load.java.m.eFy;
        kotlin.jvm.internal.h.d(bVar2, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
        if (bbQ2.k(bVar2)) {
            return f.eGv;
        }
        return null;
    }
}
