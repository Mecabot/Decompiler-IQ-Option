package kotlin.reflect.jvm.internal.impl.types.checker;

import com.iqoption.fragment.cashbox.deppage.a;
import com.iqoption.fragment.cashbox.deppage.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.q;

/* compiled from: NewKotlinTypeChecker.kt */
public final class l {
    public static final l eVB = new l();

    private l() {
    }

    public final boolean a(ay ayVar, ay ayVar2) {
        h.e(ayVar, a.TAG);
        h.e(ayVar2, b.TAG);
        boolean z = true;
        if (ayVar == ayVar2) {
            return true;
        }
        if ((ayVar instanceof ad) && (ayVar2 instanceof ad)) {
            return c((ad) ayVar, (ad) ayVar2);
        }
        if (!(ayVar instanceof q) || !(ayVar2 instanceof q)) {
            return false;
        }
        q qVar = (q) ayVar;
        q qVar2 = (q) ayVar2;
        if (!(c(qVar.byT(), qVar2.byT()) && c(qVar.byU(), qVar2.byU()))) {
            z = false;
        }
        return z;
    }

    public final boolean c(ad adVar, ad adVar2) {
        h.e(adVar, a.TAG);
        h.e(adVar2, b.TAG);
        if (adVar.aYp() != adVar2.aYp() || ag.aI(adVar) != ag.aI(adVar2) || (h.E(adVar.bwA(), adVar2.bwA()) ^ 1) != 0 || adVar.bdF().size() != adVar2.bdF().size()) {
            return false;
        }
        if (adVar.bdF() == adVar2.bdF()) {
            return true;
        }
        int size = adVar.bdF().size();
        for (int i = 0; i < size; i++) {
            ap apVar = (ap) adVar.bdF().get(i);
            ap apVar2 = (ap) adVar2.bdF().get(i);
            if (apVar.bze() != apVar2.bze()) {
                return false;
            }
            if (!apVar.bze() && (apVar.bzf() != apVar2.bzf() || !a(apVar.bai().bzc(), apVar2.bai().bzc()))) {
                return false;
            }
        }
        return true;
    }
}
