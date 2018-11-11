package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.u;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: KotlinBuiltIns */
public abstract class g {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final a exC = new a();
    public static final f exD = f.mF("<built-ins module>");
    public static final f exo = f.mD("kotlin");
    public static final kotlin.reflect.jvm.internal.impl.name.b exp = kotlin.reflect.jvm.internal.impl.name.b.E(exo);
    private static final kotlin.reflect.jvm.internal.impl.name.b exq = exp.C(f.mD("annotation"));
    public static final kotlin.reflect.jvm.internal.impl.name.b exr = exp.C(f.mD("collections"));
    public static final kotlin.reflect.jvm.internal.impl.name.b exs = exp.C(f.mD("ranges"));
    public static final kotlin.reflect.jvm.internal.impl.name.b ext = exp.C(f.mD("text"));
    public static final Set<kotlin.reflect.jvm.internal.impl.name.b> exu = aj.I(exp, exr, exs, exq, i.bbo(), exp.C(f.mD("internal")));
    private final kotlin.reflect.jvm.internal.impl.storage.b<f, kotlin.reflect.jvm.internal.impl.descriptors.d> exA;
    private final h exB;
    private u exv;
    private final e<c> exw;
    private final kotlin.reflect.jvm.internal.impl.storage.b<kotlin.reflect.jvm.internal.impl.descriptors.u, d> exx;
    private final e<b> exy;
    private final kotlin.reflect.jvm.internal.impl.storage.b<Integer, kotlin.reflect.jvm.internal.impl.descriptors.d> exz;

    /* compiled from: KotlinBuiltIns */
    public static class a {
        public final kotlin.reflect.jvm.internal.impl.name.c exI = md("Any");
        public final kotlin.reflect.jvm.internal.impl.name.c exJ = md("Nothing");
        public final kotlin.reflect.jvm.internal.impl.name.c exK = md("Cloneable");
        public final kotlin.reflect.jvm.internal.impl.name.b exL = me("Suppress");
        public final kotlin.reflect.jvm.internal.impl.name.c exM = md("Unit");
        public final kotlin.reflect.jvm.internal.impl.name.c exN = md("CharSequence");
        public final kotlin.reflect.jvm.internal.impl.name.c exO = md("String");
        public final kotlin.reflect.jvm.internal.impl.name.c exP = md("Array");
        public final kotlin.reflect.jvm.internal.impl.name.c exQ = md("Boolean");
        public final kotlin.reflect.jvm.internal.impl.name.c exR = md("Char");
        public final kotlin.reflect.jvm.internal.impl.name.c exS = md("Byte");
        public final kotlin.reflect.jvm.internal.impl.name.c exT = md("Short");
        public final kotlin.reflect.jvm.internal.impl.name.c exU = md("Int");
        public final kotlin.reflect.jvm.internal.impl.name.c exV = md("Long");
        public final kotlin.reflect.jvm.internal.impl.name.c exW = md("Float");
        public final kotlin.reflect.jvm.internal.impl.name.c exX = md("Double");
        public final kotlin.reflect.jvm.internal.impl.name.c exY = md("Number");
        public final kotlin.reflect.jvm.internal.impl.name.c exZ = md("Enum");
        public final kotlin.reflect.jvm.internal.impl.name.b eyA = mf("Map");
        public final kotlin.reflect.jvm.internal.impl.name.b eyB = this.eyA.C(f.mD("Entry"));
        public final kotlin.reflect.jvm.internal.impl.name.b eyC = mf("MutableIterator");
        public final kotlin.reflect.jvm.internal.impl.name.b eyD = mf("MutableIterable");
        public final kotlin.reflect.jvm.internal.impl.name.b eyE = mf("MutableCollection");
        public final kotlin.reflect.jvm.internal.impl.name.b eyF = mf("MutableList");
        public final kotlin.reflect.jvm.internal.impl.name.b eyG = mf("MutableListIterator");
        public final kotlin.reflect.jvm.internal.impl.name.b eyH = mf("MutableSet");
        public final kotlin.reflect.jvm.internal.impl.name.b eyI = mf("MutableMap");
        public final kotlin.reflect.jvm.internal.impl.name.b eyJ = this.eyI.C(f.mD("MutableEntry"));
        public final kotlin.reflect.jvm.internal.impl.name.c eyK = mh("KClass");
        public final kotlin.reflect.jvm.internal.impl.name.c eyL = mh("KCallable");
        public final kotlin.reflect.jvm.internal.impl.name.c eyM = mh("KProperty0");
        public final kotlin.reflect.jvm.internal.impl.name.c eyN = mh("KProperty1");
        public final kotlin.reflect.jvm.internal.impl.name.c eyO = mh("KProperty2");
        public final kotlin.reflect.jvm.internal.impl.name.c eyP = mh("KMutableProperty0");
        public final kotlin.reflect.jvm.internal.impl.name.c eyQ = mh("KMutableProperty1");
        public final kotlin.reflect.jvm.internal.impl.name.c eyR = mh("KMutableProperty2");
        public final kotlin.reflect.jvm.internal.impl.name.a eyS = kotlin.reflect.jvm.internal.impl.name.a.t(mh("KProperty").btP());
        public final kotlin.reflect.jvm.internal.impl.name.b eyT = me("UByte");
        public final kotlin.reflect.jvm.internal.impl.name.b eyU = me("UShort");
        public final kotlin.reflect.jvm.internal.impl.name.b eyV = me("UInt");
        public final kotlin.reflect.jvm.internal.impl.name.b eyW = me("ULong");
        public final kotlin.reflect.jvm.internal.impl.name.a eyX = kotlin.reflect.jvm.internal.impl.name.a.t(this.eyT);
        public final kotlin.reflect.jvm.internal.impl.name.a eyY = kotlin.reflect.jvm.internal.impl.name.a.t(this.eyU);
        public final kotlin.reflect.jvm.internal.impl.name.a eyZ = kotlin.reflect.jvm.internal.impl.name.a.t(this.eyV);
        public final kotlin.reflect.jvm.internal.impl.name.c eya = md("Function");
        public final kotlin.reflect.jvm.internal.impl.name.b eyb = me("Throwable");
        public final kotlin.reflect.jvm.internal.impl.name.b eyc = me("Comparable");
        public final kotlin.reflect.jvm.internal.impl.name.c eyd = mg("CharRange");
        public final kotlin.reflect.jvm.internal.impl.name.c eye = mg("IntRange");
        public final kotlin.reflect.jvm.internal.impl.name.c eyf = mg("LongRange");
        public final kotlin.reflect.jvm.internal.impl.name.b eyg = me("Deprecated");
        public final kotlin.reflect.jvm.internal.impl.name.b eyh = me("DeprecationLevel");
        public final kotlin.reflect.jvm.internal.impl.name.b eyi = me("ReplaceWith");
        public final kotlin.reflect.jvm.internal.impl.name.b eyj = me("ExtensionFunctionType");
        public final kotlin.reflect.jvm.internal.impl.name.b eyk = me("ParameterName");
        public final kotlin.reflect.jvm.internal.impl.name.b eyl = me("Annotation");
        public final kotlin.reflect.jvm.internal.impl.name.b eym = mi("Target");
        public final kotlin.reflect.jvm.internal.impl.name.b eyn = mi("AnnotationTarget");
        public final kotlin.reflect.jvm.internal.impl.name.b eyo = mi("AnnotationRetention");
        public final kotlin.reflect.jvm.internal.impl.name.b eyp = mi("Retention");
        public final kotlin.reflect.jvm.internal.impl.name.b eyq = mi("Repeatable");
        public final kotlin.reflect.jvm.internal.impl.name.b eyr = mi("MustBeDocumented");
        public final kotlin.reflect.jvm.internal.impl.name.b eys = me("UnsafeVariance");
        public final kotlin.reflect.jvm.internal.impl.name.b eyt = me("PublishedApi");
        public final kotlin.reflect.jvm.internal.impl.name.b eyu = mf("Iterator");
        public final kotlin.reflect.jvm.internal.impl.name.b eyv = mf("Iterable");
        public final kotlin.reflect.jvm.internal.impl.name.b eyw = mf("Collection");
        public final kotlin.reflect.jvm.internal.impl.name.b eyx = mf("List");
        public final kotlin.reflect.jvm.internal.impl.name.b eyy = mf("ListIterator");
        public final kotlin.reflect.jvm.internal.impl.name.b eyz = mf("Set");
        public final kotlin.reflect.jvm.internal.impl.name.a eza = kotlin.reflect.jvm.internal.impl.name.a.t(this.eyW);
        public final Set<f> ezb = kotlin.reflect.jvm.internal.impl.utils.a.bu(PrimitiveType.values().length);
        public final Set<f> ezc = kotlin.reflect.jvm.internal.impl.utils.a.bu(PrimitiveType.values().length);
        public final Map<kotlin.reflect.jvm.internal.impl.name.c, PrimitiveType> ezd = kotlin.reflect.jvm.internal.impl.utils.a.bf(PrimitiveType.values().length);
        public final Map<kotlin.reflect.jvm.internal.impl.name.c, PrimitiveType> eze = kotlin.reflect.jvm.internal.impl.utils.a.bf(PrimitiveType.values().length);

        public a() {
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                this.ezb.add(primitiveType.getTypeName());
                this.ezc.add(primitiveType.getArrayTypeName());
                this.ezd.put(md(primitiveType.getTypeName().asString()), primitiveType);
                this.eze.put(md(primitiveType.getArrayTypeName().asString()), primitiveType);
            }
        }

        private static kotlin.reflect.jvm.internal.impl.name.c md(String str) {
            return me(str).btL();
        }

        private static kotlin.reflect.jvm.internal.impl.name.b me(String str) {
            return g.exp.C(f.mD(str));
        }

        private static kotlin.reflect.jvm.internal.impl.name.b mf(String str) {
            return g.exr.C(f.mD(str));
        }

        private static kotlin.reflect.jvm.internal.impl.name.c mg(String str) {
            return g.exs.C(f.mD(str)).btL();
        }

        private static kotlin.reflect.jvm.internal.impl.name.c mh(String str) {
            return i.bbo().C(f.mD(str)).btL();
        }

        private static kotlin.reflect.jvm.internal.impl.name.b mi(String str) {
            return g.exq.C(f.mD(str));
        }
    }

    /* compiled from: KotlinBuiltIns */
    private static class b {
        public final x ezf;
        public final x ezg;
        public final x ezh;
        public final Set<x> ezi;

        /* synthetic */ b(x xVar, x xVar2, x xVar3, Set set, AnonymousClass1 anonymousClass1) {
            this(xVar, xVar2, xVar3, set);
        }

        private b(x xVar, x xVar2, x xVar3, Set<x> set) {
            this.ezf = xVar;
            this.ezg = xVar2;
            this.ezh = xVar3;
            this.ezi = set;
        }
    }

    /* compiled from: KotlinBuiltIns */
    private static class c {
        public final Map<PrimitiveType, ad> ezj;
        public final Map<w, ad> ezk;
        public final Map<ad, ad> ezl;

        /* synthetic */ c(Map map, Map map2, Map map3, AnonymousClass1 anonymousClass1) {
            this(map, map2, map3);
        }

        private c(Map<PrimitiveType, ad> map, Map<w, ad> map2, Map<ad, ad> map3) {
            this.ezj = map;
            this.ezk = map2;
            this.ezl = map3;
        }
    }

    /* compiled from: KotlinBuiltIns */
    private static class d {
        public final Map<w, ad> ezm;
        public final Map<ad, ad> ezn;

        /* synthetic */ d(Map map, Map map2, AnonymousClass1 anonymousClass1) {
            this(map, map2);
        }

        private d(Map<w, ad> map, Map<ad, ad> map2) {
            this.ezm = map;
            this.ezn = map2;
        }
    }

    protected g(h hVar) {
        this.exB = hVar;
        this.exy = hVar.i(new kotlin.jvm.a.a<b>() {
            /* renamed from: bbi */
            public b invoke() {
                y beV = g.this.exv.beV();
                Map linkedHashMap = new LinkedHashMap();
                x a = g.this.a(beV, linkedHashMap, g.exp);
                x a2 = g.this.a(beV, linkedHashMap, g.exr);
                g.this.a(beV, linkedHashMap, g.exs);
                return new b(a, a2, g.this.a(beV, linkedHashMap, g.exq), new LinkedHashSet(linkedHashMap.values()), null);
            }
        });
        this.exw = hVar.i(new kotlin.jvm.a.a<c>() {
            /* renamed from: bbj */
            public c invoke() {
                Map enumMap = new EnumMap(PrimitiveType.class);
                Map hashMap = new HashMap();
                Map hashMap2 = new HashMap();
                for (PrimitiveType primitiveType : PrimitiveType.values()) {
                    ad a = g.this.mc(primitiveType.getTypeName().asString());
                    ad a2 = g.this.mc(primitiveType.getArrayTypeName().asString());
                    enumMap.put(primitiveType, a2);
                    hashMap.put(a, a2);
                    hashMap2.put(a2, a);
                }
                return new c(enumMap, hashMap, hashMap2, null);
            }
        });
        this.exx = hVar.o(new kotlin.jvm.a.b<kotlin.reflect.jvm.internal.impl.descriptors.u, d>() {
            /* renamed from: a */
            public d invoke(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
                Map hashMap = new HashMap();
                Map hashMap2 = new HashMap();
                for (UnsignedType unsignedType : UnsignedType.values()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.d a = q.a(uVar, unsignedType.getClassId());
                    if (a != null) {
                        kotlin.reflect.jvm.internal.impl.descriptors.d a2 = q.a(uVar, unsignedType.getArrayClassId());
                        if (a2 != null) {
                            ad bdb = a.bdb();
                            ad bdb2 = a2.bdb();
                            hashMap.put(bdb, bdb2);
                            hashMap2.put(bdb2, bdb);
                        }
                    }
                }
                return new d(hashMap, hashMap2, null);
            }
        });
        this.exz = hVar.o(new kotlin.jvm.a.b<Integer, kotlin.reflect.jvm.internal.impl.descriptors.d>() {
            /* renamed from: k */
            public kotlin.reflect.jvm.internal.impl.descriptors.d invoke(Integer num) {
                return new FunctionClassDescriptor(g.this.baI(), ((b) g.this.exy.invoke()).ezf, Kind.SuspendFunction, num.intValue());
            }
        });
        this.exA = hVar.o(new kotlin.jvm.a.b<f, kotlin.reflect.jvm.internal.impl.descriptors.d>() {
            /* renamed from: d */
            public kotlin.reflect.jvm.internal.impl.descriptors.d invoke(f fVar) {
                return g.a(fVar, g.this.baK());
            }
        });
    }

    protected void baE() {
        this.exv = new u(exD, this.exB, this, null);
        this.exv.a(b.exf.bay().a(this.exB, this.exv, baH(), baG(), baF()));
        this.exv.a(this.exv);
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.a.a baF() {
        return kotlin.reflect.jvm.internal.impl.descriptors.a.a.a.eBS;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.a.c baG() {
        return kotlin.reflect.jvm.internal.impl.descriptors.a.c.b.eBU;
    }

    protected Iterable<kotlin.reflect.jvm.internal.impl.descriptors.a.b> baH() {
        return Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(this.exB, this.exv));
    }

    private x a(y yVar, Map<kotlin.reflect.jvm.internal.impl.name.b, x> map, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        x mVar;
        final List i = yVar.i(bVar);
        if (i.isEmpty()) {
            mVar = new m(this.exv, bVar);
        } else if (i.size() == 1) {
            mVar = (x) i.iterator().next();
        } else {
            final kotlin.reflect.jvm.internal.impl.name.b bVar2 = bVar;
            x anonymousClass6 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.w(this.exv, bVar) {
                public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("built-in package ");
                    stringBuilder.append(bVar2);
                    return new kotlin.reflect.jvm.internal.impl.resolve.scopes.b(stringBuilder.toString(), u.c(i, new kotlin.jvm.a.b<x, kotlin.reflect.jvm.internal.impl.resolve.scopes.h>() {
                        /* renamed from: a */
                        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke(x xVar) {
                            return xVar.bbk();
                        }
                    }));
                }
            };
        }
        if (map != null) {
            map.put(bVar, mVar);
        }
        return mVar;
    }

    protected h baI() {
        return this.exB;
    }

    public u baJ() {
        return this.exv;
    }

    public x baK() {
        return ((b) this.exy.invoke()).ezf;
    }

    public static boolean b(k kVar) {
        return kotlin.reflect.jvm.internal.impl.resolve.c.a(kVar, c.class, false) != null;
    }

    public static boolean c(k kVar) {
        while (kVar != null) {
            if (kVar instanceof x) {
                return ((x) kVar).bdD().D(exo);
            }
            kVar = kVar.bbv();
        }
        return false;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d c(f fVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) this.exA.invoke(fVar);
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.d a(f fVar, x xVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.d b = b(fVar, xVar);
        if (b != null) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Built-in class ");
        stringBuilder.append(xVar.bdD().C(fVar).asString());
        stringBuilder.append(" is not found");
        throw new AssertionError(stringBuilder.toString());
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d c(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return p.a(this.exv, bVar, NoLookupLocation.FROM_BUILTINS);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d d(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return c(bVar);
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.d b(f fVar, x xVar) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) xVar.bbk().c(fVar, NoLookupLocation.FROM_BUILTINS);
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.d ma(String str) {
        return c(f.mD(str));
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.d a(String str, x xVar) {
        return a(f.mD(str), xVar);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baL() {
        return ma("Any");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baM() {
        return ma("Nothing");
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.d a(PrimitiveType primitiveType) {
        return ma(primitiveType.getTypeName().asString());
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baN() {
        return ma("Array");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baO() {
        return ma("Number");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baP() {
        return ma("Unit");
    }

    public static String jp(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Function");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public static kotlin.reflect.jvm.internal.impl.name.a jq(int i) {
        return new kotlin.reflect.jvm.internal.impl.name.a(exp, f.mD(jp(i)));
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d jr(int i) {
        return ma(jp(i));
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d js(int i) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) this.exz.invoke(Integer.valueOf(i));
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baQ() {
        return ma("String");
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.d mb(String str) {
        return a(str, ((b) this.exy.invoke()).ezg);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d baR() {
        return mb("Collection");
    }

    private ad mc(String str) {
        return ma(str).bdb();
    }

    public ad baS() {
        return baM().bdb();
    }

    public ad baT() {
        return baS().gQ(true);
    }

    public ad baU() {
        return baL().bdb();
    }

    public ad baV() {
        return baU().gQ(true);
    }

    public ad baW() {
        return baV();
    }

    public ad b(PrimitiveType primitiveType) {
        return a(primitiveType).bdb();
    }

    public ad baX() {
        return b(PrimitiveType.BYTE);
    }

    public ad baY() {
        return b(PrimitiveType.SHORT);
    }

    public ad baZ() {
        return b(PrimitiveType.INT);
    }

    public ad bba() {
        return b(PrimitiveType.LONG);
    }

    public ad bbb() {
        return b(PrimitiveType.FLOAT);
    }

    public ad bbc() {
        return b(PrimitiveType.DOUBLE);
    }

    public ad bbd() {
        return b(PrimitiveType.CHAR);
    }

    public ad bbe() {
        return b(PrimitiveType.BOOLEAN);
    }

    public ad bbf() {
        return baP().bdb();
    }

    public ad bbg() {
        return baQ().bdb();
    }

    public w l(w wVar) {
        if (!n(wVar)) {
            w aU = au.aU(wVar);
            w wVar2 = (w) ((c) this.exw.invoke()).ezl.get(aU);
            if (wVar2 != null) {
                return wVar2;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.u an = kotlin.reflect.jvm.internal.impl.resolve.c.an(aU);
            if (an != null) {
                ad adVar = (ad) ((d) this.exx.invoke(an)).ezn.get(aU);
                if (adVar != null) {
                    return adVar;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("not array: ");
            stringBuilder.append(wVar);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (wVar.bdF().size() == 1) {
            return ((ap) wVar.bdF().get(0)).bai();
        } else {
            throw new IllegalStateException();
        }
    }

    public ad c(PrimitiveType primitiveType) {
        return (ad) ((c) this.exw.invoke()).ezj.get(primitiveType);
    }

    public ad m(w wVar) {
        ad adVar = (ad) ((c) this.exw.invoke()).ezk.get(wVar);
        if (adVar != null) {
            return adVar;
        }
        if (!k.ezF.I(wVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u an = kotlin.reflect.jvm.internal.impl.resolve.c.an(wVar);
        if (an == null) {
            return null;
        }
        return (ad) ((d) this.exx.invoke(an)).ezm.get(wVar);
    }

    public static boolean b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return exC.eze.get(cVar) != null;
    }

    public static PrimitiveType d(k kVar) {
        return exC.ezb.contains(kVar.bdc()) ? (PrimitiveType) exC.ezd.get(kotlin.reflect.jvm.internal.impl.resolve.c.w(kVar)) : null;
    }

    public static PrimitiveType e(k kVar) {
        return exC.ezc.contains(kVar.bdc()) ? (PrimitiveType) exC.eze.get(kotlin.reflect.jvm.internal.impl.resolve.c.w(kVar)) : null;
    }

    public ad a(Variance variance, w wVar) {
        return kotlin.reflect.jvm.internal.impl.types.x.a(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel(), baN(), Collections.singletonList(new ar(variance, wVar)));
    }

    public static boolean n(w wVar) {
        return a(wVar, exC.exP);
    }

    public static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return a((kotlin.reflect.jvm.internal.impl.descriptors.f) dVar, exC.exP) || e((k) dVar) != null;
    }

    public static boolean o(w wVar) {
        k bbW = wVar.bwA().bbW();
        return (bbW == null || e(bbW) == null) ? false : true;
    }

    public static boolean p(w wVar) {
        return !wVar.aYp() && q(wVar);
    }

    public static boolean q(w wVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        return (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && d((kotlin.reflect.jvm.internal.impl.descriptors.d) bbW);
    }

    public static boolean d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return d((k) dVar) != null;
    }

    public static boolean a(w wVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        return (bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && a(bbW, cVar);
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.descriptors.f fVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return fVar.bdc().equals(cVar.btN()) && cVar.equals(kotlin.reflect.jvm.internal.impl.resolve.c.w(fVar));
    }

    private static boolean b(w wVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return !wVar.aYp() && a(wVar, cVar);
    }

    public static boolean e(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return a((kotlin.reflect.jvm.internal.impl.descriptors.f) dVar, exC.exI) || a((kotlin.reflect.jvm.internal.impl.descriptors.f) dVar, exC.exJ);
    }

    public static boolean f(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return a((kotlin.reflect.jvm.internal.impl.descriptors.f) dVar, exC.exI);
    }

    public static boolean r(w wVar) {
        return c(wVar, exC.exQ);
    }

    public static boolean s(w wVar) {
        return c(wVar, exC.exR);
    }

    public static boolean t(w wVar) {
        return c(wVar, exC.exU);
    }

    public static boolean u(w wVar) {
        return c(wVar, exC.exS);
    }

    public static boolean v(w wVar) {
        return c(wVar, exC.exV);
    }

    public static boolean w(w wVar) {
        return c(wVar, exC.exT);
    }

    public static boolean x(w wVar) {
        return y(wVar) && !wVar.aYp();
    }

    public static boolean y(w wVar) {
        return a(wVar, exC.exW);
    }

    public static boolean z(w wVar) {
        return A(wVar) && !wVar.aYp();
    }

    public static boolean A(w wVar) {
        return a(wVar, exC.exX);
    }

    private static boolean c(w wVar, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return a(wVar, cVar) && !wVar.aYp();
    }

    public static boolean B(w wVar) {
        return C(wVar) && !au.aW(wVar);
    }

    public static boolean C(w wVar) {
        return a(wVar, exC.exJ);
    }

    public static boolean D(w wVar) {
        return a(wVar, exC.exI);
    }

    public static boolean E(w wVar) {
        return D(wVar) && wVar.aYp();
    }

    public static boolean F(w wVar) {
        return E(wVar);
    }

    public static boolean G(w wVar) {
        return b(wVar, exC.exM);
    }

    public static boolean H(w wVar) {
        return wVar != null && b(wVar, exC.exO);
    }

    public static boolean g(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        return a((kotlin.reflect.jvm.internal.impl.descriptors.f) dVar, exC.eyK);
    }

    public static boolean f(k kVar) {
        boolean z = true;
        if (a(kVar, exC.eyg)) {
            return true;
        }
        if (!(kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.ad)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ad adVar = (kotlin.reflect.jvm.internal.impl.descriptors.ad) kVar;
        boolean bdW = adVar.bdW();
        k bdI = adVar.bdI();
        kVar = adVar.bdJ();
        if (bdI == null || !f(bdI) || (bdW && (kVar == null || !f(kVar)))) {
            z = false;
        }
        return z;
    }

    public static kotlin.reflect.jvm.internal.impl.name.b d(PrimitiveType primitiveType) {
        return exp.C(primitiveType.getTypeName());
    }

    private static boolean a(k kVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ = kVar.bcZ().bbQ();
        if (bbQ.j(bVar) != null) {
            return true;
        }
        AnnotationUseSiteTarget l = AnnotationUseSiteTarget.Companion.l(kVar);
        if (l == null || kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.a(bbQ, l, bVar) == null) {
            return false;
        }
        return true;
    }
}
