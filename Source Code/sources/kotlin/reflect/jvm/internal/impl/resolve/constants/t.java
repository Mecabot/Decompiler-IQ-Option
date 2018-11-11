package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class t extends x<Byte> {
    public t(byte b) {
        super(Byte.valueOf(b));
    }

    public w h(u uVar) {
        ad bdb;
        h.e(uVar, "module");
        a aVar = g.exC.eyX;
        h.d(aVar, "KotlinBuiltIns.FQ_NAMES.uByte");
        d a = q.a(uVar, aVar);
        if (a != null) {
            bdb = a.bdb();
            if (bdb != null) {
                return bdb;
            }
        }
        bdb = p.mU("Unsigned type UByte not found");
        h.d(bdb, "ErrorUtils.createErrorTy…ed type UByte not found\")");
        return bdb;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).byteValue());
        stringBuilder.append(".toUByte()");
        return stringBuilder.toString();
    }
}
