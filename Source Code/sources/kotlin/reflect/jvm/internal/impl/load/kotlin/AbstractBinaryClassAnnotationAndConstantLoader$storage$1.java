package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1 extends Lambda implements b<n, b<? extends A, ? extends C>> {
    final /* synthetic */ a this$0;

    AbstractBinaryClassAnnotationAndConstantLoader$storage$1(a aVar) {
        this.this$0 = aVar;
        super(1);
    }

    /* renamed from: d */
    public final b<A, C> invoke(n nVar) {
        h.e(nVar, "kotlinClass");
        return this.this$0.c(nVar);
    }
}
