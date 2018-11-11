package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;

/* compiled from: SpecialTypes.kt */
public final class ag {
    public static final a aG(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof a)) {
            bzc = null;
        }
        return (a) bzc;
    }

    public static final ad aH(w wVar) {
        h.e(wVar, "$receiver");
        a aG = aG(wVar);
        return aG != null ? aG.byI() : null;
    }

    public static final ad b(ad adVar, ad adVar2) {
        h.e(adVar, "$receiver");
        h.e(adVar2, "abbreviatedType");
        if (y.aF(adVar)) {
            return adVar;
        }
        return new a(adVar, adVar2);
    }

    public static final boolean aI(w wVar) {
        h.e(wVar, "$receiver");
        return wVar.bzc() instanceof g;
    }

    public static final ad d(ad adVar) {
        h.e(adVar, "$receiver");
        g b = g.eUx.b(adVar);
        return b != null ? b : adVar.gQ(false);
    }

    public static final ay d(ay ayVar) {
        h.e(ayVar, "$receiver");
        g b = g.eUx.b(ayVar);
        return b != null ? b : ayVar.gP(false);
    }
}
