package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;

/* compiled from: InnerClassesScopeWrapper.kt */
public final class f extends i {
    private final h eSg;

    public f(h hVar) {
        h.e(hVar, "workerScope");
        this.eSg = hVar;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        kotlin.reflect.jvm.internal.impl.descriptors.f c = this.eSg.c(fVar, bVar);
        if (c == null) {
            return null;
        }
        d dVar = (d) (!(c instanceof d) ? null : c);
        if (dVar != null) {
            return dVar;
        }
        if (!(c instanceof am)) {
            c = null;
        }
        return (am) c;
    }

    /* renamed from: f */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f> a(d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        dVar = dVar.lS(d.eSd.bxf());
        if (dVar == null) {
            return m.emptyList();
        }
        Iterable a = this.eSg.a(dVar, bVar);
        Collection arrayList = new ArrayList();
        for (Object next : a) {
            if (next instanceof g) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beC() {
        return this.eSg.beC();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beD() {
        return this.eSg.beD();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classes from ");
        stringBuilder.append(this.eSg);
        return stringBuilder.toString();
    }
}
