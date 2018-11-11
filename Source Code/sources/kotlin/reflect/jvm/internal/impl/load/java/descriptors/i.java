package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: util.kt */
public final class i {
    private final boolean eGw;
    private final w ewu;

    public i(w wVar, boolean z) {
        h.e(wVar, Param.TYPE);
        this.ewu = wVar;
        this.eGw = z;
    }

    public final w bai() {
        return this.ewu;
    }

    public final boolean bfT() {
        return this.eGw;
    }
}
