package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class h extends f<Double> {
    public h(double d) {
        super(Double.valueOf(d));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        kotlin.jvm.internal.h.e(uVar, "module");
        return uVar.bdy().bbc();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).doubleValue());
        stringBuilder.append(".toDouble()");
        return stringBuilder.toString();
    }
}
