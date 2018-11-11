package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.p;

/* compiled from: NewCapturedType.kt */
public final class d extends ad {
    private final g eBt;
    private final boolean eRi;
    private final CaptureStatus eVu;
    private final e eVv;
    private final ay eVw;

    /* renamed from: bzk */
    public e bwA() {
        return this.eVv;
    }

    public final ay bzl() {
        return this.eVw;
    }

    public /* synthetic */ d(CaptureStatus captureStatus, e eVar, ay ayVar, g gVar, boolean z, int i, f fVar) {
        if ((i & 8) != 0) {
            gVar = g.eBF.bel();
        }
        this(captureStatus, eVar, ayVar, gVar, (i & 16) != 0 ? false : z);
    }

    public g bbQ() {
        return this.eBt;
    }

    public boolean aYp() {
        return this.eRi;
    }

    public d(CaptureStatus captureStatus, e eVar, ay ayVar, g gVar, boolean z) {
        h.e(captureStatus, "captureStatus");
        h.e(eVar, "constructor");
        h.e(gVar, "annotations");
        this.eVu = captureStatus;
        this.eVv = eVar;
        this.eVw = ayVar;
        this.eBt = gVar;
        this.eRi = z;
    }

    public d(CaptureStatus captureStatus, ay ayVar, ap apVar) {
        h.e(captureStatus, "captureStatus");
        h.e(apVar, "projection");
        this(captureStatus, new e(apVar, null, 2, null), ayVar, null, false, 24, null);
    }

    public List<ap> bdF() {
        return m.emptyList();
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h z = p.z("No member resolution should be done on captured type!", true);
        h.d(z, "ErrorUtils.createErrorSc…on captured type!\", true)");
        return z;
    }

    /* renamed from: q */
    public d h(g gVar) {
        h.e(gVar, "newAnnotations");
        return new d(this.eVu, bwA(), this.eVw, gVar, aYp());
    }

    /* renamed from: hj */
    public d gQ(boolean z) {
        return new d(this.eVu, bwA(), this.eVw, bbQ(), z);
    }
}
