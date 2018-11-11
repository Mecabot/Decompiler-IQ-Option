package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: specialBuiltinMembers.kt */
public final class b {
    private static final o eEF;
    private static final Map<o, f> eEG;
    private static final Map<String, f> eEH;
    private static final List<f> eEI;
    private static final Map<f, List<f>> eEJ;
    public static final b eEK = new b();

    static {
        String desc = JvmPrimitiveType.INT.getDesc();
        h.d(desc, "JvmPrimitiveType.INT.desc");
        eEF = q.d("java/util/List", "removeAt", desc, "Ljava/lang/Object;");
        u uVar = u.eJX;
        Pair[] pairArr = new Pair[8];
        String desc2 = JvmPrimitiveType.BYTE.getDesc();
        h.d(desc2, "JvmPrimitiveType.BYTE.desc");
        pairArr[0] = j.D(q.d(uVar.mu("Number"), "toByte", "", desc2), f.mD("byteValue"));
        desc2 = JvmPrimitiveType.SHORT.getDesc();
        h.d(desc2, "JvmPrimitiveType.SHORT.desc");
        pairArr[1] = j.D(q.d(uVar.mu("Number"), "toShort", "", desc2), f.mD("shortValue"));
        desc2 = JvmPrimitiveType.INT.getDesc();
        h.d(desc2, "JvmPrimitiveType.INT.desc");
        pairArr[2] = j.D(q.d(uVar.mu("Number"), "toInt", "", desc2), f.mD("intValue"));
        desc2 = JvmPrimitiveType.LONG.getDesc();
        h.d(desc2, "JvmPrimitiveType.LONG.desc");
        pairArr[3] = j.D(q.d(uVar.mu("Number"), "toLong", "", desc2), f.mD("longValue"));
        desc2 = JvmPrimitiveType.FLOAT.getDesc();
        h.d(desc2, "JvmPrimitiveType.FLOAT.desc");
        pairArr[4] = j.D(q.d(uVar.mu("Number"), "toFloat", "", desc2), f.mD("floatValue"));
        desc2 = JvmPrimitiveType.DOUBLE.getDesc();
        h.d(desc2, "JvmPrimitiveType.DOUBLE.desc");
        pairArr[5] = j.D(q.d(uVar.mu("Number"), "toDouble", "", desc2), f.mD("doubleValue"));
        pairArr[6] = j.D(eEF, f.mD(ProductAction.ACTION_REMOVE));
        String desc3 = JvmPrimitiveType.INT.getDesc();
        h.d(desc3, "JvmPrimitiveType.INT.desc");
        String desc4 = JvmPrimitiveType.CHAR.getDesc();
        h.d(desc4, "JvmPrimitiveType.CHAR.desc");
        pairArr[7] = j.D(q.d(uVar.mu("CharSequence"), "get", desc3, desc4), f.mD("charAt"));
        eEG = ad.a(pairArr);
        Map map = eEG;
        Map linkedHashMap = new LinkedHashMap(ad.jn(map.size()));
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(((o) entry.getKey()).getSignature(), entry.getValue());
        }
        eEH = linkedHashMap;
        Iterable<o> keySet = eEG.keySet();
        Collection arrayList = new ArrayList(n.e(keySet, 10));
        for (o bdc : keySet) {
            arrayList.add(bdc.bdc());
        }
        eEI = (List) arrayList;
        Iterable<Entry> entrySet = eEG.entrySet();
        arrayList = new ArrayList(n.e(entrySet, 10));
        for (Entry entry2 : entrySet) {
            arrayList.add(new Pair(((o) entry2.getKey()).bdc(), entry2.getValue()));
        }
        map = new LinkedHashMap();
        for (Pair pair : (List) arrayList) {
            f fVar = (f) pair.aXF();
            ArrayList arrayList2 = map.get(fVar);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(fVar, arrayList2);
            }
            arrayList2.add((f) pair.getFirst());
        }
        eEJ = map;
    }

    private b() {
    }

    public final List<f> bfA() {
        return eEI;
    }

    public final boolean k(f fVar) {
        h.e(fVar, "$receiver");
        return eEI.contains(fVar);
    }

    public final f a(ah ahVar) {
        h.e(ahVar, "functionDescriptor");
        Map map = eEH;
        String c = r.c(ahVar);
        return c != null ? (f) map.get(c) : null;
    }

    public final boolean b(ah ahVar) {
        h.e(ahVar, "functionDescriptor");
        return g.b((k) ahVar) && a.a(ahVar, false, new BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(ahVar), 1, null) != null;
    }

    public final List<f> l(f fVar) {
        h.e(fVar, "name");
        List<f> list = (List) eEJ.get(fVar);
        return list != null ? list : m.emptyList();
    }

    public final boolean c(ah ahVar) {
        h.e(ahVar, "$receiver");
        return h.E(ahVar.bdc().asString(), "removeAt") && h.E(r.c(ahVar), eEF.getSignature());
    }
}
