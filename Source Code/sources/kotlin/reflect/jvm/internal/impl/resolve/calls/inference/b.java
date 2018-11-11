package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: CapturedTypeConstructor.kt */
public final class b implements an {
    private final ap eRg;
    private e eRj;

    public boolean bbY() {
        return false;
    }

    public Void bwC() {
        return null;
    }

    public b(ap apVar) {
        h.e(apVar, "typeProjection");
        this.eRg = apVar;
        Object obj = this.eRg.bzf() != Variance.INVARIANT ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Only nontrivial projections can be captured, not: ");
            stringBuilder.append(this.eRg);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public /* synthetic */ f bbW() {
        return (f) bwC();
    }

    public final ap bwD() {
        return this.eRg;
    }

    public final void a(e eVar) {
        this.eRj = eVar;
    }

    public final e bwB() {
        return this.eRj;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> getParameters() {
        return m.emptyList();
    }

    public Collection<w> beu() {
        Object bai;
        if (this.eRg.bzf() == Variance.OUT_VARIANCE) {
            bai = this.eRg.bai();
        } else {
            bai = bdy().baV();
        }
        return l.cr(bai);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedTypeConstructor(");
        stringBuilder.append(this.eRg);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public g bdy() {
        g bdy = this.eRg.bai().bwA().bdy();
        h.d(bdy, "typeProjection.type.constructor.builtIns");
        return bdy;
    }
}
