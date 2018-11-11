package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: context.kt */
final class ContextKt$copyWithNewDefaultTypeQualifiers$1 extends Lambda implements a<d> {
    final /* synthetic */ g $additionalAnnotations;
    final /* synthetic */ h receiver$0;

    ContextKt$copyWithNewDefaultTypeQualifiers$1(h hVar, g gVar) {
        this.receiver$0 = hVar;
        this.$additionalAnnotations = gVar;
        super(0);
    }

    /* renamed from: bfU */
    public final d invoke() {
        return a.a(this.receiver$0, this.$additionalAnnotations);
    }
}
