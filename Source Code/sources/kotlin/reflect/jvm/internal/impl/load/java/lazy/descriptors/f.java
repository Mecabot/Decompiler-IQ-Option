package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.c;
import kotlin.reflect.jvm.internal.impl.load.java.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.j;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.x;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class f extends g implements d {
    public static final a eHA = new a();
    private static final Set<String> eHz = aj.I("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");
    private final boolean eAT;
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g eBt;
    private final av eCK;
    private final Modality eCr;
    private final ClassKind eCs;
    private final h eGT;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.g eHk;
    private final b eHt;
    private final g eHu;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.f eHv;
    private final l eHw;
    private final e<List<an>> eHx;
    private final kotlin.reflect.jvm.internal.impl.descriptors.d eHy;

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    private final class b extends kotlin.reflect.jvm.internal.impl.types.b {
        private final e<List<an>> eHB;

        public boolean bbY() {
            return true;
        }

        public b() {
            super(f.this.eGT.baI());
            this.eHB = f.this.eGT.baI().i(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(this));
        }

        public List<an> getParameters() {
            return (List) this.eHB.invoke();
        }

        protected Collection<w> bbU() {
            Object obj;
            Collection beu = f.this.eHk.beu();
            ArrayList arrayList = new ArrayList(beu.size());
            ArrayList arrayList2 = new ArrayList(0);
            w bgC = bgC();
            Iterator it = beu.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                j jVar = (j) it.next();
                w a = f.this.eGT.bgp().a((v) jVar, c.a(TypeUsage.SUPERTYPE, false, null, 3, null));
                if (a.bwA().bbW() instanceof kotlin.reflect.jvm.internal.impl.descriptors.w.b) {
                    arrayList2.add(jVar);
                }
                kotlin.reflect.jvm.internal.impl.types.an bwA = a.bwA();
                if (bgC != null) {
                    obj = bgC.bwA();
                }
                if (!kotlin.jvm.internal.h.E(bwA, obj)) {
                    if (!kotlin.reflect.jvm.internal.impl.builtins.g.D(a)) {
                        arrayList.add(a);
                    }
                }
            }
            beu = arrayList;
            kotlin.reflect.jvm.internal.impl.descriptors.d c = f.this.eHy;
            if (c != null) {
                obj = kotlin.reflect.jvm.internal.impl.builtins.jvm.g.a(c, f.this).bzh().c(c.bdb(), Variance.INVARIANT);
            }
            kotlin.reflect.jvm.internal.impl.utils.a.j(beu, obj);
            kotlin.reflect.jvm.internal.impl.utils.a.j(beu, bgC);
            if ((arrayList2.isEmpty() ^ 1) != 0) {
                l bfZ = f.this.eGT.bgq().bfZ();
                kotlin.reflect.jvm.internal.impl.descriptors.d bbX = bbW();
                Iterable<v> iterable = arrayList2;
                Collection arrayList3 = new ArrayList(n.e(iterable, 10));
                for (v vVar : iterable) {
                    if (vVar == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    }
                    arrayList3.add(((j) vVar).bhz());
                }
                bfZ.a(bbX, (List) arrayList3);
            }
            return (beu.isEmpty() ^ 1) != 0 ? u.W(arrayList) : l.cr(f.this.eGT.bar().bdy().baU());
        }

        /* JADX WARNING: Missing block: B:8:0x0019, code:
            if (r3 != null) goto L_0x001d;
     */
        private final kotlin.reflect.jvm.internal.impl.types.w bgC() {
            /*
            r8 = this;
            r0 = r8.bgD();
            r1 = 1;
            r2 = 0;
            if (r0 == 0) goto L_0x001c;
        L_0x0008:
            r3 = r0.isRoot();
            if (r3 != 0) goto L_0x0018;
        L_0x000e:
            r3 = kotlin.reflect.jvm.internal.impl.builtins.g.exo;
            r3 = r0.D(r3);
            if (r3 == 0) goto L_0x0018;
        L_0x0016:
            r3 = 1;
            goto L_0x0019;
        L_0x0018:
            r3 = 0;
        L_0x0019:
            if (r3 == 0) goto L_0x001c;
        L_0x001b:
            goto L_0x001d;
        L_0x001c:
            r0 = r2;
        L_0x001d:
            if (r0 == 0) goto L_0x0021;
        L_0x001f:
            r3 = r0;
            goto L_0x002d;
        L_0x0021:
            r3 = kotlin.reflect.jvm.internal.impl.load.java.f.eFc;
            r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.this;
            r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(r4);
            r3 = r3.n(r4);
        L_0x002d:
            if (r3 == 0) goto L_0x00fc;
        L_0x002f:
            r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.this;
            r4 = r4.eGT;
            r4 = r4.bar();
            r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER;
            r5 = (kotlin.reflect.jvm.internal.impl.incremental.components.b) r5;
            r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(r4, r3, r5);
            if (r3 == 0) goto L_0x00fb;
        L_0x0043:
            r4 = r3.bby();
            r5 = "classDescriptor.typeConstructor";
            kotlin.jvm.internal.h.d(r4, r5);
            r4 = r4.getParameters();
            r4 = r4.size();
            r5 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.this;
            r5 = r5.bby();
            r5 = r5.getParameters();
            r6 = r5.size();
            r7 = 10;
            if (r6 != r4) goto L_0x00a1;
        L_0x0066:
            r0 = "typeParameters";
            kotlin.jvm.internal.h.d(r5, r0);
            r5 = (java.lang.Iterable) r5;
            r0 = new java.util.ArrayList;
            r1 = kotlin.collections.n.e(r5, r7);
            r0.<init>(r1);
            r0 = (java.util.Collection) r0;
            r1 = r5.iterator();
        L_0x007c:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x009e;
        L_0x0082:
            r2 = r1.next();
            r2 = (kotlin.reflect.jvm.internal.impl.descriptors.an) r2;
            r4 = new kotlin.reflect.jvm.internal.impl.types.ar;
            r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
            r6 = "parameter";
            kotlin.jvm.internal.h.d(r2, r6);
            r2 = r2.bdb();
            r2 = (kotlin.reflect.jvm.internal.impl.types.w) r2;
            r4.<init>(r5, r2);
            r0.add(r4);
            goto L_0x007c;
        L_0x009e:
            r0 = (java.util.List) r0;
            goto L_0x00ed;
        L_0x00a1:
            if (r6 != r1) goto L_0x00fa;
        L_0x00a3:
            if (r4 <= r1) goto L_0x00fa;
        L_0x00a5:
            if (r0 != 0) goto L_0x00fa;
        L_0x00a7:
            r0 = new kotlin.reflect.jvm.internal.impl.types.ar;
            r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT;
            r6 = "typeParameters";
            kotlin.jvm.internal.h.d(r5, r6);
            r5 = kotlin.collections.u.bY(r5);
            r6 = "typeParameters.single()";
            kotlin.jvm.internal.h.d(r5, r6);
            r5 = (kotlin.reflect.jvm.internal.impl.descriptors.an) r5;
            r5 = r5.bdb();
            r5 = (kotlin.reflect.jvm.internal.impl.types.w) r5;
            r0.<init>(r2, r5);
            r2 = new kotlin.f.f;
            r2.<init>(r1, r4);
            r2 = (java.lang.Iterable) r2;
            r1 = new java.util.ArrayList;
            r4 = kotlin.collections.n.e(r2, r7);
            r1.<init>(r4);
            r1 = (java.util.Collection) r1;
            r2 = r2.iterator();
        L_0x00da:
            r4 = r2.hasNext();
            if (r4 == 0) goto L_0x00ea;
        L_0x00e0:
            r4 = r2;
            r4 = (kotlin.collections.z) r4;
            r4.nextInt();
            r1.add(r0);
            goto L_0x00da;
        L_0x00ea:
            r0 = r1;
            r0 = (java.util.List) r0;
        L_0x00ed:
            r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF;
            r1 = r1.bel();
            r0 = kotlin.reflect.jvm.internal.impl.types.x.a(r1, r3, r0);
            r0 = (kotlin.reflect.jvm.internal.impl.types.w) r0;
            return r0;
        L_0x00fa:
            return r2;
        L_0x00fb:
            return r2;
        L_0x00fc:
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f.b.bgC():kotlin.reflect.jvm.internal.impl.types.w");
        }

        private final kotlin.reflect.jvm.internal.impl.name.b bgD() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ = f.this.bbQ();
            kotlin.reflect.jvm.internal.impl.name.b bVar = m.eFt;
            kotlin.jvm.internal.h.d(bVar, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j = bbQ.j(bVar);
            if (j == null) {
                return null;
            }
            Object R = u.R(j.bee().values());
            if (!(R instanceof s)) {
                R = null;
            }
            s sVar = (s) R;
            if (sVar != null) {
                String str = (String) sVar.getValue();
                if (str == null || !kotlin.reflect.jvm.internal.impl.name.d.mC(str)) {
                    return null;
                }
                return new kotlin.reflect.jvm.internal.impl.name.b(str);
            }
            return null;
        }

        protected al bbZ() {
            return f.this.eGT.bgq().bbZ();
        }

        /* renamed from: bbX */
        public kotlin.reflect.jvm.internal.impl.descriptors.d bbW() {
            return f.this;
        }

        public String toString() {
            String asString = f.this.bdc().asString();
            kotlin.jvm.internal.h.d(asString, "name.asString()");
            return asString;
        }
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d bbC() {
        return null;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.c bbI() {
        return null;
    }

    public boolean bbK() {
        return false;
    }

    public boolean bbM() {
        return false;
    }

    public boolean bbN() {
        return false;
    }

    public boolean bbO() {
        return false;
    }

    public boolean bbP() {
        return false;
    }

    public /* synthetic */ f(h hVar, k kVar, kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar, int i, f fVar) {
        if ((i & 8) != 0) {
            dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) null;
        }
        this(hVar, kVar, gVar, dVar);
    }

    public f(h hVar, k kVar, kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar2 = gVar;
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "outerContext");
        k kVar2 = kVar;
        kotlin.jvm.internal.h.e(kVar2, "containingDeclaration");
        kotlin.jvm.internal.h.e(gVar2, "jClass");
        super(hVar2.baI(), kVar2, gVar.bdc(), hVar2.bgq().bgc().a(gVar2), false);
        this.eHk = gVar2;
        this.eHy = dVar;
        this.eGT = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(hVar2, (kotlin.reflect.jvm.internal.impl.descriptors.e) this, (x) this.eHk, 0, 4, null);
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = this;
        this.eGT.bgq().bga().a(this.eHk, dVar2);
        boolean z = false;
        Object obj = this.eHk.bhs() == null ? 1 : null;
        if (kotlin.m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Creating LazyJavaClassDescriptor for light class ");
            stringBuilder.append(this.eHk);
            throw new AssertionError(stringBuilder.toString());
        }
        ClassKind classKind;
        Modality modality;
        if (this.eHk.bhr()) {
            classKind = ClassKind.ANNOTATION_CLASS;
        } else if (this.eHk.isInterface()) {
            classKind = ClassKind.INTERFACE;
        } else if (this.eHk.isEnum()) {
            classKind = ClassKind.ENUM_CLASS;
        } else {
            classKind = ClassKind.CLASS;
        }
        this.eCs = classKind;
        if (this.eHk.bhr()) {
            modality = Modality.FINAL;
        } else {
            kotlin.reflect.jvm.internal.impl.descriptors.Modality.a aVar = Modality.Companion;
            boolean z2 = this.eHk.isAbstract() || this.eHk.isInterface();
            modality = aVar.n(z2, this.eHk.isFinal() ^ true);
        }
        this.eCr = modality;
        this.eCK = this.eHk.bbJ();
        if (!(this.eHk.bhq() == null || this.eHk.isStatic())) {
            z = true;
        }
        this.eAT = z;
        this.eHt = new b();
        this.eHu = new g(this.eGT, dVar2, this.eHk);
        this.eHv = new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(bbA());
        this.eHw = new l(this.eGT, this.eHk, this);
        this.eBt = kotlin.reflect.jvm.internal.impl.load.java.lazy.f.a(this.eGT, this.eHk);
        this.eHx = this.eGT.baI().i(new LazyJavaClassDescriptor$declaredParameters$1(this));
    }

    public ClassKind bbF() {
        return this.eCs;
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return (kotlin.jvm.internal.h.E(this.eCK, au.eBc) && this.eHk.bhq() == null) ? kotlin.reflect.jvm.internal.impl.load.java.k.eFf : this.eCK;
    }

    public boolean bbL() {
        return this.eAT;
    }

    public kotlin.reflect.jvm.internal.impl.types.an bby() {
        return this.eHt;
    }

    /* renamed from: bgB */
    public g bbA() {
        return this.eHu;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bdg() {
        return this.eHv;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx() {
        return this.eHw;
    }

    /* renamed from: bbD */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> bbE() {
        return (List) this.eHu.bgG().invoke();
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ() {
        return this.eBt;
    }

    public List<an> bbS() {
        return (List) this.eHx.invoke();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lazy Java class ");
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(this));
        return stringBuilder.toString();
    }

    public final f a(kotlin.reflect.jvm.internal.impl.load.java.components.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.h.e(gVar, "javaResolverCache");
        h a = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.a(this.eGT, this.eGT.bgq().a(gVar));
        k bbv = bbv();
        kotlin.jvm.internal.h.d(bbv, "containingDeclaration");
        return new f(a, bbv, this.eHk, dVar);
    }
}
