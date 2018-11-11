package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "", "invoke"})
/* compiled from: KParameterImpl.kt */
final class KParameterImpl$annotations$2 extends Lambda implements a<List<? extends Annotation>> {
    final /* synthetic */ o this$0;

    KParameterImpl$annotations$2(o oVar) {
        this.this$0 = oVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<Annotation> invoke() {
        return ae.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) this.this$0.aZL());
    }
}
