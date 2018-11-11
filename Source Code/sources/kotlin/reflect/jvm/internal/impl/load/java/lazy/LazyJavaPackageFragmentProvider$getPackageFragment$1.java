package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
final class LazyJavaPackageFragmentProvider$getPackageFragment$1 extends Lambda implements a<h> {
    final /* synthetic */ t $jPackage;
    final /* synthetic */ g this$0;

    LazyJavaPackageFragmentProvider$getPackageFragment$1(g gVar, t tVar) {
        this.this$0 = gVar;
        this.$jPackage = tVar;
        super(0);
    }

    /* renamed from: bgn */
    public final h invoke() {
        h a = this.this$0.eGT;
        t tVar = this.$jPackage;
        kotlin.jvm.internal.h.d(tVar, "jPackage");
        return new h(a, tVar);
    }
}
