package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class k extends ac implements c {
    private boolean eTA;
    private final Function eTU;
    private final kotlin.reflect.jvm.internal.impl.metadata.a.k eTa;
    private final f eTb;
    private final c evp;
    private final h evq;

    public List<i> bxW() {
        return a.a(this);
    }

    /* renamed from: byx */
    public Function bxV() {
        return this.eTU;
    }

    public c aYI() {
        return this.evp;
    }

    public h aYJ() {
        return this.evq;
    }

    public kotlin.reflect.jvm.internal.impl.metadata.a.k bxK() {
        return this.eTa;
    }

    public f bxL() {
        return this.eTb;
    }

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, ah ahVar, g gVar, f fVar, Kind kind, Function function, c cVar, h hVar, kotlin.reflect.jvm.internal.impl.metadata.a.k kVar2, f fVar2, ai aiVar, int i, f fVar3) {
        this(kVar, ahVar, gVar, fVar, kind, function, cVar, hVar, kVar2, fVar2, (i & 1024) != 0 ? (ai) null : aiVar);
    }

    public k(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, ah ahVar, g gVar, f fVar, Kind kind, Function function, c cVar, h hVar, kotlin.reflect.jvm.internal.impl.metadata.a.k kVar2, f fVar2, ai aiVar) {
        Function function2 = function;
        c cVar2 = cVar;
        h hVar2 = hVar;
        kotlin.reflect.jvm.internal.impl.metadata.a.k kVar3 = kVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar4 = kVar;
        kotlin.jvm.internal.h.e(kVar4, "containingDeclaration");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        f fVar3 = fVar;
        kotlin.jvm.internal.h.e(fVar3, "name");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        kotlin.jvm.internal.h.e(function2, "proto");
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.jvm.internal.h.e(hVar2, "typeTable");
        kotlin.jvm.internal.h.e(kVar3, "versionRequirementTable");
        super(kVar4, ahVar, gVar2, fVar3, kind2, aiVar != null ? aiVar : ai.eAX);
        this.eTU = function2;
        this.evp = cVar2;
        this.evq = hVar2;
        this.eTa = kVar3;
        this.eTb = fVar2;
    }

    private void hd(boolean z) {
        this.eTA = z;
    }

    public final ac a(w wVar, ag agVar, List<? extends an> list, List<? extends aq> list2, w wVar2, Modality modality, av avVar, Map<? extends b<?>, ?> map, boolean z) {
        kotlin.jvm.internal.h.e(list, "typeParameters");
        kotlin.jvm.internal.h.e(list2, "unsubstitutedValueParameters");
        kotlin.jvm.internal.h.e(avVar, "visibility");
        kotlin.jvm.internal.h.e(map, "userDataMap");
        ac a = super.a(wVar, agVar, list, list2, wVar2, modality, avVar, map);
        hd(z);
        kotlin.jvm.internal.h.d(a, "super.initialize(\n      …easeEnvironment\n        }");
        return a;
    }

    protected o a(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, r rVar, Kind kind, f fVar, g gVar, ai aiVar) {
        f fVar2;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2 = kVar;
        kotlin.jvm.internal.h.e(kVar2, "newOwner");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        ai aiVar2 = aiVar;
        kotlin.jvm.internal.h.e(aiVar2, FirebaseAnalytics.b.SOURCE);
        ah ahVar = (ah) rVar;
        if (fVar != null) {
            fVar2 = fVar;
        } else {
            f bdc = bdc();
            kotlin.jvm.internal.h.d(bdc, "name");
            fVar2 = bdc;
        }
        return new k(kVar2, ahVar, gVar2, fVar2, kind2, bxV(), aYI(), aYJ(), bxK(), bxL(), aiVar2);
    }
}
