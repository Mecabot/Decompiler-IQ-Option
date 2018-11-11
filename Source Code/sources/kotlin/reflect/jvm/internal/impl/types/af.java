package kotlin.reflect.jvm.internal.impl.types;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: TypeWithEnhancement.kt */
public final class af extends i implements av {
    private final ad eIE;
    private final w eUS;

    protected ad bhi() {
        return this.eIE;
    }

    public w byY() {
        return this.eUS;
    }

    public af(ad adVar, w wVar) {
        h.e(adVar, "delegate");
        h.e(wVar, "enhancement");
        this.eIE = adVar;
        this.eUS = wVar;
    }

    public ay byX() {
        return bhi();
    }

    /* renamed from: h */
    public ad f(g gVar) {
        h.e(gVar, "newAnnotations");
        ay b = aw.b(byX().f(gVar), byY());
        if (b != null) {
            return (ad) b;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        ay b = aw.b(byX().gP(z), byY().bzc().gP(z));
        if (b != null) {
            return (ad) b;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
}
