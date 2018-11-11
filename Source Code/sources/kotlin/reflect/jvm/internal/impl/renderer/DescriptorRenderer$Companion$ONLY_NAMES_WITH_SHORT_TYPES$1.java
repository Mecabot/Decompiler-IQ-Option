package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

/* compiled from: DescriptorRenderer.kt */
final class DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 extends Lambda implements b<f, l> {
    public static final DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1 ePp = new DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1();

    DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((f) obj);
        return l.etX;
    }

    public final void a(f fVar) {
        h.e(fVar, "$receiver");
        fVar.gY(false);
        fVar.l(aj.emptySet());
        fVar.a((a) a.b.eOW);
        fVar.ha(true);
        fVar.a(ParameterNameRenderingPolicy.NONE);
        fVar.gV(true);
        fVar.gW(true);
        fVar.gZ(true);
        fVar.gX(true);
    }
}
