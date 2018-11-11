package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;

/* compiled from: StarProjectionImpl.kt */
public final class al extends aq {
    private final w eVd;

    public boolean bze() {
        return true;
    }

    public al(w wVar) {
        h.e(wVar, "_type");
        this.eVd = wVar;
    }

    public Variance bzf() {
        return Variance.OUT_VARIANCE;
    }

    public w bai() {
        return this.eVd;
    }
}
