package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;

/* compiled from: KotlinType.kt */
public final class y {
    public static final boolean aF(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        return (bzc instanceof o) || ((bzc instanceof q) && (((q) bzc).bhi() instanceof o));
    }
}
