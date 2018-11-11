package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "it", "Ljava/lang/reflect/ParameterizedType;", "invoke"})
/* compiled from: reflectClassUtil.kt */
final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends Lambda implements b<ParameterizedType, h<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 eYo = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    /* renamed from: d */
    public final h<Type> invoke(ParameterizedType parameterizedType) {
        kotlin.jvm.internal.h.e(parameterizedType, "it");
        Object actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.h.d(actualTypeArguments, "it.actualTypeArguments");
        return i.E(actualTypeArguments);
    }
}
