package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"isInsideInterfaceCompanionObjectWithJvmField", "", "invoke"})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImplKt$computeCallerForAccessor$3 extends Lambda implements a<Boolean> {
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isInsideJvmInterfaceCompanionObject$2;
    final /* synthetic */ s.a receiver$0;

    KPropertyImplKt$computeCallerForAccessor$3(s.a aVar, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2) {
        this.receiver$0 = aVar;
        this.$isInsideJvmInterfaceCompanionObject$2 = kPropertyImplKt$computeCallerForAccessor$2;
        super(0);
    }

    public final boolean invoke() {
        ad aYF = this.receiver$0.aZv().aYM();
        return ((aYF instanceof j) && this.$isInsideJvmInterfaceCompanionObject$2.invoke()) ? kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j.g(((j) aYF).bxV()) : false;
    }
}
