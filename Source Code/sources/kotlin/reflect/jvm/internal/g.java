package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.KParameter;
import kotlin.reflect.a;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.n;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u00105\u001a\u00028\u00002\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010807\"\u0004\u0018\u000108H\u0016¢\u0006\u0002\u00109J#\u0010:\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002¢\u0006\u0002\u0010<J#\u0010=\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0016¢\u0006\u0002\u0010<J#\u0010>\u001a\u00028\u00002\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u0001080;H\u0002¢\u0006\u0002\u0010<J\u0012\u0010?\u001a\u0004\u0018\u0001082\u0006\u0010@\u001a\u00020AH\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \b*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00060\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010#R\u0014\u0010$\u001a\u00020\"8DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0012\u0010%\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0012R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006B"}, aXE = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "getCaller", "()Lkotlin/reflect/jvm/internal/FunctionCaller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "kotlin-reflect-api"})
/* compiled from: KCallableImpl.kt */
public abstract class g<R> implements a<R> {
    private final y.a<List<Annotation>> _annotations = y.h(new KCallableImpl$_annotations$1(this));
    private final y.a<ArrayList<KParameter>> _parameters = y.h(new KCallableImpl$_parameters$1(this));
    private final y.a<u> _returnType = y.h(new KCallableImpl$_returnType$1(this));
    private final y.a<List<w>> _typeParameters = y.h(new KCallableImpl$_typeParameters$1(this));

    public abstract CallableMemberDescriptor aYM();

    public abstract c<?> aYN();

    public abstract c<?> aYO();

    public abstract KDeclarationContainerImpl aYP();

    public abstract boolean isBound();

    public List<KParameter> getParameters() {
        Object invoke = this._parameters.invoke();
        h.d(invoke, "_parameters()");
        return (List) invoke;
    }

    public n aXT() {
        Object invoke = this._returnType.invoke();
        h.d(invoke, "_returnType()");
        return (n) invoke;
    }

    protected final boolean aYQ() {
        return h.E(getName(), "<init>") && aYP().aXV().isAnnotation();
    }

    public R L(Object... objArr) {
        h.e(objArr, "args");
        try {
            return aYN().L(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }
}
