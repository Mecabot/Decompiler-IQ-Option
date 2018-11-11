package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.metadata.a.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c.a;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class d extends f implements c {
    private boolean eTA;
    private final Constructor eTB;
    private final k eTa;
    private final f eTb;
    private final c evp;
    private final h evq;

    public boolean bbN() {
        return false;
    }

    public boolean bcb() {
        return false;
    }

    public boolean bdq() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public List<i> bxW() {
        return a.a(this);
    }

    /* renamed from: bxU */
    public Constructor bxV() {
        return this.eTB;
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

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, j jVar, g gVar, boolean z, Kind kind, Constructor constructor, c cVar, h hVar, k kVar, f fVar, ai aiVar, int i, f fVar2) {
        this(dVar, jVar, gVar, z, kind, constructor, cVar, hVar, kVar, fVar, (i & 1024) != 0 ? (ai) null : aiVar);
    }

    public d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, j jVar, g gVar, boolean z, Kind kind, Constructor constructor, c cVar, h hVar, k kVar, f fVar, ai aiVar) {
        Constructor constructor2 = constructor;
        c cVar2 = cVar;
        h hVar2 = hVar;
        k kVar2 = kVar;
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = dVar;
        kotlin.jvm.internal.h.e(dVar2, "containingDeclaration");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        kotlin.jvm.internal.h.e(constructor2, "proto");
        kotlin.jvm.internal.h.e(cVar2, "nameResolver");
        kotlin.jvm.internal.h.e(hVar2, "typeTable");
        kotlin.jvm.internal.h.e(kVar2, "versionRequirementTable");
        super(dVar2, jVar, gVar2, z, kind2, aiVar != null ? aiVar : ai.eAX);
        this.eTB = constructor2;
        this.evp = cVar2;
        this.evq = hVar2;
        this.eTa = kVar2;
        this.eTb = fVar;
    }

    public boolean bxT() {
        return this.eTA;
    }

    public void hc(boolean z) {
        this.eTA = z;
    }

    /* renamed from: f */
    protected d b(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, r rVar, Kind kind, kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar, ai aiVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2 = kVar;
        kotlin.jvm.internal.h.e(kVar2, "newOwner");
        Kind kind2 = kind;
        kotlin.jvm.internal.h.e(kind2, "kind");
        g gVar2 = gVar;
        kotlin.jvm.internal.h.e(gVar2, "annotations");
        ai aiVar2 = aiVar;
        kotlin.jvm.internal.h.e(aiVar2, b.SOURCE);
        d dVar = new d((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2, (j) rVar, gVar2, this.eCo, kind2, bxV(), aYI(), aYJ(), bxK(), bxL(), aiVar2);
        dVar.hc(bxT());
        return dVar;
    }
}
