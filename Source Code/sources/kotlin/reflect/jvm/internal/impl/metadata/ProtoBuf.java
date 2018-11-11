package kotlin.reflect.jvm.internal.impl.metadata;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

public final class ProtoBuf {

    public enum MemberKind implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<MemberKind> internalValueMap;
        private final int value;

        static {
            internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<MemberKind>() {
                /* renamed from: kh */
                public MemberKind jC(int i) {
                    return MemberKind.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i) {
            switch (i) {
                case 0:
                    return DECLARATION;
                case 1:
                    return FAKE_OVERRIDE;
                case 2:
                    return DELEGATION;
                case 3:
                    return SYNTHESIZED;
                default:
                    return null;
            }
        }

        private MemberKind(int i, int i2) {
            this.value = i2;
        }
    }

    public enum Modality implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Modality> internalValueMap;
        private final int value;

        static {
            internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Modality>() {
                /* renamed from: ki */
                public Modality jC(int i) {
                    return Modality.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i) {
            switch (i) {
                case 0:
                    return FINAL;
                case 1:
                    return OPEN;
                case 2:
                    return ABSTRACT;
                case 3:
                    return SEALED;
                default:
                    return null;
            }
        }

        private Modality(int i, int i2) {
            this.value = i2;
        }
    }

    public enum Visibility implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Visibility> internalValueMap;
        private final int value;

        static {
            internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Visibility>() {
                /* renamed from: lb */
                public Visibility jC(int i) {
                    return Visibility.valueOf(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i) {
            switch (i) {
                case 0:
                    return INTERNAL;
                case 1:
                    return PRIVATE;
                case 2:
                    return PROTECTED;
                case 3:
                    return PUBLIC;
                case 4:
                    return PRIVATE_TO_THIS;
                case 5:
                    return LOCAL;
                default:
                    return null;
            }
        }

        private Visibility(int i, int i2) {
            this.value = i2;
        }
    }

    public interface a extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface d extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface e extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface g extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface k extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface l extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface p extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface r extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface s extends kotlin.reflect.jvm.internal.impl.protobuf.o {
    }

    public interface b extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface c extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface f extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface h extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface i extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface j extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface m extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface n extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface o extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public interface q extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c {
    }

    public static final class Annotation extends GeneratedMessageLite implements a {
        private static final Annotation eKE = new Annotation(true);
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Annotation>() {
            /* renamed from: a */
            public Annotation b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Annotation(eVar, fVar);
            }
        };
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public interface a extends kotlin.reflect.jvm.internal.impl.protobuf.o {
        }

        public static final class Argument extends GeneratedMessageLite implements a {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Argument>() {
                /* renamed from: c */
                public Argument b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    return new Argument(eVar, fVar);
                }
            };
            private static final Argument eKG = new Argument(true);
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
            private Value value_;

            public interface b extends kotlin.reflect.jvm.internal.impl.protobuf.o {
            }

            public static final class Value extends GeneratedMessageLite implements b {
                public static kotlin.reflect.jvm.internal.impl.protobuf.p<Value> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Value>() {
                    /* renamed from: g */
                    public Value b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                        return new Value(eVar, fVar);
                    }
                };
                private static final Value eKH = new Value(true);
                private Annotation annotation_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

                public enum Type implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Type> internalValueMap;
                    private final int value;

                    static {
                        internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Type>() {
                            /* renamed from: jB */
                            public Type jC(int i) {
                                return Type.valueOf(i);
                            }
                        };
                    }

                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i) {
                        switch (i) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    private Type(int i, int i2) {
                        this.value = i2;
                    }
                }

                public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Value, a> implements b {
                    private Annotation annotation_ = Annotation.biV();
                    private List<Value> arrayElement_ = Collections.emptyList();
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_ = Type.BYTE;

                    private void bjp() {
                    }

                    private a() {
                        bjp();
                    }

                    private static a bjV() {
                        return new a();
                    }

                    /* renamed from: bjW */
                    public a clone() {
                        return bjV().a(bjY());
                    }

                    /* renamed from: bjA */
                    public Value bju() {
                        return Value.bjz();
                    }

                    /* renamed from: bjX */
                    public Value bjx() {
                        Object bjY = bjY();
                        if (bjY.isInitialized()) {
                            return bjY;
                        }
                        throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bjY);
                    }

                    public Value bjY() {
                        Value value = new Value((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                        int i = this.bitField0_;
                        int i2 = 1;
                        if ((i & 1) != 1) {
                            i2 = 0;
                        }
                        value.type_ = this.type_;
                        if ((i & 2) == 2) {
                            i2 |= 2;
                        }
                        value.intValue_ = this.intValue_;
                        if ((i & 4) == 4) {
                            i2 |= 4;
                        }
                        value.floatValue_ = this.floatValue_;
                        if ((i & 8) == 8) {
                            i2 |= 8;
                        }
                        value.doubleValue_ = this.doubleValue_;
                        if ((i & 16) == 16) {
                            i2 |= 16;
                        }
                        value.stringValue_ = this.stringValue_;
                        if ((i & 32) == 32) {
                            i2 |= 32;
                        }
                        value.classId_ = this.classId_;
                        if ((i & 64) == 64) {
                            i2 |= 64;
                        }
                        value.enumValueId_ = this.enumValueId_;
                        if ((i & 128) == 128) {
                            i2 |= 128;
                        }
                        value.annotation_ = this.annotation_;
                        if ((this.bitField0_ & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            this.bitField0_ &= -257;
                        }
                        value.arrayElement_ = this.arrayElement_;
                        if ((i & 512) == 512) {
                            i2 |= 256;
                        }
                        value.flags_ = this.flags_;
                        value.bitField0_ = i2;
                        return value;
                    }

                    /* renamed from: e */
                    public a a(Value value) {
                        if (value == Value.bjz()) {
                            return this;
                        }
                        if (value.hasType()) {
                            a(value.bjB());
                        }
                        if (value.bjC()) {
                            cY(value.bjD());
                        }
                        if (value.bjE()) {
                            ah(value.bjF());
                        }
                        if (value.bjG()) {
                            Y(value.Mu());
                        }
                        if (value.bjH()) {
                            jx(value.bjI());
                        }
                        if (value.bjJ()) {
                            jy(value.bjK());
                        }
                        if (value.bjL()) {
                            jz(value.bjM());
                        }
                        if (value.bjN()) {
                            d(value.bjO());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.arrayElement_.isEmpty()) {
                                this.arrayElement_ = value.arrayElement_;
                                this.bitField0_ &= -257;
                            } else {
                                bjZ();
                                this.arrayElement_.addAll(value.arrayElement_);
                            }
                        }
                        if (value.bjR()) {
                            jA(value.getFlags());
                        }
                        e(buN().a(value.unknownFields));
                        return this;
                    }

                    public final boolean isInitialized() {
                        if (bjN() && !bjO().isInitialized()) {
                            return false;
                        }
                        for (int i = 0; i < bjQ(); i++) {
                            if (!jw(i).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    /* renamed from: h */
                    public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                        Value value;
                        Throwable th;
                        Value value2 = null;
                        try {
                            Value value3 = (Value) Value.eKF.b(eVar, fVar);
                            if (value3 != null) {
                                a(value3);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            value = (Value) e.buW();
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            value2 = value;
                        }
                        if (value2 != null) {
                            a(value2);
                        }
                        throw th;
                    }

                    public a a(Type type) {
                        if (type == null) {
                            throw new NullPointerException();
                        }
                        this.bitField0_ |= 1;
                        this.type_ = type;
                        return this;
                    }

                    public a cY(long j) {
                        this.bitField0_ |= 2;
                        this.intValue_ = j;
                        return this;
                    }

                    public a ah(float f) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = f;
                        return this;
                    }

                    public a Y(double d) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = d;
                        return this;
                    }

                    public a jx(int i) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = i;
                        return this;
                    }

                    public a jy(int i) {
                        this.bitField0_ |= 32;
                        this.classId_ = i;
                        return this;
                    }

                    public a jz(int i) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = i;
                        return this;
                    }

                    public boolean bjN() {
                        return (this.bitField0_ & 128) == 128;
                    }

                    public Annotation bjO() {
                        return this.annotation_;
                    }

                    public a d(Annotation annotation) {
                        if ((this.bitField0_ & 128) != 128 || this.annotation_ == Annotation.biV()) {
                            this.annotation_ = annotation;
                        } else {
                            this.annotation_ = Annotation.a(this.annotation_).a(annotation).bke();
                        }
                        this.bitField0_ |= 128;
                        return this;
                    }

                    private void bjZ() {
                        if ((this.bitField0_ & 256) != 256) {
                            this.arrayElement_ = new ArrayList(this.arrayElement_);
                            this.bitField0_ |= 256;
                        }
                    }

                    public int bjQ() {
                        return this.arrayElement_.size();
                    }

                    public Value jw(int i) {
                        return (Value) this.arrayElement_.get(i);
                    }

                    public a jA(int i) {
                        this.bitField0_ |= 512;
                        this.flags_ = i;
                        return this;
                    }
                }

                private Value(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
                    super(aVar);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = aVar.buN();
                }

                private Value(boolean z) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
                }

                public static Value bjz() {
                    return eKH;
                }

                /* renamed from: bjA */
                public Value bjh() {
                    return eKH;
                }

                private Value(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            switch (bue) {
                                case 0:
                                    obj = 1;
                                    break;
                                case 8:
                                    int buo = eVar.buo();
                                    Type valueOf = Type.valueOf(buo);
                                    if (valueOf != null) {
                                        this.bitField0_ |= 1;
                                        this.type_ = valueOf;
                                        break;
                                    }
                                    b.C(bue);
                                    b.C(buo);
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = eVar.bus();
                                    break;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = eVar.readFloat();
                                    break;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = eVar.readDouble();
                                    break;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = eVar.buh();
                                    break;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = eVar.buh();
                                    break;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = eVar.buh();
                                    break;
                                case 66:
                                    b bVar = null;
                                    if ((this.bitField0_ & 128) == 128) {
                                        bVar = this.annotation_.bjf();
                                    }
                                    this.annotation_ = (Annotation) eVar.a(Annotation.eKF, fVar);
                                    if (bVar != null) {
                                        bVar.a(this.annotation_);
                                        this.annotation_ = bVar.bke();
                                    }
                                    this.bitField0_ |= 128;
                                    break;
                                case 74:
                                    if ((i & 256) != 256) {
                                        this.arrayElement_ = new ArrayList();
                                        i |= 256;
                                    }
                                    this.arrayElement_.add(eVar.a(eKF, fVar));
                                    break;
                                case 80:
                                    this.bitField0_ |= 256;
                                    this.flags_ = eVar.buh();
                                    break;
                                default:
                                    if (a(eVar, b, fVar, bue)) {
                                        break;
                                    }
                                    obj = 1;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.g(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                        } catch (Throwable th) {
                            if ((i & 256) == 256) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    if ((i & 256) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    eKH.bja();
                }

                public kotlin.reflect.jvm.internal.impl.protobuf.p<Value> biX() {
                    return eKF;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                public Type bjB() {
                    return this.type_;
                }

                public boolean bjC() {
                    return (this.bitField0_ & 2) == 2;
                }

                public long bjD() {
                    return this.intValue_;
                }

                public boolean bjE() {
                    return (this.bitField0_ & 4) == 4;
                }

                public float bjF() {
                    return this.floatValue_;
                }

                public boolean bjG() {
                    return (this.bitField0_ & 8) == 8;
                }

                public double Mu() {
                    return this.doubleValue_;
                }

                public boolean bjH() {
                    return (this.bitField0_ & 16) == 16;
                }

                public int bjI() {
                    return this.stringValue_;
                }

                public boolean bjJ() {
                    return (this.bitField0_ & 32) == 32;
                }

                public int bjK() {
                    return this.classId_;
                }

                public boolean bjL() {
                    return (this.bitField0_ & 64) == 64;
                }

                public int bjM() {
                    return this.enumValueId_;
                }

                public boolean bjN() {
                    return (this.bitField0_ & 128) == 128;
                }

                public Annotation bjO() {
                    return this.annotation_;
                }

                public List<Value> bjP() {
                    return this.arrayElement_;
                }

                public int bjQ() {
                    return this.arrayElement_.size();
                }

                public Value jw(int i) {
                    return (Value) this.arrayElement_.get(i);
                }

                public boolean bjR() {
                    return (this.bitField0_ & 256) == 256;
                }

                public int getFlags() {
                    return this.flags_;
                }

                private void bja() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.biV();
                    this.arrayElement_ = Collections.emptyList();
                    this.flags_ = 0;
                }

                public final boolean isInitialized() {
                    byte b = this.memoizedIsInitialized;
                    if (b == (byte) 1) {
                        return true;
                    }
                    if (b == (byte) 0) {
                        return false;
                    }
                    if (!bjN() || bjO().isInitialized()) {
                        int i = 0;
                        while (i < bjQ()) {
                            if (jw(i).isInitialized()) {
                                i++;
                            } else {
                                this.memoizedIsInitialized = (byte) 0;
                                return false;
                            }
                        }
                        this.memoizedIsInitialized = (byte) 1;
                        return true;
                    }
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }

                public void a(CodedOutputStream codedOutputStream) {
                    bjb();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.k(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.x(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.a(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.f(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.bg(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.bg(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.bg(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.b(8, this.annotation_);
                    }
                    for (int i = 0; i < this.arrayElement_.size(); i++) {
                        codedOutputStream.b(9, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.arrayElement_.get(i));
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.bg(10, this.flags_);
                    }
                    codedOutputStream.d(this.unknownFields);
                }

                public int bjb() {
                    int i = this.memoizedSerializedSize;
                    if (i != -1) {
                        return i;
                    }
                    int i2 = 0;
                    i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.n(1, this.type_.getNumber()) + 0 : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        i += CodedOutputStream.y(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        i += CodedOutputStream.b(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        i += CodedOutputStream.g(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        i += CodedOutputStream.bh(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        i += CodedOutputStream.bh(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        i += CodedOutputStream.bh(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        i += CodedOutputStream.d(8, this.annotation_);
                    }
                    while (i2 < this.arrayElement_.size()) {
                        i += CodedOutputStream.d(9, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.arrayElement_.get(i2));
                        i2++;
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        i += CodedOutputStream.bh(10, this.flags_);
                    }
                    i += this.unknownFields.size();
                    this.memoizedSerializedSize = i;
                    return i;
                }

                public static a bjS() {
                    return a.bjV();
                }

                /* renamed from: bjT */
                public a bjg() {
                    return bjS();
                }

                public static a b(Value value) {
                    return bjS().a(value);
                }

                /* renamed from: bjU */
                public a bjf() {
                    return b(this);
                }
            }

            public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Argument, a> implements a {
                private int bitField0_;
                private int nameId_;
                private Value value_ = Value.bjz();

                private void bjp() {
                }

                private a() {
                    bjp();
                }

                private static a bjq() {
                    return new a();
                }

                /* renamed from: bjr */
                public a clone() {
                    return bjq().a(bjt());
                }

                /* renamed from: bjj */
                public Argument bju() {
                    return Argument.bji();
                }

                /* renamed from: bjs */
                public Argument bjx() {
                    Object bjt = bjt();
                    if (bjt.isInitialized()) {
                        return bjt;
                    }
                    throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bjt);
                }

                public Argument bjt() {
                    Argument argument = new Argument((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    argument.nameId_ = this.nameId_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.value_ = this.value_;
                    argument.bitField0_ = i2;
                    return argument;
                }

                /* renamed from: c */
                public a a(Argument argument) {
                    if (argument == Argument.bji()) {
                        return this;
                    }
                    if (argument.bjk()) {
                        jv(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        a(argument.bjl());
                    }
                    e(buN().a(argument.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    if (bjk() && hasValue() && bjl().isInitialized()) {
                        return true;
                    }
                    return false;
                }

                /* renamed from: d */
                public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    Argument argument;
                    Throwable th;
                    Argument argument2 = null;
                    try {
                        Argument argument3 = (Argument) Argument.eKF.b(eVar, fVar);
                        if (argument3 != null) {
                            a(argument3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        argument = (Argument) e.buW();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        a(argument2);
                    }
                    throw th;
                }

                public boolean bjk() {
                    return (this.bitField0_ & 1) == 1;
                }

                public a jv(int i) {
                    this.bitField0_ |= 1;
                    this.nameId_ = i;
                    return this;
                }

                public boolean hasValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Value bjl() {
                    return this.value_;
                }

                public a a(Value value) {
                    if ((this.bitField0_ & 2) != 2 || this.value_ == Value.bjz()) {
                        this.value_ = value;
                    } else {
                        this.value_ = Value.b(this.value_).a(value).bjY();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
                super(aVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = aVar.buN();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
            }

            public static Argument bji() {
                return eKG;
            }

            /* renamed from: bjj */
            public Argument bjh() {
                return eKG;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.nameId_ = eVar.buh();
                            } else if (bue == 18) {
                                a aVar = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    aVar = this.value_.bjf();
                                }
                                this.value_ = (Value) eVar.a(Value.eKF, fVar);
                                if (aVar != null) {
                                    aVar.a(this.value_);
                                    this.value_ = aVar.bjY();
                                }
                                this.bitField0_ |= 2;
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
                eKG.bja();
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> biX() {
                return eKF;
            }

            public boolean bjk() {
                return (this.bitField0_ & 1) == 1;
            }

            public int getNameId() {
                return this.nameId_;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public Value bjl() {
                return this.value_;
            }

            private void bja() {
                this.nameId_ = 0;
                this.value_ = Value.bjz();
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                if (!bjk()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (bjl().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }

            public void a(CodedOutputStream codedOutputStream) {
                bjb();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.bg(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.b(2, this.value_);
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
                    i = 0 + CodedOutputStream.bh(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.d(2, this.value_);
                }
                i += this.unknownFields.size();
                this.memoizedSerializedSize = i;
                return i;
            }

            public static a bjm() {
                return a.bjq();
            }

            /* renamed from: bjn */
            public a bjg() {
                return bjm();
            }

            public static a a(Argument argument) {
                return bjm().a(argument);
            }

            /* renamed from: bjo */
            public a bjf() {
                return a(this);
            }
        }

        public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Annotation, b> implements a {
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int id_;

            private void bjp() {
            }

            private b() {
                bjp();
            }

            private static b bkb() {
                return new b();
            }

            /* renamed from: bkc */
            public b clone() {
                return bkb().a(bke());
            }

            /* renamed from: biW */
            public Annotation bju() {
                return Annotation.biV();
            }

            /* renamed from: bkd */
            public Annotation bjx() {
                Object bke = bke();
                if (bke.isInitialized()) {
                    return bke;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bke);
            }

            public Annotation bke() {
                Annotation annotation = new Annotation((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                annotation.id_ = this.id_;
                if ((this.bitField0_ & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -3;
                }
                annotation.argument_ = this.argument_;
                annotation.bitField0_ = i;
                return annotation;
            }

            /* renamed from: e */
            public b a(Annotation annotation) {
                if (annotation == Annotation.biV()) {
                    return this;
                }
                if (annotation.hasId()) {
                    jD(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = annotation.argument_;
                        this.bitField0_ &= -3;
                    } else {
                        bkf();
                        this.argument_.addAll(annotation.argument_);
                    }
                }
                e(buN().a(annotation.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                for (int i = 0; i < biZ(); i++) {
                    if (!ju(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: i */
            public b f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Annotation annotation;
                Throwable th;
                Annotation annotation2 = null;
                try {
                    Annotation annotation3 = (Annotation) Annotation.eKF.b(eVar, fVar);
                    if (annotation3 != null) {
                        a(annotation3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    annotation = (Annotation) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    annotation2 = annotation;
                }
                if (annotation2 != null) {
                    a(annotation2);
                }
                throw th;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public b jD(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            private void bkf() {
                if ((this.bitField0_ & 2) != 2) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 2;
                }
            }

            public int biZ() {
                return this.argument_.size();
            }

            public Argument ju(int i) {
                return (Argument) this.argument_.get(i);
            }
        }

        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private Annotation(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Annotation biV() {
            return eKE;
        }

        /* renamed from: biW */
        public Annotation bjh() {
            return eKE;
        }

        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            this.id_ = eVar.buh();
                        } else if (bue == 18) {
                            if ((i & 2) != 2) {
                                this.argument_ = new ArrayList();
                                i |= 2;
                            }
                            this.argument_.add(eVar.a(Argument.eKF, fVar));
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
            if ((i & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
            eKE.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> biX() {
            return eKF;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public List<Argument> biY() {
            return this.argument_;
        }

        public int biZ() {
            return this.argument_.size();
        }

        public Argument ju(int i) {
            return (Argument) this.argument_.get(i);
        }

        private void bja() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (hasId()) {
                int i = 0;
                while (i < biZ()) {
                    if (ju(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.id_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.b(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.argument_.get(i));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.id_) + 0 : 0;
            while (i2 < this.argument_.size()) {
                i += CodedOutputStream.d(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.argument_.get(i2));
                i2++;
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static b bjc() {
            return b.bkb();
        }

        /* renamed from: bjd */
        public b bjg() {
            return bjc();
        }

        public static b a(Annotation annotation) {
            return bjc().a(annotation);
        }

        /* renamed from: bje */
        public b bjf() {
            return a(this);
        }
    }

    public static final class Contract extends GeneratedMessageLite implements d {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Contract>() {
            /* renamed from: n */
            public Contract b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Contract(eVar, fVar);
            }
        };
        private static final Contract eKK = new Contract(true);
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Contract, a> implements d {
            private int bitField0_;
            private List<Effect> effect_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a blw() {
                return new a();
            }

            /* renamed from: blx */
            public a clone() {
                return blw().a(blz());
            }

            /* renamed from: blr */
            public Contract bju() {
                return Contract.blq();
            }

            /* renamed from: bly */
            public Contract bjx() {
                Object blz = blz();
                if (blz.isInitialized()) {
                    return blz;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(blz);
            }

            public Contract blz() {
                Contract contract = new Contract((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                    this.bitField0_ &= -2;
                }
                contract.effect_ = this.effect_;
                return contract;
            }

            /* renamed from: d */
            public a a(Contract contract) {
                if (contract == Contract.blq()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.effect_.isEmpty()) {
                        this.effect_ = contract.effect_;
                        this.bitField0_ &= -2;
                    } else {
                        blA();
                        this.effect_.addAll(contract.effect_);
                    }
                }
                e(buN().a(contract.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < bls(); i++) {
                    if (!jR(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: o */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Contract contract;
                Throwable th;
                Contract contract2 = null;
                try {
                    Contract contract3 = (Contract) Contract.eKF.b(eVar, fVar);
                    if (contract3 != null) {
                        a(contract3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    contract = (Contract) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    contract2 = contract;
                }
                if (contract2 != null) {
                    a(contract2);
                }
                throw th;
            }

            private void blA() {
                if ((this.bitField0_ & 1) != 1) {
                    this.effect_ = new ArrayList(this.effect_);
                    this.bitField0_ |= 1;
                }
            }

            public int bls() {
                return this.effect_.size();
            }

            public Effect jR(int i) {
                return (Effect) this.effect_.get(i);
            }
        }

        private Contract(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private Contract(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Contract blq() {
            return eKK;
        }

        /* renamed from: blr */
        public Contract bjh() {
            return eKK;
        }

        private Contract(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.effect_ = new ArrayList();
                                i |= 1;
                            }
                            this.effect_.add(eVar.a(Effect.eKF, fVar));
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
                        this.effect_ = Collections.unmodifiableList(this.effect_);
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
                this.effect_ = Collections.unmodifiableList(this.effect_);
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
            eKK.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> biX() {
            return eKF;
        }

        public int bls() {
            return this.effect_.size();
        }

        public Effect jR(int i) {
            return (Effect) this.effect_.get(i);
        }

        private void bja() {
            this.effect_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < bls()) {
                if (jR(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            for (int i = 0; i < this.effect_.size(); i++) {
                codedOutputStream.b(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.effect_.get(i));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.effect_.size(); i++) {
                i2 += CodedOutputStream.d(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.effect_.get(i));
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static a blt() {
            return a.blw();
        }

        /* renamed from: blu */
        public a bjg() {
            return blt();
        }

        public static a a(Contract contract) {
            return blt().a(contract);
        }

        /* renamed from: blv */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Effect extends GeneratedMessageLite implements e {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Effect>() {
            /* renamed from: p */
            public Effect b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Effect(eVar, fVar);
            }
        };
        private static final Effect eKL = new Effect(true);
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public enum EffectType implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<EffectType> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<EffectType>() {
                    /* renamed from: jT */
                    public EffectType jC(int i) {
                        return EffectType.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i) {
                switch (i) {
                    case 0:
                        return RETURNS_CONSTANT;
                    case 1:
                        return CALLS;
                    case 2:
                        return RETURNS_NOT_NULL;
                    default:
                        return null;
                }
            }

            private EffectType(int i, int i2) {
                this.value = i2;
            }
        }

        public enum InvocationKind implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<InvocationKind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<InvocationKind>() {
                    /* renamed from: jU */
                    public InvocationKind jC(int i) {
                        return InvocationKind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i) {
                switch (i) {
                    case 0:
                        return AT_MOST_ONCE;
                    case 1:
                        return EXACTLY_ONCE;
                    case 2:
                        return AT_LEAST_ONCE;
                    default:
                        return null;
                }
            }

            private InvocationKind(int i, int i2) {
                this.value = i2;
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Effect, a> implements e {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_ = Expression.bmf();
            private List<Expression> effectConstructorArgument_ = Collections.emptyList();
            private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
            private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a blO() {
                return new a();
            }

            /* renamed from: blP */
            public a clone() {
                return blO().a(blR());
            }

            /* renamed from: blD */
            public Effect bju() {
                return Effect.blC();
            }

            /* renamed from: blQ */
            public Effect bjx() {
                Object blR = blR();
                if (blR.isInitialized()) {
                    return blR;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(blR);
            }

            public Effect blR() {
                Effect effect = new Effect((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                effect.effectType_ = this.effectType_;
                if ((this.bitField0_ & 2) == 2) {
                    this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    this.bitField0_ &= -3;
                }
                effect.effectConstructorArgument_ = this.effectConstructorArgument_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                effect.kind_ = this.kind_;
                effect.bitField0_ = i2;
                return effect;
            }

            /* renamed from: d */
            public a a(Effect effect) {
                if (effect == Effect.blC()) {
                    return this;
                }
                if (effect.blE()) {
                    a(effect.blF());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.effectConstructorArgument_.isEmpty()) {
                        this.effectConstructorArgument_ = effect.effectConstructorArgument_;
                        this.bitField0_ &= -3;
                    } else {
                        blS();
                        this.effectConstructorArgument_.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.blH()) {
                    a(effect.blI());
                }
                if (effect.blJ()) {
                    a(effect.blK());
                }
                e(buN().a(effect.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < blG(); i++) {
                    if (!jS(i).isInitialized()) {
                        return false;
                    }
                }
                if (!blH() || blI().isInitialized()) {
                    return true;
                }
                return false;
            }

            /* renamed from: q */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Effect effect;
                Throwable th;
                Effect effect2 = null;
                try {
                    Effect effect3 = (Effect) Effect.eKF.b(eVar, fVar);
                    if (effect3 != null) {
                        a(effect3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    effect = (Effect) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    effect2 = effect;
                }
                if (effect2 != null) {
                    a(effect2);
                }
                throw th;
            }

            public a a(EffectType effectType) {
                if (effectType == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.effectType_ = effectType;
                return this;
            }

            private void blS() {
                if ((this.bitField0_ & 2) != 2) {
                    this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                    this.bitField0_ |= 2;
                }
            }

            public int blG() {
                return this.effectConstructorArgument_.size();
            }

            public Expression jS(int i) {
                return (Expression) this.effectConstructorArgument_.get(i);
            }

            public boolean blH() {
                return (this.bitField0_ & 4) == 4;
            }

            public Expression blI() {
                return this.conclusionOfConditionalEffect_;
            }

            public a a(Expression expression) {
                if ((this.bitField0_ & 4) != 4 || this.conclusionOfConditionalEffect_ == Expression.bmf()) {
                    this.conclusionOfConditionalEffect_ = expression;
                } else {
                    this.conclusionOfConditionalEffect_ = Expression.b(this.conclusionOfConditionalEffect_).a(expression).bmx();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public a a(InvocationKind invocationKind) {
                if (invocationKind == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.kind_ = invocationKind;
                return this;
            }
        }

        private Effect(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private Effect(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Effect blC() {
            return eKL;
        }

        /* renamed from: blD */
        public Effect bjh() {
            return eKL;
        }

        private Effect(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                        int buo;
                        if (bue == 8) {
                            buo = eVar.buo();
                            EffectType valueOf = EffectType.valueOf(buo);
                            if (valueOf == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = valueOf;
                            }
                        } else if (bue == 18) {
                            if ((i & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                i |= 2;
                            }
                            this.effectConstructorArgument_.add(eVar.a(Expression.eKF, fVar));
                        } else if (bue == 26) {
                            a aVar = null;
                            if ((this.bitField0_ & 2) == 2) {
                                aVar = this.conclusionOfConditionalEffect_.bjf();
                            }
                            this.conclusionOfConditionalEffect_ = (Expression) eVar.a(Expression.eKF, fVar);
                            if (aVar != null) {
                                aVar.a(this.conclusionOfConditionalEffect_);
                                this.conclusionOfConditionalEffect_ = aVar.bmx();
                            }
                            this.bitField0_ |= 2;
                        } else if (bue == 32) {
                            buo = eVar.buo();
                            InvocationKind valueOf2 = InvocationKind.valueOf(buo);
                            if (valueOf2 == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = valueOf2;
                            }
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            if ((i & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
            eKL.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> biX() {
            return eKF;
        }

        public boolean blE() {
            return (this.bitField0_ & 1) == 1;
        }

        public EffectType blF() {
            return this.effectType_;
        }

        public int blG() {
            return this.effectConstructorArgument_.size();
        }

        public Expression jS(int i) {
            return (Expression) this.effectConstructorArgument_.get(i);
        }

        public boolean blH() {
            return (this.bitField0_ & 2) == 2;
        }

        public Expression blI() {
            return this.conclusionOfConditionalEffect_;
        }

        public boolean blJ() {
            return (this.bitField0_ & 4) == 4;
        }

        public InvocationKind blK() {
            return this.kind_;
        }

        private void bja() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.bmf();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < blG()) {
                if (jS(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!blH() || blI().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.k(1, this.effectType_.getNumber());
            }
            for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
                codedOutputStream.b(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.effectConstructorArgument_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.b(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.k(4, this.kind_.getNumber());
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.n(1, this.effectType_.getNumber()) + 0 : 0;
            while (i2 < this.effectConstructorArgument_.size()) {
                i += CodedOutputStream.d(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.effectConstructorArgument_.get(i2));
                i2++;
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.d(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.n(4, this.kind_.getNumber());
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a blL() {
            return a.blO();
        }

        /* renamed from: blM */
        public a bjg() {
            return blL();
        }

        public static a a(Effect effect) {
            return blL().a(effect);
        }

        /* renamed from: blN */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Expression extends GeneratedMessageLite implements g {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Expression>() {
            /* renamed from: t */
            public Expression b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Expression(eVar, fVar);
            }
        };
        private static final Expression eKN = new Expression(true);
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int valueParameterReference_;

        public enum ConstantValue implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<ConstantValue> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<ConstantValue>() {
                    /* renamed from: kb */
                    public ConstantValue jC(int i) {
                        return ConstantValue.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i) {
                switch (i) {
                    case 0:
                        return TRUE;
                    case 1:
                        return FALSE;
                    case 2:
                        return NULL;
                    default:
                        return null;
                }
            }

            private ConstantValue(int i, int i2) {
                this.value = i2;
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Expression, a> implements g {
            private List<Expression> andArgument_ = Collections.emptyList();
            private int bitField0_;
            private ConstantValue constantValue_ = ConstantValue.TRUE;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_ = Type.bok();
            private List<Expression> orArgument_ = Collections.emptyList();
            private int valueParameterReference_;

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bmu() {
                return new a();
            }

            /* renamed from: bmv */
            public a clone() {
                return bmu().a(bmx());
            }

            /* renamed from: bmg */
            public Expression bju() {
                return Expression.bmf();
            }

            /* renamed from: bmw */
            public Expression bjx() {
                Object bmx = bmx();
                if (bmx.isInitialized()) {
                    return bmx;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bmx);
            }

            public Expression bmx() {
                Expression expression = new Expression((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                expression.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                expression.valueParameterReference_ = this.valueParameterReference_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                expression.constantValue_ = this.constantValue_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                expression.isInstanceType_ = this.isInstanceType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                expression.isInstanceTypeId_ = this.isInstanceTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    this.bitField0_ &= -33;
                }
                expression.andArgument_ = this.andArgument_;
                if ((this.bitField0_ & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    this.bitField0_ &= -65;
                }
                expression.orArgument_ = this.orArgument_;
                expression.bitField0_ = i2;
                return expression;
            }

            /* renamed from: f */
            public a a(Expression expression) {
                if (expression == Expression.bmf()) {
                    return this;
                }
                if (expression.bjR()) {
                    jY(expression.getFlags());
                }
                if (expression.bmh()) {
                    jZ(expression.bmi());
                }
                if (expression.bmj()) {
                    a(expression.bmk());
                }
                if (expression.bml()) {
                    a(expression.bmm());
                }
                if (expression.bmn()) {
                    ka(expression.bmo());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.andArgument_.isEmpty()) {
                        this.andArgument_ = expression.andArgument_;
                        this.bitField0_ &= -33;
                    } else {
                        bmy();
                        this.andArgument_.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.orArgument_.isEmpty()) {
                        this.orArgument_ = expression.orArgument_;
                        this.bitField0_ &= -65;
                    } else {
                        bmz();
                        this.orArgument_.addAll(expression.orArgument_);
                    }
                }
                e(buN().a(expression.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (bml() && !bmm().isInitialized()) {
                    return false;
                }
                int i;
                for (i = 0; i < bmp(); i++) {
                    if (!jW(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bmq(); i++) {
                    if (!jX(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: u */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Expression expression;
                Throwable th;
                Expression expression2 = null;
                try {
                    Expression expression3 = (Expression) Expression.eKF.b(eVar, fVar);
                    if (expression3 != null) {
                        a(expression3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    expression = (Expression) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    expression2 = expression;
                }
                if (expression2 != null) {
                    a(expression2);
                }
                throw th;
            }

            public a jY(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public a jZ(int i) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = i;
                return this;
            }

            public a a(ConstantValue constantValue) {
                if (constantValue == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.constantValue_ = constantValue;
                return this;
            }

            public boolean bml() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type bmm() {
                return this.isInstanceType_;
            }

            public a a(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.isInstanceType_ == Type.bok()) {
                    this.isInstanceType_ = type;
                } else {
                    this.isInstanceType_ = Type.f(this.isInstanceType_).a(type).bpe();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public a ka(int i) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = i;
                return this;
            }

            private void bmy() {
                if ((this.bitField0_ & 32) != 32) {
                    this.andArgument_ = new ArrayList(this.andArgument_);
                    this.bitField0_ |= 32;
                }
            }

            public int bmp() {
                return this.andArgument_.size();
            }

            public Expression jW(int i) {
                return (Expression) this.andArgument_.get(i);
            }

            private void bmz() {
                if ((this.bitField0_ & 64) != 64) {
                    this.orArgument_ = new ArrayList(this.orArgument_);
                    this.bitField0_ |= 64;
                }
            }

            public int bmq() {
                return this.orArgument_.size();
            }

            public Expression jX(int i) {
                return (Expression) this.orArgument_.get(i);
            }
        }

        private Expression(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private Expression(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Expression bmf() {
            return eKN;
        }

        /* renamed from: bmg */
        public Expression bjh() {
            return eKN;
        }

        private Expression(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            this.flags_ = eVar.buh();
                        } else if (bue == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = eVar.buh();
                        } else if (bue == 24) {
                            int buo = eVar.buo();
                            ConstantValue valueOf = ConstantValue.valueOf(buo);
                            if (valueOf == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = valueOf;
                            }
                        } else if (bue == 34) {
                            b bVar = null;
                            if ((this.bitField0_ & 8) == 8) {
                                bVar = this.isInstanceType_.bjf();
                            }
                            this.isInstanceType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.isInstanceType_);
                                this.isInstanceType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 8;
                        } else if (bue == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = eVar.buh();
                        } else if (bue == 50) {
                            if ((i & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i |= 32;
                            }
                            this.andArgument_.add(eVar.a(eKF, fVar));
                        } else if (bue == 58) {
                            if ((i & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i |= 64;
                            }
                            this.orArgument_.add(eVar.a(eKF, fVar));
                        } else if (a(eVar, b, fVar, bue)) {
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if ((i & 64) == 64) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            if ((i & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if ((i & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            eKN.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean bmh() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bmi() {
            return this.valueParameterReference_;
        }

        public boolean bmj() {
            return (this.bitField0_ & 4) == 4;
        }

        public ConstantValue bmk() {
            return this.constantValue_;
        }

        public boolean bml() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type bmm() {
            return this.isInstanceType_;
        }

        public boolean bmn() {
            return (this.bitField0_ & 16) == 16;
        }

        public int bmo() {
            return this.isInstanceTypeId_;
        }

        public int bmp() {
            return this.andArgument_.size();
        }

        public Expression jW(int i) {
            return (Expression) this.andArgument_.get(i);
        }

        public int bmq() {
            return this.orArgument_.size();
        }

        public Expression jX(int i) {
            return (Expression) this.orArgument_.get(i);
        }

        private void bja() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.bok();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!bml() || bmm().isInitialized()) {
                int i = 0;
                while (i < bmp()) {
                    if (jW(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bmq()) {
                    if (jX(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.k(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.b(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.bg(5, this.isInstanceTypeId_);
            }
            for (int i = 0; i < this.andArgument_.size(); i++) {
                codedOutputStream.b(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.andArgument_.get(i));
            }
            for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
                codedOutputStream.b(7, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.orArgument_.get(i2));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.n(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.d(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.bh(5, this.isInstanceTypeId_);
            }
            int i3 = i;
            for (i = 0; i < this.andArgument_.size(); i++) {
                i3 += CodedOutputStream.d(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.andArgument_.get(i));
            }
            while (i2 < this.orArgument_.size()) {
                i3 += CodedOutputStream.d(7, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.orArgument_.get(i2));
                i2++;
            }
            i3 += this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static a bmr() {
            return a.bmu();
        }

        /* renamed from: bms */
        public a bjg() {
            return bmr();
        }

        public static a b(Expression expression) {
            return bmr().a(expression);
        }

        /* renamed from: bmt */
        public a bjf() {
            return b(this);
        }
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements k {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedNameTable>() {
            /* renamed from: B */
            public QualifiedNameTable b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new QualifiedNameTable(eVar, fVar);
            }
        };
        private static final QualifiedNameTable eKR = new QualifiedNameTable(true);
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public interface b extends kotlin.reflect.jvm.internal.impl.protobuf.o {
        }

        public static final class QualifiedName extends GeneratedMessageLite implements b {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedName>() {
                /* renamed from: D */
                public QualifiedName b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    return new QualifiedName(eVar, fVar);
                }
            };
            private static final QualifiedName eKS = new QualifiedName(true);
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            public enum Kind implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Kind> internalValueMap;
                private final int value;

                static {
                    internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Kind>() {
                        /* renamed from: kt */
                        public Kind jC(int i) {
                            return Kind.valueOf(i);
                        }
                    };
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i) {
                    switch (i) {
                        case 0:
                            return CLASS;
                        case 1:
                            return PACKAGE;
                        case 2:
                            return LOCAL;
                        default:
                            return null;
                    }
                }

                private Kind(int i, int i2) {
                    this.value = i2;
                }
            }

            public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<QualifiedName, a> implements b {
                private int bitField0_;
                private Kind kind_ = Kind.PACKAGE;
                private int parentQualifiedName_ = -1;
                private int shortName_;

                private void bjp() {
                }

                private a() {
                    bjp();
                }

                private static a bnT() {
                    return new a();
                }

                /* renamed from: bnU */
                public a clone() {
                    return bnT().a(bnW());
                }

                /* renamed from: bnK */
                public QualifiedName bju() {
                    return QualifiedName.bnJ();
                }

                /* renamed from: bnV */
                public QualifiedName bjx() {
                    Object bnW = bnW();
                    if (bnW.isInitialized()) {
                        return bnW;
                    }
                    throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bnW);
                }

                public QualifiedName bnW() {
                    QualifiedName qualifiedName = new QualifiedName((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    qualifiedName.shortName_ = this.shortName_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    qualifiedName.kind_ = this.kind_;
                    qualifiedName.bitField0_ = i2;
                    return qualifiedName;
                }

                /* renamed from: c */
                public a a(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.bnJ()) {
                        return this;
                    }
                    if (qualifiedName.bnL()) {
                        kr(qualifiedName.bnM());
                    }
                    if (qualifiedName.bnN()) {
                        ks(qualifiedName.bnO());
                    }
                    if (qualifiedName.blJ()) {
                        a(qualifiedName.bnP());
                    }
                    e(buN().a(qualifiedName.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    return bnN();
                }

                /* renamed from: E */
                public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    QualifiedName qualifiedName;
                    Throwable th;
                    QualifiedName qualifiedName2 = null;
                    try {
                        QualifiedName qualifiedName3 = (QualifiedName) QualifiedName.eKF.b(eVar, fVar);
                        if (qualifiedName3 != null) {
                            a(qualifiedName3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        qualifiedName = (QualifiedName) e.buW();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        qualifiedName2 = qualifiedName;
                    }
                    if (qualifiedName2 != null) {
                        a(qualifiedName2);
                    }
                    throw th;
                }

                public a kr(int i) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = i;
                    return this;
                }

                public boolean bnN() {
                    return (this.bitField0_ & 2) == 2;
                }

                public a ks(int i) {
                    this.bitField0_ |= 2;
                    this.shortName_ = i;
                    return this;
                }

                public a a(Kind kind) {
                    if (kind == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 4;
                    this.kind_ = kind;
                    return this;
                }
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
                super(aVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = aVar.buN();
            }

            private QualifiedName(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
            }

            public static QualifiedName bnJ() {
                return eKS;
            }

            /* renamed from: bnK */
            public QualifiedName bjh() {
                return eKS;
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.parentQualifiedName_ = eVar.buh();
                            } else if (bue == 16) {
                                this.bitField0_ |= 2;
                                this.shortName_ = eVar.buh();
                            } else if (bue == 24) {
                                int buo = eVar.buo();
                                Kind valueOf = Kind.valueOf(buo);
                                if (valueOf == null) {
                                    b.C(bue);
                                    b.C(buo);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf;
                                }
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
                eKS.bja();
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> biX() {
                return eKF;
            }

            public boolean bnL() {
                return (this.bitField0_ & 1) == 1;
            }

            public int bnM() {
                return this.parentQualifiedName_;
            }

            public boolean bnN() {
                return (this.bitField0_ & 2) == 2;
            }

            public int bnO() {
                return this.shortName_;
            }

            public boolean blJ() {
                return (this.bitField0_ & 4) == 4;
            }

            public Kind bnP() {
                return this.kind_;
            }

            private void bja() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                if (bnN()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            public void a(CodedOutputStream codedOutputStream) {
                bjb();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.bg(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.bg(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.k(3, this.kind_.getNumber());
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
                    i = 0 + CodedOutputStream.bh(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.bh(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.n(3, this.kind_.getNumber());
                }
                i += this.unknownFields.size();
                this.memoizedSerializedSize = i;
                return i;
            }

            public static a bnQ() {
                return a.bnT();
            }

            /* renamed from: bnR */
            public a bjg() {
                return bnQ();
            }

            public static a a(QualifiedName qualifiedName) {
                return bnQ().a(qualifiedName);
            }

            /* renamed from: bnS */
            public a bjf() {
                return a(this);
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<QualifiedNameTable, a> implements k {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bnD() {
                return new a();
            }

            /* renamed from: bnE */
            public a clone() {
                return bnD().a(bnG());
            }

            /* renamed from: bny */
            public QualifiedNameTable bju() {
                return QualifiedNameTable.bnx();
            }

            /* renamed from: bnF */
            public QualifiedNameTable bjx() {
                Object bnG = bnG();
                if (bnG.isInitialized()) {
                    return bnG;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bnG);
            }

            public QualifiedNameTable bnG() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    this.bitField0_ &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.qualifiedName_;
                return qualifiedNameTable;
            }

            /* renamed from: d */
            public a a(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.bnx()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.qualifiedName_.isEmpty()) {
                        this.qualifiedName_ = qualifiedNameTable.qualifiedName_;
                        this.bitField0_ &= -2;
                    } else {
                        bnH();
                        this.qualifiedName_.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                e(buN().a(qualifiedNameTable.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < bnz(); i++) {
                    if (!kq(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: C */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                QualifiedNameTable qualifiedNameTable;
                Throwable th;
                QualifiedNameTable qualifiedNameTable2 = null;
                try {
                    QualifiedNameTable qualifiedNameTable3 = (QualifiedNameTable) QualifiedNameTable.eKF.b(eVar, fVar);
                    if (qualifiedNameTable3 != null) {
                        a(qualifiedNameTable3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    qualifiedNameTable = (QualifiedNameTable) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    qualifiedNameTable2 = qualifiedNameTable;
                }
                if (qualifiedNameTable2 != null) {
                    a(qualifiedNameTable2);
                }
                throw th;
            }

            private void bnH() {
                if ((this.bitField0_ & 1) != 1) {
                    this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                    this.bitField0_ |= 1;
                }
            }

            public int bnz() {
                return this.qualifiedName_.size();
            }

            public QualifiedName kq(int i) {
                return (QualifiedName) this.qualifiedName_.get(i);
            }
        }

        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private QualifiedNameTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static QualifiedNameTable bnx() {
            return eKR;
        }

        /* renamed from: bny */
        public QualifiedNameTable bjh() {
            return eKR;
        }

        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.qualifiedName_ = new ArrayList();
                                i |= 1;
                            }
                            this.qualifiedName_.add(eVar.a(QualifiedName.eKF, fVar));
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
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            eKR.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> biX() {
            return eKF;
        }

        public int bnz() {
            return this.qualifiedName_.size();
        }

        public QualifiedName kq(int i) {
            return (QualifiedName) this.qualifiedName_.get(i);
        }

        private void bja() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < bnz()) {
                if (kq(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            for (int i = 0; i < this.qualifiedName_.size(); i++) {
                codedOutputStream.b(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.qualifiedName_.get(i));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.qualifiedName_.size(); i++) {
                i2 += CodedOutputStream.d(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.qualifiedName_.get(i));
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static a bnA() {
            return a.bnD();
        }

        /* renamed from: bnB */
        public a bjg() {
            return bnA();
        }

        public static a a(QualifiedNameTable qualifiedNameTable) {
            return bnA().a(qualifiedNameTable);
        }

        /* renamed from: bnC */
        public a bjf() {
            return a(this);
        }
    }

    public static final class StringTable extends GeneratedMessageLite implements l {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<StringTable>() {
            /* renamed from: F */
            public StringTable b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new StringTable(eVar, fVar);
            }
        };
        private static final StringTable eKT = new StringTable(true);
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private kotlin.reflect.jvm.internal.impl.protobuf.l string_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<StringTable, a> implements l {
            private int bitField0_;
            private kotlin.reflect.jvm.internal.impl.protobuf.l string_ = kotlin.reflect.jvm.internal.impl.protobuf.k.eOo;

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a boe() {
                return new a();
            }

            /* renamed from: bof */
            public a clone() {
                return boe().a(boh());
            }

            /* renamed from: bnZ */
            public StringTable bju() {
                return StringTable.bnY();
            }

            /* renamed from: bog */
            public StringTable bjx() {
                Object boh = boh();
                if (boh.isInitialized()) {
                    return boh;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(boh);
            }

            public StringTable boh() {
                StringTable stringTable = new StringTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.string_ = this.string_.bvi();
                    this.bitField0_ &= -2;
                }
                stringTable.string_ = this.string_;
                return stringTable;
            }

            /* renamed from: d */
            public a a(StringTable stringTable) {
                if (stringTable == StringTable.bnY()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.string_.isEmpty()) {
                        this.string_ = stringTable.string_;
                        this.bitField0_ &= -2;
                    } else {
                        boi();
                        this.string_.addAll(stringTable.string_);
                    }
                }
                e(buN().a(stringTable.unknownFields));
                return this;
            }

            /* renamed from: G */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                StringTable stringTable;
                Throwable th;
                StringTable stringTable2 = null;
                try {
                    StringTable stringTable3 = (StringTable) StringTable.eKF.b(eVar, fVar);
                    if (stringTable3 != null) {
                        a(stringTable3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    stringTable = (StringTable) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    stringTable2 = stringTable;
                }
                if (stringTable2 != null) {
                    a(stringTable2);
                }
                throw th;
            }

            private void boi() {
                if ((this.bitField0_ & 1) != 1) {
                    this.string_ = new kotlin.reflect.jvm.internal.impl.protobuf.k(this.string_);
                    this.bitField0_ |= 1;
                }
            }
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private StringTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static StringTable bnY() {
            return eKT;
        }

        /* renamed from: bnZ */
        public StringTable bjh() {
            return eKT;
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            kotlin.reflect.jvm.internal.impl.protobuf.d bum = eVar.bum();
                            if ((i & 1) != 1) {
                                this.string_ = new kotlin.reflect.jvm.internal.impl.protobuf.k();
                                i |= 1;
                            }
                            this.string_.f(bum);
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
                        this.string_ = this.string_.bvi();
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
                this.string_ = this.string_.bvi();
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
            eKT.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> biX() {
            return eKF;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.q boa() {
            return this.string_;
        }

        public String getString(int i) {
            return (String) this.string_.get(i);
        }

        private void bja() {
            this.string_ = kotlin.reflect.jvm.internal.impl.protobuf.k.eOo;
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
            for (int i = 0; i < this.string_.size(); i++) {
                codedOutputStream.a(1, this.string_.lJ(i));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.string_.size(); i3++) {
                i2 += CodedOutputStream.c(this.string_.lJ(i3));
            }
            i2 = ((i2 + 0) + (boa().size() * 1)) + this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static a bob() {
            return a.boe();
        }

        /* renamed from: boc */
        public a bjg() {
            return bob();
        }

        public static a a(StringTable stringTable) {
            return bob().a(stringTable);
        }

        /* renamed from: bod */
        public a bjf() {
            return a(this);
        }
    }

    public static final class TypeTable extends GeneratedMessageLite implements p {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<TypeTable>() {
            /* renamed from: P */
            public TypeTable b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new TypeTable(eVar, fVar);
            }
        };
        private static final TypeTable eKY = new TypeTable(true);
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<TypeTable, a> implements p {
            private int bitField0_;
            private int firstNullable_ = -1;
            private List<Type> type_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bqd() {
                return new a();
            }

            /* renamed from: bqe */
            public a clone() {
                return bqd().a(bqg());
            }

            /* renamed from: bpV */
            public TypeTable bju() {
                return TypeTable.bpU();
            }

            /* renamed from: bqf */
            public TypeTable bjx() {
                Object bqg = bqg();
                if (bqg.isInitialized()) {
                    return bqg;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bqg);
            }

            public TypeTable bqg() {
                TypeTable typeTable = new TypeTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((this.bitField0_ & 1) == 1) {
                    this.type_ = Collections.unmodifiableList(this.type_);
                    this.bitField0_ &= -2;
                }
                typeTable.type_ = this.type_;
                if ((i & 2) != 2) {
                    i2 = 0;
                }
                typeTable.firstNullable_ = this.firstNullable_;
                typeTable.bitField0_ = i2;
                return typeTable;
            }

            /* renamed from: g */
            public a a(TypeTable typeTable) {
                if (typeTable == TypeTable.bpU()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.type_.isEmpty()) {
                        this.type_ = typeTable.type_;
                        this.bitField0_ &= -2;
                    } else {
                        bqh();
                        this.type_.addAll(typeTable.type_);
                    }
                }
                if (typeTable.bpY()) {
                    kQ(typeTable.bpZ());
                }
                e(buN().a(typeTable.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < bpX(); i++) {
                    if (!kP(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: Q */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                TypeTable typeTable;
                Throwable th;
                TypeTable typeTable2 = null;
                try {
                    TypeTable typeTable3 = (TypeTable) TypeTable.eKF.b(eVar, fVar);
                    if (typeTable3 != null) {
                        a(typeTable3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeTable = (TypeTable) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    typeTable2 = typeTable;
                }
                if (typeTable2 != null) {
                    a(typeTable2);
                }
                throw th;
            }

            private void bqh() {
                if ((this.bitField0_ & 1) != 1) {
                    this.type_ = new ArrayList(this.type_);
                    this.bitField0_ |= 1;
                }
            }

            public int bpX() {
                return this.type_.size();
            }

            public Type kP(int i) {
                return (Type) this.type_.get(i);
            }

            public a kQ(int i) {
                this.bitField0_ |= 2;
                this.firstNullable_ = i;
                return this;
            }
        }

        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private TypeTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static TypeTable bpU() {
            return eKY;
        }

        /* renamed from: bpV */
        public TypeTable bjh() {
            return eKY;
        }

        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.type_ = new ArrayList();
                                i |= 1;
                            }
                            this.type_.add(eVar.a(Type.eKF, fVar));
                        } else if (bue == 16) {
                            this.bitField0_ |= 1;
                            this.firstNullable_ = eVar.buh();
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
                        this.type_ = Collections.unmodifiableList(this.type_);
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
                this.type_ = Collections.unmodifiableList(this.type_);
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
            eKY.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> biX() {
            return eKF;
        }

        public List<Type> bpW() {
            return this.type_;
        }

        public int bpX() {
            return this.type_.size();
        }

        public Type kP(int i) {
            return (Type) this.type_.get(i);
        }

        public boolean bpY() {
            return (this.bitField0_ & 1) == 1;
        }

        public int bpZ() {
            return this.firstNullable_;
        }

        private void bja() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < bpX()) {
                if (kP(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            for (int i = 0; i < this.type_.size(); i++) {
                codedOutputStream.b(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(2, this.firstNullable_);
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.type_.size(); i++) {
                i2 += CodedOutputStream.d(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.type_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.bh(2, this.firstNullable_);
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static a bqa() {
            return a.bqd();
        }

        /* renamed from: bqb */
        public a bjg() {
            return bqa();
        }

        public static a d(TypeTable typeTable) {
            return bqa().a(typeTable);
        }

        /* renamed from: bqc */
        public a bjf() {
            return d(this);
        }
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements r {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirement>() {
            /* renamed from: T */
            public VersionRequirement b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new VersionRequirement(eVar, fVar);
            }
        };
        private static final VersionRequirement eLa = new VersionRequirement(true);
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        public enum Level implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Level> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Level>() {
                    /* renamed from: kZ */
                    public Level jC(int i) {
                        return Level.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i) {
                switch (i) {
                    case 0:
                        return WARNING;
                    case 1:
                        return ERROR;
                    case 2:
                        return HIDDEN;
                    default:
                        return null;
                }
            }

            private Level(int i, int i2) {
                this.value = i2;
            }
        }

        public enum VersionKind implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<VersionKind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<VersionKind>() {
                    /* renamed from: la */
                    public VersionKind jC(int i) {
                        return VersionKind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i) {
                switch (i) {
                    case 0:
                        return LANGUAGE_VERSION;
                    case 1:
                        return COMPILER_VERSION;
                    case 2:
                        return API_VERSION;
                    default:
                        return null;
                }
            }

            private VersionKind(int i, int i2) {
                this.value = i2;
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<VersionRequirement, a> implements r {
            private int bitField0_;
            private int errorCode_;
            private Level level_ = Level.ERROR;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;
            private int version_;

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bqM() {
                return new a();
            }

            /* renamed from: bqN */
            public a clone() {
                return bqM().a(bqP());
            }

            /* renamed from: bqy */
            public VersionRequirement bju() {
                return VersionRequirement.bqx();
            }

            /* renamed from: bqO */
            public VersionRequirement bjx() {
                Object bqP = bqP();
                if (bqP.isInitialized()) {
                    return bqP;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bqP);
            }

            public VersionRequirement bqP() {
                VersionRequirement versionRequirement = new VersionRequirement((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                versionRequirement.version_ = this.version_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                versionRequirement.versionFull_ = this.versionFull_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                versionRequirement.level_ = this.level_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                versionRequirement.errorCode_ = this.errorCode_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                versionRequirement.message_ = this.message_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                versionRequirement.versionKind_ = this.versionKind_;
                versionRequirement.bitField0_ = i2;
                return versionRequirement;
            }

            /* renamed from: c */
            public a a(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.bqx()) {
                    return this;
                }
                if (versionRequirement.bqz()) {
                    kV(versionRequirement.getVersion());
                }
                if (versionRequirement.bqA()) {
                    kW(versionRequirement.bqB());
                }
                if (versionRequirement.bqC()) {
                    a(versionRequirement.bqD());
                }
                if (versionRequirement.bqE()) {
                    kX(versionRequirement.getErrorCode());
                }
                if (versionRequirement.bqF()) {
                    kY(versionRequirement.bqG());
                }
                if (versionRequirement.bqH()) {
                    a(versionRequirement.bqI());
                }
                e(buN().a(versionRequirement.unknownFields));
                return this;
            }

            /* renamed from: U */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                VersionRequirement versionRequirement;
                Throwable th;
                VersionRequirement versionRequirement2 = null;
                try {
                    VersionRequirement versionRequirement3 = (VersionRequirement) VersionRequirement.eKF.b(eVar, fVar);
                    if (versionRequirement3 != null) {
                        a(versionRequirement3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    versionRequirement = (VersionRequirement) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirement2 = versionRequirement;
                }
                if (versionRequirement2 != null) {
                    a(versionRequirement2);
                }
                throw th;
            }

            public a kV(int i) {
                this.bitField0_ |= 1;
                this.version_ = i;
                return this;
            }

            public a kW(int i) {
                this.bitField0_ |= 2;
                this.versionFull_ = i;
                return this;
            }

            public a a(Level level) {
                if (level == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.level_ = level;
                return this;
            }

            public a kX(int i) {
                this.bitField0_ |= 8;
                this.errorCode_ = i;
                return this;
            }

            public a kY(int i) {
                this.bitField0_ |= 16;
                this.message_ = i;
                return this;
            }

            public a a(VersionKind versionKind) {
                if (versionKind == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.versionKind_ = versionKind;
                return this;
            }
        }

        private VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private VersionRequirement(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static VersionRequirement bqx() {
            return eLa;
        }

        /* renamed from: bqy */
        public VersionRequirement bjh() {
            return eLa;
        }

        private VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                        int buo;
                        if (bue == 8) {
                            this.bitField0_ |= 1;
                            this.version_ = eVar.buh();
                        } else if (bue == 16) {
                            this.bitField0_ |= 2;
                            this.versionFull_ = eVar.buh();
                        } else if (bue == 24) {
                            buo = eVar.buo();
                            Level valueOf = Level.valueOf(buo);
                            if (valueOf == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 4;
                                this.level_ = valueOf;
                            }
                        } else if (bue == 32) {
                            this.bitField0_ |= 8;
                            this.errorCode_ = eVar.buh();
                        } else if (bue == 40) {
                            this.bitField0_ |= 16;
                            this.message_ = eVar.buh();
                        } else if (bue == 48) {
                            buo = eVar.buo();
                            VersionKind valueOf2 = VersionKind.valueOf(buo);
                            if (valueOf2 == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 32;
                                this.versionKind_ = valueOf2;
                            }
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
            eLa.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> biX() {
            return eKF;
        }

        public boolean bqz() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getVersion() {
            return this.version_;
        }

        public boolean bqA() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bqB() {
            return this.versionFull_;
        }

        public boolean bqC() {
            return (this.bitField0_ & 4) == 4;
        }

        public Level bqD() {
            return this.level_;
        }

        public boolean bqE() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public boolean bqF() {
            return (this.bitField0_ & 16) == 16;
        }

        public int bqG() {
            return this.message_;
        }

        public boolean bqH() {
            return (this.bitField0_ & 32) == 32;
        }

        public VersionKind bqI() {
            return this.versionKind_;
        }

        private void bja() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
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
                codedOutputStream.bg(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.k(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.bg(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.bg(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.k(6, this.versionKind_.getNumber());
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
                i = 0 + CodedOutputStream.bh(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.n(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.bh(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.bh(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.n(6, this.versionKind_.getNumber());
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a bqJ() {
            return a.bqM();
        }

        /* renamed from: bqK */
        public a bjg() {
            return bqJ();
        }

        public static a a(VersionRequirement versionRequirement) {
            return bqJ().a(versionRequirement);
        }

        /* renamed from: bqL */
        public a bjf() {
            return a(this);
        }
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements s {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirementTable>() {
            /* renamed from: V */
            public VersionRequirementTable b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new VersionRequirementTable(eVar, fVar);
            }
        };
        private static final VersionRequirementTable eLb = new VersionRequirementTable(true);
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<VersionRequirementTable, a> implements s {
            private int bitField0_;
            private List<VersionRequirement> requirement_ = Collections.emptyList();

            private void bjp() {
            }

            public final boolean isInitialized() {
                return true;
            }

            private a() {
                bjp();
            }

            private static a bqY() {
                return new a();
            }

            /* renamed from: bqZ */
            public a clone() {
                return bqY().a(brb());
            }

            /* renamed from: bqS */
            public VersionRequirementTable bju() {
                return VersionRequirementTable.bqR();
            }

            /* renamed from: bra */
            public VersionRequirementTable bjx() {
                Object brb = brb();
                if (brb.isInitialized()) {
                    return brb;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(brb);
            }

            public VersionRequirementTable brb() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    this.bitField0_ &= -2;
                }
                versionRequirementTable.requirement_ = this.requirement_;
                return versionRequirementTable;
            }

            /* renamed from: f */
            public a a(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.bqR()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.requirement_.isEmpty()) {
                        this.requirement_ = versionRequirementTable.requirement_;
                        this.bitField0_ &= -2;
                    } else {
                        brc();
                        this.requirement_.addAll(versionRequirementTable.requirement_);
                    }
                }
                e(buN().a(versionRequirementTable.unknownFields));
                return this;
            }

            /* renamed from: W */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                VersionRequirementTable versionRequirementTable;
                Throwable th;
                VersionRequirementTable versionRequirementTable2 = null;
                try {
                    VersionRequirementTable versionRequirementTable3 = (VersionRequirementTable) VersionRequirementTable.eKF.b(eVar, fVar);
                    if (versionRequirementTable3 != null) {
                        a(versionRequirementTable3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    versionRequirementTable = (VersionRequirementTable) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    versionRequirementTable2 = versionRequirementTable;
                }
                if (versionRequirementTable2 != null) {
                    a(versionRequirementTable2);
                }
                throw th;
            }

            private void brc() {
                if ((this.bitField0_ & 1) != 1) {
                    this.requirement_ = new ArrayList(this.requirement_);
                    this.bitField0_ |= 1;
                }
            }
        }

        private VersionRequirementTable(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private VersionRequirementTable(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static VersionRequirementTable bqR() {
            return eLb;
        }

        /* renamed from: bqS */
        public VersionRequirementTable bjh() {
            return eLb;
        }

        private VersionRequirementTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                this.requirement_ = new ArrayList();
                                i |= 1;
                            }
                            this.requirement_.add(eVar.a(VersionRequirement.eKF, fVar));
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
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            eLb.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> biX() {
            return eKF;
        }

        public List<VersionRequirement> bqT() {
            return this.requirement_;
        }

        public int bqU() {
            return this.requirement_.size();
        }

        private void bja() {
            this.requirement_ = Collections.emptyList();
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
            for (int i = 0; i < this.requirement_.size(); i++) {
                codedOutputStream.b(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.requirement_.get(i));
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (i = 0; i < this.requirement_.size(); i++) {
                i2 += CodedOutputStream.d(1, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.requirement_.get(i));
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static a bqV() {
            return a.bqY();
        }

        /* renamed from: bqW */
        public a bjg() {
            return bqV();
        }

        public static a c(VersionRequirementTable versionRequirementTable) {
            return bqV().a(versionRequirementTable);
        }

        /* renamed from: bqX */
        public a bjf() {
            return c(this);
        }
    }

    public static final class Class extends ExtendableMessage<Class> implements b {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Class> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Class>() {
            /* renamed from: j */
            public Class b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Class(eVar, fVar);
            }
        };
        private static final Class eKI = new Class(true);
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        public enum Kind implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Kind> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Kind>() {
                    /* renamed from: jO */
                    public Kind jC(int i) {
                        return Kind.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i) {
                switch (i) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            private Kind(int i, int i2) {
                this.value = i2;
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Class, a> implements b {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_ = Collections.emptyList();
            private List<EnumEntry> enumEntry_ = Collections.emptyList();
            private int flags_ = 6;
            private int fqName_;
            private List<Function> function_ = Collections.emptyList();
            private List<Integer> nestedClassName_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
            private List<Integer> supertypeId_ = Collections.emptyList();
            private List<Type> supertype_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.bpU();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.bqR();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bkM() {
                return new a();
            }

            /* renamed from: bkN */
            public a clone() {
                return bkM().a(bkP());
            }

            /* renamed from: bki */
            public Class bju() {
                return Class.bkh();
            }

            /* renamed from: bkO */
            public Class bjx() {
                Object bkP = bkP();
                if (bkP.isInitialized()) {
                    return bkP;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bkP);
            }

            public Class bkP() {
                Class classR = new Class((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                classR.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                classR.fqName_ = this.fqName_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                classR.companionObjectName_ = this.companionObjectName_;
                if ((this.bitField0_ & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -9;
                }
                classR.typeParameter_ = this.typeParameter_;
                if ((this.bitField0_ & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    this.bitField0_ &= -17;
                }
                classR.supertype_ = this.supertype_;
                if ((this.bitField0_ & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    this.bitField0_ &= -33;
                }
                classR.supertypeId_ = this.supertypeId_;
                if ((this.bitField0_ & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    this.bitField0_ &= -65;
                }
                classR.nestedClassName_ = this.nestedClassName_;
                if ((this.bitField0_ & 128) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    this.bitField0_ &= -129;
                }
                classR.constructor_ = this.constructor_;
                if ((this.bitField0_ & 256) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -257;
                }
                classR.function_ = this.function_;
                if ((this.bitField0_ & 512) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -513;
                }
                classR.property_ = this.property_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -1025;
                }
                classR.typeAlias_ = this.typeAlias_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    this.bitField0_ &= -2049;
                }
                classR.enumEntry_ = this.enumEntry_;
                if ((this.bitField0_ & 4096) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    this.bitField0_ &= -4097;
                }
                classR.sealedSubclassFqName_ = this.sealedSubclassFqName_;
                if ((i & 8192) == 8192) {
                    i2 |= 8;
                }
                classR.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -16385;
                }
                classR.versionRequirement_ = this.versionRequirement_;
                if ((i & 32768) == 32768) {
                    i2 |= 16;
                }
                classR.versionRequirementTable_ = this.versionRequirementTable_;
                classR.bitField0_ = i2;
                return classR;
            }

            /* renamed from: n */
            public a a(Class classR) {
                if (classR == Class.bkh()) {
                    return this;
                }
                if (classR.bjR()) {
                    jL(classR.getFlags());
                }
                if (classR.bkj()) {
                    jM(classR.bkk());
                }
                if (classR.bkl()) {
                    jN(classR.bkm());
                }
                if (!classR.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = classR.typeParameter_;
                        this.bitField0_ &= -9;
                    } else {
                        bkQ();
                        this.typeParameter_.addAll(classR.typeParameter_);
                    }
                }
                if (!classR.supertype_.isEmpty()) {
                    if (this.supertype_.isEmpty()) {
                        this.supertype_ = classR.supertype_;
                        this.bitField0_ &= -17;
                    } else {
                        bkR();
                        this.supertype_.addAll(classR.supertype_);
                    }
                }
                if (!classR.supertypeId_.isEmpty()) {
                    if (this.supertypeId_.isEmpty()) {
                        this.supertypeId_ = classR.supertypeId_;
                        this.bitField0_ &= -33;
                    } else {
                        bkS();
                        this.supertypeId_.addAll(classR.supertypeId_);
                    }
                }
                if (!classR.nestedClassName_.isEmpty()) {
                    if (this.nestedClassName_.isEmpty()) {
                        this.nestedClassName_ = classR.nestedClassName_;
                        this.bitField0_ &= -65;
                    } else {
                        bkT();
                        this.nestedClassName_.addAll(classR.nestedClassName_);
                    }
                }
                if (!classR.constructor_.isEmpty()) {
                    if (this.constructor_.isEmpty()) {
                        this.constructor_ = classR.constructor_;
                        this.bitField0_ &= -129;
                    } else {
                        bkU();
                        this.constructor_.addAll(classR.constructor_);
                    }
                }
                if (!classR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = classR.function_;
                        this.bitField0_ &= -257;
                    } else {
                        bkV();
                        this.function_.addAll(classR.function_);
                    }
                }
                if (!classR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = classR.property_;
                        this.bitField0_ &= -513;
                    } else {
                        bkW();
                        this.property_.addAll(classR.property_);
                    }
                }
                if (!classR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = classR.typeAlias_;
                        this.bitField0_ &= -1025;
                    } else {
                        bkX();
                        this.typeAlias_.addAll(classR.typeAlias_);
                    }
                }
                if (!classR.enumEntry_.isEmpty()) {
                    if (this.enumEntry_.isEmpty()) {
                        this.enumEntry_ = classR.enumEntry_;
                        this.bitField0_ &= -2049;
                    } else {
                        bkY();
                        this.enumEntry_.addAll(classR.enumEntry_);
                    }
                }
                if (!classR.sealedSubclassFqName_.isEmpty()) {
                    if (this.sealedSubclassFqName_.isEmpty()) {
                        this.sealedSubclassFqName_ = classR.sealedSubclassFqName_;
                        this.bitField0_ &= -4097;
                    } else {
                        bkZ();
                        this.sealedSubclassFqName_.addAll(classR.sealedSubclassFqName_);
                    }
                }
                if (classR.bkE()) {
                    a(classR.bkF());
                }
                if (!classR.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = classR.versionRequirement_;
                        this.bitField0_ &= -16385;
                    } else {
                        bla();
                        this.versionRequirement_.addAll(classR.versionRequirement_);
                    }
                }
                if (classR.bkH()) {
                    a(classR.bkI());
                }
                a((ExtendableMessage) classR);
                e(buN().a(classR.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!bkj()) {
                    return false;
                }
                int i;
                for (i = 0; i < bko(); i++) {
                    if (!jE(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bkq(); i++) {
                    if (!jF(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bku(); i++) {
                    if (!jG(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bkw(); i++) {
                    if (!jH(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bky(); i++) {
                    if (!jI(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bkA(); i++) {
                    if (!jJ(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bkC(); i++) {
                    if (!jK(i).isInitialized()) {
                        return false;
                    }
                }
                if ((!bkE() || bkF().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: k */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Class classR;
                Throwable th;
                Class classR2 = null;
                try {
                    Class classR3 = (Class) Class.eKF.b(eVar, fVar);
                    if (classR3 != null) {
                        a(classR3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    classR = (Class) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    classR2 = classR;
                }
                if (classR2 != null) {
                    a(classR2);
                }
                throw th;
            }

            public a jL(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean bkj() {
                return (this.bitField0_ & 2) == 2;
            }

            public a jM(int i) {
                this.bitField0_ |= 2;
                this.fqName_ = i;
                return this;
            }

            public a jN(int i) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = i;
                return this;
            }

            private void bkQ() {
                if ((this.bitField0_ & 8) != 8) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 8;
                }
            }

            public int bko() {
                return this.typeParameter_.size();
            }

            public TypeParameter jE(int i) {
                return (TypeParameter) this.typeParameter_.get(i);
            }

            private void bkR() {
                if ((this.bitField0_ & 16) != 16) {
                    this.supertype_ = new ArrayList(this.supertype_);
                    this.bitField0_ |= 16;
                }
            }

            public int bkq() {
                return this.supertype_.size();
            }

            public Type jF(int i) {
                return (Type) this.supertype_.get(i);
            }

            private void bkS() {
                if ((this.bitField0_ & 32) != 32) {
                    this.supertypeId_ = new ArrayList(this.supertypeId_);
                    this.bitField0_ |= 32;
                }
            }

            private void bkT() {
                if ((this.bitField0_ & 64) != 64) {
                    this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                    this.bitField0_ |= 64;
                }
            }

            private void bkU() {
                if ((this.bitField0_ & 128) != 128) {
                    this.constructor_ = new ArrayList(this.constructor_);
                    this.bitField0_ |= 128;
                }
            }

            public int bku() {
                return this.constructor_.size();
            }

            public Constructor jG(int i) {
                return (Constructor) this.constructor_.get(i);
            }

            private void bkV() {
                if ((this.bitField0_ & 256) != 256) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 256;
                }
            }

            public int bkw() {
                return this.function_.size();
            }

            public Function jH(int i) {
                return (Function) this.function_.get(i);
            }

            private void bkW() {
                if ((this.bitField0_ & 512) != 512) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 512;
                }
            }

            public int bky() {
                return this.property_.size();
            }

            public Property jI(int i) {
                return (Property) this.property_.get(i);
            }

            private void bkX() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 1024;
                }
            }

            public int bkA() {
                return this.typeAlias_.size();
            }

            public TypeAlias jJ(int i) {
                return (TypeAlias) this.typeAlias_.get(i);
            }

            private void bkY() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.enumEntry_ = new ArrayList(this.enumEntry_);
                    this.bitField0_ |= 2048;
                }
            }

            public int bkC() {
                return this.enumEntry_.size();
            }

            public EnumEntry jK(int i) {
                return (EnumEntry) this.enumEntry_.get(i);
            }

            private void bkZ() {
                if ((this.bitField0_ & 4096) != 4096) {
                    this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                    this.bitField0_ |= 4096;
                }
            }

            public boolean bkE() {
                return (this.bitField0_ & 8192) == 8192;
            }

            public TypeTable bkF() {
                return this.typeTable_;
            }

            public a a(TypeTable typeTable) {
                if ((this.bitField0_ & 8192) != 8192 || this.typeTable_ == TypeTable.bpU()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.d(this.typeTable_).a(typeTable).bqg();
                }
                this.bitField0_ |= 8192;
                return this;
            }

            private void bla() {
                if ((this.bitField0_ & 16384) != 16384) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 16384;
                }
            }

            public a a(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 32768) != 32768 || this.versionRequirementTable_ == VersionRequirementTable.bqR()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.c(this.versionRequirementTable_).a(versionRequirementTable).brb();
                }
                this.bitField0_ |= 32768;
                return this;
            }
        }

        private Class(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Class, ?> bVar) {
            super(bVar);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Class(boolean z) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Class bkh() {
            return eKI;
        }

        /* renamed from: bki */
        public Class bjh() {
            return eKI;
        }

        /* JADX WARNING: Missing block: B:106:0x02c4, code:
            r7 = 1;
     */
        private Class(kotlin.reflect.jvm.internal.impl.protobuf.e r19, kotlin.reflect.jvm.internal.impl.protobuf.f r20) {
            /*
            r18 = this;
            r1 = r18;
            r2 = r19;
            r3 = r20;
            r18.<init>();
            r4 = -1;
            r1.supertypeIdMemoizedSerializedSize = r4;
            r1.nestedClassNameMemoizedSerializedSize = r4;
            r1.sealedSubclassFqNameMemoizedSerializedSize = r4;
            r1.memoizedIsInitialized = r4;
            r1.memoizedSerializedSize = r4;
            r18.bja();
            r4 = kotlin.reflect.jvm.internal.impl.protobuf.d.btY();
            r5 = 1;
            r6 = kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream.b(r4, r5);
            r7 = 0;
            r8 = 0;
        L_0x0022:
            r12 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r13 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
            r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r14 = 8;
            r15 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            r9 = 16;
            if (r7 != 0) goto L_0x038c;
        L_0x0030:
            r10 = r19.bue();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r16 = 0;
            switch(r10) {
                case 0: goto L_0x02c3;
                case 8: goto L_0x02b6;
                case 16: goto L_0x0298;
                case 18: goto L_0x0263;
                case 24: goto L_0x0256;
                case 32: goto L_0x0249;
                case 42: goto L_0x0230;
                case 50: goto L_0x0214;
                case 56: goto L_0x01f6;
                case 58: goto L_0x01c0;
                case 66: goto L_0x01a4;
                case 74: goto L_0x0188;
                case 82: goto L_0x016c;
                case 90: goto L_0x0152;
                case 106: goto L_0x0138;
                case 128: goto L_0x011c;
                case 130: goto L_0x00e8;
                case 242: goto L_0x00bd;
                case 248: goto L_0x00a1;
                case 250: goto L_0x006b;
                case 258: goto L_0x0040;
                default: goto L_0x0039;
            };	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x0039:
            r11 = 1;
            r9 = r1.a(r2, r6, r3, r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02c6;
        L_0x0040:
            r10 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r10 & r9;
            if (r10 != r9) goto L_0x004b;
        L_0x0045:
            r10 = r1.versionRequirementTable_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r16 = r10.bjf();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x004b:
            r10 = r16;
            r11 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = r2.a(r11, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r11;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.versionRequirementTable_ = r11;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 == 0) goto L_0x0064;
        L_0x0059:
            r11 = r1.versionRequirementTable_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.a(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r10.brb();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.versionRequirementTable_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x0064:
            r10 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r10 | r9;
            r1.bitField0_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x006b:
            r10 = r19.but();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.lv(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = r8 & 16384;
            if (r11 == r15) goto L_0x0086;
        L_0x0077:
            r11 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r11 <= 0) goto L_0x0086;
        L_0x007d:
            r11 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.versionRequirement_ = r11;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 16384;
        L_0x0086:
            r11 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r11 <= 0) goto L_0x009c;
        L_0x008c:
            r11 = r1.versionRequirement_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11.add(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = 16;
            goto L_0x0086;
        L_0x009c:
            r2.lw(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x00a1:
            r9 = r8 & 16384;
            if (r9 == r15) goto L_0x00ae;
        L_0x00a5:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.versionRequirement_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 16384;
        L_0x00ae:
            r9 = r1.versionRequirement_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x00bd:
            r9 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r9 & r14;
            if (r9 != r14) goto L_0x00c8;
        L_0x00c2:
            r9 = r1.typeTable_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r16 = r9.bjf();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x00c8:
            r9 = r16;
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.typeTable_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r9 == 0) goto L_0x00e1;
        L_0x00d6:
            r10 = r1.typeTable_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.a(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r9.bqg();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.typeTable_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x00e1:
            r9 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r9 | r14;
            r1.bitField0_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x00e8:
            r9 = r19.but();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r2.lv(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r8 & 4096;
            if (r10 == r5) goto L_0x0103;
        L_0x00f4:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x0103;
        L_0x00fa:
            r10 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.sealedSubclassFqName_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 4096;
        L_0x0103:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x0117;
        L_0x0109:
            r10 = r1.sealedSubclassFqName_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.add(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x0103;
        L_0x0117:
            r2.lw(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x011c:
            r9 = r8 & 4096;
            if (r9 == r5) goto L_0x0129;
        L_0x0120:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.sealedSubclassFqName_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 4096;
        L_0x0129:
            r9 = r1.sealedSubclassFqName_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0138:
            r9 = r8 & 2048;
            if (r9 == r13) goto L_0x0145;
        L_0x013c:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.enumEntry_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 2048;
        L_0x0145:
            r9 = r1.enumEntry_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0152:
            r9 = r8 & 1024;
            if (r9 == r12) goto L_0x015f;
        L_0x0156:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.typeAlias_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 1024;
        L_0x015f:
            r9 = r1.typeAlias_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x016c:
            r9 = r8 & 512;
            r10 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r9 == r10) goto L_0x017b;
        L_0x0172:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.property_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 512;
        L_0x017b:
            r9 = r1.property_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0188:
            r9 = r8 & 256;
            r10 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r9 == r10) goto L_0x0197;
        L_0x018e:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.function_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 256;
        L_0x0197:
            r9 = r1.function_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x01a4:
            r9 = r8 & 128;
            r10 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r9 == r10) goto L_0x01b3;
        L_0x01aa:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.constructor_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 128;
        L_0x01b3:
            r9 = r1.constructor_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x01c0:
            r9 = r19.but();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r2.lv(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r8 & 64;
            r11 = 64;
            if (r10 == r11) goto L_0x01dd;
        L_0x01ce:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x01dd;
        L_0x01d4:
            r10 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.nestedClassName_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 64;
        L_0x01dd:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x01f1;
        L_0x01e3:
            r10 = r1.nestedClassName_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.add(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x01dd;
        L_0x01f1:
            r2.lw(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x01f6:
            r9 = r8 & 64;
            r10 = 64;
            if (r9 == r10) goto L_0x0205;
        L_0x01fc:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.nestedClassName_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 64;
        L_0x0205:
            r9 = r1.nestedClassName_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0214:
            r9 = r8 & 16;
            r10 = 16;
            if (r9 == r10) goto L_0x0223;
        L_0x021a:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.supertype_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 16;
        L_0x0223:
            r9 = r1.supertype_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0230:
            r9 = r8 & 8;
            if (r9 == r14) goto L_0x023d;
        L_0x0234:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.typeParameter_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 8;
        L_0x023d:
            r9 = r1.typeParameter_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.eKF;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r2.a(r10, r3);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0249:
            r9 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r9 | 4;
            r1.bitField0_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.companionObjectName_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0256:
            r9 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r9 | 2;
            r1.bitField0_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.fqName_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0263:
            r9 = r19.but();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r2.lv(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r8 & 32;
            r11 = 32;
            if (r10 == r11) goto L_0x0280;
        L_0x0271:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x0280;
        L_0x0277:
            r10 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.supertypeId_ = r10;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 32;
        L_0x0280:
            r10 = r19.buz();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            if (r10 <= 0) goto L_0x0294;
        L_0x0286:
            r10 = r1.supertypeId_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10.add(r11);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x0280;
        L_0x0294:
            r2.lw(r9);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02b4;
        L_0x0298:
            r9 = r8 & 32;
            r10 = 32;
            if (r9 == r10) goto L_0x02a7;
        L_0x029e:
            r9 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.supertypeId_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r8 = r8 | 32;
        L_0x02a7:
            r9 = r1.supertypeId_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9.add(r10);	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
        L_0x02b4:
            r11 = 1;
            goto L_0x02c9;
        L_0x02b6:
            r9 = r1.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r11 = 1;
            r9 = r9 | r11;
            r1.bitField0_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r9 = r19.buh();	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            r1.flags_ = r9;	 Catch:{ InvalidProtocolBufferException -> 0x02df, IOException -> 0x02cf }
            goto L_0x02c9;
        L_0x02c3:
            r11 = 1;
        L_0x02c4:
            r7 = 1;
            goto L_0x02c9;
        L_0x02c6:
            if (r9 != 0) goto L_0x02c9;
        L_0x02c8:
            goto L_0x02c4;
        L_0x02c9:
            r5 = 1;
            goto L_0x0022;
        L_0x02cc:
            r0 = move-exception;
            r2 = r0;
            goto L_0x02e6;
        L_0x02cf:
            r0 = move-exception;
            r2 = r0;
            r3 = new kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x02cc }
            r2 = r2.getMessage();	 Catch:{ all -> 0x02cc }
            r3.<init>(r2);	 Catch:{ all -> 0x02cc }
            r2 = r3.g(r1);	 Catch:{ all -> 0x02cc }
            throw r2;	 Catch:{ all -> 0x02cc }
        L_0x02df:
            r0 = move-exception;
            r2 = r0;
            r2 = r2.g(r1);	 Catch:{ all -> 0x02cc }
            throw r2;	 Catch:{ all -> 0x02cc }
        L_0x02e6:
            r3 = r8 & 32;
            r7 = 32;
            if (r3 != r7) goto L_0x02f4;
        L_0x02ec:
            r3 = r1.supertypeId_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.supertypeId_ = r3;
        L_0x02f4:
            r3 = r8 & 8;
            if (r3 != r14) goto L_0x0300;
        L_0x02f8:
            r3 = r1.typeParameter_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.typeParameter_ = r3;
        L_0x0300:
            r3 = r8 & 16;
            r7 = 16;
            if (r3 != r7) goto L_0x030e;
        L_0x0306:
            r3 = r1.supertype_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.supertype_ = r3;
        L_0x030e:
            r3 = r8 & 64;
            r7 = 64;
            if (r3 != r7) goto L_0x031c;
        L_0x0314:
            r3 = r1.nestedClassName_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.nestedClassName_ = r3;
        L_0x031c:
            r3 = r8 & 128;
            r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r3 != r7) goto L_0x032a;
        L_0x0322:
            r3 = r1.constructor_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.constructor_ = r3;
        L_0x032a:
            r3 = r8 & 256;
            r7 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r3 != r7) goto L_0x0338;
        L_0x0330:
            r3 = r1.function_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.function_ = r3;
        L_0x0338:
            r3 = r8 & 512;
            r7 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r3 != r7) goto L_0x0346;
        L_0x033e:
            r3 = r1.property_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.property_ = r3;
        L_0x0346:
            r3 = r8 & 1024;
            if (r3 != r12) goto L_0x0352;
        L_0x034a:
            r3 = r1.typeAlias_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.typeAlias_ = r3;
        L_0x0352:
            r3 = r8 & 2048;
            if (r3 != r13) goto L_0x035e;
        L_0x0356:
            r3 = r1.enumEntry_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.enumEntry_ = r3;
        L_0x035e:
            r3 = r8 & 4096;
            if (r3 != r5) goto L_0x036a;
        L_0x0362:
            r3 = r1.sealedSubclassFqName_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.sealedSubclassFqName_ = r3;
        L_0x036a:
            r3 = r8 & 16384;
            if (r3 != r15) goto L_0x0376;
        L_0x036e:
            r3 = r1.versionRequirement_;
            r3 = java.util.Collections.unmodifiableList(r3);
            r1.versionRequirement_ = r3;
        L_0x0376:
            r6.flush();	 Catch:{ IOException -> 0x0379, all -> 0x0380 }
        L_0x0379:
            r3 = r4.buc();
            r1.unknownFields = r3;
            goto L_0x0388;
        L_0x0380:
            r0 = move-exception;
            r2 = r4.buc();
            r1.unknownFields = r2;
            throw r0;
        L_0x0388:
            r18.buM();
            throw r2;
        L_0x038c:
            r2 = r8 & 32;
            r3 = 32;
            if (r2 != r3) goto L_0x039a;
        L_0x0392:
            r2 = r1.supertypeId_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.supertypeId_ = r2;
        L_0x039a:
            r2 = r8 & 8;
            if (r2 != r14) goto L_0x03a6;
        L_0x039e:
            r2 = r1.typeParameter_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.typeParameter_ = r2;
        L_0x03a6:
            r2 = r8 & 16;
            r3 = 16;
            if (r2 != r3) goto L_0x03b4;
        L_0x03ac:
            r2 = r1.supertype_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.supertype_ = r2;
        L_0x03b4:
            r2 = r8 & 64;
            r3 = 64;
            if (r2 != r3) goto L_0x03c2;
        L_0x03ba:
            r2 = r1.nestedClassName_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.nestedClassName_ = r2;
        L_0x03c2:
            r2 = r8 & 128;
            r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r2 != r3) goto L_0x03d0;
        L_0x03c8:
            r2 = r1.constructor_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.constructor_ = r2;
        L_0x03d0:
            r2 = r8 & 256;
            r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
            if (r2 != r3) goto L_0x03de;
        L_0x03d6:
            r2 = r1.function_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.function_ = r2;
        L_0x03de:
            r2 = r8 & 512;
            r3 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r2 != r3) goto L_0x03ec;
        L_0x03e4:
            r2 = r1.property_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.property_ = r2;
        L_0x03ec:
            r2 = r8 & 1024;
            if (r2 != r12) goto L_0x03f8;
        L_0x03f0:
            r2 = r1.typeAlias_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.typeAlias_ = r2;
        L_0x03f8:
            r2 = r8 & 2048;
            if (r2 != r13) goto L_0x0404;
        L_0x03fc:
            r2 = r1.enumEntry_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.enumEntry_ = r2;
        L_0x0404:
            r2 = r8 & 4096;
            if (r2 != r5) goto L_0x0410;
        L_0x0408:
            r2 = r1.sealedSubclassFqName_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.sealedSubclassFqName_ = r2;
        L_0x0410:
            r2 = r8 & 16384;
            if (r2 != r15) goto L_0x041c;
        L_0x0414:
            r2 = r1.versionRequirement_;
            r2 = java.util.Collections.unmodifiableList(r2);
            r1.versionRequirement_ = r2;
        L_0x041c:
            r6.flush();	 Catch:{ IOException -> 0x041f, all -> 0x0426 }
        L_0x041f:
            r2 = r4.buc();
            r1.unknownFields = r2;
            goto L_0x042e;
        L_0x0426:
            r0 = move-exception;
            r2 = r4.buc();
            r1.unknownFields = r2;
            throw r0;
        L_0x042e:
            r18.buM();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.<init>(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):void");
        }

        static {
            eKI.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Class> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean bkj() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bkk() {
            return this.fqName_;
        }

        public boolean bkl() {
            return (this.bitField0_ & 4) == 4;
        }

        public int bkm() {
            return this.companionObjectName_;
        }

        public List<TypeParameter> bkn() {
            return this.typeParameter_;
        }

        public int bko() {
            return this.typeParameter_.size();
        }

        public TypeParameter jE(int i) {
            return (TypeParameter) this.typeParameter_.get(i);
        }

        public List<Type> bkp() {
            return this.supertype_;
        }

        public int bkq() {
            return this.supertype_.size();
        }

        public Type jF(int i) {
            return (Type) this.supertype_.get(i);
        }

        public List<Integer> bkr() {
            return this.supertypeId_;
        }

        public List<Integer> bks() {
            return this.nestedClassName_;
        }

        public List<Constructor> bkt() {
            return this.constructor_;
        }

        public int bku() {
            return this.constructor_.size();
        }

        public Constructor jG(int i) {
            return (Constructor) this.constructor_.get(i);
        }

        public List<Function> bkv() {
            return this.function_;
        }

        public int bkw() {
            return this.function_.size();
        }

        public Function jH(int i) {
            return (Function) this.function_.get(i);
        }

        public List<Property> bkx() {
            return this.property_;
        }

        public int bky() {
            return this.property_.size();
        }

        public Property jI(int i) {
            return (Property) this.property_.get(i);
        }

        public List<TypeAlias> bkz() {
            return this.typeAlias_;
        }

        public int bkA() {
            return this.typeAlias_.size();
        }

        public TypeAlias jJ(int i) {
            return (TypeAlias) this.typeAlias_.get(i);
        }

        public List<EnumEntry> bkB() {
            return this.enumEntry_;
        }

        public int bkC() {
            return this.enumEntry_.size();
        }

        public EnumEntry jK(int i) {
            return (EnumEntry) this.enumEntry_.get(i);
        }

        public List<Integer> bkD() {
            return this.sealedSubclassFqName_;
        }

        public boolean bkE() {
            return (this.bitField0_ & 8) == 8;
        }

        public TypeTable bkF() {
            return this.typeTable_;
        }

        public List<Integer> bkG() {
            return this.versionRequirement_;
        }

        public boolean bkH() {
            return (this.bitField0_ & 16) == 16;
        }

        public VersionRequirementTable bkI() {
            return this.versionRequirementTable_;
        }

        private void bja() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.typeTable_ = TypeTable.bpU();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.bqR();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (bkj()) {
                int i = 0;
                while (i < bko()) {
                    if (jE(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bkq()) {
                    if (jF(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bku()) {
                    if (jG(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bkw()) {
                    if (jH(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bky()) {
                    if (jI(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bkA()) {
                    if (jJ(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < bkC()) {
                    if (jK(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (bkE() && !bkF().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (buQ()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            int i;
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.flags_);
            }
            if (bkr().size() > 0) {
                codedOutputStream.C(18);
                codedOutputStream.C(this.supertypeIdMemoizedSerializedSize);
            }
            int i2 = 0;
            for (i = 0; i < this.supertypeId_.size(); i++) {
                codedOutputStream.s(((Integer) this.supertypeId_.get(i)).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.bg(4, this.companionObjectName_);
            }
            for (i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.b(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            for (i = 0; i < this.supertype_.size(); i++) {
                codedOutputStream.b(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.supertype_.get(i));
            }
            if (bks().size() > 0) {
                codedOutputStream.C(58);
                codedOutputStream.C(this.nestedClassNameMemoizedSerializedSize);
            }
            for (i = 0; i < this.nestedClassName_.size(); i++) {
                codedOutputStream.s(((Integer) this.nestedClassName_.get(i)).intValue());
            }
            for (i = 0; i < this.constructor_.size(); i++) {
                codedOutputStream.b(8, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.constructor_.get(i));
            }
            for (i = 0; i < this.function_.size(); i++) {
                codedOutputStream.b(9, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); i++) {
                codedOutputStream.b(10, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); i++) {
                codedOutputStream.b(11, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeAlias_.get(i));
            }
            for (i = 0; i < this.enumEntry_.size(); i++) {
                codedOutputStream.b(13, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.enumEntry_.get(i));
            }
            if (bkD().size() > 0) {
                codedOutputStream.C(130);
                codedOutputStream.C(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (i = 0; i < this.sealedSubclassFqName_.size(); i++) {
                codedOutputStream.s(((Integer) this.sealedSubclassFqName_.get(i)).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.b(30, this.typeTable_);
            }
            while (i2 < this.versionRequirement_.size()) {
                codedOutputStream.bg(31, ((Integer) this.versionRequirement_.get(i2)).intValue());
                i2++;
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.b(32, this.versionRequirementTable_);
            }
            buR.b(19000, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2;
            int i3 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.flags_) + 0 : 0;
            int i4 = 0;
            for (i2 = 0; i2 < this.supertypeId_.size(); i2++) {
                i4 += CodedOutputStream.w(((Integer) this.supertypeId_.get(i2)).intValue());
            }
            i += i4;
            if (!bkr().isEmpty()) {
                i = (i + 1) + CodedOutputStream.w(i4);
            }
            this.supertypeIdMemoizedSerializedSize = i4;
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.bh(4, this.companionObjectName_);
            }
            i2 = i;
            for (i = 0; i < this.typeParameter_.size(); i++) {
                i2 += CodedOutputStream.d(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            for (i = 0; i < this.supertype_.size(); i++) {
                i2 += CodedOutputStream.d(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.supertype_.get(i));
            }
            int i5 = 0;
            for (i = 0; i < this.nestedClassName_.size(); i++) {
                i5 += CodedOutputStream.w(((Integer) this.nestedClassName_.get(i)).intValue());
            }
            i2 += i5;
            if (!bks().isEmpty()) {
                i2 = (i2 + 1) + CodedOutputStream.w(i5);
            }
            this.nestedClassNameMemoizedSerializedSize = i5;
            for (i = 0; i < this.constructor_.size(); i++) {
                i2 += CodedOutputStream.d(8, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.constructor_.get(i));
            }
            for (i = 0; i < this.function_.size(); i++) {
                i2 += CodedOutputStream.d(9, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); i++) {
                i2 += CodedOutputStream.d(10, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.property_.get(i));
            }
            for (i = 0; i < this.typeAlias_.size(); i++) {
                i2 += CodedOutputStream.d(11, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeAlias_.get(i));
            }
            for (i = 0; i < this.enumEntry_.size(); i++) {
                i2 += CodedOutputStream.d(13, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.enumEntry_.get(i));
            }
            i5 = 0;
            for (i = 0; i < this.sealedSubclassFqName_.size(); i++) {
                i5 += CodedOutputStream.w(((Integer) this.sealedSubclassFqName_.get(i)).intValue());
            }
            i2 += i5;
            if (!bkD().isEmpty()) {
                i2 = (i2 + 2) + CodedOutputStream.w(i5);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i5;
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.d(30, this.typeTable_);
            }
            i = 0;
            while (i3 < this.versionRequirement_.size()) {
                i += CodedOutputStream.w(((Integer) this.versionRequirement_.get(i3)).intValue());
                i3++;
            }
            i2 = (i2 + i) + (bkG().size() * 2);
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.d(32, this.versionRequirementTable_);
            }
            i2 = (i2 + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static Class a(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return (Class) eKF.k(inputStream, fVar);
        }

        public static a bkJ() {
            return a.bkM();
        }

        /* renamed from: bkK */
        public a bjg() {
            return bkJ();
        }

        public static a a(Class classR) {
            return bkJ().a(classR);
        }

        /* renamed from: bkL */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Constructor extends ExtendableMessage<Constructor> implements c {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Constructor>() {
            /* renamed from: l */
            public Constructor b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Constructor(eVar, fVar);
            }
        };
        private static final Constructor eKJ = new Constructor(true);
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Constructor, a> implements c {
            private int bitField0_;
            private int flags_ = 6;
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a blk() {
                return new a();
            }

            /* renamed from: bll */
            public a clone() {
                return blk().a(bln());
            }

            /* renamed from: ble */
            public Constructor bju() {
                return Constructor.bld();
            }

            /* renamed from: blm */
            public Constructor bjx() {
                Object bln = bln();
                if (bln.isInitialized()) {
                    return bln;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bln);
            }

            public Constructor bln() {
                Constructor constructor = new Constructor((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                constructor.flags_ = this.flags_;
                if ((this.bitField0_ & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -3;
                }
                constructor.valueParameter_ = this.valueParameter_;
                if ((this.bitField0_ & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -5;
                }
                constructor.versionRequirement_ = this.versionRequirement_;
                constructor.bitField0_ = i;
                return constructor;
            }

            /* renamed from: e */
            public a a(Constructor constructor) {
                if (constructor == Constructor.bld()) {
                    return this;
                }
                if (constructor.bjR()) {
                    jQ(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = constructor.valueParameter_;
                        this.bitField0_ &= -3;
                    } else {
                        blo();
                        this.valueParameter_.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = constructor.versionRequirement_;
                        this.bitField0_ &= -5;
                    } else {
                        bla();
                        this.versionRequirement_.addAll(constructor.versionRequirement_);
                    }
                }
                a((ExtendableMessage) constructor);
                e(buN().a(constructor.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < blg(); i++) {
                    if (!jP(i).isInitialized()) {
                        return false;
                    }
                }
                if (buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: m */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Constructor constructor;
                Throwable th;
                Constructor constructor2 = null;
                try {
                    Constructor constructor3 = (Constructor) Constructor.eKF.b(eVar, fVar);
                    if (constructor3 != null) {
                        a(constructor3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    constructor = (Constructor) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    constructor2 = constructor;
                }
                if (constructor2 != null) {
                    a(constructor2);
                }
                throw th;
            }

            public a jQ(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            private void blo() {
                if ((this.bitField0_ & 2) != 2) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 2;
                }
            }

            public int blg() {
                return this.valueParameter_.size();
            }

            public ValueParameter jP(int i) {
                return (ValueParameter) this.valueParameter_.get(i);
            }

            private void bla() {
                if ((this.bitField0_ & 4) != 4) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 4;
                }
            }
        }

        private Constructor(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Constructor, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Constructor(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Constructor bld() {
            return eKJ;
        }

        /* renamed from: ble */
        public Constructor bjh() {
            return eKJ;
        }

        private Constructor(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            this.flags_ = eVar.buh();
                        } else if (bue == 18) {
                            if ((i & 2) != 2) {
                                this.valueParameter_ = new ArrayList();
                                i |= 2;
                            }
                            this.valueParameter_.add(eVar.a(ValueParameter.eKF, fVar));
                        } else if (bue == 248) {
                            if ((i & 4) != 4) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 4;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                        } else if (bue == Callback.DEFAULT_SWIPE_ANIMATION_DURATION) {
                            bue = eVar.lv(eVar.but());
                            if ((i & 4) != 4 && eVar.buz() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 4;
                            }
                            while (eVar.buz() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
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
                    if ((i & 2) == 2) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i & 4) == 4) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            if ((i & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if ((i & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            eKJ.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public List<ValueParameter> blf() {
            return this.valueParameter_;
        }

        public int blg() {
            return this.valueParameter_.size();
        }

        public ValueParameter jP(int i) {
            return (ValueParameter) this.valueParameter_.get(i);
        }

        public List<Integer> bkG() {
            return this.versionRequirement_;
        }

        private void bja() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < blg()) {
                if (jP(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (buQ()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.flags_);
            }
            for (int i = 0; i < this.valueParameter_.size(); i++) {
                codedOutputStream.b(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.valueParameter_.get(i));
            }
            for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
                codedOutputStream.bg(31, ((Integer) this.versionRequirement_.get(i2)).intValue());
            }
            buR.b(19000, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int bh = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.flags_) + 0 : 0;
            for (i = 0; i < this.valueParameter_.size(); i++) {
                bh += CodedOutputStream.d(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.valueParameter_.get(i));
            }
            i = 0;
            while (i2 < this.versionRequirement_.size()) {
                i += CodedOutputStream.w(((Integer) this.versionRequirement_.get(i2)).intValue());
                i2++;
            }
            bh = (((bh + i) + (bkG().size() * 2)) + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = bh;
            return bh;
        }

        public static a blh() {
            return a.blk();
        }

        /* renamed from: bli */
        public a bjg() {
            return blh();
        }

        public static a a(Constructor constructor) {
            return blh().a(constructor);
        }

        /* renamed from: blj */
        public a bjf() {
            return a(this);
        }
    }

    public static final class EnumEntry extends ExtendableMessage<EnumEntry> implements f {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<EnumEntry>() {
            /* renamed from: r */
            public EnumEntry b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new EnumEntry(eVar, fVar);
            }
        };
        private static final EnumEntry eKM = new EnumEntry(true);
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<EnumEntry, a> implements f {
            private int bitField0_;
            private int name_;

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bma() {
                return new a();
            }

            /* renamed from: bmb */
            public a clone() {
                return bma().a(bmd());
            }

            /* renamed from: blV */
            public EnumEntry bju() {
                return EnumEntry.blU();
            }

            /* renamed from: bmc */
            public EnumEntry bjx() {
                Object bmd = bmd();
                if (bmd.isInitialized()) {
                    return bmd;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bmd);
            }

            public EnumEntry bmd() {
                EnumEntry enumEntry = new EnumEntry((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                enumEntry.name_ = this.name_;
                enumEntry.bitField0_ = i;
                return enumEntry;
            }

            /* renamed from: c */
            public a a(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.blU()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    jV(enumEntry.blW());
                }
                a((ExtendableMessage) enumEntry);
                e(buN().a(enumEntry.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                return buQ();
            }

            /* renamed from: s */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                EnumEntry enumEntry;
                Throwable th;
                EnumEntry enumEntry2 = null;
                try {
                    EnumEntry enumEntry3 = (EnumEntry) EnumEntry.eKF.b(eVar, fVar);
                    if (enumEntry3 != null) {
                        a(enumEntry3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    enumEntry = (EnumEntry) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    enumEntry2 = enumEntry;
                }
                if (enumEntry2 != null) {
                    a(enumEntry2);
                }
                throw th;
            }

            public a jV(int i) {
                this.bitField0_ |= 1;
                this.name_ = i;
                return this;
            }
        }

        private EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<EnumEntry, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private EnumEntry(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static EnumEntry blU() {
            return eKM;
        }

        /* renamed from: blV */
        public EnumEntry bjh() {
            return eKM;
        }

        private EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
            eKM.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> biX() {
            return eKF;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        public int blW() {
            return this.name_;
        }

        private void bja() {
            this.name_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (buQ()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.name_);
            }
            buR.b(200, codedOutputStream);
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
            i = (i + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a blX() {
            return a.bma();
        }

        /* renamed from: blY */
        public a bjg() {
            return blX();
        }

        public static a a(EnumEntry enumEntry) {
            return blX().a(enumEntry);
        }

        /* renamed from: blZ */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Function extends ExtendableMessage<Function> implements h {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Function> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Function>() {
            /* renamed from: v */
            public Function b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Function(eVar, fVar);
            }
        };
        private static final Function eKO = new Function(true);
        private int bitField0_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Function, a> implements h {
            private int bitField0_;
            private Contract contract_ = Contract.blq();
            private int flags_ = 6;
            private int name_;
            private int oldFlags_ = 6;
            private int receiverTypeId_;
            private Type receiverType_ = Type.bok();
            private int returnTypeId_;
            private Type returnType_ = Type.bok();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.bpU();
            private List<ValueParameter> valueParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bmS() {
                return new a();
            }

            /* renamed from: bmT */
            public a clone() {
                return bmS().a(bmV());
            }

            /* renamed from: bmC */
            public Function bju() {
                return Function.bmB();
            }

            /* renamed from: bmU */
            public Function bjx() {
                Object bmV = bmV();
                if (bmV.isInitialized()) {
                    return bmV;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bmV);
            }

            public Function bmV() {
                Function function = new Function((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                function.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                function.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                function.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                function.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                function.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                function.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                function.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                function.receiverTypeId_ = this.receiverTypeId_;
                if ((this.bitField0_ & 256) == 256) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    this.bitField0_ &= -257;
                }
                function.valueParameter_ = this.valueParameter_;
                if ((i & 512) == 512) {
                    i2 |= 128;
                }
                function.typeTable_ = this.typeTable_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -1025;
                }
                function.versionRequirement_ = this.versionRequirement_;
                if ((i & 2048) == 2048) {
                    i2 |= 256;
                }
                function.contract_ = this.contract_;
                function.bitField0_ = i2;
                return function;
            }

            /* renamed from: f */
            public a a(Function function) {
                if (function == Function.bmB()) {
                    return this;
                }
                if (function.bjR()) {
                    kc(function.getFlags());
                }
                if (function.bmD()) {
                    kd(function.bmE());
                }
                if (function.hasName()) {
                    ke(function.blW());
                }
                if (function.bmF()) {
                    b(function.bmG());
                }
                if (function.bmH()) {
                    kf(function.bmI());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = function.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        bkQ();
                        this.typeParameter_.addAll(function.typeParameter_);
                    }
                }
                if (function.bmJ()) {
                    c(function.bmK());
                }
                if (function.bmL()) {
                    kg(function.bmM());
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.valueParameter_.isEmpty()) {
                        this.valueParameter_ = function.valueParameter_;
                        this.bitField0_ &= -257;
                    } else {
                        blo();
                        this.valueParameter_.addAll(function.valueParameter_);
                    }
                }
                if (function.bkE()) {
                    b(function.bkF());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = function.versionRequirement_;
                        this.bitField0_ &= -1025;
                    } else {
                        bla();
                        this.versionRequirement_.addAll(function.versionRequirement_);
                    }
                }
                if (function.bmN()) {
                    e(function.bmO());
                }
                a((ExtendableMessage) function);
                e(buN().a(function.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (bmF() && !bmG().isInitialized()) {
                    return false;
                }
                int i;
                for (i = 0; i < bko(); i++) {
                    if (!jE(i).isInitialized()) {
                        return false;
                    }
                }
                if (bmJ() && !bmK().isInitialized()) {
                    return false;
                }
                for (i = 0; i < blg(); i++) {
                    if (!jP(i).isInitialized()) {
                        return false;
                    }
                }
                if (bkE() && !bkF().isInitialized()) {
                    return false;
                }
                if ((!bmN() || bmO().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: w */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Function function;
                Throwable th;
                Function function2 = null;
                try {
                    Function function3 = (Function) Function.eKF.b(eVar, fVar);
                    if (function3 != null) {
                        a(function3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    function = (Function) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    function2 = function;
                }
                if (function2 != null) {
                    a(function2);
                }
                throw th;
            }

            public a kc(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public a kd(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public a ke(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public boolean bmF() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type bmG() {
                return this.returnType_;
            }

            public a b(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.bok()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.f(this.returnType_).a(type).bpe();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public a kf(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            private void bkQ() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            public int bko() {
                return this.typeParameter_.size();
            }

            public TypeParameter jE(int i) {
                return (TypeParameter) this.typeParameter_.get(i);
            }

            public boolean bmJ() {
                return (this.bitField0_ & 64) == 64;
            }

            public Type bmK() {
                return this.receiverType_;
            }

            public a c(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.bok()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.f(this.receiverType_).a(type).bpe();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public a kg(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            private void blo() {
                if ((this.bitField0_ & 256) != 256) {
                    this.valueParameter_ = new ArrayList(this.valueParameter_);
                    this.bitField0_ |= 256;
                }
            }

            public int blg() {
                return this.valueParameter_.size();
            }

            public ValueParameter jP(int i) {
                return (ValueParameter) this.valueParameter_.get(i);
            }

            public boolean bkE() {
                return (this.bitField0_ & 512) == 512;
            }

            public TypeTable bkF() {
                return this.typeTable_;
            }

            public a b(TypeTable typeTable) {
                if ((this.bitField0_ & 512) != 512 || this.typeTable_ == TypeTable.bpU()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.d(this.typeTable_).a(typeTable).bqg();
                }
                this.bitField0_ |= 512;
                return this;
            }

            private void bla() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 1024;
                }
            }

            public boolean bmN() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public Contract bmO() {
                return this.contract_;
            }

            public a e(Contract contract) {
                if ((this.bitField0_ & 2048) != 2048 || this.contract_ == Contract.blq()) {
                    this.contract_ = contract;
                } else {
                    this.contract_ = Contract.a(this.contract_).a(contract).blz();
                }
                this.bitField0_ |= 2048;
                return this;
            }
        }

        private Function(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Function, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Function(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Function bmB() {
            return eKO;
        }

        /* renamed from: bmC */
        public Function bjh() {
            return eKO;
        }

        private Function(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                    b bVar = null;
                    switch (bue) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = eVar.buh();
                            break;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = eVar.buh();
                            break;
                        case 26:
                            if ((this.bitField0_ & 8) == 8) {
                                bVar = this.returnType_.bjf();
                            }
                            this.returnType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.returnType_);
                                this.returnType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 34:
                            if ((i & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i |= 32;
                            }
                            this.typeParameter_.add(eVar.a(TypeParameter.eKF, fVar));
                            break;
                        case 42:
                            if ((this.bitField0_ & 32) == 32) {
                                bVar = this.receiverType_.bjf();
                            }
                            this.receiverType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.receiverType_);
                                this.receiverType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 32;
                            break;
                        case 50:
                            if ((i & 256) != 256) {
                                this.valueParameter_ = new ArrayList();
                                i |= 256;
                            }
                            this.valueParameter_.add(eVar.a(ValueParameter.eKF, fVar));
                            break;
                        case 56:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = eVar.buh();
                            break;
                        case 64:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = eVar.buh();
                            break;
                        case 72:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.buh();
                            break;
                        case 242:
                            a bqc;
                            if ((this.bitField0_ & 128) == 128) {
                                bqc = this.typeTable_.bjf();
                            }
                            this.typeTable_ = (TypeTable) eVar.a(TypeTable.eKF, fVar);
                            if (bqc != null) {
                                bqc.a(this.typeTable_);
                                this.typeTable_ = bqc.bqg();
                            }
                            this.bitField0_ |= 128;
                            break;
                        case 248:
                            if ((i & 1024) != 1024) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            break;
                        case Callback.DEFAULT_SWIPE_ANIMATION_DURATION /*250*/:
                            bue = eVar.lv(eVar.but());
                            if ((i & 1024) != 1024 && eVar.buz() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            while (eVar.buz() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            }
                            eVar.lw(bue);
                            break;
                        case 258:
                            a blv;
                            if ((this.bitField0_ & 256) == 256) {
                                blv = this.contract_.bjf();
                            }
                            this.contract_ = (Contract) eVar.a(Contract.eKF, fVar);
                            if (blv != null) {
                                blv.a(this.contract_);
                                this.contract_ = blv.blz();
                            }
                            this.bitField0_ |= 256;
                            break;
                        default:
                            if (a(eVar, b, fVar, bue)) {
                                break;
                            }
                            obj = 1;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 256) == 256) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i & 1024) == 1024) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            if ((i & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i & 256) == 256) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if ((i & 1024) == 1024) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            eKO.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Function> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean bmD() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bmE() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int blW() {
            return this.name_;
        }

        public boolean bmF() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type bmG() {
            return this.returnType_;
        }

        public boolean bmH() {
            return (this.bitField0_ & 16) == 16;
        }

        public int bmI() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> bkn() {
            return this.typeParameter_;
        }

        public int bko() {
            return this.typeParameter_.size();
        }

        public TypeParameter jE(int i) {
            return (TypeParameter) this.typeParameter_.get(i);
        }

        public boolean bmJ() {
            return (this.bitField0_ & 32) == 32;
        }

        public Type bmK() {
            return this.receiverType_;
        }

        public boolean bmL() {
            return (this.bitField0_ & 64) == 64;
        }

        public int bmM() {
            return this.receiverTypeId_;
        }

        public List<ValueParameter> blf() {
            return this.valueParameter_;
        }

        public int blg() {
            return this.valueParameter_.size();
        }

        public ValueParameter jP(int i) {
            return (ValueParameter) this.valueParameter_.get(i);
        }

        public boolean bkE() {
            return (this.bitField0_ & 128) == 128;
        }

        public TypeTable bkF() {
            return this.typeTable_;
        }

        public List<Integer> bkG() {
            return this.versionRequirement_;
        }

        public boolean bmN() {
            return (this.bitField0_ & 256) == 256;
        }

        public Contract bmO() {
            return this.contract_;
        }

        private void bja() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.bok();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.bok();
            this.receiverTypeId_ = 0;
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.bpU();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.blq();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!bmF() || bmG().isInitialized()) {
                int i = 0;
                while (i < bko()) {
                    if (jE(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!bmJ() || bmK().isInitialized()) {
                    i = 0;
                    while (i < blg()) {
                        if (jP(i).isInitialized()) {
                            i++;
                        } else {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    if (bkE() && !bkF().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    } else if (bmN() && !bmO().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    } else if (buQ()) {
                        this.memoizedIsInitialized = (byte) 1;
                        return true;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.bg(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.b(3, this.returnType_);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.b(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.b(5, this.receiverType_);
            }
            for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
                codedOutputStream.b(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.valueParameter_.get(i3));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.bg(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.bg(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.b(30, this.typeTable_);
            }
            while (i < this.versionRequirement_.size()) {
                codedOutputStream.bg(31, ((Integer) this.versionRequirement_.get(i)).intValue());
                i++;
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.b(32, this.contract_);
            }
            buR.b(19000, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 2) == 2 ? CodedOutputStream.bh(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.bh(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.d(3, this.returnType_);
            }
            int i3 = i;
            for (i = 0; i < this.typeParameter_.size(); i++) {
                i3 += CodedOutputStream.d(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.d(5, this.receiverType_);
            }
            for (i = 0; i < this.valueParameter_.size(); i++) {
                i3 += CodedOutputStream.d(6, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.valueParameter_.get(i));
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.bh(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.bh(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.bh(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.d(30, this.typeTable_);
            }
            i = 0;
            while (i2 < this.versionRequirement_.size()) {
                i += CodedOutputStream.w(((Integer) this.versionRequirement_.get(i2)).intValue());
                i2++;
            }
            i3 = (i3 + i) + (bkG().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.d(32, this.contract_);
            }
            i3 = (i3 + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static Function b(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return (Function) eKF.k(inputStream, fVar);
        }

        public static a bmP() {
            return a.bmS();
        }

        /* renamed from: bmQ */
        public a bjg() {
            return bmP();
        }

        public static a a(Function function) {
            return bmP().a(function);
        }

        /* renamed from: bmR */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Package extends ExtendableMessage<Package> implements i {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Package> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Package>() {
            /* renamed from: x */
            public Package b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Package(eVar, fVar);
            }
        };
        private static final Package eKP = new Package(true);
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Package, a> implements i {
            private int bitField0_;
            private List<Function> function_ = Collections.emptyList();
            private List<Property> property_ = Collections.emptyList();
            private List<TypeAlias> typeAlias_ = Collections.emptyList();
            private TypeTable typeTable_ = TypeTable.bpU();
            private VersionRequirementTable versionRequirementTable_ = VersionRequirementTable.bqR();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bnc() {
                return new a();
            }

            /* renamed from: bnd */
            public a clone() {
                return bnc().a(bnf());
            }

            /* renamed from: bmY */
            public Package bju() {
                return Package.bmX();
            }

            /* renamed from: bne */
            public Package bjx() {
                Object bnf = bnf();
                if (bnf.isInitialized()) {
                    return bnf;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bnf);
            }

            public Package bnf() {
                Package packageR = new Package((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((this.bitField0_ & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                    this.bitField0_ &= -2;
                }
                packageR.function_ = this.function_;
                if ((this.bitField0_ & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -3;
                }
                packageR.property_ = this.property_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    this.bitField0_ &= -5;
                }
                packageR.typeAlias_ = this.typeAlias_;
                if ((i & 8) != 8) {
                    i2 = 0;
                }
                packageR.typeTable_ = this.typeTable_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                packageR.versionRequirementTable_ = this.versionRequirementTable_;
                packageR.bitField0_ = i2;
                return packageR;
            }

            /* renamed from: f */
            public a a(Package packageR) {
                if (packageR == Package.bmX()) {
                    return this;
                }
                if (!packageR.function_.isEmpty()) {
                    if (this.function_.isEmpty()) {
                        this.function_ = packageR.function_;
                        this.bitField0_ &= -2;
                    } else {
                        bkV();
                        this.function_.addAll(packageR.function_);
                    }
                }
                if (!packageR.property_.isEmpty()) {
                    if (this.property_.isEmpty()) {
                        this.property_ = packageR.property_;
                        this.bitField0_ &= -3;
                    } else {
                        bkW();
                        this.property_.addAll(packageR.property_);
                    }
                }
                if (!packageR.typeAlias_.isEmpty()) {
                    if (this.typeAlias_.isEmpty()) {
                        this.typeAlias_ = packageR.typeAlias_;
                        this.bitField0_ &= -5;
                    } else {
                        bkX();
                        this.typeAlias_.addAll(packageR.typeAlias_);
                    }
                }
                if (packageR.bkE()) {
                    c(packageR.bkF());
                }
                if (packageR.bkH()) {
                    b(packageR.bkI());
                }
                a((ExtendableMessage) packageR);
                e(buN().a(packageR.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < bkw(); i++) {
                    if (!jH(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bky(); i++) {
                    if (!jI(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bkA(); i++) {
                    if (!jJ(i).isInitialized()) {
                        return false;
                    }
                }
                if ((!bkE() || bkF().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: y */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Package packageR;
                Throwable th;
                Package packageR2 = null;
                try {
                    Package packageR3 = (Package) Package.eKF.b(eVar, fVar);
                    if (packageR3 != null) {
                        a(packageR3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    packageR = (Package) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    packageR2 = packageR;
                }
                if (packageR2 != null) {
                    a(packageR2);
                }
                throw th;
            }

            private void bkV() {
                if ((this.bitField0_ & 1) != 1) {
                    this.function_ = new ArrayList(this.function_);
                    this.bitField0_ |= 1;
                }
            }

            public int bkw() {
                return this.function_.size();
            }

            public Function jH(int i) {
                return (Function) this.function_.get(i);
            }

            private void bkW() {
                if ((this.bitField0_ & 2) != 2) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 2;
                }
            }

            public int bky() {
                return this.property_.size();
            }

            public Property jI(int i) {
                return (Property) this.property_.get(i);
            }

            private void bkX() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeAlias_ = new ArrayList(this.typeAlias_);
                    this.bitField0_ |= 4;
                }
            }

            public int bkA() {
                return this.typeAlias_.size();
            }

            public TypeAlias jJ(int i) {
                return (TypeAlias) this.typeAlias_.get(i);
            }

            public boolean bkE() {
                return (this.bitField0_ & 8) == 8;
            }

            public TypeTable bkF() {
                return this.typeTable_;
            }

            public a c(TypeTable typeTable) {
                if ((this.bitField0_ & 8) != 8 || this.typeTable_ == TypeTable.bpU()) {
                    this.typeTable_ = typeTable;
                } else {
                    this.typeTable_ = TypeTable.d(this.typeTable_).a(typeTable).bqg();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public a b(VersionRequirementTable versionRequirementTable) {
                if ((this.bitField0_ & 16) != 16 || this.versionRequirementTable_ == VersionRequirementTable.bqR()) {
                    this.versionRequirementTable_ = versionRequirementTable;
                } else {
                    this.versionRequirementTable_ = VersionRequirementTable.c(this.versionRequirementTable_).a(versionRequirementTable).brb();
                }
                this.bitField0_ |= 16;
                return this;
            }
        }

        private Package(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Package, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Package(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Package bmX() {
            return eKP;
        }

        /* renamed from: bmY */
        public Package bjh() {
            return eKP;
        }

        private Package(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                        if (bue == 26) {
                            if ((i & 1) != 1) {
                                this.function_ = new ArrayList();
                                i |= 1;
                            }
                            this.function_.add(eVar.a(Function.eKF, fVar));
                        } else if (bue == 34) {
                            if ((i & 2) != 2) {
                                this.property_ = new ArrayList();
                                i |= 2;
                            }
                            this.property_.add(eVar.a(Property.eKF, fVar));
                        } else if (bue != 42) {
                            a aVar = null;
                            if (bue == 242) {
                                if ((this.bitField0_ & 1) == 1) {
                                    aVar = this.typeTable_.bjf();
                                }
                                this.typeTable_ = (TypeTable) eVar.a(TypeTable.eKF, fVar);
                                if (aVar != null) {
                                    aVar.a(this.typeTable_);
                                    this.typeTable_ = aVar.bqg();
                                }
                                this.bitField0_ |= 1;
                            } else if (bue == 258) {
                                a bqX;
                                if ((this.bitField0_ & 2) == 2) {
                                    bqX = this.versionRequirementTable_.bjf();
                                }
                                this.versionRequirementTable_ = (VersionRequirementTable) eVar.a(VersionRequirementTable.eKF, fVar);
                                if (bqX != null) {
                                    bqX.a(this.versionRequirementTable_);
                                    this.versionRequirementTable_ = bqX.brb();
                                }
                                this.bitField0_ |= 2;
                            } else if (a(eVar, b, fVar, bue)) {
                            }
                        } else {
                            if ((i & 4) != 4) {
                                this.typeAlias_ = new ArrayList();
                                i |= 4;
                            }
                            this.typeAlias_.add(eVar.a(TypeAlias.eKF, fVar));
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if ((i & 2) == 2) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if ((i & 4) == 4) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if ((i & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if ((i & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
            eKP.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Package> biX() {
            return eKF;
        }

        public List<Function> bkv() {
            return this.function_;
        }

        public int bkw() {
            return this.function_.size();
        }

        public Function jH(int i) {
            return (Function) this.function_.get(i);
        }

        public List<Property> bkx() {
            return this.property_;
        }

        public int bky() {
            return this.property_.size();
        }

        public Property jI(int i) {
            return (Property) this.property_.get(i);
        }

        public List<TypeAlias> bkz() {
            return this.typeAlias_;
        }

        public int bkA() {
            return this.typeAlias_.size();
        }

        public TypeAlias jJ(int i) {
            return (TypeAlias) this.typeAlias_.get(i);
        }

        public boolean bkE() {
            return (this.bitField0_ & 1) == 1;
        }

        public TypeTable bkF() {
            return this.typeTable_;
        }

        public boolean bkH() {
            return (this.bitField0_ & 2) == 2;
        }

        public VersionRequirementTable bkI() {
            return this.versionRequirementTable_;
        }

        private void bja() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.bpU();
            this.versionRequirementTable_ = VersionRequirementTable.bqR();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < bkw()) {
                if (jH(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < bky()) {
                if (jI(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < bkA()) {
                if (jJ(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (bkE() && !bkF().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (buQ()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            int i;
            bjb();
            a buR = buR();
            for (i = 0; i < this.function_.size(); i++) {
                codedOutputStream.b(3, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.function_.get(i));
            }
            for (i = 0; i < this.property_.size(); i++) {
                codedOutputStream.b(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.property_.get(i));
            }
            for (int i2 = 0; i2 < this.typeAlias_.size(); i2++) {
                codedOutputStream.b(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeAlias_.get(i2));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.b(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.b(32, this.versionRequirementTable_);
            }
            buR.b(200, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2;
            int i3 = 0;
            for (i2 = 0; i2 < this.function_.size(); i2++) {
                i3 += CodedOutputStream.d(3, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.function_.get(i2));
            }
            for (i2 = 0; i2 < this.property_.size(); i2++) {
                i3 += CodedOutputStream.d(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.property_.get(i2));
            }
            for (i = 0; i < this.typeAlias_.size(); i++) {
                i3 += CodedOutputStream.d(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeAlias_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.d(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.d(32, this.versionRequirementTable_);
            }
            i3 = (i3 + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static Package c(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return (Package) eKF.k(inputStream, fVar);
        }

        public static a bmZ() {
            return a.bnc();
        }

        /* renamed from: bna */
        public a bjg() {
            return bmZ();
        }

        public static a a(Package packageR) {
            return bmZ().a(packageR);
        }

        /* renamed from: bnb */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Property extends ExtendableMessage<Property> implements j {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Property> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Property>() {
            /* renamed from: z */
            public Property b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Property(eVar, fVar);
            }
        };
        private static final Property eKQ = new Property(true);
        private int bitField0_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Property, a> implements j {
            private int bitField0_;
            private int flags_ = 518;
            private int getterFlags_;
            private int name_;
            private int oldFlags_ = 2054;
            private int receiverTypeId_;
            private Type receiverType_ = Type.bok();
            private int returnTypeId_;
            private Type returnType_ = Type.bok();
            private int setterFlags_;
            private ValueParameter setterValueParameter_ = ValueParameter.bqj();
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bns() {
                return new a();
            }

            /* renamed from: bnt */
            public a clone() {
                return bns().a(bnv());
            }

            /* renamed from: bni */
            public Property bju() {
                return Property.bnh();
            }

            /* renamed from: bnu */
            public Property bjx() {
                Object bnv = bnv();
                if (bnv.isInitialized()) {
                    return bnv;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bnv);
            }

            public Property bnv() {
                Property property = new Property((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                property.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                property.oldFlags_ = this.oldFlags_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                property.name_ = this.name_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                property.returnType_ = this.returnType_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                property.returnTypeId_ = this.returnTypeId_;
                if ((this.bitField0_ & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -33;
                }
                property.typeParameter_ = this.typeParameter_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                property.receiverType_ = this.receiverType_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                property.receiverTypeId_ = this.receiverTypeId_;
                if ((i & 256) == 256) {
                    i2 |= 128;
                }
                property.setterValueParameter_ = this.setterValueParameter_;
                if ((i & 512) == 512) {
                    i2 |= 256;
                }
                property.getterFlags_ = this.getterFlags_;
                if ((i & 1024) == 1024) {
                    i2 |= 512;
                }
                property.setterFlags_ = this.setterFlags_;
                if ((this.bitField0_ & 2048) == 2048) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -2049;
                }
                property.versionRequirement_ = this.versionRequirement_;
                property.bitField0_ = i2;
                return property;
            }

            /* renamed from: e */
            public a a(Property property) {
                if (property == Property.bnh()) {
                    return this;
                }
                if (property.bjR()) {
                    kj(property.getFlags());
                }
                if (property.bmD()) {
                    kk(property.bmE());
                }
                if (property.hasName()) {
                    kl(property.blW());
                }
                if (property.bmF()) {
                    d(property.bmG());
                }
                if (property.bmH()) {
                    km(property.bmI());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = property.typeParameter_;
                        this.bitField0_ &= -33;
                    } else {
                        bkQ();
                        this.typeParameter_.addAll(property.typeParameter_);
                    }
                }
                if (property.bmJ()) {
                    e(property.bmK());
                }
                if (property.bmL()) {
                    kn(property.bmM());
                }
                if (property.bnj()) {
                    a(property.bnk());
                }
                if (property.bnl()) {
                    ko(property.bnm());
                }
                if (property.bnn()) {
                    kp(property.bno());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = property.versionRequirement_;
                        this.bitField0_ &= -2049;
                    } else {
                        bla();
                        this.versionRequirement_.addAll(property.versionRequirement_);
                    }
                }
                a((ExtendableMessage) property);
                e(buN().a(property.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (bmF() && !bmG().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < bko(); i++) {
                    if (!jE(i).isInitialized()) {
                        return false;
                    }
                }
                if (bmJ() && !bmK().isInitialized()) {
                    return false;
                }
                if ((!bnj() || bnk().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: A */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Property property;
                Throwable th;
                Property property2 = null;
                try {
                    Property property3 = (Property) Property.eKF.b(eVar, fVar);
                    if (property3 != null) {
                        a(property3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    property = (Property) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    property2 = property;
                }
                if (property2 != null) {
                    a(property2);
                }
                throw th;
            }

            public a kj(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public a kk(int i) {
                this.bitField0_ |= 2;
                this.oldFlags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 4) == 4;
            }

            public a kl(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public boolean bmF() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type bmG() {
                return this.returnType_;
            }

            public a d(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.returnType_ == Type.bok()) {
                    this.returnType_ = type;
                } else {
                    this.returnType_ = Type.f(this.returnType_).a(type).bpe();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public a km(int i) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = i;
                return this;
            }

            private void bkQ() {
                if ((this.bitField0_ & 32) != 32) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 32;
                }
            }

            public int bko() {
                return this.typeParameter_.size();
            }

            public TypeParameter jE(int i) {
                return (TypeParameter) this.typeParameter_.get(i);
            }

            public boolean bmJ() {
                return (this.bitField0_ & 64) == 64;
            }

            public Type bmK() {
                return this.receiverType_;
            }

            public a e(Type type) {
                if ((this.bitField0_ & 64) != 64 || this.receiverType_ == Type.bok()) {
                    this.receiverType_ = type;
                } else {
                    this.receiverType_ = Type.f(this.receiverType_).a(type).bpe();
                }
                this.bitField0_ |= 64;
                return this;
            }

            public a kn(int i) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = i;
                return this;
            }

            public boolean bnj() {
                return (this.bitField0_ & 256) == 256;
            }

            public ValueParameter bnk() {
                return this.setterValueParameter_;
            }

            public a a(ValueParameter valueParameter) {
                if ((this.bitField0_ & 256) != 256 || this.setterValueParameter_ == ValueParameter.bqj()) {
                    this.setterValueParameter_ = valueParameter;
                } else {
                    this.setterValueParameter_ = ValueParameter.b(this.setterValueParameter_).a(valueParameter).bqv();
                }
                this.bitField0_ |= 256;
                return this;
            }

            public a ko(int i) {
                this.bitField0_ |= 512;
                this.getterFlags_ = i;
                return this;
            }

            public a kp(int i) {
                this.bitField0_ |= 1024;
                this.setterFlags_ = i;
                return this;
            }

            private void bla() {
                if ((this.bitField0_ & 2048) != 2048) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 2048;
                }
            }
        }

        private Property(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Property, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Property(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Property bnh() {
            return eKQ;
        }

        /* renamed from: bni */
        public Property bjh() {
            return eKQ;
        }

        private Property(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                    b bVar = null;
                    switch (bue) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = eVar.buh();
                            break;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = eVar.buh();
                            break;
                        case 26:
                            if ((this.bitField0_ & 8) == 8) {
                                bVar = this.returnType_.bjf();
                            }
                            this.returnType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.returnType_);
                                this.returnType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 34:
                            if ((i & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i |= 32;
                            }
                            this.typeParameter_.add(eVar.a(TypeParameter.eKF, fVar));
                            break;
                        case 42:
                            if ((this.bitField0_ & 32) == 32) {
                                bVar = this.receiverType_.bjf();
                            }
                            this.receiverType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.receiverType_);
                                this.receiverType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 32;
                            break;
                        case 50:
                            a bqr;
                            if ((this.bitField0_ & 128) == 128) {
                                bqr = this.setterValueParameter_.bjf();
                            }
                            this.setterValueParameter_ = (ValueParameter) eVar.a(ValueParameter.eKF, fVar);
                            if (bqr != null) {
                                bqr.a(this.setterValueParameter_);
                                this.setterValueParameter_ = bqr.bqv();
                            }
                            this.bitField0_ |= 128;
                            break;
                        case 56:
                            this.bitField0_ |= 256;
                            this.getterFlags_ = eVar.buh();
                            break;
                        case 64:
                            this.bitField0_ |= 512;
                            this.setterFlags_ = eVar.buh();
                            break;
                        case 72:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = eVar.buh();
                            break;
                        case 80:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = eVar.buh();
                            break;
                        case 88:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.buh();
                            break;
                        case 248:
                            if ((i & 2048) != 2048) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            break;
                        case Callback.DEFAULT_SWIPE_ANIMATION_DURATION /*250*/:
                            bue = eVar.lv(eVar.but());
                            if ((i & 2048) != 2048 && eVar.buz() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            while (eVar.buz() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            }
                            eVar.lw(bue);
                            break;
                        default:
                            if (a(eVar, b, fVar, bue)) {
                                break;
                            }
                            obj = 1;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 2048) == 2048) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            if ((i & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i & 2048) == 2048) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            eKQ.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Property> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean bmD() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bmE() {
            return this.oldFlags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public int blW() {
            return this.name_;
        }

        public boolean bmF() {
            return (this.bitField0_ & 8) == 8;
        }

        public Type bmG() {
            return this.returnType_;
        }

        public boolean bmH() {
            return (this.bitField0_ & 16) == 16;
        }

        public int bmI() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> bkn() {
            return this.typeParameter_;
        }

        public int bko() {
            return this.typeParameter_.size();
        }

        public TypeParameter jE(int i) {
            return (TypeParameter) this.typeParameter_.get(i);
        }

        public boolean bmJ() {
            return (this.bitField0_ & 32) == 32;
        }

        public Type bmK() {
            return this.receiverType_;
        }

        public boolean bmL() {
            return (this.bitField0_ & 64) == 64;
        }

        public int bmM() {
            return this.receiverTypeId_;
        }

        public boolean bnj() {
            return (this.bitField0_ & 128) == 128;
        }

        public ValueParameter bnk() {
            return this.setterValueParameter_;
        }

        public boolean bnl() {
            return (this.bitField0_ & 256) == 256;
        }

        public int bnm() {
            return this.getterFlags_;
        }

        public boolean bnn() {
            return (this.bitField0_ & 512) == 512;
        }

        public int bno() {
            return this.setterFlags_;
        }

        public List<Integer> bkG() {
            return this.versionRequirement_;
        }

        private void bja() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.bok();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.bok();
            this.receiverTypeId_ = 0;
            this.setterValueParameter_ = ValueParameter.bqj();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!bmF() || bmG().isInitialized()) {
                int i = 0;
                while (i < bko()) {
                    if (jE(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (bmJ() && !bmK().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (bnj() && !bnk().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (buQ()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.bg(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.b(3, this.returnType_);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
                codedOutputStream.b(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i2));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.b(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.b(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.bg(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.bg(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.bg(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.bg(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(11, this.flags_);
            }
            while (i < this.versionRequirement_.size()) {
                codedOutputStream.bg(31, ((Integer) this.versionRequirement_.get(i)).intValue());
                i++;
            }
            buR.b(19000, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 2) == 2 ? CodedOutputStream.bh(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.bh(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.d(3, this.returnType_);
            }
            int i3 = i;
            for (i = 0; i < this.typeParameter_.size(); i++) {
                i3 += CodedOutputStream.d(4, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.d(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.d(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i3 += CodedOutputStream.bh(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i3 += CodedOutputStream.bh(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.bh(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.bh(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.bh(11, this.flags_);
            }
            i = 0;
            while (i2 < this.versionRequirement_.size()) {
                i += CodedOutputStream.w(((Integer) this.versionRequirement_.get(i2)).intValue());
                i2++;
            }
            i3 = (((i3 + i) + (bkG().size() * 2)) + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static a bnp() {
            return a.bns();
        }

        /* renamed from: bnq */
        public a bjg() {
            return bnp();
        }

        public static a a(Property property) {
            return bnp().a(property);
        }

        /* renamed from: bnr */
        public a bjf() {
            return a(this);
        }
    }

    public static final class Type extends ExtendableMessage<Type> implements n {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Type> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Type>() {
            /* renamed from: H */
            public Type b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new Type(eVar, fVar);
            }
        };
        private static final Type eKU = new Type(true);
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        public interface a extends kotlin.reflect.jvm.internal.impl.protobuf.o {
        }

        public static final class Argument extends GeneratedMessageLite implements a {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Argument>() {
                /* renamed from: I */
                public Argument b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    return new Argument(eVar, fVar);
                }
            };
            private static final Argument eKV = new Argument(true);
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            public enum Projection implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Projection> internalValueMap;
                private final int value;

                static {
                    internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Projection>() {
                        /* renamed from: kw */
                        public Projection jC(int i) {
                            return Projection.valueOf(i);
                        }
                    };
                }

                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i) {
                    switch (i) {
                        case 0:
                            return IN;
                        case 1:
                            return OUT;
                        case 2:
                            return INV;
                        case 3:
                            return STAR;
                        default:
                            return null;
                    }
                }

                private Projection(int i, int i2) {
                    this.value = i2;
                }
            }

            public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Argument, a> implements a {
                private int bitField0_;
                private Projection projection_ = Projection.INV;
                private int typeId_;
                private Type type_ = Type.bok();

                private void bjp() {
                }

                private a() {
                    bjp();
                }

                private static a boW() {
                    return new a();
                }

                /* renamed from: boX */
                public a clone() {
                    return boW().a(boZ());
                }

                /* renamed from: boO */
                public Argument bju() {
                    return Argument.boN();
                }

                /* renamed from: boY */
                public Argument bjx() {
                    Object boZ = boZ();
                    if (boZ.isInitialized()) {
                        return boZ;
                    }
                    throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(boZ);
                }

                public Argument boZ() {
                    Argument argument = new Argument((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                    int i = this.bitField0_;
                    int i2 = 1;
                    if ((i & 1) != 1) {
                        i2 = 0;
                    }
                    argument.projection_ = this.projection_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    argument.type_ = this.type_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    argument.typeId_ = this.typeId_;
                    argument.bitField0_ = i2;
                    return argument;
                }

                /* renamed from: c */
                public a a(Argument argument) {
                    if (argument == Argument.boN()) {
                        return this;
                    }
                    if (argument.boP()) {
                        a(argument.boQ());
                    }
                    if (argument.hasType()) {
                        i(argument.boR());
                    }
                    if (argument.boS()) {
                        kv(argument.getTypeId());
                    }
                    e(buN().a(argument.unknownFields));
                    return this;
                }

                public final boolean isInitialized() {
                    return !hasType() || boR().isInitialized();
                }

                /* renamed from: J */
                public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                    Argument argument;
                    Throwable th;
                    Argument argument2 = null;
                    try {
                        Argument argument3 = (Argument) Argument.eKF.b(eVar, fVar);
                        if (argument3 != null) {
                            a(argument3);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        argument = (Argument) e.buW();
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        argument2 = argument;
                    }
                    if (argument2 != null) {
                        a(argument2);
                    }
                    throw th;
                }

                public a a(Projection projection) {
                    if (projection == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.projection_ = projection;
                    return this;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 2) == 2;
                }

                public Type boR() {
                    return this.type_;
                }

                public a i(Type type) {
                    if ((this.bitField0_ & 2) != 2 || this.type_ == Type.bok()) {
                        this.type_ = type;
                    } else {
                        this.type_ = Type.f(this.type_).a(type).bpe();
                    }
                    this.bitField0_ |= 2;
                    return this;
                }

                public a kv(int i) {
                    this.bitField0_ |= 4;
                    this.typeId_ = i;
                    return this;
                }
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
                super(aVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = aVar.buN();
            }

            private Argument(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
            }

            public static Argument boN() {
                return eKV;
            }

            /* renamed from: boO */
            public Argument bjh() {
                return eKV;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                                int buo = eVar.buo();
                                Projection valueOf = Projection.valueOf(buo);
                                if (valueOf == null) {
                                    b.C(bue);
                                    b.C(buo);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.projection_ = valueOf;
                                }
                            } else if (bue == 18) {
                                b bVar = null;
                                if ((this.bitField0_ & 2) == 2) {
                                    bVar = this.type_.bjf();
                                }
                                this.type_ = (Type) eVar.a(Type.eKF, fVar);
                                if (bVar != null) {
                                    bVar.a(this.type_);
                                    this.type_ = bVar.bpe();
                                }
                                this.bitField0_ |= 2;
                            } else if (bue == 24) {
                                this.bitField0_ |= 4;
                                this.typeId_ = eVar.buh();
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
                eKV.bja();
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> biX() {
                return eKF;
            }

            public boolean boP() {
                return (this.bitField0_ & 1) == 1;
            }

            public Projection boQ() {
                return this.projection_;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public Type boR() {
                return this.type_;
            }

            public boolean boS() {
                return (this.bitField0_ & 4) == 4;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            private void bja() {
                this.projection_ = Projection.INV;
                this.type_ = Type.bok();
                this.typeId_ = 0;
            }

            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == (byte) 1) {
                    return true;
                }
                if (b == (byte) 0) {
                    return false;
                }
                if (!hasType() || boR().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            public void a(CodedOutputStream codedOutputStream) {
                bjb();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.k(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.b(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.bg(3, this.typeId_);
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
                    i = 0 + CodedOutputStream.n(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    i += CodedOutputStream.d(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    i += CodedOutputStream.bh(3, this.typeId_);
                }
                i += this.unknownFields.size();
                this.memoizedSerializedSize = i;
                return i;
            }

            public static a boT() {
                return a.boW();
            }

            /* renamed from: boU */
            public a bjg() {
                return boT();
            }

            public static a a(Argument argument) {
                return boT().a(argument);
            }

            /* renamed from: boV */
            public a bjf() {
                return a(this);
            }
        }

        public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Type, b> implements n {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_ = Type.bok();
            private List<Argument> argument_ = Collections.emptyList();
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_ = Type.bok();
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_ = Type.bok();
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private void bjp() {
            }

            private b() {
                bjp();
            }

            private static b bpb() {
                return new b();
            }

            /* renamed from: bpc */
            public b clone() {
                return bpb().a(bpe());
            }

            /* renamed from: bol */
            public Type bju() {
                return Type.bok();
            }

            /* renamed from: bpd */
            public Type bjx() {
                Object bpe = bpe();
                if (bpe.isInitialized()) {
                    return bpe;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bpe);
            }

            public Type bpe() {
                Type type = new Type((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((this.bitField0_ & 1) == 1) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
                    this.bitField0_ &= -2;
                }
                type.argument_ = this.argument_;
                if ((i & 2) != 2) {
                    i2 = 0;
                }
                type.nullable_ = this.nullable_;
                if ((i & 4) == 4) {
                    i2 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                type.flexibleUpperBound_ = this.flexibleUpperBound_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                type.className_ = this.className_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                type.typeParameter_ = this.typeParameter_;
                if ((i & 128) == 128) {
                    i2 |= 64;
                }
                type.typeParameterName_ = this.typeParameterName_;
                if ((i & 256) == 256) {
                    i2 |= 128;
                }
                type.typeAliasName_ = this.typeAliasName_;
                if ((i & 512) == 512) {
                    i2 |= 256;
                }
                type.outerType_ = this.outerType_;
                if ((i & 1024) == 1024) {
                    i2 |= 512;
                }
                type.outerTypeId_ = this.outerTypeId_;
                if ((i & 2048) == 2048) {
                    i2 |= 1024;
                }
                type.abbreviatedType_ = this.abbreviatedType_;
                if ((i & 4096) == 4096) {
                    i2 |= 2048;
                }
                type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
                if ((i & 8192) == 8192) {
                    i2 |= 4096;
                }
                type.flags_ = this.flags_;
                type.bitField0_ = i2;
                return type;
            }

            /* renamed from: j */
            public b a(Type type) {
                if (type == Type.bok()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.argument_.isEmpty()) {
                        this.argument_ = type.argument_;
                        this.bitField0_ &= -2;
                    } else {
                        bkf();
                        this.argument_.addAll(type.argument_);
                    }
                }
                if (type.bom()) {
                    gS(type.bon());
                }
                if (type.boo()) {
                    kx(type.bop());
                }
                if (type.boq()) {
                    k(type.bor());
                }
                if (type.bos()) {
                    ky(type.bot());
                }
                if (type.bou()) {
                    kz(type.bov());
                }
                if (type.bow()) {
                    kA(type.box());
                }
                if (type.boy()) {
                    kB(type.boz());
                }
                if (type.boA()) {
                    kC(type.boB());
                }
                if (type.boC()) {
                    l(type.boD());
                }
                if (type.boE()) {
                    kD(type.boF());
                }
                if (type.boG()) {
                    m(type.boH());
                }
                if (type.boI()) {
                    kE(type.boJ());
                }
                if (type.bjR()) {
                    kF(type.getFlags());
                }
                a((ExtendableMessage) type);
                e(buN().a(type.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < biZ(); i++) {
                    if (!ku(i).isInitialized()) {
                        return false;
                    }
                }
                if (boq() && !bor().isInitialized()) {
                    return false;
                }
                if (boC() && !boD().isInitialized()) {
                    return false;
                }
                if ((!boG() || boH().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: K */
            public b f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                Type type;
                Throwable th;
                Type type2 = null;
                try {
                    Type type3 = (Type) Type.eKF.b(eVar, fVar);
                    if (type3 != null) {
                        a(type3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    type = (Type) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    type2 = type;
                }
                if (type2 != null) {
                    a(type2);
                }
                throw th;
            }

            private void bkf() {
                if ((this.bitField0_ & 1) != 1) {
                    this.argument_ = new ArrayList(this.argument_);
                    this.bitField0_ |= 1;
                }
            }

            public int biZ() {
                return this.argument_.size();
            }

            public Argument ku(int i) {
                return (Argument) this.argument_.get(i);
            }

            public b gS(boolean z) {
                this.bitField0_ |= 2;
                this.nullable_ = z;
                return this;
            }

            public b kx(int i) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = i;
                return this;
            }

            public boolean boq() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type bor() {
                return this.flexibleUpperBound_;
            }

            public b k(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.flexibleUpperBound_ == Type.bok()) {
                    this.flexibleUpperBound_ = type;
                } else {
                    this.flexibleUpperBound_ = Type.f(this.flexibleUpperBound_).a(type).bpe();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public b ky(int i) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = i;
                return this;
            }

            public b kz(int i) {
                this.bitField0_ |= 32;
                this.className_ = i;
                return this;
            }

            public b kA(int i) {
                this.bitField0_ |= 64;
                this.typeParameter_ = i;
                return this;
            }

            public b kB(int i) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = i;
                return this;
            }

            public b kC(int i) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = i;
                return this;
            }

            public boolean boC() {
                return (this.bitField0_ & 512) == 512;
            }

            public Type boD() {
                return this.outerType_;
            }

            public b l(Type type) {
                if ((this.bitField0_ & 512) != 512 || this.outerType_ == Type.bok()) {
                    this.outerType_ = type;
                } else {
                    this.outerType_ = Type.f(this.outerType_).a(type).bpe();
                }
                this.bitField0_ |= 512;
                return this;
            }

            public b kD(int i) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = i;
                return this;
            }

            public boolean boG() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public Type boH() {
                return this.abbreviatedType_;
            }

            public b m(Type type) {
                if ((this.bitField0_ & 2048) != 2048 || this.abbreviatedType_ == Type.bok()) {
                    this.abbreviatedType_ = type;
                } else {
                    this.abbreviatedType_ = Type.f(this.abbreviatedType_).a(type).bpe();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public b kE(int i) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = i;
                return this;
            }

            public b kF(int i) {
                this.bitField0_ |= 8192;
                this.flags_ = i;
                return this;
            }
        }

        private Type(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<Type, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private Type(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static Type bok() {
            return eKU;
        }

        /* renamed from: bol */
        public Type bjh() {
            return eKU;
        }

        private Type(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                    b bVar = null;
                    switch (bue) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = eVar.buh();
                            break;
                        case 18:
                            if ((i & 1) != 1) {
                                this.argument_ = new ArrayList();
                                i |= 1;
                            }
                            this.argument_.add(eVar.a(Argument.eKF, fVar));
                            break;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = eVar.buk();
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = eVar.buh();
                            break;
                        case 42:
                            if ((this.bitField0_ & 4) == 4) {
                                bVar = this.flexibleUpperBound_.bjf();
                            }
                            this.flexibleUpperBound_ = (Type) eVar.a(eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.flexibleUpperBound_);
                                this.flexibleUpperBound_ = bVar.bpe();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 48:
                            this.bitField0_ |= 16;
                            this.className_ = eVar.buh();
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = eVar.buh();
                            break;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = eVar.buh();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = eVar.buh();
                            break;
                        case 82:
                            if ((this.bitField0_ & 256) == 256) {
                                bVar = this.outerType_.bjf();
                            }
                            this.outerType_ = (Type) eVar.a(eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.outerType_);
                                this.outerType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 256;
                            break;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = eVar.buh();
                            break;
                        case 96:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = eVar.buh();
                            break;
                        case 106:
                            if ((this.bitField0_ & 1024) == 1024) {
                                bVar = this.abbreviatedType_.bjf();
                            }
                            this.abbreviatedType_ = (Type) eVar.a(eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.abbreviatedType_);
                                this.abbreviatedType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 1024;
                            break;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = eVar.buh();
                            break;
                        default:
                            if (a(eVar, b, fVar, bue)) {
                                break;
                            }
                            obj = 1;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
                this.argument_ = Collections.unmodifiableList(this.argument_);
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
            eKU.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<Type> biX() {
            return eKF;
        }

        public List<Argument> biY() {
            return this.argument_;
        }

        public int biZ() {
            return this.argument_.size();
        }

        public Argument ku(int i) {
            return (Argument) this.argument_.get(i);
        }

        public boolean bom() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean bon() {
            return this.nullable_;
        }

        public boolean boo() {
            return (this.bitField0_ & 2) == 2;
        }

        public int bop() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public boolean boq() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type bor() {
            return this.flexibleUpperBound_;
        }

        public boolean bos() {
            return (this.bitField0_ & 8) == 8;
        }

        public int bot() {
            return this.flexibleUpperBoundId_;
        }

        public boolean bou() {
            return (this.bitField0_ & 16) == 16;
        }

        public int bov() {
            return this.className_;
        }

        public boolean bow() {
            return (this.bitField0_ & 32) == 32;
        }

        public int box() {
            return this.typeParameter_;
        }

        public boolean boy() {
            return (this.bitField0_ & 64) == 64;
        }

        public int boz() {
            return this.typeParameterName_;
        }

        public boolean boA() {
            return (this.bitField0_ & 128) == 128;
        }

        public int boB() {
            return this.typeAliasName_;
        }

        public boolean boC() {
            return (this.bitField0_ & 256) == 256;
        }

        public Type boD() {
            return this.outerType_;
        }

        public boolean boE() {
            return (this.bitField0_ & 512) == 512;
        }

        public int boF() {
            return this.outerTypeId_;
        }

        public boolean boG() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public Type boH() {
            return this.abbreviatedType_;
        }

        public boolean boI() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public int boJ() {
            return this.abbreviatedTypeId_;
        }

        public boolean bjR() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public int getFlags() {
            return this.flags_;
        }

        private void bja() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = bok();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = bok();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = bok();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            int i = 0;
            while (i < biZ()) {
                if (ku(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (boq() && !bor().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (boC() && !boD().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (boG() && !boH().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (buQ()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.bg(1, this.flags_);
            }
            for (int i = 0; i < this.argument_.size(); i++) {
                codedOutputStream.b(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.argument_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.c(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.b(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.bg(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.bg(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.bg(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.bg(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.b(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.bg(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.bg(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.b(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.bg(14, this.abbreviatedTypeId_);
            }
            buR.b(200, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.bh(1, this.flags_) + 0 : 0;
            while (i2 < this.argument_.size()) {
                i += CodedOutputStream.d(2, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.argument_.get(i2));
                i2++;
            }
            if ((this.bitField0_ & 1) == 1) {
                i += CodedOutputStream.d(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.d(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.bh(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.bh(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.bh(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i += CodedOutputStream.bh(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                i += CodedOutputStream.d(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                i += CodedOutputStream.bh(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                i += CodedOutputStream.bh(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                i += CodedOutputStream.d(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                i += CodedOutputStream.bh(14, this.abbreviatedTypeId_);
            }
            i = (i + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static b boK() {
            return b.bpb();
        }

        /* renamed from: boL */
        public b bjg() {
            return boK();
        }

        public static b f(Type type) {
            return boK().a(type);
        }

        /* renamed from: boM */
        public b bjf() {
            return f(this);
        }
    }

    public static final class TypeAlias extends ExtendableMessage<TypeAlias> implements m {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<TypeAlias>() {
            /* renamed from: L */
            public TypeAlias b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new TypeAlias(eVar, fVar);
            }
        };
        private static final TypeAlias eKW = new TypeAlias(true);
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<TypeAlias, a> implements m {
            private List<Annotation> annotation_ = Collections.emptyList();
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_ = Type.bok();
            private int flags_ = 6;
            private int name_;
            private List<TypeParameter> typeParameter_ = Collections.emptyList();
            private int underlyingTypeId_;
            private Type underlyingType_ = Type.bok();
            private List<Integer> versionRequirement_ = Collections.emptyList();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bpv() {
                return new a();
            }

            /* renamed from: bpw */
            public a clone() {
                return bpv().a(bpy());
            }

            /* renamed from: bph */
            public TypeAlias bju() {
                return TypeAlias.bpg();
            }

            /* renamed from: bpx */
            public TypeAlias bjx() {
                Object bpy = bpy();
                if (bpy.isInitialized()) {
                    return bpy;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bpy);
            }

            public TypeAlias bpy() {
                TypeAlias typeAlias = new TypeAlias((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                typeAlias.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                typeAlias.name_ = this.name_;
                if ((this.bitField0_ & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    this.bitField0_ &= -5;
                }
                typeAlias.typeParameter_ = this.typeParameter_;
                if ((i & 8) == 8) {
                    i2 |= 4;
                }
                typeAlias.underlyingType_ = this.underlyingType_;
                if ((i & 16) == 16) {
                    i2 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.underlyingTypeId_;
                if ((i & 32) == 32) {
                    i2 |= 16;
                }
                typeAlias.expandedType_ = this.expandedType_;
                if ((i & 64) == 64) {
                    i2 |= 32;
                }
                typeAlias.expandedTypeId_ = this.expandedTypeId_;
                if ((this.bitField0_ & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -129;
                }
                typeAlias.annotation_ = this.annotation_;
                if ((this.bitField0_ & 256) == 256) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    this.bitField0_ &= -257;
                }
                typeAlias.versionRequirement_ = this.versionRequirement_;
                typeAlias.bitField0_ = i2;
                return typeAlias;
            }

            /* renamed from: f */
            public a a(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.bpg()) {
                    return this;
                }
                if (typeAlias.bjR()) {
                    kH(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    kI(typeAlias.blW());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.typeParameter_.isEmpty()) {
                        this.typeParameter_ = typeAlias.typeParameter_;
                        this.bitField0_ &= -5;
                    } else {
                        bkQ();
                        this.typeParameter_.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.bpi()) {
                    n(typeAlias.bpj());
                }
                if (typeAlias.bpk()) {
                    kJ(typeAlias.bpl());
                }
                if (typeAlias.bpm()) {
                    o(typeAlias.bpn());
                }
                if (typeAlias.bpo()) {
                    kK(typeAlias.bpp());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = typeAlias.annotation_;
                        this.bitField0_ &= -129;
                    } else {
                        bpz();
                        this.annotation_.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.versionRequirement_.isEmpty()) {
                        this.versionRequirement_ = typeAlias.versionRequirement_;
                        this.bitField0_ &= -257;
                    } else {
                        bla();
                        this.versionRequirement_.addAll(typeAlias.versionRequirement_);
                    }
                }
                a((ExtendableMessage) typeAlias);
                e(buN().a(typeAlias.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                int i;
                for (i = 0; i < bko(); i++) {
                    if (!jE(i).isInitialized()) {
                        return false;
                    }
                }
                if (bpi() && !bpj().isInitialized()) {
                    return false;
                }
                if (bpm() && !bpn().isInitialized()) {
                    return false;
                }
                for (i = 0; i < bpr(); i++) {
                    if (!kG(i).isInitialized()) {
                        return false;
                    }
                }
                if (buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: M */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                TypeAlias typeAlias;
                Throwable th;
                TypeAlias typeAlias2 = null;
                try {
                    TypeAlias typeAlias3 = (TypeAlias) TypeAlias.eKF.b(eVar, fVar);
                    if (typeAlias3 != null) {
                        a(typeAlias3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeAlias = (TypeAlias) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    typeAlias2 = typeAlias;
                }
                if (typeAlias2 != null) {
                    a(typeAlias2);
                }
                throw th;
            }

            public a kH(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public a kI(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            private void bkQ() {
                if ((this.bitField0_ & 4) != 4) {
                    this.typeParameter_ = new ArrayList(this.typeParameter_);
                    this.bitField0_ |= 4;
                }
            }

            public int bko() {
                return this.typeParameter_.size();
            }

            public TypeParameter jE(int i) {
                return (TypeParameter) this.typeParameter_.get(i);
            }

            public boolean bpi() {
                return (this.bitField0_ & 8) == 8;
            }

            public Type bpj() {
                return this.underlyingType_;
            }

            public a n(Type type) {
                if ((this.bitField0_ & 8) != 8 || this.underlyingType_ == Type.bok()) {
                    this.underlyingType_ = type;
                } else {
                    this.underlyingType_ = Type.f(this.underlyingType_).a(type).bpe();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public a kJ(int i) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = i;
                return this;
            }

            public boolean bpm() {
                return (this.bitField0_ & 32) == 32;
            }

            public Type bpn() {
                return this.expandedType_;
            }

            public a o(Type type) {
                if ((this.bitField0_ & 32) != 32 || this.expandedType_ == Type.bok()) {
                    this.expandedType_ = type;
                } else {
                    this.expandedType_ = Type.f(this.expandedType_).a(type).bpe();
                }
                this.bitField0_ |= 32;
                return this;
            }

            public a kK(int i) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = i;
                return this;
            }

            private void bpz() {
                if ((this.bitField0_ & 128) != 128) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 128;
                }
            }

            public int bpr() {
                return this.annotation_.size();
            }

            public Annotation kG(int i) {
                return (Annotation) this.annotation_.get(i);
            }

            private void bla() {
                if ((this.bitField0_ & 256) != 256) {
                    this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                    this.bitField0_ |= 256;
                }
            }
        }

        private TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<TypeAlias, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private TypeAlias(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static TypeAlias bpg() {
            return eKW;
        }

        /* renamed from: bph */
        public TypeAlias bjh() {
            return eKW;
        }

        private TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                    b bVar = null;
                    switch (bue) {
                        case 0:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = eVar.buh();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = eVar.buh();
                            break;
                        case 26:
                            if ((i & 4) != 4) {
                                this.typeParameter_ = new ArrayList();
                                i |= 4;
                            }
                            this.typeParameter_.add(eVar.a(TypeParameter.eKF, fVar));
                            break;
                        case 34:
                            if ((this.bitField0_ & 4) == 4) {
                                bVar = this.underlyingType_.bjf();
                            }
                            this.underlyingType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.underlyingType_);
                                this.underlyingType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = eVar.buh();
                            break;
                        case 50:
                            if ((this.bitField0_ & 16) == 16) {
                                bVar = this.expandedType_.bjf();
                            }
                            this.expandedType_ = (Type) eVar.a(Type.eKF, fVar);
                            if (bVar != null) {
                                bVar.a(this.expandedType_);
                                this.expandedType_ = bVar.bpe();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = eVar.buh();
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.annotation_ = new ArrayList();
                                i |= 128;
                            }
                            this.annotation_.add(eVar.a(Annotation.eKF, fVar));
                            break;
                        case 248:
                            if ((i & 256) != 256) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 256;
                            }
                            this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            break;
                        case Callback.DEFAULT_SWIPE_ANIMATION_DURATION /*250*/:
                            bue = eVar.lv(eVar.but());
                            if ((i & 256) != 256 && eVar.buz() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 256;
                            }
                            while (eVar.buz() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(eVar.buh()));
                            }
                            eVar.lw(bue);
                            break;
                        default:
                            if (a(eVar, b, fVar, bue)) {
                                break;
                            }
                            obj = 1;
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i & 256) == 256) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            if ((i & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if ((i & 256) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
            eKW.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int blW() {
            return this.name_;
        }

        public List<TypeParameter> bkn() {
            return this.typeParameter_;
        }

        public int bko() {
            return this.typeParameter_.size();
        }

        public TypeParameter jE(int i) {
            return (TypeParameter) this.typeParameter_.get(i);
        }

        public boolean bpi() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type bpj() {
            return this.underlyingType_;
        }

        public boolean bpk() {
            return (this.bitField0_ & 8) == 8;
        }

        public int bpl() {
            return this.underlyingTypeId_;
        }

        public boolean bpm() {
            return (this.bitField0_ & 16) == 16;
        }

        public Type bpn() {
            return this.expandedType_;
        }

        public boolean bpo() {
            return (this.bitField0_ & 32) == 32;
        }

        public int bpp() {
            return this.expandedTypeId_;
        }

        public List<Annotation> bpq() {
            return this.annotation_;
        }

        public int bpr() {
            return this.annotation_.size();
        }

        public Annotation kG(int i) {
            return (Annotation) this.annotation_.get(i);
        }

        public List<Integer> bkG() {
            return this.versionRequirement_;
        }

        private void bja() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.bok();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.bok();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (hasName()) {
                int i = 0;
                while (i < bko()) {
                    if (jE(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (bpi() && !bpj().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!bpm() || bpn().isInitialized()) {
                    i = 0;
                    while (i < bpr()) {
                        if (kG(i).isInitialized()) {
                            i++;
                        } else {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    if (buQ()) {
                        this.memoizedIsInitialized = (byte) 1;
                        return true;
                    }
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            int i;
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.name_);
            }
            for (i = 0; i < this.typeParameter_.size(); i++) {
                codedOutputStream.b(3, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.b(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.bg(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.b(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.bg(7, this.expandedTypeId_);
            }
            for (i = 0; i < this.annotation_.size(); i++) {
                codedOutputStream.b(8, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.annotation_.get(i));
            }
            for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
                codedOutputStream.bg(31, ((Integer) this.versionRequirement_.get(i2)).intValue());
            }
            buR.b(200, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.name_);
            }
            int i3 = i;
            for (i = 0; i < this.typeParameter_.size(); i++) {
                i3 += CodedOutputStream.d(3, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.typeParameter_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.d(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.bh(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.d(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.bh(7, this.expandedTypeId_);
            }
            for (i = 0; i < this.annotation_.size(); i++) {
                i3 += CodedOutputStream.d(8, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.annotation_.get(i));
            }
            i = 0;
            while (i2 < this.versionRequirement_.size()) {
                i += CodedOutputStream.w(((Integer) this.versionRequirement_.get(i2)).intValue());
                i2++;
            }
            i3 = (((i3 + i) + (bkG().size() * 2)) + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static TypeAlias d(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            return (TypeAlias) eKF.j(inputStream, fVar);
        }

        public static a bps() {
            return a.bpv();
        }

        /* renamed from: bpt */
        public a bjg() {
            return bps();
        }

        public static a a(TypeAlias typeAlias) {
            return bps().a(typeAlias);
        }

        /* renamed from: bpu */
        public a bjf() {
            return a(this);
        }
    }

    public static final class TypeParameter extends ExtendableMessage<TypeParameter> implements o {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<TypeParameter>() {
            /* renamed from: N */
            public TypeParameter b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new TypeParameter(eVar, fVar);
            }
        };
        private static final TypeParameter eKX = new TypeParameter(true);
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        public enum Variance implements kotlin.reflect.jvm.internal.impl.protobuf.h.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            private static kotlin.reflect.jvm.internal.impl.protobuf.h.b<Variance> internalValueMap;
            private final int value;

            static {
                internalValueMap = new kotlin.reflect.jvm.internal.impl.protobuf.h.b<Variance>() {
                    /* renamed from: kO */
                    public Variance jC(int i) {
                        return Variance.valueOf(i);
                    }
                };
            }

            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i) {
                switch (i) {
                    case 0:
                        return IN;
                    case 1:
                        return OUT;
                    case 2:
                        return INV;
                    default:
                        return null;
                }
            }

            private Variance(int i, int i2) {
                this.value = i2;
            }
        }

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<TypeParameter, a> implements o {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_ = Collections.emptyList();
            private List<Type> upperBound_ = Collections.emptyList();
            private Variance variance_ = Variance.INV;

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bpN() {
                return new a();
            }

            /* renamed from: bpO */
            public a clone() {
                return bpN().a(bpQ());
            }

            /* renamed from: bpC */
            public TypeParameter bju() {
                return TypeParameter.bpB();
            }

            /* renamed from: bpP */
            public TypeParameter bjx() {
                Object bpQ = bpQ();
                if (bpQ.isInitialized()) {
                    return bpQ;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bpQ);
            }

            public TypeParameter bpQ() {
                TypeParameter typeParameter = new TypeParameter((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                typeParameter.id_ = this.id_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                typeParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                typeParameter.reified_ = this.reified_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                typeParameter.variance_ = this.variance_;
                if ((this.bitField0_ & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    this.bitField0_ &= -17;
                }
                typeParameter.upperBound_ = this.upperBound_;
                if ((this.bitField0_ & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    this.bitField0_ &= -33;
                }
                typeParameter.upperBoundId_ = this.upperBoundId_;
                typeParameter.bitField0_ = i2;
                return typeParameter;
            }

            /* renamed from: e */
            public a a(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.bpB()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    kM(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    kN(typeParameter.blW());
                }
                if (typeParameter.bpD()) {
                    gT(typeParameter.bpE());
                }
                if (typeParameter.bpF()) {
                    a(typeParameter.bpG());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.upperBound_.isEmpty()) {
                        this.upperBound_ = typeParameter.upperBound_;
                        this.bitField0_ &= -17;
                    } else {
                        bpR();
                        this.upperBound_.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.upperBoundId_.isEmpty()) {
                        this.upperBoundId_ = typeParameter.upperBoundId_;
                        this.bitField0_ &= -33;
                    } else {
                        bpS();
                        this.upperBoundId_.addAll(typeParameter.upperBoundId_);
                    }
                }
                a((ExtendableMessage) typeParameter);
                e(buN().a(typeParameter.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId() || !hasName()) {
                    return false;
                }
                for (int i = 0; i < bpI(); i++) {
                    if (!kL(i).isInitialized()) {
                        return false;
                    }
                }
                if (buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: O */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                TypeParameter typeParameter;
                Throwable th;
                TypeParameter typeParameter2 = null;
                try {
                    TypeParameter typeParameter3 = (TypeParameter) TypeParameter.eKF.b(eVar, fVar);
                    if (typeParameter3 != null) {
                        a(typeParameter3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    typeParameter = (TypeParameter) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    typeParameter2 = typeParameter;
                }
                if (typeParameter2 != null) {
                    a(typeParameter2);
                }
                throw th;
            }

            public boolean hasId() {
                return (this.bitField0_ & 1) == 1;
            }

            public a kM(int i) {
                this.bitField0_ |= 1;
                this.id_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public a kN(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public a gT(boolean z) {
                this.bitField0_ |= 4;
                this.reified_ = z;
                return this;
            }

            public a a(Variance variance) {
                if (variance == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.variance_ = variance;
                return this;
            }

            private void bpR() {
                if ((this.bitField0_ & 16) != 16) {
                    this.upperBound_ = new ArrayList(this.upperBound_);
                    this.bitField0_ |= 16;
                }
            }

            public int bpI() {
                return this.upperBound_.size();
            }

            public Type kL(int i) {
                return (Type) this.upperBound_.get(i);
            }

            private void bpS() {
                if ((this.bitField0_ & 32) != 32) {
                    this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                    this.bitField0_ |= 32;
                }
            }
        }

        private TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<TypeParameter, ?> bVar) {
            super(bVar);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private TypeParameter(boolean z) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static TypeParameter bpB() {
            return eKX;
        }

        /* renamed from: bpC */
        public TypeParameter bjh() {
            return eKX;
        }

        private TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            this.upperBoundIdMemoizedSerializedSize = -1;
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
                            this.id_ = eVar.buh();
                        } else if (bue == 16) {
                            this.bitField0_ |= 2;
                            this.name_ = eVar.buh();
                        } else if (bue == 24) {
                            this.bitField0_ |= 4;
                            this.reified_ = eVar.buk();
                        } else if (bue == 32) {
                            int buo = eVar.buo();
                            Variance valueOf = Variance.valueOf(buo);
                            if (valueOf == null) {
                                b.C(bue);
                                b.C(buo);
                            } else {
                                this.bitField0_ |= 8;
                                this.variance_ = valueOf;
                            }
                        } else if (bue == 42) {
                            if ((i & 16) != 16) {
                                this.upperBound_ = new ArrayList();
                                i |= 16;
                            }
                            this.upperBound_.add(eVar.a(Type.eKF, fVar));
                        } else if (bue == 48) {
                            if ((i & 32) != 32) {
                                this.upperBoundId_ = new ArrayList();
                                i |= 32;
                            }
                            this.upperBoundId_.add(Integer.valueOf(eVar.buh()));
                        } else if (bue == 50) {
                            bue = eVar.lv(eVar.but());
                            if ((i & 32) != 32 && eVar.buz() > 0) {
                                this.upperBoundId_ = new ArrayList();
                                i |= 32;
                            }
                            while (eVar.buz() > 0) {
                                this.upperBoundId_.add(Integer.valueOf(eVar.buh()));
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
                    if ((i & 16) == 16) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if ((i & 32) == 32) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if ((i & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
            eKX.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> biX() {
            return eKF;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getId() {
            return this.id_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int blW() {
            return this.name_;
        }

        public boolean bpD() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean bpE() {
            return this.reified_;
        }

        public boolean bpF() {
            return (this.bitField0_ & 8) == 8;
        }

        public Variance bpG() {
            return this.variance_;
        }

        public List<Type> bpH() {
            return this.upperBound_;
        }

        public int bpI() {
            return this.upperBound_.size();
        }

        public Type kL(int i) {
            return (Type) this.upperBound_.get(i);
        }

        public List<Integer> bpJ() {
            return this.upperBoundId_;
        }

        private void bja() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasName()) {
                int i = 0;
                while (i < bpI()) {
                    if (kL(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (buQ()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.c(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.k(4, this.variance_.getNumber());
            }
            int i = 0;
            for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
                codedOutputStream.b(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.upperBound_.get(i2));
            }
            if (bpJ().size() > 0) {
                codedOutputStream.C(50);
                codedOutputStream.C(this.upperBoundIdMemoizedSerializedSize);
            }
            while (i < this.upperBoundId_.size()) {
                codedOutputStream.s(((Integer) this.upperBoundId_.get(i)).intValue());
                i++;
            }
            buR.b(1000, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.bh(1, this.id_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.d(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.n(4, this.variance_.getNumber());
            }
            int i3 = i;
            for (i = 0; i < this.upperBound_.size(); i++) {
                i3 += CodedOutputStream.d(5, (kotlin.reflect.jvm.internal.impl.protobuf.n) this.upperBound_.get(i));
            }
            i = 0;
            while (i2 < this.upperBoundId_.size()) {
                i += CodedOutputStream.w(((Integer) this.upperBoundId_.get(i2)).intValue());
                i2++;
            }
            i3 += i;
            if (!bpJ().isEmpty()) {
                i3 = (i3 + 1) + CodedOutputStream.w(i);
            }
            this.upperBoundIdMemoizedSerializedSize = i;
            i3 = (i3 + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static a bpK() {
            return a.bpN();
        }

        /* renamed from: bpL */
        public a bjg() {
            return bpK();
        }

        public static a a(TypeParameter typeParameter) {
            return bpK().a(typeParameter);
        }

        /* renamed from: bpM */
        public a bjf() {
            return a(this);
        }
    }

    public static final class ValueParameter extends ExtendableMessage<ValueParameter> implements q {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<ValueParameter>() {
            /* renamed from: R */
            public ValueParameter b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                return new ValueParameter(eVar, fVar);
            }
        };
        private static final ValueParameter eKZ = new ValueParameter(true);
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<ValueParameter, a> implements q {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_ = Type.bok();
            private int varargElementTypeId_;
            private Type varargElementType_ = Type.bok();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a bqs() {
                return new a();
            }

            /* renamed from: bqt */
            public a clone() {
                return bqs().a(bqv());
            }

            /* renamed from: bqk */
            public ValueParameter bju() {
                return ValueParameter.bqj();
            }

            /* renamed from: bqu */
            public ValueParameter bjx() {
                Object bqv = bqv();
                if (bqv.isInitialized()) {
                    return bqv;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(bqv);
            }

            public ValueParameter bqv() {
                ValueParameter valueParameter = new ValueParameter((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                valueParameter.flags_ = this.flags_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                valueParameter.name_ = this.name_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                valueParameter.type_ = this.type_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                valueParameter.typeId_ = this.typeId_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                valueParameter.varargElementType_ = this.varargElementType_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.varargElementTypeId_;
                valueParameter.bitField0_ = i2;
                return valueParameter;
            }

            /* renamed from: d */
            public a a(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.bqj()) {
                    return this;
                }
                if (valueParameter.bjR()) {
                    kR(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    kS(valueParameter.blW());
                }
                if (valueParameter.hasType()) {
                    p(valueParameter.boR());
                }
                if (valueParameter.boS()) {
                    kT(valueParameter.getTypeId());
                }
                if (valueParameter.bql()) {
                    q(valueParameter.bqm());
                }
                if (valueParameter.bqn()) {
                    kU(valueParameter.bqo());
                }
                a((ExtendableMessage) valueParameter);
                e(buN().a(valueParameter.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {
                    return false;
                }
                if (hasType() && !boR().isInitialized()) {
                    return false;
                }
                if ((!bql() || bqm().isInitialized()) && buQ()) {
                    return true;
                }
                return false;
            }

            /* renamed from: S */
            public a f(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                ValueParameter valueParameter;
                Throwable th;
                ValueParameter valueParameter2 = null;
                try {
                    ValueParameter valueParameter3 = (ValueParameter) ValueParameter.eKF.b(eVar, fVar);
                    if (valueParameter3 != null) {
                        a(valueParameter3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    valueParameter = (ValueParameter) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    valueParameter2 = valueParameter;
                }
                if (valueParameter2 != null) {
                    a(valueParameter2);
                }
                throw th;
            }

            public a kR(int i) {
                this.bitField0_ |= 1;
                this.flags_ = i;
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 2) == 2;
            }

            public a kS(int i) {
                this.bitField0_ |= 2;
                this.name_ = i;
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & 4) == 4;
            }

            public Type boR() {
                return this.type_;
            }

            public a p(Type type) {
                if ((this.bitField0_ & 4) != 4 || this.type_ == Type.bok()) {
                    this.type_ = type;
                } else {
                    this.type_ = Type.f(this.type_).a(type).bpe();
                }
                this.bitField0_ |= 4;
                return this;
            }

            public a kT(int i) {
                this.bitField0_ |= 8;
                this.typeId_ = i;
                return this;
            }

            public boolean bql() {
                return (this.bitField0_ & 16) == 16;
            }

            public Type bqm() {
                return this.varargElementType_;
            }

            public a q(Type type) {
                if ((this.bitField0_ & 16) != 16 || this.varargElementType_ == Type.bok()) {
                    this.varargElementType_ = type;
                } else {
                    this.varargElementType_ = Type.f(this.varargElementType_).a(type).bpe();
                }
                this.bitField0_ |= 16;
                return this;
            }

            public a kU(int i) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = i;
                return this;
            }
        }

        private ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b<ValueParameter, ?> bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.buN();
        }

        private ValueParameter(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.eNx;
        }

        public static ValueParameter bqj() {
            return eKZ;
        }

        /* renamed from: bqk */
        public ValueParameter bjh() {
            return eKZ;
        }

        private ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
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
                            this.flags_ = eVar.buh();
                        } else if (bue != 16) {
                            b bVar = null;
                            if (bue == 26) {
                                if ((this.bitField0_ & 4) == 4) {
                                    bVar = this.type_.bjf();
                                }
                                this.type_ = (Type) eVar.a(Type.eKF, fVar);
                                if (bVar != null) {
                                    bVar.a(this.type_);
                                    this.type_ = bVar.bpe();
                                }
                                this.bitField0_ |= 4;
                            } else if (bue == 34) {
                                if ((this.bitField0_ & 16) == 16) {
                                    bVar = this.varargElementType_.bjf();
                                }
                                this.varargElementType_ = (Type) eVar.a(Type.eKF, fVar);
                                if (bVar != null) {
                                    bVar.a(this.varargElementType_);
                                    this.varargElementType_ = bVar.bpe();
                                }
                                this.bitField0_ |= 16;
                            } else if (bue == 40) {
                                this.bitField0_ |= 8;
                                this.typeId_ = eVar.buh();
                            } else if (bue == 48) {
                                this.bitField0_ |= 32;
                                this.varargElementTypeId_ = eVar.buh();
                            } else if (a(eVar, b, fVar, bue)) {
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.name_ = eVar.buh();
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
            eKZ.bja();
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> biX() {
            return eKF;
        }

        public boolean bjR() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getFlags() {
            return this.flags_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public int blW() {
            return this.name_;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public Type boR() {
            return this.type_;
        }

        public boolean boS() {
            return (this.bitField0_ & 8) == 8;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean bql() {
            return (this.bitField0_ & 16) == 16;
        }

        public Type bqm() {
            return this.varargElementType_;
        }

        public boolean bqn() {
            return (this.bitField0_ & 32) == 32;
        }

        public int bqo() {
            return this.varargElementTypeId_;
        }

        private void bja() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.bok();
            this.typeId_ = 0;
            this.varargElementType_ = Type.bok();
            this.varargElementTypeId_ = 0;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasType() && !boR().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (bql() && !bqm().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (buQ()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            } else {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }

        public void a(CodedOutputStream codedOutputStream) {
            bjb();
            a buR = buR();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.bg(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.bg(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.b(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.b(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.bg(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.bg(6, this.varargElementTypeId_);
            }
            buR.b(200, codedOutputStream);
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.bh(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.bh(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.d(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.d(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.bh(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.bh(6, this.varargElementTypeId_);
            }
            i = (i + buS()) + this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a bqp() {
            return a.bqs();
        }

        /* renamed from: bqq */
        public a bjg() {
            return bqp();
        }

        public static a b(ValueParameter valueParameter) {
            return bqp().a(valueParameter);
        }

        /* renamed from: bqr */
        public a bjf() {
            return b(this);
        }
    }
}
