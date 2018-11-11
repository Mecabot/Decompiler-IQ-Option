package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.g;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: JavaDescriptorResolver.kt */
public final class a {
    private final g eGC;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.g eRy;

    public a(kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar, g gVar2) {
        h.e(gVar, "packageFragmentProvider");
        h.e(gVar2, "javaResolverCache");
        this.eRy = gVar;
        this.eGC = gVar2;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.g bwJ() {
        return this.eRy;
    }

    public final d b(kotlin.reflect.jvm.internal.impl.load.java.structure.g gVar) {
        h.e(gVar, "javaClass");
        b bdD = gVar.bdD();
        if (bdD != null && gVar.bhs() == LightClassOriginKind.SOURCE) {
            return this.eGC.o(bdD);
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.g bhq = gVar.bhq();
        d dVar = null;
        if (bhq != null) {
            d b = b(bhq);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h bdg = b != null ? b.bdg() : null;
            f c = bdg != null ? bdg.c(gVar.bdc(), NoLookupLocation.FROM_JAVA_LOADER) : null;
            if (!(c instanceof d)) {
                c = null;
            }
            return (d) c;
        } else if (bdD == null) {
            return null;
        } else {
            kotlin.reflect.jvm.internal.impl.load.java.lazy.g gVar2 = this.eRy;
            bdD = bdD.btM();
            h.d(bdD, "fqName.parent()");
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h hVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h) u.bV(gVar2.i(bdD));
            if (hVar != null) {
                dVar = hVar.c(gVar);
            }
            return dVar;
        }
    }
}
