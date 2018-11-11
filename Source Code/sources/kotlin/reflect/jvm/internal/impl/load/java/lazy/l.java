package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.a;

/* compiled from: ModuleClassResolver.kt */
public final class l implements j {
    public a eHg;

    public d b(g gVar) {
        h.e(gVar, "javaClass");
        a aVar = this.eHg;
        if (aVar == null) {
            h.lS("resolver");
        }
        return aVar.b(gVar);
    }

    public final void a(a aVar) {
        h.e(aVar, "<set-?>");
        this.eHg = aVar;
    }
}
