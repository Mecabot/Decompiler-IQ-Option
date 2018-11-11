package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.i;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.h;

/* compiled from: FunctionDescriptorImpl */
public abstract class o extends k implements r {
    private List<an> eAR;
    private List<aq> eCG;
    private w eCH;
    private ag eCI;
    private ag eCJ;
    private av eCK = au.eBk;
    private boolean eCL = false;
    private boolean eCM = false;
    private boolean eCN = false;
    private boolean eCO = false;
    private boolean eCP = false;
    private boolean eCQ = false;
    private boolean eCR = false;
    private boolean eCS = false;
    private boolean eCT = true;
    private boolean eCU = false;
    private Collection<? extends r> eCV = null;
    private volatile kotlin.jvm.a.a<Collection<r>> eCW = null;
    private final r eCX;
    private final Kind eCY;
    private r eCZ = null;
    private Modality eCr;
    protected Map<b<?>, Object> eDa = null;
    private boolean isActual = false;
    private boolean isExternal = false;

    /* compiled from: FunctionDescriptorImpl */
    public class a implements kotlin.reflect.jvm.internal.impl.descriptors.r.a<r> {
        protected f eBW;
        protected ag eCJ = o.this.eCJ;
        private boolean eCQ = o.this.bdm();
        private boolean eCR = o.this.bdp();
        protected r eCX = null;
        protected Kind eCY;
        private Map<b<?>, Object> eDa = new LinkedHashMap();
        protected as eDd;
        protected k eDe;
        protected Modality eDf;
        protected av eDg;
        protected List<aq> eDh;
        protected w eDi;
        protected w eDj;
        protected boolean eDk = true;
        protected boolean eDl = false;
        protected boolean eDm = false;
        protected boolean eDn = false;
        private List<an> eDo = null;
        private g eDp = null;
        private Boolean eDq = null;
        protected boolean eDr = false;

        public a(as asVar, k kVar, Modality modality, av avVar, Kind kind, List<aq> list, w wVar, w wVar2, f fVar) {
            this.eDd = asVar;
            this.eDe = kVar;
            this.eDf = modality;
            this.eDg = avVar;
            this.eCY = kind;
            this.eDh = list;
            this.eDi = wVar;
            this.eDj = wVar2;
            this.eBW = fVar;
        }

        /* renamed from: n */
        public a h(k kVar) {
            this.eDe = kVar;
            return this;
        }

        /* renamed from: b */
        public a a(Modality modality) {
            this.eDf = modality;
            return this;
        }

        /* renamed from: e */
        public a a(av avVar) {
            this.eDg = avVar;
            return this;
        }

        /* renamed from: b */
        public a a(Kind kind) {
            this.eCY = kind;
            return this;
        }

        /* renamed from: gH */
        public a gu(boolean z) {
            this.eDk = z;
            return this;
        }

        /* renamed from: i */
        public a e(f fVar) {
            this.eBW = fVar;
            return this;
        }

        /* renamed from: cd */
        public a cb(List<aq> list) {
            this.eDh = list;
            return this;
        }

        /* renamed from: R */
        public a M(w wVar) {
            this.eDj = wVar;
            return this;
        }

        /* renamed from: S */
        public a N(w wVar) {
            this.eDi = wVar;
            return this;
        }

        /* renamed from: b */
        public a a(ag agVar) {
            this.eCJ = agVar;
            return this;
        }

        public a i(CallableMemberDescriptor callableMemberDescriptor) {
            this.eCX = (r) callableMemberDescriptor;
            return this;
        }

        /* renamed from: beH */
        public a bds() {
            this.eDl = true;
            return this;
        }

        /* renamed from: beI */
        public a bdt() {
            this.eDm = true;
            return this;
        }

        /* renamed from: beJ */
        public a bdu() {
            this.eDn = true;
            return this;
        }

        /* renamed from: beK */
        public a bdv() {
            this.eCQ = true;
            return this;
        }

        /* renamed from: beL */
        public a bdw() {
            this.eCR = true;
            return this;
        }

        /* renamed from: d */
        public a a(g gVar) {
            this.eDp = gVar;
            return this;
        }

        public a gI(boolean z) {
            this.eDq = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: c */
        public a b(as asVar) {
            this.eDd = asVar;
            return this;
        }

        public r bdx() {
            return o.this.a(this);
        }

        public a gJ(boolean z) {
            this.eDr = z;
            return this;
        }
    }

    protected abstract o a(k kVar, r rVar, Kind kind, f fVar, g gVar, ai aiVar);

    protected o(k kVar, r rVar, g gVar, f fVar, Kind kind, ai aiVar) {
        super(kVar, gVar, fVar, aiVar);
        if (rVar == null) {
            rVar = this;
        }
        this.eCX = rVar;
        this.eCY = kind;
    }

    public o a(w wVar, ag agVar, List<? extends an> list, List<aq> list2, w wVar2, Modality modality, av avVar) {
        this.eAR = u.W(list);
        this.eCG = u.W(list2);
        this.eCH = wVar2;
        this.eCr = modality;
        this.eCK = avVar;
        this.eCI = kotlin.reflect.jvm.internal.impl.resolve.b.a((kotlin.reflect.jvm.internal.impl.descriptors.a) this, wVar);
        this.eCJ = agVar;
        for (int i = 0; i < list.size(); i++) {
            an anVar = (an) list.get(i);
            if (anVar.getIndex() != i) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(anVar);
                stringBuilder.append(" index is ");
                stringBuilder.append(anVar.getIndex());
                stringBuilder.append(" but position is ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            aq aqVar = (aq) list2.get(i2);
            if (aqVar.getIndex() != i2 + 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(aqVar);
                stringBuilder2.append("index is ");
                stringBuilder2.append(aqVar.getIndex());
                stringBuilder2.append(" but position is ");
                stringBuilder2.append(i2);
                throw new IllegalStateException(stringBuilder2.toString());
            }
        }
        return this;
    }

    public void d(av avVar) {
        this.eCK = avVar;
    }

    public void gv(boolean z) {
        this.eCL = z;
    }

    public void gw(boolean z) {
        this.eCM = z;
    }

    public void gx(boolean z) {
        this.isExternal = z;
    }

    public void gy(boolean z) {
        this.eCN = z;
    }

    public void gz(boolean z) {
        this.eCO = z;
    }

    public void gA(boolean z) {
        this.eCP = z;
    }

    public void gB(boolean z) {
        this.isActual = z;
    }

    private void gC(boolean z) {
        this.eCQ = z;
    }

    private void gD(boolean z) {
        this.eCR = z;
    }

    public void gE(boolean z) {
        this.eCS = z;
    }

    public void Q(w wVar) {
        w wVar2 = this.eCH;
        this.eCH = wVar;
    }

    public void gF(boolean z) {
        this.eCT = z;
    }

    public void gG(boolean z) {
        this.eCU = z;
    }

    public ag bcO() {
        return this.eCI;
    }

    public ag bcP() {
        return this.eCJ;
    }

    public Collection<? extends r> bcU() {
        beE();
        return this.eCV != null ? this.eCV : Collections.emptyList();
    }

    private void beE() {
        kotlin.jvm.a.a aVar = this.eCW;
        if (aVar != null) {
            this.eCV = (Collection) aVar.invoke();
            this.eCW = null;
        }
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return this.eCK;
    }

    public boolean bdn() {
        if (this.eCL) {
            return true;
        }
        for (r bdn : beq().bcU()) {
            if (bdn.bdn()) {
                return true;
            }
        }
        return false;
    }

    public boolean bdo() {
        if (this.eCM) {
            return true;
        }
        for (r bdo : beq().bcU()) {
            if (bdo.bdo()) {
                return true;
            }
        }
        return false;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean bbN() {
        return this.eCN;
    }

    public boolean bcb() {
        return this.eCO;
    }

    public boolean bdq() {
        return this.eCS;
    }

    public boolean bbO() {
        return this.eCP;
    }

    public boolean bbP() {
        return this.isActual;
    }

    public <V> V a(b<V> bVar) {
        if (this.eDa == null) {
            return null;
        }
        return this.eDa.get(bVar);
    }

    public boolean bdm() {
        return this.eCQ;
    }

    public void Q(Collection<? extends CallableMemberDescriptor> collection) {
        this.eCV = collection;
        for (r bdp : this.eCV) {
            if (bdp.bdp()) {
                this.eCR = true;
                return;
            }
        }
    }

    public List<an> getTypeParameters() {
        return this.eAR;
    }

    public List<aq> bcS() {
        return this.eCG;
    }

    public boolean beF() {
        return this.eCT;
    }

    public boolean bcT() {
        return this.eCU;
    }

    public w bcQ() {
        return this.eCH;
    }

    /* renamed from: bdk */
    public r beq() {
        return this.eCX == this ? this : this.eCX.bdk();
    }

    public Kind bcW() {
        return this.eCY;
    }

    /* renamed from: c */
    public r f(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return h(typeSubstitutor).i(beq()).gJ(true).bdx();
    }

    private w beG() {
        if (this.eCI == null) {
            return null;
        }
        return this.eCI.bai();
    }

    public boolean bdp() {
        return this.eCR;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.r.a<? extends r> bdr() {
        return h(TypeSubstitutor.eVk);
    }

    protected a h(TypeSubstitutor typeSubstitutor) {
        return new a(typeSubstitutor.bzi(), bbv(), bbG(), bbJ(), bcW(), bcS(), beG(), bcQ(), null);
    }

    protected r a(a aVar) {
        a aVar2 = aVar;
        boolean[] zArr = new boolean[1];
        r a = a(aVar2.eDe, aVar2.eCX, aVar2.eCY, aVar2.eBW, aVar.eDp != null ? i.a(bbQ(), aVar.eDp) : bbQ(), a(aVar2.eDm, aVar2.eCX));
        List typeParameters = aVar.eDo == null ? getTypeParameters() : aVar.eDo;
        zArr[0] = zArr[0] | (typeParameters.isEmpty() ^ 1);
        List arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor a2 = kotlin.reflect.jvm.internal.impl.types.k.a(typeParameters, aVar2.eDd, a, arrayList, zArr);
        if (a2 == null) {
            return null;
        }
        w wVar;
        ag agVar;
        if (aVar2.eDi != null) {
            w c = a2.c(aVar2.eDi, Variance.IN_VARIANCE);
            if (c == null) {
                return null;
            }
            zArr[0] = zArr[0] | (c != aVar2.eDi ? 1 : 0);
            wVar = c;
        } else {
            wVar = null;
        }
        if (aVar2.eCJ != null) {
            ag e = aVar2.eCJ.e(a2);
            if (e == null) {
                return null;
            }
            zArr[0] = zArr[0] | (e != aVar2.eCJ ? 1 : 0);
            agVar = e;
        } else {
            agVar = null;
        }
        typeParameters = a(a, aVar2.eDh, a2, aVar2.eDn, aVar2.eDm, zArr);
        if (typeParameters == null) {
            return null;
        }
        w c2 = a2.c(aVar2.eDj, Variance.OUT_VARIANCE);
        if (c2 == null) {
            return null;
        }
        zArr[0] = zArr[0] | (c2 != aVar2.eDj ? 1 : 0);
        if (!zArr[0] && aVar2.eDr) {
            return this;
        }
        final TypeSubstitutor typeSubstitutor = a2;
        a.a(wVar, agVar, arrayList, typeParameters, c2, aVar2.eDf, aVar2.eDg);
        a.gv(this.eCL);
        a.gw(this.eCM);
        a.gx(this.isExternal);
        a.gy(this.eCN);
        a.gz(this.eCO);
        a.gE(this.eCS);
        a.gA(this.eCP);
        a.gB(this.isActual);
        a.gF(this.eCT);
        a.gC(aVar.eCQ);
        a.gD(aVar.eCR);
        a.gG(aVar.eDq != null ? aVar.eDq.booleanValue() : this.eCU);
        if (!(aVar.eDa.isEmpty() && this.eDa == null)) {
            Map g = aVar.eDa;
            if (this.eDa != null) {
                for (Entry entry : this.eDa.entrySet()) {
                    if (!g.containsKey(entry.getKey())) {
                        g.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (g.size() == 1) {
                a.eDa = Collections.singletonMap(g.keySet().iterator().next(), g.values().iterator().next());
            } else {
                a.eDa = g;
            }
        }
        if (aVar2.eDl || bdl() != null) {
            a.g((bdl() != null ? bdl() : this).c(typeSubstitutor));
        }
        if (aVar2.eDk && !beq().bcU().isEmpty()) {
            if (aVar2.eDd.isEmpty()) {
                kotlin.jvm.a.a aVar3 = this.eCW;
                if (aVar3 != null) {
                    a.eCW = aVar3;
                } else {
                    a.Q(bcU());
                }
            } else {
                a.eCW = new kotlin.jvm.a.a<Collection<r>>() {
                    /* renamed from: aZh */
                    public Collection<r> invoke() {
                        Collection<r> hVar = new h();
                        for (r c : o.this.bcU()) {
                            hVar.add(c.c(typeSubstitutor));
                        }
                        return hVar;
                    }
                };
            }
        }
        return a;
    }

    /* renamed from: c */
    public r a(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        return bdr().h(kVar).a(modality).a(avVar).a(kind).gu(z).bdx();
    }

    private ai a(boolean z, r rVar) {
        if (!z) {
            return ai.eAX;
        }
        if (rVar == null) {
            rVar = beq();
        }
        return rVar.bbR();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((r) this, (Object) d);
    }

    public static List<aq> a(r rVar, List<aq> list, TypeSubstitutor typeSubstitutor) {
        return a(rVar, (List) list, typeSubstitutor, false, false, null);
    }

    public static List<aq> a(r rVar, List<aq> list, TypeSubstitutor typeSubstitutor, boolean z, boolean z2, boolean[] zArr) {
        TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
        List<aq> arrayList = new ArrayList(list.size());
        for (aq aqVar : list) {
            w wVar;
            w c = typeSubstitutor2.c(aqVar.bai(), Variance.IN_VARIANCE);
            w bdS = aqVar.bdS();
            if (bdS == null) {
                wVar = null;
            } else {
                wVar = typeSubstitutor2.c(bdS, Variance.IN_VARIANCE);
            }
            if (c == null) {
                return null;
            }
            if (!((c == aqVar.bai() && bdS == wVar) || zArr == null)) {
                zArr[0] = true;
            }
            arrayList.add(new ah(rVar, z ? null : aqVar, aqVar.getIndex(), aqVar.bbQ(), aqVar.bdc(), c, aqVar.bdR(), aqVar.bdU(), aqVar.bdV(), wVar, z2 ? aqVar.bbR() : ai.eAX));
        }
        return arrayList;
    }

    public r bdl() {
        return this.eCZ;
    }

    private void g(r rVar) {
        this.eCZ = rVar;
    }

    public <V> void a(b<V> bVar, Object obj) {
        if (this.eDa == null) {
            this.eDa = new LinkedHashMap();
        }
        this.eDa.put(bVar, obj);
    }
}
