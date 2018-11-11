package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;
import kotlin.reflect.jvm.internal.impl.util.a.a;

/* compiled from: JvmPackageScope.kt */
public final class d implements h {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h eGT;
    private final j eHn;
    private final e eHo = this.eGT.baI().i(new JvmPackageScope$kotlinScopes$2(this));
    private final h eHp;

    private final List<h> bgy() {
        return (List) g.a(this.eHo, (Object) this, apP[0]);
    }

    public d(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, t tVar, h hVar2) {
        kotlin.jvm.internal.h.e(hVar, "c");
        kotlin.jvm.internal.h.e(tVar, "jPackage");
        kotlin.jvm.internal.h.e(hVar2, "packageFragment");
        this.eGT = hVar;
        this.eHp = hVar2;
        this.eHn = new j(this.eGT, tVar, this.eHp);
    }

    public final j bgx() {
        return this.eHn;
    }

    public f c(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        kotlin.reflect.jvm.internal.impl.descriptors.d e = this.eHn.c(fVar, bVar);
        if (e != null) {
            return e;
        }
        f fVar2 = (f) null;
        for (h c : bgy()) {
            f c2 = c.c(fVar, bVar);
            if (c2 != null) {
                if (!(c2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) || !((kotlin.reflect.jvm.internal.impl.descriptors.g) c2).bbO()) {
                    fVar2 = c2;
                    break;
                } else if (fVar2 == null) {
                    fVar2 = c2;
                }
            }
        }
        return fVar2;
    }

    public Collection<ad> a(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        j jVar = this.eHn;
        List<h> bgy = bgy();
        Collection<ad> a = jVar.a(fVar, bVar);
        for (h a2 : bgy) {
            a = a.d(a, a2.a(fVar, bVar));
        }
        return a != null ? a : aj.emptySet();
    }

    public Collection<ah> b(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        j jVar = this.eHn;
        List<h> bgy = bgy();
        Collection<ah> b = jVar.b(fVar, bVar);
        for (h b2 : bgy) {
            b = a.d(b, b2.b(fVar, bVar));
        }
        return b != null ? b : aj.emptySet();
    }

    public Collection<k> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        kotlin.jvm.internal.h.e(bVar, "nameFilter");
        j jVar = this.eHn;
        List<h> bgy = bgy();
        Collection<k> a = jVar.a(dVar, bVar);
        for (h a2 : bgy) {
            a = a.d(a, a2.a(dVar, bVar));
        }
        return a != null ? a : aj.emptySet();
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beC() {
        Collection linkedHashSet = new LinkedHashSet();
        for (h beC : bgy()) {
            r.a(linkedHashSet, (Iterable) beC.beC());
        }
        Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) linkedHashSet;
        set.addAll(this.eHn.beC());
        return set;
    }

    public Set<kotlin.reflect.jvm.internal.impl.name.f> beD() {
        Collection linkedHashSet = new LinkedHashSet();
        for (h beD : bgy()) {
            r.a(linkedHashSet, (Iterable) beD.beD());
        }
        Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) linkedHashSet;
        set.addAll(this.eHn.beD());
        return set;
    }

    public void d(kotlin.reflect.jvm.internal.impl.name.f fVar, b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        kotlin.reflect.jvm.internal.impl.incremental.a.a(this.eGT.bgq().bgf(), bVar, (x) this.eHp, fVar);
    }
}
