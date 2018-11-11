package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: KotlinTypeFactory.kt */
final class d extends j {
    private final g eBt;

    public g bbQ() {
        return this.eBt;
    }

    public d(ad adVar, g gVar) {
        h.e(adVar, "delegate");
        h.e(gVar, "annotations");
        super(adVar);
        this.eBt = gVar;
    }
}
