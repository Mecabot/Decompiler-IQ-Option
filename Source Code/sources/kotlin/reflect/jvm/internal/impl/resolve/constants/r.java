package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class r extends m<Short> {
    public r(short s) {
        super(Short.valueOf(s));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().baY();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).shortValue());
        stringBuilder.append(".toShort()");
        return stringBuilder.toString();
    }
}
