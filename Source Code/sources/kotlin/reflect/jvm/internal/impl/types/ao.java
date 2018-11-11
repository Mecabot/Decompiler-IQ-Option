package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;

/* compiled from: TypeSubstitution.kt */
public abstract class ao extends as {
    public static final a eVe = new a();

    /* compiled from: TypeSubstitution.kt */
    public static final class a {

        /* compiled from: TypeSubstitution.kt */
        public static final class a extends ao {
            final /* synthetic */ Map eVf;
            final /* synthetic */ boolean eVg;

            a(Map map, boolean z) {
                this.eVf = map;
                this.eVg = z;
            }

            public ap d(an anVar) {
                h.e(anVar, "key");
                return (ap) this.eVf.get(anVar);
            }

            public boolean isEmpty() {
                return this.eVf.isEmpty();
            }

            public boolean byO() {
                return this.eVg;
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* synthetic */ ao a(a aVar, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.b(map, z);
        }

        public final ao b(Map<an, ? extends ap> map, boolean z) {
            h.e(map, "map");
            return new a(map, z);
        }

        public final as aN(w wVar) {
            h.e(wVar, "kotlinType");
            return b(wVar.bwA(), wVar.bdF());
        }

        public final as b(an anVar, List<? extends ap> list) {
            h.e(anVar, "typeConstructor");
            h.e(list, "arguments");
            List parameters = anVar.getParameters();
            h.d(parameters, "parameters");
            an anVar2 = (an) u.bX(parameters);
            if (!(anVar2 != null ? anVar2.bcX() : false)) {
                return new u(parameters, list);
            }
            a aVar = this;
            List parameters2 = anVar.getParameters();
            h.d(parameters2, "typeConstructor.parameters");
            Iterable<an> iterable = parameters2;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (an anVar3 : iterable) {
                h.d(anVar3, "it");
                arrayList.add(anVar3.bby());
            }
            return a(aVar, ad.ae(u.f((Iterable) (List) arrayList, (Iterable) list)), false, 2, null);
        }
    }

    public static final ao O(Map<an, ? extends ap> map) {
        return a.a(eVe, map, false, 2, null);
    }

    public static final as b(an anVar, List<? extends ap> list) {
        return eVe.b(anVar, (List) list);
    }

    public abstract ap d(an anVar);

    public ap Z(w wVar) {
        h.e(wVar, "key");
        return d(wVar.bwA());
    }
}
