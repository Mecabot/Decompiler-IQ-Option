package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: flexibleTypes.kt */
public final class t {
    public static final boolean aB(w wVar) {
        h.e(wVar, "$receiver");
        return wVar.bzc() instanceof q;
    }

    public static final q aC(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (bzc != null) {
            return (q) bzc;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
    }

    public static final ad aD(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (bzc instanceof q) {
            return ((q) bzc).byT();
        }
        if (bzc instanceof ad) {
            return (ad) bzc;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ad aE(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (bzc instanceof q) {
            return ((q) bzc).byU();
        }
        if (bzc instanceof ad) {
            return (ad) bzc;
        }
        throw new NoWhenBranchMatchedException();
    }
}
