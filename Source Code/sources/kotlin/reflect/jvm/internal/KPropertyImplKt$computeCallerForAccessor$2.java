package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.resolve.c;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"isInsideJvmInterfaceCompanionObject", "", "invoke"})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImplKt$computeCallerForAccessor$2 extends Lambda implements a<Boolean> {
    final /* synthetic */ s.a receiver$0;

    KPropertyImplKt$computeCallerForAccessor$2(s.a aVar) {
        this.receiver$0 = aVar;
        super(0);
    }

    public final boolean invoke() {
        k bbv = this.receiver$0.aZv().aYM().bbv();
        if (c.D(bbv)) {
            h.d(bbv, "possibleCompanionObject");
            if (c.J(bbv.bbv()) || c.I(bbv.bbv())) {
                return true;
            }
        }
        return false;
    }
}
