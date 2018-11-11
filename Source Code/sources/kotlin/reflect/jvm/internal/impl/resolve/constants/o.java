package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class o extends f<w> {
    private final w ewu;

    public o(w wVar) {
        h.e(wVar, Param.TYPE);
        super(wVar);
        this.ewu = wVar;
    }

    public w h(u uVar) {
        h.e(uVar, "module");
        return this.ewu;
    }

    /* renamed from: bwH */
    public w getValue() {
        w bai = ((ap) u.bY(this.ewu.bdF())).bai();
        h.d(bai, "type.arguments.single().type");
        return bai;
    }
}
