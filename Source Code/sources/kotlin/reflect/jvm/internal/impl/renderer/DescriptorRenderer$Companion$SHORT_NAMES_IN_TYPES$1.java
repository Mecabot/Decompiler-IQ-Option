package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1 extends Lambda implements b<f, l> {
    public static final DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1 ePq = new DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1();

    DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((f) obj);
        return l.etX;
    }

    public final void a(f fVar) {
        h.e(fVar, "$receiver");
        fVar.a((a) a.b.eOW);
        fVar.a(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
    }
}
