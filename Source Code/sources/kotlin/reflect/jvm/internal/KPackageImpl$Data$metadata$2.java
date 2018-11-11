package kotlin.reflect.jvm.internal;

import kotlin.Pair;
import kotlin.Triple;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.components.e;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$metadata$2 extends Lambda implements a<Triple<? extends h, ? extends Package, ? extends g>> {
    final /* synthetic */ a this$0;

    KPackageImpl$Data$metadata$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aZJ */
    public final Triple<h, Package, g> invoke() {
        e a = this.this$0.aZE();
        if (a == null) {
            return null;
        }
        KotlinClassHeader bap = a.bap();
        if (bap == null) {
            return null;
        }
        String[] biO = bap.biO();
        String[] biQ = bap.biQ();
        if (biO == null || biQ == null) {
            return null;
        }
        Pair b = j.b(biO, biQ);
        return new Triple((h) b.aXG(), (Package) b.aXH(), bap.biN());
    }
}
