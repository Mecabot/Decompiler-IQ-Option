package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class u extends x<Integer> {
    public u(int i) {
        super(Integer.valueOf(i));
    }

    public w h(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        ad bdb;
        h.e(uVar, "module");
        a aVar = g.exC.eyZ;
        h.d(aVar, "KotlinBuiltIns.FQ_NAMES.uInt");
        d a = q.a(uVar, aVar);
        if (a != null) {
            bdb = a.bdb();
            if (bdb != null) {
                return bdb;
            }
        }
        bdb = p.mU("Unsigned type UInt not found");
        h.d(bdb, "ErrorUtils.createErrorTy…ned type UInt not found\")");
        return bdb;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).intValue());
        stringBuilder.append(".toUInt()");
        return stringBuilder.toString();
    }
}
