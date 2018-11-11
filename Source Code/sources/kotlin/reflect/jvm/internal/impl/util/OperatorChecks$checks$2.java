package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements b<r, String> {
    public static final OperatorChecks$checks$2 eWo = new OperatorChecks$checks$2();

    OperatorChecks$checks$2() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(r rVar) {
        h.e(rVar, "$receiver");
        AnonymousClass1 anonymousClass1 = AnonymousClass1.eWp;
        i iVar = i.eWm;
        k bbv = rVar.bbv();
        h.d(bbv, "containingDeclaration");
        boolean i = anonymousClass1.i(bbv);
        Object obj = 1;
        if (!i) {
            Object obj2;
            Collection bcU = rVar.bcU();
            h.d(bcU, "overriddenDescriptors");
            Iterable<r> iterable = bcU;
            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                for (r rVar2 : iterable) {
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.eWp;
                    h.d(rVar2, "it");
                    k bbv2 = rVar2.bbv();
                    h.d(bbv2, "it.containingDeclaration");
                    if (anonymousClass12.i(bbv2)) {
                        obj2 = 1;
                        break;
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
                obj = null;
            }
        }
        return obj == null ? "must override ''equals()'' in Any" : null;
    }
}
