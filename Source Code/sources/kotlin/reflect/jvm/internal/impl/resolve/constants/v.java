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
public final class v extends x<Long> {
    public v(long j) {
        super(Long.valueOf(j));
    }

    public w h(u uVar) {
        ad bdb;
        h.e(uVar, "module");
        a aVar = g.exC.eza;
        h.d(aVar, "KotlinBuiltIns.FQ_NAMES.uLong");
        d a = q.a(uVar, aVar);
        if (a != null) {
            bdb = a.bdb();
            if (bdb != null) {
                return bdb;
            }
        }
        bdb = p.mU("Unsigned type ULong not found");
        h.d(bdb, "ErrorUtils.createErrorTy…ed type ULong not found\")");
        return bdb;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) getValue()).longValue());
        stringBuilder.append(".toULong()");
        return stringBuilder.toString();
    }
}
