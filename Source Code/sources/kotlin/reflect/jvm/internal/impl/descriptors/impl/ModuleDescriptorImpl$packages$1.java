package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: ModuleDescriptorImpl.kt */
final class ModuleDescriptorImpl$packages$1 extends Lambda implements b<kotlin.reflect.jvm.internal.impl.name.b, q> {
    final /* synthetic */ u this$0;

    ModuleDescriptorImpl$packages$1(u uVar) {
        this.this$0 = uVar;
        super(1);
    }

    /* renamed from: m */
    public final q invoke(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return new q(this.this$0, bVar, this.this$0.exB);
    }
}
