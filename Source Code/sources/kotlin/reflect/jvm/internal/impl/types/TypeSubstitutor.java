package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.k;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.l;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.b;

public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor eVk = e(as.eVi);
    private final as eDd;

    private static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    private enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public static TypeSubstitutor e(as asVar) {
        return new TypeSubstitutor(asVar);
    }

    public static TypeSubstitutor b(as asVar, as asVar2) {
        return e(l.a(asVar, asVar2));
    }

    public static TypeSubstitutor aQ(w wVar) {
        return e(ao.b(wVar.bwA(), wVar.bdF()));
    }

    protected TypeSubstitutor(as asVar) {
        this.eDd = asVar;
    }

    public boolean isEmpty() {
        return this.eDd.isEmpty();
    }

    public as bzi() {
        return this.eDd;
    }

    public w b(w wVar, Variance variance) {
        if (isEmpty()) {
            return wVar;
        }
        try {
            return a(new ar(variance, wVar), 0).bai();
        } catch (SubstitutionException e) {
            return p.mU(e.getMessage());
        }
    }

    public w c(w wVar, Variance variance) {
        ap d = d(new ar(variance, bzi().a(wVar, variance)));
        if (d == null) {
            return null;
        }
        return d.bai();
    }

    public ap d(ap apVar) {
        apVar = e(apVar);
        if (this.eDd.byO() || this.eDd.bwE()) {
            return b.a(apVar, this.eDd.bwE());
        }
        return apVar;
    }

    public ap e(ap apVar) {
        if (isEmpty()) {
            return apVar;
        }
        try {
            return a(apVar, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    private ap a(ap apVar, int i) {
        a(i, apVar, this.eDd);
        if (apVar.bze()) {
            return apVar;
        }
        w bai = apVar.bai();
        ap a;
        if (bai instanceof av) {
            av avVar = (av) bai;
            w byX = avVar.byX();
            bai = avVar.byY();
            a = a(new ar(apVar.bzf(), byX), i + 1);
            return new ar(a.bzf(), aw.b(a.bai().bzc(), c(bai, apVar.bzf())));
        } else if (n.az(bai) || (bai.bzc() instanceof ac)) {
            return apVar;
        } else {
            ap Z = this.eDd.Z(bai);
            Variance bzf = apVar.bzf();
            if (Z == null && t.aB(bai) && !am.aJ(bai)) {
                q aC = t.aC(bai);
                i++;
                Z = a(new ar(bzf, aC.byT()), i);
                a = a(new ar(bzf, aC.byU()), i);
                Variance bzf2 = Z.bzf();
                if (Z.bai() == aC.byT() && a.bai() == aC.byU()) {
                    return apVar;
                }
                return new ar(bzf2, x.a(at.aP(Z.bai()), at.aP(a.bai())));
            } else if (g.B(bai) || y.aF(bai)) {
                return apVar;
            } else {
                if (Z == null) {
                    return b(apVar, i);
                }
                VarianceConflictType b = b(bzf, Z.bzf());
                if (!c.au(bai)) {
                    switch (b) {
                        case OUT_IN_IN_POSITION:
                            throw new SubstitutionException("Out-projection in in-position");
                        case IN_IN_OUT_POSITION:
                            return new ar(Variance.OUT_VARIANCE, bai.bwA().bdy().baV());
                    }
                }
                f aK = am.aK(bai);
                if (Z.bze()) {
                    return Z;
                }
                w ac;
                if (aK != null) {
                    ac = aK.ac(Z.bai());
                } else {
                    ac = au.c(Z.bai(), bai.aYp());
                }
                if (!bai.bbQ().isEmpty()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.annotations.g p = p(this.eDd.m(bai.bbQ()));
                    ac = a.a(ac, new k(ac.bbQ(), p));
                }
                if (b == VarianceConflictType.NO_CONFLICT) {
                    bzf = a(bzf, Z.bzf());
                }
                return new ar(bzf, ac);
            }
        }
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.annotations.g p(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (gVar.k(g.exC.eys)) {
            return new l(gVar, new kotlin.jvm.a.b<kotlin.reflect.jvm.internal.impl.name.b, Boolean>() {
                /* renamed from: v */
                public Boolean invoke(kotlin.reflect.jvm.internal.impl.name.b bVar) {
                    return Boolean.valueOf(bVar.equals(g.exC.eys) ^ 1);
                }
            });
        }
        return gVar;
    }

    private ap b(ap apVar, int i) {
        w bai = apVar.bai();
        Variance bzf = apVar.bzf();
        if (bai.bwA().bbW() instanceof an) {
            return apVar;
        }
        w wVar = null;
        w aH = ag.aH(bai);
        if (aH != null) {
            wVar = c(aH, Variance.INVARIANT);
        }
        w a = at.a(bai, b(bai.bwA().getParameters(), bai.bdF(), i), this.eDd.m(bai.bbQ()));
        if ((a instanceof ad) && (wVar instanceof ad)) {
            a = ag.b((ad) a, (ad) wVar);
        }
        return new ar(bzf, a);
    }

    private List<ap> b(List<an> list, List<ap> list2, int i) {
        List<ap> arrayList = new ArrayList(list.size());
        Object obj = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            an anVar = (an) list.get(i2);
            ap apVar = (ap) list2.get(i2);
            ap a = a(apVar, i + 1);
            switch (b(anVar.bdd(), a.bzf())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    a = au.e(anVar);
                    break;
                case NO_CONFLICT:
                    if (!(anVar.bdd() == Variance.INVARIANT || a.bze())) {
                        a = new ar(Variance.INVARIANT, a.bai());
                        break;
                    }
            }
            if (a != apVar) {
                obj = 1;
            }
            arrayList.add(a);
        }
        return obj == null ? list2 : arrayList;
    }

    public static Variance a(Variance variance, ap apVar) {
        if (apVar.bze()) {
            return Variance.OUT_VARIANCE;
        }
        return a(variance, apVar.bzf());
    }

    public static Variance a(Variance variance, Variance variance2) {
        if (variance == Variance.INVARIANT) {
            return variance2;
        }
        if (variance2 == Variance.INVARIANT) {
            return variance;
        }
        if (variance == variance2) {
            return variance2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variance conflict: type parameter variance '");
        stringBuilder.append(variance);
        stringBuilder.append("' and ");
        stringBuilder.append("projection kind '");
        stringBuilder.append(variance2);
        stringBuilder.append("' cannot be combined");
        throw new AssertionError(stringBuilder.toString());
    }

    private static VarianceConflictType b(Variance variance, Variance variance2) {
        if (variance == Variance.IN_VARIANCE && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == Variance.IN_VARIANCE) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    private static void a(int i, ap apVar, as asVar) {
        if (i > 100) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Recursion too deep. Most likely infinite loop while substituting ");
            stringBuilder.append(dg(apVar));
            stringBuilder.append("; substitution: ");
            stringBuilder.append(dg(asVar));
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static String dg(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (kotlin.reflect.jvm.internal.impl.utils.c.ag(th)) {
                RuntimeException runtimeException = (RuntimeException) th;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[Exception while computing toString(): ");
                stringBuilder.append(th);
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
    }
}
