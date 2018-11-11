package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.iqoption.fragment.cashbox.deppage.b;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.at;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* compiled from: TypeCheckerContext.kt */
public class TypeCheckerContext {
    private int eVD;
    private boolean eVE;
    private ArrayDeque<ad> eVF;
    private Set<ad> eVG;
    private final boolean eVH;
    private final boolean eVI;

    /* compiled from: TypeCheckerContext.kt */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* compiled from: TypeCheckerContext.kt */
    public enum SeveralSupertypesWithSameConstructorPolicy {
        TAKE_FIRST_FOR_SUBTYPING,
        FORCE_NOT_SUBTYPE,
        CHECK_ANY_OF_THEM,
        INTERSECT_ARGUMENTS_AND_CHECK_AGAIN
    }

    /* compiled from: TypeCheckerContext.kt */
    public static abstract class a {

        /* compiled from: TypeCheckerContext.kt */
        public static final class a extends a {
            public static final a eVJ = new a();

            private a() {
                super();
            }

            public ad bg(w wVar) {
                h.e(wVar, Param.TYPE);
                return t.aD(wVar);
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class b extends a {
            private final TypeSubstitutor eSo;

            public b(TypeSubstitutor typeSubstitutor) {
                h.e(typeSubstitutor, "substitutor");
                super();
                this.eSo = typeSubstitutor;
            }

            public ad bg(w wVar) {
                h.e(wVar, Param.TYPE);
                wVar = this.eSo.b((w) t.aD(wVar), Variance.INVARIANT);
                h.d(wVar, "substitutor.safeSubstitu…le(), Variance.INVARIANT)");
                return at.aP(wVar);
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class c extends a {
            public static final c eVK = new c();

            private c() {
                super();
            }

            public /* synthetic */ ad bg(w wVar) {
                return (ad) bh(wVar);
            }

            public Void bh(w wVar) {
                h.e(wVar, Param.TYPE);
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: TypeCheckerContext.kt */
        public static final class d extends a {
            public static final d eVL = new d();

            private d() {
                super();
            }

            public ad bg(w wVar) {
                h.e(wVar, Param.TYPE);
                return t.aE(wVar);
            }
        }

        public abstract ad bg(w wVar);

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public Boolean b(ay ayVar, ay ayVar2) {
        h.e(ayVar, "subType");
        h.e(ayVar2, "superType");
        return null;
    }

    public TypeCheckerContext(boolean z, boolean z2) {
        this.eVH = z;
        this.eVI = z2;
    }

    public /* synthetic */ TypeCheckerContext(boolean z, boolean z2, int i, f fVar) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        this(z, z2);
    }

    public final boolean bzo() {
        return this.eVH;
    }

    public boolean d(an anVar, an anVar2) {
        h.e(anVar, com.iqoption.fragment.cashbox.deppage.a.TAG);
        h.e(anVar2, b.TAG);
        return h.E(anVar, anVar2);
    }

    public LowerCapturedTypePolicy a(ad adVar, d dVar) {
        h.e(adVar, "subType");
        h.e(dVar, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public SeveralSupertypesWithSameConstructorPolicy bzn() {
        return SeveralSupertypesWithSameConstructorPolicy.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN;
    }

    private final void initialize() {
        int i = this.eVE ^ 1;
        if (m.etY && i == 0) {
            throw new AssertionError("Assertion failed");
        }
        this.eVE = true;
        if (this.eVF == null) {
            this.eVF = new ArrayDeque(4);
        }
        if (this.eVG == null) {
            this.eVG = i.eXR.bzH();
        }
    }

    private final void clear() {
        ArrayDeque arrayDeque = this.eVF;
        if (arrayDeque == null) {
            h.aXZ();
        }
        arrayDeque.clear();
        Set set = this.eVG;
        if (set == null) {
            h.aXZ();
        }
        set.clear();
        this.eVE = false;
    }

    public final boolean g(ay ayVar) {
        h.e(ayVar, "$receiver");
        return this.eVI && (ayVar.bwA() instanceof j);
    }
}
