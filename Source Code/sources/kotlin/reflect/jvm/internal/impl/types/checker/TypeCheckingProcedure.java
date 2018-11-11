package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.am;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

public class TypeCheckingProcedure {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final o eVM;

    public enum EnrichedProjectionKind {
        IN,
        OUT,
        INV,
        STAR;

        public static EnrichedProjectionKind fromVariance(Variance variance) {
            switch (variance) {
                case INVARIANT:
                    return INV;
                case IN_VARIANCE:
                    return IN;
                case OUT_VARIANCE:
                    return OUT;
                default:
                    throw new IllegalStateException("Unknown variance");
            }
        }
    }

    public static w f(w wVar, w wVar2) {
        return a(wVar, wVar2, new n());
    }

    public static w a(w wVar, w wVar2, o oVar) {
        return p.a(wVar, wVar2, oVar);
    }

    private static w a(an anVar, ap apVar) {
        Object obj = (apVar.bzf() == Variance.IN_VARIANCE || anVar.bdd() == Variance.IN_VARIANCE) ? 1 : null;
        return obj != null ? a.Q(anVar).baV() : apVar.bai();
    }

    private static w b(an anVar, ap apVar) {
        Object obj = (apVar.bzf() == Variance.OUT_VARIANCE || anVar.bdd() == Variance.OUT_VARIANCE) ? 1 : null;
        return obj != null ? a.Q(anVar).baS() : apVar.bai();
    }

    public TypeCheckingProcedure(o oVar) {
        this.eVM = oVar;
    }

    public boolean d(w wVar, w wVar2) {
        boolean z = true;
        if (wVar == wVar2) {
            return true;
        }
        if (t.aB(wVar)) {
            if (!t.aB(wVar2)) {
                return g(wVar2, wVar);
            }
            if (y.aF(wVar) || y.aF(wVar2) || !c(wVar, wVar2) || !c(wVar2, wVar)) {
                z = false;
            }
            return z;
        } else if (t.aB(wVar2)) {
            return g(wVar, wVar2);
        } else {
            if (wVar.aYp() != wVar2.aYp()) {
                return false;
            }
            if (wVar.aYp()) {
                return this.eVM.a(au.aU(wVar), au.aU(wVar2), this);
            }
            kotlin.reflect.jvm.internal.impl.types.an bwA = wVar.bwA();
            kotlin.reflect.jvm.internal.impl.types.an bwA2 = wVar2.bwA();
            if (!this.eVM.c(bwA, bwA2)) {
                return false;
            }
            List bdF = wVar.bdF();
            List bdF2 = wVar2.bdF();
            if (bdF.size() != bdF2.size()) {
                return false;
            }
            for (int i = 0; i < bdF.size(); i++) {
                ap apVar = (ap) bdF.get(i);
                ap apVar2 = (ap) bdF2.get(i);
                if (!apVar.bze() || !apVar2.bze()) {
                    an anVar = (an) bwA.getParameters().get(i);
                    an anVar2 = (an) bwA2.getParameters().get(i);
                    if (!(a(apVar, apVar2, anVar) || (c(anVar, apVar) == c(anVar2, apVar2) && this.eVM.a(apVar.bai(), apVar2.bai(), this)))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    protected boolean g(w wVar, w wVar2) {
        return c(t.aC(wVar2).byT(), wVar) && c(wVar, t.aC(wVar2).byU());
    }

    public static EnrichedProjectionKind c(an anVar, ap apVar) {
        Variance bdd = anVar.bdd();
        Variance bzf = apVar.bzf();
        if (bzf == Variance.INVARIANT) {
            Variance variance = bzf;
            bzf = bdd;
            bdd = variance;
        }
        if (bdd == Variance.IN_VARIANCE && bzf == Variance.OUT_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        if (bdd == Variance.OUT_VARIANCE && bzf == Variance.IN_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        return EnrichedProjectionKind.fromVariance(bzf);
    }

    public boolean c(w wVar, w wVar2) {
        if (am.b(wVar, wVar2)) {
            boolean z = !wVar.aYp() || wVar2.aYp();
            return z;
        }
        w aL = am.aL(wVar);
        w aM = am.aM(wVar2);
        if (aL == wVar && aM == wVar2) {
            return h(wVar, wVar2);
        }
        return c(aL, aM);
    }

    private boolean h(w wVar, w wVar2) {
        if (y.aF(wVar) || y.aF(wVar2)) {
            return true;
        }
        if (!wVar2.aYp() && wVar.aYp()) {
            return false;
        }
        if (g.C(wVar)) {
            return true;
        }
        w a = a(wVar, wVar2, this.eVM);
        if (a == null) {
            return this.eVM.e(wVar, wVar2);
        }
        if (wVar2.aYp() || !a.aYp()) {
            return i(a, wVar2);
        }
        return false;
    }

    private boolean i(w wVar, w wVar2) {
        kotlin.reflect.jvm.internal.impl.types.an bwA = wVar.bwA();
        List bdF = wVar.bdF();
        List bdF2 = wVar2.bdF();
        if (bdF.size() != bdF2.size()) {
            return false;
        }
        List parameters = bwA.getParameters();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= parameters.size()) {
                return true;
            }
            an anVar = (an) parameters.get(i);
            ap apVar = (ap) bdF2.get(i);
            ap apVar2 = (ap) bdF.get(i);
            if (!(apVar.bze() || a(apVar2, apVar, anVar))) {
                if (!(y.aF(apVar2.bai()) || y.aF(apVar.bai()))) {
                    z = false;
                }
                if (z || anVar.bdd() != Variance.INVARIANT || apVar2.bzf() != Variance.INVARIANT || apVar.bzf() != Variance.INVARIANT) {
                    w a = a(anVar, apVar);
                    if (!this.eVM.b(a(anVar, apVar2), a, this)) {
                        return false;
                    }
                    a = b(anVar, apVar);
                    w b = b(anVar, apVar2);
                    if (!(apVar.bzf() == Variance.OUT_VARIANCE || this.eVM.b(a, b, this))) {
                        return false;
                    }
                } else if (!this.eVM.a(apVar2.bai(), apVar.bai(), this)) {
                    return false;
                }
            }
            i++;
        }
    }

    private boolean a(ap apVar, ap apVar2, an anVar) {
        if (anVar.bdd() == Variance.INVARIANT && apVar.bzf() != Variance.INVARIANT && apVar2.bzf() == Variance.INVARIANT) {
            return this.eVM.a(apVar2.bai(), apVar);
        }
        return false;
    }
}
