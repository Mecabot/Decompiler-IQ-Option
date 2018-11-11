package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ao;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.at;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.aw;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: CapturedTypeApproximation.kt */
public final class b {

    /* compiled from: CapturedTypeApproximation.kt */
    public static final class a extends ao {
        a() {
        }

        public ap d(an anVar) {
            h.e(anVar, "key");
            if (!(anVar instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b)) {
                anVar = null;
            }
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b bVar = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) anVar;
            if (bVar == null) {
                return null;
            }
            if (bVar.bwD().bze()) {
                return new ar(Variance.OUT_VARIANCE, bVar.bwD().bai());
            }
            return bVar.bwD();
        }
    }

    private static final ap a(d dVar) {
        boolean bzs = dVar.bzs();
        if (!m.etY || bzs) {
            CapturedTypeApproximationKt$toTypeProjection$2 capturedTypeApproximationKt$toTypeProjection$2 = new CapturedTypeApproximationKt$toTypeProjection$2(dVar);
            if (h.E(dVar.bzu(), dVar.bzv())) {
                return new ar(dVar.bzu());
            }
            if (g.B(dVar.bzu()) && dVar.bzt().bdd() != Variance.IN_VARIANCE) {
                return new ar(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.OUT_VARIANCE), dVar.bzv());
            }
            if (g.E(dVar.bzv())) {
                return new ar(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.IN_VARIANCE), dVar.bzu());
            }
            return new ar(capturedTypeApproximationKt$toTypeProjection$2.invoke(Variance.OUT_VARIANCE), dVar.bzv());
        }
        kotlin.reflect.jvm.internal.impl.renderer.b n = kotlin.reflect.jvm.internal.impl.renderer.b.ePh.n(CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1.eVU);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Only consistent enhanced type projection can be converted to type projection, but ");
        stringBuilder.append('[');
        stringBuilder.append(n.s(dVar.bzt()));
        stringBuilder.append(": <");
        stringBuilder.append(n.b(dVar.bzu()));
        stringBuilder.append(", ");
        stringBuilder.append(n.b(dVar.bzv()));
        stringBuilder.append(">]");
        stringBuilder.append(" was found");
        throw new AssertionError(stringBuilder.toString());
    }

    private static final d c(ap apVar, kotlin.reflect.jvm.internal.impl.descriptors.an anVar) {
        w bai;
        w bai2;
        ad baV;
        switch (c.aoS[TypeSubstitutor.a(anVar.bdd(), apVar).ordinal()]) {
            case 1:
                bai = apVar.bai();
                h.d(bai, Param.TYPE);
                bai2 = apVar.bai();
                h.d(bai2, Param.TYPE);
                return new d(anVar, bai, bai2);
            case 2:
                bai2 = apVar.bai();
                h.d(bai2, Param.TYPE);
                baV = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(anVar).baV();
                h.d(baV, "typeParameter.builtIns.nullableAnyType");
                return new d(anVar, bai2, baV);
            case 3:
                baV = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(anVar).baS();
                h.d(baV, "typeParameter.builtIns.nothingType");
                bai = baV;
                bai2 = apVar.bai();
                h.d(bai2, Param.TYPE);
                return new d(anVar, bai, bai2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ap a(ap apVar, boolean z) {
        if (apVar == null) {
            return null;
        }
        if (apVar.bze()) {
            return apVar;
        }
        w bai = apVar.bai();
        if (!au.b(bai, (kotlin.jvm.a.b) CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.eVT)) {
            return apVar;
        }
        Variance bzf = apVar.bzf();
        if (bzf == Variance.OUT_VARIANCE) {
            h.d(bai, Param.TYPE);
            return new ar(bzf, (w) bm(bai).bzr());
        } else if (!z) {
            return f(apVar);
        } else {
            h.d(bai, Param.TYPE);
            return new ar(bzf, (w) bm(bai).bzq());
        }
    }

    private static final ap f(ap apVar) {
        return TypeSubstitutor.e((as) new a()).e(apVar);
    }

    public static final a<w> bm(w wVar) {
        h.e(wVar, Param.TYPE);
        if (t.aB(wVar)) {
            a bm = bm(t.aD(wVar));
            a bm2 = bm(t.aE(wVar));
            return new a(aw.a(x.a(t.aD((w) bm.bzq()), t.aE((w) bm2.bzq())), wVar), aw.a(x.a(t.aD((w) bm.bzr()), t.aE((w) bm2.bzr())), wVar));
        }
        an bwA = wVar.bwA();
        if (c.au(wVar)) {
            if (bwA == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            }
            a<w> aVar;
            ap bwD = ((kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) bwA).bwD();
            CapturedTypeApproximationKt$approximateCapturedTypes$1 capturedTypeApproximationKt$approximateCapturedTypes$1 = new CapturedTypeApproximationKt$approximateCapturedTypes$1(wVar);
            w bai = bwD.bai();
            h.d(bai, "typeProjection.type");
            bai = capturedTypeApproximationKt$approximateCapturedTypes$1.invoke(bai);
            switch (c.auk[bwD.bzf().ordinal()]) {
                case 1:
                    aVar = new a(bai, kotlin.reflect.jvm.internal.impl.types.b.a.bj(wVar).baV());
                    break;
                case 2:
                    ad baS = kotlin.reflect.jvm.internal.impl.types.b.a.bj(wVar).baS();
                    h.d(baS, "type.builtIns.nothingType");
                    aVar = new a(capturedTypeApproximationKt$approximateCapturedTypes$1.invoke(baS), bai);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Only nontrivial projections should have been captured, not: ");
                    stringBuilder.append(bwD);
                    throw new AssertionError(stringBuilder.toString());
            }
            return aVar;
        } else if (wVar.bdF().isEmpty() || wVar.bdF().size() != bwA.getParameters().size()) {
            return new a(wVar, wVar);
        } else {
            d c;
            Object obj;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterable bdF = wVar.bdF();
            List parameters = bwA.getParameters();
            h.d(parameters, "typeConstructor.parameters");
            for (Pair pair : u.f(bdF, (Iterable) parameters)) {
                ap apVar = (ap) pair.aXG();
                kotlin.reflect.jvm.internal.impl.descriptors.an anVar = (kotlin.reflect.jvm.internal.impl.descriptors.an) pair.aXH();
                h.d(anVar, "typeParameter");
                c = c(apVar, anVar);
                if (apVar.bze()) {
                    arrayList.add(c);
                    arrayList2.add(c);
                } else {
                    a b = b(c);
                    d dVar = (d) b.aXG();
                    c = (d) b.aXH();
                    arrayList.add(dVar);
                    arrayList2.add(c);
                }
            }
            Iterable<d> iterable = arrayList;
            Object obj2 = null;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (d c2 : iterable) {
                    if ((c2.bzs() ^ 1) != 0) {
                        obj2 = 1;
                        break;
                    }
                }
            }
            if (obj2 != null) {
                ad baS2 = kotlin.reflect.jvm.internal.impl.types.b.a.bj(wVar).baS();
                h.d(baS2, "type.builtIns.nothingType");
                obj = baS2;
            } else {
                obj = a(wVar, (List) arrayList);
            }
            return new a(obj, a(wVar, (List) arrayList2));
        }
    }

    private static final w a(w wVar, List<d> list) {
        Object obj = wVar.bdF().size() == list.size() ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Incorrect type arguments ");
            stringBuilder.append(list);
            throw new AssertionError(stringBuilder.toString());
        }
        Iterable<d> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (d a : iterable) {
            arrayList.add(a(a));
        }
        return at.a(wVar, (List) arrayList, null, 2, null);
    }

    private static final a<d> b(d dVar) {
        a bm = bm(dVar.bzu());
        w wVar = (w) bm.aXG();
        w wVar2 = (w) bm.aXH();
        a bm2 = bm(dVar.bzv());
        return new a(new d(dVar.bzt(), wVar2, (w) bm2.aXG()), new d(dVar.bzt(), wVar, (w) bm2.aXH()));
    }
}
