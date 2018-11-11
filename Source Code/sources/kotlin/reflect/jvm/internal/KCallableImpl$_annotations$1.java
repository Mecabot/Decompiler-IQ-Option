package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "", "R", "invoke"})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$_annotations$1 extends Lambda implements a<List<? extends Annotation>> {
    final /* synthetic */ g this$0;

    KCallableImpl$_annotations$1(g gVar) {
        this.this$0 = gVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<Annotation> invoke() {
        return ae.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) this.this$0.aYM());
    }
}
