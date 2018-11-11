package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeclaredMemberIndex.kt */
public interface b {

    /* compiled from: DeclaredMemberIndex.kt */
    public static final class a implements b {
        public static final a eHm = new a();

        public n s(f fVar) {
            h.e(fVar, "name");
            return null;
        }

        private a() {
        }

        /* renamed from: t */
        public List<q> r(f fVar) {
            h.e(fVar, "name");
            return m.emptyList();
        }

        public Set<f> bgv() {
            return aj.emptySet();
        }

        public Set<f> bgw() {
            return aj.emptySet();
        }
    }

    Set<f> bgv();

    Set<f> bgw();

    Collection<q> r(f fVar);

    n s(f fVar);
}
