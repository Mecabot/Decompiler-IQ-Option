package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.k;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.f;
import kotlin.reflect.jvm.internal.impl.load.java.m;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.aw;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: typeEnhancement.kt */
public final class p {
    private static final b eJg;
    private static final b eJh;

    public static final w a(w wVar, b<? super Integer, d> bVar) {
        h.e(wVar, "$receiver");
        h.e(bVar, "qualifiers");
        return a(wVar.bzc(), (b) bVar, 0).bif();
    }

    public static final boolean af(w wVar) {
        h.e(wVar, "$receiver");
        g bbQ = wVar.bbQ();
        kotlin.reflect.jvm.internal.impl.name.b bVar = m.eFu;
        h.d(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return bbQ.j(bVar) != null;
    }

    private static final i a(ay ayVar, b<? super Integer, d> bVar, int i) {
        w wVar = ayVar;
        boolean z = false;
        if (y.aF(wVar)) {
            return new i(wVar, 1, false);
        }
        i iVar;
        if (ayVar instanceof q) {
            q qVar = (q) ayVar;
            m a = a(qVar.byT(), bVar, i, TypeComponentPosition.FLEXIBLE_LOWER);
            m a2 = a(qVar.byU(), bVar, i, TypeComponentPosition.FLEXIBLE_UPPER);
            Object obj = a.big() == a2.big() ? 1 : null;
            if (kotlin.m.etY && obj == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Different tree sizes of bounds: ");
                stringBuilder.append("lower = (");
                stringBuilder.append(qVar.byT());
                stringBuilder.append(", ");
                stringBuilder.append(a.big());
                stringBuilder.append("), ");
                stringBuilder.append("upper = (");
                stringBuilder.append(qVar.byU());
                stringBuilder.append(", ");
                stringBuilder.append(a2.big());
                stringBuilder.append(')');
                throw new AssertionError(stringBuilder.toString());
            }
            if (a.bih() || a2.bih()) {
                z = true;
            }
            w bc = aw.bc(a.bai());
            if (bc == null) {
                bc = aw.bc(a2.bai());
            }
            if (z) {
                if (ayVar instanceof f) {
                    ayVar = new f(a.bai(), a2.bai());
                } else {
                    ayVar = x.a(a.bai(), a2.bai());
                }
                ayVar = aw.b(ayVar, bc);
            }
            iVar = new i(ayVar, a.big(), z);
        } else if (ayVar instanceof ad) {
            iVar = a((ad) ayVar, bVar, i, TypeComponentPosition.INFLEXIBLE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return iVar;
    }

    private static final m a(ad adVar, b<? super Integer, d> bVar, int i, TypeComponentPosition typeComponentPosition) {
        ad adVar2 = adVar;
        b bVar2 = bVar;
        TypeComponentPosition typeComponentPosition2 = typeComponentPosition;
        if (!a(typeComponentPosition) && adVar.bdF().isEmpty()) {
            return new m(adVar2, 1, false);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = adVar.bwA().bbW();
        if (bbW == null) {
            return new m(adVar2, 1, false);
        }
        d dVar = (d) bVar2.invoke(Integer.valueOf(i));
        h.d(bbW, "originalClass");
        c a = a(bbW, dVar, typeComponentPosition2);
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = (kotlin.reflect.jvm.internal.impl.descriptors.f) a.aXG();
        g bhP = a.bhP();
        an bby = fVar.bby();
        int i2 = i + 1;
        Object obj = bhP != null ? 1 : null;
        Iterable<ap> bdF = adVar.bdF();
        Collection arrayList = new ArrayList(n.e(bdF, 10));
        int i3 = i2;
        i2 = 0;
        for (ap apVar : bdF) {
            Object e;
            int i4 = i2 + 1;
            if (apVar.bze()) {
                i3++;
                an bby2 = fVar.bby();
                h.d(bby2, "enhancedClassifier.typeConstructor");
                e = au.e((kotlin.reflect.jvm.internal.impl.descriptors.an) bby2.getParameters().get(i2));
            } else {
                i a2 = a(apVar.bai().bzc(), bVar2, i3);
                obj = (obj != null || a2.bih()) ? 1 : null;
                i3 += a2.big();
                w bai = a2.bai();
                Variance bzf = apVar.bzf();
                h.d(bzf, "arg.projectionKind");
                h.d(bby, "typeConstructor");
                e = a.a(bai, bzf, (kotlin.reflect.jvm.internal.impl.descriptors.an) bby.getParameters().get(i2));
            }
            arrayList.add(e);
            i2 = i4;
        }
        List list = (List) arrayList;
        c a3 = a((w) adVar2, dVar, typeComponentPosition2);
        boolean booleanValue = ((Boolean) a3.aXG()).booleanValue();
        g bhP2 = a3.bhP();
        Object obj2 = (obj == null && bhP2 == null) ? null : 1;
        i3 -= i;
        if (obj2 == null) {
            return new m(adVar2, i3, false);
        }
        g ch = ch(u.S(m.listOf(adVar.bbQ(), bhP, bhP2)));
        h.d(bby, "typeConstructor");
        ad c = x.c(ch, bby, list, booleanValue);
        if (dVar.bhS()) {
            c = new e(c);
        }
        Object obj3 = (bhP2 == null || !dVar.bhT()) ? null : 1;
        ay b = obj3 != null ? aw.b(adVar2, c) : c;
        if (b != null) {
            return new m((ad) b, i3, true);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    private static final g ch(List<? extends g> list) {
        switch (list.size()) {
            case 0:
                throw new IllegalStateException("At least one Annotations object expected".toString());
            case 1:
                return (g) u.bY(list);
            default:
                return new k(u.W(list));
        }
    }

    private static final boolean a(TypeComponentPosition typeComponentPosition) {
        return typeComponentPosition != TypeComponentPosition.INFLEXIBLE;
    }

    private static final <T> c<T> cM(T t) {
        return new c(t, null);
    }

    private static final <T> c<T> cN(T t) {
        return new c(t, eJg);
    }

    private static final <T> c<T> cO(T t) {
        return new c(t, eJh);
    }

    private static final c<kotlin.reflect.jvm.internal.impl.descriptors.f> a(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, d dVar, TypeComponentPosition typeComponentPosition) {
        if (!a(typeComponentPosition)) {
            return cM(fVar);
        }
        if (!(fVar instanceof d)) {
            return cM(fVar);
        }
        c cVar = c.eAc;
        MutabilityQualifier bhR = dVar.bhR();
        if (bhR != null) {
            d dVar2;
            switch (q.aoS[bhR.ordinal()]) {
                case 1:
                    if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                        dVar2 = (d) fVar;
                        if (cVar.h(dVar2)) {
                            return cO(cVar.j(dVar2));
                        }
                    }
                    break;
                case 2:
                    if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                        dVar2 = (d) fVar;
                        if (cVar.i(dVar2)) {
                            return cO(cVar.k(dVar2));
                        }
                    }
                    break;
            }
        }
        return cM(fVar);
    }

    private static final c<Boolean> a(w wVar, d dVar, TypeComponentPosition typeComponentPosition) {
        if (!a(typeComponentPosition)) {
            return cM(Boolean.valueOf(wVar.aYp()));
        }
        c<Boolean> cN;
        NullabilityQualifier bhQ = dVar.bhQ();
        if (bhQ != null) {
            switch (q.auk[bhQ.ordinal()]) {
                case 1:
                    cN = cN(Boolean.valueOf(true));
                    break;
                case 2:
                    cN = cN(Boolean.valueOf(false));
                    break;
            }
        }
        cN = cM(Boolean.valueOf(wVar.aYp()));
        return cN;
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.b bVar = m.eFu;
        h.d(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        eJg = new b(bVar);
        bVar = m.eFv;
        h.d(bVar, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        eJh = new b(bVar);
    }
}
