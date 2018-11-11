package kotlin.reflect.jvm.internal.components;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "version", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"})
/* compiled from: RuntimePackagePartProvider.kt */
final class RuntimePackagePartProvider$registerModule$1$mapping$1 extends Lambda implements b<g, l> {
    public static final RuntimePackagePartProvider$registerModule$1$mapping$1 ewX = new RuntimePackagePartProvider$registerModule$1$mapping$1();

    RuntimePackagePartProvider$registerModule$1$mapping$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((g) obj);
        return l.etX;
    }

    public final void a(g gVar) {
        h.e(gVar, "version");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Module was compiled with an incompatible version of Kotlin. The binary version of its metadata is ");
        stringBuilder.append(gVar);
        stringBuilder.append(", ");
        stringBuilder.append("expected version is ");
        stringBuilder.append(g.eMH);
        stringBuilder.append(". Please update Kotlin to the latest version");
        throw new UnsupportedOperationException(stringBuilder.toString());
    }
}
