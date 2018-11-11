package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.jvm.internal.h;

/* compiled from: signatureEnhancement.kt */
public final class l {
    private static final d a(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (z2 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new d(nullabilityQualifier, mutabilityQualifier, true, z);
        }
        return new d(nullabilityQualifier, mutabilityQualifier, false, z);
    }

    private static final <T> T a(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (h.E(t4, t) && h.E(t3, t2)) {
                t4 = null;
            } else if (t3 != null) {
                t4 = t3;
            }
            return t4;
        }
        if (t3 != null) {
            Set<? extends T> Y = u.Y(ak.e(set, t3));
            if (Y != null) {
                set = Y;
            }
        }
        return u.R(set);
    }

    private static final NullabilityQualifier a(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        if (nullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) a(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
