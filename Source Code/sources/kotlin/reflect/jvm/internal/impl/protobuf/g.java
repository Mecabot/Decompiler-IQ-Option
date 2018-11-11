package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType;

/* compiled from: FieldSet */
final class g<FieldDescriptorType extends a<FieldDescriptorType>> {
    private static final g eNS = new g(true);
    private final s<FieldDescriptorType, Object> eNP = s.lL(16);
    private boolean eNQ;
    private boolean eNR = false;

    /* compiled from: FieldSet */
    public interface a<T extends a<T>> extends Comparable<T> {
        kotlin.reflect.jvm.internal.impl.protobuf.n.a a(kotlin.reflect.jvm.internal.impl.protobuf.n.a aVar, n nVar);

        FieldType buI();

        JavaType buJ();

        boolean buK();

        boolean buL();

        int getNumber();
    }

    private g() {
    }

    private g(boolean z) {
        makeImmutable();
    }

    public static <T extends a<T>> g<T> buF() {
        return new g();
    }

    public static <T extends a<T>> g<T> buG() {
        return eNS;
    }

    public void makeImmutable() {
        if (!this.eNQ) {
            this.eNP.makeImmutable();
            this.eNQ = true;
        }
    }

    /* renamed from: buH */
    public g<FieldDescriptorType> clone() {
        Entry lM;
        g<FieldDescriptorType> buF = buF();
        for (int i = 0; i < this.eNP.bvn(); i++) {
            lM = this.eNP.lM(i);
            buF.a((a) lM.getKey(), lM.getValue());
        }
        for (Entry lM2 : this.eNP.bvo()) {
            buF.a((a) lM2.getKey(), lM2.getValue());
        }
        buF.eNR = this.eNR;
        return buF;
    }

    public Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.eNR) {
            return new b(this.eNP.entrySet().iterator());
        }
        return this.eNP.entrySet().iterator();
    }

    public boolean a(FieldDescriptorType fieldDescriptorType) {
        if (!fieldDescriptorType.buK()) {
            return this.eNP.get(fieldDescriptorType) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public Object b(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.eNP.get(fieldDescriptorType);
        return obj instanceof i ? ((i) obj).bvg() : obj;
    }

    public void a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.buK()) {
            a(fieldDescriptorType.buI(), obj);
        } else if (obj instanceof List) {
            List<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                a(fieldDescriptorType.buI(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof i) {
            this.eNR = true;
        }
        this.eNP.put((Comparable) fieldDescriptorType, obj);
    }

    public int c(FieldDescriptorType fieldDescriptorType) {
        if (fieldDescriptorType.buK()) {
            Object b = b(fieldDescriptorType);
            if (b == null) {
                return 0;
            }
            return ((List) b).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object a(FieldDescriptorType fieldDescriptorType, int i) {
        if (fieldDescriptorType.buK()) {
            Object b = b(fieldDescriptorType);
            if (b != null) {
                return ((List) b).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void b(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (fieldDescriptorType.buK()) {
            List arrayList;
            a(fieldDescriptorType.buI(), obj);
            Object b = b(fieldDescriptorType);
            if (b == null) {
                arrayList = new ArrayList();
                this.eNP.put((Comparable) fieldDescriptorType, (Object) arrayList);
            } else {
                arrayList = (List) b;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* JADX WARNING: Missing block: B:8:0x0020, code:
            if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.i) == false) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:9:0x0022, code:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:13:0x002a, code:
            if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a) == false) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:17:0x0033, code:
            if ((r3 instanceof byte[]) == false) goto L_0x0047;
     */
    private static void a(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType r2, java.lang.Object r3) {
        /*
        if (r3 != 0) goto L_0x0008;
    L_0x0002:
        r2 = new java.lang.NullPointerException;
        r2.<init>();
        throw r2;
    L_0x0008:
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.g.AnonymousClass1.eNT;
        r2 = r2.getJavaType();
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0045;
            case 2: goto L_0x0042;
            case 3: goto L_0x003f;
            case 4: goto L_0x003c;
            case 5: goto L_0x0039;
            case 6: goto L_0x0036;
            case 7: goto L_0x002d;
            case 8: goto L_0x0024;
            case 9: goto L_0x001a;
            default: goto L_0x0019;
        };
    L_0x0019:
        goto L_0x0047;
    L_0x001a:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.n;
        if (r2 != 0) goto L_0x0022;
    L_0x001e:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.i;
        if (r2 == 0) goto L_0x0047;
    L_0x0022:
        r1 = 1;
        goto L_0x0047;
    L_0x0024:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0022;
    L_0x0028:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a;
        if (r2 == 0) goto L_0x0047;
    L_0x002c:
        goto L_0x0022;
    L_0x002d:
        r2 = r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.d;
        if (r2 != 0) goto L_0x0022;
    L_0x0031:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0047;
    L_0x0035:
        goto L_0x0022;
    L_0x0036:
        r1 = r3 instanceof java.lang.String;
        goto L_0x0047;
    L_0x0039:
        r1 = r3 instanceof java.lang.Boolean;
        goto L_0x0047;
    L_0x003c:
        r1 = r3 instanceof java.lang.Double;
        goto L_0x0047;
    L_0x003f:
        r1 = r3 instanceof java.lang.Float;
        goto L_0x0047;
    L_0x0042:
        r1 = r3 instanceof java.lang.Long;
        goto L_0x0047;
    L_0x0045:
        r1 = r3 instanceof java.lang.Integer;
    L_0x0047:
        if (r1 != 0) goto L_0x0051;
    L_0x0049:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
    L_0x0051:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.g.a(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.eNP.bvn(); i++) {
            if (!k(this.eNP.lM(i))) {
                return false;
            }
        }
        for (Entry k : this.eNP.bvo()) {
            if (!k(k)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(Entry<FieldDescriptorType, Object> entry) {
        a aVar = (a) entry.getKey();
        if (aVar.buJ() == JavaType.MESSAGE) {
            if (aVar.buK()) {
                for (n isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof n) {
                if (!((n) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof i) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    static int a(FieldType fieldType, boolean z) {
        return z ? 2 : fieldType.getWireType();
    }

    public void a(g<FieldDescriptorType> gVar) {
        for (int i = 0; i < gVar.eNP.bvn(); i++) {
            l(gVar.eNP.lM(i));
        }
        for (Entry l : gVar.eNP.bvo()) {
            l(l);
        }
    }

    private Object cU(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    private void l(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (a) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i) {
            value = ((i) value).bvg();
        }
        Object b;
        if (comparable.buK()) {
            b = b(comparable);
            if (b == null) {
                b = new ArrayList();
            }
            for (Object cU : (List) value) {
                ((List) b).add(cU(cU));
            }
            this.eNP.put(comparable, b);
        } else if (comparable.buJ() == JavaType.MESSAGE) {
            b = b(comparable);
            if (b == null) {
                this.eNP.put(comparable, cU(value));
                return;
            }
            this.eNP.put(comparable, comparable.a(((n) b).bjf(), (n) value).bjx());
        } else {
            this.eNP.put(comparable, cU(value));
        }
    }

    public static Object a(e eVar, FieldType fieldType, boolean z) {
        switch (fieldType) {
            case DOUBLE:
                return Double.valueOf(eVar.readDouble());
            case FLOAT:
                return Float.valueOf(eVar.readFloat());
            case INT64:
                return Long.valueOf(eVar.bug());
            case UINT64:
                return Long.valueOf(eVar.buf());
            case INT32:
                return Integer.valueOf(eVar.buh());
            case FIXED64:
                return Long.valueOf(eVar.bui());
            case FIXED32:
                return Integer.valueOf(eVar.buj());
            case BOOL:
                return Boolean.valueOf(eVar.buk());
            case STRING:
                if (z) {
                    return eVar.bul();
                }
                return eVar.readString();
            case BYTES:
                return eVar.bum();
            case UINT32:
                return Integer.valueOf(eVar.bun());
            case SFIXED32:
                return Integer.valueOf(eVar.bup());
            case SFIXED64:
                return Long.valueOf(eVar.buq());
            case SINT32:
                return Integer.valueOf(eVar.bur());
            case SINT64:
                return Long.valueOf(eVar.bus());
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void a(CodedOutputStream codedOutputStream, FieldType fieldType, int i, Object obj) {
        if (fieldType == FieldType.GROUP) {
            codedOutputStream.a(i, (n) obj);
            return;
        }
        codedOutputStream.p(i, a(fieldType, false));
        a(codedOutputStream, fieldType, obj);
    }

    private static void a(CodedOutputStream codedOutputStream, FieldType fieldType, Object obj) {
        switch (fieldType) {
            case DOUBLE:
                codedOutputStream.Z(((Double) obj).doubleValue());
                return;
            case FLOAT:
                codedOutputStream.k(((Float) obj).floatValue());
                return;
            case INT64:
                codedOutputStream.da(((Long) obj).longValue());
                return;
            case UINT64:
                codedOutputStream.n(((Long) obj).longValue());
                return;
            case INT32:
                codedOutputStream.s(((Integer) obj).intValue());
                return;
            case FIXED64:
                codedOutputStream.db(((Long) obj).longValue());
                return;
            case FIXED32:
                codedOutputStream.lE(((Integer) obj).intValue());
                return;
            case BOOL:
                codedOutputStream.D(((Boolean) obj).booleanValue());
                return;
            case STRING:
                codedOutputStream.mJ((String) obj);
                return;
            case BYTES:
                if (obj instanceof d) {
                    codedOutputStream.b((d) obj);
                    return;
                } else {
                    codedOutputStream.af((byte[]) obj);
                    return;
                }
            case UINT32:
                codedOutputStream.t(((Integer) obj).intValue());
                return;
            case SFIXED32:
                codedOutputStream.lF(((Integer) obj).intValue());
                return;
            case SFIXED64:
                codedOutputStream.dc(((Long) obj).longValue());
                return;
            case SINT32:
                codedOutputStream.v(((Integer) obj).intValue());
                return;
            case SINT64:
                codedOutputStream.dd(((Long) obj).longValue());
                return;
            case GROUP:
                codedOutputStream.c((n) obj);
                return;
            case MESSAGE:
                codedOutputStream.d((n) obj);
                return;
            case ENUM:
                if (obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a) {
                    codedOutputStream.u(((kotlin.reflect.jvm.internal.impl.protobuf.h.a) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.u(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void a(a<?> aVar, Object obj, CodedOutputStream codedOutputStream) {
        FieldType buI = aVar.buI();
        int number = aVar.getNumber();
        if (aVar.buK()) {
            List<Object> list = (List) obj;
            if (aVar.buL()) {
                codedOutputStream.p(number, 2);
                int i = 0;
                for (Object b : list) {
                    i += b(buI, b);
                }
                codedOutputStream.C(i);
                for (Object obj2 : list) {
                    a(codedOutputStream, buI, obj2);
                }
                return;
            }
            for (Object obj22 : list) {
                a(codedOutputStream, buI, number, obj22);
            }
        } else if (obj22 instanceof i) {
            a(codedOutputStream, buI, number, ((i) obj22).bvg());
        } else {
            a(codedOutputStream, buI, number, obj22);
        }
    }

    public int bjb() {
        Entry lM;
        int i = 0;
        for (int i2 = 0; i2 < this.eNP.bvn(); i2++) {
            lM = this.eNP.lM(i2);
            i += c((a) lM.getKey(), lM.getValue());
        }
        for (Entry lM2 : this.eNP.bvo()) {
            i += c((a) lM2.getKey(), lM2.getValue());
        }
        return i;
    }

    private static int a(FieldType fieldType, int i, Object obj) {
        i = CodedOutputStream.B(i);
        if (fieldType == FieldType.GROUP) {
            i *= 2;
        }
        return i + b(fieldType, obj);
    }

    private static int b(FieldType fieldType, Object obj) {
        switch (fieldType) {
            case DOUBLE:
                return CodedOutputStream.aa(((Double) obj).doubleValue());
            case FLOAT:
                return CodedOutputStream.l(((Float) obj).floatValue());
            case INT64:
                return CodedOutputStream.de(((Long) obj).longValue());
            case UINT64:
                return CodedOutputStream.o(((Long) obj).longValue());
            case INT32:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case FIXED64:
                return CodedOutputStream.df(((Long) obj).longValue());
            case FIXED32:
                return CodedOutputStream.lG(((Integer) obj).intValue());
            case BOOL:
                return CodedOutputStream.E(((Boolean) obj).booleanValue());
            case STRING:
                return CodedOutputStream.mK((String) obj);
            case BYTES:
                if (obj instanceof d) {
                    return CodedOutputStream.c((d) obj);
                }
                return CodedOutputStream.ag((byte[]) obj);
            case UINT32:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case SFIXED32:
                return CodedOutputStream.lH(((Integer) obj).intValue());
            case SFIXED64:
                return CodedOutputStream.dg(((Long) obj).longValue());
            case SINT32:
                return CodedOutputStream.z(((Integer) obj).intValue());
            case SINT64:
                return CodedOutputStream.dh(((Long) obj).longValue());
            case GROUP:
                return CodedOutputStream.e((n) obj);
            case MESSAGE:
                if (obj instanceof i) {
                    return CodedOutputStream.a((i) obj);
                }
                return CodedOutputStream.f((n) obj);
            case ENUM:
                if (obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.h.a) {
                    return CodedOutputStream.y(((kotlin.reflect.jvm.internal.impl.protobuf.h.a) obj).getNumber());
                }
                return CodedOutputStream.y(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        FieldType buI = aVar.buI();
        int number = aVar.getNumber();
        if (!aVar.buK()) {
            return a(buI, number, obj);
        }
        int i = 0;
        if (aVar.buL()) {
            for (Object obj2 : (List) obj2) {
                i += b(buI, obj2);
            }
            return (CodedOutputStream.B(number) + i) + CodedOutputStream.D(i);
        }
        for (Object obj22 : (List) obj22) {
            i += a(buI, number, obj22);
        }
        return i;
    }
}
