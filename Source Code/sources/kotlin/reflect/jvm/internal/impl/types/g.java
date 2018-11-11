package kotlin.reflect.jvm.internal.impl.types;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.types.checker.j;
import kotlin.reflect.jvm.internal.impl.types.checker.k;

/* compiled from: SpecialTypes.kt */
public final class g extends i implements f {
    public static final a eUx = new a();
    private final ad eUw;

    /* compiled from: SpecialTypes.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final g b(ay ayVar) {
            h.e(ayVar, Param.TYPE);
            if (ayVar instanceof g) {
                return (g) ayVar;
            }
            if (!c(ayVar)) {
                return null;
            }
            if (ayVar instanceof q) {
                q qVar = (q) ayVar;
                boolean E = h.E(qVar.byT().bwA(), qVar.byU().bwA());
                if (m.etY && !E) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("DefinitelyNotNullType for flexible type (");
                    stringBuilder.append(ayVar);
                    stringBuilder.append(") can be created only from type variable with the same constructor for bounds");
                    throw new AssertionError(stringBuilder.toString());
                }
            }
            return new g(t.aD(ayVar), null);
        }

        public final boolean c(ay ayVar) {
            h.e(ayVar, Param.TYPE);
            return kotlin.reflect.jvm.internal.impl.types.b.a.h(ayVar) && !k.eVA.f(ayVar);
        }
    }

    public boolean aYp() {
        return false;
    }

    private g(ad adVar) {
        this.eUw = adVar;
    }

    public /* synthetic */ g(ad adVar, f fVar) {
        this(adVar);
    }

    public final ad byN() {
        return this.eUw;
    }

    protected ad bhi() {
        return this.eUw;
    }

    public boolean bhW() {
        return (bhi().bwA() instanceof j) || (bhi().bwA().bbW() instanceof an);
    }

    public w ac(w wVar) {
        h.e(wVar, "replacement");
        return ag.d(wVar.bzc());
    }

    /* renamed from: l */
    public g h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        h.e(gVar, "newAnnotations");
        return new g(bhi().h(gVar));
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        return z ? bhi().gQ(z) : this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bhi());
        stringBuilder.append("!!");
        return stringBuilder.toString();
    }
}
