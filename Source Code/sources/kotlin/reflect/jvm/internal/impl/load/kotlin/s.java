package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.k;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.k.a;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.i;

/* compiled from: ModuleMappingUtil.kt */
public final class s {
    public static final k a(a aVar, byte[] bArr, String str, i iVar, b<? super g, l> bVar) {
        h.e(aVar, "$receiver");
        h.e(str, "debugName");
        h.e(iVar, "configuration");
        h.e(bVar, "reportIncompatibleVersionError");
        return aVar.a(bArr, str, iVar.bir(), iVar.bxG(), bVar);
    }
}
