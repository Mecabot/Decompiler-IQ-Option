package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.as;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.utils.d;

/* compiled from: MemberScopeImpl.kt */
public abstract class i implements h {
    public f c(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return null;
    }

    public void d(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        h.b.a(this, fVar, bVar);
    }

    public Collection<ad> a(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return m.emptyList();
    }

    public Collection<ah> b(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return m.emptyList();
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        return m.emptyList();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beC() {
        Collection arrayList = new ArrayList();
        for (Object next : a(d.eRY, d.bzy())) {
            if (next instanceof ah) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (ah bdc : (List) arrayList) {
            linkedHashSet.add(bdc.bdc());
        }
        return (Set) linkedHashSet;
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beD() {
        Collection arrayList = new ArrayList();
        for (Object next : a(d.eRZ, d.bzy())) {
            if (next instanceof as) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (as bdc : (List) arrayList) {
            linkedHashSet.add(bdc.bdc());
        }
        return (Set) linkedHashSet;
    }
}
