package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: TypeSubstitution.kt */
public final class at {
    public static final w a(w wVar, List<? extends ap> list, g gVar) {
        h.e(wVar, "$receiver");
        h.e(list, "newArguments");
        h.e(gVar, "newAnnotations");
        if ((list.isEmpty() || list == wVar.bdF()) && gVar == wVar.bbQ()) {
            return wVar;
        }
        ay bzc = wVar.bzc();
        if (bzc instanceof q) {
            q qVar = (q) bzc;
            wVar = x.a(a(qVar.byT(), (List) list, gVar), a(qVar.byU(), (List) list, gVar));
        } else if (bzc instanceof ad) {
            wVar = a((ad) bzc, (List) list, gVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return wVar;
    }

    public static final ad a(ad adVar, List<? extends ap> list, g gVar) {
        h.e(adVar, "$receiver");
        h.e(list, "newArguments");
        h.e(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == adVar.bbQ()) {
            return adVar;
        }
        if (list.isEmpty()) {
            return adVar.h(gVar);
        }
        return x.c(gVar, adVar.bwA(), list, adVar.aYp());
    }

    public static final ad aP(w wVar) {
        h.e(wVar, "$receiver");
        ay bzc = wVar.bzc();
        if (!(bzc instanceof ad)) {
            bzc = null;
        }
        ad adVar = (ad) bzc;
        if (adVar != null) {
            return adVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This is should be simple type: ");
        stringBuilder.append(wVar);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }
}
