package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: modifierChecks.kt */
public abstract class a {
    public abstract List<d> bzw();

    public final c m(r rVar) {
        h.e(rVar, "functionDescriptor");
        for (d dVar : bzw()) {
            if (dVar.o(rVar)) {
                return dVar.p(rVar);
            }
        }
        return kotlin.reflect.jvm.internal.impl.util.c.a.eVX;
    }
}
