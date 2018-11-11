package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.a.a;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f;

/* compiled from: context.kt */
public final class j {
    private final k eCq;
    private final h eJC;
    private final a eSC;
    private final v eSY;
    private final p eSZ = new p(this);
    private final kotlin.reflect.jvm.internal.impl.metadata.a.k eTa;
    private final f eTb;
    private final c evp;
    private final h evq;

    public j(h hVar, c cVar, k kVar, h hVar2, kotlin.reflect.jvm.internal.impl.metadata.a.k kVar2, a aVar, f fVar, v vVar, List<TypeParameter> list) {
        h hVar3 = hVar;
        c cVar2 = cVar;
        k kVar3 = kVar;
        h hVar4 = hVar2;
        kotlin.reflect.jvm.internal.impl.metadata.a.k kVar4 = kVar2;
        a aVar2 = aVar;
        kotlin.jvm.internal.h.e(hVar3, "components");
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.jvm.internal.h.e(kVar3, "containingDeclaration");
        kotlin.jvm.internal.h.e(hVar4, "typeTable");
        kotlin.jvm.internal.h.e(kVar4, "versionRequirementTable");
        kotlin.jvm.internal.h.e(aVar2, "metadataVersion");
        List<TypeParameter> list2 = list;
        kotlin.jvm.internal.h.e(list2, "typeParameters");
        this.eJC = hVar3;
        this.evp = cVar2;
        this.eCq = kVar3;
        this.evq = hVar4;
        this.eTa = kVar4;
        this.eSC = aVar2;
        this.eTb = fVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Deserializer for ");
        stringBuilder.append(this.eCq.bdc());
        this.eSY = new v(this, vVar, list2, stringBuilder.toString(), false, 16, null);
    }

    public final h biq() {
        return this.eJC;
    }

    public final c aYI() {
        return this.evp;
    }

    public final k bbv() {
        return this.eCq;
    }

    public final h aYJ() {
        return this.evq;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.a.k bxK() {
        return this.eTa;
    }

    public final f bxL() {
        return this.eTb;
    }

    public final v bxI() {
        return this.eSY;
    }

    public final p bxJ() {
        return this.eSZ;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.h baI() {
        return this.eJC.baI();
    }

    public static /* bridge */ /* synthetic */ j a(j jVar, k kVar, List list, c cVar, h hVar, kotlin.reflect.jvm.internal.impl.metadata.a.k kVar2, a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            cVar = jVar.evp;
        }
        c cVar2 = cVar;
        if ((i & 8) != 0) {
            hVar = jVar.evq;
        }
        h hVar2 = hVar;
        if ((i & 16) != 0) {
            kVar2 = jVar.eTa;
        }
        kotlin.reflect.jvm.internal.impl.metadata.a.k kVar3 = kVar2;
        if ((i & 32) != 0) {
            aVar = jVar.eSC;
        }
        return jVar.a(kVar, list, cVar2, hVar2, kVar3, aVar);
    }

    public final j a(k kVar, List<TypeParameter> list, c cVar, h hVar, kotlin.reflect.jvm.internal.impl.metadata.a.k kVar2, a aVar) {
        k kVar3 = kVar;
        kotlin.jvm.internal.h.e(kVar3, "descriptor");
        List<TypeParameter> list2 = list;
        kotlin.jvm.internal.h.e(list2, "typeParameterProtos");
        c cVar2 = cVar;
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.a.k kVar4 = kVar2;
        kotlin.jvm.internal.h.e(kVar4, "versionRequirementTable");
        a aVar2 = aVar;
        kotlin.jvm.internal.h.e(aVar2, "metadataVersion");
        h hVar3 = this.eJC;
        if (!l.a(aVar)) {
            kVar4 = this.eTa;
        }
        return new j(hVar3, cVar2, kVar3, hVar2, kVar4, aVar2, this.eTb, this.eSY, list2);
    }
}
