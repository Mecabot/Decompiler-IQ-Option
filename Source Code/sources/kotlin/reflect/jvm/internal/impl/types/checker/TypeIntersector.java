package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.v;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: IntersectionType.kt */
public final class TypeIntersector {
    public static final TypeIntersector eVO = new TypeIntersector();

    /* compiled from: IntersectionType.kt */
    private enum ResultNullability {
        ;

        /* compiled from: IntersectionType.kt */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i);
            }

            public ResultNullability combine(ay ayVar) {
                h.e(ayVar, "nextType");
                return getResultNullability(ayVar);
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class NOT_NULL extends ResultNullability {
            public NOT_NULL combine(ay ayVar) {
                h.e(ayVar, "nextType");
                return this;
            }

            NOT_NULL(String str, int i) {
                super(str, i);
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i);
            }

            public ResultNullability combine(ay ayVar) {
                h.e(ayVar, "nextType");
                return getResultNullability(ayVar);
            }
        }

        /* compiled from: IntersectionType.kt */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i);
            }

            public ResultNullability combine(ay ayVar) {
                h.e(ayVar, "nextType");
                ResultNullability resultNullability = getResultNullability(ayVar);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        public abstract ResultNullability combine(ay ayVar);

        protected final ResultNullability getResultNullability(ay ayVar) {
            h.e(ayVar, "$receiver");
            if (ayVar.aYp()) {
                return ACCEPT_NULL;
            }
            if (k.eVA.f(ayVar)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }

    private TypeIntersector() {
    }

    public final ad cr(List<? extends ad> list) {
        h.e(list, "types");
        Object obj = list.size() > 1 ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Size should be at least 2, but it is ");
            stringBuilder.append(list.size());
            throw new AssertionError(stringBuilder.toString());
        }
        ArrayList arrayList = new ArrayList();
        for (ad adVar : list) {
            if (adVar.bwA() instanceof v) {
                Collection beu = adVar.bwA().beu();
                h.d(beu, "type.constructor.supertypes");
                Iterable<w> iterable = beu;
                Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                for (w wVar : iterable) {
                    h.d(wVar, "it");
                    Object aE = t.aE(wVar);
                    if (adVar.aYp()) {
                        aE = aE.gQ(true);
                    }
                    arrayList2.add(aE);
                }
                arrayList.addAll((List) arrayList2);
            } else {
                arrayList.add(adVar);
            }
        }
        Iterable<ay> iterable2 = arrayList;
        ResultNullability resultNullability = ResultNullability.START;
        for (ay combine : iterable2) {
            resultNullability = resultNullability.combine(combine);
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (Object obj2 : iterable2) {
            Object obj22;
            if (resultNullability == ResultNullability.NOT_NULL) {
                obj22 = ag.d((ad) obj22);
            }
            linkedHashSet.add(obj22);
        }
        return n((LinkedHashSet) linkedHashSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A:{SYNTHETIC} */
    private final kotlin.reflect.jvm.internal.impl.types.ad n(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.types.ad> r12) {
        /*
        r11 = this;
        r0 = r12.size();
        r1 = 1;
        if (r0 != r1) goto L_0x0010;
    L_0x0007:
        r12 = (java.lang.Iterable) r12;
        r12 = kotlin.collections.u.Q(r12);
        r12 = (kotlin.reflect.jvm.internal.impl.types.ad) r12;
        return r12;
    L_0x0010:
        r0 = new java.util.ArrayList;
        r2 = r12;
        r2 = (java.util.Collection) r2;
        r0.<init>(r2);
        r3 = r0.iterator();
    L_0x001c:
        r4 = r3.hasNext();
        r5 = 0;
        if (r4 == 0) goto L_0x0077;
    L_0x0023:
        r4 = r3.next();
        r4 = (kotlin.reflect.jvm.internal.impl.types.ad) r4;
        r6 = r0;
        r6 = (java.lang.Iterable) r6;
        r7 = r6 instanceof java.util.Collection;
        if (r7 == 0) goto L_0x003a;
    L_0x0030:
        r7 = r6;
        r7 = (java.util.Collection) r7;
        r7 = r7.isEmpty();
        if (r7 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x0071;
    L_0x003a:
        r6 = r6.iterator();
    L_0x003e:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x0071;
    L_0x0044:
        r7 = r6.next();
        r7 = (kotlin.reflect.jvm.internal.impl.types.ad) r7;
        if (r7 == r4) goto L_0x006d;
    L_0x004c:
        r8 = eVO;
        r9 = "lower";
        kotlin.jvm.internal.h.d(r7, r9);
        r7 = (kotlin.reflect.jvm.internal.impl.types.w) r7;
        r9 = "upper";
        kotlin.jvm.internal.h.d(r4, r9);
        r9 = r4;
        r9 = (kotlin.reflect.jvm.internal.impl.types.w) r9;
        r8 = r8.j(r7, r9);
        if (r8 != 0) goto L_0x006b;
    L_0x0063:
        r8 = kotlin.reflect.jvm.internal.impl.types.checker.g.eVz;
        r7 = r8.d(r7, r9);
        if (r7 == 0) goto L_0x006d;
    L_0x006b:
        r7 = 1;
        goto L_0x006e;
    L_0x006d:
        r7 = 0;
    L_0x006e:
        if (r7 == 0) goto L_0x003e;
    L_0x0070:
        r5 = 1;
    L_0x0071:
        if (r5 == 0) goto L_0x001c;
    L_0x0073:
        r3.remove();
        goto L_0x001c;
    L_0x0077:
        r3 = r0;
        r3 = (java.util.Collection) r3;
        r3 = r3.isEmpty();
        r1 = r1 ^ r3;
        r3 = kotlin.m.etY;
        if (r3 == 0) goto L_0x00ae;
    L_0x0083:
        if (r1 != 0) goto L_0x00ae;
    L_0x0085:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "This collections cannot be empty! input types: ";
        r0.append(r1);
        r2 = r12;
        r2 = (java.lang.Iterable) r2;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 63;
        r10 = 0;
        r12 = kotlin.collections.u.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0.append(r12);
        r12 = r0.toString();
        r0 = new java.lang.AssertionError;
        r0.<init>(r12);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x00ae:
        r12 = r0.size();
        r1 = 2;
        if (r12 >= r1) goto L_0x00c3;
    L_0x00b5:
        r0 = (java.util.List) r0;
        r12 = kotlin.collections.u.bY(r0);
        r0 = "filteredSuperAndEqualTypes.single()";
        kotlin.jvm.internal.h.d(r12, r0);
        r12 = (kotlin.reflect.jvm.internal.impl.types.ad) r12;
        return r12;
    L_0x00c3:
        r12 = new kotlin.reflect.jvm.internal.impl.types.v;
        r12.<init>(r2);
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF;
        r0 = r0.bel();
        r1 = r12;
        r1 = (kotlin.reflect.jvm.internal.impl.types.an) r1;
        r2 = kotlin.collections.m.emptyList();
        r12 = r12.bzb();
        r3 = "constructor.createScopeForKotlinType()";
        kotlin.jvm.internal.h.d(r12, r3);
        r12 = kotlin.reflect.jvm.internal.impl.types.x.a(r0, r1, r2, r5, r12);
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.n(java.util.Set):kotlin.reflect.jvm.internal.impl.types.ad");
    }

    private final boolean j(w wVar, w wVar2) {
        g gVar = g.eVz;
        return gVar.c(wVar, wVar2) && !gVar.c(wVar2, wVar);
    }
}
