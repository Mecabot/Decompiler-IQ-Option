package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.z;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* compiled from: JvmBuiltInsSettings.kt */
public class JvmBuiltInsSettings implements kotlin.reflect.jvm.internal.impl.descriptors.a.a, kotlin.reflect.jvm.internal.impl.descriptors.a.c {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(JvmBuiltInsSettings.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(JvmBuiltInsSettings.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(JvmBuiltInsSettings.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(JvmBuiltInsSettings.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationsImpl;"))};
    private static final Set<String> eAA;
    private static final Set<String> eAB;
    private static final Set<String> eAC;
    private static final Set<String> eAD;
    public static final a eAE = new a();
    private static final Set<String> eAy = ak.e(u.eJX.d("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    private static final Set<String> eAz;
    private final kotlin.reflect.jvm.internal.impl.descriptors.u eAh;
    private final c eAr = c.eAc;
    private final kotlin.d eAs;
    private final kotlin.d eAt;
    private final w eAu;
    private final kotlin.reflect.jvm.internal.impl.storage.e eAv;
    private final kotlin.reflect.jvm.internal.impl.storage.a<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.descriptors.d> eAw;
    private final kotlin.reflect.jvm.internal.impl.storage.e eAx;

    /* compiled from: JvmBuiltInsSettings.kt */
    private enum JDKMemberStatus {
        BLACK_LIST,
        WHITE_LIST,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final boolean d(kotlin.reflect.jvm.internal.impl.name.c cVar) {
            h.e(cVar, "fqName");
            if (e(cVar)) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.name.a c = c.eAc.c(cVar);
            if (c == null) {
                return false;
            }
            try {
                return Serializable.class.isAssignableFrom(Class.forName(c.btK().asString()));
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }

        private final boolean e(kotlin.reflect.jvm.internal.impl.name.c cVar) {
            return h.E(cVar, g.exC.exP) || g.b(cVar);
        }

        public final Set<String> bcD() {
            return JvmBuiltInsSettings.eAy;
        }

        public final Set<String> bcE() {
            return JvmBuiltInsSettings.eAz;
        }

        public final Set<String> bcG() {
            return JvmBuiltInsSettings.eAA;
        }

        private final Set<String> bcF() {
            u uVar = u.eJX;
            Collection linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType jvmPrimitiveType : m.listOf(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR)) {
                String asString = jvmPrimitiveType.getWrapperFqName().btN().asString();
                h.d(asString, "it.wrapperFqName.shortName().asString()");
                String[] strArr = new String[1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jvmPrimitiveType.getJavaKeywordName());
                stringBuilder.append("Value()");
                stringBuilder.append(jvmPrimitiveType.getDesc());
                strArr[0] = stringBuilder.toString();
                r.a(linkedHashSet, (Iterable) uVar.c(asString, strArr));
            }
            return (LinkedHashSet) linkedHashSet;
        }

        private final Set<String> bcH() {
            u uVar = u.eJX;
            Collection linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType wrapperFqName : m.listOf(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT)) {
                String asString = wrapperFqName.getWrapperFqName().btN().asString();
                h.d(asString, "it.wrapperFqName.shortName().asString()");
                String[] i = uVar.i("Ljava/lang/String;");
                r.a(linkedHashSet, (Iterable) uVar.c(asString, (String[]) Arrays.copyOf(i, i.length)));
            }
            return (LinkedHashSet) linkedHashSet;
        }
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    static final class c<N> implements kotlin.reflect.jvm.internal.impl.utils.b.b<N> {
        final /* synthetic */ JvmBuiltInsSettings this$0;

        c(JvmBuiltInsSettings jvmBuiltInsSettings) {
            this.this$0 = jvmBuiltInsSettings;
        }

        /* renamed from: q */
        public final List<f> cK(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            h.d(dVar, "it");
            an bby = dVar.bby();
            h.d(bby, "it.typeConstructor");
            Collection<w> beu = bby.beu();
            h.d(beu, "it.typeConstructor.supertypes");
            Collection arrayList = new ArrayList();
            for (w bwA : beu) {
                kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bwA.bwA().bbW();
                Object obj = null;
                bbW = bbW != null ? bbW.bda() : null;
                if (!(bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
                    bbW = null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
                if (dVar2 != null) {
                    obj = this.this$0.o(dVar2);
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return (List) arrayList;
        }
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    static final class e<N> implements kotlin.reflect.jvm.internal.impl.utils.b.b<N> {
        public static final e eAH = new e();

        e() {
        }

        /* renamed from: d */
        public final Collection<? extends CallableMemberDescriptor> cK(CallableMemberDescriptor callableMemberDescriptor) {
            h.d(callableMemberDescriptor, "it");
            callableMemberDescriptor = callableMemberDescriptor.bcV();
            h.d(callableMemberDescriptor, "it.original");
            return callableMemberDescriptor.bcU();
        }
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    public static final class d extends kotlin.reflect.jvm.internal.impl.utils.b.a<kotlin.reflect.jvm.internal.impl.descriptors.d, JDKMemberStatus> {
        final /* synthetic */ String eAF;
        final /* synthetic */ ObjectRef eAG;

        d(String str, ObjectRef objectRef) {
            this.eAF = str;
            this.eAG = objectRef;
        }

        /* renamed from: r */
        public boolean cL(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            h.e(dVar, "javaClassDescriptor");
            String a = u.eJX.a(dVar, this.eAF);
            if (JvmBuiltInsSettings.eAE.bcE().contains(a)) {
                this.eAG.element = JDKMemberStatus.BLACK_LIST;
            } else if (JvmBuiltInsSettings.eAE.bcG().contains(a)) {
                this.eAG.element = JDKMemberStatus.WHITE_LIST;
            } else if (JvmBuiltInsSettings.eAE.bcD().contains(a)) {
                this.eAG.element = JDKMemberStatus.DROP;
            }
            return ((JDKMemberStatus) this.eAG.element) == null;
        }

        /* renamed from: bcL */
        public JDKMemberStatus bcM() {
            JDKMemberStatus jDKMemberStatus = (JDKMemberStatus) this.eAG.element;
            return jDKMemberStatus != null ? jDKMemberStatus : JDKMemberStatus.NOT_CONSIDERED;
        }
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    public static final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.w {
        final /* synthetic */ JvmBuiltInsSettings this$0;

        b(JvmBuiltInsSettings jvmBuiltInsSettings, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            this.this$0 = jvmBuiltInsSettings;
            super(uVar, bVar);
        }

        /* renamed from: bcJ */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c bbk() {
            return kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.u bcw() {
        kotlin.d dVar = this.eAs;
        j jVar = apP[0];
        return (kotlin.reflect.jvm.internal.impl.descriptors.u) dVar.getValue();
    }

    private final boolean bcx() {
        kotlin.d dVar = this.eAt;
        j jVar = apP[1];
        return ((Boolean) dVar.getValue()).booleanValue();
    }

    private final ad bcy() {
        return (ad) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eAv, (Object) this, apP[2]);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.h bcz() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.annotations.h) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eAx, (Object) this, apP[3]);
    }

    public JvmBuiltInsSettings(kotlin.reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.storage.h hVar, kotlin.jvm.a.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.u> aVar, kotlin.jvm.a.a<Boolean> aVar2) {
        h.e(uVar, "moduleDescriptor");
        h.e(hVar, "storageManager");
        h.e(aVar, "deferredOwnerModuleDescriptor");
        h.e(aVar2, "isAdditionalBuiltInsFeatureSupported");
        this.eAh = uVar;
        this.eAs = g.f(aVar);
        this.eAt = g.f(aVar2);
        this.eAu = a(hVar);
        this.eAv = hVar.i(new JvmBuiltInsSettings$cloneableType$2(this, hVar));
        this.eAw = hVar.byD();
        this.eAx = hVar.i(new JvmBuiltInsSettings$notConsideredDeprecation$2(this));
    }

    private final w a(kotlin.reflect.jvm.internal.impl.storage.h hVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.h hVar2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.h(new b(this, this.eAh, new kotlin.reflect.jvm.internal.impl.name.b("java.io")), kotlin.reflect.jvm.internal.impl.name.f.mD("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, l.cr(new z(hVar, new JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1(this))), ai.eAX, false, hVar);
        hVar2.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm, aj.emptySet(), null);
        ad bdb = hVar2.bdb();
        h.d(bdb, "mockSerializableClass.defaultType");
        return bdb;
    }

    public Collection<w> l(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "classDescriptor");
        kotlin.reflect.jvm.internal.impl.name.c z = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(dVar);
        if (eAE.e(z)) {
            w[] wVarArr = new w[2];
            ad bcy = bcy();
            h.d(bcy, "cloneableType");
            wVarArr[0] = bcy;
            wVarArr[1] = this.eAu;
            return m.listOf(wVarArr);
        } else if (eAE.d(z)) {
            return l.cr(this.eAu);
        } else {
            return m.emptyList();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0144  */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ah> a(kotlin.reflect.jvm.internal.impl.name.f r6, kotlin.reflect.jvm.internal.impl.descriptors.d r7) {
        /*
        r5 = this;
        r0 = "name";
        kotlin.jvm.internal.h.e(r6, r0);
        r0 = "classDescriptor";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.a.ezP;
        r0 = r0.bcd();
        r0 = kotlin.jvm.internal.h.E(r6, r0);
        if (r0 == 0) goto L_0x009e;
    L_0x0016:
        r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
        if (r0 == 0) goto L_0x009e;
    L_0x001a:
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.c(r7);
        if (r0 == 0) goto L_0x009e;
    L_0x0020:
        r7 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) r7;
        r0 = r7.byk();
        r0 = r0.bkv();
        r1 = "classDescriptor.classProto.functionList";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = (java.lang.Iterable) r0;
        r1 = r0 instanceof java.util.Collection;
        r2 = 0;
        if (r1 == 0) goto L_0x0040;
    L_0x0036:
        r1 = r0;
        r1 = (java.util.Collection) r1;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0072;
    L_0x0040:
        r0 = r0.iterator();
    L_0x0044:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0072;
    L_0x004a:
        r1 = r0.next();
        r1 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r1;
        r3 = r7.bxX();
        r3 = r3.aYI();
        r4 = "functionProto";
        kotlin.jvm.internal.h.d(r1, r4);
        r1 = r1.blW();
        r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.q.b(r3, r1);
        r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.a.ezP;
        r3 = r3.bcd();
        r1 = kotlin.jvm.internal.h.E(r1, r3);
        if (r1 == 0) goto L_0x0044;
    L_0x0071:
        r2 = 1;
    L_0x0072:
        if (r2 == 0) goto L_0x007b;
    L_0x0074:
        r6 = kotlin.collections.m.emptyList();
        r6 = (java.util.Collection) r6;
        return r6;
    L_0x007b:
        r0 = r5.bcy();
        r0 = r0.bbk();
        r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS;
        r1 = (kotlin.reflect.jvm.internal.impl.incremental.components.b) r1;
        r6 = r0.b(r6, r1);
        r6 = (java.lang.Iterable) r6;
        r6 = kotlin.collections.u.Q(r6);
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ah) r6;
        r6 = r5.a(r7, r6);
        r6 = kotlin.collections.l.cr(r6);
        r6 = (java.util.Collection) r6;
        return r6;
    L_0x009e:
        r0 = r5.bcx();
        if (r0 != 0) goto L_0x00ab;
    L_0x00a4:
        r6 = kotlin.collections.m.emptyList();
        r6 = (java.util.Collection) r6;
        return r6;
    L_0x00ab:
        r0 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getFunctions$2;
        r0.<init>(r6);
        r0 = (kotlin.jvm.a.b) r0;
        r6 = r5.a(r7, r0);
        r6 = (java.lang.Iterable) r6;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r6 = r6.iterator();
    L_0x00c3:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0151;
    L_0x00c9:
        r1 = r6.next();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ah) r1;
        r2 = r1.bbv();
        if (r2 != 0) goto L_0x00dd;
    L_0x00d5:
        r6 = new kotlin.TypeCastException;
        r7 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r6.<init>(r7);
        throw r6;
    L_0x00dd:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r2;
        r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.g.a(r2, r7);
        r2 = r2.bzh();
        r2 = r1.c(r2);
        if (r2 != 0) goto L_0x00f5;
    L_0x00ed:
        r6 = new kotlin.TypeCastException;
        r7 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor";
        r6.<init>(r7);
        throw r6;
    L_0x00f5:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ah) r2;
        r2 = r2.bdr();
        r3 = r7;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r3;
        r2.h(r3);
        r3 = r7.bdh();
        r2.a(r3);
        r2.bdt();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r1;
        r1 = r5.f(r1);
        r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.f.aoS;
        r1 = r1.ordinal();
        r1 = r3[r1];
        r3 = 0;
        switch(r1) {
            case 1: goto L_0x012e;
            case 2: goto L_0x011e;
            case 3: goto L_0x014a;
            case 4: goto L_0x013e;
            default: goto L_0x011d;
        };
    L_0x011d:
        goto L_0x013e;
    L_0x011e:
        r1 = r5.bcz();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) r1;
        r1 = r2.a(r1);
        r3 = "setAdditionalAnnotations(notConsideredDeprecation)";
        kotlin.jvm.internal.h.d(r1, r3);
        goto L_0x013e;
    L_0x012e:
        r1 = kotlin.reflect.jvm.internal.impl.descriptors.t.s(r7);
        if (r1 == 0) goto L_0x0135;
    L_0x0134:
        goto L_0x014a;
    L_0x0135:
        r1 = r2.bdw();
        r3 = "setHiddenForResolutionEverywhereBesideSupercalls()";
        kotlin.jvm.internal.h.d(r1, r3);
    L_0x013e:
        r1 = r2.bdx();
        if (r1 != 0) goto L_0x0147;
    L_0x0144:
        kotlin.jvm.internal.h.aXZ();
    L_0x0147:
        r3 = r1;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ah) r3;
    L_0x014a:
        if (r3 == 0) goto L_0x00c3;
    L_0x014c:
        r0.add(r3);
        goto L_0x00c3;
    L_0x0151:
        r0 = (java.util.List) r0;
        r0 = (java.util.Collection) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.a(kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d):java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ah>");
    }

    /* JADX WARNING: Missing block: B:9:0x0020, code:
            if (r2 != null) goto L_0x0027;
     */
    /* renamed from: m */
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.f> n(kotlin.reflect.jvm.internal.impl.descriptors.d r2) {
        /*
        r1 = this;
        r0 = "classDescriptor";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = r1.bcx();
        if (r0 != 0) goto L_0x0010;
    L_0x000b:
        r2 = kotlin.collections.aj.emptySet();
        return r2;
    L_0x0010:
        r2 = r1.o(r2);
        if (r2 == 0) goto L_0x0023;
    L_0x0016:
        r2 = r2.bbA();
        if (r2 == 0) goto L_0x0023;
    L_0x001c:
        r2 = r2.beC();
        if (r2 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0027;
    L_0x0023:
        r2 = kotlin.collections.aj.emptySet();
    L_0x0027:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.m(kotlin.reflect.jvm.internal.impl.descriptors.d):java.util.Set<kotlin.reflect.jvm.internal.impl.name.f>");
    }

    private final Collection<ah> a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends ah>> bVar) {
        f o = o(dVar);
        if (o == null) {
            return m.emptyList();
        }
        k kVar = o;
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.d> a = this.eAr.a(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(kVar), b.ezQ.bcf());
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) u.P(a);
        if (dVar2 == null) {
            return m.emptyList();
        }
        kotlin.reflect.jvm.internal.impl.utils.i.b bVar2 = i.eXR;
        Collection arrayList = new ArrayList(n.e(a, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.d x : a) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(x));
        }
        i Y = bVar2.Y((List) arrayList);
        boolean h = this.eAr.h(dVar);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbA = ((kotlin.reflect.jvm.internal.impl.descriptors.d) this.eAw.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(kVar), new JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1(o, dVar2))).bbA();
        h.d(bbA, "scope");
        Iterable iterable = (Iterable) bVar.invoke(bbA);
        Collection arrayList2 = new ArrayList();
        for (Object next : iterable) {
            ah ahVar = (ah) next;
            Object obj = null;
            if (ahVar.bcW() == Kind.DECLARATION && ahVar.bbJ().bed() && !g.f((k) ahVar)) {
                Object obj2;
                Collection bcU = ahVar.bcU();
                h.d(bcU, "analogueMember.overriddenDescriptors");
                Iterable<r> iterable2 = bcU;
                if (!((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty())) {
                    for (r rVar : iterable2) {
                        h.d(rVar, "it");
                        k bbv = rVar.bbv();
                        h.d(bbv, "it.containingDeclaration");
                        if (Y.contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(bbv))) {
                            obj2 = 1;
                            break;
                        }
                    }
                }
                obj2 = null;
                if (obj2 == null && !a(ahVar, h)) {
                    obj = 1;
                }
            }
            if (obj != null) {
                arrayList2.add(next);
            }
        }
        return (List) arrayList2;
    }

    private final ah a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e eVar, ah ahVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.r.a bdr = ahVar.bdr();
        bdr.h(eVar);
        bdr.a(au.eBg);
        bdr.M(eVar.bdb());
        bdr.a(eVar.bdh());
        r bdx = bdr.bdx();
        if (bdx == null) {
            h.aXZ();
        }
        return (ah) bdx;
    }

    private final boolean a(ah ahVar, boolean z) {
        k bbv = ahVar.bbv();
        if (bbv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        if ((z ^ eAB.contains(u.eJX.a((kotlin.reflect.jvm.internal.impl.descriptors.d) bbv, kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(ahVar, false, false, 3, null)))) != 0) {
            return true;
        }
        Boolean a = kotlin.reflect.jvm.internal.impl.utils.b.a((Collection) l.cr(ahVar), (kotlin.reflect.jvm.internal.impl.utils.b.b) e.eAH, (kotlin.jvm.a.b) new JvmBuiltInsSettings$isMutabilityViolation$2(this));
        h.d(a, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
        return a.booleanValue();
    }

    private final JDKMemberStatus f(r rVar) {
        k bbv = rVar.bbv();
        if (bbv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbv;
        String a = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(rVar, false, false, 3, null);
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (JDKMemberStatus) null;
        Object a2 = kotlin.reflect.jvm.internal.impl.utils.b.a((Collection) l.cr(dVar), (kotlin.reflect.jvm.internal.impl.utils.b.b) new c(this), (kotlin.reflect.jvm.internal.impl.utils.b.c) new d(a, objectRef));
        h.d(a2, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
        return (JDKMemberStatus) a2;
    }

    private final f o(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (g.f(dVar)) {
            return null;
        }
        k kVar = dVar;
        if (!g.c(kVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.c z = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(kVar);
        if (!z.isSafe()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.a c = this.eAr.c(z);
        if (c != null) {
            kotlin.reflect.jvm.internal.impl.name.b btK = c.btK();
            if (btK != null) {
                kotlin.reflect.jvm.internal.impl.descriptors.u bcw = bcw();
                h.d(btK, "javaAnalogueFqName");
                dVar = p.a(bcw, btK, NoLookupLocation.FROM_BUILTINS);
                if (!(dVar instanceof f)) {
                    dVar = null;
                }
                return (f) dVar;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0058 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1  */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> p(kotlin.reflect.jvm.internal.impl.descriptors.d r18) {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = "classDescriptor";
        kotlin.jvm.internal.h.e(r1, r2);
        r2 = r18.bbF();
        r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS;
        if (r2 != r3) goto L_0x016d;
    L_0x0011:
        r2 = r17.bcx();
        if (r2 != 0) goto L_0x0019;
    L_0x0017:
        goto L_0x016d;
    L_0x0019:
        r2 = r17.o(r18);
        if (r2 == 0) goto L_0x0166;
    L_0x001f:
        r3 = r0.eAr;
        r4 = r2;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r4;
        r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(r4);
        r5 = kotlin.reflect.jvm.internal.impl.builtins.jvm.b.ezQ;
        r5 = r5.bcf();
        r6 = 0;
        r7 = 4;
        r8 = 0;
        r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a(r3, r4, r5, r6, r7, r8);
        if (r3 == 0) goto L_0x015f;
    L_0x0037:
        r4 = r2;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r4;
        r5 = kotlin.reflect.jvm.internal.impl.builtins.jvm.g.a(r3, r4);
        r5 = r5.bzh();
        r6 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getConstructors$1;
        r6.<init>(r5);
        r2 = r2.bbE();
        r2 = (java.lang.Iterable) r2;
        r7 = new java.util.ArrayList;
        r7.<init>();
        r7 = (java.util.Collection) r7;
        r2 = r2.iterator();
    L_0x0058:
        r8 = r2.hasNext();
        r9 = 0;
        r10 = 3;
        r11 = 0;
        if (r8 == 0) goto L_0x00e6;
    L_0x0061:
        r8 = r2.next();
        r12 = r8;
        r12 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r12;
        r13 = "javaConstructor";
        kotlin.jvm.internal.h.d(r12, r13);
        r13 = r12.bbJ();
        r13 = r13.bed();
        if (r13 == 0) goto L_0x00dd;
    L_0x0077:
        r13 = r3.bbE();
        r15 = "defaultKotlinVersion.constructors";
        kotlin.jvm.internal.h.d(r13, r15);
        r13 = (java.lang.Iterable) r13;
        r15 = r13 instanceof java.util.Collection;
        if (r15 == 0) goto L_0x0091;
    L_0x0086:
        r15 = r13;
        r15 = (java.util.Collection) r15;
        r15 = r15.isEmpty();
        if (r15 == 0) goto L_0x0091;
    L_0x008f:
        r14 = 1;
        goto L_0x00b2;
    L_0x0091:
        r13 = r13.iterator();
    L_0x0095:
        r15 = r13.hasNext();
        if (r15 == 0) goto L_0x008f;
    L_0x009b:
        r15 = r13.next();
        r15 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r15;
        r14 = "it";
        kotlin.jvm.internal.h.d(r15, r14);
        r15 = (kotlin.reflect.jvm.internal.impl.descriptors.j) r15;
        r14 = r12;
        r14 = (kotlin.reflect.jvm.internal.impl.descriptors.j) r14;
        r14 = r6.a(r15, r14);
        if (r14 == 0) goto L_0x0095;
    L_0x00b1:
        r14 = 0;
    L_0x00b2:
        if (r14 == 0) goto L_0x00dd;
    L_0x00b4:
        r13 = r12;
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.j) r13;
        r13 = r0.a(r13, r1);
        if (r13 != 0) goto L_0x00dd;
    L_0x00bd:
        r13 = r12;
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r13;
        r13 = kotlin.reflect.jvm.internal.impl.builtins.g.f(r13);
        if (r13 != 0) goto L_0x00dd;
    L_0x00c6:
        r13 = eAC;
        r14 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.eJX;
        r12 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r12;
        r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(r12, r11, r11, r10, r9);
        r9 = r14.a(r4, r9);
        r9 = r13.contains(r9);
        if (r9 != 0) goto L_0x00dd;
    L_0x00da:
        r16 = 1;
        goto L_0x00df;
    L_0x00dd:
        r16 = 0;
    L_0x00df:
        if (r16 == 0) goto L_0x0058;
    L_0x00e1:
        r7.add(r8);
        goto L_0x0058;
    L_0x00e6:
        r7 = (java.util.List) r7;
        r7 = (java.lang.Iterable) r7;
        r2 = new java.util.ArrayList;
        r3 = 10;
        r3 = kotlin.collections.n.e(r7, r3);
        r2.<init>(r3);
        r2 = (java.util.Collection) r2;
        r3 = r7.iterator();
    L_0x00fb:
        r6 = r3.hasNext();
        if (r6 == 0) goto L_0x015a;
    L_0x0101:
        r6 = r3.next();
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r6;
        r7 = r6.bdr();
        r8 = r1;
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r8;
        r7.h(r8);
        r8 = r18.bdb();
        r8 = (kotlin.reflect.jvm.internal.impl.types.w) r8;
        r7.M(r8);
        r7.bdt();
        r8 = r5.bzi();
        r7.b(r8);
        r8 = eAD;
        r12 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.eJX;
        r13 = "javaConstructor";
        kotlin.jvm.internal.h.d(r6, r13);
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r6;
        r6 = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(r6, r11, r11, r10, r9);
        r6 = r12.a(r4, r6);
        r6 = r8.contains(r6);
        if (r6 != 0) goto L_0x0146;
    L_0x013d:
        r6 = r17.bcz();
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) r6;
        r7.a(r6);
    L_0x0146:
        r6 = r7.bdx();
        if (r6 != 0) goto L_0x0154;
    L_0x014c:
        r1 = new kotlin.TypeCastException;
        r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor";
        r1.<init>(r2);
        throw r1;
    L_0x0154:
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r6;
        r2.add(r6);
        goto L_0x00fb;
    L_0x015a:
        r2 = (java.util.List) r2;
        r2 = (java.util.Collection) r2;
        return r2;
    L_0x015f:
        r1 = kotlin.collections.m.emptyList();
        r1 = (java.util.Collection) r1;
        return r1;
    L_0x0166:
        r1 = kotlin.collections.m.emptyList();
        r1 = (java.util.Collection) r1;
        return r1;
    L_0x016d:
        r1 = kotlin.collections.m.emptyList();
        r1 = (java.util.Collection) r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.p(kotlin.reflect.jvm.internal.impl.descriptors.d):java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.c>");
    }

    public boolean a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, ah ahVar) {
        h.e(dVar, "classDescriptor");
        h.e(ahVar, "functionDescriptor");
        f o = o(dVar);
        if (o == null || !ahVar.bbQ().k(kotlin.reflect.jvm.internal.impl.descriptors.a.d.bem())) {
            return true;
        }
        boolean z = false;
        if (!bcx()) {
            return false;
        }
        String a = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(ahVar, false, false, 3, null);
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.g bgB = o.bbA();
        kotlin.reflect.jvm.internal.impl.name.f bdc = ahVar.bdc();
        h.d(bdc, "functionDescriptor.name");
        Iterable<ah> b = bgB.b(bdc, (kotlin.reflect.jvm.internal.impl.incremental.components.b) NoLookupLocation.FROM_BUILTINS);
        if (!(b instanceof Collection) || !((Collection) b).isEmpty()) {
            for (ah ahVar2 : b) {
                if (h.E(kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(ahVar2, false, false, 3, null), a)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (jVar.bcS().size() == 1) {
            List bcS = jVar.bcS();
            h.d(bcS, "valueParameters");
            Object bY = u.bY(bcS);
            h.d(bY, "valueParameters.single()");
            kotlin.reflect.jvm.internal.impl.descriptors.f bbW = ((aq) bY).bai().bwA().bbW();
            if (h.E(bbW != null ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(bbW) : null, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(dVar))) {
                return true;
            }
        }
        return false;
    }

    static {
        u uVar = u.eJX;
        eAz = ak.a(ak.a(ak.a(ak.a(ak.a(eAE.bcF(), uVar.d("List", "sort(Ljava/util/Comparator;)V")), uVar.c("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), uVar.c("Double", "isInfinite()Z", "isNaN()Z")), uVar.c("Float", "isInfinite()Z", "isNaN()Z")), uVar.c("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        uVar = u.eJX;
        eAA = ak.a(ak.a(ak.a(ak.a(ak.a(ak.a(uVar.c("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), uVar.d("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), uVar.c("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), uVar.c("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), uVar.d("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), uVar.d("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), uVar.d("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        uVar = u.eJX;
        eAB = ak.a(ak.a(uVar.d("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), uVar.d("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), uVar.d("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        uVar = u.eJX;
        Set b = eAE.bcH();
        String[] i = uVar.i("D");
        b = ak.a(b, uVar.c("Float", (String[]) Arrays.copyOf(i, i.length)));
        i = uVar.i("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        eAC = ak.a(b, uVar.c("String", (String[]) Arrays.copyOf(i, i.length)));
        uVar = u.eJX;
        String[] i2 = uVar.i("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        eAD = uVar.c("Throwable", (String[]) Arrays.copyOf(i2, i2.length));
    }
}
