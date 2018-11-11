package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: AbstractScopeAdapter.kt */
public abstract class a implements h {
    protected abstract h bwL();

    public Collection<ah> b(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return bwL().b(fVar, bVar);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return bwL().c(fVar, bVar);
    }

    public Collection<ad> a(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return bwL().a(fVar, bVar);
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        return bwL().a(dVar, bVar);
    }

    public Set<f> beC() {
        return bwL().beC();
    }

    public Set<f> beD() {
        return bwL().beD();
    }
}
