package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolverKt$getErasedUpperBound$1 extends Lambda implements a<ad> {
    final /* synthetic */ an receiver$0;

    JavaTypeResolverKt$getErasedUpperBound$1(an anVar) {
        this.receiver$0 = anVar;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't compute erased upper bound of type parameter `");
        stringBuilder.append(this.receiver$0);
        stringBuilder.append('`');
        ad mU = p.mU(stringBuilder.toString());
        h.d(mU, "ErrorUtils.createErrorTy… type parameter `$this`\")");
        return mU;
    }
}
