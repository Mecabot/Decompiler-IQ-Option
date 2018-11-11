package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;

/* compiled from: DescriptorRendererOptionsImpl.kt */
final class DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 extends Lambda implements b<aq, String> {
    public static final DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2 eQo = new DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2();

    DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(aq aqVar) {
        h.e(aqVar, "it");
        return "...";
    }
}
