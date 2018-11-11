package kotlin.reflect.jvm.internal.impl.types;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.storage.e;

/* compiled from: AbstractTypeConstructor.kt */
public abstract class c implements an {
    private final e<a> eUs;

    /* compiled from: AbstractTypeConstructor.kt */
    private static final class a {
        private List<? extends w> eUt = l.cr(p.eUE);
        private final Collection<w> eUu;

        public a(Collection<? extends w> collection) {
            h.e(collection, "allSupertypes");
            this.eUu = collection;
        }

        public final Collection<w> byL() {
            return this.eUu;
        }

        public final List<w> byK() {
            return this.eUt;
        }

        public final void cm(List<? extends w> list) {
            h.e(list, "<set-?>");
            this.eUt = list;
        }
    }

    protected void P(w wVar) {
        h.e(wVar, Param.TYPE);
    }

    protected void ax(w wVar) {
        h.e(wVar, Param.TYPE);
    }

    protected abstract Collection<w> bbU();

    protected abstract al bbZ();

    protected w bex() {
        return null;
    }

    public c(kotlin.reflect.jvm.internal.impl.storage.h hVar) {
        h.e(hVar, "storageManager");
        this.eUs = hVar.a(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.eUv, new AbstractTypeConstructor$supertypes$3(this));
    }

    /* renamed from: byJ */
    public List<w> beu() {
        return ((a) this.eUs.invoke()).byK();
    }

    private final Collection<w> a(an anVar, boolean z) {
        c cVar = (c) (!(anVar instanceof c) ? null : anVar);
        if (cVar != null) {
            List b = u.b(((a) cVar.eUs.invoke()).byL(), (Iterable) cVar.hg(z));
            if (b != null) {
                return b;
            }
        }
        Collection<w> beu = anVar.beu();
        h.d(beu, "supertypes");
        return beu;
    }

    protected Collection<w> hg(boolean z) {
        return m.emptyList();
    }
}
