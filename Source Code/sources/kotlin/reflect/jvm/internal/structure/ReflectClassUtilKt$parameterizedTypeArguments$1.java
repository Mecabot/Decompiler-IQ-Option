package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Ljava/lang/reflect/ParameterizedType;", "it", "invoke"})
/* compiled from: reflectClassUtil.kt */
final class ReflectClassUtilKt$parameterizedTypeArguments$1 extends Lambda implements b<ParameterizedType, ParameterizedType> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$1 eYn = new ReflectClassUtilKt$parameterizedTypeArguments$1();

    ReflectClassUtilKt$parameterizedTypeArguments$1() {
        super(1);
    }

    /* renamed from: c */
    public final ParameterizedType invoke(ParameterizedType parameterizedType) {
        h.e(parameterizedType, "it");
        Type ownerType = parameterizedType.getOwnerType();
        if (!(ownerType instanceof ParameterizedType)) {
            ownerType = null;
        }
        return (ParameterizedType) ownerType;
    }
}
