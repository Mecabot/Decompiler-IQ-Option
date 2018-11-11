package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.renderer.f;
import kotlin.reflect.jvm.internal.impl.types.checker.b;

/* compiled from: flexibleTypes.kt */
public final class r extends q implements f {
    public static boolean eUP;
    public static final a eUQ = new a();
    private boolean eUO;

    /* compiled from: flexibleTypes.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public r(ad adVar, ad adVar2) {
        h.e(adVar, "lowerBound");
        h.e(adVar2, "upperBound");
        super(adVar, adVar2);
    }

    private final void byV() {
        if (eUP && !this.eUO) {
            this.eUO = true;
            int aB = t.aB(byT()) ^ 1;
            StringBuilder stringBuilder;
            if (m.etY && aB == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Lower bound of a flexible type can not be flexible: ");
                stringBuilder.append(byT());
                throw new AssertionError(stringBuilder.toString());
            }
            aB = t.aB(byU()) ^ 1;
            if (m.etY && aB == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Upper bound of a flexible type can not be flexible: ");
                stringBuilder.append(byU());
                throw new AssertionError(stringBuilder.toString());
            }
            int E = 1 ^ h.E(byT(), byU());
            if (m.etY && E == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Lower and upper bounds are equal: ");
                stringBuilder.append(byT());
                stringBuilder.append(" == ");
                stringBuilder.append(byU());
                throw new AssertionError(stringBuilder.toString());
            }
            boolean c = b.eVr.c(byT(), byU());
            if (m.etY && !c) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Lower bound ");
                stringBuilder.append(byT());
                stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
                stringBuilder.append(byU());
                throw new AssertionError(stringBuilder.toString());
            }
        }
    }

    public ad bhi() {
        byV();
        return byT();
    }

    public boolean bhW() {
        return (byT().bwA().bbW() instanceof an) && h.E(byT().bwA(), byU().bwA());
    }

    public w ac(w wVar) {
        ay ayVar;
        h.e(wVar, "replacement");
        ay bzc = wVar.bzc();
        if (bzc instanceof q) {
            ayVar = bzc;
        } else if (bzc instanceof ad) {
            ad adVar = (ad) bzc;
            ayVar = x.a(adVar, adVar.gQ(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return aw.a(ayVar, bzc);
    }

    public ay f(g gVar) {
        h.e(gVar, "newAnnotations");
        return x.a(byT().h(gVar), byU().h(gVar));
    }

    public String a(kotlin.reflect.jvm.internal.impl.renderer.b bVar, f fVar) {
        h.e(bVar, "renderer");
        h.e(fVar, "options");
        if (!fVar.HW()) {
            return bVar.a(bVar.b(byT()), bVar.b(byU()), kotlin.reflect.jvm.internal.impl.types.b.a.bj(this));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        stringBuilder.append(bVar.b(byT()));
        stringBuilder.append("..");
        stringBuilder.append(bVar.b(byU()));
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public ay gP(boolean z) {
        return x.a(byT().gQ(z), byU().gQ(z));
    }
}
