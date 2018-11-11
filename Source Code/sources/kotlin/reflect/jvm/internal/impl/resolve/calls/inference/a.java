package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ak;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: CapturedTypeConstructor.kt */
public final class a extends ad implements ak {
    private final g eBt;
    private final ap eRg;
    private final b eRh;
    private final boolean eRi;

    public /* synthetic */ a(ap apVar, b bVar, boolean z, g gVar, int i, f fVar) {
        if ((i & 2) != 0) {
            bVar = new b(apVar);
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            gVar = g.eBF.bel();
        }
        this(apVar, bVar, z, gVar);
    }

    /* renamed from: bwz */
    public b bwA() {
        return this.eRh;
    }

    public boolean aYp() {
        return this.eRi;
    }

    public g bbQ() {
        return this.eBt;
    }

    public a(ap apVar, b bVar, boolean z, g gVar) {
        h.e(apVar, "typeProjection");
        h.e(bVar, "constructor");
        h.e(gVar, "annotations");
        this.eRg = apVar;
        this.eRh = bVar;
        this.eRi = z;
        this.eBt = gVar;
    }

    public List<ap> bdF() {
        return m.emptyList();
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h z = p.z("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        h.d(z, "ErrorUtils.createErrorSc…system resolution\", true)");
        return z;
    }

    public w bwx() {
        Variance variance = Variance.OUT_VARIANCE;
        ad baV = kotlin.reflect.jvm.internal.impl.types.b.a.bj(this).baV();
        h.d(baV, "builtIns.nullableAnyType");
        w b = b(variance, baV);
        h.d(b, "representative(OUT_VARIA…builtIns.nullableAnyType)");
        return b;
    }

    public w bwy() {
        Variance variance = Variance.IN_VARIANCE;
        ad baS = kotlin.reflect.jvm.internal.impl.types.b.a.bj(this).baS();
        h.d(baS, "builtIns.nothingType");
        w b = b(variance, baS);
        h.d(b, "representative(IN_VARIANCE, builtIns.nothingType)");
        return b;
    }

    private final w b(Variance variance, w wVar) {
        return this.eRg.bzf() == variance ? this.eRg.bai() : wVar;
    }

    public boolean at(w wVar) {
        h.e(wVar, Param.TYPE);
        return bwA() == wVar.bwA();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Captured(");
        stringBuilder.append(this.eRg);
        stringBuilder.append(')');
        stringBuilder.append(aYp() ? "?" : "");
        return stringBuilder.toString();
    }

    /* renamed from: hb */
    public a gQ(boolean z) {
        if (z == aYp()) {
            return this;
        }
        return new a(this.eRg, bwA(), z, bbQ());
    }

    /* renamed from: j */
    public a h(g gVar) {
        h.e(gVar, "newAnnotations");
        return new a(this.eRg, bwA(), aYp(), gVar);
    }
}
