package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$HTML$1 extends Lambda implements b<f, l> {
    public static final DescriptorRenderer$Companion$HTML$1 ePo = new DescriptorRenderer$Companion$HTML$1();

    DescriptorRenderer$Companion$HTML$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((f) obj);
        return l.etX;
    }

    public final void a(f fVar) {
        h.e(fVar, "$receiver");
        fVar.a(RenderingFormat.HTML);
        fVar.l(DescriptorRendererModifier.ALL);
    }
}
