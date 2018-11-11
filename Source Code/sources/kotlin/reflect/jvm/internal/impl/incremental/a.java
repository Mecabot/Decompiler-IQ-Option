package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.incremental.components.b;
import kotlin.reflect.jvm.internal.impl.incremental.components.c;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: utils.kt */
public final class a {
    public static final void a(c cVar, b bVar, d dVar, f fVar) {
        h.e(cVar, "$receiver");
        h.e(bVar, "from");
        h.e(dVar, "scopeOwner");
        h.e(fVar, "name");
        if (cVar != kotlin.reflect.jvm.internal.impl.incremental.components.c.a.eEs) {
            kotlin.reflect.jvm.internal.impl.incremental.components.a location = bVar.getLocation();
            if (location != null) {
                Position bfs = cVar.bft() ? location.bfs() : Position.eEu.bfv();
                String bfr = location.bfr();
                String asString = kotlin.reflect.jvm.internal.impl.resolve.c.w(dVar).asString();
                h.d(asString, "DescriptorUtils.getFqName(scopeOwner).asString()");
                ScopeKind scopeKind = ScopeKind.CLASSIFIER;
                String asString2 = fVar.asString();
                h.d(asString2, "name.asString()");
                cVar.a(bfr, bfs, asString, scopeKind, asString2);
            }
        }
    }

    public static final void a(c cVar, b bVar, x xVar, f fVar) {
        h.e(cVar, "$receiver");
        h.e(bVar, "from");
        h.e(xVar, "scopeOwner");
        h.e(fVar, "name");
        String asString = xVar.bdD().asString();
        h.d(asString, "scopeOwner.fqName.asString()");
        String asString2 = fVar.asString();
        h.d(asString2, "name.asString()");
        a(cVar, bVar, asString, asString2);
    }

    public static final void a(c cVar, b bVar, String str, String str2) {
        h.e(cVar, "$receiver");
        h.e(bVar, "from");
        h.e(str, "packageFqName");
        h.e(str2, "name");
        if (cVar != kotlin.reflect.jvm.internal.impl.incremental.components.c.a.eEs) {
            kotlin.reflect.jvm.internal.impl.incremental.components.a location = bVar.getLocation();
            if (location != null) {
                cVar.a(location.bfr(), cVar.bft() ? location.bfs() : Position.eEu.bfv(), str, ScopeKind.PACKAGE, str2);
            }
        }
    }
}
