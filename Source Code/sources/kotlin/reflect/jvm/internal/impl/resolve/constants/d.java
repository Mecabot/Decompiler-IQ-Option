package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class d extends m<Byte> {
    public d(byte b) {
        super(Byte.valueOf(b));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().baX();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).byteValue());
        stringBuilder.append(".toByte()");
        return stringBuilder.toString();
    }
}
