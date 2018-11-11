package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* compiled from: context.kt */
final class ContextKt$childForClassOrPackage$1 extends Lambda implements a<d> {
    final /* synthetic */ e $containingDeclaration;
    final /* synthetic */ h receiver$0;

    ContextKt$childForClassOrPackage$1(h hVar, e eVar) {
        this.receiver$0 = hVar;
        this.$containingDeclaration = eVar;
        super(0);
    }

    /* renamed from: bfU */
    public final d invoke() {
        return a.a(this.receiver$0, this.$containingDeclaration.bbQ());
    }
}
