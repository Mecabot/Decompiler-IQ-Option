package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.h.b;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.util.b.a;

/* compiled from: modifierChecks.kt */
final class e implements b {
    private static final String description = "second parameter must be of type KProperty<*> or its supertype";
    public static final e eWg = new e();

    private e() {
    }

    public String a(r rVar) {
        h.e(rVar, "functionDescriptor");
        return a.a(this, rVar);
    }

    public String getDescription() {
        return description;
    }

    public boolean n(r rVar) {
        h.e(rVar, "functionDescriptor");
        aq aqVar = (aq) rVar.bcS().get(1);
        b bVar = kotlin.reflect.jvm.internal.impl.builtins.h.ezx;
        h.d(aqVar, "secondParameter");
        w b = bVar.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.P(aqVar));
        if (b == null) {
            return false;
        }
        w bai = aqVar.bai();
        h.d(bai, "secondParameter.type");
        bai = kotlin.reflect.jvm.internal.impl.types.b.a.aU(bai);
        h.d(bai, "secondParameter.type.makeNotNullable()");
        return kotlin.reflect.jvm.internal.impl.types.b.a.c(b, bai);
    }
}
