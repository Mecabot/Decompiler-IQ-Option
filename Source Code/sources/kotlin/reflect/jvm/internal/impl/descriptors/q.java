package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: findClassInModule.kt */
public final class q {
    public static final d a(u uVar, a aVar) {
        h.e(uVar, "$receiver");
        h.e(aVar, "classId");
        b packageFqName = aVar.getPackageFqName();
        h.d(packageFqName, "classId.packageFqName");
        z g = uVar.g(packageFqName);
        List pathSegments = aVar.btG().pathSegments();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk = g.bbk();
        h.d(pathSegments, "segments");
        Object bU = u.bU(pathSegments);
        h.d(bU, "segments.first()");
        f c = bbk.c((f) bU, NoLookupLocation.FROM_DESERIALIZATION);
        if (!(c instanceof d)) {
            c = null;
        }
        d dVar = (d) c;
        if (dVar == null) {
            return null;
        }
        for (f fVar : pathSegments.subList(1, pathSegments.size())) {
            bbk = dVar.bdg();
            h.d(fVar, "name");
            c = bbk.c(fVar, NoLookupLocation.FROM_DESERIALIZATION);
            if (!(c instanceof d)) {
                c = null;
            }
            dVar = (d) c;
            if (dVar == null) {
                return null;
            }
        }
        return dVar;
    }

    public static final d a(u uVar, a aVar, w wVar) {
        h.e(uVar, "$receiver");
        h.e(aVar, "classId");
        h.e(wVar, "notFoundClasses");
        d a = a(uVar, aVar);
        if (a != null) {
            return a;
        }
        return wVar.a(aVar, m.f(m.f(k.a((Object) aVar, (kotlin.jvm.a.b) FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.eAM), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.eAN)));
    }

    public static final am b(u uVar, a aVar) {
        h.e(uVar, "$receiver");
        h.e(aVar, "classId");
        b packageFqName = aVar.getPackageFqName();
        h.d(packageFqName, "classId.packageFqName");
        z g = uVar.g(packageFqName);
        List pathSegments = aVar.btG().pathSegments();
        int size = pathSegments.size() - 1;
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk = g.bbk();
        h.d(pathSegments, "segments");
        Object bU = u.bU(pathSegments);
        h.d(bU, "segments.first()");
        f c = bbk.c((f) bU, NoLookupLocation.FROM_DESERIALIZATION);
        if (size == 0) {
            if (!(c instanceof am)) {
                c = null;
            }
            return (am) c;
        }
        if (!(c instanceof d)) {
            c = null;
        }
        d dVar = (d) c;
        if (dVar == null) {
            return null;
        }
        for (f fVar : pathSegments.subList(1, size)) {
            bbk = dVar.bdg();
            h.d(fVar, "name");
            c = bbk.c(fVar, NoLookupLocation.FROM_DESERIALIZATION);
            if (!(c instanceof d)) {
                c = null;
            }
            dVar = (d) c;
            if (dVar == null) {
                return null;
            }
        }
        f fVar2 = (f) pathSegments.get(size);
        bbk = dVar.bbA();
        h.d(fVar2, "lastName");
        c = bbk.c(fVar2, NoLookupLocation.FROM_DESERIALIZATION);
        if (!(c instanceof am)) {
            c = null;
        }
        return (am) c;
    }
}
