package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.i;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: TypeIntersectionScope.kt */
public final class m extends a {
    public static final a eSs = new a();
    private final b eSr;

    /* compiled from: TypeIntersectionScope.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final h a(String str, Collection<? extends w> collection) {
            h.e(str, "message");
            h.e(collection, "types");
            Iterable<w> iterable = collection;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (w bbk : iterable) {
                arrayList.add(bbk.bbk());
            }
            b bVar = new b(str, (List) arrayList);
            if (collection.size() <= 1) {
                return bVar;
            }
            return new m(bVar, null);
        }
    }

    public static final h a(String str, Collection<? extends w> collection) {
        return eSs.a(str, collection);
    }

    private m(b bVar) {
        this.eSr = bVar;
    }

    public /* synthetic */ m(b bVar, f fVar) {
        this(bVar);
    }

    /* renamed from: bxl */
    protected b bwL() {
        return this.eSr;
    }

    public Collection<ah> b(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return i.b(super.b(fVar, bVar), TypeIntersectionScope$getContributedFunctions$1.eSu);
    }

    public Collection<ad> a(f fVar, b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        return i.b(super.a(fVar, bVar), TypeIntersectionScope$getContributedVariables$1.eSv);
    }

    public Collection<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        Iterable a = super.a(dVar, (kotlin.jvm.a.b) bVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : a) {
            if (((k) next) instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.aXG();
        List list2 = (List) pair.aXH();
        if (list != null) {
            return u.b(i.b(list, TypeIntersectionScope$getContributedDescriptors$2.eSt), (Iterable) list2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    }
}
