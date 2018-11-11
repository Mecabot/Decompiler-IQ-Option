package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.i;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.e;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.af;

@i(aXC = {1, 1, 11}, aXD = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 ;*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004:;<=B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\n\u00101\u001a\u0004\u0018\u00010\u0015H\u0004J\u0013\u00102\u001a\u00020'2\b\u00103\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u00104\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010\u00152\b\u00106\u001a\u0004\u0018\u00010\nH\u0004J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0007H\u0016R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\r0\r0\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0014\u0010)\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0013\u0010+\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/¨\u0006>"}, aXE = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflect-api"})
/* compiled from: KPropertyImpl.kt */
public abstract class s<R> extends g<R> implements j<R> {
    private static final Object ewp = new Object();
    public static final b ewq = new b();
    private final Object boundReceiver;
    private final KDeclarationContainerImpl container;
    private final kotlin.reflect.jvm.internal.y.a<Field> ewn;
    private final kotlin.reflect.jvm.internal.y.a<ad> ewo;
    private final String name;
    private final String signature;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, aXE = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "()V", "EXTENSION_PROPERTY_DELEGATE", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "kotlin-reflect-api"})
    /* compiled from: KPropertyImpl.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, aXE = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflect-api"})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class a<PropertyType, ReturnType> extends g<ReturnType> implements e<ReturnType>, kotlin.reflect.j.a<PropertyType> {
        public c<?> aYO() {
            return null;
        }

        public abstract s<PropertyType> aZv();

        public abstract ac bab();

        public KDeclarationContainerImpl aYP() {
            return aZv().aYP();
        }

        public boolean isBound() {
            return aZv().isBound();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8VX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, aXE = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class c<R> extends a<R, R> implements kotlin.reflect.j.b<R> {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        private final kotlin.reflect.jvm.internal.y.a caller$delegate = y.h(new KPropertyImpl$Getter$caller$2(this));
        private final kotlin.reflect.jvm.internal.y.a descriptor$delegate = y.h(new KPropertyImpl$Getter$descriptor$2(this));

        public c<?> aYN() {
            return (c) this.caller$delegate.G(this, apP[1]);
        }

        /* renamed from: bac */
        public ae bab() {
            return (ae) this.descriptor$delegate.G(this, apP[0]);
        }

        public String getName() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<get-");
            stringBuilder.append(aZv().getName());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005R\u001f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8VX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, aXE = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflect-api"})
    /* compiled from: KPropertyImpl.kt */
    public static abstract class d<R> extends a<R, l> implements kotlin.reflect.f.a<R> {
        static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
        private final kotlin.reflect.jvm.internal.y.a caller$delegate = y.h(new KPropertyImpl$Setter$caller$2(this));
        private final kotlin.reflect.jvm.internal.y.a descriptor$delegate = y.h(new KPropertyImpl$Setter$descriptor$2(this));

        public c<?> aYN() {
            return (c) this.caller$delegate.G(this, apP[1]);
        }

        /* renamed from: bae */
        public af bab() {
            return (af) this.descriptor$delegate.G(this, apP[0]);
        }

        public String getName() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<set-");
            stringBuilder.append(aZv().getName());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }
    }

    public abstract c<R> aZP();

    public KDeclarationContainerImpl aYP() {
        return this.container;
    }

    public String getName() {
        return this.name;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final Object aXQ() {
        return this.boundReceiver;
    }

    private s(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, ad adVar, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.boundReceiver = obj;
        this.ewn = y.h(new KPropertyImpl$_javaField$1(this));
        this.ewo = y.a(adVar, new KPropertyImpl$_descriptor$1(this));
    }

    public s(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        h.e(kDeclarationContainerImpl, "container");
        h.e(str, "name");
        h.e(str2, "signature");
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    public s(KDeclarationContainerImpl kDeclarationContainerImpl, ad adVar) {
        h.e(kDeclarationContainerImpl, "container");
        h.e(adVar, "descriptor");
        String asString = adVar.bdc().asString();
        h.d(asString, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, asString, ac.ewF.d(adVar).asString(), adVar, CallableReference.euq);
    }

    public boolean isBound() {
        return h.E(this.boundReceiver, CallableReference.euq) ^ 1;
    }

    public final Field aZZ() {
        return (Field) this.ewn.invoke();
    }

    protected final Field baa() {
        return aYM().isDelegated() ? aZZ() : null;
    }

    protected final Object a(Field field, Object obj) {
        try {
            if (obj != ewp || aYM().bcO() != null) {
                return field != null ? field.get(obj) : null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('\'');
                stringBuilder.append(this);
                stringBuilder.append("' is not an extension property and thus getExtensionDelegate() ");
                stringBuilder.append("is not going to work, use getDelegate() instead");
                throw new RuntimeException(stringBuilder.toString());
            }
        } catch (IllegalAccessException e) {
            throw new IllegalPropertyDelegateAccessException(e);
        }
    }

    /* renamed from: aYF */
    public ad aYM() {
        Object invoke = this.ewo.invoke();
        h.d(invoke, "_descriptor()");
        return (ad) invoke;
    }

    public c<?> aYN() {
        return aZP().aYN();
    }

    public c<?> aYO() {
        return aZP().aYO();
    }

    public boolean equals(Object obj) {
        s cI = ae.cI(obj);
        boolean z = false;
        if (cI == null) {
            return false;
        }
        if (h.E(aYP(), cI.aYP()) && h.E(getName(), cI.getName()) && h.E(this.signature, cI.signature) && h.E(this.boundReceiver, cI.boundReceiver)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (((aYP().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return aa.ewB.c(aYM());
    }
}
