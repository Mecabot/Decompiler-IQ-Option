package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.e;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.c.c;
import kotlin.reflect.jvm.internal.c.f;
import kotlin.reflect.jvm.internal.c.g;
import kotlin.reflect.jvm.internal.c.n;
import kotlin.reflect.jvm.internal.c.s;
import kotlin.reflect.jvm.internal.c.t;
import kotlin.reflect.jvm.internal.c.w;
import kotlin.reflect.jvm.internal.c.z;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.y.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0011J\u001e\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00132\n\u0010,\u001a\u0006\u0012\u0002\b\u00030+H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010,\u001a\u00020/H\u0002J\u0013\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00138VX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\r\u001a\u00020\u000e8VX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0014\u0010#\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, aXE = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "getArity", "", "hashCode", "toString", "kotlin-reflect-api"})
/* compiled from: KFunctionImpl.kt */
public final class KFunctionImpl extends g<Object> implements FunctionBase, e<Object>, d {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/FunctionCaller;"))};
    private final Object boundReceiver;
    private final a caller$delegate;
    private final KDeclarationContainerImpl container;
    private final a defaultCaller$delegate;
    private final a descriptor$delegate;
    private final String signature;

    public c<?> aYN() {
        return (c) this.caller$delegate.G(this, apP[1]);
    }

    public c<?> aYO() {
        return (c) this.defaultCaller$delegate.G(this, apP[2]);
    }

    /* renamed from: aZq */
    public r aYM() {
        return (r) this.descriptor$delegate.G(this, apP[0]);
    }

    public Object B(Object obj, Object obj2) {
        return d.a.a(this, obj, obj2);
    }

    public Object c(Object obj, Object obj2, Object obj3) {
        return d.a.a(this, obj, obj2, obj3);
    }

    public Object invoke() {
        return d.a.a(this);
    }

    public Object invoke(Object obj) {
        return d.a.a(this, obj);
    }

    public KDeclarationContainerImpl aYP() {
        return this.container;
    }

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, r rVar, Object obj, int i, f fVar) {
        if ((i & 16) != 0) {
            obj = CallableReference.euq;
        }
        this(kDeclarationContainerImpl, str, str2, rVar, obj);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, r rVar, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.boundReceiver = obj;
        this.descriptor$delegate = y.a(rVar, new KFunctionImpl$descriptor$2(this, str));
        this.caller$delegate = y.h(new KFunctionImpl$caller$2(this));
        this.defaultCaller$delegate = y.h(new KFunctionImpl$defaultCaller$2(this));
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        h.e(kDeclarationContainerImpl, "container");
        h.e(str, "name");
        h.e(str2, "signature");
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, r rVar) {
        h.e(kDeclarationContainerImpl, "container");
        h.e(rVar, "descriptor");
        String asString = rVar.bdc().asString();
        h.d(asString, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, asString, ac.ewF.d(rVar).asString(), rVar, null, 16, null);
    }

    public boolean isBound() {
        return h.E(this.boundReceiver, CallableReference.euq) ^ 1;
    }

    public String getName() {
        String asString = aYM().bdc().asString();
        h.d(asString, "descriptor.name.asString()");
        return asString;
    }

    private final w c(Method method) {
        return isBound() ? new c.j(method, this.boundReceiver) : new z(method);
    }

    private final w d(Method method) {
        return isBound() ? new g(method) : new t(method);
    }

    private final w e(Method method) {
        return isBound() ? new f(method, this.boundReceiver) : new s(method);
    }

    private final c<Constructor<?>> a(Constructor<?> constructor) {
        return isBound() ? new c(constructor, this.boundReceiver) : new n(constructor);
    }

    public boolean equals(Object obj) {
        KFunctionImpl cH = ae.cH(obj);
        boolean z = false;
        if (cH == null) {
            return false;
        }
        if (h.E(aYP(), cH.aYP()) && h.E(getName(), cH.getName()) && h.E(this.signature, cH.signature) && h.E(this.boundReceiver, cH.boundReceiver)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (((aYP().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return aa.ewB.b(aYM());
    }
}
