package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$propertyNamesLazy$2 extends Lambda implements a<Set<? extends f>> {
    final /* synthetic */ k this$0;

    LazyJavaScope$propertyNamesLazy$2(k kVar) {
        this.this$0 = kVar;
        super(0);
    }

    /* renamed from: bgK */
    public final Set<f> invoke() {
        return this.this$0.e(d.eRZ, null);
    }
}
