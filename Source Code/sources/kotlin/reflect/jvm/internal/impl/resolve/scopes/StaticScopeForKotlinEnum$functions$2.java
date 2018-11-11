package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.resolve.b;

/* compiled from: StaticScopeForKotlinEnum.kt */
final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements a<List<? extends ah>> {
    final /* synthetic */ k this$0;

    StaticScopeForKotlinEnum$functions$2(k kVar) {
        this.this$0 = kVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<ah> invoke() {
        return m.listOf(b.H(this.this$0.eSf), b.G(this.this$0.eSf));
    }
}
