package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: ClassDeserializer.kt */
public final class f {
    private static final Set<kotlin.reflect.jvm.internal.impl.name.a> eSF = ai.cu(kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.exK.btP()));
    public static final b eSG = new b();
    private final h eJC;
    private final kotlin.jvm.a.b<a, d> eSE = this.eJC.baI().p(new ClassDeserializer$classes$1(this));

    /* compiled from: ClassDeserializer.kt */
    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.name.a classId;
        private final d eSH;

        public a(kotlin.reflect.jvm.internal.impl.name.a aVar, d dVar) {
            h.e(aVar, "classId");
            this.classId = aVar;
            this.eSH = dVar;
        }

        public final d bxr() {
            return this.eSH;
        }

        public final kotlin.reflect.jvm.internal.impl.name.a getClassId() {
            return this.classId;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && h.E(this.classId, ((a) obj).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public f(h hVar) {
        h.e(hVar, "components");
        this.eJC = hVar;
    }

    public static /* bridge */ /* synthetic */ d a(f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar, d dVar, int i, Object obj) {
        if ((i & 2) != 0) {
            dVar = (d) null;
        }
        return fVar.a(aVar, dVar);
    }

    public final d a(kotlin.reflect.jvm.internal.impl.name.a aVar, d dVar) {
        h.e(aVar, "classId");
        return (d) this.eSE.invoke(new a(aVar, dVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd A:{SYNTHETIC, EDGE_INSN: B:47:0x00bd->B:37:0x00bd ?: BREAK  } */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.f.a r13) {
        /*
        r12 = this;
        r0 = r13.getClassId();
        r1 = r12.eJC;
        r1 = r1.bxA();
        r1 = r1.iterator();
    L_0x000e:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0021;
    L_0x0014:
        r2 = r1.next();
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a.b) r2;
        r2 = r2.e(r0);
        if (r2 == 0) goto L_0x000e;
    L_0x0020:
        return r2;
    L_0x0021:
        r1 = eSF;
        r1 = r1.contains(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x002b;
    L_0x002a:
        return r2;
    L_0x002b:
        r13 = r13.bxr();
        if (r13 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x003c;
    L_0x0032:
        r13 = r12.eJC;
        r13 = r13.bxw();
        r13 = r13.i(r0);
    L_0x003c:
        if (r13 == 0) goto L_0x00f6;
    L_0x003e:
        r1 = r13.bxn();
        r10 = r13.bxo();
        r11 = r13.bxp();
        r13 = r13.bxq();
        r3 = r0.btI();
        if (r3 == 0) goto L_0x007a;
    L_0x0054:
        r4 = 2;
        r3 = a(r12, r3, r2, r4, r2);
        r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
        if (r4 != 0) goto L_0x005e;
    L_0x005d:
        r3 = r2;
    L_0x005e:
        r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) r3;
        if (r3 == 0) goto L_0x0079;
    L_0x0062:
        r0 = r0.btH();
        r4 = "classId.shortClassName";
        kotlin.jvm.internal.h.d(r0, r4);
        r0 = r3.O(r0);
        if (r0 != 0) goto L_0x0072;
    L_0x0071:
        return r2;
    L_0x0072:
        r0 = r3.bxX();
    L_0x0076:
        r4 = r0;
        goto L_0x00e8;
    L_0x0079:
        return r2;
    L_0x007a:
        r3 = r12.eJC;
        r3 = r3.beV();
        r4 = r0.getPackageFqName();
        r5 = "classId.packageFqName";
        kotlin.jvm.internal.h.d(r4, r5);
        r3 = r3.i(r4);
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x0093:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x00bc;
    L_0x0099:
        r4 = r3.next();
        r5 = r4;
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.x) r5;
        r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.k;
        if (r6 == 0) goto L_0x00b8;
    L_0x00a4:
        r5 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.k) r5;
        r6 = r0.btH();
        r7 = "classId.shortClassName";
        kotlin.jvm.internal.h.d(r6, r7);
        r5 = r5.N(r6);
        if (r5 == 0) goto L_0x00b6;
    L_0x00b5:
        goto L_0x00b8;
    L_0x00b6:
        r5 = 0;
        goto L_0x00b9;
    L_0x00b8:
        r5 = 1;
    L_0x00b9:
        if (r5 == 0) goto L_0x0093;
    L_0x00bb:
        goto L_0x00bd;
    L_0x00bc:
        r4 = r2;
    L_0x00bd:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.x) r4;
        if (r4 == 0) goto L_0x00f5;
    L_0x00c1:
        r3 = r12.eJC;
        r6 = new kotlin.reflect.jvm.internal.impl.metadata.a.h;
        r0 = r10.bkF();
        r2 = "classProto.typeTable";
        kotlin.jvm.internal.h.d(r0, r2);
        r6.<init>(r0);
        r0 = kotlin.reflect.jvm.internal.impl.metadata.a.k.eMf;
        r2 = r10.bkI();
        r5 = "classProto.versionRequirementTable";
        kotlin.jvm.internal.h.d(r2, r5);
        r7 = r0.g(r2);
        r9 = 0;
        r5 = r1;
        r8 = r11;
        r0 = r3.a(r4, r5, r6, r7, r8, r9);
        goto L_0x0076;
    L_0x00e8:
        r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
        r3 = r0;
        r5 = r10;
        r6 = r1;
        r7 = r11;
        r8 = r13;
        r3.<init>(r4, r5, r6, r7, r8);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.d) r0;
        return r0;
    L_0x00f5:
        return r2;
    L_0x00f6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.f.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.f$a):kotlin.reflect.jvm.internal.impl.descriptors.d");
    }
}
