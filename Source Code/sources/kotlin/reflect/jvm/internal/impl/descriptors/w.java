package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.z;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e;

/* compiled from: NotFoundClasses.kt */
public final class w {
    private final kotlin.reflect.jvm.internal.impl.storage.b<kotlin.reflect.jvm.internal.impl.name.b, x> eAO = this.exB.o(new NotFoundClasses$packageFragments$1(this));
    private final kotlin.reflect.jvm.internal.impl.storage.b<a, d> eAP = this.exB.o(new NotFoundClasses$classes$1(this));
    private final h exB;
    private final u ezG;

    /* compiled from: NotFoundClasses.kt */
    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.name.a classId;
        private final List<Integer> eAQ;

        public final kotlin.reflect.jvm.internal.impl.name.a bcj() {
            return this.classId;
        }

        public final List<Integer> bdz() {
            return this.eAQ;
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (kotlin.jvm.internal.h.E(r2.eAQ, r3.eAQ) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r2 == r3) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.w.a;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r3 = (kotlin.reflect.jvm.internal.impl.descriptors.w.a) r3;
            r0 = r2.classId;
            r1 = r3.classId;
            r0 = kotlin.jvm.internal.h.E(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.eAQ;
            r3 = r3.eAQ;
            r3 = kotlin.jvm.internal.h.E(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            return r3;
        L_0x001f:
            r3 = 1;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.w.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            kotlin.reflect.jvm.internal.impl.name.a aVar = this.classId;
            int i = 0;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            List list = this.eAQ;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassRequest(classId=");
            stringBuilder.append(this.classId);
            stringBuilder.append(", typeParametersCount=");
            stringBuilder.append(this.eAQ);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public a(kotlin.reflect.jvm.internal.impl.name.a aVar, List<Integer> list) {
            kotlin.jvm.internal.h.e(aVar, "classId");
            kotlin.jvm.internal.h.e(list, "typeParametersCount");
            this.classId = aVar;
            this.eAQ = list;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class b extends g {
        private final List<an> eAR;
        private final e eAS;
        private final boolean eAT;

        public d bbC() {
            return null;
        }

        public c bbI() {
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

        public boolean isExternal() {
            return false;
        }

        public b(h hVar, k kVar, f fVar, boolean z, int i) {
            kotlin.jvm.internal.h.e(hVar, "storageManager");
            kotlin.jvm.internal.h.e(kVar, "container");
            kotlin.jvm.internal.h.e(fVar, "name");
            super(hVar, kVar, fVar, ai.eAX, false);
            this.eAT = z;
            Iterable bd = j.bd(0, i);
            Collection arrayList = new ArrayList(n.e(bd, 10));
            Iterator it = bd.iterator();
            while (it.hasNext()) {
                int nextInt = ((z) it).nextInt();
                k kVar2 = this;
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bel = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
                Variance variance = Variance.INVARIANT;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('T');
                stringBuilder.append(nextInt);
                arrayList.add(ag.a(kVar2, bel, false, variance, f.mD(stringBuilder.toString()), nextInt));
            }
            this.eAR = (List) arrayList;
            this.eAS = new e(this, this.eAR, ai.cu(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.P(this).bdy().baU()), hVar);
        }

        public ClassKind bbF() {
            return ClassKind.CLASS;
        }

        public Modality bbG() {
            return Modality.FINAL;
        }

        public av bbJ() {
            return au.eBg;
        }

        /* renamed from: bdA */
        public e bby() {
            return this.eAS;
        }

        public List<an> bbS() {
            return this.eAR;
        }

        public boolean bbL() {
            return this.eAT;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g bbQ() {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel();
        }

        /* renamed from: bdB */
        public c bbA() {
            return c.eSm;
        }

        /* renamed from: bbw */
        public c bbx() {
            return c.eSm;
        }

        public Collection<c> bbE() {
            return aj.emptySet();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("class ");
            stringBuilder.append(bdc());
            stringBuilder.append(" (not found)");
            return stringBuilder.toString();
        }
    }

    public w(h hVar, u uVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(uVar, "module");
        this.exB = hVar;
        this.ezG = uVar;
    }

    public final d a(kotlin.reflect.jvm.internal.impl.name.a aVar, List<Integer> list) {
        kotlin.jvm.internal.h.e(aVar, "classId");
        kotlin.jvm.internal.h.e(list, "typeParametersCount");
        return (d) this.eAP.invoke(new a(aVar, list));
    }
}
