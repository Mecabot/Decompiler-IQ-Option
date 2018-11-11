package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.a.a;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;

/* compiled from: DeserializedPackageMemberScope.kt */
public class i extends h {
    private final x eTT;
    private final b packageFqName = this.eTT.bdD();

    protected void c(Collection<k> collection, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(collection, "result");
        h.e(bVar, "nameFilter");
    }

    public i(x xVar, Package packageR, c cVar, a aVar, f fVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.h hVar, kotlin.jvm.a.a<? extends Collection<f>> aVar2) {
        x xVar2 = xVar;
        h.e(xVar2, "packageDescriptor");
        h.e(packageR, "proto");
        c cVar2 = cVar;
        h.e(cVar2, "nameResolver");
        a aVar3 = aVar;
        h.e(aVar3, "metadataVersion");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.h hVar2 = hVar;
        h.e(hVar2, "components");
        kotlin.jvm.a.a<? extends Collection<f>> aVar4 = aVar2;
        h.e(aVar4, "classNames");
        TypeTable bkF = packageR.bkF();
        h.d(bkF, "proto.typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.a.h hVar3 = new kotlin.reflect.jvm.internal.impl.metadata.a.h(bkF);
        kotlin.reflect.jvm.internal.impl.metadata.a.k.a aVar5 = kotlin.reflect.jvm.internal.impl.metadata.a.k.eMf;
        VersionRequirementTable bkI = packageR.bkI();
        h.d(bkI, "proto.versionRequirementTable");
        j a = hVar2.a(xVar2, cVar2, hVar3, aVar5.g(bkI), aVar3, fVar);
        List bkv = packageR.bkv();
        h.d(bkv, "proto.functionList");
        Collection collection = bkv;
        bkv = packageR.bkx();
        h.d(bkv, "proto.propertyList");
        Collection collection2 = bkv;
        bkv = packageR.bkz();
        h.d(bkv, "proto.typeAliasList");
        super(a, collection, collection2, bkv, aVar4);
        this.eTT = xVar2;
    }

    /* renamed from: f */
    public List<k> a(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        Collection b = b(dVar, bVar, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Collection arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.a.b e : bxX().biq().bxA()) {
            r.a(arrayList, (Iterable) e.e(this.packageFqName));
        }
        return u.b(b, (Iterable) (List) arrayList);
    }

    protected boolean U(f fVar) {
        h.e(fVar, "name");
        if (super.U(fVar)) {
            return true;
        }
        Object obj;
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.a.b> bxA = bxX().biq().bxA();
        if (!((bxA instanceof Collection) && ((Collection) bxA).isEmpty())) {
            for (kotlin.reflect.jvm.internal.impl.descriptors.a.b a : bxA) {
                if (a.a(this.packageFqName, fVar)) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    protected kotlin.reflect.jvm.internal.impl.name.a P(f fVar) {
        h.e(fVar, "name");
        return new kotlin.reflect.jvm.internal.impl.name.a(this.packageFqName, fVar);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, bVar);
        return super.c(fVar, bVar);
    }

    public void d(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        kotlin.reflect.jvm.internal.impl.incremental.a.a(bxX().biq().bgf(), bVar, this.eTT, fVar);
    }

    protected Set<f> byn() {
        return aj.emptySet();
    }

    protected Set<f> byo() {
        return aj.emptySet();
    }
}
