package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: Annotations.kt */
final class CompositeAnnotations$findAnnotation$1 extends Lambda implements b<g, c> {
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.b $fqName;

    CompositeAnnotations$findAnnotation$1(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        this.$fqName = bVar;
        super(1);
    }

    /* renamed from: b */
    public final c invoke(g gVar) {
        h.e(gVar, "it");
        return gVar.j(this.$fqName);
    }
}
