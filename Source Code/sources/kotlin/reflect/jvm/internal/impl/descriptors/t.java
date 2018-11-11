package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.h;

/* compiled from: Modality.kt */
public final class t {
    public static final boolean s(d dVar) {
        h.e(dVar, "$receiver");
        return dVar.bbG() == Modality.FINAL && dVar.bbF() != ClassKind.ENUM_CLASS;
    }
}
