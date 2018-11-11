package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$1 extends Lambda implements b<r, String> {
    public static final OperatorChecks$checks$1 eWn = new OperatorChecks$checks$1();

    OperatorChecks$checks$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(r rVar) {
        h.e(rVar, "$receiver");
        List bcS = rVar.bcS();
        h.d(bcS, "valueParameters");
        aq aqVar = (aq) u.bX(bcS);
        Object obj = null;
        if (aqVar != null) {
            int i = (a.e(aqVar) || aqVar.bdS() != null) ? 0 : 1;
            if (i == 1) {
                obj = 1;
            }
        }
        i iVar = i.eWm;
        return obj == null ? "last parameter should not have a default value or be a vararg" : null;
    }
}
