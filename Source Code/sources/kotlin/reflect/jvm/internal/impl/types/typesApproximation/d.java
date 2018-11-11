package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: CapturedTypeApproximation.kt */
final class d {
    private final w eVV;
    private final w eVW;
    private final an eVa;

    public d(an anVar, w wVar, w wVar2) {
        h.e(anVar, "typeParameter");
        h.e(wVar, "inProjection");
        h.e(wVar2, "outProjection");
        this.eVa = anVar;
        this.eVV = wVar;
        this.eVW = wVar2;
    }

    public final an bzt() {
        return this.eVa;
    }

    public final w bzu() {
        return this.eVV;
    }

    public final w bzv() {
        return this.eVW;
    }

    public final boolean bzs() {
        return b.eVr.c(this.eVV, this.eVW);
    }
}
