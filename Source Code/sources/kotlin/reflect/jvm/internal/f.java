package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.e.e;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.load.java.l;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0004\t\n\u000b\f¨\u0006\r"}, aXE = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflect-api"})
/* compiled from: RuntimeTypeMapper.kt */
public abstract class f {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflect-api"})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class a extends f {
        private final Field field;

        public a(Field field) {
            h.e(field, "field");
            super();
            this.field = field;
        }

        public final Field getField() {
            return this.field;
        }

        public String asString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l.mm(this.field.getName()));
            stringBuilder.append("()");
            Class type = this.field.getType();
            h.d(type, "field.type");
            stringBuilder.append(kotlin.reflect.jvm.internal.structure.b.T(type));
            return stringBuilder.toString();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflect-api"})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class b extends f {
        private final Method evk;
        private final Method evl;

        public b(Method method, Method method2) {
            h.e(method, "getterMethod");
            super();
            this.evk = method;
            this.evl = method2;
        }

        public final Method aYC() {
            return this.evk;
        }

        public final Method aYD() {
            return this.evl;
        }

        public String asString() {
            return ad.getSignature(this.evk);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, aXE = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflect-api"})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class c extends f {
        private final ad evm;
        private final Property evn;
        private final JvmPropertySignature evo;
        private final kotlin.reflect.jvm.internal.impl.metadata.a.c evp;
        private final kotlin.reflect.jvm.internal.impl.metadata.a.h evq;
        private final String string;

        public final ad aYF() {
            return this.evm;
        }

        public final Property aYG() {
            return this.evn;
        }

        public final JvmPropertySignature aYH() {
            return this.evo;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.a.c aYI() {
            return this.evp;
        }

        public final kotlin.reflect.jvm.internal.impl.metadata.a.h aYJ() {
            return this.evq;
        }

        public c(ad adVar, Property property, JvmPropertySignature jvmPropertySignature, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar) {
            String stringBuilder;
            h.e(adVar, "descriptor");
            h.e(property, "proto");
            h.e(jvmPropertySignature, "signature");
            h.e(cVar, "nameResolver");
            h.e(hVar, "typeTable");
            super();
            this.evm = adVar;
            this.evn = property;
            this.evo = jvmPropertySignature;
            this.evp = cVar;
            this.evq = hVar;
            if (this.evo.bsE()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                kotlin.reflect.jvm.internal.impl.metadata.a.c cVar2 = this.evp;
                JvmMethodSignature bsF = this.evo.bsF();
                h.d(bsF, "signature.getter");
                stringBuilder2.append(cVar2.getString(bsF.blW()));
                cVar2 = this.evp;
                bsF = this.evo.bsF();
                h.d(bsF, "signature.getter");
                stringBuilder2.append(cVar2.getString(bsF.bsf()));
                stringBuilder = stringBuilder2.toString();
            } else {
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a a = j.eMR.a(this.evn, this.evp, this.evq);
                if (a != null) {
                    String component1 = a.component1();
                    stringBuilder = a.component2();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(l.mm(component1));
                    stringBuilder3.append(aYE());
                    stringBuilder3.append("()");
                    stringBuilder3.append(stringBuilder);
                    stringBuilder = stringBuilder3.toString();
                } else {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("No field signature for property: ");
                    stringBuilder4.append(this.evm);
                    throw new KotlinReflectionInternalError(stringBuilder4.toString());
                }
            }
            this.string = stringBuilder;
        }

        /* JADX WARNING: Missing block: B:7:0x003b, code:
            if (r0 != null) goto L_0x0040;
     */
        private final java.lang.String aYE() {
            /*
            r3 = this;
            r0 = r3.evm;
            r0 = r0.bbv();
            r1 = r3.evm;
            r1 = r1.bbJ();
            r2 = kotlin.reflect.jvm.internal.impl.descriptors.au.eBf;
            r1 = kotlin.jvm.internal.h.E(r1, r2);
            if (r1 == 0) goto L_0x0056;
        L_0x0014:
            r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e;
            if (r1 == 0) goto L_0x0056;
        L_0x0018:
            r0 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) r0;
            r0 = r0.byk();
            r0 = (kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage) r0;
            r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.eMq;
            r2 = "JvmProtoBuf.classModuleName";
            kotlin.jvm.internal.h.d(r1, r2);
            r0 = kotlin.reflect.jvm.internal.impl.metadata.a.f.a(r0, r1);
            r0 = (java.lang.Integer) r0;
            if (r0 == 0) goto L_0x003e;
        L_0x002f:
            r1 = r3.evp;
            r0 = (java.lang.Number) r0;
            r0 = r0.intValue();
            r0 = r1.getString(r0);
            if (r0 == 0) goto L_0x003e;
        L_0x003d:
            goto L_0x0040;
        L_0x003e:
            r0 = "main";
        L_0x0040:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "$";
            r1.append(r2);
            r0 = kotlin.reflect.jvm.internal.impl.name.g.mH(r0);
            r1.append(r0);
            r0 = r1.toString();
            return r0;
        L_0x0056:
            r1 = r3.evm;
            r1 = r1.bbJ();
            r2 = kotlin.reflect.jvm.internal.impl.descriptors.au.eBc;
            r1 = kotlin.jvm.internal.h.E(r1, r2);
            if (r1 == 0) goto L_0x00a0;
        L_0x0064:
            r0 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.x;
            if (r0 == 0) goto L_0x00a0;
        L_0x0068:
            r0 = r3.evm;
            if (r0 != 0) goto L_0x0074;
        L_0x006c:
            r0 = new kotlin.TypeCastException;
            r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor";
            r0.<init>(r1);
            throw r0;
        L_0x0074:
            r0 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) r0;
            r0 = r0.bxL();
            r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.i;
            if (r1 == 0) goto L_0x00a0;
        L_0x007e:
            r0 = (kotlin.reflect.jvm.internal.impl.load.kotlin.i) r0;
            r1 = r0.biw();
            if (r1 == 0) goto L_0x00a0;
        L_0x0086:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "$";
            r1.append(r2);
            r0 = r0.biu();
            r0 = r0.asString();
            r1.append(r0);
            r0 = r1.toString();
            return r0;
        L_0x00a0:
            r0 = "";
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.f.c.aYE():java.lang.String");
        }

        public String asString() {
            return this.string;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", "", "kotlin-reflect-api"})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class d extends f {
        private final e evr;
        private final e evs;

        public final e aYK() {
            return this.evr;
        }

        public final e aYL() {
            return this.evs;
        }

        public d(e eVar, e eVar2) {
            h.e(eVar, "getterSignature");
            super();
            this.evr = eVar;
            this.evs = eVar2;
        }

        public String asString() {
            return this.evr.asString();
        }
    }

    public abstract String asString();

    private f() {
    }

    public /* synthetic */ f(f fVar) {
        this();
    }
}
