package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.h;

/* compiled from: Annotations.kt */
public final class i {
    public static final g a(g gVar, g gVar2) {
        h.e(gVar, "first");
        h.e(gVar2, "second");
        if (gVar.isEmpty()) {
            return gVar2;
        }
        if (gVar2.isEmpty()) {
            return gVar;
        }
        return new k(gVar, gVar2);
    }
}
