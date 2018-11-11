package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends FunctionReference implements b<aq, Boolean> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 eRu = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1);
    }

    public final d Py() {
        return j.F(aq.class);
    }

    public final String getName() {
        return "declaresDefaultValue";
    }

    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(g((aq) obj));
    }

    public final boolean g(aq aqVar) {
        h.e(aqVar, "p1");
        return aqVar.bdR();
    }
}
