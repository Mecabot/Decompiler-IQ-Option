package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;

/* compiled from: TypeCapabilities.kt */
public final class am {
    public static final boolean aJ(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof f)) {
            bzc = null;
        }
        f fVar = (f) bzc;
        return fVar != null ? fVar.bhW() : false;
    }

    public static final f aK(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof f)) {
            bzc = null;
        }
        f fVar = (f) bzc;
        if (fVar == null || !fVar.bhW()) {
            return null;
        }
        return fVar;
    }

    public static final w aL(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof ak)) {
            bzc = null;
        }
        ak akVar = (ak) bzc;
        if (akVar == null) {
            return wVar;
        }
        w bwx = akVar.bwx();
        return bwx != null ? bwx : wVar;
    }

    public static final w aM(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof ak)) {
            bzc = null;
        }
        ak akVar = (ak) bzc;
        if (akVar == null) {
            return wVar;
        }
        w bwy = akVar.bwy();
        return bwy != null ? bwy : wVar;
    }

    public static final boolean b(w wVar, w wVar2) {
        h.e(wVar, "first");
        h.e(wVar2, "second");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof ak)) {
            bzc = null;
        }
        ak akVar = (ak) bzc;
        if (!(akVar != null ? akVar.at(wVar2) : false)) {
            ay bzc2 = wVar2.bzc();
            if (!(bzc2 instanceof ak)) {
                bzc2 = null;
            }
            ak akVar2 = (ak) bzc2;
            if (!(akVar2 != null ? akVar2.at(wVar) : false)) {
                return false;
            }
        }
        return true;
    }
}
