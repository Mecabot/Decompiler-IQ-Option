package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;

/* compiled from: DescriptorRendererImpl.kt */
final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements b<f<?>, String> {
    final /* synthetic */ d this$0;

    DescriptorRendererImpl$renderConstant$1(d dVar) {
        this.this$0 = dVar;
        super(1);
    }

    /* renamed from: d */
    public final String invoke(f<?> fVar) {
        h.e(fVar, "it");
        return this.this$0.c(fVar);
    }
}
