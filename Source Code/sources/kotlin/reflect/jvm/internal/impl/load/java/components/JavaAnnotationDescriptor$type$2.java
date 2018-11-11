package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaAnnotationDescriptor$type$2 extends Lambda implements a<ad> {
    final /* synthetic */ h $c;
    final /* synthetic */ b this$0;

    JavaAnnotationDescriptor$type$2(b bVar, h hVar) {
        this.this$0 = bVar;
        this.$c = hVar;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        d d = this.$c.bar().bdy().d(this.this$0.bdD());
        kotlin.jvm.internal.h.d(d, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
        return d.bdb();
    }
}
