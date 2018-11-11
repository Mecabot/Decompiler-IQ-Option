package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c;

/* compiled from: EmptyPackageFragmentDesciptor.kt */
public final class m extends w {
    public m(u uVar, b bVar) {
        h.e(uVar, "module");
        h.e(bVar, "fqName");
        super(uVar, bVar);
    }

    /* renamed from: bcJ */
    public c bbk() {
        return c.eSm;
    }
}
