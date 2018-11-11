package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: RawType.kt */
public final class d extends as {
    private static final a eIp = c.a(TypeUsage.COMMON, false, null, 3, null).a(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    private static final a eIq = c.a(TypeUsage.COMMON, false, null, 3, null).a(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
    public static final d eIr = new d();

    public boolean isEmpty() {
        return false;
    }

    private d() {
    }

    /* renamed from: Y */
    public ar Z(w wVar) {
        h.e(wVar, "key");
        return new ar(aa(wVar));
    }

    private final w aa(w wVar) {
        f bbW = wVar.bwA().bbW();
        if (bbW instanceof an) {
            return aa(c.a((an) bbW, null, null, 3, null));
        }
        if (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            ay fVar;
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
            Pair a = a(t.aD(wVar), dVar, eIp);
            ad adVar = (ad) a.aXG();
            boolean booleanValue = ((Boolean) a.aXH()).booleanValue();
            Pair a2 = a(t.aE(wVar), dVar, eIq);
            ad adVar2 = (ad) a2.aXG();
            boolean booleanValue2 = ((Boolean) a2.aXH()).booleanValue();
            if (booleanValue || booleanValue2) {
                fVar = new f(adVar, adVar2);
            } else {
                fVar = x.a(adVar, adVar2);
            }
            return fVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected declaration kind: ");
        stringBuilder.append(bbW);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    private final Pair<ad, Boolean> a(ad adVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, a aVar) {
        if (adVar.bwA().getParameters().isEmpty()) {
            return j.D(adVar, Boolean.valueOf(false));
        }
        w wVar = adVar;
        if (g.n(wVar)) {
            ap apVar = (ap) adVar.bdF().get(0);
            Variance bzf = apVar.bzf();
            w bai = apVar.bai();
            h.d(bai, "componentTypeProjection.type");
            return j.D(x.c(adVar.bbQ(), adVar.bwA(), l.cr(new ar(bzf, aa(bai))), adVar.aYp()), Boolean.valueOf(false));
        } else if (y.aF(wVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Raw error type: ");
            stringBuilder.append(adVar.bwA());
            return j.D(p.mU(stringBuilder.toString()), Boolean.valueOf(false));
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ = adVar.bbQ();
            kotlin.reflect.jvm.internal.impl.types.an bwA = adVar.bwA();
            List parameters = adVar.bwA().getParameters();
            h.d(parameters, "type.constructor.parameters");
            Iterable<an> iterable = parameters;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (an anVar : iterable) {
                d dVar2 = eIr;
                h.d(anVar, "parameter");
                arrayList.add(a(dVar2, anVar, aVar, null, 4, null));
            }
            List list = (List) arrayList;
            boolean aYp = adVar.aYp();
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h a = dVar.a(eIr);
            h.d(a, "declaration.getMemberScope(RawSubstitution)");
            return j.D(x.a(bbQ, bwA, list, aYp, a), Boolean.valueOf(true));
        }
    }

    public static /* bridge */ /* synthetic */ ap a(d dVar, an anVar, a aVar, w wVar, int i, Object obj) {
        if ((i & 4) != 0) {
            wVar = c.a(anVar, null, null, 3, null);
        }
        return dVar.a(anVar, aVar, wVar);
    }

    public final ap a(an anVar, a aVar, w wVar) {
        h.e(anVar, "parameter");
        h.e(aVar, "attr");
        h.e(wVar, "erasedUpperBound");
        switch (e.aoS[aVar.bhd().ordinal()]) {
            case 1:
                return new ar(Variance.INVARIANT, wVar);
            case 2:
            case 3:
                if (!anVar.bdd().getAllowsOutPosition()) {
                    return new ar(Variance.INVARIANT, a.Q(anVar).baS());
                }
                ap arVar;
                List parameters = wVar.bwA().getParameters();
                h.d(parameters, "erasedUpperBound.constructor.parameters");
                if ((parameters.isEmpty() ^ 1) != 0) {
                    arVar = new ar(Variance.OUT_VARIANCE, wVar);
                } else {
                    arVar = c.a(anVar, aVar);
                }
                return arVar;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
