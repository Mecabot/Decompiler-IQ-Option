package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$resolveProperty$1 extends Lambda implements a<f<?>> {
    final /* synthetic */ n $field;
    final /* synthetic */ y $propertyDescriptor;
    final /* synthetic */ k this$0;

    LazyJavaScope$resolveProperty$1(k kVar, n nVar, y yVar) {
        this.this$0 = kVar;
        this.$field = nVar;
        this.$propertyDescriptor = yVar;
        super(0);
    }

    /* renamed from: bgX */
    public final f<?> invoke() {
        return this.this$0.bgT().bgq().bgb().a(this.$field, this.$propertyDescriptor);
    }
}
