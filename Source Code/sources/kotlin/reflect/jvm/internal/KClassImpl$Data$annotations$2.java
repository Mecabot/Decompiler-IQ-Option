package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "", "T", "", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$annotations$2 extends Lambda implements a<List<? extends Annotation>> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$annotations$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<Annotation> invoke() {
        return ae.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.a) this.this$0.aYX());
    }
}
