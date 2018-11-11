package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.d;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaToKotlinClassMap.kt */
public final class c {
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.c, b> eAa = new HashMap();
    private static final List<a> eAb;
    public static final c eAc;
    private static final String ezS;
    private static final String ezT;
    private static final kotlin.reflect.jvm.internal.impl.name.a ezU = kotlin.reflect.jvm.internal.impl.name.a.t(new b("kotlin.jvm.functions.FunctionN"));
    private static final b ezV = ezU.btK();
    private static final kotlin.reflect.jvm.internal.impl.name.a ezW = kotlin.reflect.jvm.internal.impl.name.a.t(new b("kotlin.reflect.KFunction"));
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.a> ezX = new HashMap();
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.a> ezY = new HashMap();
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.c, b> ezZ = new HashMap();

    /* compiled from: JavaToKotlinClassMap.kt */
    public static final class a {
        private final kotlin.reflect.jvm.internal.impl.name.a eAd;
        private final kotlin.reflect.jvm.internal.impl.name.a eAe;
        private final kotlin.reflect.jvm.internal.impl.name.a eAf;

        public final kotlin.reflect.jvm.internal.impl.name.a bcj() {
            return this.eAd;
        }

        public final kotlin.reflect.jvm.internal.impl.name.a bck() {
            return this.eAe;
        }

        public final kotlin.reflect.jvm.internal.impl.name.a bcl() {
            return this.eAf;
        }

        /* JADX WARNING: Missing block: B:8:0x0024, code:
            if (kotlin.jvm.internal.h.E(r2.eAf, r3.eAf) != false) goto L_0x0029;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x0029;
        L_0x0002:
            r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a;
            if (r0 == 0) goto L_0x0027;
        L_0x0006:
            r3 = (kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a) r3;
            r0 = r2.eAd;
            r1 = r3.eAd;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x0012:
            r0 = r2.eAe;
            r1 = r3.eAe;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x0027;
        L_0x001c:
            r0 = r2.eAf;
            r3 = r3.eAf;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x0027;
        L_0x0026:
            goto L_0x0029;
        L_0x0027:
            r3 = 0;
            return r3;
        L_0x0029:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.c.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            kotlin.reflect.jvm.internal.impl.name.a aVar = this.eAd;
            int i = 0;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            kotlin.reflect.jvm.internal.impl.name.a aVar2 = this.eAe;
            hashCode = (hashCode + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
            aVar2 = this.eAf;
            if (aVar2 != null) {
                i = aVar2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PlatformMutabilityMapping(javaClass=");
            stringBuilder.append(this.eAd);
            stringBuilder.append(", kotlinReadOnly=");
            stringBuilder.append(this.eAe);
            stringBuilder.append(", kotlinMutable=");
            stringBuilder.append(this.eAf);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.a aVar2, kotlin.reflect.jvm.internal.impl.name.a aVar3) {
            h.e(aVar, "javaClass");
            h.e(aVar2, "kotlinReadOnly");
            h.e(aVar3, "kotlinMutable");
            this.eAd = aVar;
            this.eAe = aVar2;
            this.eAf = aVar3;
        }

        public final kotlin.reflect.jvm.internal.impl.name.a bci() {
            return this.eAd;
        }
    }

    static {
        int i;
        kotlin.reflect.jvm.internal.impl.name.a t;
        StringBuilder stringBuilder;
        kotlin.reflect.jvm.internal.impl.name.a t2;
        c cVar = new c();
        eAc = cVar;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Kind.Function.getPackageFqName().toString());
        stringBuilder2.append(".");
        stringBuilder2.append(Kind.Function.getClassNamePrefix());
        ezS = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(Kind.KFunction.getPackageFqName().toString());
        stringBuilder2.append(".");
        stringBuilder2.append(Kind.KFunction.getClassNamePrefix());
        ezT = stringBuilder2.toString();
        a[] aVarArr = new a[8];
        kotlin.reflect.jvm.internal.impl.name.a t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyv);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.iterable)");
        b bVar = g.exC.eyD;
        h.d(bVar, "FQ_NAMES.mutableIterable");
        b packageFqName = t3.getPackageFqName();
        b packageFqName2 = t3.getPackageFqName();
        h.d(packageFqName2, "kotlinReadOnly.packageFqName");
        bVar = d.b(bVar, packageFqName2);
        int i2 = 0;
        aVarArr[0] = new a(cVar.N(Iterable.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, bVar, false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyu);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.iterator)");
        bVar = g.exC.eyC;
        h.d(bVar, "FQ_NAMES.mutableIterator");
        packageFqName = t3.getPackageFqName();
        b packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[1] = new a(cVar.N(Iterator.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyw);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.collection)");
        bVar = g.exC.eyE;
        h.d(bVar, "FQ_NAMES.mutableCollection");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[2] = new a(cVar.N(Collection.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyx);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.list)");
        bVar = g.exC.eyF;
        h.d(bVar, "FQ_NAMES.mutableList");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[3] = new a(cVar.N(List.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyz);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.set)");
        bVar = g.exC.eyH;
        h.d(bVar, "FQ_NAMES.mutableSet");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[4] = new a(cVar.N(Set.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyy);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.listIterator)");
        bVar = g.exC.eyG;
        h.d(bVar, "FQ_NAMES.mutableListIterator");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[5] = new a(cVar.N(ListIterator.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyA);
        h.d(t3, "ClassId.topLevel(FQ_NAMES.map)");
        bVar = g.exC.eyI;
        h.d(bVar, "FQ_NAMES.mutableMap");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[6] = new a(cVar.N(Map.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        t3 = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyA).B(g.exC.eyB.btN());
        h.d(t3, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
        bVar = g.exC.eyJ;
        h.d(bVar, "FQ_NAMES.mutableMapEntry");
        packageFqName = t3.getPackageFqName();
        packageFqName3 = t3.getPackageFqName();
        h.d(packageFqName3, "kotlinReadOnly.packageFqName");
        aVarArr[7] = new a(cVar.N(Entry.class), t3, new kotlin.reflect.jvm.internal.impl.name.a(packageFqName, d.b(bVar, packageFqName3), false));
        eAb = m.listOf(aVarArr);
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = g.exC.exI;
        h.d(cVar2, "FQ_NAMES.any");
        cVar.a(Object.class, cVar2);
        cVar2 = g.exC.exO;
        h.d(cVar2, "FQ_NAMES.string");
        cVar.a(String.class, cVar2);
        cVar2 = g.exC.exN;
        h.d(cVar2, "FQ_NAMES.charSequence");
        cVar.a(CharSequence.class, cVar2);
        b bVar2 = g.exC.eyb;
        h.d(bVar2, "FQ_NAMES.throwable");
        cVar.a(Throwable.class, bVar2);
        cVar2 = g.exC.exK;
        h.d(cVar2, "FQ_NAMES.cloneable");
        cVar.a(Cloneable.class, cVar2);
        cVar2 = g.exC.exY;
        h.d(cVar2, "FQ_NAMES.number");
        cVar.a(Number.class, cVar2);
        bVar2 = g.exC.eyc;
        h.d(bVar2, "FQ_NAMES.comparable");
        cVar.a(Comparable.class, bVar2);
        cVar2 = g.exC.exZ;
        h.d(cVar2, "FQ_NAMES._enum");
        cVar.a(Enum.class, cVar2);
        bVar2 = g.exC.eyl;
        h.d(bVar2, "FQ_NAMES.annotation");
        cVar.a(Annotation.class, bVar2);
        for (a a : eAb) {
            cVar.a(a);
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            kotlin.reflect.jvm.internal.impl.name.a t4 = kotlin.reflect.jvm.internal.impl.name.a.t(jvmPrimitiveType.getWrapperFqName());
            h.d(t4, "ClassId.topLevel(jvmType.wrapperFqName)");
            t = kotlin.reflect.jvm.internal.impl.name.a.t(g.d(jvmPrimitiveType.getPrimitiveType()));
            h.d(t, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
            cVar.a(t4, t);
        }
        for (kotlin.reflect.jvm.internal.impl.name.a t32 : kotlin.reflect.jvm.internal.impl.builtins.d.exk.baA()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.internal.");
            stringBuilder.append(t32.btH().asString());
            stringBuilder.append("CompanionObject");
            t2 = kotlin.reflect.jvm.internal.impl.name.a.t(new b(stringBuilder.toString()));
            h.d(t2, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
            t32 = t32.B(kotlin.reflect.jvm.internal.impl.name.h.eNq);
            h.d(t32, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            cVar.a(t2, t32);
        }
        for (i = 0; i < 23; i++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.jvm.functions.Function");
            stringBuilder.append(i);
            t2 = kotlin.reflect.jvm.internal.impl.name.a.t(new b(stringBuilder.toString()));
            h.d(t2, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
            t = g.jq(i);
            h.d(t, "KotlinBuiltIns.getFunctionClassId(i)");
            cVar.a(t2, t);
            stringBuilder = new StringBuilder();
            stringBuilder.append(ezT);
            stringBuilder.append(i);
            bVar = new b(stringBuilder.toString());
            t = ezW;
            h.d(t, "K_FUNCTION_CLASS_ID");
            cVar.a(bVar, t);
        }
        while (i2 < 22) {
            Kind kind = Kind.KSuspendFunction;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(kind.getPackageFqName().toString());
            stringBuilder3.append(".");
            stringBuilder3.append(kind.getClassNamePrefix());
            String stringBuilder4 = stringBuilder3.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder4);
            stringBuilder.append(i2);
            bVar = new b(stringBuilder.toString());
            t32 = ezW;
            h.d(t32, "K_FUNCTION_CLASS_ID");
            cVar.a(bVar, t32);
            i2++;
        }
        b btP = g.exC.exJ.btP();
        h.d(btP, "FQ_NAMES.nothing.toSafe()");
        cVar.a(btP, cVar.N(Void.class));
    }

    private c() {
    }

    public final List<a> bch() {
        return eAb;
    }

    public final kotlin.reflect.jvm.internal.impl.name.a f(b bVar) {
        h.e(bVar, "fqName");
        return (kotlin.reflect.jvm.internal.impl.name.a) ezX.get(bVar.btL());
    }

    public static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d a(c cVar, b bVar, g gVar, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = (Integer) null;
        }
        return cVar.a(bVar, gVar, num);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.d a(b bVar, g gVar, Integer num) {
        kotlin.reflect.jvm.internal.impl.name.a f;
        h.e(bVar, "fqName");
        h.e(gVar, "builtIns");
        if (num == null || !h.E(bVar, ezV)) {
            f = f(bVar);
        } else {
            f = g.jq(num.intValue());
        }
        return f != null ? gVar.d(f.btK()) : null;
    }

    public final kotlin.reflect.jvm.internal.impl.name.a c(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        h.e(cVar, "kotlinFqName");
        if (a(cVar, ezS)) {
            return ezU;
        }
        if (a(cVar, ezT)) {
            return ezW;
        }
        return (kotlin.reflect.jvm.internal.impl.name.a) ezY.get(cVar);
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.name.c cVar, String str) {
        String asString = cVar.asString();
        h.d(asString, "kotlinFqName.asString()");
        asString = v.n(asString, str, "");
        CharSequence charSequence = asString;
        boolean z = true;
        if ((charSequence.length() > 0 ? 1 : null) == null || v.a(charSequence, '0', false, 2, null)) {
            return false;
        }
        Integer nf = t.nf(asString);
        if (nf == null || nf.intValue() < 23) {
            z = false;
        }
        return z;
    }

    private final void a(a aVar) {
        kotlin.reflect.jvm.internal.impl.name.a bcj = aVar.bcj();
        kotlin.reflect.jvm.internal.impl.name.a bck = aVar.bck();
        kotlin.reflect.jvm.internal.impl.name.a bcl = aVar.bcl();
        a(bcj, bck);
        b btK = bcl.btK();
        h.d(btK, "mutableClassId.asSingleFqName()");
        a(btK, bcj);
        b btK2 = bck.btK();
        b btK3 = bcl.btK();
        ezZ.put(bcl.btK().btL(), btK2);
        eAa.put(btK2.btL(), btK3);
    }

    private final void a(kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.a aVar2) {
        b(aVar, aVar2);
        b btK = aVar2.btK();
        h.d(btK, "kotlinClassId.asSingleFqName()");
        a(btK, aVar);
    }

    private final void a(Class<?> cls, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        b btP = cVar.btP();
        h.d(btP, "kotlinFqName.toSafe()");
        a((Class) cls, btP);
    }

    private final void a(Class<?> cls, b bVar) {
        kotlin.reflect.jvm.internal.impl.name.a N = N(cls);
        kotlin.reflect.jvm.internal.impl.name.a t = kotlin.reflect.jvm.internal.impl.name.a.t(bVar);
        h.d(t, "ClassId.topLevel(kotlinFqName)");
        a(N, t);
    }

    private final void b(kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.a aVar2) {
        ezX.put(aVar.btK().btL(), aVar2);
    }

    private final void a(b bVar, kotlin.reflect.jvm.internal.impl.name.a aVar) {
        ezY.put(bVar.btL(), aVar);
    }

    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(b bVar, g gVar) {
        h.e(bVar, "fqName");
        h.e(gVar, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.d a = a(this, bVar, gVar, null, 4, null);
        if (a == null) {
            return aj.emptySet();
        }
        if (((b) eAa.get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(a))) == null) {
            return ai.cu(a);
        }
        List asList = Arrays.asList(new kotlin.reflect.jvm.internal.impl.descriptors.d[]{a, gVar.d((b) eAa.get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(a)))});
        h.d(asList, "Arrays.asList(kotlinAnal…tlinMutableAnalogFqName))");
        return asList;
    }

    public final boolean h(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "mutable");
        return ezZ.containsKey(kotlin.reflect.jvm.internal.impl.resolve.c.w(dVar));
    }

    public final boolean J(w wVar) {
        h.e(wVar, Param.TYPE);
        kotlin.reflect.jvm.internal.impl.descriptors.d aZ = au.aZ(wVar);
        return aZ != null && h(aZ);
    }

    public final boolean i(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "readOnly");
        return eAa.containsKey(kotlin.reflect.jvm.internal.impl.resolve.c.w(dVar));
    }

    public final boolean K(w wVar) {
        h.e(wVar, Param.TYPE);
        kotlin.reflect.jvm.internal.impl.descriptors.d aZ = au.aZ(wVar);
        return aZ != null && i(aZ);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.d j(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "mutable");
        return a(dVar, (Map) ezZ, "mutable");
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.d k(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "readOnly");
        return a(dVar, (Map) eAa, "read-only");
    }

    private final kotlin.reflect.jvm.internal.impl.name.a N(Class<?> cls) {
        Object obj = (cls.isPrimitive() || cls.isArray()) ? null : 1;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid class: ");
            stringBuilder.append(cls);
            throw new AssertionError(stringBuilder.toString());
        }
        Class declaringClass = cls.getDeclaringClass();
        kotlin.reflect.jvm.internal.impl.name.a t;
        if (declaringClass == null) {
            t = kotlin.reflect.jvm.internal.impl.name.a.t(new b(cls.getCanonicalName()));
            h.d(t, "ClassId.topLevel(FqName(clazz.canonicalName))");
            return t;
        }
        t = N(declaringClass).B(f.mD(cls.getSimpleName()));
        h.d(t, "classId(outer).createNes…tifier(clazz.simpleName))");
        return t;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, Map<kotlin.reflect.jvm.internal.impl.name.c, b> map, String str) {
        k kVar = dVar;
        b bVar = (b) map.get(kotlin.reflect.jvm.internal.impl.resolve.c.w(kVar));
        if (bVar != null) {
            dVar = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(kVar).d(bVar);
            h.d(dVar, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return dVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Given class ");
        stringBuilder.append(dVar);
        stringBuilder.append(" is not a ");
        stringBuilder.append(str);
        stringBuilder.append(" collection");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
