package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: MemberScope.kt */
public interface h extends j {
    public static final a eSi = a.eSk;

    /* compiled from: MemberScope.kt */
    public static final class a {
        private static final kotlin.jvm.a.b<f, Boolean> eSj = MemberScope$Companion$ALL_NAME_FILTER$1.eSl;
        static final /* synthetic */ a eSk = new a();

        private a() {
        }

        public final kotlin.jvm.a.b<f, Boolean> bxi() {
            return eSj;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class b {
        public static void a(h hVar, f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            kotlin.jvm.internal.h.e(fVar, "name");
            kotlin.jvm.internal.h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a.a(hVar, fVar, bVar);
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class c extends i {
        public static final c eSm = new c();

        private c() {
        }

        public Set<f> beC() {
            return aj.emptySet();
        }

        public Set<f> beD() {
            return aj.emptySet();
        }
    }

    Collection<ad> a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar);

    Collection<ah> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar);

    Set<f> beC();

    Set<f> beD();
}
