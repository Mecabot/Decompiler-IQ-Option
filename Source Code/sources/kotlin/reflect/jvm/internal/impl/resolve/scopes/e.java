package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.g;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: GivenFunctionsMemberScope.kt */
public abstract class e extends i {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final kotlin.reflect.jvm.internal.impl.storage.e eSe;
    private final d eSf;

    /* compiled from: GivenFunctionsMemberScope.kt */
    public static final class a extends g {
        final /* synthetic */ ArrayList $result;
        final /* synthetic */ e this$0;

        a(e eVar, ArrayList arrayList) {
            this.this$0 = eVar;
            this.$result = arrayList;
        }

        public void h(CallableMemberDescriptor callableMemberDescriptor) {
            h.e(callableMemberDescriptor, "fakeOverride");
            OverridingUtil.a(callableMemberDescriptor, null);
            this.$result.add(callableMemberDescriptor);
        }

        protected void a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
            h.e(callableMemberDescriptor, "fromSuper");
            h.e(callableMemberDescriptor2, "fromCurrent");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Conflict in scope of ");
            stringBuilder.append(this.this$0.bxh());
            stringBuilder.append(": ");
            stringBuilder.append(callableMemberDescriptor);
            stringBuilder.append(" vs ");
            stringBuilder.append(callableMemberDescriptor2);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
    }

    private final List<k> bxg() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eSe, (Object) this, apP[0]);
    }

    protected abstract List<r> bca();

    protected final d bxh() {
        return this.eSf;
    }

    public e(kotlin.reflect.jvm.internal.impl.storage.h hVar, d dVar) {
        h.e(hVar, "storageManager");
        h.e(dVar, "containingClass");
        this.eSf = dVar;
        this.eSe = hVar.i(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    public Collection<k> a(d dVar, b<? super f, Boolean> bVar) {
        h.e(dVar, "kindFilter");
        h.e(bVar, "nameFilter");
        if (dVar.lR(d.eRS.bwN())) {
            return bxg();
        }
        return m.emptyList();
    }

    public Collection<ah> b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : bxg()) {
            if (next instanceof ah) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (h.E(((ah) next2).bdc(), fVar)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }

    public Collection<ad> a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
        h.e(fVar, "name");
        h.e(bVar, FirebaseAnalytics.b.LOCATION);
        Collection arrayList = new ArrayList();
        for (Object next : bxg()) {
            if (next instanceof ad) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (h.E(((ad) next2).bdc(), fVar)) {
                arrayList2.add(next2);
            }
        }
        return (List) arrayList2;
    }

    private final List<k> cl(List<? extends r> list) {
        ArrayList arrayList = new ArrayList(3);
        an bby = this.eSf.bby();
        h.d(bby, "containingClass.typeConstructor");
        Collection<w> beu = bby.beu();
        h.d(beu, "containingClass.typeConstructor.supertypes");
        Collection arrayList2 = new ArrayList();
        for (w bbk : beu) {
            r.a(arrayList2, (Iterable) kotlin.reflect.jvm.internal.impl.resolve.scopes.j.a.a(bbk.bbk(), null, null, 3, null));
        }
        Collection arrayList3 = new ArrayList();
        for (Object next : (List) arrayList2) {
            if (next instanceof CallableMemberDescriptor) {
                arrayList3.add(next);
            }
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next2 : (List) arrayList3) {
            f bdc = ((CallableMemberDescriptor) next2).bdc();
            ArrayList arrayList4 = linkedHashMap.get(bdc);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(bdc, arrayList4);
            }
            arrayList4.add(next2);
        }
        for (Entry entry : linkedHashMap.entrySet()) {
            f fVar = (f) entry.getKey();
            Map linkedHashMap2 = new LinkedHashMap();
            for (Object next3 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) next3) instanceof r);
                ArrayList arrayList5 = linkedHashMap2.get(valueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(valueOf, arrayList5);
                }
                arrayList5.add(next3);
            }
            for (Entry entry2 : linkedHashMap2.entrySet()) {
                List list2;
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                Collection collection = (List) entry2.getValue();
                if (booleanValue) {
                    Collection arrayList6 = new ArrayList();
                    for (Object next4 : list) {
                        if (h.E(((r) next4).bdc(), fVar)) {
                            arrayList6.add(next4);
                        }
                    }
                    list2 = (List) arrayList6;
                } else {
                    list2 = m.emptyList();
                }
                OverridingUtil.a(fVar, collection, list2, this.eSf, new a(this, arrayList));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.j(arrayList);
    }
}
