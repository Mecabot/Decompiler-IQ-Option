package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: modifierChecks.kt */
public interface b {

    /* compiled from: modifierChecks.kt */
    public static final class a {
        public static String a(b bVar, r rVar) {
            h.e(rVar, "functionDescriptor");
            return !bVar.n(rVar) ? bVar.getDescription() : null;
        }
    }

    String a(r rVar);

    String getDescription();

    boolean n(r rVar);
}
