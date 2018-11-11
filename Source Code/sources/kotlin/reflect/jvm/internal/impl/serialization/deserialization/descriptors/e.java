package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.l;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import kotlin.reflect.jvm.internal.impl.storage.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DeserializedClassDescriptor.kt */
public final class e extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a {
    private final kotlin.reflect.jvm.internal.impl.name.a classId;
    private final g eBt;
    private final av eCK = s.eTk.a((Visibility) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLi.get(this.eSB.getFlags()));
    private final k eCq;
    private final Modality eCr = s.eTk.a((ProtoBuf.Modality) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLj.get(this.eSB.getFlags()));
    private final ClassKind eCs = s.eTk.a((Kind) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLk.get(this.eSB.getFlags()));
    private final kotlin.reflect.jvm.internal.impl.storage.e<Collection<kotlin.reflect.jvm.internal.impl.descriptors.c>> eHC;
    private final Class eSB;
    private final kotlin.reflect.jvm.internal.impl.metadata.a.a eSC;
    private final ai eSD;
    private final i eTC;
    private final b eTD;
    private final a eTE;
    private final c eTF;
    private final f<kotlin.reflect.jvm.internal.impl.descriptors.c> eTG;
    private final f<d> eTH;
    private final kotlin.reflect.jvm.internal.impl.storage.e<Collection<d>> eTI;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a eTJ;
    private final j eTh;

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class c {
        private final kotlin.reflect.jvm.internal.impl.storage.e<Set<kotlin.reflect.jvm.internal.impl.name.f>> eCy;
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, EnumEntry> eTL;
        private final kotlin.reflect.jvm.internal.impl.storage.c<kotlin.reflect.jvm.internal.impl.name.f, d> eTM;

        public c() {
            List bkB = e.this.byk().bkB();
            h.d(bkB, "classProto.enumEntryList");
            Iterable iterable = bkB;
            Map linkedHashMap = new LinkedHashMap(j.be(ad.jn(n.e(iterable, 10)), 16));
            for (Object next : iterable) {
                EnumEntry enumEntry = (EnumEntry) next;
                kotlin.reflect.jvm.internal.impl.metadata.a.c aYI = e.this.bxX().aYI();
                h.d(enumEntry, "it");
                linkedHashMap.put(q.b(aYI, enumEntry.blW()), next);
            }
            this.eTL = linkedHashMap;
            this.eTM = e.this.bxX().baI().p(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this));
            this.eCy = e.this.bxX().baI().i(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        public final d Q(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            h.e(fVar, "name");
            return (d) this.eTM.invoke(fVar);
        }

        private final Set<kotlin.reflect.jvm.internal.impl.name.f> byq() {
            kotlin.reflect.jvm.internal.impl.metadata.a.c aYI;
            HashSet hashSet = new HashSet();
            for (w bbk : e.this.bby().beu()) {
                for (k kVar : kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a.a(bbk.bbk(), null, null, 3, null)) {
                    if ((kVar instanceof ah) || (kVar instanceof ad)) {
                        hashSet.add(kVar.bdc());
                    }
                }
            }
            List<Function> bkv = e.this.byk().bkv();
            h.d(bkv, "classProto.functionList");
            for (Function function : bkv) {
                Collection collection = hashSet;
                aYI = e.this.bxX().aYI();
                h.d(function, "it");
                collection.add(q.b(aYI, function.blW()));
            }
            Collection collection2 = hashSet;
            Set set = (Set) collection2;
            List<Property> bkx = e.this.byk().bkx();
            h.d(bkx, "classProto.propertyList");
            for (Property property : bkx) {
                aYI = e.this.bxX().aYI();
                h.d(property, "it");
                collection2.add(q.b(aYI, property.blW()));
            }
            return ak.a(set, collection2);
        }

        public final Collection<d> byr() {
            Collection arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.name.f Q : this.eTL.keySet()) {
                d Q2 = Q(Q);
                if (Q2 != null) {
                    arrayList.add(Q2);
                }
            }
            return (List) arrayList;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class b extends kotlin.reflect.jvm.internal.impl.types.b {
        private final kotlin.reflect.jvm.internal.impl.storage.e<List<an>> eHB;

        public boolean bbY() {
            return true;
        }

        public b() {
            super(e.this.bxX().baI());
            this.eHB = e.this.bxX().baI().i(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(this));
        }

        protected Collection<w> bbU() {
            Iterable<Type> a = kotlin.reflect.jvm.internal.impl.metadata.a.g.a(e.this.byk(), e.this.bxX().aYJ());
            Collection arrayList = new ArrayList(n.e(a, 10));
            for (Type a2 : a) {
                arrayList.add(v.a(e.this.bxX().bxI(), a2, null, 2, null));
            }
            Iterable<w> b = u.b((Collection) (List) arrayList, (Iterable) e.this.bxX().biq().baF().l(e.this));
            arrayList = new ArrayList();
            for (w bwA : b) {
                kotlin.reflect.jvm.internal.impl.descriptors.f bbW = bwA.bwA().bbW();
                if (!(bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.w.b)) {
                    bbW = null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.w.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.w.b) bbW;
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
            List list = (List) arrayList;
            if ((list.isEmpty() ^ 1) != 0) {
                l bfZ = e.this.bxX().biq().bfZ();
                d dVar = e.this;
                Iterable<kotlin.reflect.jvm.internal.impl.descriptors.w.b> iterable = list;
                Collection arrayList2 = new ArrayList(n.e(iterable, 10));
                for (kotlin.reflect.jvm.internal.impl.descriptors.w.b bVar2 : iterable) {
                    Object asString;
                    kotlin.reflect.jvm.internal.impl.name.a c = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.c(bVar2);
                    if (c != null) {
                        kotlin.reflect.jvm.internal.impl.name.b btK = c.btK();
                        if (btK != null) {
                            asString = btK.asString();
                            if (asString != null) {
                                arrayList2.add(asString);
                            }
                        }
                    }
                    asString = bVar2.bdc().asString();
                    arrayList2.add(asString);
                }
                bfZ.a(dVar, (List) arrayList2);
            }
            return u.W(b);
        }

        public List<an> getParameters() {
            return (List) this.eHB.invoke();
        }

        /* renamed from: byp */
        public e bbX() {
            return e.this;
        }

        public String toString() {
            return e.this.bdc().toString();
        }

        protected al bbZ() {
            return kotlin.reflect.jvm.internal.impl.descriptors.al.a.eAZ;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class a extends h {
        private final kotlin.reflect.jvm.internal.impl.storage.e<Collection<k>> eCB;

        /* compiled from: DeserializedClassDescriptor.kt */
        public static final class a extends kotlin.reflect.jvm.internal.impl.resolve.g {
            final /* synthetic */ Collection eTK;

            protected void a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                h.e(callableMemberDescriptor, "fromSuper");
                h.e(callableMemberDescriptor2, "fromCurrent");
            }

            a(Collection collection) {
                this.eTK = collection;
            }

            public void h(CallableMemberDescriptor callableMemberDescriptor) {
                h.e(callableMemberDescriptor, "fakeOverride");
                OverridingUtil.a(callableMemberDescriptor, null);
                this.eTK.add(callableMemberDescriptor);
            }
        }

        public a() {
            j bxX = e.this.bxX();
            List bkv = e.this.byk().bkv();
            h.d(bkv, "classProto.functionList");
            Collection collection = bkv;
            bkv = e.this.byk().bkx();
            h.d(bkv, "classProto.propertyList");
            Collection collection2 = bkv;
            bkv = e.this.byk().bkz();
            h.d(bkv, "classProto.typeAliasList");
            Collection collection3 = bkv;
            bkv = e.this.byk().bks();
            h.d(bkv, "classProto.nestedClassNameList");
            Iterable<Number> iterable = bkv;
            kotlin.reflect.jvm.internal.impl.metadata.a.c aYI = e.this.bxX().aYI();
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (Number intValue : iterable) {
                arrayList.add(q.b(aYI, intValue.intValue()));
            }
            super(bxX, collection, collection2, collection3, new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1((List) arrayList));
            this.eCB = bxX().baI().i(new DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(this));
        }

        private final e bym() {
            return e.this;
        }

        public Collection<k> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
            h.e(dVar, "kindFilter");
            h.e(bVar, "nameFilter");
            return (Collection) this.eCB.invoke();
        }

        public Collection<ah> b(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            h.e(fVar, "name");
            h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
            d(fVar, bVar);
            return super.b(fVar, bVar);
        }

        public Collection<ad> a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            h.e(fVar, "name");
            h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
            d(fVar, bVar);
            return super.a(fVar, bVar);
        }

        protected void d(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<ah> collection) {
            h.e(fVar, "name");
            h.e(collection, "functions");
            ArrayList arrayList = new ArrayList();
            for (w bbk : bym().bby().beu()) {
                arrayList.addAll(bbk.bbk().b(fVar, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            r.a((Iterable) collection, (kotlin.jvm.a.b) new DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1(this));
            collection.addAll(bxX().biq().baF().a(fVar, e.this));
            a(fVar, arrayList, collection);
        }

        protected void b(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<ad> collection) {
            h.e(fVar, "name");
            h.e(collection, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (w bbk : bym().bby().beu()) {
                arrayList.addAll(bbk.bbk().a(fVar, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            a(fVar, arrayList, collection);
        }

        private final <D extends CallableMemberDescriptor> void a(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends D> collection, Collection<D> collection2) {
            OverridingUtil.a(fVar, collection, new ArrayList(collection2), bym(), new a(collection2));
        }

        protected Set<kotlin.reflect.jvm.internal.impl.name.f> byn() {
            Collection linkedHashSet = new LinkedHashSet();
            for (w bbk : bym().eTD.beu()) {
                r.a(linkedHashSet, (Iterable) bbk.bbk().beC());
            }
            ((LinkedHashSet) linkedHashSet).addAll(bxX().biq().baF().n(e.this));
            return (Set) linkedHashSet;
        }

        protected Set<kotlin.reflect.jvm.internal.impl.name.f> byo() {
            Collection linkedHashSet = new LinkedHashSet();
            for (w bbk : bym().eTD.beu()) {
                r.a(linkedHashSet, (Iterable) bbk.bbk().beD());
            }
            return (Set) linkedHashSet;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.f c(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            h.e(fVar, "name");
            h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
            d(fVar, bVar);
            c b = bym().eTF;
            if (b != null) {
                d Q = b.Q(fVar);
                if (Q != null) {
                    return Q;
                }
            }
            return super.c(fVar, bVar);
        }

        protected kotlin.reflect.jvm.internal.impl.name.a P(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            h.e(fVar, "name");
            return e.this.classId.B(fVar);
        }

        protected void c(Collection<k> collection, kotlin.jvm.a.b<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> bVar) {
            h.e(collection, "result");
            h.e(bVar, "nameFilter");
            c b = bym().eTF;
            Collection byr = b != null ? b.byr() : null;
            if (byr == null) {
                byr = m.emptyList();
            }
            collection.addAll(byr);
        }

        public void d(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            h.e(fVar, "name");
            h.e(bVar, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
            kotlin.reflect.jvm.internal.impl.incremental.a.a(bxX().biq().bgf(), bVar, (d) bym(), fVar);
        }
    }

    public boolean bbP() {
        return false;
    }

    public /* synthetic */ boolean bbL() {
        return bxZ().booleanValue();
    }

    public /* synthetic */ boolean bbM() {
        return bya().booleanValue();
    }

    public /* synthetic */ boolean bbN() {
        return byb().booleanValue();
    }

    public /* synthetic */ boolean bbO() {
        return byc().booleanValue();
    }

    public /* synthetic */ boolean isExternal() {
        return byd().booleanValue();
    }

    public final Class byk() {
        return this.eSB;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.a.a byl() {
        return this.eSC;
    }

    public e(j jVar, Class classR, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.a aVar, ai aiVar) {
        g nVar;
        h.e(jVar, "outerContext");
        h.e(classR, "classProto");
        h.e(cVar, "nameResolver");
        h.e(aVar, "metadataVersion");
        h.e(aiVar, "sourceElement");
        super(jVar.baI(), q.a(cVar, classR.bkk()).btH());
        this.eSB = classR;
        this.eSC = aVar;
        this.eSD = aiVar;
        this.classId = q.a(cVar, this.eSB.bkk());
        k kVar = this;
        List bkn = this.eSB.bkn();
        h.d(bkn, "classProto.typeParameterList");
        TypeTable bkF = this.eSB.bkF();
        h.d(bkF, "classProto.typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.a.h hVar = new kotlin.reflect.jvm.internal.impl.metadata.a.h(bkF);
        kotlin.reflect.jvm.internal.impl.metadata.a.k.a aVar2 = kotlin.reflect.jvm.internal.impl.metadata.a.k.eMf;
        VersionRequirementTable bkI = this.eSB.bkI();
        h.d(bkI, "classProto.versionRequirementTable");
        this.eTh = jVar.a(kVar, bkn, cVar, hVar, aVar2.g(bkI), this.eSC);
        this.eTC = this.eCs == ClassKind.ENUM_CLASS ? new kotlin.reflect.jvm.internal.impl.resolve.scopes.k(this.eTh.baI(), this) : kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c.eSm;
        this.eTD = new b();
        this.eTE = new a();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar3 = null;
        this.eTF = this.eCs == ClassKind.ENUM_CLASS ? new c() : null;
        this.eCq = jVar.bbv();
        this.eTG = this.eTh.baI().j(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.eHC = this.eTh.baI().i(new DeserializedClassDescriptor$constructors$1(this));
        this.eTH = this.eTh.baI().j(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.eTI = this.eTh.baI().i(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        Class classR2 = this.eSB;
        kotlin.reflect.jvm.internal.impl.metadata.a.c aYI = this.eTh.aYI();
        kotlin.reflect.jvm.internal.impl.metadata.a.h aYJ = this.eTh.aYJ();
        ai aiVar2 = this.eSD;
        k kVar2 = this.eCq;
        if (!(kVar2 instanceof e)) {
            kVar2 = null;
        }
        e eVar = (e) kVar2;
        if (eVar != null) {
            aVar3 = eVar.eTJ;
        }
        this.eTJ = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a(classR2, aYI, aYJ, aiVar2, aVar3);
        if (kotlin.reflect.jvm.internal.impl.metadata.a.b.eLh.get(this.eSB.getFlags()).booleanValue()) {
            nVar = new n(this.eTh.baI(), new DeserializedClassDescriptor$annotations$1(this));
        } else {
            nVar = g.eBF.bel();
        }
        this.eBt = nVar;
    }

    public final j bxX() {
        return this.eTh;
    }

    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a bxY() {
        return this.eTJ;
    }

    public g bbQ() {
        return this.eBt;
    }

    public k bbv() {
        return this.eCq;
    }

    public kotlin.reflect.jvm.internal.impl.types.an bby() {
        return this.eTD;
    }

    public ClassKind bbF() {
        return this.eCs;
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return this.eCK;
    }

    public Boolean bxZ() {
        return kotlin.reflect.jvm.internal.impl.metadata.a.b.eLl.get(this.eSB.getFlags());
    }

    public Boolean bya() {
        return kotlin.reflect.jvm.internal.impl.metadata.a.b.eLm.get(this.eSB.getFlags());
    }

    public Boolean byb() {
        return kotlin.reflect.jvm.internal.impl.metadata.a.b.eLp.get(this.eSB.getFlags());
    }

    public Boolean byc() {
        return kotlin.reflect.jvm.internal.impl.metadata.a.b.eLo.get(this.eSB.getFlags());
    }

    public Boolean byd() {
        return kotlin.reflect.jvm.internal.impl.metadata.a.b.eLn.get(this.eSB.getFlags());
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbA() {
        return this.eTE;
    }

    /* renamed from: bye */
    public i bbx() {
        return this.eTC;
    }

    public boolean bbK() {
        return ((Kind) kotlin.reflect.jvm.internal.impl.metadata.a.b.eLk.get(this.eSB.getFlags())) == Kind.COMPANION_OBJECT;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.c byf() {
        if (this.eCs.isSingleton()) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.f a = kotlin.reflect.jvm.internal.impl.resolve.b.a((d) this, ai.eAX);
            a.Q((w) bdb());
            return a;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.c cVar;
        Object obj;
        List bkt = this.eSB.bkt();
        h.d(bkt, "classProto.constructorList");
        Iterator it = bkt.iterator();
        kotlin.reflect.jvm.internal.impl.metadata.a.b.a aVar;
        Constructor constructor;
        do {
            cVar = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            constructor = (Constructor) obj;
            aVar = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLq;
            h.d(constructor, "it");
        } while ((aVar.get(constructor.getFlags()).booleanValue() ^ 1) == 0);
        Constructor constructor2 = (Constructor) obj;
        if (constructor2 != null) {
            cVar = this.eTh.bxJ().a(constructor2, true);
        }
        return cVar;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.c bbI() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) this.eTG.invoke();
    }

    private final Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> byg() {
        return u.b((Collection) u.b((Collection) byh(), (Iterable) m.cs(bbI())), (Iterable) this.eTh.biq().baF().p(this));
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.c> byh() {
        List bkt = this.eSB.bkt();
        h.d(bkt, "classProto.constructorList");
        Collection arrayList = new ArrayList();
        for (Object next : bkt) {
            Constructor constructor = (Constructor) next;
            kotlin.reflect.jvm.internal.impl.metadata.a.b.a aVar = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLq;
            h.d(constructor, "it");
            Boolean lc = aVar.get(constructor.getFlags());
            h.d(lc, "Flags.IS_SECONDARY.get(it.flags)");
            if (lc.booleanValue()) {
                arrayList.add(next);
            }
        }
        Iterable<Constructor> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(n.e(iterable, 10));
        for (Constructor constructor2 : iterable) {
            p bxJ = this.eTh.bxJ();
            h.d(constructor2, "it");
            arrayList2.add(bxJ.a(constructor2, false));
        }
        return (List) arrayList2;
    }

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> bbE() {
        return (Collection) this.eHC.invoke();
    }

    private final d byi() {
        if (!this.eSB.bkl()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f c = this.eTE.c(q.b(this.eTh.aYI(), this.eSB.bkm()), (kotlin.reflect.jvm.internal.impl.incremental.components.b) NoLookupLocation.FROM_DESERIALIZATION);
        if (!(c instanceof d)) {
            c = null;
        }
        return (d) c;
    }

    public d bbC() {
        return (d) this.eTH.invoke();
    }

    public final boolean O(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        h.e(fVar, "name");
        return this.eTE.byv().contains(fVar);
    }

    private final Collection<d> byj() {
        if (this.eCr != Modality.SEALED) {
            return m.emptyList();
        }
        List<Integer> bkD = this.eSB.bkD();
        h.d(bkD, "fqNames");
        if ((bkD.isEmpty() ^ 1) == 0) {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.M(this);
        }
        Collection arrayList = new ArrayList();
        for (Integer num : bkD) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.h biq = this.eTh.biq();
            kotlin.reflect.jvm.internal.impl.metadata.a.c aYI = this.eTh.aYI();
            h.d(num, com.google.firebase.analytics.FirebaseAnalytics.b.INDEX);
            d l = biq.l(q.a(aYI, num.intValue()));
            if (l != null) {
                arrayList.add(l);
            }
        }
        return (List) arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("deserialized class ");
        stringBuilder.append(bdc());
        return stringBuilder.toString();
    }

    public ai bbR() {
        return this.eSD;
    }

    public List<an> bbS() {
        return this.eTh.bxI().bxQ();
    }
}
