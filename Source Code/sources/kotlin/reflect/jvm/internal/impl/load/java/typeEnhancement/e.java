package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.aw;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.f;
import kotlin.reflect.jvm.internal.impl.types.i;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: typeEnhancement.kt */
public final class e extends i implements f {
    private final ad eIE;

    public boolean aYp() {
        return false;
    }

    public boolean bhW() {
        return true;
    }

    public e(ad adVar) {
        h.e(adVar, "delegate");
        this.eIE = adVar;
    }

    protected ad bhi() {
        return this.eIE;
    }

    public w ac(w wVar) {
        h.e(wVar, "replacement");
        ay bzc = wVar.bzc();
        w wVar2 = bzc;
        if (!au.aW(wVar2) && !a.ba(wVar2)) {
            return wVar2;
        }
        if (bzc instanceof ad) {
            wVar = a((ad) bzc);
        } else if (bzc instanceof q) {
            q qVar = (q) bzc;
            wVar = aw.b(x.a(a(qVar.byT()), a(qVar.byU())), aw.bc(wVar2));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Incorrect type: ");
            stringBuilder.append(bzc);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        return wVar;
    }

    private final ad a(ad adVar) {
        ad gQ = adVar.gQ(false);
        if (a.ba(adVar)) {
            return new e(gQ);
        }
        return gQ;
    }

    /* renamed from: g */
    public e h(g gVar) {
        h.e(gVar, "newAnnotations");
        return new e(bhi().h(gVar));
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        return z ? bhi().gQ(true) : this;
    }
}
