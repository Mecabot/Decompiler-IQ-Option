package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: KotlinTypeFactory.kt */
public abstract class j extends i {
    private final ad eIE;

    public j(ad adVar) {
        h.e(adVar, "delegate");
        this.eIE = adVar;
    }

    protected ad bhi() {
        return this.eIE;
    }

    /* renamed from: n */
    public j h(g gVar) {
        h.e(gVar, "newAnnotations");
        return gVar != bbQ() ? new d(this, gVar) : this;
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        if (z == aYp()) {
            return this;
        }
        return bhi().gQ(z).h(bbQ());
    }
}
