package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.checker.j;

/* compiled from: TypeUtils */
public class au {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ad eVm = p.mV("DONT_CARE");
    public static final ad eVn = p.mU("Cannot be inferred");
    public static final ad eVo = new a("NO_EXPECTED_TYPE");
    public static final ad eVp = new a("UNIT_EXPECTED_TYPE");

    /* compiled from: TypeUtils */
    public static class a extends i {
        private final String name;

        public a(String str) {
            this.name = str;
        }

        protected ad bhi() {
            throw new IllegalStateException(this.name);
        }

        /* renamed from: h */
        public ad f(g gVar) {
            throw new IllegalStateException(this.name);
        }

        /* renamed from: gQ */
        public ad gP(boolean z) {
            throw new IllegalStateException(this.name);
        }

        public String toString() {
            return this.name;
        }
    }

    public static boolean aR(w wVar) {
        return wVar == eVo || wVar == eVp;
    }

    public static boolean aS(w wVar) {
        return wVar != null && wVar.bwA() == eVm.bwA();
    }

    public static w aT(w wVar) {
        return b(wVar, true);
    }

    public static w aU(w wVar) {
        return b(wVar, false);
    }

    public static w b(w wVar, boolean z) {
        return wVar.bzc().gP(z);
    }

    public static w c(w wVar, boolean z) {
        return z ? aT(wVar) : wVar;
    }

    public static ad a(f fVar, h hVar) {
        if (p.W(fVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsubstituted type for ");
            stringBuilder.append(fVar);
            return p.mU(stringBuilder.toString());
        }
        an bby = fVar.bby();
        return x.a(g.eBF.bel(), bby, cn(bby.getParameters()), false, hVar);
    }

    public static List<ap> cn(List<an> list) {
        Iterable arrayList = new ArrayList(list.size());
        for (an bdb : list) {
            arrayList.add(new ar(bdb.bdb()));
        }
        return u.W(arrayList);
    }

    public static List<w> aV(w wVar) {
        TypeSubstitutor aQ = TypeSubstitutor.aQ(wVar);
        Collection<w> beu = wVar.bwA().beu();
        List<w> arrayList = new ArrayList(beu.size());
        for (w a : beu) {
            w a2 = a(wVar, a2, aQ);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static w a(w wVar, w wVar2, TypeSubstitutor typeSubstitutor) {
        wVar2 = typeSubstitutor.c(wVar2, Variance.INVARIANT);
        return wVar2 != null ? c(wVar2, wVar.aYp()) : null;
    }

    public static boolean aW(w wVar) {
        if (wVar.aYp()) {
            return true;
        }
        if (t.aB(wVar) && aW(t.aC(wVar).byU())) {
            return true;
        }
        if (ba(wVar)) {
            return aY(wVar);
        }
        an bwA = wVar.bwA();
        if (bwA instanceof v) {
            for (w aW : bwA.beu()) {
                if (aW(aW)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean aX(w wVar) {
        if (wVar.aYp()) {
            return true;
        }
        if (t.aB(wVar) && aX(t.aC(wVar).byU())) {
            return true;
        }
        return false;
    }

    public static boolean aY(w wVar) {
        if (wVar.bwA().bbW() instanceof d) {
            return false;
        }
        for (w aW : aV(wVar)) {
            if (aW(aW)) {
                return true;
            }
        }
        return false;
    }

    public static d aZ(w wVar) {
        f bbW = wVar.bwA().bbW();
        return bbW instanceof d ? (d) bbW : null;
    }

    public static boolean b(w wVar, b<ay, Boolean> bVar) {
        if (wVar == null) {
            return false;
        }
        ay bzc = wVar.bzc();
        if (((Boolean) bVar.invoke(bzc)).booleanValue()) {
            return true;
        }
        q qVar = bzc instanceof q ? (q) bzc : null;
        if (qVar != null && (b(qVar.byT(), (b) bVar) || b(qVar.byU(), (b) bVar))) {
            return true;
        }
        if ((bzc instanceof g) && b(((g) bzc).byN(), (b) bVar)) {
            return true;
        }
        an bwA = wVar.bwA();
        if (bwA instanceof v) {
            for (w b : ((v) bwA).beu()) {
                if (b(b, (b) bVar)) {
                    return true;
                }
            }
            return false;
        }
        for (ap apVar : wVar.bdF()) {
            if (!apVar.bze() && b(apVar.bai(), (b) bVar)) {
                return true;
            }
        }
        return false;
    }

    public static ap e(an anVar) {
        return new ah(anVar);
    }

    public static boolean ba(w wVar) {
        return bb(wVar) != null || (wVar.bwA() instanceof j);
    }

    public static an bb(w wVar) {
        return wVar.bwA().bbW() instanceof an ? (an) wVar.bwA().bbW() : null;
    }
}
