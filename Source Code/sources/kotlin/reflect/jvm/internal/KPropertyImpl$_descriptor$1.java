package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$_descriptor$1 extends Lambda implements a<ad> {
    final /* synthetic */ s this$0;

    KPropertyImpl$_descriptor$1(s sVar) {
        this.this$0 = sVar;
        super(0);
    }

    /* renamed from: bag */
    public final ad invoke() {
        return this.this$0.aYP().aY(this.this$0.getName(), this.this$0.getSignature());
    }
}
