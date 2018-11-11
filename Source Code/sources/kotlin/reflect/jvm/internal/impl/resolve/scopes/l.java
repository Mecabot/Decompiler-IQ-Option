package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ak;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* compiled from: SubstitutingScope.kt */
public final class l implements h {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(l.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    private final h eSg;
    private final TypeSubstitutor eSo;
    private Map<k, k> eSp;
    private final d eSq = g.f(new SubstitutingScope$_allDescriptors$2(this));

    private final Collection<k> bxk() {
        d dVar = this.eSq;
        j jVar = apP[0];
        return (Collection) dVar.getValue();
    }

    public l(h hVar, TypeSubstitutor typeSubstitutor) {
        h.e(hVar, "workerScope");
        h.e(typeSubstitutor, "givenSubstitutor");
        this.eSg = hVar;
        as bzi = typeSubstitutor.bzi();
        h.d(bzi, "givenSubstitutor.substitution");
        this.eSo = c.a(bzi, false, 1, null).bzh();
    }

    private final <D extends k> D U(D d) {
        if (this.eSo.isEmpty()) {
            return d;
        }
        if (this.eSp == null) {
            this.eSp = new HashMap();
        }
        Map map = this.eSp;
        if (map == null) {
            h.aXZ();
        }
        Object obj = map.get(d);
        if (obj == null) {
            StringBuilder stringBuilder;
            if (d instanceof ak) {
                kotlin.reflect.jvm.internal.impl.descriptors.l f = ((ak) d).f(this.eSo);
                if (f != null) {
                    obj = f;
                    map.put(d, obj);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, ");
                    stringBuilder.append("but ");
                    stringBuilder.append(d);
                    stringBuilder.append(" substitution fails");
                    throw new AssertionError(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown descriptor in scope: ");
            stringBuilder.append(d);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        k kVar = (k) obj;
        if (kVar != null) {
            return kVar;
        }
        throw new TypeCastException("null cannot be cast to non-null type D");
    }

    private final <D extends k> Collection<D> W(Collection<? extends D> collection) {
        if (this.eSo.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet mc = a.mc(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            mc.add(U((k) it.next()));
        }
        return mc;
    }

    public Collection<ad> a(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return W(this.eSg.a(fVar, bVar));
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        kotlin.reflect.jvm.internal.impl.descriptors.f c = this.eSg.c(fVar, bVar);
        return c != null ? (kotlin.reflect.jvm.internal.impl.descriptors.f) U(c) : null;
    }

    public Collection<ah> b(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return W(this.eSg.b(fVar, bVar));
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        return bxk();
    }

    public Set<f> beC() {
        return this.eSg.beC();
    }

    public Set<f> beD() {
        return this.eSg.beD();
    }
}
