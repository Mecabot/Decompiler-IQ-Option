package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.m;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.storage.f;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ag;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class af extends o implements ae {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(af.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public static final a eEg = new a();
    private final f eEd;
    private c eEe;
    private final am eEf;
    private final h exB;

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final TypeSubstitutor a(am amVar) {
            if (amVar.bdP() == null) {
                return null;
            }
            return TypeSubstitutor.aQ(amVar.bdO());
        }

        public final ae a(h hVar, am amVar, c cVar) {
            am amVar2 = amVar;
            c cVar2 = cVar;
            h hVar2 = hVar;
            kotlin.jvm.internal.h.e(hVar2, "storageManager");
            kotlin.jvm.internal.h.e(amVar2, "typeAliasDescriptor");
            kotlin.jvm.internal.h.e(cVar2, "constructor");
            TypeSubstitutor a = a(amVar2);
            ae aeVar = null;
            if (a == null) {
                return null;
            }
            c a2 = cVar2.a(a);
            if (a2 == null) {
                return null;
            }
            g bbQ = cVar.bbQ();
            Kind bcW = cVar.bcW();
            kotlin.jvm.internal.h.d(bcW, "constructor.kind");
            ai bbR = amVar.bbR();
            kotlin.jvm.internal.h.d(bbR, "typeAliasDescriptor.source");
            af afVar = new af(hVar2, amVar2, a2, null, bbQ, bcW, bbR, null);
            List a3 = o.a(afVar, cVar.bcS(), a);
            if (a3 == null) {
                return null;
            }
            ad aD = t.aD(a2.bcQ().bzc());
            ad bdb = amVar.bdb();
            kotlin.jvm.internal.h.d(bdb, "typeAliasDescriptor.defaultType");
            aD = ag.b(aD, bdb);
            kotlin.reflect.jvm.internal.impl.descriptors.ag bcP = cVar.bcP();
            if (bcP != null) {
                kotlin.jvm.internal.h.d(bcP, "it");
                aeVar = a.b(bcP.bai(), Variance.INVARIANT);
            }
            afVar.a(aeVar, null, amVar.bbS(), a3, aD, Modality.FINAL, amVar.bbJ());
            return afVar;
        }
    }

    public /* synthetic */ af(h hVar, am amVar, c cVar, ae aeVar, g gVar, Kind kind, ai aiVar, f fVar) {
        this(hVar, amVar, cVar, aeVar, gVar, kind, aiVar);
    }

    public final h baI() {
        return this.exB;
    }

    public am bfm() {
        return this.eEf;
    }

    private af(h hVar, am amVar, c cVar, ae aeVar, g gVar, Kind kind, ai aiVar) {
        super(amVar, aeVar, gVar, kotlin.reflect.jvm.internal.impl.name.f.mF("<init>"), kind, aiVar);
        this.exB = hVar;
        this.eEf = amVar;
        gB(bfm().bbP());
        this.eEd = this.exB.j(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, cVar));
        this.eEe = cVar;
    }

    private void a(c cVar) {
        this.eEe = cVar;
    }

    public c bfj() {
        return this.eEe;
    }

    /* renamed from: bfk */
    public am bdj() {
        return bfm();
    }

    public w bcQ() {
        w bcQ = super.bcQ();
        if (bcQ == null) {
            kotlin.jvm.internal.h.aXZ();
        }
        return bcQ;
    }

    /* renamed from: bfl */
    public ae beq() {
        r bdk = super.beq();
        if (bdk != null) {
            return (ae) bdk;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    /* renamed from: i */
    public ae f(TypeSubstitutor typeSubstitutor) {
        kotlin.jvm.internal.h.e(typeSubstitutor, "substitutor");
        r c = super.f(typeSubstitutor);
        if (c == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        }
        af afVar = (af) c;
        TypeSubstitutor aQ = TypeSubstitutor.aQ(afVar.bcQ());
        c bdf = bfj().bdf();
        kotlin.jvm.internal.h.d(aQ, "underlyingConstructorSubstitutor");
        c a = bdf.a(aQ);
        if (a == null) {
            return null;
        }
        afVar.a(a);
        return afVar;
    }

    /* renamed from: g */
    public ae c(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        kotlin.jvm.internal.h.e(kVar, "newOwner");
        kotlin.jvm.internal.h.e(modality, "modality");
        kotlin.jvm.internal.h.e(avVar, "visibility");
        kotlin.jvm.internal.h.e(kind, "kind");
        r bdx = bdr().h(kVar).a(modality).a(avVar).a(kind).gu(z).bdx();
        if (bdx != null) {
            return (ae) bdx;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    /* renamed from: c */
    protected af a(k kVar, r rVar, Kind kind, kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar, ai aiVar) {
        kotlin.jvm.internal.h.e(kVar, "newOwner");
        kotlin.jvm.internal.h.e(kind, "kind");
        kotlin.jvm.internal.h.e(gVar, "annotations");
        kotlin.jvm.internal.h.e(aiVar, b.SOURCE);
        Object obj = 1;
        Object obj2 = (kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED) ? 1 : null;
        if (m.etY && obj2 == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Creating a type alias constructor that is not a declaration: \ncopy from: ");
            stringBuilder.append(this);
            stringBuilder.append("\nnewOwner: ");
            stringBuilder.append(kVar);
            stringBuilder.append("\nkind: ");
            stringBuilder.append(kind);
            throw new AssertionError(stringBuilder.toString());
        }
        if (fVar != null) {
            obj = null;
        }
        if (m.etY && obj == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Renaming type alias constructor: ");
            stringBuilder2.append(this);
            throw new AssertionError(stringBuilder2.toString());
        }
        return new af(this.exB, bfm(), bfj(), this, gVar, Kind.DECLARATION, aiVar);
    }
}
