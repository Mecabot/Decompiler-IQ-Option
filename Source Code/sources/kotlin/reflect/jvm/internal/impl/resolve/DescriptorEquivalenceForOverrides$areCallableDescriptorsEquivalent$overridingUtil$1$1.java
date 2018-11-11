package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1 extends Lambda implements m<k, k, Boolean> {
    final /* synthetic */ a this$0;

    DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1(a aVar) {
        this.this$0 = aVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Boolean.valueOf(e((k) obj, (k) obj2));
    }

    public final boolean e(k kVar, k kVar2) {
        return h.E(kVar, this.this$0.eQx) && h.E(kVar2, this.this$0.eQy);
    }
}
