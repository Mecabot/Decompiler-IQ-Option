package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.fragment.cashbox.deppage.a;
import com.iqoption.fragment.cashbox.deppage.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.aj;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ao;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.aw;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.a.c;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.q;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.v;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: NewKotlinTypeChecker.kt */
public final class g implements b {
    public static final g eVz = new g();

    private g() {
    }

    public boolean c(w wVar, w wVar2) {
        h.e(wVar, "subtype");
        h.e(wVar2, "supertype");
        return b(new TypeCheckerContext(true, false, 2, null), wVar.bzc(), wVar2.bzc());
    }

    public boolean d(w wVar, w wVar2) {
        h.e(wVar, a.TAG);
        h.e(wVar2, b.TAG);
        return a(new TypeCheckerContext(false, false, 2, null), wVar.bzc(), wVar2.bzc());
    }

    public final boolean a(TypeCheckerContext typeCheckerContext, ay ayVar, ay ayVar2) {
        h.e(typeCheckerContext, "$receiver");
        h.e(ayVar, a.TAG);
        h.e(ayVar2, b.TAG);
        boolean z = true;
        if (ayVar == ayVar2) {
            return true;
        }
        w wVar = ayVar;
        if (bf(wVar)) {
            w wVar2 = ayVar2;
            if (bf(wVar2)) {
                if (!typeCheckerContext.d(ayVar.bwA(), ayVar2.bwA())) {
                    return false;
                }
                if (ayVar.bdF().isEmpty()) {
                    if (be(wVar) || be(wVar2)) {
                        return true;
                    }
                    if (ayVar.aYp() != ayVar2.aYp()) {
                        z = false;
                    }
                    return z;
                }
            }
        }
        if (!(b(typeCheckerContext, ayVar, ayVar2) && b(typeCheckerContext, ayVar2, ayVar))) {
            z = false;
        }
        return z;
    }

    private final boolean be(w wVar) {
        return t.aD(wVar).aYp() != t.aE(wVar).aYp();
    }

    private final boolean bf(w wVar) {
        return wVar.bwA().bbY() && !n.az(wVar) && !ag.aI(wVar) && h.E(t.aD(wVar).bwA(), t.aE(wVar).bwA());
    }

    public final boolean b(TypeCheckerContext typeCheckerContext, ay ayVar, ay ayVar2) {
        h.e(typeCheckerContext, "$receiver");
        h.e(ayVar, "subType");
        h.e(ayVar2, "superType");
        if (ayVar == ayVar2) {
            return true;
        }
        ayVar = e(ayVar);
        ayVar2 = e(ayVar2);
        w wVar = ayVar;
        w wVar2 = ayVar2;
        Boolean a = a(typeCheckerContext, t.aD(wVar), t.aE(wVar2));
        if (a != null) {
            boolean booleanValue = a.booleanValue();
            typeCheckerContext.b(ayVar, ayVar2);
            return booleanValue;
        }
        Boolean b = typeCheckerContext.b(ayVar, ayVar2);
        if (b != null) {
            return b.booleanValue();
        }
        return b(typeCheckerContext, t.aD(wVar), t.aE(wVar2));
    }

    public final ad e(ad adVar) {
        h.e(adVar, Param.TYPE);
        an bwA = adVar.bwA();
        boolean z = false;
        Iterable<w> beu;
        Collection arrayList;
        if (bwA instanceof kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) {
            kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b bVar = (kotlin.reflect.jvm.internal.impl.resolve.calls.inference.b) bwA;
            ap bwD = bVar.bwD();
            if (bwD.bzf() == Variance.IN_VARIANCE) {
                z = true;
            }
            ay ayVar = null;
            if (!z) {
                bwD = null;
            }
            if (bwD != null) {
                w bai = bwD.bai();
                if (bai != null) {
                    ayVar = bai.bzc();
                }
            }
            ay ayVar2 = ayVar;
            if (bVar.bwB() == null) {
                bwD = bVar.bwD();
                Iterable<w> beu2 = bVar.beu();
                Collection arrayList2 = new ArrayList(n.e(beu2, 10));
                for (w bzc : beu2) {
                    arrayList2.add(bzc.bzc());
                }
                bVar.a(new e(bwD, (List) arrayList2));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            e bwB = bVar.bwB();
            if (bwB == null) {
                h.aXZ();
            }
            return new d(captureStatus, bwB, ayVar2, adVar.bbQ(), adVar.aYp());
        } else if (bwA instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.n) {
            beu = ((kotlin.reflect.jvm.internal.impl.resolve.constants.n) bwA).beu();
            arrayList = new ArrayList(n.e(beu, 10));
            for (w b : beu) {
                arrayList.add(au.b(b, adVar.aYp()));
            }
            return x.a(adVar.bbQ(), new v((List) arrayList), m.emptyList(), false, adVar.bbk());
        } else if (!(bwA instanceof v) || !adVar.aYp()) {
            return adVar;
        } else {
            Collection beu3 = ((v) bwA).beu();
            h.d(beu3, "constructor.supertypes");
            beu = beu3;
            arrayList = new ArrayList(n.e(beu, 10));
            for (w b2 : beu) {
                h.d(b2, "it");
                arrayList.add(kotlin.reflect.jvm.internal.impl.types.b.a.aT(b2));
            }
            v vVar = new v((List) arrayList);
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ = adVar.bbQ();
            an anVar = vVar;
            List emptyList = m.emptyList();
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h bzb = vVar.bzb();
            h.d(bzb, "newConstructor.createScopeForKotlinType()");
            return x.a(bbQ, anVar, emptyList, false, bzb);
        }
    }

    public final ay e(ay ayVar) {
        ay e;
        h.e(ayVar, Param.TYPE);
        if (ayVar instanceof ad) {
            e = e((ad) ayVar);
        } else if (ayVar instanceof q) {
            q qVar = (q) ayVar;
            ad e2 = e(qVar.byT());
            ad e3 = e(qVar.byU());
            if (e2 == qVar.byT() && e3 == qVar.byU()) {
                e = ayVar;
            } else {
                e = x.a(e2, e3);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return aw.a(e, ayVar);
    }

    private final Boolean a(TypeCheckerContext typeCheckerContext, ad adVar, ad adVar2) {
        boolean z = true;
        if (y.aF(adVar) || y.aF(adVar2)) {
            if (typeCheckerContext.bzo()) {
                return Boolean.valueOf(true);
            }
            if (!adVar.aYp() || adVar2.aYp()) {
                return Boolean.valueOf(l.eVB.c(adVar.gQ(false), adVar2.gQ(false)));
            }
            return Boolean.valueOf(false);
        } else if ((adVar instanceof aj) || (adVar2 instanceof aj)) {
            return Boolean.valueOf(true);
        } else {
            if (adVar2 instanceof d) {
                d dVar = (d) adVar2;
                if (dVar.bzl() != null) {
                    switch (h.aoS[typeCheckerContext.a(adVar, dVar).ordinal()]) {
                        case 1:
                            return Boolean.valueOf(b(typeCheckerContext, (ay) adVar, dVar.bzl()));
                        case 2:
                            if (b(typeCheckerContext, (ay) adVar, dVar.bzl())) {
                                return Boolean.valueOf(true);
                            }
                            break;
                    }
                }
            }
            an bwA = adVar2.bwA();
            if (!(bwA instanceof v)) {
                bwA = null;
            }
            v vVar = (v) bwA;
            if (vVar == null) {
                return null;
            }
            int aYp = adVar2.aYp() ^ 1;
            if (m.etY && aYp == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Intersection type should not be marked nullable!: ");
                stringBuilder.append(adVar2);
                throw new AssertionError(stringBuilder.toString());
            }
            Collection beu = vVar.beu();
            h.d(beu, "it.supertypes");
            Iterable<w> iterable = beu;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (w bzc : iterable) {
                    if (!eVz.b(typeCheckerContext, (ay) adVar, bzc.bzc())) {
                        z = false;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0100 A:{RETURN} */
    private final boolean b(kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext r18, kotlin.reflect.jvm.internal.impl.types.ad r19, kotlin.reflect.jvm.internal.impl.types.ad r20) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = kotlin.reflect.jvm.internal.impl.types.checker.i.g(r19);
        r5 = 1;
        r6 = 0;
        if (r4 != 0) goto L_0x0022;
    L_0x0010:
        r4 = kotlin.reflect.jvm.internal.impl.types.checker.i.h(r19);
        if (r4 != 0) goto L_0x0022;
    L_0x0016:
        r4 = r2;
        r4 = (kotlin.reflect.jvm.internal.impl.types.ay) r4;
        r4 = r1.g(r4);
        if (r4 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r4 = 0;
        goto L_0x0023;
    L_0x0022:
        r4 = 1;
    L_0x0023:
        r7 = kotlin.m.etY;
        if (r7 == 0) goto L_0x0042;
    L_0x0027:
        if (r4 != 0) goto L_0x0042;
    L_0x0029:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "Not singleClassifierType and not intersection subType: ";
        r1.append(r3);
        r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.AssertionError;
        r2.<init>(r1);
        r2 = (java.lang.Throwable) r2;
        throw r2;
    L_0x0042:
        r4 = kotlin.reflect.jvm.internal.impl.types.checker.i.g(r20);
        if (r4 != 0) goto L_0x0054;
    L_0x0048:
        r4 = r3;
        r4 = (kotlin.reflect.jvm.internal.impl.types.ay) r4;
        r4 = r1.g(r4);
        if (r4 == 0) goto L_0x0052;
    L_0x0051:
        goto L_0x0054;
    L_0x0052:
        r4 = 0;
        goto L_0x0055;
    L_0x0054:
        r4 = 1;
    L_0x0055:
        r7 = kotlin.m.etY;
        if (r7 == 0) goto L_0x0074;
    L_0x0059:
        if (r4 != 0) goto L_0x0074;
    L_0x005b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Not singleClassifierType superType: ";
        r1.append(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = new java.lang.AssertionError;
        r2.<init>(r1);
        r2 = (java.lang.Throwable) r2;
        throw r2;
    L_0x0074:
        r4 = kotlin.reflect.jvm.internal.impl.types.checker.k.eVA;
        r4 = r4.c(r1, r2, r3);
        if (r4 != 0) goto L_0x007d;
    L_0x007c:
        return r6;
    L_0x007d:
        r4 = r20.bwA();
        r7 = r19.bwA();
        r7 = kotlin.jvm.internal.h.E(r7, r4);
        if (r7 == 0) goto L_0x0096;
    L_0x008b:
        r7 = r4.getParameters();
        r7 = r7.isEmpty();
        if (r7 == 0) goto L_0x0096;
    L_0x0095:
        return r5;
    L_0x0096:
        r7 = r3;
        r7 = (kotlin.reflect.jvm.internal.impl.types.w) r7;
        r7 = kotlin.reflect.jvm.internal.impl.types.b.a.D(r7);
        if (r7 == 0) goto L_0x00a0;
    L_0x009f:
        return r5;
    L_0x00a0:
        r7 = r0.b(r1, r2, r4);
        r8 = r7.size();
        switch(r8) {
            case 0: goto L_0x00ca;
            case 1: goto L_0x00bb;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        r8 = r18.bzn();
        r9 = kotlin.reflect.jvm.internal.impl.types.checker.h.auk;
        r8 = r8.ordinal();
        r8 = r9[r8];
        switch(r8) {
            case 1: goto L_0x0110;
            case 2: goto L_0x0101;
            case 3: goto L_0x00cf;
            case 4: goto L_0x00cf;
            default: goto L_0x00ba;
        };
    L_0x00ba:
        goto L_0x0111;
    L_0x00bb:
        r2 = kotlin.collections.u.bU(r7);
        r2 = (kotlin.reflect.jvm.internal.impl.types.ad) r2;
        r2 = r2.bdF();
        r1 = r0.a(r1, r2, r3);
        return r1;
    L_0x00ca:
        r1 = r17.a(r18, r19);
        return r1;
    L_0x00cf:
        r8 = r7;
        r8 = (java.lang.Iterable) r8;
        r9 = r8 instanceof java.util.Collection;
        if (r9 == 0) goto L_0x00e1;
    L_0x00d6:
        r9 = r8;
        r9 = (java.util.Collection) r9;
        r9 = r9.isEmpty();
        if (r9 == 0) goto L_0x00e1;
    L_0x00df:
        r8 = 0;
        goto L_0x00fe;
    L_0x00e1:
        r8 = r8.iterator();
    L_0x00e5:
        r9 = r8.hasNext();
        if (r9 == 0) goto L_0x00df;
    L_0x00eb:
        r9 = r8.next();
        r9 = (kotlin.reflect.jvm.internal.impl.types.ad) r9;
        r10 = eVz;
        r9 = r9.bdF();
        r9 = r10.a(r1, r9, r3);
        if (r9 == 0) goto L_0x00e5;
    L_0x00fd:
        r8 = 1;
    L_0x00fe:
        if (r8 == 0) goto L_0x0111;
    L_0x0100:
        return r5;
    L_0x0101:
        r2 = kotlin.collections.u.bU(r7);
        r2 = (kotlin.reflect.jvm.internal.impl.types.ad) r2;
        r2 = r2.bdF();
        r1 = r0.a(r1, r2, r3);
        return r1;
    L_0x0110:
        return r6;
    L_0x0111:
        r8 = r18.bzn();
        r9 = kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SeveralSupertypesWithSameConstructorPolicy.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;
        if (r8 == r9) goto L_0x011a;
    L_0x0119:
        return r6;
    L_0x011a:
        r4 = r4.getParameters();
        r8 = "superConstructor.parameters";
        kotlin.jvm.internal.h.d(r4, r8);
        r4 = (java.lang.Iterable) r4;
        r8 = new java.util.ArrayList;
        r9 = 10;
        r10 = kotlin.collections.n.e(r4, r9);
        r8.<init>(r10);
        r8 = (java.util.Collection) r8;
        r4 = r4.iterator();
        r10 = 0;
    L_0x0137:
        r11 = r4.hasNext();
        if (r11 == 0) goto L_0x01d3;
    L_0x013d:
        r11 = r4.next();
        r12 = r10 + 1;
        r11 = (kotlin.reflect.jvm.internal.impl.descriptors.an) r11;
        r11 = r7;
        r11 = (java.lang.Iterable) r11;
        r13 = new java.util.ArrayList;
        r14 = kotlin.collections.n.e(r11, r9);
        r13.<init>(r14);
        r13 = (java.util.Collection) r13;
        r11 = r11.iterator();
    L_0x0157:
        r14 = r11.hasNext();
        if (r14 == 0) goto L_0x01bf;
    L_0x015d:
        r14 = r11.next();
        r14 = (kotlin.reflect.jvm.internal.impl.types.ad) r14;
        r15 = r14.bdF();
        r15 = kotlin.collections.u.h(r15, r10);
        r15 = (kotlin.reflect.jvm.internal.impl.types.ap) r15;
        if (r15 == 0) goto L_0x0192;
    L_0x016f:
        r5 = r15.bzf();
        r6 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
        if (r5 != r6) goto L_0x0179;
    L_0x0177:
        r5 = 1;
        goto L_0x017a;
    L_0x0179:
        r5 = 0;
    L_0x017a:
        if (r5 == 0) goto L_0x017d;
    L_0x017c:
        goto L_0x017e;
    L_0x017d:
        r15 = 0;
    L_0x017e:
        if (r15 == 0) goto L_0x0192;
    L_0x0180:
        r5 = r15.bai();
        if (r5 == 0) goto L_0x0192;
    L_0x0186:
        r5 = r5.bzc();
        if (r5 == 0) goto L_0x0192;
    L_0x018c:
        r13.add(r5);
        r5 = 1;
        r6 = 0;
        goto L_0x0157;
    L_0x0192:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "Incorrect type: ";
        r1.append(r4);
        r1.append(r14);
        r4 = ", subType: ";
        r1.append(r4);
        r1.append(r2);
        r2 = ", superType: ";
        r1.append(r2);
        r1.append(r3);
        r1 = r1.toString();
        r2 = new java.lang.IllegalStateException;
        r1 = r1.toString();
        r2.<init>(r1);
        r2 = (java.lang.Throwable) r2;
        throw r2;
    L_0x01bf:
        r13 = (java.util.List) r13;
        r5 = kotlin.reflect.jvm.internal.impl.types.checker.a.co(r13);
        r5 = (kotlin.reflect.jvm.internal.impl.types.w) r5;
        r5 = kotlin.reflect.jvm.internal.impl.types.b.a.bk(r5);
        r8.add(r5);
        r10 = r12;
        r5 = 1;
        r6 = 0;
        goto L_0x0137;
    L_0x01d3:
        r8 = (java.util.List) r8;
        r1 = r0.a(r1, r8, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.g.b(kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.ad, kotlin.reflect.jvm.internal.impl.types.ad):boolean");
    }

    private final List<ad> a(TypeCheckerContext typeCheckerContext, ad adVar, an anVar) {
        return cq(c(typeCheckerContext, adVar, anVar));
    }

    public final List<ad> b(TypeCheckerContext typeCheckerContext, ad adVar, an anVar) {
        h.e(typeCheckerContext, "$receiver");
        h.e(adVar, "baseType");
        h.e(anVar, "constructor");
        if (i.f(adVar)) {
            return a(typeCheckerContext, adVar, anVar);
        }
        if (!(anVar.bbW() instanceof d)) {
            return c(typeCheckerContext, adVar, anVar);
        }
        kotlin.reflect.jvm.internal.impl.utils.h<ad> hVar = new kotlin.reflect.jvm.internal.impl.utils.h();
        typeCheckerContext.initialize();
        ArrayDeque c = typeCheckerContext.eVF;
        if (c == null) {
            h.aXZ();
        }
        Set d = typeCheckerContext.eVG;
        if (d == null) {
            h.aXZ();
        }
        c.push(adVar);
        while ((c.isEmpty() ^ 1) != 0) {
            if (d.size() > 1000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many supertypes for type: ");
                stringBuilder.append(adVar);
                stringBuilder.append(". Supertypes = ");
                stringBuilder.append(u.a(d, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            ad adVar2 = (ad) c.pop();
            h.d(adVar2, "current");
            if (d.add(adVar2)) {
                TypeCheckerContext.a aVar;
                if (i.f(adVar2)) {
                    hVar.add(adVar2);
                    aVar = c.eVK;
                } else {
                    aVar = TypeCheckerContext.a.a.eVJ;
                }
                if ((h.E(aVar, c.eVK) ^ 1) == 0) {
                    aVar = null;
                }
                if (aVar != null) {
                    for (w wVar : adVar2.bwA().beu()) {
                        h.d(wVar, "supertype");
                        c.add(aVar.bg(wVar));
                    }
                }
            }
        }
        typeCheckerContext.clear();
        Collection arrayList = new ArrayList();
        for (ad adVar3 : hVar) {
            g gVar = eVz;
            h.d(adVar3, "it");
            r.a(arrayList, (Iterable) gVar.a(typeCheckerContext, adVar3, anVar));
        }
        return (List) arrayList;
    }

    private final List<ad> c(TypeCheckerContext typeCheckerContext, ad adVar, an anVar) {
        TypeCheckerContext typeCheckerContext2 = typeCheckerContext;
        ad adVar2 = adVar;
        an anVar2 = anVar;
        f bbW = anVar.bbW();
        if (!(bbW instanceof d)) {
            bbW = null;
        }
        d dVar = (d) bbW;
        if (dVar == null) {
        } else if (N(dVar)) {
            List<ad> cr;
            if (typeCheckerContext2.d(adVar.bwA(), anVar2)) {
                Object a = f.a(adVar2, CaptureStatus.FOR_SUBTYPING, null, 4, null);
                if (a == null) {
                    a = adVar2;
                }
                cr = l.cr(a);
            } else {
                cr = m.emptyList();
            }
            return cr;
        }
        List<ad> hVar = new kotlin.reflect.jvm.internal.impl.utils.h();
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
                TypeCheckerContext.a aVar;
                ad a2 = f.a(adVar3, CaptureStatus.FOR_SUBTYPING, null, 4, null);
                if (a2 == null) {
                    a2 = adVar3;
                }
                if (typeCheckerContext2.d(a2.bwA(), anVar2)) {
                    hVar.add(a2);
                    aVar = c.eVK;
                } else if (a2.bdF().isEmpty()) {
                    aVar = TypeCheckerContext.a.a.eVJ;
                } else {
                    aVar = new TypeCheckerContext.a.b(ao.eVe.aN(a2).bzh());
                }
                if ((h.E(aVar, c.eVK) ^ 1) == 0) {
                    aVar = null;
                }
                if (aVar != null) {
                    for (w wVar : adVar3.bwA().beu()) {
                        h.d(wVar, "supertype");
                        c.add(aVar.bg(wVar));
                    }
                }
            }
        }
        typeCheckerContext.clear();
        return hVar;
    }

    private final boolean N(d dVar) {
        return (!kotlin.reflect.jvm.internal.impl.descriptors.t.s(dVar) || dVar.bbF() == ClassKind.ENUM_ENTRY || dVar.bbF() == ClassKind.ANNOTATION_CLASS) ? false : true;
    }

    private final List<ad> cq(List<? extends ad> list) {
        if (list.size() < 2) {
            return list;
        }
        List<ad> list2;
        Collection arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Iterable<ap> bdF = ((ad) next).bdF();
            if (!(bdF instanceof Collection) || !((Collection) bdF).isEmpty()) {
                for (ap bai : bdF) {
                    w bai2 = bai.bai();
                    h.d(bai2, "it.type");
                    if ((t.aB(bai2) ^ 1) == 0) {
                        i = 0;
                        break;
                    }
                }
            }
            if (i != 0) {
                arrayList.add(next);
            }
        }
        List<ad> list3 = (List) arrayList;
        if ((list3.isEmpty() ^ 1) != 0) {
            list2 = list3;
        }
        return list2;
    }

    public final Variance c(Variance variance, Variance variance2) {
        h.e(variance, "declared");
        h.e(variance2, "useSite");
        if (variance == Variance.INVARIANT) {
            return variance2;
        }
        return (variance2 == Variance.INVARIANT || variance == variance2) ? variance : null;
    }

    private final boolean a(TypeCheckerContext typeCheckerContext, List<? extends ap> list, ad adVar) {
        if (list == adVar.bdF()) {
            return true;
        }
        List parameters = adVar.bwA().getParameters();
        h.d(parameters, "parameters");
        int size = parameters.size();
        for (int i = 0; i < size; i++) {
            ap apVar = (ap) adVar.bdF().get(i);
            if (!apVar.bze()) {
                ay bzc = apVar.bai().bzc();
                ap apVar2 = (ap) list.get(i);
                Object obj = apVar2.bzf() == Variance.INVARIANT ? 1 : null;
                StringBuilder stringBuilder;
                if (m.etY && obj == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Incorrect sub argument: ");
                    stringBuilder.append(apVar2);
                    throw new AssertionError(stringBuilder.toString());
                }
                ay bzc2 = apVar2.bai().bzc();
                obj = parameters.get(i);
                h.d(obj, "parameters[index]");
                Variance bdd = ((kotlin.reflect.jvm.internal.impl.descriptors.an) obj).bdd();
                h.d(bdd, "parameters[index].variance");
                Variance bzf = apVar.bzf();
                h.d(bzf, "superProjection.projectionKind");
                bzf = c(bdd, bzf);
                if (bzf == null) {
                    return typeCheckerContext.bzo();
                }
                if (typeCheckerContext.eVD > 100) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Arguments depth is too high. Some related argument: ");
                    stringBuilder.append(bzc2);
                    throw new IllegalStateException(stringBuilder.toString().toString());
                }
                boolean a;
                typeCheckerContext.eVD = typeCheckerContext.eVD + 1;
                switch (h.auV[bzf.ordinal()]) {
                    case 1:
                        a = eVz.a(typeCheckerContext, bzc2, bzc);
                        break;
                    case 2:
                        a = eVz.b(typeCheckerContext, bzc2, bzc);
                        break;
                    case 3:
                        a = eVz.b(typeCheckerContext, bzc, bzc2);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                typeCheckerContext.eVD = typeCheckerContext.eVD - 1;
                if (!a) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean a(TypeCheckerContext typeCheckerContext, ad adVar) {
        if (kotlin.reflect.jvm.internal.impl.builtins.g.C(adVar)) {
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
        c.push(adVar);
        while ((c.isEmpty() ^ 1) != 0) {
            if (d.size() > 1000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many supertypes for type: ");
                stringBuilder.append(adVar);
                stringBuilder.append(". Supertypes = ");
                stringBuilder.append(u.a(d, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            ad adVar2 = (ad) c.pop();
            h.d(adVar2, "current");
            if (d.add(adVar2)) {
                TypeCheckerContext.a aVar;
                if (i.f(adVar2)) {
                    aVar = c.eVK;
                } else {
                    aVar = TypeCheckerContext.a.a.eVJ;
                }
                if ((h.E(aVar, c.eVK) ^ 1) == 0) {
                    aVar = null;
                }
                if (aVar != null) {
                    for (w wVar : adVar2.bwA().beu()) {
                        h.d(wVar, "supertype");
                        ad bg = aVar.bg(wVar);
                        if (kotlin.reflect.jvm.internal.impl.builtins.g.C(bg)) {
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
