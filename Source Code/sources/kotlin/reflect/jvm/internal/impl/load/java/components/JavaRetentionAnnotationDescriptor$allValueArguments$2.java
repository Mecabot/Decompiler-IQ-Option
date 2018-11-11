package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>>> {
    final /* synthetic */ h this$0;

    JavaRetentionAnnotationDescriptor$allValueArguments$2(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    /* renamed from: adu */
    public final Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> invoke() {
        kotlin.reflect.jvm.internal.impl.resolve.constants.f a = d.eGf.a(this.this$0.bfO());
        Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> h = a != null ? ac.h(j.D(c.eGc.bfR(), a)) : null;
        return h != null ? h : ad.emptyMap();
    }
}
