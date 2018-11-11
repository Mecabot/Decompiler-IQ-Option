package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;

/* compiled from: constantValues.kt */
public final class w extends x<Short> {
    public w(short s) {
        super(Short.valueOf(s));
    }

    public kotlin.reflect.jvm.internal.impl.types.w h(u uVar) {
        ad bdb;
        h.e(uVar, "module");
        a aVar = g.exC.eyY;
        h.d(aVar, "KotlinBuiltIns.FQ_NAMES.uShort");
        d a = q.a(uVar, aVar);
        if (a != null) {
            bdb = a.bdb();
            if (bdb != null) {
                return bdb;
            }
        }
        bdb = p.mU("Unsigned type UShort not found");
        h.d(bdb, "ErrorUtils.createErrorTy…d type UShort not found\")");
        return bdb;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).shortValue());
        stringBuilder.append(".toUShort()");
        return stringBuilder.toString();
    }
}
