package kotlin.reflect.jvm.internal.impl.load.kotlin;

import android.support.v4.app.FrameMetricsAggregator;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeMappingMode.kt */
public final class x {
    public static final x eKi = new x(false, false, false, false, false, null, false, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    public static final x eKj = new x(false, true, false, false, false, null, false, null, null, 509, null);
    public static final x eKk = new x(false, false, false, false, false, eKi, false, null, null, 476, null);
    public static final x eKl = new x(false, true, false, false, false, eKi, false, null, null, 476, null);
    public static final x eKm = new x(false, false, false, true, false, eKi, false, null, null, 471, null);
    public static final x eKn = new x(false, false, false, true, false, eKi, false, null, null, 407, null);
    public static final x eKo = new x(false, false, true, false, false, new x(false, false, true, false, false, eKi, false, null, null, 475, null), false, null, null, 472, null);
    public static final a eKp = new a();
    private final boolean eIl;
    private final boolean eKa;
    private final boolean eKb;
    private final boolean eKc;
    private final boolean eKd;
    private final x eKe;
    private final boolean eKf;
    private final x eKg;
    private final x eKh;

    /* compiled from: TypeMappingMode.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private x(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, x xVar, boolean z6, x xVar2, x xVar3) {
        this.eKa = z;
        this.eKb = z2;
        this.eIl = z3;
        this.eKc = z4;
        this.eKd = z5;
        this.eKe = xVar;
        this.eKf = z6;
        this.eKg = xVar2;
        this.eKh = xVar3;
    }

    public final boolean biG() {
        return this.eKa;
    }

    public final boolean biH() {
        return this.eKb;
    }

    public final boolean bhe() {
        return this.eIl;
    }

    /* synthetic */ x(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, x xVar, boolean z6, x xVar2, x xVar3, int i, f fVar) {
        int i2 = i;
        boolean z7 = (i2 & 1) != 0 ? true : z;
        boolean z8 = (i2 & 2) != 0 ? true : z2;
        boolean z9 = (i2 & 4) != 0 ? false : z3;
        boolean z10 = (i2 & 8) != 0 ? false : z4;
        boolean z11 = (i2 & 16) != 0 ? false : z5;
        x xVar4 = (i2 & 32) != 0 ? (x) null : xVar;
        this(z7, z8, z9, z10, z11, xVar4, (i2 & 64) != 0 ? true : z6, (i2 & 128) != 0 ? xVar4 : xVar2, (i2 & 256) != 0 ? xVar4 : xVar3);
    }

    public final boolean biI() {
        return this.eKf;
    }

    public final x a(Variance variance) {
        h.e(variance, "effectiveVariance");
        x thisR;
        switch (y.aoS[variance.ordinal()]) {
            case 1:
                thisR = this.eKg;
                if (thisR != null) {
                    return thisR;
                }
                break;
            case 2:
                thisR = this.eKh;
                if (thisR != null) {
                    return thisR;
                }
                break;
            default:
                thisR = this.eKe;
                if (thisR != null) {
                    return thisR;
                }
                break;
        }
        return this;
    }

    public final x biF() {
        return new x(this.eKa, true, this.eIl, this.eKc, this.eKd, this.eKe, this.eKf, this.eKg, this.eKh);
    }
}
