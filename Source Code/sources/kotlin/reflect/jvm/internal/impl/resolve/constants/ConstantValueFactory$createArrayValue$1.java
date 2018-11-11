package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ConstantValueFactory.kt */
final class ConstantValueFactory$createArrayValue$1 extends Lambda implements b<u, w> {
    final /* synthetic */ w $type;

    ConstantValueFactory$createArrayValue$1(w wVar) {
        this.$type = wVar;
        super(1);
    }

    /* renamed from: g */
    public final w invoke(u uVar) {
        h.e(uVar, "it");
        return this.$type;
    }
}
