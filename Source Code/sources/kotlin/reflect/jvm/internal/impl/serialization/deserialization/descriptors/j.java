package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.a.b;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.metadata.a.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c.a;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class j extends y implements c {
    private boolean eTA;
    private final k eTa;
    private final f eTb;
    private final Property evn;
    private final c evp;
    private final h evq;

    public List<i> bxW() {
        return a.a(this);
    }

    public /* synthetic */ boolean isExternal() {
        return byd().booleanValue();
    }

    /* renamed from: aYG */
    public Property bxV() {
        return this.evn;
    }

    public c aYI() {
        return this.evp;
    }

    public h aYJ() {
        return this.evq;
    }

    public k bxK() {
        return this.eTa;
    }

    public f bxL() {
        return this.eTb;
    }

    public j(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, ad adVar, g gVar, Modality modality, av avVar, boolean z, f fVar, Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Property property, c cVar, h hVar, k kVar2, f fVar2) {
        Property property2 = property;
        c cVar2 = cVar;
        h hVar2 = hVar;
        k kVar3 = kVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar4 = kVar;
        kotlin.jvm.internal.h.e(kVar4, "containingDeclaration");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        Modality modality2 = modality;
        kotlin.jvm.internal.h.e(modality2, "modality");
        av avVar2 = avVar;
        kotlin.jvm.internal.h.e(avVar2, "visibility");
        f fVar3 = fVar;
        kotlin.jvm.internal.h.e(fVar3, "name");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        kotlin.jvm.internal.h.e(property2, "proto");
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.jvm.internal.h.e(hVar2, "typeTable");
        kotlin.jvm.internal.h.e(kVar3, "versionRequirementTable");
        super(kVar4, adVar, gVar2, modality2, avVar2, z, fVar3, kind2, ai.eAX, z2, z3, z6, false, z4, z5);
        this.evn = property;
        this.evp = cVar;
        this.evq = hVar;
        this.eTa = kVar2;
        this.eTb = fVar2;
    }

    private void hd(boolean z) {
        this.eTA = z;
    }

    public final void a(z zVar, af afVar, boolean z) {
        super.a(zVar, afVar);
        l lVar = l.etX;
        hd(z);
    }

    protected y a(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, av avVar, ad adVar, Kind kind, f fVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2 = kVar;
        kotlin.jvm.internal.h.e(kVar2, "newOwner");
        Modality modality2 = modality;
        kotlin.jvm.internal.h.e(modality2, "newModality");
        av avVar2 = avVar;
        kotlin.jvm.internal.h.e(avVar2, "newVisibility");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        f fVar2 = fVar;
        kotlin.jvm.internal.h.e(fVar2, "newName");
        g bbQ = bbQ();
        boolean bdW = bdW();
        boolean bdZ = bdZ();
        boolean bdY = bdY();
        Boolean byd = byd();
        kotlin.jvm.internal.h.d(byd, "isExternal");
        return new j(kVar2, adVar, bbQ, modality2, avVar2, bdW, fVar2, kind2, bdZ, bdY, byd.booleanValue(), isDelegated(), bbO(), bxV(), aYI(), aYJ(), bxK(), bxL());
    }

    public Boolean byd() {
        return b.eLF.get(bxV().getFlags());
    }
}
