package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.h;

/* compiled from: typeParameterUtils.kt */
final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 extends Lambda implements b<k, h<? extends an>> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 eBb = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2() {
        super(1);
    }

    /* renamed from: j */
    public final h<an> invoke(k kVar) {
        kotlin.jvm.internal.h.e(kVar, "it");
        List typeParameters = ((a) kVar).getTypeParameters();
        kotlin.jvm.internal.h.d(typeParameters, "(it as CallableDescriptor).typeParameters");
        return u.ac(typeParameters);
    }
}
