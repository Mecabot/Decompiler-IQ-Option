package kotlin.reflect.jvm.internal.impl.types;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.f;

/* compiled from: KotlinType.kt */
public abstract class q extends ay implements ak {
    private final ad eUM;
    private final ad eUN;

    public abstract String a(b bVar, f fVar);

    public boolean at(w wVar) {
        h.e(wVar, Param.TYPE);
        return false;
    }

    public abstract ad bhi();

    public final ad byT() {
        return this.eUM;
    }

    public final ad byU() {
        return this.eUN;
    }

    public q(ad adVar, ad adVar2) {
        h.e(adVar, "lowerBound");
        h.e(adVar2, "upperBound");
        super();
        this.eUM = adVar;
        this.eUN = adVar2;
    }

    public w bwx() {
        return this.eUM;
    }

    public w bwy() {
        return this.eUN;
    }

    public g bbQ() {
        return bhi().bbQ();
    }

    public an bwA() {
        return bhi().bwA();
    }

    public List<ap> bdF() {
        return bhi().bdF();
    }

    public boolean aYp() {
        return bhi().aYp();
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk() {
        return bhi().bbk();
    }

    public String toString() {
        return b.ePf.b(this);
    }
}
