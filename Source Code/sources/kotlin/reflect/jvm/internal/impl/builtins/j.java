package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.m;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.v;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: suspendFunctionTypes.kt */
public final class j {
    private static final v ezC;
    private static final v ezD;

    public static final v bbp() {
        return ezC;
    }

    static {
        u byQ = p.byQ();
        h.d(byQ, "ErrorUtils.getErrorModule()");
        b bVar = c.eQG;
        h.d(bVar, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
        v vVar = new v(new m(byQ, bVar), ClassKind.INTERFACE, false, false, c.eQI.btN(), ai.eAX, LockBasedStorageManager.eUc);
        vVar.c(Modality.ABSTRACT);
        vVar.d(au.eBg);
        vVar.cf(l.cr(ag.a(vVar, g.eBF.bel(), false, Variance.IN_VARIANCE, f.mD("T"), 0)));
        vVar.beY();
        ezC = vVar;
        u byQ2 = p.byQ();
        h.d(byQ2, "ErrorUtils.getErrorModule()");
        b bVar2 = c.eQF;
        h.d(bVar2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
        v vVar2 = new v(new m(byQ2, bVar2), ClassKind.INTERFACE, false, false, c.eQJ.btN(), ai.eAX, LockBasedStorageManager.eUc);
        vVar2.c(Modality.ABSTRACT);
        vVar2.d(au.eBg);
        vVar2.cf(l.cr(ag.a(vVar2, g.eBF.bel(), false, Variance.IN_VARIANCE, f.mD("T"), 0)));
        vVar2.beY();
        ezD = vVar2;
    }

    public static final v bbq() {
        return ezD;
    }

    public static final ad a(w wVar, boolean z) {
        h.e(wVar, "suspendFunType");
        boolean d = f.d(wVar);
        if (!kotlin.m.etY || d) {
            an bby;
            g bj = a.bj(wVar);
            g bbQ = wVar.bbQ();
            w h = f.h(wVar);
            Iterable<ap> j = f.j(wVar);
            Collection arrayList = new ArrayList(n.e(j, 10));
            for (ap bai : j) {
                arrayList.add(bai.bai());
            }
            arrayList = (List) arrayList;
            g bel = g.eBF.bel();
            if (z) {
                bby = ezD.bby();
            } else {
                bby = ezC.bby();
            }
            h.d(bby, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
            List i = u.i(arrayList, (Object) x.c(bel, bby, l.cr(a.bk(f.i(wVar))), false));
            ad baV = a.bj(wVar).baV();
            h.d(baV, "suspendFunType.builtIns.nullableAnyType");
            return f.a(bj, bbQ, h, i, null, baV, false, 64, null).gQ(wVar.aYp());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This type should be suspend function type: ");
        stringBuilder.append(wVar);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final boolean a(b bVar, boolean z) {
        if (z) {
            return h.E(bVar, c.eQJ);
        }
        return h.E(bVar, c.eQI);
    }
}
