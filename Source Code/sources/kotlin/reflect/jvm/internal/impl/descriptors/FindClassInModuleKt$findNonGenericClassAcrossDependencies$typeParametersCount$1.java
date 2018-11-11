package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.name.a;

/* compiled from: findClassInModule.kt */
final class FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 extends FunctionReference implements b<a, a> {
    public static final FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 eAM = new FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1();

    FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1() {
        super(1);
    }

    public final d Py() {
        return j.F(a.class);
    }

    public final String getName() {
        return "getOuterClassId";
    }

    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    /* renamed from: f */
    public final a invoke(a aVar) {
        h.e(aVar, "p1");
        return aVar.btI();
    }
}
