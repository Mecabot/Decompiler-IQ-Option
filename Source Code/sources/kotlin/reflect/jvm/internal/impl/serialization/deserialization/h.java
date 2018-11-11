package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.incremental.components.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.k;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;

/* compiled from: context.kt */
public final class h {
    private final u eAh;
    private final l eGB;
    private final c eGI;
    private final f eSL = new f(this);
    private final i eSM;
    private final e eSN;
    private final a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, f<?>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> eSO;
    private final y eSP;
    private final o eSQ;
    private final m eSR;
    private final Iterable<b> eSS;
    private final g eST;
    private final a eSU;
    private final kotlin.reflect.jvm.internal.impl.descriptors.a.c eSV;
    private final kotlin.reflect.jvm.internal.impl.protobuf.f eSW;
    private final kotlin.reflect.jvm.internal.impl.storage.h exB;
    private final w ezw;

    public h(kotlin.reflect.jvm.internal.impl.storage.h hVar, u uVar, i iVar, e eVar, a<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends f<?>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> aVar, y yVar, o oVar, l lVar, c cVar, m mVar, Iterable<? extends b> iterable, w wVar, g gVar, a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.a.c cVar2, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        kotlin.reflect.jvm.internal.impl.storage.h hVar2 = hVar;
        u uVar2 = uVar;
        i iVar2 = iVar;
        e eVar2 = eVar;
        a<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, ? extends f<?>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> aVar3 = aVar;
        y yVar2 = yVar;
        o oVar2 = oVar;
        l lVar2 = lVar;
        c cVar3 = cVar;
        m mVar2 = mVar;
        Iterable<? extends b> iterable2 = iterable;
        w wVar2 = wVar;
        g gVar2 = gVar;
        a aVar4 = aVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.a.c cVar4 = cVar2;
        kotlin.jvm.internal.h.e(hVar2, "storageManager");
        kotlin.jvm.internal.h.e(uVar2, "moduleDescriptor");
        kotlin.jvm.internal.h.e(iVar2, "configuration");
        kotlin.jvm.internal.h.e(eVar2, "classDataFinder");
        kotlin.jvm.internal.h.e(aVar3, "annotationAndConstantLoader");
        kotlin.jvm.internal.h.e(yVar2, "packageFragmentProvider");
        kotlin.jvm.internal.h.e(oVar2, "localClassifierTypeSettings");
        kotlin.jvm.internal.h.e(lVar2, "errorReporter");
        kotlin.jvm.internal.h.e(cVar3, "lookupTracker");
        kotlin.jvm.internal.h.e(mVar2, "flexibleTypeDeserializer");
        kotlin.jvm.internal.h.e(iterable2, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.h.e(wVar2, "notFoundClasses");
        kotlin.jvm.internal.h.e(gVar2, "contractDeserializer");
        kotlin.jvm.internal.h.e(aVar4, "additionalClassPartsProvider");
        kotlin.jvm.internal.h.e(cVar4, "platformDependentDeclarationFilter");
        kotlin.reflect.jvm.internal.impl.protobuf.f fVar2 = fVar;
        kotlin.jvm.internal.h.e(fVar2, "extensionRegistryLite");
        this.exB = hVar2;
        this.eAh = uVar2;
        this.eSM = iVar2;
        this.eSN = eVar2;
        this.eSO = aVar3;
        this.eSP = yVar2;
        this.eSQ = oVar2;
        this.eGB = lVar2;
        this.eGI = cVar3;
        this.eSR = mVar2;
        this.eSS = iterable2;
        this.ezw = wVar2;
        this.eST = gVar2;
        this.eSU = aVar4;
        this.eSV = cVar2;
        this.eSW = fVar2;
    }

    public final kotlin.reflect.jvm.internal.impl.storage.h baI() {
        return this.exB;
    }

    public final u bxu() {
        return this.eAh;
    }

    public final i bxv() {
        return this.eSM;
    }

    public final e bxw() {
        return this.eSN;
    }

    public final a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, f<?>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> bxx() {
        return this.eSO;
    }

    public final y beV() {
        return this.eSP;
    }

    public final o bxy() {
        return this.eSQ;
    }

    public final l bfZ() {
        return this.eGB;
    }

    public final c bgf() {
        return this.eGI;
    }

    public final m bxz() {
        return this.eSR;
    }

    public final Iterable<b> bxA() {
        return this.eSS;
    }

    public final w bxB() {
        return this.ezw;
    }

    public final g bxC() {
        return this.eST;
    }

    public final a baF() {
        return this.eSU;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.a.c baG() {
        return this.eSV;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.f bxD() {
        return this.eSW;
    }

    public final f bxt() {
        return this.eSL;
    }

    public final d l(kotlin.reflect.jvm.internal.impl.name.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "classId");
        return f.a(this.eSL, aVar, null, 2, null);
    }

    public final j a(x xVar, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar, k kVar, kotlin.reflect.jvm.internal.impl.metadata.a.a aVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar) {
        x xVar2 = xVar;
        kotlin.jvm.internal.h.e(xVar2, "descriptor");
        kotlin.reflect.jvm.internal.impl.metadata.a.c cVar2 = cVar;
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.reflect.jvm.internal.impl.metadata.a.h hVar2 = hVar;
        kotlin.jvm.internal.h.e(hVar2, "typeTable");
        k kVar2 = kVar;
        kotlin.jvm.internal.h.e(kVar2, "versionRequirementTable");
        kotlin.reflect.jvm.internal.impl.metadata.a.a aVar2 = aVar;
        kotlin.jvm.internal.h.e(aVar2, "metadataVersion");
        return new j(this, cVar2, xVar2, hVar2, kVar2, aVar2, fVar, null, m.emptyList());
    }
}
