package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class p extends m<Long> {
    public p(long j) {
        super(Long.valueOf(j));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().bba();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).longValue());
        stringBuilder.append(".toLong()");
        return stringBuilder.toString();
    }
}
