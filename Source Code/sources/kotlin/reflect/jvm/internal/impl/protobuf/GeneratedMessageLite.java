package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.JavaType;

public abstract class GeneratedMessageLite extends a implements Serializable {

    public static class e<ContainingType extends n, Type> {
        final Type defaultValue;
        final ContainingType eOd;
        final n eOe;
        final d eOf;
        final Class eOg;
        final Method eOh;

        e(ContainingType containingType, Type type, n nVar, d dVar, Class cls) {
            if (containingType == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.buI() == FieldType.MESSAGE && nVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.eOd = containingType;
                this.defaultValue = type;
                this.eOe = nVar;
                this.eOf = dVar;
                this.eOg = cls;
                if (kotlin.reflect.jvm.internal.impl.protobuf.h.a.class.isAssignableFrom(cls)) {
                    this.eOh = GeneratedMessageLite.b(cls, "valueOf", Integer.TYPE);
                    return;
                }
                this.eOh = null;
            }
        }

        public ContainingType buU() {
            return this.eOd;
        }

        public int getNumber() {
            return this.eOf.getNumber();
        }

        public n buV() {
            return this.eOe;
        }

        Object cV(Object obj) {
            if (!this.eOf.buK()) {
                return cW(obj);
            }
            if (this.eOf.buJ() != JavaType.ENUM) {
                return obj;
            }
            List arrayList = new ArrayList();
            for (Object cW : (List) obj) {
                arrayList.add(cW(cW));
            }
            return arrayList;
        }

        Object cW(Object obj) {
            if (this.eOf.buJ() != JavaType.ENUM) {
                return obj;
            }
            return GeneratedMessageLite.a(this.eOh, null, (Integer) obj);
        }

        Object cX(Object obj) {
            return this.eOf.buJ() == JavaType.ENUM ? Integer.valueOf(((kotlin.reflect.jvm.internal.impl.protobuf.h.a) obj).getNumber()) : obj;
        }
    }

    public interface c extends o {
    }

    static final class d implements kotlin.reflect.jvm.internal.impl.protobuf.g.a<d> {
        final kotlin.reflect.jvm.internal.impl.protobuf.h.b<?> eNZ;
        final FieldType eOa;
        final boolean eOb;
        final boolean eOc;
        final int number;

        d(kotlin.reflect.jvm.internal.impl.protobuf.h.b<?> bVar, int i, FieldType fieldType, boolean z, boolean z2) {
            this.eNZ = bVar;
            this.number = i;
            this.eOa = fieldType;
            this.eOb = z;
            this.eOc = z2;
        }

        public int getNumber() {
            return this.number;
        }

        public FieldType buI() {
            return this.eOa;
        }

        public JavaType buJ() {
            return this.eOa.getJavaType();
        }

        public boolean buK() {
            return this.eOb;
        }

        public boolean buL() {
            return this.eOc;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.h.b<?> buT() {
            return this.eNZ;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.n.a a(kotlin.reflect.jvm.internal.impl.protobuf.n.a aVar, n nVar) {
            return ((a) aVar).a((GeneratedMessageLite) nVar);
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.number - dVar.number;
        }
    }

    public static abstract class a<MessageType extends GeneratedMessageLite, BuilderType extends a> extends kotlin.reflect.jvm.internal.impl.protobuf.a.a<BuilderType> {
        private d unknownFields = d.eNx;

        public abstract BuilderType a(MessageType messageType);

        /* renamed from: bju */
        public abstract MessageType bjh();

        protected a() {
        }

        /* renamed from: bjv */
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final d buN() {
            return this.unknownFields;
        }

        public final BuilderType e(d dVar) {
            this.unknownFields = dVar;
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements c<MessageType> {
        private final g<d> extensions;

        protected class a {
            private Entry<d, Object> eNW;
            private final boolean eNX;
            private final Iterator<Entry<d, Object>> iter;

            private a(boolean z) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.eNW = (Entry) this.iter.next();
                }
                this.eNX = z;
            }

            public void b(int i, CodedOutputStream codedOutputStream) {
                while (this.eNW != null && ((d) this.eNW.getKey()).getNumber() < i) {
                    kotlin.reflect.jvm.internal.impl.protobuf.g.a aVar = (d) this.eNW.getKey();
                    if (this.eNX && aVar.buJ() == JavaType.MESSAGE && !aVar.buK()) {
                        codedOutputStream.c(aVar.getNumber(), (n) this.eNW.getValue());
                    } else {
                        g.a(aVar, this.eNW.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.eNW = (Entry) this.iter.next();
                    } else {
                        this.eNW = null;
                    }
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = g.buF();
        }

        protected ExtendableMessage(b<MessageType, ?> bVar) {
            this.extensions = bVar.buP();
        }

        private void b(e<MessageType, ?> eVar) {
            if (eVar.buU() != bjh()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean c(e<MessageType, Type> eVar) {
            b((e) eVar);
            return this.extensions.a(eVar.eOf);
        }

        public final <Type> int d(e<MessageType, List<Type>> eVar) {
            b((e) eVar);
            return this.extensions.c(eVar.eOf);
        }

        public final <Type> Type e(e<MessageType, Type> eVar) {
            b((e) eVar);
            Object b = this.extensions.b(eVar.eOf);
            if (b == null) {
                return eVar.defaultValue;
            }
            return eVar.cV(b);
        }

        public final <Type> Type a(e<MessageType, List<Type>> eVar, int i) {
            b((e) eVar);
            return eVar.cW(this.extensions.a(eVar.eOf, i));
        }

        protected boolean buQ() {
            return this.extensions.isInitialized();
        }

        protected boolean a(e eVar, CodedOutputStream codedOutputStream, f fVar, int i) {
            return GeneratedMessageLite.a(this.extensions, bjh(), eVar, codedOutputStream, fVar, i);
        }

        protected void buM() {
            this.extensions.makeImmutable();
        }

        protected a buR() {
            return new a(false);
        }

        protected int buS() {
            return this.extensions.bjb();
        }
    }

    public static abstract class b<MessageType extends ExtendableMessage<MessageType>, BuilderType extends b<MessageType, BuilderType>> extends a<MessageType, BuilderType> implements c<MessageType> {
        private boolean eNV;
        private g<d> extensions = g.buG();

        protected b() {
        }

        private void buO() {
            if (!this.eNV) {
                this.extensions = this.extensions.clone();
                this.eNV = true;
            }
        }

        private g<d> buP() {
            this.extensions.makeImmutable();
            this.eNV = false;
            return this.extensions;
        }

        /* renamed from: blb */
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean buQ() {
            return this.extensions.isInitialized();
        }

        protected final void a(MessageType messageType) {
            buO();
            this.extensions.a(messageType.extensions);
        }
    }

    protected void buM() {
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(a aVar) {
    }

    public p<? extends n> biX() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean a(e eVar, CodedOutputStream codedOutputStream, f fVar, int i) {
        return eVar.a(i, codedOutputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    private static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.n> boolean a(kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.d> r4, MessageType r5, kotlin.reflect.jvm.internal.impl.protobuf.e r6, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r7, kotlin.reflect.jvm.internal.impl.protobuf.f r8, int r9) {
        /*
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.lP(r9);
        r1 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.lQ(r9);
        r5 = r8.a(r5, r1);
        r1 = 0;
        r2 = 1;
        if (r5 != 0) goto L_0x0013;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        r3 = 0;
        goto L_0x003f;
    L_0x0013:
        r3 = r5.eOf;
        r3 = r3.buI();
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.g.a(r3, r1);
        if (r0 != r3) goto L_0x0021;
    L_0x001f:
        r0 = 0;
        goto L_0x0011;
    L_0x0021:
        r3 = r5.eOf;
        r3 = r3.eOb;
        if (r3 == 0) goto L_0x0010;
    L_0x0027:
        r3 = r5.eOf;
        r3 = r3.eOa;
        r3 = r3.isPackable();
        if (r3 == 0) goto L_0x0010;
    L_0x0031:
        r3 = r5.eOf;
        r3 = r3.buI();
        r3 = kotlin.reflect.jvm.internal.impl.protobuf.g.a(r3, r2);
        if (r0 != r3) goto L_0x0010;
    L_0x003d:
        r0 = 0;
        r3 = 1;
    L_0x003f:
        if (r0 == 0) goto L_0x0046;
    L_0x0041:
        r4 = r6.a(r9, r7);
        return r4;
    L_0x0046:
        if (r3 == 0) goto L_0x0096;
    L_0x0048:
        r7 = r6.but();
        r7 = r6.lv(r7);
        r8 = r5.eOf;
        r8 = r8.buI();
        r9 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.ENUM;
        if (r8 != r9) goto L_0x007b;
    L_0x005a:
        r8 = r6.buz();
        if (r8 <= 0) goto L_0x0091;
    L_0x0060:
        r8 = r6.buo();
        r9 = r5.eOf;
        r9 = r9.buT();
        r8 = r9.jC(r8);
        if (r8 != 0) goto L_0x0071;
    L_0x0070:
        return r2;
    L_0x0071:
        r9 = r5.eOf;
        r8 = r5.cX(r8);
        r4.b(r9, r8);
        goto L_0x005a;
    L_0x007b:
        r8 = r6.buz();
        if (r8 <= 0) goto L_0x0091;
    L_0x0081:
        r8 = r5.eOf;
        r8 = r8.buI();
        r8 = kotlin.reflect.jvm.internal.impl.protobuf.g.a(r6, r8, r1);
        r9 = r5.eOf;
        r4.b(r9, r8);
        goto L_0x007b;
    L_0x0091:
        r6.lw(r7);
        goto L_0x011e;
    L_0x0096:
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.AnonymousClass1.eNT;
        r3 = r5.eOf;
        r3 = r3.buJ();
        r3 = r3.ordinal();
        r0 = r0[r3];
        switch(r0) {
            case 1: goto L_0x00c9;
            case 2: goto L_0x00b2;
            default: goto L_0x00a7;
        };
    L_0x00a7:
        r7 = r5.eOf;
        r7 = r7.buI();
        r8 = kotlin.reflect.jvm.internal.impl.protobuf.g.a(r6, r7, r1);
        goto L_0x0103;
    L_0x00b2:
        r6 = r6.buo();
        r8 = r5.eOf;
        r8 = r8.buT();
        r8 = r8.jC(r6);
        if (r8 != 0) goto L_0x0103;
    L_0x00c2:
        r7.C(r9);
        r7.t(r6);
        return r2;
    L_0x00c9:
        r7 = 0;
        r9 = r5.eOf;
        r9 = r9.buK();
        if (r9 != 0) goto L_0x00e0;
    L_0x00d2:
        r9 = r5.eOf;
        r9 = r4.b(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.protobuf.n) r9;
        if (r9 == 0) goto L_0x00e0;
    L_0x00dc:
        r7 = r9.bjf();
    L_0x00e0:
        if (r7 != 0) goto L_0x00ea;
    L_0x00e2:
        r7 = r5.buV();
        r7 = r7.bjg();
    L_0x00ea:
        r9 = r5.eOf;
        r9 = r9.buI();
        r0 = kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType.GROUP;
        if (r9 != r0) goto L_0x00fc;
    L_0x00f4:
        r9 = r5.getNumber();
        r6.a(r9, r7, r8);
        goto L_0x00ff;
    L_0x00fc:
        r6.a(r7, r8);
    L_0x00ff:
        r8 = r7.bjx();
    L_0x0103:
        r6 = r5.eOf;
        r6 = r6.buK();
        if (r6 == 0) goto L_0x0115;
    L_0x010b:
        r6 = r5.eOf;
        r5 = r5.cX(r8);
        r4.b(r6, r5);
        goto L_0x011e;
    L_0x0115:
        r6 = r5.eOf;
        r5 = r5.cX(r8);
        r4.a(r6, r5);
    L_0x011e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a(kotlin.reflect.jvm.internal.impl.protobuf.g, kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f, int):boolean");
    }

    public static <ContainingType extends n, Type> e<ContainingType, Type> a(ContainingType containingType, Type type, n nVar, kotlin.reflect.jvm.internal.impl.protobuf.h.b<?> bVar, int i, FieldType fieldType, Class cls) {
        return new e(containingType, type, nVar, new d(bVar, i, fieldType, false, false), cls);
    }

    public static <ContainingType extends n, Type> e<ContainingType, Type> a(ContainingType containingType, n nVar, kotlin.reflect.jvm.internal.impl.protobuf.h.b<?> bVar, int i, FieldType fieldType, boolean z, Class cls) {
        return new e(containingType, Collections.emptyList(), nVar, new d(bVar, i, fieldType, true, z), cls);
    }

    static Method b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable e) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            str = String.valueOf(String.valueOf(str));
            StringBuilder stringBuilder = new StringBuilder((valueOf.length() + 45) + str.length());
            stringBuilder.append("Generated message class \"");
            stringBuilder.append(valueOf);
            stringBuilder.append("\" missing method \"");
            stringBuilder.append(str);
            stringBuilder.append("\".");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    static Object a(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }
}
