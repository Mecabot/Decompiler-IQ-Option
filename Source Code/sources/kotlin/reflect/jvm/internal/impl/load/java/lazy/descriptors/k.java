package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.as;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.load.java.structure.x;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.i;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: LazyJavaScope.kt */
public abstract class k extends i {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    private final kotlin.reflect.jvm.internal.impl.storage.b<f, List<ad>> eCA = this.eGT.baI().o(new LazyJavaScope$properties$1(this));
    private final e<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> eCB = this.eGT.baI().a(new LazyJavaScope$allDescriptors$1(this), m.emptyList());
    private final kotlin.reflect.jvm.internal.impl.storage.b<f, Collection<ah>> eCz = this.eGT.baI().o(new LazyJavaScope$functions$1(this));
    private final h eGT;
    private final e<b> eHT = this.eGT.baI().i(new LazyJavaScope$declaredMemberIndex$1(this));
    private final e eHU = this.eGT.baI().i(new LazyJavaScope$functionNamesLazy$2(this));
    private final e eHV = this.eGT.baI().i(new LazyJavaScope$propertyNamesLazy$2(this));
    private final e eHW = this.eGT.baI().i(new LazyJavaScope$classNamesLazy$2(this));

    /* compiled from: LazyJavaScope.kt */
    protected static final class a {
        private final List<an> eAR;
        private final boolean eCT;
        private final w eDY;
        private final w eGn;
        private final List<aq> eGo;
        private final List<String> errors;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (kotlin.jvm.internal.h.E(this.eDY, aVar.eDY) && kotlin.jvm.internal.h.E(this.eGn, aVar.eGn) && kotlin.jvm.internal.h.E(this.eGo, aVar.eGo) && kotlin.jvm.internal.h.E(this.eAR, aVar.eAR)) {
                    return (this.eCT == aVar.eCT ? 1 : null) != null && kotlin.jvm.internal.h.E(this.errors, aVar.errors);
                }
            }
        }

        public int hashCode() {
            w wVar = this.eDY;
            int i = 0;
            int hashCode = (wVar != null ? wVar.hashCode() : 0) * 31;
            w wVar2 = this.eGn;
            hashCode = (hashCode + (wVar2 != null ? wVar2.hashCode() : 0)) * 31;
            List list = this.eGo;
            hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            list = this.eAR;
            hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            int i2 = this.eCT;
            if (i2 != 0) {
                i2 = 1;
            }
            hashCode = (hashCode + i2) * 31;
            list = this.errors;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MethodSignatureData(returnType=");
            stringBuilder.append(this.eDY);
            stringBuilder.append(", receiverType=");
            stringBuilder.append(this.eGn);
            stringBuilder.append(", valueParameters=");
            stringBuilder.append(this.eGo);
            stringBuilder.append(", typeParameters=");
            stringBuilder.append(this.eAR);
            stringBuilder.append(", hasStableParameterNames=");
            stringBuilder.append(this.eCT);
            stringBuilder.append(", errors=");
            stringBuilder.append(this.errors);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(w wVar, w wVar2, List<? extends aq> list, List<? extends an> list2, boolean z, List<String> list3) {
            kotlin.jvm.internal.h.e(wVar, "returnType");
            kotlin.jvm.internal.h.e(list, "valueParameters");
            kotlin.jvm.internal.h.e(list2, "typeParameters");
            kotlin.jvm.internal.h.e(list3, "errors");
            this.eDY = wVar;
            this.eGn = wVar2;
            this.eGo = list;
            this.eAR = list2;
            this.eCT = z;
            this.errors = list3;
        }

        public final w bcQ() {
            return this.eDY;
        }

        public final w bfS() {
            return this.eGn;
        }

        public final List<aq> bcS() {
            return this.eGo;
        }

        public final List<an> getTypeParameters() {
            return this.eAR;
        }

        public final boolean bgU() {
            return this.eCT;
        }

        public final List<String> getErrors() {
            return this.errors;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class b {
        private final List<aq> eHX;
        private final boolean eHY;

        public b(List<? extends aq> list, boolean z) {
            kotlin.jvm.internal.h.e(list, "descriptors");
            this.eHX = list;
            this.eHY = z;
        }

        public final boolean bgV() {
            return this.eHY;
        }

        public final List<aq> getDescriptors() {
            return this.eHX;
        }
    }

    private final Set<f> bgR() {
        return (Set) g.a(this.eHU, (Object) this, apP[0]);
    }

    private final Set<f> bgS() {
        return (Set) g.a(this.eHV, (Object) this, apP[1]);
    }

    protected abstract a a(q qVar, List<? extends an> list, w wVar, List<? extends aq> list2);

    protected abstract void a(Collection<ah> collection, f fVar);

    protected boolean a(JavaMethodDescriptor javaMethodDescriptor) {
        kotlin.jvm.internal.h.e(javaMethodDescriptor, "$receiver");
        return true;
    }

    protected abstract void b(f fVar, Collection<ad> collection);

    protected abstract ag bcP();

    protected abstract b bgF();

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.k bgJ();

    protected abstract Set<f> c(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar);

    protected abstract Set<f> d(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar);

    protected abstract Set<f> e(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar);

    public k(h hVar) {
        kotlin.jvm.internal.h.e(hVar, "c");
        this.eGT = hVar;
    }

    protected final h bgT() {
        return this.eGT;
    }

    protected final e<b> bgQ() {
        return this.eHT;
    }

    protected final JavaMethodDescriptor c(q qVar) {
        Map h;
        kotlin.jvm.internal.h.e(qVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        JavaMethodDescriptor a = JavaMethodDescriptor.a(bgJ(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.eGT, qVar), qVar.bdc(), this.eGT.bgq().bgc().a(qVar));
        h hVar = this.eGT;
        kotlin.jvm.internal.h.d(a, "functionDescriptorImpl");
        hVar = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(hVar, (kotlin.reflect.jvm.internal.impl.descriptors.k) a, (x) qVar, 0, 4, null);
        Iterable<kotlin.reflect.jvm.internal.impl.load.java.structure.w> typeParameters = qVar.getTypeParameters();
        Collection arrayList = new ArrayList(n.e(typeParameters, 10));
        for (kotlin.reflect.jvm.internal.impl.load.java.structure.w a2 : typeParameters) {
            an a3 = hVar.bgr().a(a2);
            if (a3 == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            arrayList.add(a3);
        }
        List list = (List) arrayList;
        b a4 = a(hVar, (r) a, qVar.bcS());
        a a5 = a(qVar, list, a(qVar, hVar), a4.getDescriptors());
        w bfS = a5.bfS();
        ag bcP = bcP();
        List typeParameters2 = a5.getTypeParameters();
        List bcS = a5.bcS();
        w bcQ = a5.bcQ();
        Modality n = Modality.Companion.n(qVar.isAbstract(), qVar.isFinal() ^ 1);
        av bbJ = qVar.bbJ();
        if (a5.bfS() != null) {
            h = ac.h(kotlin.j.D(JavaMethodDescriptor.eGs, u.bU(a4.getDescriptors())));
        } else {
            h = ad.emptyMap();
        }
        a.a(bfS, bcP, typeParameters2, bcS, bcQ, n, bbJ, h);
        a.o(a5.bgU(), a4.bgV());
        if ((a5.getErrors().isEmpty() ^ 1) != 0) {
            hVar.bgq().bfY().a(a, a5.getErrors());
        }
        return a;
    }

    protected final w a(q qVar, h hVar) {
        kotlin.jvm.internal.h.e(qVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        kotlin.jvm.internal.h.e(hVar, "c");
        return hVar.bgp().a(qVar.bhG(), c.a(TypeUsage.COMMON, qVar.bhF().bhr(), null, 2, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013b  */
    protected final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.k.b a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h r23, kotlin.reflect.jvm.internal.impl.descriptors.r r24, java.util.List<? extends kotlin.reflect.jvm.internal.impl.load.java.structure.y> r25) {
        /*
        r22 = this;
        r0 = r23;
        r1 = r24;
        r2 = r25;
        r3 = "c";
        kotlin.jvm.internal.h.e(r0, r3);
        r3 = "function";
        kotlin.jvm.internal.h.e(r1, r3);
        r3 = "jValueParameters";
        kotlin.jvm.internal.h.e(r2, r3);
        r3 = new java.util.LinkedHashSet;
        r3.<init>();
        r3 = (java.util.Set) r3;
        r4 = r2;
        r4 = (java.lang.Iterable) r4;
        r4 = kotlin.collections.u.Z(r4);
        r5 = new java.util.ArrayList;
        r6 = 10;
        r6 = kotlin.collections.n.e(r4, r6);
        r5.<init>(r6);
        r5 = (java.util.Collection) r5;
        r4 = r4.iterator();
        r6 = 0;
        r7 = 0;
    L_0x0036:
        r8 = r4.hasNext();
        if (r8 == 0) goto L_0x0182;
    L_0x003c:
        r8 = r4.next();
        r8 = (kotlin.collections.w) r8;
        r12 = r8.component1();
        r8 = r8.aXH();
        r8 = (kotlin.reflect.jvm.internal.impl.load.java.structure.y) r8;
        r9 = r8;
        r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.d) r9;
        r13 = kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(r0, r9);
        r9 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON;
        r10 = 3;
        r11 = 0;
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c.a(r9, r6, r11, r10, r11);
        r10 = kotlin.reflect.jvm.internal.impl.load.java.m.eFw;
        r14 = "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME";
        kotlin.jvm.internal.h.d(r10, r14);
        r10 = r13.j(r10);
        if (r10 == 0) goto L_0x007e;
    L_0x0068:
        r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(r10);
        if (r10 == 0) goto L_0x007e;
    L_0x006e:
        r14 = r10 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.s;
        if (r14 != 0) goto L_0x0073;
    L_0x0072:
        r10 = r11;
    L_0x0073:
        r10 = (kotlin.reflect.jvm.internal.impl.resolve.constants.s) r10;
        if (r10 == 0) goto L_0x007e;
    L_0x0077:
        r10 = r10.getValue();
        r10 = (java.lang.String) r10;
        goto L_0x007f;
    L_0x007e:
        r10 = r11;
    L_0x007f:
        r14 = r8.bhL();
        r15 = 1;
        if (r14 == 0) goto L_0x00c6;
    L_0x0086:
        r14 = r8.bhD();
        r6 = r14 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.f;
        if (r6 != 0) goto L_0x008f;
    L_0x008e:
        goto L_0x0090;
    L_0x008f:
        r11 = r14;
    L_0x0090:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.f) r11;
        if (r11 == 0) goto L_0x00ad;
    L_0x0094:
        r6 = r23.bgp();
        r6 = r6.a(r11, r9, r15);
        r9 = r23.bar();
        r9 = r9.bdy();
        r9 = r9.l(r6);
        r6 = kotlin.j.D(r6, r9);
        goto L_0x00d6;
    L_0x00ad:
        r0 = new java.lang.AssertionError;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Vararg parameter should be an array: ";
        r1.append(r2);
        r1.append(r8);
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x00c6:
        r6 = r23.bgp();
        r14 = r8.bhD();
        r6 = r6.a(r14, r9);
        r6 = kotlin.j.D(r6, r11);
    L_0x00d6:
        r9 = r6.aXG();
        r14 = r9;
        r14 = (kotlin.reflect.jvm.internal.impl.types.w) r14;
        r6 = r6.aXH();
        r19 = r6;
        r19 = (kotlin.reflect.jvm.internal.impl.types.w) r19;
        r6 = r24.bdc();
        r6 = r6.asString();
        r9 = "equals";
        r6 = kotlin.jvm.internal.h.E(r6, r9);
        if (r6 == 0) goto L_0x0114;
    L_0x00f5:
        r6 = r25.size();
        if (r6 != r15) goto L_0x0114;
    L_0x00fb:
        r6 = r23.bar();
        r6 = r6.bdy();
        r6 = r6.baV();
        r6 = kotlin.jvm.internal.h.E(r6, r14);
        if (r6 == 0) goto L_0x0114;
    L_0x010d:
        r6 = "other";
        r6 = kotlin.reflect.jvm.internal.impl.name.f.mD(r6);
        goto L_0x0151;
    L_0x0114:
        if (r10 == 0) goto L_0x012f;
    L_0x0116:
        r6 = r10;
        r6 = (java.lang.CharSequence) r6;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0121;
    L_0x011f:
        r6 = 1;
        goto L_0x0122;
    L_0x0121:
        r6 = 0;
    L_0x0122:
        if (r6 == 0) goto L_0x012f;
    L_0x0124:
        r6 = r3.add(r10);
        if (r6 == 0) goto L_0x012f;
    L_0x012a:
        r6 = kotlin.reflect.jvm.internal.impl.name.f.mD(r10);
        goto L_0x0151;
    L_0x012f:
        r6 = r8.bdc();
        if (r6 != 0) goto L_0x0136;
    L_0x0135:
        goto L_0x0137;
    L_0x0136:
        r15 = r7;
    L_0x0137:
        if (r6 == 0) goto L_0x013b;
    L_0x0139:
        r7 = r15;
        goto L_0x0151;
    L_0x013b:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r6.append(r7);
        r6.append(r12);
        r6 = r6.toString();
        r6 = kotlin.reflect.jvm.internal.impl.name.f.mD(r6);
        goto L_0x0139;
    L_0x0151:
        r15 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ah;
        r10 = r1;
        r10 = (kotlin.reflect.jvm.internal.impl.descriptors.a) r10;
        r11 = 0;
        r9 = "name";
        kotlin.jvm.internal.h.d(r6, r9);
        r16 = 0;
        r17 = 0;
        r18 = 0;
        r9 = r23.bgq();
        r9 = r9.bgc();
        r8 = (kotlin.reflect.jvm.internal.impl.load.java.structure.l) r8;
        r8 = r9.a(r8);
        r20 = r8;
        r20 = (kotlin.reflect.jvm.internal.impl.descriptors.ai) r20;
        r9 = r15;
        r8 = r14;
        r14 = r6;
        r6 = r15;
        r15 = r8;
        r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        r5.add(r6);
        r6 = 0;
        goto L_0x0036;
    L_0x0182:
        r5 = (java.util.List) r5;
        r5 = (java.lang.Iterable) r5;
        r0 = kotlin.collections.u.W(r5);
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.k$b;
        r1.<init>(r0, r7);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.k.a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h, kotlin.reflect.jvm.internal.impl.descriptors.r, java.util.List):kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.k$b");
    }

    public Set<f> beC() {
        return bgR();
    }

    public Set<f> beD() {
        return bgS();
    }

    public Collection<ah> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        if (beC().contains(fVar)) {
            return (Collection) this.eCz.invoke(fVar);
        }
        return m.emptyList();
    }

    private final ad a(n nVar) {
        y b = b(nVar);
        b.a(null, null);
        b.a(d(nVar), m.emptyList(), bcP(), (w) null);
        if (kotlin.reflect.jvm.internal.impl.resolve.c.a((as) b, b.bai())) {
            b.a(this.eGT.baI().j(new LazyJavaScope$resolveProperty$1(this, nVar, b)));
        }
        ad adVar = b;
        this.eGT.bgq().bga().c(nVar, adVar);
        return adVar;
    }

    private final y b(n nVar) {
        boolean isFinal = nVar.isFinal() ^ 1;
        kotlin.reflect.jvm.internal.impl.load.java.descriptors.e a = kotlin.reflect.jvm.internal.impl.load.java.descriptors.e.a(bgJ(), kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.eGT, nVar), Modality.FINAL, nVar.bbJ(), isFinal, nVar.bdc(), this.eGT.bgq().bgc().a(nVar), c(nVar));
        kotlin.jvm.internal.h.d(a, "JavaPropertyDescriptor.c…d.isFinalStatic\n        )");
        return a;
    }

    private final boolean c(n nVar) {
        return nVar.isFinal() && nVar.isStatic();
    }

    private final w d(n nVar) {
        boolean z = false;
        w a = this.eGT.bgp().a(nVar.bhD(), c.a(TypeUsage.COMMON, false, null, 3, null));
        if ((kotlin.reflect.jvm.internal.impl.builtins.g.p(a) || kotlin.reflect.jvm.internal.impl.builtins.g.H(a)) && c(nVar) && nVar.bhE()) {
            z = true;
        }
        if (!z) {
            return a;
        }
        w aU = au.aU(a);
        kotlin.jvm.internal.h.d(aU, "TypeUtils.makeNotNullable(propertyType)");
        return aU;
    }

    public Collection<ad> a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        if (beD().contains(fVar)) {
            return (Collection) this.eCA.invoke(fVar);
        }
        return m.emptyList();
    }

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        kotlin.jvm.internal.h.e(bVar, "nameFilter");
        return (Collection) this.eCB.invoke();
    }

    protected final List<kotlin.reflect.jvm.internal.impl.descriptors.k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar2) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        kotlin.jvm.internal.h.e(bVar, "nameFilter");
        kotlin.jvm.internal.h.e(bVar2, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (dVar.lR(d.eSd.bxf())) {
            for (f fVar : d(dVar, bVar)) {
                if (((Boolean) bVar.invoke(fVar)).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.j(linkedHashSet, c(fVar, bVar2));
                }
            }
        }
        if (dVar.lR(d.eSd.bxc()) && !dVar.bwO().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.c.a.eRC)) {
            for (f fVar2 : c(dVar, bVar)) {
                if (((Boolean) bVar.invoke(fVar2)).booleanValue()) {
                    linkedHashSet.addAll(b(fVar2, bVar2));
                }
            }
        }
        if (dVar.lR(d.eSd.bxd()) && !dVar.bwO().contains(kotlin.reflect.jvm.internal.impl.resolve.scopes.c.a.eRC)) {
            for (f fVar3 : e(dVar, bVar)) {
                if (((Boolean) bVar.invoke(fVar3)).booleanValue()) {
                    linkedHashSet.addAll(a(fVar3, bVar2));
                }
            }
        }
        return u.W(linkedHashSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy scope for ");
        stringBuilder.append(bgJ());
        return stringBuilder.toString();
    }
}
