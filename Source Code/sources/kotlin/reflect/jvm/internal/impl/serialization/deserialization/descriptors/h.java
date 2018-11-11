package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.l;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.storage.b;
import kotlin.reflect.jvm.internal.impl.storage.c;
import kotlin.reflect.jvm.internal.impl.storage.e;
import kotlin.reflect.jvm.internal.impl.storage.g;

/* compiled from: DeserializedMemberScope.kt */
public abstract class h extends i {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};
    private final b<f, Collection<ad>> eCA;
    private final b<f, Collection<ah>> eCz;
    private final e eHU;
    private final Map<f, byte[]> eTN;
    private final Map<f, byte[]> eTO;
    private final Map<f, byte[]> eTP;
    private final c<f, am> eTQ;
    private final e eTR;
    private final e eTS;
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.j eTh;

    private final Set<f> bgR() {
        return (Set) g.a(this.eHU, (Object) this, apP[0]);
    }

    private final Set<f> byt() {
        return (Set) g.a(this.eTR, (Object) this, apP[1]);
    }

    protected abstract a P(f fVar);

    protected void b(f fVar, Collection<ad> collection) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(collection, "descriptors");
    }

    protected abstract Set<f> byn();

    protected abstract Set<f> byo();

    public final Set<f> byv() {
        return (Set) g.a(this.eTS, (Object) this, apP[2]);
    }

    protected abstract void c(Collection<k> collection, kotlin.jvm.a.b<? super f, Boolean> bVar);

    protected void d(f fVar, Collection<ah> collection) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(collection, "functions");
    }

    protected final kotlin.reflect.jvm.internal.impl.serialization.deserialization.j bxX() {
        return this.eTh;
    }

    protected h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.j jVar, Collection<Function> collection, Collection<Property> collection2, Collection<TypeAlias> collection3, kotlin.jvm.a.a<? extends Collection<f>> aVar) {
        kotlin.jvm.internal.h.e(jVar, "c");
        kotlin.jvm.internal.h.e(collection, "functionList");
        kotlin.jvm.internal.h.e(collection2, "propertyList");
        kotlin.jvm.internal.h.e(collection3, "typeAliasList");
        kotlin.jvm.internal.h.e(aVar, "classNames");
        this.eTh = jVar;
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : collection) {
            f b = q.b(this.eTh.aYI(), ((Function) ((n) next)).blW());
            ArrayList arrayList = linkedHashMap.get(b);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(b, arrayList);
            }
            arrayList.add(next);
        }
        this.eTN = N(linkedHashMap);
        linkedHashMap = new LinkedHashMap();
        for (Object next2 : collection2) {
            f b2 = q.b(this.eTh.aYI(), ((Property) ((n) next2)).blW());
            ArrayList arrayList2 = linkedHashMap.get(b2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(b2, arrayList2);
            }
            arrayList2.add(next2);
        }
        this.eTO = N(linkedHashMap);
        if (this.eTh.biq().bxv().bxF()) {
            linkedHashMap = new LinkedHashMap();
            for (Object next22 : collection3) {
                f b3 = q.b(this.eTh.aYI(), ((TypeAlias) ((n) next22)).blW());
                ArrayList arrayList3 = linkedHashMap.get(b3);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    linkedHashMap.put(b3, arrayList3);
                }
                arrayList3.add(next22);
            }
            linkedHashMap = N(linkedHashMap);
        } else {
            linkedHashMap = ad.emptyMap();
        }
        this.eTP = linkedHashMap;
        this.eCz = this.eTh.baI().o(new DeserializedMemberScope$functions$1(this));
        this.eCA = this.eTh.baI().o(new DeserializedMemberScope$properties$1(this));
        this.eTQ = this.eTh.baI().p(new DeserializedMemberScope$typeAliasByName$1(this));
        this.eHU = this.eTh.baI().i(new DeserializedMemberScope$functionNamesLazy$2(this));
        this.eTR = this.eTh.baI().i(new DeserializedMemberScope$variableNamesLazy$2(this));
        this.eTS = this.eTh.baI().i(new DeserializedMemberScope$classNames$2(aVar));
    }

    private final Set<f> byu() {
        return this.eTP.keySet();
    }

    public Set<f> beC() {
        return bgR();
    }

    public Set<f> beD() {
        return byt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043 A:{LOOP_END, LOOP:0: B:7:0x003d->B:9:0x0043} */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ah> g(kotlin.reflect.jvm.internal.impl.name.f r6) {
        /*
        r5 = this;
        r0 = r5.eTN;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.eKF;
        r2 = "ProtoBuf.Function.PARSER";
        kotlin.jvm.internal.h.d(r1, r2);
        r0 = r0.get(r6);
        r0 = (byte[]) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0011:
        r2 = new java.io.ByteArrayInputStream;
        r2.<init>(r0);
        r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1;
        r0.<init>(r2, r5, r1);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.sequences.k.k(r0);
        r0 = kotlin.sequences.m.f(r0);
        if (r0 == 0) goto L_0x002a;
    L_0x0027:
        r0 = (java.util.Collection) r0;
        goto L_0x0030;
    L_0x002a:
        r0 = kotlin.collections.m.emptyList();
        r0 = (java.util.Collection) r0;
    L_0x0030:
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x003d:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x005c;
    L_0x0043:
        r2 = r0.next();
        r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r2;
        r3 = r5.eTh;
        r3 = r3.bxJ();
        r4 = "it";
        kotlin.jvm.internal.h.d(r2, r4);
        r2 = r3.h(r2);
        r1.add(r2);
        goto L_0x003d;
    L_0x005c:
        r1 = (java.util.ArrayList) r1;
        r0 = r1;
        r0 = (java.util.Collection) r0;
        r5.d(r6, r0);
        r6 = kotlin.reflect.jvm.internal.impl.utils.a.j(r1);
        r6 = (java.util.Collection) r6;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.g(kotlin.reflect.jvm.internal.impl.name.f):java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ah>");
    }

    public Collection<ah> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        if (beC().contains(fVar)) {
            return (Collection) this.eCz.invoke(fVar);
        }
        return m.emptyList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043 A:{LOOP_END, LOOP:0: B:7:0x003d->B:9:0x0043} */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ad> f(kotlin.reflect.jvm.internal.impl.name.f r6) {
        /*
        r5 = this;
        r0 = r5.eTO;
        r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.eKF;
        r2 = "ProtoBuf.Property.PARSER";
        kotlin.jvm.internal.h.d(r1, r2);
        r0 = r0.get(r6);
        r0 = (byte[]) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0011:
        r2 = new java.io.ByteArrayInputStream;
        r2.<init>(r0);
        r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3;
        r0.<init>(r2, r5, r1);
        r0 = (kotlin.jvm.a.a) r0;
        r0 = kotlin.sequences.k.k(r0);
        r0 = kotlin.sequences.m.f(r0);
        if (r0 == 0) goto L_0x002a;
    L_0x0027:
        r0 = (java.util.Collection) r0;
        goto L_0x0030;
    L_0x002a:
        r0 = kotlin.collections.m.emptyList();
        r0 = (java.util.Collection) r0;
    L_0x0030:
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x003d:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x005c;
    L_0x0043:
        r2 = r0.next();
        r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r2;
        r3 = r5.eTh;
        r3 = r3.bxJ();
        r4 = "it";
        kotlin.jvm.internal.h.d(r2, r4);
        r2 = r3.h(r2);
        r1.add(r2);
        goto L_0x003d;
    L_0x005c:
        r1 = (java.util.ArrayList) r1;
        r0 = r1;
        r0 = (java.util.Collection) r0;
        r5.b(r6, r0);
        r6 = kotlin.reflect.jvm.internal.impl.utils.a.j(r1);
        r6 = (java.util.Collection) r6;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h.f(kotlin.reflect.jvm.internal.impl.name.f):java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ad>");
    }

    private final am S(f fVar) {
        byte[] bArr = (byte[]) this.eTP.get(fVar);
        if (bArr == null) {
            return null;
        }
        TypeAlias d = TypeAlias.d((InputStream) new ByteArrayInputStream(bArr), this.eTh.biq().bxD());
        if (d != null) {
            return this.eTh.bxJ().g(d);
        }
        return null;
    }

    public Collection<ad> a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        if (beD().contains(fVar)) {
            return (Collection) this.eCA.invoke(fVar);
        }
        return m.emptyList();
    }

    protected final Collection<k> b(d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar2) {
        kotlin.jvm.internal.h.e(dVar, "kindFilter");
        kotlin.jvm.internal.h.e(bVar, "nameFilter");
        kotlin.jvm.internal.h.e(bVar2, FirebaseAnalytics.b.LOCATION);
        ArrayList arrayList = new ArrayList(0);
        if (dVar.lR(d.eSd.bwZ())) {
            c((Collection) arrayList, (kotlin.jvm.a.b) bVar);
        }
        Collection collection = arrayList;
        a(collection, dVar, bVar, bVar2);
        if (dVar.lR(d.eSd.bxf())) {
            for (f fVar : byv()) {
                if (((Boolean) bVar.invoke(fVar)).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.j(collection, T(fVar));
                }
            }
        }
        if (dVar.lR(d.eSd.bxa())) {
            for (f fVar2 : byu()) {
                if (((Boolean) bVar.invoke(fVar2)).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.j(collection, this.eTQ.invoke(fVar2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.j(arrayList);
    }

    private final void a(Collection<k> collection, d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar2) {
        if (dVar.lR(d.eSd.bxd())) {
            Collection<f> beD = beD();
            ArrayList arrayList = new ArrayList();
            for (f fVar : beD) {
                if (((Boolean) bVar.invoke(fVar)).booleanValue()) {
                    arrayList.addAll(a(fVar, bVar2));
                }
            }
            List list = arrayList;
            kotlin.reflect.jvm.internal.impl.resolve.e.a aVar = kotlin.reflect.jvm.internal.impl.resolve.e.a.eQN;
            kotlin.jvm.internal.h.d(aVar, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            q.a(list, aVar);
            collection.addAll(arrayList);
        }
        if (dVar.lR(d.eSd.bxc())) {
            Collection<f> beC = beC();
            ArrayList arrayList2 = new ArrayList();
            for (f fVar2 : beC) {
                if (((Boolean) bVar.invoke(fVar2)).booleanValue()) {
                    arrayList2.addAll(b(fVar2, bVar2));
                }
            }
            List list2 = arrayList2;
            kotlin.reflect.jvm.internal.impl.resolve.e.a aVar2 = kotlin.reflect.jvm.internal.impl.resolve.e.a.eQN;
            kotlin.jvm.internal.h.d(aVar2, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            q.a(list2, aVar2);
            collection.addAll(arrayList2);
        }
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        kotlin.jvm.internal.h.e(bVar, FirebaseAnalytics.b.LOCATION);
        if (U(fVar)) {
            return T(fVar);
        }
        return byu().contains(fVar) ? (kotlin.reflect.jvm.internal.impl.descriptors.f) this.eTQ.invoke(fVar) : null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d T(f fVar) {
        return this.eTh.biq().l(P(fVar));
    }

    protected boolean U(f fVar) {
        kotlin.jvm.internal.h.e(fVar, "name");
        return byv().contains(fVar);
    }

    private final Map<f, byte[]> N(Map<f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) {
        Map<f, byte[]> linkedHashMap = new LinkedHashMap(ad.jn(map.size()));
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<kotlin.reflect.jvm.internal.impl.protobuf.a> iterable = (Iterable) entry.getValue();
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (kotlin.reflect.jvm.internal.impl.protobuf.a d : iterable) {
                d.d(byteArrayOutputStream);
                arrayList.add(l.etX);
            }
            List list = (List) arrayList;
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }
}
