package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$fqName$2 extends Lambda implements a<b> {
    final /* synthetic */ e this$0;

    LazyJavaAnnotationDescriptor$fqName$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: bgA */
    public final b invoke() {
        kotlin.reflect.jvm.internal.impl.name.a classId = this.this$0.eHs.getClassId();
        return classId != null ? classId.btK() : null;
    }
}
