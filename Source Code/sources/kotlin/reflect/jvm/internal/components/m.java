package kotlin.reflect.jvm.internal.components;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, aXE = {"Lkotlin/reflect/jvm/internal/components/SignatureSerializer;", "", "()V", "constructorDesc", "", "constructor", "Ljava/lang/reflect/Constructor;", "fieldDesc", "field", "Ljava/lang/reflect/Field;", "methodDesc", "method", "Ljava/lang/reflect/Method;", "descriptors.runtime"})
/* compiled from: ReflectKotlinClass.kt */
final class m {
    public static final m exa = new m();

    private m() {
    }

    public final String g(Method method) {
        h.e(method, b.METHOD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Class cls : method.getParameterTypes()) {
            h.d(cls, "parameterType");
            stringBuilder.append(kotlin.reflect.jvm.internal.structure.b.T(cls));
        }
        stringBuilder.append(")");
        Class returnType = method.getReturnType();
        h.d(returnType, "method.returnType");
        stringBuilder.append(kotlin.reflect.jvm.internal.structure.b.T(returnType));
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }

    public final String b(Constructor<?> constructor) {
        h.e(constructor, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (Class cls : constructor.getParameterTypes()) {
            h.d(cls, "parameterType");
            stringBuilder.append(kotlin.reflect.jvm.internal.structure.b.T(cls));
        }
        stringBuilder.append(")V");
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }

    public final String c(Field field) {
        h.e(field, "field");
        Class type = field.getType();
        h.d(type, "field.type");
        return kotlin.reflect.jvm.internal.structure.b.T(type);
    }
}
