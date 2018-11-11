package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: typeSignatureMapping.kt */
public class h<T> {
    private int eJJ;
    private T eJK;
    private final k<T> eJL;

    public void bit() {
    }

    public void bis() {
        if (this.eJK == null) {
            this.eJJ++;
            int i = this.eJJ;
        }
    }

    public void cR(T t) {
        kotlin.jvm.internal.h.e(t, "objectType");
        cS(t);
    }

    protected final void cS(T t) {
        kotlin.jvm.internal.h.e(t, Param.TYPE);
        if (this.eJK == null) {
            k kVar = this.eJL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(u.l("[", this.eJJ));
            stringBuilder.append(this.eJL.toString(t));
            this.eJK = kVar.mq(stringBuilder.toString());
        }
    }

    public void c(f fVar, T t) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(t, Param.TYPE);
        cS(t);
    }
}
