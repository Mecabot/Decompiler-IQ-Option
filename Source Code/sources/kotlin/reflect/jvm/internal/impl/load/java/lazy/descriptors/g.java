package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.a.b;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.j;
import kotlin.reflect.jvm.internal.impl.load.java.l;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.p;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.x;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class g extends k {
    private final e<List<c>> eHC;
    private final e<Set<f>> eHD;
    private final e<Map<f, n>> eHE;
    private final kotlin.reflect.jvm.internal.impl.storage.c<f, kotlin.reflect.jvm.internal.impl.descriptors.impl.g> eHF;
    private final d eHG;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.g eHk;

    /* renamed from: bgI */
    protected d bgJ() {
        return this.eHG;
    }

    public g(h hVar, d dVar, kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.jvm.internal.h.e(dVar, "ownerDescriptor");
        kotlin.jvm.internal.h.e(gVar, "jClass");
        super(hVar);
        this.eHG = dVar;
        this.eHk = gVar;
        this.eHC = hVar.baI().i(new LazyJavaClassMemberScope$constructors$1(this, hVar));
        this.eHD = hVar.baI().i(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.eHE = hVar.baI().i(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.eHF = hVar.baI().p(new LazyJavaClassMemberScope$nestedClasses$1(this, hVar));
    }

    /* renamed from: bgE */
    protected a bgF() {
        return new a(this.eHk, LazyJavaClassMemberScope$computeMemberIndex$1.eHH);
    }

    /* renamed from: b */
    protected HashSet<f> c(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, b<? super f, Boolean> bVar) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        an bby = bgJ().bby();
        kotlin.jvm.internal.h.d(bby, "ownerDescriptor.typeConstructor");
        Collection<w> beu = bby.beu();
        kotlin.jvm.internal.h.d(beu, "ownerDescriptor.typeConstructor.supertypes");
        Collection hashSet = new HashSet();
        for (w bbk : beu) {
            r.a(hashSet, (Iterable) bbk.bbk().beC());
        }
        HashSet<f> hashSet2 = (HashSet) hashSet;
        hashSet2.addAll(((b) bgQ().invoke()).bgv());
        hashSet2.addAll(d(dVar, (b) bVar));
        return hashSet2;
    }

    public final e<List<c>> bgG() {
        return this.eHC;
    }

    protected boolean a(JavaMethodDescriptor javaMethodDescriptor) {
        kotlin.jvm.internal.h.e(javaMethodDescriptor, "$receiver");
        if (this.eHk.bhr()) {
            return false;
        }
        return d((ah) javaMethodDescriptor);
    }

    private final boolean d(ah ahVar) {
        Object obj;
        f bdc = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "function.name");
        Iterable<f> q = p.q(bdc);
        boolean z = true;
        if (!((q instanceof Collection) && ((Collection) q).isEmpty())) {
            for (f x : q) {
                Object obj2;
                Iterable<ad> x2 = x(x);
                if (!((x2 instanceof Collection) && ((Collection) x2).isEmpty())) {
                    for (ad adVar : x2) {
                        Object obj3;
                        if (!c(adVar, (b) new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$$inlined$any$lambda$1(this, ahVar)) || (!adVar.bdW() && l.ml(ahVar.bdc().asString()))) {
                            obj3 = null;
                            continue;
                        } else {
                            obj3 = 1;
                            continue;
                        }
                        if (obj3 != null) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                }
                obj2 = null;
                continue;
                if (obj2 != null) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj != null) {
            return false;
        }
        if (f(ahVar) || e(ahVar) || g(ahVar)) {
            z = false;
        }
        return z;
    }

    private final boolean e(ah ahVar) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.eES;
        f bdc = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "name");
        boolean m = builtinMethodsWithSpecialGenericSignature.m(bdc);
        boolean z = false;
        if (!m) {
            return false;
        }
        f bdc2 = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc2, "name");
        Collection arrayList = new ArrayList();
        for (ah h : w(bdc2)) {
            r h2 = BuiltinMethodsWithSpecialGenericSignature.h(h);
            if (h2 != null) {
                arrayList.add(h2);
            }
        }
        Iterable<r> iterable = (List) arrayList;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (r b : iterable) {
                if (b(ahVar, b)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    private final Collection<ah> u(f fVar) {
        Iterable<q> r = ((b) bgQ().invoke()).r(fVar);
        Collection arrayList = new ArrayList(n.e(r, 10));
        for (q c : r) {
            arrayList.add(c(c));
        }
        return (List) arrayList;
    }

    private final Collection<ah> v(f fVar) {
        Collection arrayList = new ArrayList();
        for (Object next : w(fVar)) {
            ah ahVar = (ah) next;
            Object obj = (kotlin.reflect.jvm.internal.impl.load.java.q.r((CallableMemberDescriptor) ahVar) || BuiltinMethodsWithSpecialGenericSignature.h(ahVar) != null) ? 1 : null;
            if (obj == null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    private final boolean f(ah ahVar) {
        kotlin.reflect.jvm.internal.impl.load.java.b bVar = kotlin.reflect.jvm.internal.impl.load.java.b.eEK;
        f bdc = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "name");
        Iterable<f> l = bVar.l(bdc);
        if ((l instanceof Collection) && ((Collection) l).isEmpty()) {
            return false;
        }
        for (f bdc2 : l) {
            Object obj;
            Collection arrayList = new ArrayList();
            for (Object next : w(bdc2)) {
                if (kotlin.reflect.jvm.internal.impl.load.java.q.r((ah) next)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                ah a = a(ahVar, bdc2);
                Iterable<ah> iterable = list;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (ah a2 : iterable) {
                        if (a(a2, (r) a)) {
                            obj = 1;
                            continue;
                            break;
                        }
                    }
                }
            }
            obj = null;
            continue;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private final boolean g(ah ahVar) {
        ah h = h(ahVar);
        boolean z = false;
        if (h == null) {
            return false;
        }
        f bdc = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "name");
        Iterable<ah> w = w(bdc);
        if (!(w instanceof Collection) || !((Collection) w).isEmpty()) {
            for (ah ahVar2 : w) {
                Object obj;
                if (ahVar2.bdq() && b((a) h, (a) ahVar2)) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    private final kotlin.reflect.jvm.internal.impl.descriptors.ah h(kotlin.reflect.jvm.internal.impl.descriptors.ah r5) {
        /*
        r4 = this;
        r0 = r5.bcS();
        r1 = "valueParameters";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = kotlin.collections.u.bX(r0);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.aq) r0;
        r1 = 0;
        if (r0 == 0) goto L_0x008e;
    L_0x0012:
        r2 = r0.bai();
        r2 = r2.bwA();
        r2 = r2.bbW();
        if (r2 == 0) goto L_0x0037;
    L_0x0020:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r2;
        r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(r2);
        if (r2 == 0) goto L_0x0037;
    L_0x0028:
        r3 = r2.isSafe();
        if (r3 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0030;
    L_0x002f:
        r2 = r1;
    L_0x0030:
        if (r2 == 0) goto L_0x0037;
    L_0x0032:
        r2 = r2.btP();
        goto L_0x0038;
    L_0x0037:
        r2 = r1;
    L_0x0038:
        r3 = r4.bgT();
        r3 = r3.bgq();
        r3 = r3.bgk();
        r3 = r3.bgl();
        r2 = kotlin.reflect.jvm.internal.impl.builtins.j.a(r2, r3);
        if (r2 == 0) goto L_0x004f;
    L_0x004e:
        goto L_0x0050;
    L_0x004f:
        r0 = r1;
    L_0x0050:
        if (r0 == 0) goto L_0x008e;
    L_0x0052:
        r1 = r5.bdr();
        r5 = r5.bcS();
        r2 = "valueParameters";
        kotlin.jvm.internal.h.d(r5, r2);
        r2 = 1;
        r5 = kotlin.collections.u.i(r5, r2);
        r5 = r1.cb(r5);
        r0 = r0.bai();
        r0 = r0.bdF();
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (kotlin.reflect.jvm.internal.impl.types.ap) r0;
        r0 = r0.bai();
        r5 = r5.M(r0);
        r5 = r5.bdx();
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ah) r5;
        r0 = r5;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.ac) r0;
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0.gE(r2);
    L_0x008d:
        return r5;
    L_0x008e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g.h(kotlin.reflect.jvm.internal.impl.descriptors.ah):kotlin.reflect.jvm.internal.impl.descriptors.ah");
    }

    private final ah a(ah ahVar, f fVar) {
        r.a bdr = ahVar.bdr();
        bdr.e(fVar);
        bdr.bds();
        bdr.bdt();
        r bdx = bdr.bdx();
        if (bdx == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return (ah) bdx;
    }

    private final boolean a(ah ahVar, r rVar) {
        Object rVar2;
        if (kotlin.reflect.jvm.internal.impl.load.java.b.eEK.c(ahVar)) {
            rVar2 = rVar2.bdk();
        }
        kotlin.jvm.internal.h.d(rVar2, "subDescriptorToCheck");
        return b((a) rVar2, (a) ahVar);
    }

    private final boolean b(a aVar, a aVar2) {
        OverrideCompatibilityInfo b = OverridingUtil.eQR.b(aVar2, aVar, true);
        kotlin.jvm.internal.h.d(b, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
        if (b.bww() != Result.OVERRIDABLE || j.eFe.a(aVar2, aVar)) {
            return false;
        }
        return true;
    }

    private final ah a(ad adVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        ae bdI = adVar.bdI();
        String str = null;
        bdI = bdI != null ? (ae) kotlin.reflect.jvm.internal.impl.load.java.q.q(bdI) : null;
        if (bdI != null) {
            str = kotlin.reflect.jvm.internal.impl.load.java.c.eEZ.o(bdI);
        }
        if (str != null && !kotlin.reflect.jvm.internal.impl.load.java.q.a(bgJ(), bdI)) {
            return a(adVar, str, (b) bVar);
        }
        String mm = l.mm(adVar.bdc().asString());
        kotlin.jvm.internal.h.d(mm, "JvmAbi.getterName(name.asString())");
        return a(adVar, mm, (b) bVar);
    }

    private final ah a(ad adVar, String str, b<? super f, ? extends Collection<? extends ah>> bVar) {
        ah ahVar;
        f mD = f.mD(str);
        kotlin.jvm.internal.h.d(mD, "Name.identifier(getterName)");
        Iterator it = ((Iterable) bVar.invoke(mD)).iterator();
        do {
            ahVar = null;
            if (!it.hasNext()) {
                break;
            }
            ah ahVar2 = (ah) it.next();
            if (ahVar2.bcS().size() == 0) {
                kotlin.reflect.jvm.internal.impl.types.checker.b bVar2 = kotlin.reflect.jvm.internal.impl.types.checker.b.eVr;
                w bcQ = ahVar2.bcQ();
                if (bcQ != null ? bVar2.c(bcQ, adVar.bai()) : false) {
                    ahVar = ahVar2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (ahVar == null);
        return ahVar;
    }

    private final ah b(ad adVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        ah ahVar;
        f mD = f.mD(l.mn(adVar.bdc().asString()));
        kotlin.jvm.internal.h.d(mD, "Name.identifier(JvmAbi.s…terName(name.asString()))");
        Iterator it = ((Iterable) bVar.invoke(mD)).iterator();
        do {
            ahVar = null;
            if (!it.hasNext()) {
                break;
            }
            ah ahVar2 = (ah) it.next();
            if (ahVar2.bcS().size() == 1) {
                w bcQ = ahVar2.bcQ();
                if (bcQ != null && kotlin.reflect.jvm.internal.impl.builtins.g.G(bcQ)) {
                    kotlin.reflect.jvm.internal.impl.types.checker.b bVar2 = kotlin.reflect.jvm.internal.impl.types.checker.b.eVr;
                    List bcS = ahVar2.bcS();
                    kotlin.jvm.internal.h.d(bcS, "descriptor.valueParameters");
                    Object bY = u.bY(bcS);
                    kotlin.jvm.internal.h.d(bY, "descriptor.valueParameters.single()");
                    if (bVar2.d(((aq) bY).bai(), adVar.bai())) {
                        ahVar = ahVar2;
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } while (ahVar == null);
        return ahVar;
    }

    private final boolean c(ad adVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        boolean z = false;
        if (c.f(adVar)) {
            return false;
        }
        ah a = a(adVar, (b) bVar);
        ah b = b(adVar, (b) bVar);
        if (a == null) {
            return false;
        }
        if (!adVar.bdW()) {
            return true;
        }
        if (b != null && b.bbG() == a.bbG()) {
            z = true;
        }
        return z;
    }

    protected void a(Collection<ah> collection, f fVar) {
        kotlin.jvm.internal.h.e(collection, "result");
        kotlin.jvm.internal.h.e(fVar, "name");
        Set w = w(fVar);
        if (!(kotlin.reflect.jvm.internal.impl.load.java.b.eEK.k(fVar) || BuiltinMethodsWithSpecialGenericSignature.eES.m(fVar))) {
            Object obj;
            Iterable<r> iterable = w;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (r bdq : iterable) {
                    if (bdq.bdq()) {
                        obj = null;
                        break;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                Collection arrayList = new ArrayList();
                for (Object next : iterable) {
                    if (d((ah) next)) {
                        arrayList.add(next);
                    }
                }
                a((Collection) collection, fVar, (Collection) (List) arrayList, false);
                return;
            }
        }
        i bzH = i.eXR.bzH();
        Collection a = kotlin.reflect.jvm.internal.impl.load.java.components.a.a(fVar, w, m.emptyList(), bgJ(), kotlin.reflect.jvm.internal.impl.serialization.deserialization.l.eTc);
        kotlin.jvm.internal.h.d(a, "mergedFunctionFromSuperTypes");
        g gVar = this;
        f fVar2 = fVar;
        Collection<ah> collection2 = collection;
        Collection collection3 = a;
        a(fVar2, collection2, collection3, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(gVar));
        a(fVar2, collection2, collection3, bzH, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(gVar));
        a = new ArrayList();
        for (Object next2 : w) {
            if (d((ah) next2)) {
                a.add(next2);
            }
        }
        a((Collection) collection, fVar, (Collection) u.b((Collection) (List) a, (Iterable) bzH), true);
    }

    private final void a(Collection<ah> collection, f fVar, Collection<? extends ah> collection2, boolean z) {
        Collection a = kotlin.reflect.jvm.internal.impl.load.java.components.a.a(fVar, collection2, collection, bgJ(), bgT().bgq().bfZ());
        if (z) {
            kotlin.jvm.internal.h.d(a, "additionalOverrides");
            Iterable<Object> iterable = a;
            List b = u.b((Collection) collection, (Iterable) iterable);
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (Object obj : iterable) {
                Object obj2;
                ah ahVar = (ah) kotlin.reflect.jvm.internal.impl.load.java.q.s((CallableMemberDescriptor) obj2);
                if (ahVar != null) {
                    kotlin.jvm.internal.h.d(obj2, "resolvedOverride");
                    obj2 = a((ah) obj2, (a) ahVar, (Collection) b);
                }
                arrayList.add(obj2);
            }
            collection.addAll((List) arrayList);
            return;
        }
        kotlin.jvm.internal.h.d(a, "additionalOverrides");
        collection.addAll(a);
    }

    private final void a(f fVar, Collection<? extends ah> collection, Collection<? extends ah> collection2, Collection<ah> collection3, b<? super f, ? extends Collection<? extends ah>> bVar) {
        for (ah ahVar : collection2) {
            kotlin.reflect.jvm.internal.impl.utils.a.j(collection3, a(ahVar, (b) bVar, fVar, (Collection) collection));
            kotlin.reflect.jvm.internal.impl.utils.a.j(collection3, a(ahVar, (b) bVar, (Collection) collection));
            kotlin.reflect.jvm.internal.impl.utils.a.j(collection3, a(ahVar, (b) bVar));
        }
    }

    private final ah a(ah ahVar, b<? super f, ? extends Collection<? extends ah>> bVar, Collection<? extends ah> collection) {
        r h = BuiltinMethodsWithSpecialGenericSignature.h(ahVar);
        ah ahVar2 = null;
        if (h == null) {
            return null;
        }
        ah a = a(h, (b) bVar);
        if (a != null) {
            if (!d(a)) {
                a = null;
            }
            if (a != null) {
                ahVar2 = a(a, (a) h, (Collection) collection);
            }
        }
        return ahVar2;
    }

    private final ah a(ah ahVar, b<? super f, ? extends Collection<? extends ah>> bVar, f fVar, Collection<? extends ah> collection) {
        ahVar = (ah) kotlin.reflect.jvm.internal.impl.load.java.q.q(ahVar);
        if (ahVar == null) {
            return null;
        }
        String t = kotlin.reflect.jvm.internal.impl.load.java.q.t(ahVar);
        if (t == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        f mD = f.mD(t);
        kotlin.jvm.internal.h.d(mD, "Name.identifier(nameInJava)");
        for (ah a : (Collection) bVar.invoke(mD)) {
            ah a2 = a(a2, fVar);
            if (a(ahVar, (r) a2)) {
                return a(a2, (a) ahVar, (Collection) collection);
            }
        }
        return null;
    }

    private final ah a(ah ahVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        if (!ahVar.bdq()) {
            return null;
        }
        ah h;
        f bdc = ahVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "descriptor.name");
        for (ah h2 : (Iterable) bVar.invoke(bdc)) {
            h2 = h(h2);
            if (h2 == null || !b((a) h2, (a) ahVar)) {
                h2 = null;
                continue;
            }
            if (h2 != null) {
                break;
            }
        }
        h2 = null;
        return h2;
    }

    private final ah a(ah ahVar, a aVar, Collection<? extends ah> collection) {
        Iterable<ah> iterable = collection;
        int i = 1;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (ah ahVar2 : iterable) {
                Object obj;
                if ((kotlin.jvm.internal.h.E(ahVar, ahVar2) ^ 1) != 0 && ahVar2.bdl() == null && b((a) ahVar2, aVar)) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    i = 0;
                    break;
                }
            }
        }
        if (i != 0) {
            return ahVar;
        }
        r bdx = ahVar.bdr().bdv().bdx();
        if (bdx == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return (ah) bdx;
    }

    private final ah a(r rVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        f bdc = rVar.bdc();
        kotlin.jvm.internal.h.d(bdc, "overridden.name");
        for (Object next : (Iterable) bVar.invoke(bdc)) {
            if (b((ah) next, rVar)) {
                break;
            }
        }
        Object next2 = null;
        ah ahVar = (ah) next2;
        if (ahVar == null) {
            return null;
        }
        r.a bdr = ahVar.bdr();
        List bcS = rVar.bcS();
        kotlin.jvm.internal.h.d(bcS, "overridden.valueParameters");
        Iterable<aq> iterable = bcS;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (aq aqVar : iterable) {
            kotlin.jvm.internal.h.d(aqVar, "it");
            w bai = aqVar.bai();
            kotlin.jvm.internal.h.d(bai, "it.type");
            arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.descriptors.i(bai, aqVar.bdR()));
        }
        arrayList = (List) arrayList;
        List bcS2 = ahVar.bcS();
        kotlin.jvm.internal.h.d(bcS2, "override.valueParameters");
        bdr.cb(kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.a(arrayList, bcS2, rVar));
        bdr.bds();
        bdr.bdt();
        return (ah) bdr.bdx();
    }

    private final Set<ah> w(f fVar) {
        an bby = bgJ().bby();
        kotlin.jvm.internal.h.d(bby, "ownerDescriptor.typeConstructor");
        Collection<w> beu = bby.beu();
        kotlin.jvm.internal.h.d(beu, "ownerDescriptor.typeConstructor.supertypes");
        Collection linkedHashSet = new LinkedHashSet();
        for (w bbk : beu) {
            r.a(linkedHashSet, (Iterable) bbk.bbk().b(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return (Set) linkedHashSet;
    }

    protected void b(f fVar, Collection<ad> collection) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(collection, "result");
        if (this.eHk.bhr()) {
            c(fVar, (Collection) collection);
        }
        Set x = x(fVar);
        if (!x.isEmpty()) {
            i bzH = i.eXR.bzH();
            a(x, (Collection) collection, (b) new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
            a(x, (Collection) bzH, (b) new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
            Collection a = kotlin.reflect.jvm.internal.impl.load.java.components.a.a(fVar, ak.a(x, bzH), collection, bgJ(), bgT().bgq().bfZ());
            kotlin.jvm.internal.h.d(a, "resolveOverridesForNonSt…rorReporter\n            )");
            collection.addAll(a);
        }
    }

    private final void a(Set<? extends ad> set, Collection<ad> collection, b<? super f, ? extends Collection<? extends ah>> bVar) {
        for (ad d : set) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.e d2 = d(d, (b) bVar);
            if (d2 != null) {
                collection.add(d2);
                return;
            }
        }
    }

    private final void c(f fVar, Collection<ad> collection) {
        q qVar = (q) u.R(((b) bgQ().invoke()).r(fVar));
        if (qVar != null) {
            collection.add(a(this, qVar, null, Modality.FINAL, 2, null));
        }
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a(q qVar, w wVar, Modality modality) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.a(bgJ(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(bgT(), qVar), modality, qVar.bbJ(), false, qVar.bdc(), bgT().bgq().bgc().a(qVar), false);
        z b = kotlin.reflect.jvm.internal.impl.resolve.b.b(a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel());
        a.a(b, null);
        if (wVar == null) {
            h bgT = bgT();
            kotlin.jvm.internal.h.d(a, "propertyDescriptor");
            wVar = a(qVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(bgT, (k) a, (x) qVar, 0, 4, null));
        }
        a.a(wVar, m.emptyList(), bcP(), (w) null);
        b.T(wVar);
        kotlin.jvm.internal.h.d(a, "propertyDescriptor");
        return a;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.e d(ad adVar, b<? super f, ? extends Collection<? extends ah>> bVar) {
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e eVar = null;
        if (!c(adVar, (b) bVar)) {
            return null;
        }
        ah b;
        ah a = a(adVar, (b) bVar);
        if (a == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        if (adVar.bdW()) {
            b = b(adVar, (b) bVar);
            if (b == null) {
                kotlin.jvm.internal.h.aXZ();
            }
        } else {
            b = null;
        }
        Object obj = (b == null || b.bbG() == a.bbG()) ? 1 : null;
        if (m.etY && obj == null) {
            Object bbG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Different accessors modalities when creating overrides for ");
            stringBuilder.append(adVar);
            stringBuilder.append(" in ");
            stringBuilder.append(bgJ());
            stringBuilder.append("for getter is ");
            stringBuilder.append(a.bbG());
            stringBuilder.append(", but for setter is ");
            if (b != null) {
                bbG = b.bbG();
            }
            stringBuilder.append(bbG);
            throw new AssertionError(stringBuilder.toString());
        }
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a2 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.a(bgJ(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), a.bbG(), a.bbJ(), b != null, adVar.bdc(), a.bbR(), false);
        w bcQ = a.bcQ();
        if (bcQ == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        a2.a(bcQ, m.emptyList(), bcP(), (w) null);
        ad adVar2 = a2;
        z b2 = kotlin.reflect.jvm.internal.impl.resolve.b.b(adVar2, a.bbQ(), false, false, false, a.bbR());
        b2.g(a);
        kotlin.jvm.internal.h.d(a2, "propertyDescriptor");
        b2.T(a2.bai());
        if (b != null) {
            eVar = kotlin.reflect.jvm.internal.impl.resolve.b.a(adVar2, b.bbQ(), false, false, false, b.bbJ(), b.bbR());
            eVar.g(b);
        }
        a2.a(b2, (af) eVar);
        return a2;
    }

    private final Set<ad> x(f fVar) {
        an bby = bgJ().bby();
        kotlin.jvm.internal.h.d(bby, "ownerDescriptor.typeConstructor");
        Collection<w> beu = bby.beu();
        kotlin.jvm.internal.h.d(beu, "ownerDescriptor.typeConstructor.supertypes");
        Collection arrayList = new ArrayList();
        for (w bbk : beu) {
            Iterable<ad> a = bbk.bbk().a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            Collection arrayList2 = new ArrayList(n.e(a, 10));
            for (ad add : a) {
                arrayList2.add(add);
            }
            r.a(arrayList, (Iterable) (List) arrayList2);
        }
        return u.Y((List) arrayList);
    }

    protected a a(q qVar, List<? extends kotlin.reflect.jvm.internal.impl.descriptors.an> list, w wVar, List<? extends aq> list2) {
        kotlin.jvm.internal.h.e(qVar, FirebaseAnalytics.b.METHOD);
        kotlin.jvm.internal.h.e(list, "methodTypeParameters");
        kotlin.jvm.internal.h.e(wVar, "returnType");
        kotlin.jvm.internal.h.e(list2, "valueParameters");
        kotlin.reflect.jvm.internal.impl.load.java.components.k.a a = bgT().bgq().bfY().a(qVar, bgJ(), wVar, null, list2, list);
        kotlin.jvm.internal.h.d(a, "propagated");
        w bcQ = a.bcQ();
        kotlin.jvm.internal.h.d(bcQ, "propagated.returnType");
        w bfS = a.bfS();
        List bcS = a.bcS();
        kotlin.jvm.internal.h.d(bcS, "propagated.valueParameters");
        List typeParameters = a.getTypeParameters();
        kotlin.jvm.internal.h.d(typeParameters, "propagated.typeParameters");
        boolean beF = a.beF();
        List errors = a.getErrors();
        kotlin.jvm.internal.h.d(errors, "propagated.errors");
        return new a(bcQ, bfS, bcS, typeParameters, beF, errors);
    }

    private final boolean b(ah ahVar, r rVar) {
        String a = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(ahVar, false, false, 2, null);
        r bdk = rVar.bdk();
        kotlin.jvm.internal.h.d(bdk, "builtinWithErasedParameters.original");
        return kotlin.jvm.internal.h.E(a, kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(bdk, false, false, 2, null)) && !b((a) ahVar, (a) rVar);
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.descriptors.c a(kotlin.reflect.jvm.internal.impl.load.java.structure.k kVar) {
        d bgI = bgJ();
        kotlin.reflect.jvm.internal.impl.load.java.structure.l lVar = kVar;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.c b = kotlin.reflect.jvm.internal.impl.load.java.descriptors.c.b(bgI, kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(bgT(), kVar), false, bgT().bgq().bgc().a(lVar));
        h bgT = bgT();
        kotlin.jvm.internal.h.d(b, "constructorDescriptor");
        bgT = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(bgT, (k) b, (x) kVar, bgI.bbS().size());
        b a = a(bgT, (r) b, kVar.bcS());
        List bbS = bgI.bbS();
        kotlin.jvm.internal.h.d(bbS, "classDescriptor.declaredTypeParameters");
        Collection collection = bbS;
        Iterable<kotlin.reflect.jvm.internal.impl.load.java.structure.w> typeParameters = kVar.getTypeParameters();
        Collection arrayList = new ArrayList(n.e(typeParameters, 10));
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.w a2 : typeParameters) {
            kotlin.reflect.jvm.internal.impl.descriptors.an a3 = bgT.bgr().a(a2);
            if (a3 == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            arrayList.add(a3);
        }
        b.a(a.getDescriptors(), kVar.bbJ(), u.b(collection, (Iterable) (List) arrayList));
        b.gF(false);
        b.gG(a.bgV());
        b.Q((w) bgI.bdb());
        bgT.bgq().bga().a(lVar, (kotlin.reflect.jvm.internal.impl.descriptors.j) b);
        return b;
    }

    private final c bgH() {
        boolean bhr = this.eHk.bhr();
        if (this.eHk.isInterface() && !bhr) {
            return null;
        }
        List a;
        d bgI = bgJ();
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.c b = kotlin.reflect.jvm.internal.impl.load.java.descriptors.c.b(bgI, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), true, bgT().bgq().bgc().a(this.eHk));
        if (bhr) {
            kotlin.jvm.internal.h.d(b, "constructorDescriptor");
            a = a((kotlin.reflect.jvm.internal.impl.descriptors.impl.f) b);
        } else {
            a = Collections.emptyList();
        }
        b.gG(false);
        b.a(a, A(bgI));
        b.gF(true);
        kotlin.jvm.internal.h.d(b, "constructorDescriptor");
        b.Q((w) bgI.bdb());
        bgT().bgq().bga().a((kotlin.reflect.jvm.internal.impl.load.java.structure.l) this.eHk, (kotlin.reflect.jvm.internal.impl.descriptors.j) b);
        return b;
    }

    private final av A(d dVar) {
        av bbJ = dVar.bbJ();
        if (kotlin.jvm.internal.h.E(bbJ, kotlin.reflect.jvm.internal.impl.load.java.k.eFg)) {
            bbJ = kotlin.reflect.jvm.internal.impl.load.java.k.eFh;
            kotlin.jvm.internal.h.d(bbJ, "JavaVisibilities.PROTECTED_AND_PACKAGE");
            return bbJ;
        }
        kotlin.jvm.internal.h.d(bbJ, "visibility");
        return bbJ;
    }

    private final List<aq> a(kotlin.reflect.jvm.internal.impl.descriptors.impl.f fVar) {
        Collection bht = this.eHk.bht();
        ArrayList arrayList = new ArrayList(bht.size());
        kotlin.reflect.jvm.internal.impl.load.java.lazy.types.a a = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.a(TypeUsage.COMMON, true, null, 2, null);
        Iterable iterable = bht;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : iterable) {
            if (kotlin.jvm.internal.h.E(((q) next).bdc(), kotlin.reflect.jvm.internal.impl.load.java.m.eFm)) {
                arrayList2.add(next);
            } else {
                arrayList3.add(next);
            }
        }
        Pair pair = new Pair(arrayList2, arrayList3);
        List list = (List) pair.aXG();
        List<q> list2 = (List) pair.aXH();
        int i = 0;
        Object obj = list.size() <= 1 ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("There can't be more than one method named 'value' in annotation class: ");
            stringBuilder.append(this.eHk);
            throw new AssertionError(stringBuilder.toString());
        }
        q qVar = (q) u.bV(list);
        if (qVar != null) {
            Pair pair2;
            v bhG = qVar.bhG();
            if (bhG instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.f) {
                kotlin.reflect.jvm.internal.impl.load.java.structure.f fVar2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.f) bhG;
                pair2 = new Pair(bgT().bgp().a(fVar2, a, true), bgT().bgp().a(fVar2.bho(), a));
            } else {
                pair2 = new Pair(bgT().bgp().a(bhG, a), null);
            }
            a((List) arrayList, (kotlin.reflect.jvm.internal.impl.descriptors.j) fVar, 0, qVar, (w) pair2.aXG(), (w) pair2.aXH());
        }
        int i2 = qVar != null ? 1 : 0;
        for (q qVar2 : list2) {
            a((List) arrayList, (kotlin.reflect.jvm.internal.impl.descriptors.j) fVar, i + i2, qVar2, bgT().bgp().a(qVar2.bhG(), a), null);
            i++;
        }
        return arrayList;
    }

    private final void a(List<aq> list, kotlin.reflect.jvm.internal.impl.descriptors.j jVar, int i, q qVar, w wVar, w wVar2) {
        a aVar = jVar;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bel = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
        f bdc = qVar.bdc();
        w aU = au.aU(wVar);
        kotlin.jvm.internal.h.d(aU, "TypeUtils.makeNotNullable(returnType)");
        list.add(new kotlin.reflect.jvm.internal.impl.descriptors.impl.ah(aVar, null, i, bel, bdc, aU, qVar.bhH(), false, false, wVar2 != null ? au.aU(wVar2) : null, bgT().bgq().bgc().a(qVar)));
    }

    protected ag bcP() {
        return kotlin.reflect.jvm.internal.impl.resolve.c.t(bgJ());
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        return (kotlin.reflect.jvm.internal.impl.descriptors.f) this.eHF.invoke(fVar);
    }

    public Collection<ah> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        return super.b(fVar, bVar);
    }

    public Collection<ad> a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        return super.a(fVar, bVar);
    }

    protected Set<f> d(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, b<? super f, Boolean> bVar) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        return ak.a((Set) this.eHD.invoke(), ((Map) this.eHE.invoke()).keySet());
    }

    protected Set<f> e(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, b<? super f, Boolean> bVar) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        if (this.eHk.bhr()) {
            return beC();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((b) bgQ().invoke()).bgw());
        an bby = bgJ().bby();
        kotlin.jvm.internal.h.d(bby, "ownerDescriptor.typeConstructor");
        Collection<w> beu = bby.beu();
        kotlin.jvm.internal.h.d(beu, "ownerDescriptor.typeConstructor.supertypes");
        for (w bbk : beu) {
            r.a((Collection) linkedHashSet, (Iterable) bbk.bbk().beD());
        }
        return linkedHashSet;
    }

    public void d(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        kotlin.reflect.jvm.internal.impl.incremental.a.a(bgT().bgq().bgf(), bVar, bgJ(), fVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java member scope for ");
        stringBuilder.append(this.eHk.bdD());
        return stringBuilder.toString();
    }
}
