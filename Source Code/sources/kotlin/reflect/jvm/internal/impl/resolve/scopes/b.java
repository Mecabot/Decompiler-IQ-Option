package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: ChainedMemberScope.kt */
public final class b implements h {
    public static final a eRA = new a();
    private final String debugName;
    private final List<h> eRz;

    /* compiled from: ChainedMemberScope.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b(String str, List<? extends h> list) {
        h.e(str, "debugName");
        h.e(list, "scopes");
        this.debugName = str;
        this.eRz = list;
    }

    public f c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        f fVar2 = (f) null;
        for (h c : this.eRz) {
            f c2 = c.c(fVar, bVar);
            if (c2 != null) {
                if (!(c2 instanceof g) || !((g) c2).bbO()) {
                    return c2;
                }
                if (fVar2 == null) {
                    fVar2 = c2;
                }
            }
        }
        return fVar2;
    }

    public Collection<ad> a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        List<h> list = this.eRz;
        if (list.isEmpty()) {
            return aj.emptySet();
        }
        Collection<ad> collection = (Collection) null;
        for (h a : list) {
            collection = kotlin.reflect.jvm.internal.impl.util.a.a.d(collection, a.a(fVar, bVar));
        }
        return collection != null ? collection : aj.emptySet();
    }

    public Collection<ah> b(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        List<h> list = this.eRz;
        if (list.isEmpty()) {
            return aj.emptySet();
        }
        Collection<ah> collection = (Collection) null;
        for (h b : list) {
            collection = kotlin.reflect.jvm.internal.impl.util.a.a.d(collection, b.b(fVar, bVar));
        }
        return collection != null ? collection : aj.emptySet();
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        List<h> list = this.eRz;
        if (list.isEmpty()) {
            return aj.emptySet();
        }
        Collection<k> collection = (Collection) null;
        for (h a : list) {
            collection = kotlin.reflect.jvm.internal.impl.util.a.a.d(collection, a.a(dVar, bVar));
        }
        return collection != null ? collection : aj.emptySet();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beC() {
        Collection linkedHashSet = new LinkedHashSet();
        for (h beC : this.eRz) {
            r.a(linkedHashSet, (Iterable) beC.beC());
        }
        return (Set) linkedHashSet;
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beD() {
        Collection linkedHashSet = new LinkedHashSet();
        for (h beD : this.eRz) {
            r.a(linkedHashSet, (Iterable) beD.beD());
        }
        return (Set) linkedHashSet;
    }

    public String toString() {
        return this.debugName;
    }
}
