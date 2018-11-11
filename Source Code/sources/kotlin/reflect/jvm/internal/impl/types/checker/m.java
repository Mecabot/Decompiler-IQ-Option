package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: utils.kt */
final class m {
    private final m eVC;
    private final w ewu;

    public m(w wVar, m mVar) {
        h.e(wVar, Param.TYPE);
        this.ewu = wVar;
        this.eVC = mVar;
    }

    public final w bai() {
        return this.ewu;
    }

    public final m bzm() {
        return this.eVC;
    }
}
