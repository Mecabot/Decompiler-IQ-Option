package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$knownClassNamesInPackage$1 extends Lambda implements a<Set<? extends String>> {
    final /* synthetic */ h $c;
    final /* synthetic */ j this$0;

    LazyJavaPackageScope$knownClassNamesInPackage$1(j jVar, h hVar) {
        this.this$0 = jVar;
        this.$c = hVar;
        super(0);
    }

    /* renamed from: bgK */
    public final Set<String> invoke() {
        return this.$c.bgq().bfV().b(this.this$0.bgJ().bdD());
    }
}
