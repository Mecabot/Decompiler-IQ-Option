package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;

/* compiled from: specialBuiltinMembers.kt */
public final class c {
    private static final Map<b, f> eEV;
    private static final Map<f, List<f>> eEW;
    private static final Set<b> eEX = eEV.keySet();
    private static final Set<f> eEY;
    public static final c eEZ = new c();

    static {
        Pair[] pairArr = new Pair[8];
        kotlin.reflect.jvm.internal.impl.name.c cVar = g.exC.exZ;
        h.d(cVar, "BUILTIN_NAMES._enum");
        pairArr[0] = j.D(q.b(cVar, "name"), f.mD("name"));
        cVar = g.exC.exZ;
        h.d(cVar, "BUILTIN_NAMES._enum");
        pairArr[1] = j.D(q.b(cVar, "ordinal"), f.mD("ordinal"));
        b bVar = g.exC.eyw;
        h.d(bVar, "BUILTIN_NAMES.collection");
        pairArr[2] = j.D(q.b(bVar, "size"), f.mD("size"));
        bVar = g.exC.eyA;
        h.d(bVar, "BUILTIN_NAMES.map");
        pairArr[3] = j.D(q.b(bVar, "size"), f.mD("size"));
        cVar = g.exC.exN;
        h.d(cVar, "BUILTIN_NAMES.charSequence");
        pairArr[4] = j.D(q.b(cVar, "length"), f.mD("length"));
        bVar = g.exC.eyA;
        h.d(bVar, "BUILTIN_NAMES.map");
        pairArr[5] = j.D(q.b(bVar, "keys"), f.mD("keySet"));
        bVar = g.exC.eyA;
        h.d(bVar, "BUILTIN_NAMES.map");
        pairArr[6] = j.D(q.b(bVar, "values"), f.mD("values"));
        bVar = g.exC.eyA;
        h.d(bVar, "BUILTIN_NAMES.map");
        pairArr[7] = j.D(q.b(bVar, "entries"), f.mD("entrySet"));
        eEV = ad.a(pairArr);
        Iterable<Entry> entrySet = eEV.entrySet();
        Collection arrayList = new ArrayList(n.e(entrySet, 10));
        for (Entry entry : entrySet) {
            arrayList.add(new Pair(((b) entry.getKey()).btN(), entry.getValue()));
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Pair pair : (List) arrayList) {
            f fVar = (f) pair.aXF();
            ArrayList arrayList2 = linkedHashMap.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(fVar, arrayList2);
            }
            arrayList2.add((f) pair.getFirst());
        }
        eEW = linkedHashMap;
        Iterable<b> iterable = eEX;
        arrayList = new ArrayList(n.e(iterable, 10));
        for (b btN : iterable) {
            arrayList.add(btN.btN());
        }
        eEY = u.Y((List) arrayList);
    }

    private c() {
    }

    public final Set<f> bfB() {
        return eEY;
    }

    public final boolean m(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "callableMemberDescriptor");
        if (eEY.contains(callableMemberDescriptor.bdc())) {
            return n(callableMemberDescriptor);
        }
        return false;
    }

    private final boolean n(CallableMemberDescriptor callableMemberDescriptor) {
        if (u.b((Iterable) eEX, (Object) a.h(callableMemberDescriptor)) && callableMemberDescriptor.bcS().isEmpty()) {
            return true;
        }
        boolean z = false;
        if (!g.b((k) callableMemberDescriptor)) {
            return false;
        }
        Collection bcU = callableMemberDescriptor.bcU();
        h.d(bcU, "overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = bcU;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : iterable) {
                c cVar = eEZ;
                h.d(callableMemberDescriptor2, "it");
                if (cVar.m(callableMemberDescriptor2)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public final List<f> n(f fVar) {
        h.e(fVar, "name1");
        List<f> list = (List) eEW.get(fVar);
        return list != null ? list : m.emptyList();
    }

    public final String o(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        boolean b = g.b((k) callableMemberDescriptor);
        if (!m.etY || b) {
            String str = null;
            callableMemberDescriptor = a.a(a.H(callableMemberDescriptor), false, BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.eFa, 1, null);
            if (callableMemberDescriptor == null) {
                return null;
            }
            f fVar = (f) eEV.get(a.x(callableMemberDescriptor));
            if (fVar != null) {
                str = fVar.asString();
            }
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This method is defined only for builtin members, but ");
        stringBuilder.append(callableMemberDescriptor);
        stringBuilder.append(" found");
        throw new AssertionError(stringBuilder.toString());
    }
}
