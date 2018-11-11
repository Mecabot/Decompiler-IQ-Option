package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: TypeSubstitution.kt */
public class h extends as {
    private final as eDd;

    public h(as asVar) {
        kotlin.jvm.internal.h.e(asVar, "substitution");
        this.eDd = asVar;
    }

    public ap Z(w wVar) {
        kotlin.jvm.internal.h.e(wVar, "key");
        return this.eDd.Z(wVar);
    }

    public w a(w wVar, Variance variance) {
        kotlin.jvm.internal.h.e(wVar, "topLevelType");
        kotlin.jvm.internal.h.e(variance, "position");
        return this.eDd.a(wVar, variance);
    }

    public boolean isEmpty() {
        return this.eDd.isEmpty();
    }

    public boolean byO() {
        return this.eDd.byO();
    }

    public boolean bwE() {
        return this.eDd.bwE();
    }

    public g m(g gVar) {
        kotlin.jvm.internal.h.e(gVar, "annotations");
        return this.eDd.m(gVar);
    }
}
