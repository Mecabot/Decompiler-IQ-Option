package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: ResolutionScope.kt */
public interface j {

    /* compiled from: ResolutionScope.kt */
    public static final class a {
        public static /* synthetic */ Collection a(j jVar, d dVar, b bVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i & 1) != 0) {
                dVar = d.eRR;
            }
            if ((i & 2) != 0) {
                bVar = h.eSi.bxi();
            }
            return jVar.a(dVar, bVar);
        }

        public static void a(j jVar, f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            h.e(fVar, "name");
            h.e(bVar, FirebaseAnalytics.b.LOCATION);
            jVar.b(fVar, bVar);
        }
    }

    Collection<k> a(d dVar, b<? super f, Boolean> bVar);

    Collection<r> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar);

    kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar);
}
