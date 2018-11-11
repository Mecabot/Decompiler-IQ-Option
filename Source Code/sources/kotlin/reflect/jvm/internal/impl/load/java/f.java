package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: FakePureImplementationsProvider.kt */
public final class f {
    private static final HashMap<b, b> eFb = new HashMap();
    public static final f eFc;

    static {
        f fVar = new f();
        eFc = fVar;
        b bVar = g.exC.eyF;
        h.d(bVar, "FQ_NAMES.mutableList");
        fVar.a(bVar, fVar.h("java.util.ArrayList", "java.util.LinkedList"));
        bVar = g.exC.eyH;
        h.d(bVar, "FQ_NAMES.mutableSet");
        fVar.a(bVar, fVar.h("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        bVar = g.exC.eyI;
        h.d(bVar, "FQ_NAMES.mutableMap");
        fVar.a(bVar, fVar.h("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fVar.a(new b("java.util.function.Function"), fVar.h("java.util.function.UnaryOperator"));
        fVar.a(new b("java.util.function.BiFunction"), fVar.h("java.util.function.BinaryOperator"));
    }

    private f() {
    }

    public final b n(b bVar) {
        h.e(bVar, "classFqName");
        return (b) eFb.get(bVar);
    }

    private final void a(b bVar, List<b> list) {
        Map map = eFb;
        for (b D : list) {
            Pair D2 = j.D(D, bVar);
            map.put(D2.getFirst(), D2.aXF());
        }
    }

    private final List<b> h(String... strArr) {
        Collection arrayList = new ArrayList(strArr.length);
        for (String bVar : strArr) {
            arrayList.add(new b(bVar));
        }
        return (List) arrayList;
    }
}
