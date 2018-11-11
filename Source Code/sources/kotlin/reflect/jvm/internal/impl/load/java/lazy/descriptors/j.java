package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.storage.c;
import kotlin.reflect.jvm.internal.impl.storage.f;

/* compiled from: LazyJavaPackageScope.kt */
public final class j extends m {
    private final t eHM;
    private final f<Set<String>> eHN;
    private final c<a, d> eHO;
    private final h eHP;

    /* compiled from: LazyJavaPackageScope.kt */
    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.name.f eBW;
        private final g eHQ;

        public a(kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar) {
            h.e(fVar, "name");
            this.eBW = fVar;
            this.eHQ = gVar;
        }

        public final kotlin.reflect.jvm.internal.impl.name.f bdc() {
            return this.eBW;
        }

        public final g bgP() {
            return this.eHQ;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && h.E(this.eBW, ((a) obj).eBW);
        }

        public int hashCode() {
            return this.eBW.hashCode();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    private static abstract class b {

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class a extends b {
            private final d eDs;

            public a(d dVar) {
                h.e(dVar, "descriptor");
                super();
                this.eDs = dVar;
            }

            public final d aYX() {
                return this.eDs;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class b extends b {
            public static final b eHR = new b();

            private b() {
                super();
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class c extends b {
            public static final c eHS = new c();

            private c() {
                super();
            }
        }

        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    protected void a(Collection<ah> collection, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        h.e(collection, "result");
        h.e(fVar, "name");
    }

    /* renamed from: bgO */
    protected h bgJ() {
        return this.eHP;
    }

    public j(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, t tVar, h hVar2) {
        h.e(hVar, "c");
        h.e(tVar, "jPackage");
        h.e(hVar2, "ownerDescriptor");
        super(hVar);
        this.eHM = tVar;
        this.eHP = hVar2;
        this.eHN = hVar.baI().j(new LazyJavaPackageScope$knownClassNamesInPackage$1(this, hVar));
        this.eHO = hVar.baI().p(new LazyJavaPackageScope$classes$1(this, hVar));
    }

    private final b a(n nVar) {
        if (nVar == null) {
            return b.eHR;
        }
        if (nVar.bap().biM() != Kind.CLASS) {
            return c.eHS;
        }
        d e = bgT().bgq().bfX().e(nVar);
        return e != null ? new a(e) : b.eHR;
    }

    /* renamed from: e */
    public d c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        return a(fVar, null);
    }

    private final d a(kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar) {
        if (!kotlin.reflect.jvm.internal.impl.name.h.J(fVar)) {
            return null;
        }
        Set set = (Set) this.eHN.invoke();
        if (gVar != null || set == null || set.contains(fVar.asString())) {
            return (d) this.eHO.invoke(new a(fVar, gVar));
        }
        return null;
    }

    public final d c(g gVar) {
        h.e(gVar, "javaClass");
        return a(gVar.bdc(), gVar);
    }

    public Collection<ad> a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        return m.emptyList();
    }

    protected b bgF() {
        return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b.a.eHm;
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> d(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        if (!dVar.lR(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.eSd.bwY())) {
            return aj.emptySet();
        }
        Set<String> set = (Set) this.eHN.invoke();
        Collection hashSet;
        if (set != null) {
            hashSet = new HashSet();
            for (String mD : set) {
                hashSet.add(kotlin.reflect.jvm.internal.impl.name.f.mD(mD));
            }
            return (Set) hashSet;
        }
        kotlin.jvm.a.b bVar2;
        t tVar = this.eHM;
        if (bVar2 == null) {
            bVar2 = kotlin.reflect.jvm.internal.impl.utils.d.bzy();
        }
        Iterable<g> m = tVar.m(bVar2);
        hashSet = new LinkedHashSet();
        for (g gVar : m) {
            Object bdc = gVar.bhs() == LightClassOriginKind.SOURCE ? null : gVar.bdc();
            if (bdc != null) {
                hashSet.add(bdc);
            }
        }
        return (Set) hashSet;
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> c(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        return aj.emptySet();
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> e(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        return aj.emptySet();
    }

    public Collection<k> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        return a(dVar, (kotlin.jvm.a.b) bVar, (kotlin.reflect.jvm.internal.impl.incremental.components.b) NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
