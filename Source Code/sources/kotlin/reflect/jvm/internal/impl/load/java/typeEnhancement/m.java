package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: typeEnhancement.kt */
final class m extends i {
    private final ad eJe;

    public m(ad adVar, int i, boolean z) {
        h.e(adVar, Param.TYPE);
        super(adVar, i, z);
        this.eJe = adVar;
    }

    /* renamed from: bfN */
    public ad bai() {
        return this.eJe;
    }
}
