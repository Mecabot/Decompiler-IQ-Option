package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$3 extends Lambda implements b<r, String> {
    public static final OperatorChecks$checks$3 eWq = new OperatorChecks$checks$3();

    OperatorChecks$checks$3() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(r rVar) {
        h.e(rVar, "$receiver");
        ag bcP = rVar.bcP();
        if (bcP == null) {
            bcP = rVar.bcO();
        }
        i iVar = i.eWm;
        Object obj = null;
        if (bcP != null) {
            boolean c;
            w bcQ = rVar.bcQ();
            if (bcQ != null) {
                w bai = bcP.bai();
                h.d(bai, "receiver.type");
                c = a.c(bcQ, bai);
            } else {
                c = false;
            }
            if (c) {
                obj = 1;
            }
        }
        return obj == null ? "receiver must be a supertype of the return type" : null;
    }
}
