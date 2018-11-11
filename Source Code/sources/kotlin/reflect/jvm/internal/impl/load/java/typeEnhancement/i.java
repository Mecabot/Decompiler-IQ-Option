package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: typeEnhancement.kt */
class i {
    private final int eIN;
    private final boolean eIO;
    private final w ewu;

    public i(w wVar, int i, boolean z) {
        h.e(wVar, Param.TYPE);
        this.ewu = wVar;
        this.eIN = i;
        this.eIO = z;
    }

    public w bai() {
        return this.ewu;
    }

    public final int big() {
        return this.eIN;
    }

    public final boolean bih() {
        return this.eIO;
    }

    public final w bif() {
        return this.eIO ? bai() : null;
    }
}
