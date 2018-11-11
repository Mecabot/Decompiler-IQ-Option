package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClasses$packageFragments$1 extends Lambda implements b<kotlin.reflect.jvm.internal.impl.name.b, m> {
    final /* synthetic */ w this$0;

    NotFoundClasses$packageFragments$1(w wVar) {
        this.this$0 = wVar;
        super(1);
    }

    /* renamed from: h */
    public final m invoke(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        h.e(bVar, "fqName");
        return new m(this.this$0.ezG, bVar);
    }
}
