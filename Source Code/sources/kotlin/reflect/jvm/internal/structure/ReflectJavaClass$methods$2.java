package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "p1", "Ljava/lang/reflect/Method;", "Lkotlin/ParameterName;", "name", "member", "invoke"})
/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$2 extends FunctionReference implements b<Method, s> {
    public static final ReflectJavaClass$methods$2 eYy = new ReflectJavaClass$methods$2();

    ReflectJavaClass$methods$2() {
        super(1);
    }

    public final d Py() {
        return j.F(s.class);
    }

    public final String getName() {
        return "<init>";
    }

    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    /* renamed from: j */
    public final s invoke(Method method) {
        h.e(method, "p1");
        return new s(method);
    }
}
