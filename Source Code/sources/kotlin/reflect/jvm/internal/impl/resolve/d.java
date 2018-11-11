package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: inlineClassesUtils.kt */
public final class d {
    public static final aq K(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        h.e(dVar, "$receiver");
        aq aqVar = null;
        if (!dVar.bbN()) {
            return null;
        }
        c bbI = dVar.bbI();
        if (bbI != null) {
            List bcS = bbI.bcS();
            if (bcS != null) {
                aqVar = (aq) u.bZ(bcS);
            }
        }
        return aqVar;
    }

    public static final boolean N(k kVar) {
        h.e(kVar, "$receiver");
        return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && ((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar).bbN();
    }

    public static final aq ap(w wVar) {
        h.e(wVar, "$receiver");
        f bbW = wVar.bwA().bbW();
        if (!(bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            bbW = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
        return dVar != null ? K(dVar) : null;
    }

    public static final w aq(w wVar) {
        h.e(wVar, "$receiver");
        aq ap = ap(wVar);
        return ap != null ? ap.bai() : null;
    }

    public static final boolean ar(w wVar) {
        h.e(wVar, "$receiver");
        f bbW = wVar.bwA().bbW();
        return bbW != null ? N(bbW) : false;
    }

    public static final w as(w wVar) {
        h.e(wVar, "$receiver");
        aq ap = ap(wVar);
        w wVar2 = null;
        if (ap == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk = wVar.bbk();
        kotlin.reflect.jvm.internal.impl.name.f bdc = ap.bdc();
        h.d(bdc, "parameter.name");
        ad adVar = (ad) u.R(bbk.a(bdc, NoLookupLocation.FOR_ALREADY_TRACKED));
        if (adVar != null) {
            wVar2 = adVar.bai();
        }
        return wVar2;
    }
}
