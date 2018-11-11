package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.types.w;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ReflectionObjectRenderer.kt */
final class ReflectionObjectRenderer$renderFunction$1$1 extends Lambda implements b<aq, String> {
    public static final ReflectionObjectRenderer$renderFunction$1$1 ewC = new ReflectionObjectRenderer$renderFunction$1$1();

    ReflectionObjectRenderer$renderFunction$1$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(aq aqVar) {
        aa aaVar = aa.ewB;
        h.d(aqVar, "it");
        w bai = aqVar.bai();
        h.d(bai, "it.type");
        return aaVar.b(bai);
    }
}
