package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$descriptor$2 extends Lambda implements a<r> {
    final /* synthetic */ String $name;
    final /* synthetic */ KFunctionImpl this$0;

    KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        this.this$0 = kFunctionImpl;
        this.$name = str;
        super(0);
    }

    /* renamed from: aZs */
    public final r invoke() {
        return this.this$0.aYP().aZ(this.$name, this.this$0.signature);
    }
}
