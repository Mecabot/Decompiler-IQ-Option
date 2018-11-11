package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: KotlinTypeFactory.kt */
public final class x {
    public static final x eUX = new x();

    private x() {
    }

    private final h a(an anVar, List<? extends ap> list) {
        f bbW = anVar.bbW();
        if (bbW instanceof an) {
            return bbW.bdb().bbk();
        }
        h a;
        if (bbW instanceof d) {
            if (list.isEmpty()) {
                return ((d) bbW).bdb().bbk();
            }
            a = ((d) bbW).a(ao.eVe.b(anVar, (List) list));
            kotlin.jvm.internal.h.d(a, "descriptor.getMemberScop…(constructor, arguments))");
            return a;
        } else if (bbW instanceof am) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scope for abbreviation: ");
            stringBuilder.append(((am) bbW).bdc());
            a = p.z(stringBuilder.toString(), true);
            kotlin.jvm.internal.h.d(a, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
            return a;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unsupported classifier: ");
            stringBuilder2.append(bbW);
            stringBuilder2.append(" for constructor: ");
            stringBuilder2.append(anVar);
            throw new IllegalStateException(stringBuilder2.toString());
        }
    }

    public static final ad c(g gVar, an anVar, List<? extends ap> list, boolean z) {
        kotlin.jvm.internal.h.e(gVar, "annotations");
        kotlin.jvm.internal.h.e(anVar, "constructor");
        kotlin.jvm.internal.h.e(list, "arguments");
        if (!gVar.isEmpty() || !list.isEmpty() || z || anVar.bbW() == null) {
            return a(gVar, anVar, list, z, eUX.a(anVar, (List) list));
        }
        f bbW = anVar.bbW();
        if (bbW == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        kotlin.jvm.internal.h.d(bbW, "constructor.declarationDescriptor!!");
        ad bdb = bbW.bdb();
        kotlin.jvm.internal.h.d(bdb, "constructor.declarationDescriptor!!.defaultType");
        return bdb;
    }

    public static final ad a(g gVar, an anVar, List<? extends ap> list, boolean z, h hVar) {
        kotlin.jvm.internal.h.e(gVar, "annotations");
        kotlin.jvm.internal.h.e(anVar, "constructor");
        kotlin.jvm.internal.h.e(list, "arguments");
        kotlin.jvm.internal.h.e(hVar, "memberScope");
        ae aeVar = new ae(anVar, list, z, hVar);
        if (gVar.isEmpty()) {
            return aeVar;
        }
        return new d(aeVar, gVar);
    }

    public static final ad a(g gVar, d dVar, List<? extends ap> list) {
        kotlin.jvm.internal.h.e(gVar, "annotations");
        kotlin.jvm.internal.h.e(dVar, "descriptor");
        kotlin.jvm.internal.h.e(list, "arguments");
        an bby = dVar.bby();
        kotlin.jvm.internal.h.d(bby, "descriptor.typeConstructor");
        return c(gVar, bby, list, false);
    }

    public static final ay a(ad adVar, ad adVar2) {
        kotlin.jvm.internal.h.e(adVar, "lowerBound");
        kotlin.jvm.internal.h.e(adVar2, "upperBound");
        if (kotlin.jvm.internal.h.E(adVar, adVar2)) {
            return adVar;
        }
        return new r(adVar, adVar2);
    }
}
