package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ao;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.metadata.a.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.at;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class l extends d implements g {
    private List<? extends an> eDA;
    private boolean eTA;
    private Collection<? extends ae> eTV;
    private ad eTW;
    private ad eTX;
    private ad eTY;
    private final TypeAlias eTZ;
    private final k eTa;
    private final f eTb;
    private final c evp;
    private final h evq;
    private final kotlin.reflect.jvm.internal.impl.storage.h exB;

    public List<i> bxW() {
        return a.d(this);
    }

    protected kotlin.reflect.jvm.internal.impl.storage.h baI() {
        return this.exB;
    }

    /* renamed from: byy */
    public TypeAlias bxV() {
        return this.eTZ;
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

    public l(kotlin.reflect.jvm.internal.impl.storage.h hVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, g gVar, f fVar, av avVar, TypeAlias typeAlias, c cVar, h hVar2, k kVar2, f fVar2) {
        kotlin.reflect.jvm.internal.impl.storage.h hVar3 = hVar;
        TypeAlias typeAlias2 = typeAlias;
        c cVar2 = cVar;
        h hVar4 = hVar2;
        k kVar3 = kVar2;
        kotlin.jvm.internal.h.e(hVar3, "storageManager");
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar4 = kVar;
        kotlin.jvm.internal.h.e(kVar4, "containingDeclaration");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        f fVar3 = fVar;
        kotlin.jvm.internal.h.e(fVar3, "name");
        av avVar2 = avVar;
        kotlin.jvm.internal.h.e(avVar2, "visibility");
        kotlin.jvm.internal.h.e(typeAlias2, "proto");
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.jvm.internal.h.e(hVar4, "typeTable");
        kotlin.jvm.internal.h.e(kVar3, "versionRequirementTable");
        ai aiVar = ai.eAX;
        kotlin.jvm.internal.h.d(aiVar, "SourceElement.NO_SOURCE");
        super(kVar4, gVar2, fVar3, aiVar, avVar2);
        this.exB = hVar3;
        this.eTZ = typeAlias2;
        this.evp = cVar2;
        this.evq = hVar4;
        this.eTa = kVar3;
        this.eTb = fVar2;
    }

    private void X(Collection<? extends ae> collection) {
        this.eTV = collection;
    }

    private void b(ad adVar) {
        this.eTW = adVar;
    }

    public ad bdN() {
        ad adVar = this.eTW;
        if (adVar == null) {
            kotlin.jvm.internal.h.lS("underlyingType");
        }
        return adVar;
    }

    private void c(ad adVar) {
        this.eTX = adVar;
    }

    public ad bdO() {
        ad adVar = this.eTX;
        if (adVar == null) {
            kotlin.jvm.internal.h.lS("expandedType");
        }
        return adVar;
    }

    private void hd(boolean z) {
        this.eTA = z;
    }

    public boolean bxT() {
        return this.eTA;
    }

    public final void a(List<? extends an> list, ad adVar, ad adVar2, boolean z) {
        kotlin.jvm.internal.h.e(list, "declaredTypeParameters");
        kotlin.jvm.internal.h.e(adVar, "underlyingType");
        kotlin.jvm.internal.h.e(adVar2, "expandedType");
        cc(list);
        b(adVar);
        c(adVar2);
        this.eDA = ao.a(this);
        this.eTY = bes();
        X(beo());
        hd(z);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d bdP() {
        if (y.aF(bdO())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bdO().bwA().bbW();
        if (!(bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            bbW = null;
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) bbW;
    }

    public ad bdb() {
        ad adVar = this.eTY;
        if (adVar == null) {
            kotlin.jvm.internal.h.lS("defaultTypeImpl");
        }
        return adVar;
    }

    /* renamed from: k */
    public am f(TypeSubstitutor typeSubstitutor) {
        kotlin.jvm.internal.h.e(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        kotlin.reflect.jvm.internal.impl.storage.h baI = baI();
        kotlin.reflect.jvm.internal.impl.descriptors.k bbv = bbv();
        kotlin.jvm.internal.h.d(bbv, "containingDeclaration");
        g bbQ = bbQ();
        kotlin.jvm.internal.h.d(bbQ, "annotations");
        f bdc = bdc();
        kotlin.jvm.internal.h.d(bdc, "name");
        l lVar = new l(baI, bbv, bbQ, bdc, bbJ(), bxV(), aYI(), aYJ(), bxK(), bxL());
        List bbS = bbS();
        w b = typeSubstitutor.b((w) bdN(), Variance.INVARIANT);
        kotlin.jvm.internal.h.d(b, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        ad aP = at.aP(b);
        w b2 = typeSubstitutor.b((w) bdO(), Variance.INVARIANT);
        kotlin.jvm.internal.h.d(b2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        lVar.a(bbS, aP, at.aP(b2), bxT());
        return lVar;
    }

    protected List<an> ber() {
        List<an> list = this.eDA;
        if (list == null) {
            kotlin.jvm.internal.h.lS("typeConstructorParameters");
        }
        return list;
    }
}
