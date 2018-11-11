package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.types.an;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class l extends m {
    private final f eHZ;
    private final g eHk;

    /* compiled from: LazyJavaStaticClassScope.kt */
    static final class a<N> implements kotlin.reflect.jvm.internal.impl.utils.b.b<N> {
        public static final a eIc = new a();

        a() {
        }

        /* renamed from: B */
        public final Iterable<d> cK(d dVar) {
            h.d(dVar, "it");
            an bby = dVar.bby();
            h.d(bby, "it.typeConstructor");
            Collection beu = bby.beu();
            h.d(beu, "it.typeConstructor.supertypes");
            return m.j(m.g(u.ac(beu), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1$1.eId));
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    public static final class b extends kotlin.reflect.jvm.internal.impl.utils.b.a<d, kotlin.l> {
        final /* synthetic */ d eIe;
        final /* synthetic */ Set eIf;
        final /* synthetic */ kotlin.jvm.a.b eIg;

        public void bgZ() {
        }

        b(d dVar, Set set, kotlin.jvm.a.b bVar) {
            this.eIe = dVar;
            this.eIf = set;
            this.eIg = bVar;
        }

        public /* synthetic */ Object bcM() {
            bgZ();
            return kotlin.l.etX;
        }

        /* renamed from: r */
        public boolean cL(d dVar) {
            h.e(dVar, "current");
            if (dVar == this.eIe) {
                return true;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbx = dVar.bbx();
            if (!(bbx instanceof m)) {
                return true;
            }
            this.eIf.addAll((Collection) this.eIg.invoke(bbx));
            return false;
        }
    }

    public f c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        return null;
    }

    /* renamed from: bgY */
    protected f bgJ() {
        return this.eHZ;
    }

    public l(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, g gVar, f fVar) {
        h.e(hVar, "c");
        h.e(gVar, "jClass");
        h.e(fVar, "ownerDescriptor");
        super(hVar);
        this.eHk = gVar;
        this.eHZ = fVar;
    }

    /* renamed from: bgE */
    protected a bgF() {
        return new a(this.eHk, LazyJavaStaticClassScope$computeMemberIndex$1.eIa);
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> c(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        Set<kotlin.reflect.jvm.internal.impl.name.f> ab = u.ab(((b) bgQ().invoke()).bgv());
        l z = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.z(bgJ());
        Set beC = z != null ? z.beC() : null;
        if (beC == null) {
            beC = aj.emptySet();
        }
        ab.addAll(beC);
        if (this.eHk.isEnum()) {
            ab.addAll(m.listOf(c.eQB, c.eQA));
        }
        return ab;
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> e(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        Set<kotlin.reflect.jvm.internal.impl.name.f> ab = u.ab(((b) bgQ().invoke()).bgw());
        a(bgJ(), ab, LazyJavaStaticClassScope$computePropertyNames$1$1.eIb);
        return ab;
    }

    protected Set<kotlin.reflect.jvm.internal.impl.name.f> d(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        return aj.emptySet();
    }

    protected void a(Collection<ah> collection, kotlin.reflect.jvm.internal.impl.name.f fVar) {
        h.e(collection, "result");
        h.e(fVar, "name");
        Collection b = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, c(fVar, (d) bgJ()), collection, bgJ(), bgT().bgq().bfZ());
        h.d(b, "resolveOverridesForStati…components.errorReporter)");
        collection.addAll(b);
        if (!this.eHk.isEnum()) {
            return;
        }
        ah H;
        if (h.E(fVar, c.eQB)) {
            H = kotlin.reflect.jvm.internal.impl.resolve.b.H(bgJ());
            h.d(H, "createEnumValueOfMethod(ownerDescriptor)");
            collection.add(H);
        } else if (h.E(fVar, c.eQA)) {
            H = kotlin.reflect.jvm.internal.impl.resolve.b.G(bgJ());
            h.d(H, "createEnumValuesMethod(ownerDescriptor)");
            collection.add(H);
        }
    }

    protected void b(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<ad> collection) {
        h.e(fVar, "name");
        h.e(collection, "result");
        Set a = a(bgJ(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(fVar));
        if ((collection.isEmpty() ^ 1) != 0) {
            Collection b = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, a, collection, bgJ(), bgT().bgq().bfZ());
            h.d(b, "resolveOverridesForStati…rorReporter\n            )");
            collection.addAll(b);
            return;
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : a) {
            ad g = g((ad) next);
            ArrayList arrayList = linkedHashMap.get(g);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(g, arrayList);
            }
            arrayList.add(next);
        }
        Collection arrayList2 = new ArrayList();
        for (Entry value : linkedHashMap.entrySet()) {
            r.a(arrayList2, (Iterable) kotlin.reflect.jvm.internal.impl.load.java.components.a.b(fVar, (Collection) value.getValue(), collection, bgJ(), bgT().bgq().bfZ()));
        }
        collection.addAll((List) arrayList2);
    }

    private final Set<ah> c(kotlin.reflect.jvm.internal.impl.name.f fVar, d dVar) {
        l z = kotlin.reflect.jvm.internal.impl.load.java.descriptors.h.z(dVar);
        if (z != null) {
            return u.Y(z.b(fVar, (kotlin.reflect.jvm.internal.impl.incremental.components.b) NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return aj.emptySet();
    }

    private final <R> Set<R> a(d dVar, Set<R> set, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.h, ? extends Collection<? extends R>> bVar) {
        kotlin.reflect.jvm.internal.impl.utils.b.a((Collection) l.cr(dVar), (kotlin.reflect.jvm.internal.impl.utils.b.b) a.eIc, (kotlin.reflect.jvm.internal.impl.utils.b.c) new b(dVar, set, bVar));
        return set;
    }

    private final ad g(ad adVar) {
        Kind bcW = adVar.bcW();
        h.d(bcW, "this.kind");
        if (bcW.isReal()) {
            return adVar;
        }
        Collection bcU = adVar.bcU();
        h.d(bcU, "this.overriddenDescriptors");
        Iterable<ad> iterable = bcU;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (ad adVar2 : iterable) {
            h.d(adVar2, "it");
            arrayList.add(g(adVar2));
        }
        return (ad) u.bY(u.aa((List) arrayList));
    }
}
