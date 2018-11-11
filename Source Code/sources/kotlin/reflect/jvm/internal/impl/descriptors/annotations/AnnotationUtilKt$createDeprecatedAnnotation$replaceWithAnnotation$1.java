package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: annotationUtil.kt */
final class AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1 extends Lambda implements b<u, ad> {
    final /* synthetic */ g receiver$0;

    AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(g gVar) {
        this.receiver$0 = gVar;
        super(1);
    }

    /* renamed from: f */
    public final ad invoke(u uVar) {
        h.e(uVar, "module");
        ad a = uVar.bdy().a(Variance.INVARIANT, (w) this.receiver$0.bbg());
        h.d(a, "module.builtIns.getArray…ce.INVARIANT, stringType)");
        return a;
    }
}
