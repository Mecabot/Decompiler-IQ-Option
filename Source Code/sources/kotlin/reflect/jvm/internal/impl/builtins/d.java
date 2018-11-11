package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.c;

/* compiled from: CompanionObjectMapping.kt */
public final class d {
    private static final LinkedHashSet<a> exj;
    public static final d exk = new d();

    static {
        Set set = PrimitiveType.NUMBER_TYPES;
        h.d(set, "PrimitiveType.NUMBER_TYPES");
        Iterable<PrimitiveType> iterable = set;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (PrimitiveType d : iterable) {
            arrayList.add(g.d(d));
        }
        Iterable<b> i = u.i((Collection) u.i((Collection) (List) arrayList, (Object) g.exC.exO.btP()), (Object) g.exC.exZ.btP());
        arrayList = new LinkedHashSet();
        for (b t : i) {
            arrayList.add(a.t(t));
        }
        exj = (LinkedHashSet) arrayList;
    }

    private d() {
    }

    public final Set<a> baA() {
        Set<a> unmodifiableSet = Collections.unmodifiableSet(exj);
        h.d(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        return unmodifiableSet;
    }

    public final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "classDescriptor");
        if (c.D(dVar)) {
            Iterable iterable = exj;
            a c = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(dVar);
            if (u.b(iterable, c != null ? c.btI() : null)) {
                return true;
            }
        }
        return false;
    }
}
