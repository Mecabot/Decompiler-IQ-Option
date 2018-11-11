package kotlin.reflect.jvm.internal.impl.types.b;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ah;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.at;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.aw;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.d;
import kotlin.reflect.jvm.internal.impl.types.checker.j;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: TypeUtils.kt */
public final class a {
    public static final g bj(w wVar) {
        h.e(wVar, "$receiver");
        g bdy = wVar.bwA().bdy();
        h.d(bdy, "constructor.builtIns");
        return bdy;
    }

    public static final w aT(w wVar) {
        h.e(wVar, "$receiver");
        return au.aT(wVar);
    }

    public static final w aU(w wVar) {
        h.e(wVar, "$receiver");
        return au.aU(wVar);
    }

    public static final boolean D(w wVar) {
        h.e(wVar, "$receiver");
        return g.D(wVar);
    }

    public static final boolean ba(w wVar) {
        h.e(wVar, "$receiver");
        return au.ba(wVar);
    }

    public static final boolean c(w wVar, w wVar2) {
        h.e(wVar, "$receiver");
        h.e(wVar2, "superType");
        return b.eVr.c(wVar, wVar2);
    }

    public static final w a(w wVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        h.e(wVar, "$receiver");
        h.e(gVar, "newAnnotations");
        if (wVar.bbQ().isEmpty() && gVar.isEmpty()) {
            return wVar;
        }
        return wVar.bzc().f(gVar);
    }

    public static final ap a(w wVar, Variance variance, an anVar) {
        h.e(wVar, Param.TYPE);
        h.e(variance, "projectionKind");
        if ((anVar != null ? anVar.bdd() : null) == variance) {
            variance = Variance.INVARIANT;
        }
        return new ar(variance, wVar);
    }

    public static final ap bk(w wVar) {
        h.e(wVar, "$receiver");
        return new ar(wVar);
    }

    public static final boolean h(ay ayVar) {
        h.e(ayVar, "$receiver");
        return (ayVar.bwA() instanceof j) || (ayVar.bwA().bbW() instanceof an) || (ayVar instanceof d);
    }

    public static final w bl(w wVar) {
        ay a;
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        ad byU;
        if (bzc instanceof q) {
            List parameters;
            Iterable<an> iterable;
            Collection arrayList;
            q qVar = (q) bzc;
            ad byT = qVar.byT();
            if (!(byT.bwA().getParameters().isEmpty() || byT.bwA().bbW() == null)) {
                parameters = byT.bwA().getParameters();
                h.d(parameters, "constructor.parameters");
                iterable = parameters;
                arrayList = new ArrayList(n.e(iterable, 10));
                for (an ahVar : iterable) {
                    arrayList.add(new ah(ahVar));
                }
                byT = at.a(byT, (List) arrayList, null, 2, null);
            }
            byU = qVar.byU();
            if (!(byU.bwA().getParameters().isEmpty() || byU.bwA().bbW() == null)) {
                parameters = byU.bwA().getParameters();
                h.d(parameters, "constructor.parameters");
                iterable = parameters;
                arrayList = new ArrayList(n.e(iterable, 10));
                for (an ahVar2 : iterable) {
                    arrayList.add(new ah(ahVar2));
                }
                byU = at.a(byU, (List) arrayList, null, 2, null);
            }
            a = x.a(byT, byU);
        } else if (bzc instanceof ad) {
            byU = (ad) bzc;
            if (!(byU.bwA().getParameters().isEmpty() || byU.bwA().bbW() == null)) {
                List parameters2 = byU.bwA().getParameters();
                h.d(parameters2, "constructor.parameters");
                Iterable<an> iterable2 = parameters2;
                Collection arrayList2 = new ArrayList(n.e(iterable2, 10));
                for (an ahVar3 : iterable2) {
                    arrayList2.add(new ah(ahVar3));
                }
                byU = at.a(byU, (List) arrayList2, null, 2, null);
            }
            a = byU;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return aw.a(a, bzc);
    }
}
