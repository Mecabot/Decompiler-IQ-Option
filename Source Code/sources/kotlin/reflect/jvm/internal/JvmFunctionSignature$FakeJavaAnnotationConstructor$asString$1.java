package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: RuntimeTypeMapper.kt */
final class JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 extends Lambda implements b<Method, String> {
    public static final JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1 evf = new JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1();

    JvmFunctionSignature$FakeJavaAnnotationConstructor$asString$1() {
        super(1);
    }

    /* renamed from: b */
    public final String invoke(Method method) {
        h.d(method, "it");
        Class returnType = method.getReturnType();
        h.d(returnType, "it.returnType");
        return kotlin.reflect.jvm.internal.structure.b.T(returnType);
    }
}
