package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.b;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* compiled from: PropertyDescriptorImpl */
public class y extends aj implements ad {
    private List<an> eAR;
    private ag eCI;
    private ag eCJ;
    private av eCK;
    private final boolean eCP;
    private final Kind eCY;
    private final Modality eCr;
    private Collection<? extends ad> eDO = null;
    private final ad eDP;
    private final boolean eDQ;
    private final boolean eDR;
    private final boolean eDS;
    private z eDT;
    private af eDU;
    private boolean eDV;
    private final boolean isActual;
    private final boolean isExternal;

    /* compiled from: PropertyDescriptorImpl */
    public class a {
        private f eBW = y.this.bdc();
        private ag eCJ = y.this.eCJ;
        private av eCK = y.this.bbJ();
        private Kind eCY = y.this.bcW();
        private Modality eCr = y.this.bbG();
        private ad eDP = null;
        private k eDW = y.this.bbv();
        private as eDd = as.eVi;
        private boolean eDk = true;
        private List<an> eDo = null;

        public a o(k kVar) {
            this.eDW = kVar;
            return this;
        }

        public a j(CallableMemberDescriptor callableMemberDescriptor) {
            this.eDP = (ad) callableMemberDescriptor;
            return this;
        }

        public a d(Modality modality) {
            this.eCr = modality;
            return this;
        }

        public a f(av avVar) {
            this.eCK = avVar;
            return this;
        }

        public a c(Kind kind) {
            this.eCY = kind;
            return this;
        }

        public a d(as asVar) {
            this.eDd = asVar;
            return this;
        }

        public a gN(boolean z) {
            this.eDk = z;
            return this;
        }

        public ad bfe() {
            return y.this.a(this);
        }
    }

    protected y(k kVar, ad adVar, g gVar, Modality modality, av avVar, boolean z, f fVar, Kind kind, ai aiVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(kVar, gVar, fVar, null, z, aiVar);
        this.eCr = modality;
        this.eCK = avVar;
        this.eDP = adVar == null ? this : adVar;
        this.eCY = kind;
        this.eDQ = z2;
        this.eDR = z3;
        this.eCP = z4;
        this.isActual = z5;
        this.isExternal = z6;
        this.eDS = z7;
    }

    public static y a(k kVar, g gVar, Modality modality, av avVar, boolean z, f fVar, Kind kind, ai aiVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return new y(kVar, null, gVar, modality, avVar, z, fVar, kind, aiVar, z2, z3, z4, z5, z6, z7);
    }

    public void a(w wVar, List<? extends an> list, ag agVar, w wVar2) {
        a(wVar, (List) list, agVar, b.a((kotlin.reflect.jvm.internal.impl.descriptors.a) this, wVar2));
    }

    public void a(w wVar, List<? extends an> list, ag agVar, ag agVar2) {
        W(wVar);
        this.eAR = new ArrayList(list);
        this.eCI = agVar2;
        this.eCJ = agVar;
    }

    public void a(z zVar, af afVar) {
        this.eDT = zVar;
        this.eDU = afVar;
    }

    public void gM(boolean z) {
        this.eDV = z;
    }

    public void d(av avVar) {
        this.eCK = avVar;
    }

    public List<an> getTypeParameters() {
        return this.eAR;
    }

    public ag bcO() {
        return this.eCI;
    }

    public ag bcP() {
        return this.eCJ;
    }

    public w bcQ() {
        return bai();
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return this.eCK;
    }

    /* renamed from: bfa */
    public z bdI() {
        return this.eDT;
    }

    public af bdJ() {
        return this.eDU;
    }

    public boolean bfb() {
        return this.eDV;
    }

    public boolean bdZ() {
        return this.eDQ;
    }

    public boolean bdY() {
        return this.eDR;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isDelegated() {
        return this.eDS;
    }

    public List<ac> bdK() {
        List<ac> arrayList = new ArrayList(2);
        if (this.eDT != null) {
            arrayList.add(this.eDT);
        }
        if (this.eDU != null) {
            arrayList.add(this.eDU);
        }
        return arrayList;
    }

    /* renamed from: d */
    public ad f(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return bfc().d(typeSubstitutor.bzi()).j(bfd()).bfe();
    }

    public a bfc() {
        return new a();
    }

    protected ad a(a aVar) {
        ad a = a(aVar.eDW, aVar.eCr, aVar.eCK, aVar.eDP, aVar.eCY, aVar.eBW);
        List typeParameters = aVar.eDo == null ? getTypeParameters() : aVar.eDo;
        List arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor a2 = kotlin.reflect.jvm.internal.impl.types.k.a(typeParameters, aVar.eDd, a, arrayList);
        w c = a2.c(bai(), Variance.OUT_VARIANCE);
        ad adVar = null;
        if (c == null) {
            return null;
        }
        w c2;
        z zVar;
        af afVar;
        ag j = aVar.eCJ;
        if (j != null) {
            j = j.e(a2);
            if (j == null) {
                return null;
            }
        }
        j = null;
        if (this.eCI != null) {
            c2 = a2.c(this.eCI.bai(), Variance.IN_VARIANCE);
            if (c2 == null) {
                return null;
            }
        }
        c2 = null;
        a.a(c, arrayList, j, c2);
        if (this.eDT == null) {
            zVar = null;
        } else {
            z zVar2 = new z(a, this.eDT.bbQ(), aVar.eCr, a(this.eDT.bbJ(), aVar.eCY), this.eDT.isDefault(), this.eDT.isExternal(), this.eDT.bbN(), aVar.eCY, aVar.eDP == null ? null : aVar.eDP.bdI(), ai.eAX);
        }
        if (zVar != null) {
            c = this.eDT.bcQ();
            zVar.g(a(a2, this.eDT));
            zVar.T(c != null ? a2.c(c, Variance.OUT_VARIANCE) : null);
        }
        if (this.eDU == null) {
            afVar = null;
        } else {
            g bbQ = this.eDU.bbQ();
            Modality c3 = aVar.eCr;
            av a3 = a(this.eDU.bbJ(), aVar.eCY);
            boolean isDefault = this.eDU.isDefault();
            boolean isExternal = this.eDU.isExternal();
            boolean bbN = this.eDU.bbN();
            Kind f = aVar.eCY;
            if (aVar.eDP != null) {
                adVar = aVar.eDP.bdJ();
            }
            af aaVar = new aa(a, bbQ, c3, a3, isDefault, isExternal, bbN, f, adVar, ai.eAX);
        }
        if (afVar != null) {
            List a4 = o.a((r) afVar, this.eDU.bcS(), a2, false, false, null);
            if (a4 == null) {
                a.gM(true);
                a4 = Collections.singletonList(aa.a(afVar, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(aVar.eDW).baS()));
            }
            if (a4.size() != 1) {
                throw new IllegalStateException();
            }
            afVar.g(a(a2, this.eDU));
            afVar.c((aq) a4.get(0));
        }
        a.a(zVar, afVar);
        if (aVar.eDk) {
            Collection bzH = i.bzH();
            for (ad adVar2 : bcU()) {
                bzH.add(adVar2.d(a2));
            }
            a.Q(bzH);
        }
        if (bdY() && this.eEr != null) {
            a.a(this.eEr);
        }
        return a;
    }

    private static av a(av avVar, Kind kind) {
        return (kind == Kind.FAKE_OVERRIDE && au.b(avVar.bec())) ? au.eBj : avVar;
    }

    private static r a(TypeSubstitutor typeSubstitutor, ac acVar) {
        return acVar.bdl() != null ? acVar.bdl().c(typeSubstitutor) : null;
    }

    protected y a(k kVar, Modality modality, av avVar, ad adVar, Kind kind, f fVar) {
        return new y(kVar, adVar, bbQ(), modality, avVar, bdW(), fVar, kind, ai.eAX, bdZ(), bdY(), bbO(), bbP(), isExternal(), isDelegated());
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((ad) this, (Object) d);
    }

    /* renamed from: bdL */
    public ad bfd() {
        return this.eDP == this ? this : this.eDP.bdL();
    }

    public Kind bcW() {
        return this.eCY;
    }

    public boolean bbO() {
        return this.eCP;
    }

    public boolean bbP() {
        return this.isActual;
    }

    public void Q(Collection<? extends CallableMemberDescriptor> collection) {
        this.eDO = collection;
    }

    public Collection<? extends ad> bcU() {
        return this.eDO != null ? this.eDO : Collections.emptyList();
    }

    /* renamed from: e */
    public ad a(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        return bfc().o(kVar).j(null).d(modality).f(avVar).c(kind).gN(z).bfe();
    }
}
