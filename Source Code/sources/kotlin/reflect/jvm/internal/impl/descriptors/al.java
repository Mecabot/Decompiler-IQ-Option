package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: SupertypeLoopChecker.kt */
public interface al {

    /* compiled from: SupertypeLoopChecker.kt */
    public static final class a implements al {
        public static final a eAZ = new a();

        public Collection<w> a(an anVar, Collection<? extends w> collection, b<? super an, ? extends Iterable<? extends w>> bVar, b<? super w, l> bVar2) {
            h.e(anVar, "currentTypeConstructor");
            h.e(collection, "superTypes");
            h.e(bVar, "neighbors");
            h.e(bVar2, "reportLoop");
            return collection;
        }

        private a() {
        }
    }

    Collection<w> a(an anVar, Collection<? extends w> collection, b<? super an, ? extends Iterable<? extends w>> bVar, b<? super w, l> bVar2);
}
