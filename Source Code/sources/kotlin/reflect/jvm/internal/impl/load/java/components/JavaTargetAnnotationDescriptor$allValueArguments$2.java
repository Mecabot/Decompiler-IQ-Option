package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.b;
import kotlin.reflect.jvm.internal.impl.load.java.structure.e;
import kotlin.reflect.jvm.internal.impl.load.java.structure.m;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>>> {
    final /* synthetic */ i this$0;

    JavaTargetAnnotationDescriptor$allValueArguments$2(i iVar) {
        this.this$0 = iVar;
        super(0);
    }

    /* renamed from: adu */
    public final Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> invoke() {
        b bfO = this.this$0.bfO();
        Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> map = null;
        Object cg = bfO instanceof e ? d.eGf.cg(((e) this.this$0.bfO()).bhn()) : bfO instanceof m ? d.eGf.cg(l.cr(this.this$0.bfO())) : null;
        if (cg != null) {
            map = ac.h(j.D(c.eGc.bfQ(), cg));
        }
        return map != null ? map : ad.emptyMap();
    }
}
