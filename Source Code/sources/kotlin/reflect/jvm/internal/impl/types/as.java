package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;

/* compiled from: TypeSubstitution.kt */
public abstract class as {
    public static final as eVi = new b();
    public static final a eVj = new a();

    /* compiled from: TypeSubstitution.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: TypeSubstitution.kt */
    public static final class b extends as {
        public Void aO(w wVar) {
            h.e(wVar, "key");
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }

        b() {
        }

        public /* synthetic */ ap Z(w wVar) {
            return (ap) aO(wVar);
        }
    }

    public abstract ap Z(w wVar);

    public w a(w wVar, Variance variance) {
        h.e(wVar, "topLevelType");
        h.e(variance, "position");
        return wVar;
    }

    public boolean bwE() {
        return false;
    }

    public boolean byO() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public g m(g gVar) {
        h.e(gVar, "annotations");
        return gVar;
    }

    public final TypeSubstitutor bzh() {
        TypeSubstitutor e = TypeSubstitutor.e(this);
        h.d(e, "TypeSubstitutor.create(this)");
        return e;
    }
}
