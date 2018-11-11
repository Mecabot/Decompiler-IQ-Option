package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.k;
import kotlin.reflect.jvm.internal.impl.protobuf.l;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

public final class JvmModuleProtoBuf {

    public interface a extends o {
    }

    public interface b extends o {
    }

    public static final class Module extends GeneratedMessageLite implements a {
        public static p<Module> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<Module>() {
            /* renamed from: X */
            public Module b(e eVar, f fVar) {
                return new Module(eVar, fVar);
            }
        };
        private static final Module eMg = new Module(true);
        private List<Annotation> annotation_;
        private int bitField0_;
        private l jvmPackageName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<PackageParts> metadataParts_;
        private List<PackageParts> packageParts_;
        private QualifiedNameTable qualifiedNameTable_;
        private StringTable stringTable_;
        private final d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<Module, a> implements a {
            private List<Annotation> annotation_ = Collections.emptyList();
            private int bitField0_;
            private l jvmPackageName_ = k.eOo;
            private List<PackageParts> metadataParts_ = Collections.emptyList();
            private List<PackageParts> packageParts_ = Collections.emptyList();
            private QualifiedNameTable qualifiedNameTable_ = QualifiedNameTable.bnx();
            private StringTable stringTable_ = StringTable.bnY();

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a brx() {
                return new a();
            }

            /* renamed from: bry */
            public a clone() {
                return brx().a(brA());
            }

            /* renamed from: brk */
            public Module bju() {
                return Module.brj();
            }

            /* renamed from: brz */
            public Module bjx() {
                Object brA = brA();
                if (brA.isInitialized()) {
                    return brA;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(brA);
            }

            public Module brA() {
                Module module = new Module((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = this.bitField0_;
                int i2 = 1;
                if ((this.bitField0_ & 1) == 1) {
                    this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                    this.bitField0_ &= -2;
                }
                module.packageParts_ = this.packageParts_;
                if ((this.bitField0_ & 2) == 2) {
                    this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                    this.bitField0_ &= -3;
                }
                module.metadataParts_ = this.metadataParts_;
                if ((this.bitField0_ & 4) == 4) {
                    this.jvmPackageName_ = this.jvmPackageName_.bvi();
                    this.bitField0_ &= -5;
                }
                module.jvmPackageName_ = this.jvmPackageName_;
                if ((i & 8) != 8) {
                    i2 = 0;
                }
                module.stringTable_ = this.stringTable_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                module.qualifiedNameTable_ = this.qualifiedNameTable_;
                if ((this.bitField0_ & 32) == 32) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    this.bitField0_ &= -33;
                }
                module.annotation_ = this.annotation_;
                module.bitField0_ = i2;
                return module;
            }

            /* renamed from: g */
            public a a(Module module) {
                if (module == Module.brj()) {
                    return this;
                }
                if (!module.packageParts_.isEmpty()) {
                    if (this.packageParts_.isEmpty()) {
                        this.packageParts_ = module.packageParts_;
                        this.bitField0_ &= -2;
                    } else {
                        brB();
                        this.packageParts_.addAll(module.packageParts_);
                    }
                }
                if (!module.metadataParts_.isEmpty()) {
                    if (this.metadataParts_.isEmpty()) {
                        this.metadataParts_ = module.metadataParts_;
                        this.bitField0_ &= -3;
                    } else {
                        brC();
                        this.metadataParts_.addAll(module.metadataParts_);
                    }
                }
                if (!module.jvmPackageName_.isEmpty()) {
                    if (this.jvmPackageName_.isEmpty()) {
                        this.jvmPackageName_ = module.jvmPackageName_;
                        this.bitField0_ &= -5;
                    } else {
                        brD();
                        this.jvmPackageName_.addAll(module.jvmPackageName_);
                    }
                }
                if (module.brq()) {
                    e(module.brr());
                }
                if (module.brs()) {
                    e(module.brt());
                }
                if (!module.annotation_.isEmpty()) {
                    if (this.annotation_.isEmpty()) {
                        this.annotation_ = module.annotation_;
                        this.bitField0_ &= -33;
                    } else {
                        bpz();
                        this.annotation_.addAll(module.annotation_);
                    }
                }
                e(buN().a(module.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                int i;
                for (i = 0; i < brm(); i++) {
                    if (!lj(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < bro(); i++) {
                    if (!lk(i).isInitialized()) {
                        return false;
                    }
                }
                if (brs() && !brt().isInitialized()) {
                    return false;
                }
                for (i = 0; i < bpr(); i++) {
                    if (!kG(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: Y */
            public a f(e eVar, f fVar) {
                Module module;
                Throwable th;
                Module module2 = null;
                try {
                    Module module3 = (Module) Module.eKF.b(eVar, fVar);
                    if (module3 != null) {
                        a(module3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    module = (Module) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    module2 = module;
                }
                if (module2 != null) {
                    a(module2);
                }
                throw th;
            }

            private void brB() {
                if ((this.bitField0_ & 1) != 1) {
                    this.packageParts_ = new ArrayList(this.packageParts_);
                    this.bitField0_ |= 1;
                }
            }

            public int brm() {
                return this.packageParts_.size();
            }

            public PackageParts lj(int i) {
                return (PackageParts) this.packageParts_.get(i);
            }

            private void brC() {
                if ((this.bitField0_ & 2) != 2) {
                    this.metadataParts_ = new ArrayList(this.metadataParts_);
                    this.bitField0_ |= 2;
                }
            }

            public int bro() {
                return this.metadataParts_.size();
            }

            public PackageParts lk(int i) {
                return (PackageParts) this.metadataParts_.get(i);
            }

            private void brD() {
                if ((this.bitField0_ & 4) != 4) {
                    this.jvmPackageName_ = new k(this.jvmPackageName_);
                    this.bitField0_ |= 4;
                }
            }

            public a e(StringTable stringTable) {
                if ((this.bitField0_ & 8) != 8 || this.stringTable_ == StringTable.bnY()) {
                    this.stringTable_ = stringTable;
                } else {
                    this.stringTable_ = StringTable.a(this.stringTable_).a(stringTable).boh();
                }
                this.bitField0_ |= 8;
                return this;
            }

            public boolean brs() {
                return (this.bitField0_ & 16) == 16;
            }

            public QualifiedNameTable brt() {
                return this.qualifiedNameTable_;
            }

            public a e(QualifiedNameTable qualifiedNameTable) {
                if ((this.bitField0_ & 16) != 16 || this.qualifiedNameTable_ == QualifiedNameTable.bnx()) {
                    this.qualifiedNameTable_ = qualifiedNameTable;
                } else {
                    this.qualifiedNameTable_ = QualifiedNameTable.a(this.qualifiedNameTable_).a(qualifiedNameTable).bnG();
                }
                this.bitField0_ |= 16;
                return this;
            }

            private void bpz() {
                if ((this.bitField0_ & 32) != 32) {
                    this.annotation_ = new ArrayList(this.annotation_);
                    this.bitField0_ |= 32;
                }
            }

            public int bpr() {
                return this.annotation_.size();
            }

            public Annotation kG(int i) {
                return (Annotation) this.annotation_.get(i);
            }
        }

        private Module(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private Module(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.eNx;
        }

        public static Module brj() {
            return eMg;
        }

        /* renamed from: brk */
        public Module bjh() {
            return eMg;
        }

        private Module(e eVar, f fVar) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            int i = 0;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        if (bue == 10) {
                            if ((i & 1) != 1) {
                                this.packageParts_ = new ArrayList();
                                i |= 1;
                            }
                            this.packageParts_.add(eVar.a(PackageParts.eKF, fVar));
                        } else if (bue == 18) {
                            if ((i & 2) != 2) {
                                this.metadataParts_ = new ArrayList();
                                i |= 2;
                            }
                            this.metadataParts_.add(eVar.a(PackageParts.eKF, fVar));
                        } else if (bue != 26) {
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.a aVar = null;
                            if (bue == 34) {
                                if ((this.bitField0_ & 1) == 1) {
                                    aVar = this.stringTable_.bjf();
                                }
                                this.stringTable_ = (StringTable) eVar.a(StringTable.eKF, fVar);
                                if (aVar != null) {
                                    aVar.a(this.stringTable_);
                                    this.stringTable_ = aVar.boh();
                                }
                                this.bitField0_ |= 1;
                            } else if (bue == 42) {
                                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.a bnC;
                                if ((this.bitField0_ & 2) == 2) {
                                    bnC = this.qualifiedNameTable_.bjf();
                                }
                                this.qualifiedNameTable_ = (QualifiedNameTable) eVar.a(QualifiedNameTable.eKF, fVar);
                                if (bnC != null) {
                                    bnC.a(this.qualifiedNameTable_);
                                    this.qualifiedNameTable_ = bnC.bnG();
                                }
                                this.bitField0_ |= 2;
                            } else if (bue == 50) {
                                if ((i & 32) != 32) {
                                    this.annotation_ = new ArrayList();
                                    i |= 32;
                                }
                                this.annotation_.add(eVar.a(Annotation.eKF, fVar));
                            } else if (a(eVar, b, fVar, bue)) {
                            }
                        } else {
                            d bum = eVar.bum();
                            if ((i & 4) != 4) {
                                this.jvmPackageName_ = new k();
                                i |= 4;
                            }
                            this.jvmPackageName_.f(bum);
                        }
                    }
                    obj = 1;
                } catch (InvalidProtocolBufferException e) {
                    throw e.g(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).g(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                    }
                    if ((i & 2) == 2) {
                        this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                    }
                    if ((i & 4) == 4) {
                        this.jvmPackageName_ = this.jvmPackageName_.bvi();
                    }
                    if ((i & 32) == 32) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
                this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
            }
            if ((i & 2) == 2) {
                this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
            }
            if ((i & 4) == 4) {
                this.jvmPackageName_ = this.jvmPackageName_.bvi();
            }
            if ((i & 32) == 32) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
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
            eMg.bja();
        }

        public p<Module> biX() {
            return eKF;
        }

        public List<PackageParts> brl() {
            return this.packageParts_;
        }

        public int brm() {
            return this.packageParts_.size();
        }

        public PackageParts lj(int i) {
            return (PackageParts) this.packageParts_.get(i);
        }

        public List<PackageParts> brn() {
            return this.metadataParts_;
        }

        public int bro() {
            return this.metadataParts_.size();
        }

        public PackageParts lk(int i) {
            return (PackageParts) this.metadataParts_.get(i);
        }

        public q brp() {
            return this.jvmPackageName_;
        }

        public boolean brq() {
            return (this.bitField0_ & 1) == 1;
        }

        public StringTable brr() {
            return this.stringTable_;
        }

        public boolean brs() {
            return (this.bitField0_ & 2) == 2;
        }

        public QualifiedNameTable brt() {
            return this.qualifiedNameTable_;
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

        private void bja() {
            this.packageParts_ = Collections.emptyList();
            this.metadataParts_ = Collections.emptyList();
            this.jvmPackageName_ = k.eOo;
            this.stringTable_ = StringTable.bnY();
            this.qualifiedNameTable_ = QualifiedNameTable.bnx();
            this.annotation_ = Collections.emptyList();
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
            while (i < brm()) {
                if (lj(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < bro()) {
                if (lk(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!brs() || brt().isInitialized()) {
                i = 0;
                while (i < bpr()) {
                    if (kG(i).isInitialized()) {
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
            int i;
            bjb();
            int i2 = 0;
            for (i = 0; i < this.packageParts_.size(); i++) {
                codedOutputStream.b(1, (n) this.packageParts_.get(i));
            }
            for (i = 0; i < this.metadataParts_.size(); i++) {
                codedOutputStream.b(2, (n) this.metadataParts_.get(i));
            }
            for (i = 0; i < this.jvmPackageName_.size(); i++) {
                codedOutputStream.a(3, this.jvmPackageName_.lJ(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.b(4, this.stringTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.b(5, this.qualifiedNameTable_);
            }
            while (i2 < this.annotation_.size()) {
                codedOutputStream.b(6, (n) this.annotation_.get(i2));
                i2++;
            }
            codedOutputStream.d(this.unknownFields);
        }

        public int bjb() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2;
            i = 0;
            int i3 = 0;
            for (i2 = 0; i2 < this.packageParts_.size(); i2++) {
                i3 += CodedOutputStream.d(1, (n) this.packageParts_.get(i2));
            }
            for (i2 = 0; i2 < this.metadataParts_.size(); i2++) {
                i3 += CodedOutputStream.d(2, (n) this.metadataParts_.get(i2));
            }
            int i4 = 0;
            for (i2 = 0; i2 < this.jvmPackageName_.size(); i2++) {
                i4 += CodedOutputStream.c(this.jvmPackageName_.lJ(i2));
            }
            i3 = (i3 + i4) + (brp().size() * 1);
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.d(4, this.stringTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.d(5, this.qualifiedNameTable_);
            }
            while (i < this.annotation_.size()) {
                i3 += CodedOutputStream.d(6, (n) this.annotation_.get(i));
                i++;
            }
            i3 += this.unknownFields.size();
            this.memoizedSerializedSize = i3;
            return i3;
        }

        public static Module j(InputStream inputStream) {
            return (Module) eKF.l(inputStream);
        }

        public static a bru() {
            return a.brx();
        }

        /* renamed from: brv */
        public a bjg() {
            return bru();
        }

        public static a a(Module module) {
            return bru().a(module);
        }

        /* renamed from: brw */
        public a bjf() {
            return a(this);
        }
    }

    public static final class PackageParts extends GeneratedMessageLite implements b {
        public static p<PackageParts> eKF = new kotlin.reflect.jvm.internal.impl.protobuf.b<PackageParts>() {
            /* renamed from: Z */
            public PackageParts b(e eVar, f fVar) {
                return new PackageParts(eVar, fVar);
            }
        };
        private static final PackageParts eMh = new PackageParts(true);
        private int bitField0_;
        private int classWithJvmPackageNamePackageIdMemoizedSerializedSize;
        private List<Integer> classWithJvmPackageNamePackageId_;
        private l classWithJvmPackageNameShortName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multifileFacadeShortNameIdMemoizedSerializedSize;
        private List<Integer> multifileFacadeShortNameId_;
        private l multifileFacadeShortName_;
        private Object packageFqName_;
        private l shortClassName_;
        private final d unknownFields;

        public static final class a extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a<PackageParts, a> implements b {
            private int bitField0_;
            private List<Integer> classWithJvmPackageNamePackageId_ = Collections.emptyList();
            private l classWithJvmPackageNameShortName_ = k.eOo;
            private List<Integer> multifileFacadeShortNameId_ = Collections.emptyList();
            private l multifileFacadeShortName_ = k.eOo;
            private Object packageFqName_ = "";
            private l shortClassName_ = k.eOo;

            private void bjp() {
            }

            private a() {
                bjp();
            }

            private static a brS() {
                return new a();
            }

            /* renamed from: brT */
            public a clone() {
                return brS().a(brV());
            }

            /* renamed from: brG */
            public PackageParts bju() {
                return PackageParts.brF();
            }

            /* renamed from: brU */
            public PackageParts bjx() {
                Object brV = brV();
                if (brV.isInitialized()) {
                    return brV;
                }
                throw kotlin.reflect.jvm.internal.impl.protobuf.a.a.a(brV);
            }

            public PackageParts brV() {
                PackageParts packageParts = new PackageParts((kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a) this, null);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                packageParts.packageFqName_ = this.packageFqName_;
                if ((this.bitField0_ & 2) == 2) {
                    this.shortClassName_ = this.shortClassName_.bvi();
                    this.bitField0_ &= -3;
                }
                packageParts.shortClassName_ = this.shortClassName_;
                if ((this.bitField0_ & 4) == 4) {
                    this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                    this.bitField0_ &= -5;
                }
                packageParts.multifileFacadeShortNameId_ = this.multifileFacadeShortNameId_;
                if ((this.bitField0_ & 8) == 8) {
                    this.multifileFacadeShortName_ = this.multifileFacadeShortName_.bvi();
                    this.bitField0_ &= -9;
                }
                packageParts.multifileFacadeShortName_ = this.multifileFacadeShortName_;
                if ((this.bitField0_ & 16) == 16) {
                    this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.bvi();
                    this.bitField0_ &= -17;
                }
                packageParts.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_;
                if ((this.bitField0_ & 32) == 32) {
                    this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
                    this.bitField0_ &= -33;
                }
                packageParts.classWithJvmPackageNamePackageId_ = this.classWithJvmPackageNamePackageId_;
                packageParts.bitField0_ = i;
                return packageParts;
            }

            /* renamed from: i */
            public a a(PackageParts packageParts) {
                if (packageParts == PackageParts.brF()) {
                    return this;
                }
                if (packageParts.brH()) {
                    this.bitField0_ |= 1;
                    this.packageFqName_ = packageParts.packageFqName_;
                }
                if (!packageParts.shortClassName_.isEmpty()) {
                    if (this.shortClassName_.isEmpty()) {
                        this.shortClassName_ = packageParts.shortClassName_;
                        this.bitField0_ &= -3;
                    } else {
                        brW();
                        this.shortClassName_.addAll(packageParts.shortClassName_);
                    }
                }
                if (!packageParts.multifileFacadeShortNameId_.isEmpty()) {
                    if (this.multifileFacadeShortNameId_.isEmpty()) {
                        this.multifileFacadeShortNameId_ = packageParts.multifileFacadeShortNameId_;
                        this.bitField0_ &= -5;
                    } else {
                        brX();
                        this.multifileFacadeShortNameId_.addAll(packageParts.multifileFacadeShortNameId_);
                    }
                }
                if (!packageParts.multifileFacadeShortName_.isEmpty()) {
                    if (this.multifileFacadeShortName_.isEmpty()) {
                        this.multifileFacadeShortName_ = packageParts.multifileFacadeShortName_;
                        this.bitField0_ &= -9;
                    } else {
                        brY();
                        this.multifileFacadeShortName_.addAll(packageParts.multifileFacadeShortName_);
                    }
                }
                if (!packageParts.classWithJvmPackageNameShortName_.isEmpty()) {
                    if (this.classWithJvmPackageNameShortName_.isEmpty()) {
                        this.classWithJvmPackageNameShortName_ = packageParts.classWithJvmPackageNameShortName_;
                        this.bitField0_ &= -17;
                    } else {
                        brZ();
                        this.classWithJvmPackageNameShortName_.addAll(packageParts.classWithJvmPackageNameShortName_);
                    }
                }
                if (!packageParts.classWithJvmPackageNamePackageId_.isEmpty()) {
                    if (this.classWithJvmPackageNamePackageId_.isEmpty()) {
                        this.classWithJvmPackageNamePackageId_ = packageParts.classWithJvmPackageNamePackageId_;
                        this.bitField0_ &= -33;
                    } else {
                        bsa();
                        this.classWithJvmPackageNamePackageId_.addAll(packageParts.classWithJvmPackageNamePackageId_);
                    }
                }
                e(buN().a(packageParts.unknownFields));
                return this;
            }

            public final boolean isInitialized() {
                return brH();
            }

            /* renamed from: aa */
            public a f(e eVar, f fVar) {
                PackageParts packageParts;
                Throwable th;
                PackageParts packageParts2 = null;
                try {
                    PackageParts packageParts3 = (PackageParts) PackageParts.eKF.b(eVar, fVar);
                    if (packageParts3 != null) {
                        a(packageParts3);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    packageParts = (PackageParts) e.buW();
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    packageParts2 = packageParts;
                }
                if (packageParts2 != null) {
                    a(packageParts2);
                }
                throw th;
            }

            public boolean brH() {
                return (this.bitField0_ & 1) == 1;
            }

            private void brW() {
                if ((this.bitField0_ & 2) != 2) {
                    this.shortClassName_ = new k(this.shortClassName_);
                    this.bitField0_ |= 2;
                }
            }

            private void brX() {
                if ((this.bitField0_ & 4) != 4) {
                    this.multifileFacadeShortNameId_ = new ArrayList(this.multifileFacadeShortNameId_);
                    this.bitField0_ |= 4;
                }
            }

            private void brY() {
                if ((this.bitField0_ & 8) != 8) {
                    this.multifileFacadeShortName_ = new k(this.multifileFacadeShortName_);
                    this.bitField0_ |= 8;
                }
            }

            private void brZ() {
                if ((this.bitField0_ & 16) != 16) {
                    this.classWithJvmPackageNameShortName_ = new k(this.classWithJvmPackageNameShortName_);
                    this.bitField0_ |= 16;
                }
            }

            private void bsa() {
                if ((this.bitField0_ & 32) != 32) {
                    this.classWithJvmPackageNamePackageId_ = new ArrayList(this.classWithJvmPackageNamePackageId_);
                    this.bitField0_ |= 32;
                }
            }
        }

        private PackageParts(kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.a aVar) {
            super(aVar);
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = aVar.buN();
        }

        private PackageParts(boolean z) {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = d.eNx;
        }

        public static PackageParts brF() {
            return eMh;
        }

        /* renamed from: brG */
        public PackageParts bjh() {
            return eMh;
        }

        private PackageParts(e eVar, f fVar) {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            bja();
            OutputStream btY = d.btY();
            CodedOutputStream b = CodedOutputStream.b(btY, 1);
            Object obj = null;
            int i = 0;
            while (obj == null) {
                try {
                    int bue = eVar.bue();
                    if (bue != 0) {
                        d bum;
                        if (bue == 10) {
                            bum = eVar.bum();
                            this.bitField0_ |= 1;
                            this.packageFqName_ = bum;
                        } else if (bue == 18) {
                            bum = eVar.bum();
                            if ((i & 2) != 2) {
                                this.shortClassName_ = new k();
                                i |= 2;
                            }
                            this.shortClassName_.f(bum);
                        } else if (bue == 24) {
                            if ((i & 4) != 4) {
                                this.multifileFacadeShortNameId_ = new ArrayList();
                                i |= 4;
                            }
                            this.multifileFacadeShortNameId_.add(Integer.valueOf(eVar.buh()));
                        } else if (bue == 26) {
                            bue = eVar.lv(eVar.but());
                            if ((i & 4) != 4 && eVar.buz() > 0) {
                                this.multifileFacadeShortNameId_ = new ArrayList();
                                i |= 4;
                            }
                            while (eVar.buz() > 0) {
                                this.multifileFacadeShortNameId_.add(Integer.valueOf(eVar.buh()));
                            }
                            eVar.lw(bue);
                        } else if (bue == 34) {
                            bum = eVar.bum();
                            if ((i & 8) != 8) {
                                this.multifileFacadeShortName_ = new k();
                                i |= 8;
                            }
                            this.multifileFacadeShortName_.f(bum);
                        } else if (bue == 42) {
                            bum = eVar.bum();
                            if ((i & 16) != 16) {
                                this.classWithJvmPackageNameShortName_ = new k();
                                i |= 16;
                            }
                            this.classWithJvmPackageNameShortName_.f(bum);
                        } else if (bue == 48) {
                            if ((i & 32) != 32) {
                                this.classWithJvmPackageNamePackageId_ = new ArrayList();
                                i |= 32;
                            }
                            this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(eVar.buh()));
                        } else if (bue == 50) {
                            bue = eVar.lv(eVar.but());
                            if ((i & 32) != 32 && eVar.buz() > 0) {
                                this.classWithJvmPackageNamePackageId_ = new ArrayList();
                                i |= 32;
                            }
                            while (eVar.buz() > 0) {
                                this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(eVar.buh()));
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
                        this.shortClassName_ = this.shortClassName_.bvi();
                    }
                    if ((i & 4) == 4) {
                        this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                    }
                    if ((i & 8) == 8) {
                        this.multifileFacadeShortName_ = this.multifileFacadeShortName_.bvi();
                    }
                    if ((i & 16) == 16) {
                        this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.bvi();
                    }
                    if ((i & 32) == 32) {
                        this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
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
                this.shortClassName_ = this.shortClassName_.bvi();
            }
            if ((i & 4) == 4) {
                this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
            }
            if ((i & 8) == 8) {
                this.multifileFacadeShortName_ = this.multifileFacadeShortName_.bvi();
            }
            if ((i & 16) == 16) {
                this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.bvi();
            }
            if ((i & 32) == 32) {
                this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
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
            eMh.bja();
        }

        public p<PackageParts> biX() {
            return eKF;
        }

        public boolean brH() {
            return (this.bitField0_ & 1) == 1;
        }

        public String brI() {
            Object obj = this.packageFqName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            d dVar = (d) obj;
            String btV = dVar.btV();
            if (dVar.btW()) {
                this.packageFqName_ = btV;
            }
            return btV;
        }

        public d brJ() {
            Object obj = this.packageFqName_;
            if (!(obj instanceof String)) {
                return (d) obj;
            }
            d mI = d.mI((String) obj);
            this.packageFqName_ = mI;
            return mI;
        }

        public q brK() {
            return this.shortClassName_;
        }

        public List<Integer> brL() {
            return this.multifileFacadeShortNameId_;
        }

        public q brM() {
            return this.multifileFacadeShortName_;
        }

        public q brN() {
            return this.classWithJvmPackageNameShortName_;
        }

        public List<Integer> brO() {
            return this.classWithJvmPackageNamePackageId_;
        }

        private void bja() {
            this.packageFqName_ = "";
            this.shortClassName_ = k.eOo;
            this.multifileFacadeShortNameId_ = Collections.emptyList();
            this.multifileFacadeShortName_ = k.eOo;
            this.classWithJvmPackageNameShortName_ = k.eOo;
            this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == (byte) 1) {
                return true;
            }
            if (b == (byte) 0) {
                return false;
            }
            if (brH()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        public void a(CodedOutputStream codedOutputStream) {
            int i;
            bjb();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a(1, brJ());
            }
            int i2 = 0;
            for (i = 0; i < this.shortClassName_.size(); i++) {
                codedOutputStream.a(2, this.shortClassName_.lJ(i));
            }
            if (brL().size() > 0) {
                codedOutputStream.C(26);
                codedOutputStream.C(this.multifileFacadeShortNameIdMemoizedSerializedSize);
            }
            for (i = 0; i < this.multifileFacadeShortNameId_.size(); i++) {
                codedOutputStream.s(((Integer) this.multifileFacadeShortNameId_.get(i)).intValue());
            }
            for (i = 0; i < this.multifileFacadeShortName_.size(); i++) {
                codedOutputStream.a(4, this.multifileFacadeShortName_.lJ(i));
            }
            for (i = 0; i < this.classWithJvmPackageNameShortName_.size(); i++) {
                codedOutputStream.a(5, this.classWithJvmPackageNameShortName_.lJ(i));
            }
            if (brO().size() > 0) {
                codedOutputStream.C(50);
                codedOutputStream.C(this.classWithJvmPackageNamePackageIdMemoizedSerializedSize);
            }
            while (i2 < this.classWithJvmPackageNamePackageId_.size()) {
                codedOutputStream.s(((Integer) this.classWithJvmPackageNamePackageId_.get(i2)).intValue());
                i2++;
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
            i = (this.bitField0_ & 1) == 1 ? CodedOutputStream.b(1, brJ()) + 0 : 0;
            int i4 = 0;
            for (i2 = 0; i2 < this.shortClassName_.size(); i2++) {
                i4 += CodedOutputStream.c(this.shortClassName_.lJ(i2));
            }
            i = (i + i4) + (brK().size() * 1);
            i4 = 0;
            for (i2 = 0; i2 < this.multifileFacadeShortNameId_.size(); i2++) {
                i4 += CodedOutputStream.w(((Integer) this.multifileFacadeShortNameId_.get(i2)).intValue());
            }
            i += i4;
            if (!brL().isEmpty()) {
                i = (i + 1) + CodedOutputStream.w(i4);
            }
            this.multifileFacadeShortNameIdMemoizedSerializedSize = i4;
            i4 = 0;
            for (i2 = 0; i2 < this.multifileFacadeShortName_.size(); i2++) {
                i4 += CodedOutputStream.c(this.multifileFacadeShortName_.lJ(i2));
            }
            i = (i + i4) + (brM().size() * 1);
            i4 = 0;
            for (i2 = 0; i2 < this.classWithJvmPackageNameShortName_.size(); i2++) {
                i4 += CodedOutputStream.c(this.classWithJvmPackageNameShortName_.lJ(i2));
            }
            i = (i + i4) + (brN().size() * 1);
            int i5 = 0;
            while (i3 < this.classWithJvmPackageNamePackageId_.size()) {
                i5 += CodedOutputStream.w(((Integer) this.classWithJvmPackageNamePackageId_.get(i3)).intValue());
                i3++;
            }
            i += i5;
            if (!brO().isEmpty()) {
                i = (i + 1) + CodedOutputStream.w(i5);
            }
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = i5;
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public static a brP() {
            return a.brS();
        }

        /* renamed from: brQ */
        public a bjg() {
            return brP();
        }

        public static a a(PackageParts packageParts) {
            return brP().a(packageParts);
        }

        /* renamed from: brR */
        public a bjf() {
            return a(this);
        }
    }
}
