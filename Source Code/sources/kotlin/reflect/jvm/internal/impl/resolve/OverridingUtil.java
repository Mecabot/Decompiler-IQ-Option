package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.a.m;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.x;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.b.a;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.t;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;
import kotlin.reflect.jvm.internal.impl.utils.i;

public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final List<ExternalOverridabilityCondition> eQQ = u.W(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public static final OverridingUtil eQR = new OverridingUtil(new a() {
        public boolean a(an anVar, an anVar2) {
            return anVar.equals(anVar2);
        }
    });
    private final a eQS;

    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo eRc = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result eRd;
        private final String eRe;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public static OverrideCompatibilityInfo bwv() {
            return eRc;
        }

        public static OverrideCompatibilityInfo mO(String str) {
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        public static OverrideCompatibilityInfo mP(String str) {
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        public OverrideCompatibilityInfo(Result result, String str) {
            this.eRd = result;
            this.eRe = str;
        }

        public Result bww() {
            return this.eRd;
        }
    }

    public static OverridingUtil a(a aVar) {
        return new OverridingUtil(aVar);
    }

    private OverridingUtil(a aVar) {
        this.eQS = aVar;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> m(Set<D> set) {
        return a((Set) set, new m<D, D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>>() {
            /* renamed from: h */
            public Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> B(D d, D d2) {
                return new Pair(d, d2);
            }
        });
    }

    public static <D> Set<D> a(Set<D> set, m<? super D, ? super D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> mVar) {
        if (set.size() <= 1) {
            return set;
        }
        Set<D> linkedHashSet = new LinkedHashSet();
        for (Object next : set) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) mVar.B(next, it.next());
                kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) pair.aXG();
                kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) pair.aXH();
                if (c(aVar, aVar2)) {
                    it.remove();
                } else if (c(aVar2, aVar)) {
                    break;
                }
            }
            linkedHashSet.add(next);
        }
        return linkedHashSet;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean c(D d, D d2) {
        if (!d.equals(d2) && a.eQv.d(d.bcR(), d2.bcR())) {
            return true;
        }
        k bcR = d2.bcR();
        for (kotlin.reflect.jvm.internal.impl.descriptors.a d3 : c.e(d)) {
            if (a.eQv.d(bcR, d3)) {
                return true;
            }
        }
        return false;
    }

    public static Set<CallableMemberDescriptor> C(CallableMemberDescriptor callableMemberDescriptor) {
        Set linkedHashSet = new LinkedHashSet();
        a(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static void a(CallableMemberDescriptor callableMemberDescriptor, Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor.bcW().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (callableMemberDescriptor.bcU().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No overridden descriptors found for (fake override) ");
            stringBuilder.append(callableMemberDescriptor);
            throw new IllegalStateException(stringBuilder.toString());
        } else {
            for (CallableMemberDescriptor a : callableMemberDescriptor.bcU()) {
                a(a, (Set) set);
            }
        }
    }

    public OverrideCompatibilityInfo c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, d dVar) {
        return a(aVar, aVar2, dVar, false);
    }

    public OverrideCompatibilityInfo a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, d dVar, boolean z) {
        OverrideCompatibilityInfo b = b(aVar, aVar2, z);
        Object obj = b.bww() == Result.OVERRIDABLE ? 1 : null;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : eQQ) {
            if (externalOverridabilityCondition.bfC() != Contract.CONFLICTS_ONLY) {
                if (obj == null || externalOverridabilityCondition.bfC() != Contract.SUCCESS_ONLY) {
                    switch (externalOverridabilityCondition.a(aVar, aVar2, dVar)) {
                        case OVERRIDABLE:
                            obj = 1;
                            break;
                        case CONFLICT:
                            return OverrideCompatibilityInfo.mP("External condition failed");
                        case INCOMPATIBLE:
                            return OverrideCompatibilityInfo.mO("External condition");
                        default:
                            break;
                    }
                }
            }
        }
        if (obj == null) {
            return b;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : eQQ) {
            if (externalOverridabilityCondition2.bfC() == Contract.CONFLICTS_ONLY) {
                switch (externalOverridabilityCondition2.a(aVar, aVar2, dVar)) {
                    case OVERRIDABLE:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Contract violation in ");
                        stringBuilder.append(externalOverridabilityCondition2.getClass().getName());
                        stringBuilder.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(stringBuilder.toString());
                    case CONFLICT:
                        return OverrideCompatibilityInfo.mP("External condition failed");
                    case INCOMPATIBLE:
                        return OverrideCompatibilityInfo.mO("External condition");
                    default:
                        break;
                }
            }
        }
        return OverrideCompatibilityInfo.bwv();
    }

    public OverrideCompatibilityInfo b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z) {
        OverrideCompatibilityInfo d = d(aVar, aVar2);
        if (d != null) {
            return d;
        }
        List f = f(aVar);
        List f2 = f(aVar2);
        List typeParameters = aVar.getTypeParameters();
        List typeParameters2 = aVar2.getTypeParameters();
        int i = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i < f.size()) {
                if (!b.eVr.d((w) f.get(i), (w) f2.get(i))) {
                    return OverrideCompatibilityInfo.mO("Type parameter number mismatch");
                }
                i++;
            }
            return OverrideCompatibilityInfo.mP("Type parameter number mismatch");
        }
        b j = j(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            if (!a((kotlin.reflect.jvm.internal.impl.descriptors.an) typeParameters.get(i2), (kotlin.reflect.jvm.internal.impl.descriptors.an) typeParameters2.get(i2), j)) {
                return OverrideCompatibilityInfo.mO("Type parameter bounds mismatch");
            }
        }
        for (int i3 = 0; i3 < f.size(); i3++) {
            if (!a((w) f.get(i3), (w) f2.get(i3), j)) {
                return OverrideCompatibilityInfo.mO("Value parameter type mismatch");
            }
        }
        if ((aVar instanceof r) && (aVar2 instanceof r) && ((r) aVar).bdq() != ((r) aVar2).bdq()) {
            return OverrideCompatibilityInfo.mP("Incompatible suspendability");
        }
        if (z) {
            w bcQ = aVar.bcQ();
            w bcQ2 = aVar2.bcQ();
            if (!(bcQ == null || bcQ2 == null)) {
                if (y.aF(bcQ2) && y.aF(bcQ)) {
                    i = 1;
                }
                if (i == 0 && !j.c(bcQ2, bcQ)) {
                    return OverrideCompatibilityInfo.mP("Return type mismatch");
                }
            }
        }
        return OverrideCompatibilityInfo.bwv();
    }

    public static OverrideCompatibilityInfo d(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z = aVar instanceof r;
        if (!z || (aVar2 instanceof r)) {
            boolean z2 = aVar instanceof ad;
            if (!z2 || (aVar2 instanceof ad)) {
                if (!z && !z2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("This type of CallableDescriptor cannot be checked for overridability: ");
                    stringBuilder.append(aVar);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (!aVar.bdc().equals(aVar2.bdc())) {
                    return OverrideCompatibilityInfo.mO("Name mismatch");
                } else {
                    OverrideCompatibilityInfo e = e(aVar, aVar2);
                    return e != null ? e : null;
                }
            }
        }
        return OverrideCompatibilityInfo.mO("Member kind mismatch");
    }

    private b j(List<kotlin.reflect.jvm.internal.impl.descriptors.an> list, List<kotlin.reflect.jvm.internal.impl.descriptors.an> list2) {
        if (list.isEmpty()) {
            return c.b(this.eQS);
        }
        final Map hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(((kotlin.reflect.jvm.internal.impl.descriptors.an) list.get(i)).bby(), ((kotlin.reflect.jvm.internal.impl.descriptors.an) list2.get(i)).bby());
        }
        return c.b(new a() {
            public boolean a(an anVar, an anVar2) {
                boolean z = true;
                if (OverridingUtil.this.eQS.a(anVar, anVar2)) {
                    return true;
                }
                an anVar3 = (an) hashMap.get(anVar);
                an anVar4 = (an) hashMap.get(anVar2);
                if ((anVar3 == null || !anVar3.equals(anVar2)) && (anVar4 == null || !anVar4.equals(anVar))) {
                    z = false;
                }
                return z;
            }
        });
    }

    private static OverrideCompatibilityInfo e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        Object obj = null;
        Object obj2 = aVar.bcO() == null ? 1 : null;
        if (aVar2.bcO() == null) {
            obj = 1;
        }
        if (obj2 != obj) {
            return OverrideCompatibilityInfo.mO("Receiver presence mismatch");
        }
        return aVar.bcS().size() != aVar2.bcS().size() ? OverrideCompatibilityInfo.mO("Value parameter number mismatch") : null;
    }

    private static boolean a(w wVar, w wVar2, b bVar) {
        Object obj = (y.aF(wVar) && y.aF(wVar2)) ? 1 : null;
        if (obj != null || bVar.d(wVar, wVar2)) {
            return true;
        }
        return false;
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.descriptors.an anVar, kotlin.reflect.jvm.internal.impl.descriptors.an anVar2, b bVar) {
        List<w> aYq = anVar.aYq();
        List arrayList = new ArrayList(anVar2.aYq());
        if (aYq.size() != arrayList.size()) {
            return false;
        }
        for (w wVar : aYq) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (a(wVar, (w) listIterator.next(), bVar)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    private static List<w> f(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        ag bcO = aVar.bcO();
        List<w> arrayList = new ArrayList();
        if (bcO != null) {
            arrayList.add(bcO.bai());
        }
        for (aq bai : aVar.bcS()) {
            arrayList.add(bai.bai());
        }
        return arrayList;
    }

    public static void a(f fVar, Collection<? extends CallableMemberDescriptor> collection, Collection<? extends CallableMemberDescriptor> collection2, d dVar, h hVar) {
        Collection linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor a : collection2) {
            linkedHashSet.removeAll(a(a, (Collection) collection, dVar, hVar));
        }
        a(dVar, linkedHashSet, hVar);
    }

    public static boolean a(s sVar, s sVar2) {
        return !au.b(sVar2.bbJ()) && au.a((o) sVar2, (k) sVar);
    }

    private static Collection<CallableMemberDescriptor> a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection, d dVar, h hVar) {
        Collection<CallableMemberDescriptor> arrayList = new ArrayList(collection.size());
        Collection bzH = i.bzH();
        for (s sVar : collection) {
            Result bww = eQR.c(sVar, callableMemberDescriptor, dVar).bww();
            boolean a = a((s) callableMemberDescriptor, sVar);
            switch (bww) {
                case OVERRIDABLE:
                    if (a) {
                        bzH.add(sVar);
                    }
                    arrayList.add(sVar);
                    break;
                case CONFLICT:
                    if (a) {
                        hVar.b(sVar, callableMemberDescriptor);
                    }
                    arrayList.add(sVar);
                    break;
                default:
                    break;
            }
        }
        hVar.a(callableMemberDescriptor, bzH);
        return arrayList;
    }

    private static boolean S(Collection<CallableMemberDescriptor> collection) {
        if (collection.size() < 2) {
            return true;
        }
        final k bbv = ((CallableMemberDescriptor) collection.iterator().next()).bbv();
        return u.d((Iterable) collection, new kotlin.jvm.a.b<CallableMemberDescriptor, Boolean>() {
            /* renamed from: E */
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(callableMemberDescriptor.bbv() == bbv);
            }
        });
    }

    private static void a(d dVar, Collection<CallableMemberDescriptor> collection, h hVar) {
        if (S(collection)) {
            for (CallableMemberDescriptor singleton : collection) {
                a(Collections.singleton(singleton), dVar, hVar);
            }
            return;
        }
        Queue linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            a(a(j.V(linkedList), linkedList, hVar), dVar, hVar);
        }
    }

    public static boolean f(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        w bcQ = aVar.bcQ();
        w bcQ2 = aVar2.bcQ();
        boolean z = false;
        if (!a((o) aVar, (o) aVar2)) {
            return false;
        }
        if (aVar instanceof r) {
            return a(aVar, bcQ, aVar2, bcQ2);
        }
        if (aVar instanceof ad) {
            ad adVar = (ad) aVar;
            ad adVar2 = (ad) aVar2;
            if (!a(adVar.bdJ(), adVar2.bdJ())) {
                return false;
            }
            if (adVar.bdW() && adVar2.bdW()) {
                return eQR.j(aVar.getTypeParameters(), aVar2.getTypeParameters()).d(bcQ, bcQ2);
            }
            if ((adVar.bdW() || !adVar2.bdW()) && a(aVar, bcQ, aVar2, bcQ2)) {
                z = true;
            }
            return z;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected callable: ");
        stringBuilder.append(aVar.getClass());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static boolean a(o oVar, o oVar2) {
        Integer c = au.c(oVar.bbJ(), oVar2.bbJ());
        return c == null || c.intValue() >= 0;
    }

    private static boolean a(ac acVar, ac acVar2) {
        return (acVar == null || acVar2 == null) ? true : a((o) acVar, (o) acVar2);
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.a f : collection) {
            if (!f(aVar, f)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, w wVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, w wVar2) {
        return eQR.j(aVar.getTypeParameters(), aVar2.getTypeParameters()).c(wVar, wVar2);
    }

    public static <H> H a(Collection<H> collection, kotlin.jvm.a.b<H, kotlin.reflect.jvm.internal.impl.descriptors.a> bVar) {
        if (collection.size() == 1) {
            return u.M(collection);
        }
        Iterable arrayList = new ArrayList(2);
        Collection c = u.c((Iterable) collection, (kotlin.jvm.a.b) bVar);
        H M = u.M(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) bVar.invoke(M);
        for (H next : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) bVar.invoke(next);
            if (a(aVar2, c)) {
                arrayList.add(next);
            }
            if (f(aVar2, aVar) && !f(aVar, aVar2)) {
                M = next;
            }
        }
        if (arrayList.isEmpty()) {
            return M;
        }
        if (arrayList.size() == 1) {
            return u.M(arrayList);
        }
        H h = null;
        for (H next2 : arrayList) {
            if (!t.aB(((kotlin.reflect.jvm.internal.impl.descriptors.a) bVar.invoke(next2)).bcQ())) {
                h = next2;
                break;
            }
        }
        if (h != null) {
            return h;
        }
        return u.M(arrayList);
    }

    private static void a(Collection<CallableMemberDescriptor> collection, d dVar, h hVar) {
        Collection collection2;
        Collection a = a(dVar, (Collection) collection2);
        boolean isEmpty = a.isEmpty();
        if (!isEmpty) {
            collection2 = a;
        }
        CallableMemberDescriptor a2 = ((CallableMemberDescriptor) a(collection2, new kotlin.jvm.a.b<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a>() {
            /* renamed from: F */
            public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).a(dVar, a(collection2, dVar), isEmpty ? au.eBj : au.eBi, Kind.FAKE_OVERRIDE, false);
        hVar.a(a2, collection2);
        hVar.h(a2);
    }

    private static Modality a(Collection<CallableMemberDescriptor> collection, d dVar) {
        boolean z = false;
        Object obj = null;
        Object obj2 = null;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            switch (callableMemberDescriptor.bbG()) {
                case FINAL:
                    return Modality.FINAL;
                case SEALED:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Member cannot have SEALED modality: ");
                    stringBuilder.append(callableMemberDescriptor);
                    throw new IllegalStateException(stringBuilder.toString());
                case OPEN:
                    obj = 1;
                    break;
                case ABSTRACT:
                    obj2 = 1;
                    break;
                default:
                    break;
            }
        }
        if (!(!dVar.bbO() || dVar.bbG() == Modality.ABSTRACT || dVar.bbG() == Modality.SEALED)) {
            z = true;
        }
        if (obj != null && obj2 == null) {
            return Modality.OPEN;
        }
        if (obj != null || obj2 == null) {
            Set hashSet = new HashSet();
            for (CallableMemberDescriptor C : collection) {
                hashSet.addAll(C(C));
            }
            return a(m(hashSet), z, dVar.bbG());
        }
        return z ? dVar.bbG() : Modality.ABSTRACT;
    }

    private static Modality a(Collection<CallableMemberDescriptor> collection, boolean z, Modality modality) {
        Enum enumR = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Enum bbG = (z && callableMemberDescriptor.bbG() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.bbG();
            if (bbG.compareTo(enumR) < 0) {
                enumR = bbG;
            }
        }
        return enumR;
    }

    private static Collection<CallableMemberDescriptor> a(final d dVar, Collection<CallableMemberDescriptor> collection) {
        return u.b((Iterable) collection, new kotlin.jvm.a.b<CallableMemberDescriptor, Boolean>() {
            /* renamed from: E */
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z = !au.b(callableMemberDescriptor.bbJ()) && au.a((o) callableMemberDescriptor, dVar);
                return Boolean.valueOf(z);
            }
        });
    }

    public static <H> Collection<H> a(H h, Collection<H> collection, kotlin.jvm.a.b<H, kotlin.reflect.jvm.internal.impl.descriptors.a> bVar, kotlin.jvm.a.b<H, l> bVar2) {
        Collection<H> arrayList = new ArrayList();
        arrayList.add(h);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) bVar.invoke(h);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) bVar.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                Result g = g(aVar, aVar2);
                if (g == Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (g == Result.CONFLICT) {
                    bVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static Result g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        Result bww = eQR.c(aVar2, aVar, null).bww();
        Result bww2 = eQR.c(aVar, aVar2, null).bww();
        if (bww == Result.OVERRIDABLE && bww2 == Result.OVERRIDABLE) {
            return Result.OVERRIDABLE;
        }
        return (bww == Result.CONFLICT || bww2 == Result.CONFLICT) ? Result.CONFLICT : Result.INCOMPATIBLE;
    }

    private static Collection<CallableMemberDescriptor> a(final CallableMemberDescriptor callableMemberDescriptor, Queue<CallableMemberDescriptor> queue, final h hVar) {
        return a((Object) callableMemberDescriptor, (Collection) queue, new kotlin.jvm.a.b<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a>() {
            /* renamed from: G */
            public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        }, new kotlin.jvm.a.b<CallableMemberDescriptor, l>() {
            /* renamed from: x */
            public l invoke(CallableMemberDescriptor callableMemberDescriptor) {
                hVar.c(callableMemberDescriptor, callableMemberDescriptor);
                return l.etX;
            }
        });
    }

    public static void a(CallableMemberDescriptor callableMemberDescriptor, kotlin.jvm.a.b<CallableMemberDescriptor, l> bVar) {
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.bcU()) {
            if (callableMemberDescriptor2.bbJ() == au.eBi) {
                a(callableMemberDescriptor2, (kotlin.jvm.a.b) bVar);
            }
        }
        if (callableMemberDescriptor.bbJ() == au.eBi) {
            av avVar;
            av D = D(callableMemberDescriptor);
            if (D == null) {
                if (bVar != null) {
                    bVar.invoke(callableMemberDescriptor);
                }
                avVar = au.eBg;
            } else {
                avVar = D;
            }
            if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.y) {
                ((kotlin.reflect.jvm.internal.impl.descriptors.impl.y) callableMemberDescriptor).d(avVar);
                for (CallableMemberDescriptor callableMemberDescriptor22 : ((ad) callableMemberDescriptor).bdK()) {
                    a(callableMemberDescriptor22, D == null ? null : bVar);
                }
            } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.o) {
                ((kotlin.reflect.jvm.internal.impl.descriptors.impl.o) callableMemberDescriptor).d(avVar);
            } else {
                x xVar = (x) callableMemberDescriptor;
                xVar.d(avVar);
                if (avVar != xVar.bdH().bbJ()) {
                    xVar.gK(false);
                }
            }
        }
    }

    private static av D(CallableMemberDescriptor callableMemberDescriptor) {
        Collection<CallableMemberDescriptor> bcU = callableMemberDescriptor.bcU();
        av T = T(bcU);
        if (T == null) {
            return null;
        }
        if (callableMemberDescriptor.bcW() != Kind.FAKE_OVERRIDE) {
            return T.bec();
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : bcU) {
            if (callableMemberDescriptor2.bbG() != Modality.ABSTRACT && !callableMemberDescriptor2.bbJ().equals(T)) {
                return null;
            }
        }
        return T;
    }

    public static av T(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection.isEmpty()) {
            return au.eBn;
        }
        av avVar;
        loop0:
        while (true) {
            avVar = null;
            for (CallableMemberDescriptor bbJ : collection) {
                av bbJ2 = bbJ.bbJ();
                if (avVar != null) {
                    Integer c = au.c(bbJ2, avVar);
                    if (c != null) {
                        if (c.intValue() <= 0) {
                        }
                    }
                }
                avVar = bbJ2;
            }
            break loop0;
        }
        if (avVar == null) {
            return null;
        }
        for (CallableMemberDescriptor bbJ3 : collection) {
            Integer c2 = au.c(avVar, bbJ3.bbJ());
            if (c2 != null) {
                if (c2.intValue() < 0) {
                }
            }
            return null;
        }
        return avVar;
    }
}
