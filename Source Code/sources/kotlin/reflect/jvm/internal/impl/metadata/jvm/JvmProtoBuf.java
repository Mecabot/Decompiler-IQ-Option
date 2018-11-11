package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat.FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

public final class JvmProtoBuf {
    public static final e<Constructor, JvmMethodSignature> eMi = GeneratedMessageLite.a(Constructor.bld(), JvmMethodSignature.bso(), JvmMethodSignature.bso(), null, 100, FieldType.MESSAGE, JvmMethodSignature.class);
    public static final e<Function, JvmMethodSignature> eMj = GeneratedMessageLite.a(Function.bmB(), JvmMethodSignature.bso(), JvmMethodSignature.bso(), null, 100, FieldType.MESSAGE, JvmMethodSignature.class);
    public static final e<Function, Integer> eMk = GeneratedMessageLite.a(Function.bmB(), Integer.valueOf(0), null, null, 101, FieldType.INT32, Integer.class);
    public static final e<Property, JvmPropertySignature> eMl = GeneratedMessageLite.a(Property.bnh(), JvmPropertySignature.bsy(), JvmPropertySignature.bsy(), null, 100, FieldType.MESSAGE, JvmPropertySignature.class);
    public static final e<Property, Integer> eMm = GeneratedMessageLite.a(Property.bnh(), Integer.valueOf(0), null, null, 101, FieldType.INT32, Integer.class);
    public static final e<Type, List<Annotation>> eMn = GeneratedMessageLite.a(Type.bok(), Annotation.biV(), null, 100, FieldType.MESSAGE, false, Annotation.class);
    public static final e<Type, Boolean> eMo = GeneratedMessageLite.a(Type.bok(), Boolean.valueOf(false), null, null, 101, FieldType.BOOL, Boolean.class);
    public static final e<TypeParameter, List<Annotation>> eMp = GeneratedMessageLite.a(TypeParameter.bpB(), Annotation.biV(), null, 100, FieldType.MESSAGE, false, Annotation.class);
    public static final e<Class, Integer> eMq = GeneratedMessageLite.a(Class.bkh(), Integer.valueOf(0), null, null, 101, FieldType.INT32, Integer.class);
    public static final e<Class, List<Property>> eMr = GeneratedMessageLite.a(Class.bkh(), Property.bnh(), null, 102, FieldType.MESSAGE, false, Property.class);
    public static final e<Class, Integer> eMs = GeneratedMessageLite.a(Class.bkh(), Integer.valueOf(0), null, null, 103, FieldType.INT32, Integer.class);
    public static final e<Package, Integer> eMt = GeneratedMessageLite.a(Package.bmX(), Integer.valueOf(0), null, null, 101, FieldType.INT32, Integer.class);
    public static final e<Package, List<Property>> eMu = GeneratedMessageLite.a(Package.bmX(), Property.bnh(), null, 102, FieldType.MESSAGE, false, Property.class);

    public interface a extends o {
    }

    public interface b extends o {
    }

    public interface c extends o {
    }

    public interface d extends o {
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements a {
        public static p<JvmFieldSignature> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<JvmFieldSignature>() {
            /* renamed from: ab */
            public JvmFieldSignature b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                return new JvmFieldSignature(eVar, fVar);
            }
        };
        private static final JvmFieldSignature eMv = new JvmFieldSignature(true);
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<JvmFieldSignature, a> implements a {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bsj() {
                return new a();
            }

            /* renamed from: bsk */
            public a clone() {
                return bsj().a(bsm());
            }

            /* renamed from: bsd */
            public JvmFieldSignature bju() {
                return JvmFieldSignature.bsc();
            }

            /* renamed from: bsl */
            public JvmFieldSignature bjx() {
                Object bsm = bsm();
                if (bsm.isInitialized()) {
                    return bsm;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bsm);
            }

            public JvmFieldSignature bsm() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmFieldSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmFieldSignature.desc_ = this.desc_;
                jvmFieldSignature.bitField0_ = i2;
                return jvmFieldSignature;
            }

            /* renamed from: c */
            public a a(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.bsc()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    ll(jvmFieldSignature.blW());
                }
                if (jvmFieldSignature.bse()) {
                    lm(jvmFieldSignature.bsf());
                }
                e(buN().a(jvmFieldSignature.unknownFields));
                return this;
            }

            /* renamed from: ac */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                JvmFieldSignature jvmFieldSignature;
                Throwable th;
                JvmFieldSignature jvmFieldSignature2 = null;
                try {
                    JvmFieldSignature jvmFieldSignature3 = (JvmFieldSignature) JvmFieldSignature.eKF.b(eVar, fVar);
                    if (jvmFieldSignature3 != null) {
                        a(jvmFieldSignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    jvmFieldSignature = (JvmFieldSignature) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    jvmFieldSignature2 = jvmFieldSignature;
                }
                if (jvmFieldSignature2 != null) {
                    a(jvmFieldSignature2);
                }
                throw th;
            }

            public a ll(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }

            public a lm(int i) {
                this.bitField0_ |= 2;
                this.desc_ = i;
                return this;
            }
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private JvmFieldSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static JvmFieldSignature bsc() {
            return eMv;
        }

        /* renamed from: bsd */
        public JvmFieldSignature bjh() {
            return eMv;
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        if (bue == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = eVar.buh();
                        } else if (bue == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = eVar.buh();
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    try {
                        b.flush();
                    } catch (IOException unused) {
                        this.unknownFields = btY.buc();
                        buM();
                        throw th;
                    } catch (Throwable th2) {
                        this.unknownFields = btY.buc();
                    }
                }
            }
            try {
                b.flush();
            } catch (IOException unused2) {
                this.unknownFields = btY.buc();
                buM();
            } catch (Throwable th3) {
                this.unknownFields = btY.buc();
            }
        }

        static {
            eMv.bja();
        }

        public p<JvmFieldSignature> biX() {
            return eKF;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public int blW() {
            return this.name_;
        }

        public boolean bse() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bsf() {
            return this.desc_;
        }

        private void bja() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.desc_);
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.bh(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.desc_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a bsg() {
            return a.bsj();
        }

        /* renamed from: bsh */
        public a bjg() {
            return bsg();
        }

        public static a a(JvmFieldSignature jvmFieldSignature) {
            return bsg().a(jvmFieldSignature);
        }

        /* renamed from: bsi */
        public a bjf() {
            return a(this);
        }
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements b {
        public static p<JvmMethodSignature> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<JvmMethodSignature>() {
            /* renamed from: ad */
            public JvmMethodSignature b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                return new JvmMethodSignature(eVar, fVar);
            }
        };
        private static final JvmMethodSignature eMw = new JvmMethodSignature(true);
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<JvmMethodSignature, a> implements b {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bst() {
                return new a();
            }

            /* renamed from: bsu */
            public a clone() {
                return bst().a(bsw());
            }

            /* renamed from: bsp */
            public JvmMethodSignature bju() {
                return JvmMethodSignature.bso();
            }

            /* renamed from: bsv */
            public JvmMethodSignature bjx() {
                Object bsw = bsw();
                if (bsw.isInitialized()) {
                    return bsw;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bsw);
            }

            public JvmMethodSignature bsw() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmMethodSignature.name_ = this.name_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmMethodSignature.desc_ = this.desc_;
                jvmMethodSignature.bitField0_ = i2;
                return jvmMethodSignature;
            }

            /* renamed from: c */
            public a a(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.bso()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    ln(jvmMethodSignature.blW());
                }
                if (jvmMethodSignature.bse()) {
                    lo(jvmMethodSignature.bsf());
                }
                e(buN().a(jvmMethodSignature.unknownFields));
                return this;
            }

            /* renamed from: ae */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                JvmMethodSignature jvmMethodSignature;
                Throwable th;
                JvmMethodSignature jvmMethodSignature2 = null;
                try {
                    JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) JvmMethodSignature.eKF.b(eVar, fVar);
                    if (jvmMethodSignature3 != null) {
                        a(jvmMethodSignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    jvmMethodSignature = (JvmMethodSignature) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    jvmMethodSignature2 = jvmMethodSignature;
                }
                if (jvmMethodSignature2 != null) {
                    a(jvmMethodSignature2);
                }
                throw th;
            }

            public a ln(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }

            public a lo(int i) {
                this.bitField0_ |= 2;
                this.desc_ = i;
                return this;
            }
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private JvmMethodSignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static JvmMethodSignature bso() {
            return eMw;
        }

        /* renamed from: bsp */
        public JvmMethodSignature bjh() {
            return eMw;
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        if (bue == 8) {
                            this.bitField0_ |= 1;
                            this.name_ = eVar.buh();
                        } else if (bue == 16) {
                            this.bitField0_ |= 2;
                            this.desc_ = eVar.buh();
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    try {
                        b.flush();
                    } catch (IOException unused) {
                        this.unknownFields = btY.buc();
                        buM();
                        throw th;
                    } catch (Throwable th2) {
                        this.unknownFields = btY.buc();
                    }
                }
            }
            try {
                b.flush();
            } catch (IOException unused2) {
                this.unknownFields = btY.buc();
                buM();
            } catch (Throwable th3) {
                this.unknownFields = btY.buc();
            }
        }

        static {
            eMw.bja();
        }

        public p<JvmMethodSignature> biX() {
            return eKF;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public int blW() {
            return this.name_;
        }

        public boolean bse() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bsf() {
            return this.desc_;
        }

        private void bja() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.desc_);
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.bh(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.desc_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a bsq() {
            return a.bst();
        }

        /* renamed from: bsr */
        public a bjg() {
            return bsq();
        }

        public static a a(JvmMethodSignature jvmMethodSignature) {
            return bsq().a(jvmMethodSignature);
        }

        /* renamed from: bss */
        public a bjf() {
            return a(this);
        }
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements c {
        public static p<JvmPropertySignature> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<JvmPropertySignature>() {
            /* renamed from: af */
            public JvmPropertySignature b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                return new JvmPropertySignature(eVar, fVar);
            }
        };
        private static final JvmPropertySignature eMx = new JvmPropertySignature(true);
        private int bitField0_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<JvmPropertySignature, a> implements c {
            private int bitField0_;
            private JvmFieldSignature field_ = JvmFieldSignature.bsc();
            private JvmMethodSignature getter_ = JvmMethodSignature.bso();
            private JvmMethodSignature setter_ = JvmMethodSignature.bso();
            private JvmMethodSignature syntheticMethod_ = JvmMethodSignature.bso();

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bsL() {
                return new a();
            }

            /* renamed from: bsM */
            public a clone() {
                return bsL().a(bsO());
            }

            /* renamed from: bsz */
            public JvmPropertySignature bju() {
                return JvmPropertySignature.bsy();
            }

            /* renamed from: bsN */
            public JvmPropertySignature bjx() {
                Object bsO = bsO();
                if (bsO.isInitialized()) {
                    return bsO;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bsO);
            }

            public JvmPropertySignature bsO() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                jvmPropertySignature.field_ = this.field_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.syntheticMethod_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                jvmPropertySignature.getter_ = this.getter_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                jvmPropertySignature.setter_ = this.setter_;
                jvmPropertySignature.bitField0_ = i2;
                return jvmPropertySignature;
            }

            /* renamed from: c */
            public a a(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.bsy()) {
                    return this;
                }
                if (jvmPropertySignature.bsA()) {
                    d(jvmPropertySignature.bsB());
                }
                if (jvmPropertySignature.bsC()) {
                    d(jvmPropertySignature.bsD());
                }
                if (jvmPropertySignature.bsE()) {
                    e(jvmPropertySignature.bsF());
                }
                if (jvmPropertySignature.bsG()) {
                    f(jvmPropertySignature.bsH());
                }
                e(buN().a(jvmPropertySignature.unknownFields));
                return this;
            }

            /* renamed from: ag */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                JvmPropertySignature jvmPropertySignature;
                Throwable th;
                JvmPropertySignature jvmPropertySignature2 = null;
                try {
                    JvmPropertySignature jvmPropertySignature3 = (JvmPropertySignature) JvmPropertySignature.eKF.b(eVar, fVar);
                    if (jvmPropertySignature3 != null) {
                        a(jvmPropertySignature3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    jvmPropertySignature = (JvmPropertySignature) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    jvmPropertySignature2 = jvmPropertySignature;
                }
                if (jvmPropertySignature2 != null) {
                    a(jvmPropertySignature2);
                }
                throw th;
            }

            public a d(JvmFieldSignature jvmFieldSignature) {
                if ((this.bitField0_ & 1) != 1 || this.field_ == JvmFieldSignature.bsc()) {
                    this.field_ = jvmFieldSignature;
                } else {
                    this.field_ = JvmFieldSignature.a(this.field_).a(jvmFieldSignature).bsm();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public a d(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 2) != 2 || this.syntheticMethod_ == JvmMethodSignature.bso()) {
                    this.syntheticMethod_ = jvmMethodSignature;
                } else {
                    this.syntheticMethod_ = JvmMethodSignature.a(this.syntheticMethod_).a(jvmMethodSignature).bsw();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public a e(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 4) != 4 || this.getter_ == JvmMethodSignature.bso()) {
                    this.getter_ = jvmMethodSignature;
                } else {
                    this.getter_ = JvmMethodSignature.a(this.getter_).a(jvmMethodSignature).bsw();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public a f(JvmMethodSignature jvmMethodSignature) {
                if ((this.bitField0_ & 8) != 8 || this.setter_ == JvmMethodSignature.bso()) {
                    this.setter_ = jvmMethodSignature;
                } else {
                    this.setter_ = JvmMethodSignature.a(this.setter_).a(jvmMethodSignature).bsw();
                }
                this.bitField0_ |= 8;
                return this;
            }
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private JvmPropertySignature(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static JvmPropertySignature bsy() {
            return eMx;
        }

        /* renamed from: bsz */
        public JvmPropertySignature bjh() {
            return eMx;
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        a aVar = null;
                        a bss;
                        if (bue == 10) {
                            if ((this.bitField0_ & 1) == 1) {
                                aVar = this.field_.bjf();
                            }
                            this.field_ = (JvmFieldSignature) eVar.a(JvmFieldSignature.eKF, fVar);
                            if (aVar != null) {
                                aVar.a(this.field_);
                                this.field_ = aVar.bsm();
                            }
                            this.bitField0_ |= 1;
                        } else if (bue == 18) {
                            if ((this.bitField0_ & 2) == 2) {
                                bss = this.syntheticMethod_.bjf();
                            }
                            this.syntheticMethod_ = (JvmMethodSignature) eVar.a(JvmMethodSignature.eKF, fVar);
                            if (bss != null) {
                                bss.a(this.syntheticMethod_);
                                this.syntheticMethod_ = bss.bsw();
                            }
                            this.bitField0_ |= 2;
                        } else if (bue == 26) {
                            if ((this.bitField0_ & 4) == 4) {
                                bss = this.getter_.bjf();
                            }
                            this.getter_ = (JvmMethodSignature) eVar.a(JvmMethodSignature.eKF, fVar);
                            if (bss != null) {
                                bss.a(this.getter_);
                                this.getter_ = bss.bsw();
                            }
                            this.bitField0_ |= 4;
                        } else if (bue == 34) {
                            if ((this.bitField0_ & 8) == 8) {
                                bss = this.setter_.bjf();
                            }
                            this.setter_ = (JvmMethodSignature) eVar.a(JvmMethodSignature.eKF, fVar);
                            if (bss != null) {
                                bss.a(this.setter_);
                                this.setter_ = bss.bsw();
                            }
                            this.bitField0_ |= 8;
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    try {
                        b.flush();
                    } catch (IOException unused) {
                        this.unknownFields = btY.buc();
                        buM();
                        throw th;
                    } catch (Throwable th2) {
                        this.unknownFields = btY.buc();
                    }
                }
            }
            try {
                b.flush();
            } catch (IOException unused2) {
                this.unknownFields = btY.buc();
                buM();
            } catch (Throwable th3) {
                this.unknownFields = btY.buc();
            }
        }

        static {
            eMx.bja();
        }

        public p<JvmPropertySignature> biX() {
            return eKF;
        }

        public boolean bsA() {
            return (this.bitField0_ & 1) == 1;
        }

        public JvmFieldSignature bsB() {
            return this.field_;
        }

        public boolean bsC() {
            return (this.bitField0_ & 2) == 2;
        }

        public JvmMethodSignature bsD() {
            return this.syntheticMethod_;
        }

        public boolean bsE() {
            return (this.bitField0_ & 4) == 4;
        }

        public JvmMethodSignature bsF() {
            return this.getter_;
        }

        public boolean bsG() {
            return (this.bitField0_ & 8) == 8;
        }

        public JvmMethodSignature bsH() {
            return this.setter_;
        }

        private void bja() {
            this.field_ = JvmFieldSignature.bsc();
            this.syntheticMethod_ = JvmMethodSignature.bso();
            this.getter_ = JvmMethodSignature.bso();
            this.setter_ = JvmMethodSignature.bso();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.b(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.b(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.b(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.b(4, this.setter_);
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.d(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.d(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.d(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.d(4, this.setter_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a bsI() {
            return a.bsL();
        }

        /* renamed from: bsJ */
        public a bjg() {
            return bsI();
        }

        public static a a(JvmPropertySignature jvmPropertySignature) {
            return bsI().a(jvmPropertySignature);
        }

        /* renamed from: bsK */
        public a bjf() {
            return a(this);
        }
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements d {
        public static p<StringTableTypes> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<StringTableTypes>() {
            /* renamed from: ah */
            public StringTableTypes b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                return new StringTableTypes(eVar, fVar);
            }
        };
        private static final StringTableTypes eMy = new StringTableTypes(true);
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public interface b extends o {
        }

        public static final class Record extends GeneratedMessageLite implements b {
            public static p<Record> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Record>() {
                /* renamed from: aj */
                public Record b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                    return new Record(eVar, fVar);
                }
            };
            private static final Record eMz = new Record(true);
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            public enum Operation implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Operation> internalValueMap;
                private final int value;

                static {
                    internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Operation>() {
                        /* renamed from: lr */
                        public Operation jC(int i) {
                            return Operation.valueOf(i);
                        }
                    };
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i) {
                    switch (i) {
                        case 0:
                            return NONE;
                        case 1:
                            return INTERNAL_TO_CLASS_ID;
                        case 2:
                            return DESC_TO_CLASS_ID;
                        default:
                            return null;
                    }
                }

                private Operation(int i, int i2) {
                    this.value = i2;
                }
            }

            public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Record, a> implements b {
                private int bitField0_;
                private Operation operation_ = Operation.NONE;
                private int predefinedIndex_;
                private int range_ = 1;
                private List<Integer> replaceChar_ = Collections.emptyList();
                private Object string_ = "";
                private List<Integer> substringIndex_ = Collections.emptyList();

                private void bjp() {
                }

                public final boolean isInitialized() {
                    return true;
                }

                private a() {
                    bjp();
                }

                private static a btu() {
                    return new a();
                }

                /* renamed from: btv */
                public a clone() {
                    return btu().a(btx());
                }

                /* renamed from: btf */
                public Record bju() {
                    return Record.bte();
                }

                /* renamed from: btw */
                public Record bjx() {
                    Object btx = btx();
                    if (btx.isInitialized()) {
                        return btx;
                    }
                    throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(btx);
                }

                public Record btx() {
                    Record record = new Record((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    record.range_ = this.range_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    record.predefinedIndex_ = this.predefinedIndex_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    record.string_ = this.string_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    record.operation_ = this.operation_;
                    if ((this.bitField0_ & 16) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        this.bitField0_ &= -17;
                    }
                    record.substringIndex_ = this.substringIndex_;
                    if ((this.bitField0_ & 32) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        this.bitField0_ &= -33;
                    }
                    record.replaceChar_ = this.replaceChar_;
                    record.bitField0_ = i2;
                    return record;
                }

                /* renamed from: f */
                public a a(Record record) {
                    if (record == Record.bte()) {
                        return this;
                    }
                    if (record.btg()) {
                        lp(record.bth());
                    }
                    if (record.bti()) {
                        lq(record.btj());
                    }
                    if (record.hasString()) {
                        this.bitField0_ |= 4;
                        this.string_ = record.string_;
                    }
                    if (record.btl()) {
                        a(record.btm());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.substringIndex_.isEmpty()) {
                            this.substringIndex_ = record.substringIndex_;
                            this.bitField0_ &= -17;
                        } else {
                            bty();
                            this.substringIndex_.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.replaceChar_.isEmpty()) {
                            this.replaceChar_ = record.replaceChar_;
                            this.bitField0_ &= -33;
                        } else {
                            btz();
                            this.replaceChar_.addAll(record.replaceChar_);
                        }
                    }
                    e(buN().a(record.unknownFields));
                    return this;
                }

                /* renamed from: ak */
                public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                    Record record;
                    Throwable th;
                    Record record2 = null;
                    try {
                        Record record3 = (Record) Record.eKF.b(eVar, fVar);
                        if (record3 != null) {
                            a(record3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        record = (Record) e.buW();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        record2 = record;
                    }
                    if (record2 != null) {
                        a(record2);
                    }
                    throw th;
                }

                public a lp(int i) {
                    this.bitField0_ |= 1;
                    this.range_ = i;
                    return this;
                }

                public a lq(int i) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = i;
                    return this;
                }

                public a a(Operation operation) {
                    if (operation == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 8;
                    this.operation_ = operation;
                    return this;
                }

                private void bty() {
                    if ((this.bitField0_ & 16) != 16) {
                        this.substringIndex_ = new ArrayList(this.substringIndex_);
                        this.bitField0_ |= 16;
                    }
                }

                private void btz() {
                    if ((this.bitField0_ & 32) != 32) {
                        this.replaceChar_ = new ArrayList(this.replaceChar_);
                        this.bitField0_ |= 32;
                    }
                }
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
                super(aVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = aVar.buN();
            }

            private Record(boolean z) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
            }

            public static Record bte() {
                return eMz;
            }

            /* renamed from: btf */
            public Record bjh() {
                return eMz;
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                bja();
                OutputStream btY = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
                CodedOutputStream b = CodedOutputStream.b(btY, 1);
                Object obj = null;
                int i = 0;
                while (obj == null) {
                    try {
                        int bue = eVar.bue();
                        if (bue != 0) {
                            if (bue == 8) {
                                this.bitField0_ |= 1;
                                this.range_ = eVar.buh();
                            } else if (bue == 16) {
                                this.bitField0_ |= 2;
                                this.predefinedIndex_ = eVar.buh();
                            } else if (bue == 24) {
                                int buo = eVar.buo();
                                Operation valueOf = Operation.valueOf(buo);
                                if (valueOf == null) {
                                    b.C(bue);
                                    b.C(buo);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.operation_ = valueOf;
                                }
                            } else if (bue == 32) {
                                if ((i & 16) != 16) {
                                    this.substringIndex_ = new ArrayList();
                                    i |= 16;
                                }
                                this.substringIndex_.add(Integer.valueOf(eVar.buh()));
                            } else if (bue == 34) {
                                bue = eVar.lv(eVar.but());
                                if ((i & 16) != 16 && eVar.buz() > 0) {
                                    this.substringIndex_ = new ArrayList();
                                    i |= 16;
                                }
                                while (eVar.buz() > 0) {
                                    this.substringIndex_.add(Integer.valueOf(eVar.buh()));
                                }
                                eVar.lw(bue);
                            } else if (bue == 40) {
                                if ((i & 32) != 32) {
                                    this.replaceChar_ = new ArrayList();
                                    i |= 32;
                                }
                                this.replaceChar_.add(Integer.valueOf(eVar.buh()));
                            } else if (bue == 42) {
                                bue = eVar.lv(eVar.but());
                                if ((i & 32) != 32 && eVar.buz() > 0) {
                                    this.replaceChar_ = new ArrayList();
                                    i |= 32;
                                }
                                while (eVar.buz() > 0) {
                                    this.replaceChar_.add(Integer.valueOf(eVar.buh()));
                                }
                                eVar.lw(bue);
                            } else if (bue == 50) {
                                kotlin.reflect.jvm.internal.impl.protobuf.d bum = eVar.bum();
                                this.bitField0_ |= 4;
                                this.string_ = bum;
                            } else if (a(eVar, b, fVar, bue)) {
                            }
                        }
                        obj = 1;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.g(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                    } catch (Throwable th) {
                        if ((i & 16) == 16) {
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if ((i & 32) == 32) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                        }
                        try {
                            b.flush();
                        } catch (IOException unused) {
                            this.unknownFields = btY.buc();
                            buM();
                            throw th;
                        } catch (Throwable th2) {
                            this.unknownFields = btY.buc();
                        }
                    }
                }
                if ((i & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    b.flush();
                } catch (IOException unused2) {
                    this.unknownFields = btY.buc();
                    buM();
                } catch (Throwable th3) {
                    this.unknownFields = btY.buc();
                }
            }

            static {
                eMz.bja();
            }

            public p<Record> biX() {
                return eKF;
            }

            public boolean btg() {
                return (this.bitField0_ & 1) == 1;
            }

            public int bth() {
                return this.range_;
            }

            public boolean bti() {
                return (this.bitField0_ & 2) == 2;
            }

            public int btj() {
                return this.predefinedIndex_;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String btV = dVar.btV();
                if (dVar.btW()) {
                    this.string_ = btV;
                }
                return btV;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d btk() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d mI = kotlin.reflect.jvm.internal.impl.protobuf.d.mI((String) obj);
                this.string_ = mI;
                return mI;
            }

            public boolean btl() {
                return (this.bitField0_ & 8) == 8;
            }

            public Operation btm() {
                return this.operation_;
            }

            public List<Integer> btn() {
                return this.substringIndex_;
            }

            public int bto() {
                return this.substringIndex_.size();
            }

            public List<Integer> btp() {
                return this.replaceChar_;
            }

            public int btq() {
                return this.replaceChar_.size();
            }

            private void bja() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            public void a(CodedOutputStream codedOutputStream) {
                bjb();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.bg(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.bg(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.k(3, this.operation_.getNumber());
                }
                if (btn().size() > 0) {
                    codedOutputStream.C(34);
                    codedOutputStream.C(this.substringIndexMemoizedSerializedSize);
                }
                int i = 0;
                for (int i2 = 0; i2 < this.substringIndex_.size(); i2++) {
                    codedOutputStream.s(((Integer) this.substringIndex_.get(i2)).intValue());
                }
                if (btp().size() > 0) {
                    codedOutputStream.C(42);
                    codedOutputStream.C(this.replaceCharMemoizedSerializedSize);
                }
                while (i < this.replaceChar_.size()) {
                    codedOutputStream.s(((Integer) this.replaceChar_.get(i)).intValue());
                    i++;
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.a(6, btk());
                }
                codedOutputStream.d(this.unknownFields);
            }

            public int bjb() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int i2;
                int i3 = 0;
                i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.bh(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    i += CodedOutputStream.n(3, this.operation_.getNumber());
                }
                int i4 = 0;
                for (i2 = 0; i2 < this.substringIndex_.size(); i2++) {
                    i4 += CodedOutputStream.w(((Integer) this.substringIndex_.get(i2)).intValue());
                }
                i += i4;
                if (!btn().isEmpty()) {
                    i = (i + 1) + CodedOutputStream.w(i4);
                }
                this.substringIndexMemoizedSerializedSize = i4;
                i2 = 0;
                while (i3 < this.replaceChar_.size()) {
                    i2 += CodedOutputStream.w(((Integer) this.replaceChar_.get(i3)).intValue());
                    i3++;
                }
                i += i2;
                if (!btp().isEmpty()) {
                    i = (i + 1) + CodedOutputStream.w(i2);
                }
                this.replaceCharMemoizedSerializedSize = i2;
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.b(6, btk());
                }
                i += this.unknownFields.size();
                this.memoizedSerializedSize = i;
                return i;
            }

            public static a btr() {
                return a.btu();
            }

            /* renamed from: bts */
            public a bjg() {
                return btr();
            }

            public static a a(Record record) {
                return btr().a(record);
            }

            /* renamed from: btt */
            public a bjf() {
                return a(this);
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<StringTableTypes, a> implements d {
            private int bitField0_;
            private List<Integer> localName_ = Collections.emptyList();
            private List<Record> record_ = Collections.emptyList();

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bsX() {
                return new a();
            }

            /* renamed from: bsY */
            public a clone() {
                return bsX().a(bta());
            }

            /* renamed from: bsR */
            public StringTableTypes bju() {
                return StringTableTypes.bsQ();
            }

            /* renamed from: bsZ */
            public StringTableTypes bjx() {
                Object bta = bta();
                if (bta.isInitialized()) {
                    return bta;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bta);
            }

            public StringTableTypes bta() {
                StringTableTypes stringTableTypes = new StringTableTypes((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                    this.bitField0_ &= -2;
                }
                stringTableTypes.record_ = this.record_;
                if ((this.bitField0_ & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
                    this.bitField0_ &= -3;
                }
                stringTableTypes.localName_ = this.localName_;
                return stringTableTypes;
            }

            /* renamed from: e */
            public a a(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.bsQ()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.record_.isEmpty()) {
                        this.record_ = stringTableTypes.record_;
                        this.bitField0_ &= -2;
                    } else {
                        btb();
                        this.record_.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.localName_.isEmpty()) {
                        this.localName_ = stringTableTypes.localName_;
                        this.bitField0_ &= -3;
                    } else {
                        btc();
                        this.localName_.addAll(stringTableTypes.localName_);
                    }
                }
                e(buN().a(stringTableTypes.unknownFields));
                return this;
            }

            /* renamed from: ai */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
                StringTableTypes stringTableTypes;
                Throwable th;
                StringTableTypes stringTableTypes2 = null;
                try {
                    StringTableTypes stringTableTypes3 = (StringTableTypes) StringTableTypes.eKF.b(eVar, fVar);
                    if (stringTableTypes3 != null) {
                        a(stringTableTypes3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    stringTableTypes = (StringTableTypes) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    stringTableTypes2 = stringTableTypes;
                }
                if (stringTableTypes2 != null) {
                    a(stringTableTypes2);
                }
                throw th;
            }

            private void btb() {
                if ((this.bitField0_ & 1) != 1) {
                    this.record_ = new ArrayList(this.record_);
                    this.bitField0_ |= 1;
                }
            }

            private void btc() {
                if ((this.bitField0_ & 2) != 2) {
                    this.localName_ = new ArrayList(this.localName_);
                    this.bitField0_ |= 2;
                }
            }
        }

        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private StringTableTypes(boolean z) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static StringTableTypes bsQ() {
            return eMy;
        }

        /* renamed from: bsR */
        public StringTableTypes bjh() {
            return eMy;
        }

        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            int i = 0;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        if (bue == 10) {
                            if ((i & 1) != 1) {
                                this.record_ = new ArrayList();
                                i |= 1;
                            }
                            this.record_.add(eVar.a(Record.eKF, fVar));
                        } else if (bue == 40) {
                            if ((i & 2) != 2) {
                                this.localName_ = new ArrayList();
                                i |= 2;
                            }
                            this.localName_.add(Integer.valueOf(eVar.buh()));
                        } else if (bue == 42) {
                            bue = eVar.lv(eVar.but());
                            if ((i & 2) != 2 && eVar.buz() > 0) {
                                this.localName_ = new ArrayList();
                                i |= 2;
                            }
                            while (eVar.buz() > 0) {
                                this.localName_.add(Integer.valueOf(eVar.buh()));
                            }
                            eVar.lw(bue);
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        b.flush();
                    } catch (IOException unused) {
                        this.unknownFields = btY.buc();
                        buM();
                        throw th;
                    } catch (Throwable th2) {
                        this.unknownFields = btY.buc();
                    }
                }
            }
            if ((i & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                b.flush();
            } catch (IOException unused2) {
                this.unknownFields = btY.buc();
                buM();
            } catch (Throwable th3) {
                this.unknownFields = btY.buc();
            }
        }

        static {
            eMy.bja();
        }

        public p<StringTableTypes> biX() {
            return eKF;
        }

        public List<Record> bsS() {
            return this.record_;
        }

        public List<Integer> bsT() {
            return this.localName_;
        }

        private void bja() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            int i = 0;
            for (int i2 = 0; i2 < this.record_.size(); i2++) {
                codedOutputStream.b(1, (n) this.record_.get(i2));
            }
            if (bsT().size() > 0) {
                codedOutputStream.C(42);
                codedOutputStream.C(this.localNameMemoizedSerializedSize);
            }
            while (i < this.localName_.size()) {
                codedOutputStream.s(((Integer) this.localName_.get(i)).intValue());
                i++;
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2;
            int i3 = 0;
            for (i2 = 0; i2 < this.record_.size(); i2++) {
                i3 += CodedOutputStream.d(1, (n) this.record_.get(i2));
            }
            i2 = 0;
            for (i = 0; i < this.localName_.size(); i++) {
                i2 += CodedOutputStream.w(((Integer) this.localName_.get(i)).intValue());
            }
            i3 += i2;
            if (!bsT().isEmpty()) {
                i3 = (i3 + 1) + CodedOutputStream.w(i2);
            }
            this.localNameMemoizedSerializedSize = i2;
            i3 += this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static StringTableTypes e(InputStream inputStream, f fVar) {
            return (StringTableTypes) eKF.j(inputStream, fVar);
        }

        public static a bsU() {
            return a.bsX();
        }

        /* renamed from: bsV */
        public a bjg() {
            return bsU();
        }

        public static a a(StringTableTypes stringTableTypes) {
            return bsU().a(stringTableTypes);
        }

        /* renamed from: bsW */
        public a bjf() {
            return a(this);
        }
    }

    public static void a(f fVar) {
        fVar.a(eMi);
        fVar.a(eMj);
        fVar.a(eMk);
        fVar.a(eMl);
        fVar.a(eMm);
        fVar.a(eMn);
        fVar.a(eMo);
        fVar.a(eMp);
        fVar.a(eMq);
        fVar.a(eMr);
        fVar.a(eMs);
        fVar.a(eMt);
        fVar.a(eMu);
    }
}
