package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.util.b.a;

/* compiled from: modifierChecks.kt */
final class h implements b {
    private static final String description = "should not have varargs or parameters with default values";
    public static final h eWk = new h();

    private h() {
    }

    public String a(r rVar) {
        kotlin.jvm.internal.h.e(rVar, "functionDescriptor");
        return a.a(this, rVar);
    }

    public String getDescription() {
        return description;
    }

    public boolean n(r rVar) {
        kotlin.jvm.internal.h.e(rVar, "functionDescriptor");
        List bcS = rVar.bcS();
        kotlin.jvm.internal.h.d(bcS, "functionDescriptor.valueParameters");
        Iterable<aq> iterable = bcS;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (aq aqVar : iterable) {
            Object obj;
            kotlin.jvm.internal.h.d(aqVar, "it");
            if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(aqVar) || aqVar.bdS() != null) {
                obj = null;
                continue;
            } else {
                obj = 1;
                continue;
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }
}
