package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: GivenFunctionsMemberScope.kt */
final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements a<List<? extends k>> {
    final /* synthetic */ e this$0;

    GivenFunctionsMemberScope$allDescriptors$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<k> invoke() {
        List bca = this.this$0.bca();
        return u.b((Collection) bca, (Iterable) this.this$0.cl(bca));
    }
}
