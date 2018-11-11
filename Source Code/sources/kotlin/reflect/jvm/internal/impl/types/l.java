package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
public final class l extends as {
    public static final a eUA = new a();
    private final as eUy;
    private final as eUz;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final as a(as asVar, as asVar2) {
            h.e(asVar, "first");
            h.e(asVar2, "second");
            if (asVar.isEmpty()) {
                return asVar2;
            }
            if (asVar2.isEmpty()) {
                return asVar;
            }
            return new l(asVar, asVar2, null);
        }
    }

    public static final as a(as asVar, as asVar2) {
        return eUA.a(asVar, asVar2);
    }

    public boolean isEmpty() {
        return false;
    }

    public /* synthetic */ l(as asVar, as asVar2, f fVar) {
        this(asVar, asVar2);
    }

    private l(as asVar, as asVar2) {
        this.eUy = asVar;
        this.eUz = asVar2;
    }

    public ap Z(w wVar) {
        h.e(wVar, "key");
        ap Z = this.eUy.Z(wVar);
        return Z != null ? Z : this.eUz.Z(wVar);
    }

    public w a(w wVar, Variance variance) {
        h.e(wVar, "topLevelType");
        h.e(variance, "position");
        return this.eUz.a(this.eUy.a(wVar, variance), variance);
    }

    public boolean byO() {
        return this.eUy.byO() || this.eUz.byO();
    }

    public boolean bwE() {
        return this.eUy.bwE() || this.eUz.bwE();
    }

    public g m(g gVar) {
        h.e(gVar, "annotations");
        return this.eUz.m(this.eUy.m(gVar));
    }
}
