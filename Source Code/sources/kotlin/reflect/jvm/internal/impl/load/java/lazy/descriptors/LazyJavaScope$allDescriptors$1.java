package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$allDescriptors$1 extends Lambda implements a<List<? extends k>> {
    final /* synthetic */ k this$0;

    LazyJavaScope$allDescriptors$1(k kVar) {
        this.this$0 = kVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<k> invoke() {
        return this.this$0.a(d.eRR, h.eSi.bxi(), (b) NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
