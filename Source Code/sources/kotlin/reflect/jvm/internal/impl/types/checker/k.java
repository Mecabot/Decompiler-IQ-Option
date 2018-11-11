package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.a.a;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.a.c;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.a.d;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: NewKotlinTypeChecker.kt */
public final class k {
    public static final k eVA = new k();

    private k() {
    }

    public final boolean c(TypeCheckerContext typeCheckerContext, ad adVar, ad adVar2) {
        h.e(typeCheckerContext, "context");
        h.e(adVar, "subType");
        h.e(adVar2, "superType");
        return d(typeCheckerContext, adVar, adVar2);
    }

    public final boolean f(ay ayVar) {
        h.e(ayVar, Param.TYPE);
        return a(new TypeCheckerContext(false, false, 2, null), t.aD(ayVar), a.eVJ);
    }

    private final boolean d(TypeCheckerContext typeCheckerContext, ad adVar, ad adVar2) {
        Object obj = (i.h(adVar) || i.g(adVar) || typeCheckerContext.g(adVar)) ? 1 : null;
        StringBuilder stringBuilder;
        if (m.etY && obj == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Not singleClassifierType superType: ");
            stringBuilder.append(adVar2);
            throw new AssertionError(stringBuilder.toString());
        }
        obj = (i.g(adVar2) || typeCheckerContext.g(adVar2)) ? 1 : null;
        if (m.etY && obj == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Not singleClassifierType superType: ");
            stringBuilder.append(adVar2);
            throw new AssertionError(stringBuilder.toString());
        } else if (adVar2.aYp() || ag.aI(adVar) || a(typeCheckerContext, adVar, a.eVJ)) {
            return true;
        } else {
            if (ag.aI(adVar2) || a(typeCheckerContext, adVar2, d.eVL) || i.f(adVar)) {
                return false;
            }
            return d(typeCheckerContext, adVar, adVar2.bwA());
        }
    }

    private final boolean a(TypeCheckerContext typeCheckerContext, ad adVar, TypeCheckerContext.a aVar) {
        ad adVar2 = adVar;
        Object obj = ((!i.f(adVar) || adVar.aYp()) && !ag.aI(adVar2)) ? null : 1;
        if (obj != null) {
            return true;
        }
        typeCheckerContext.initialize();
        ArrayDeque c = typeCheckerContext.eVF;
        if (c == null) {
            h.aXZ();
        }
        Set d = typeCheckerContext.eVG;
        if (d == null) {
            h.aXZ();
        }
        c.push(adVar2);
        while ((c.isEmpty() ^ 1) != 0) {
            if (d.size() > 1000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many supertypes for type: ");
                stringBuilder.append(adVar2);
                stringBuilder.append(". Supertypes = ");
                stringBuilder.append(u.a(d, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            ad adVar3 = (ad) c.pop();
            h.d(adVar3, "current");
            if (d.add(adVar3)) {
                TypeCheckerContext.a aVar2 = adVar3.aYp() ? c.eVK : aVar;
                if ((h.E(aVar2, c.eVK) ^ 1) == 0) {
                    aVar2 = null;
                }
                if (aVar2 != null) {
                    for (w wVar : adVar3.bwA().beu()) {
                        h.d(wVar, "supertype");
                        ad bg = aVar2.bg(wVar);
                        Object obj2 = ((!i.f(bg) || bg.aYp()) && !ag.aI(bg)) ? null : 1;
                        if (obj2 != null) {
                            typeCheckerContext.clear();
                            return true;
                        }
                        c.add(bg);
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        typeCheckerContext.clear();
        return false;
    }

    private final boolean d(TypeCheckerContext typeCheckerContext, ad adVar, an anVar) {
        ad adVar2 = adVar;
        an anVar2 = anVar;
        Object obj = (adVar.aYp() || !h.E(adVar.bwA(), anVar2)) ? null : 1;
        if (obj != null) {
            return true;
        }
        typeCheckerContext.initialize();
        ArrayDeque c = typeCheckerContext.eVF;
        if (c == null) {
            h.aXZ();
        }
        Set d = typeCheckerContext.eVG;
        if (d == null) {
            h.aXZ();
        }
        c.push(adVar2);
        while ((c.isEmpty() ^ 1) != 0) {
            if (d.size() > 1000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many supertypes for type: ");
                stringBuilder.append(adVar2);
                stringBuilder.append(". Supertypes = ");
                stringBuilder.append(u.a(d, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            ad adVar3 = (ad) c.pop();
            h.d(adVar3, "current");
            if (d.add(adVar3)) {
                TypeCheckerContext.a aVar = adVar3.aYp() ? c.eVK : a.eVJ;
                if ((h.E(aVar, c.eVK) ^ 1) == 0) {
                    aVar = null;
                }
                if (aVar != null) {
                    for (w wVar : adVar3.bwA().beu()) {
                        h.d(wVar, "supertype");
                        ad bg = aVar.bg(wVar);
                        Object obj2 = (bg.aYp() || !h.E(bg.bwA(), anVar2)) ? null : 1;
                        if (obj2 != null) {
                            typeCheckerContext.clear();
                            return true;
                        }
                        c.add(bg);
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        typeCheckerContext.clear();
        return false;
    }
}
