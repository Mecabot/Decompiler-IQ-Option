package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: BuiltInAnnotationDescriptor.kt */
final class BuiltInAnnotationDescriptor$type$2 extends Lambda implements a<ad> {
    final /* synthetic */ j this$0;

    BuiltInAnnotationDescriptor$type$2(j jVar) {
        this.this$0 = jVar;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        d d = this.this$0.eBL.d(this.this$0.bdD());
        h.d(d, "builtIns.getBuiltInClassByFqName(fqName)");
        return d.bdb();
    }
}
