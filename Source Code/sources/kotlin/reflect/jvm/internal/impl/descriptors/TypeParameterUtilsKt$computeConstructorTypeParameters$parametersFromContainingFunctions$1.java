package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: typeParameterUtils.kt */
final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 extends Lambda implements b<k, Boolean> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1 eBa = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(i((k) obj));
    }

    public final boolean i(k kVar) {
        h.e(kVar, "it");
        return kVar instanceof a;
    }
}
