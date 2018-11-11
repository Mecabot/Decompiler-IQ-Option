package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: MemberScope.kt */
public final class d {
    private static int eRG = 1;
    private static final int eRH = eSd.nextMask();
    private static final int eRI = eSd.nextMask();
    private static final int eRJ = eSd.nextMask();
    private static final int eRK = eSd.nextMask();
    private static final int eRL = eSd.nextMask();
    private static final int eRM = eSd.nextMask();
    private static final int eRN = (eSd.nextMask() - 1);
    private static final int eRO = ((eRH | eRI) | eRJ);
    private static final int eRP = ((eRI | eRL) | eRM);
    private static final int eRQ = (eRL | eRM);
    public static final d eRR = new d(eRN, null, 2, null);
    public static final d eRS = new d(eRQ, null, 2, null);
    public static final d eRT = new d(eRH, null, 2, null);
    public static final d eRU = new d(eRI, null, 2, null);
    public static final d eRV = new d(eRJ, null, 2, null);
    public static final d eRW = new d(eRO, null, 2, null);
    public static final d eRX = new d(eRK, null, 2, null);
    public static final d eRY = new d(eRL, null, 2, null);
    public static final d eRZ = new d(eRM, null, 2, null);
    public static final d eSa = new d(eRP, null, 2, null);
    private static final List<a> eSb;
    private static final List<a> eSc;
    public static final a eSd = new a();
    private final int eRE;
    private final List<c> eRF;

    /* compiled from: MemberScope.kt */
    public static final class a {

        /* compiled from: MemberScope.kt */
        private static final class a {
            private final int mask;
            private final String name;

            public a(int i, String str) {
                h.e(str, "name");
                this.mask = i;
                this.name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final int nextMask() {
            int bwP = d.eRG;
            d.eRG = d.eRG << 1;
            return bwP;
        }

        public final int bwY() {
            return d.eRH;
        }

        public final int bwZ() {
            return d.eRI;
        }

        public final int bxa() {
            return d.eRJ;
        }

        public final int bxb() {
            return d.eRK;
        }

        public final int bxc() {
            return d.eRL;
        }

        public final int bxd() {
            return d.eRM;
        }

        public final int bxe() {
            return d.eRN;
        }

        public final int bxf() {
            return d.eRO;
        }
    }

    public d(int i, List<? extends c> list) {
        h.e(list, "excludes");
        this.eRF = list;
        for (c bwM : this.eRF) {
            i &= bwM.bwM() ^ -1;
        }
        this.eRE = i;
    }

    public /* synthetic */ d(int i, List list, int i2, f fVar) {
        if ((i2 & 2) != 0) {
            list = m.emptyList();
        }
        this(i, list);
    }

    public final List<c> bwO() {
        return this.eRF;
    }

    public final int bwN() {
        return this.eRE;
    }

    public final boolean lR(int i) {
        return (i & this.eRE) != 0;
    }

    public final d lS(int i) {
        i &= this.eRE;
        if (i == 0) {
            return null;
        }
        return new d(i, this.eRF);
    }

    public String toString() {
        Object obj;
        for (Object next : eSb) {
            if (((a) next).getMask() == this.eRE) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj != null) {
                break;
            }
        }
        Object next2 = null;
        a aVar = (a) next2;
        String name = aVar != null ? aVar.getName() : null;
        if (name == null) {
            Collection arrayList = new ArrayList();
            for (a aVar2 : eSc) {
                obj = lR(aVar2.getMask()) ? aVar2.getName() : null;
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            name = u.a((List) arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DescriptorKindFilter(");
        stringBuilder.append(name);
        stringBuilder.append(", ");
        stringBuilder.append(this.eRF);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    static {
        int i;
        Object obj;
        String name;
        Object aVar;
        a aVar2 = eSd;
        Object fields = d.class.getFields();
        h.d(fields, "T::class.java.fields");
        Collection arrayList = new ArrayList();
        for (Field field : fields) {
            h.d(field, "it");
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Field field2 : (List) arrayList) {
            obj = field2.get(null);
            if (!(obj instanceof d)) {
                obj = null;
            }
            d dVar = (d) obj;
            if (dVar != null) {
                i = dVar.eRE;
                h.d(field2, "field");
                name = field2.getName();
                h.d(name, "field.name");
                aVar = new a(i, name);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        eSb = u.W((List) arrayList2);
        aVar2 = eSd;
        fields = d.class.getFields();
        h.d(fields, "T::class.java.fields");
        arrayList = new ArrayList();
        for (Field field3 : fields) {
            h.d(field3, "it");
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList.add(field3);
            }
        }
        arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            Field field4 = (Field) next;
            h.d(field4, "it");
            if (h.E(field4.getType(), Integer.TYPE)) {
                arrayList2.add(next);
            }
        }
        arrayList = new ArrayList();
        for (Field field22 : (List) arrayList2) {
            obj = field22.get(null);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            i = ((Integer) obj).intValue();
            if ((i == ((-i) & i) ? 1 : null) != null) {
                h.d(field22, "field");
                name = field22.getName();
                h.d(name, "field.name");
                aVar = new a(i, name);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        eSc = u.W((List) arrayList);
    }
}
