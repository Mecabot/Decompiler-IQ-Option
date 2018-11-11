package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.a;

/* compiled from: LazyJavaAnnotations.kt */
final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements b<a, c> {
    final /* synthetic */ e this$0;

    LazyJavaAnnotations$annotationDescriptors$1(e eVar) {
        this.this$0 = eVar;
        super(1);
    }

    /* renamed from: a */
    public final c invoke(a aVar) {
        h.e(aVar, "annotation");
        return kotlin.reflect.jvm.internal.impl.load.java.components.c.eGc.a(aVar, this.this$0.eGT);
    }
}
