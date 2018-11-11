package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class k extends f<Float> {
    public k(float f) {
        super(Float.valueOf(f));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().bbb();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).floatValue());
        stringBuilder.append(".toFloat()");
        return stringBuilder.toString();
    }
}
