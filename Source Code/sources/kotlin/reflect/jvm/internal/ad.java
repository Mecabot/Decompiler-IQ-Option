package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, aXE = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflect-api"})
/* compiled from: RuntimeTypeMapper.kt */
public final class ad {
    private static final String getSignature(Method method) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method.getName());
        Object parameterTypes = method.getParameterTypes();
        h.d(parameterTypes, "parameterTypes");
        stringBuilder.append(i.a((Object[]) parameterTypes, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, (b) RuntimeTypeMapperKt$signature$1.ewG, 24, null));
        Class returnType = method.getReturnType();
        h.d(returnType, "returnType");
        stringBuilder.append(kotlin.reflect.jvm.internal.structure.b.T(returnType));
        return stringBuilder.toString();
    }
}
