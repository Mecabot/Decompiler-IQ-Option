package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.w;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.util.j;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class e extends ac {
    public static final a ezN = new a();

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final e a(FunctionClassDescriptor functionClassDescriptor, boolean z) {
            h.e(functionClassDescriptor, "functionClass");
            List bbS = functionClassDescriptor.bbS();
            e eVar = new e(functionClassDescriptor, null, Kind.DECLARATION, z, null);
            ag bdh = functionClassDescriptor.bdh();
            List emptyList = m.emptyList();
            Iterable iterable = bbS;
            ArrayList arrayList = new ArrayList();
            for (Object next : iterable) {
                if ((((an) next).bdd() == Variance.IN_VARIANCE ? 1 : null) == null) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<w> Z = u.Z(arrayList);
            Collection arrayList2 = new ArrayList(n.e(Z, 10));
            for (w wVar : Z) {
                arrayList2.add(e.ezN.a(eVar, wVar.getIndex(), (an) wVar.getValue()));
            }
            eVar.a(null, bdh, emptyList, (List) arrayList2, ((an) u.bW(bbS)).bdb(), Modality.ABSTRACT, au.eBg);
            eVar.gG(true);
            return eVar;
        }

        private final aq a(e eVar, int i, an anVar) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar;
            g bel;
            f mD;
            ad bdb;
            kotlin.reflect.jvm.internal.impl.types.w wVar;
            ai aiVar;
            String asString = anVar.bdc().asString();
            int hashCode = asString.hashCode();
            if (hashCode != 69) {
                if (hashCode == 84 && asString.equals("T")) {
                    asString = "instance";
                    aVar = eVar;
                    bel = g.eBF.bel();
                    mD = f.mD(asString);
                    h.d(mD, "Name.identifier(name)");
                    bdb = anVar.bdb();
                    h.d(bdb, "typeParameter.defaultType");
                    wVar = bdb;
                    aiVar = ai.eAX;
                    h.d(aiVar, "SourceElement.NO_SOURCE");
                    return new ah(aVar, null, i, bel, mD, wVar, false, false, false, null, aiVar);
                }
            } else if (asString.equals("E")) {
                asString = "receiver";
                aVar = eVar;
                bel = g.eBF.bel();
                mD = f.mD(asString);
                h.d(mD, "Name.identifier(name)");
                bdb = anVar.bdb();
                h.d(bdb, "typeParameter.defaultType");
                wVar = bdb;
                aiVar = ai.eAX;
                h.d(aiVar, "SourceElement.NO_SOURCE");
                return new ah(aVar, null, i, bel, mD, wVar, false, false, false, null, aiVar);
            }
            h.d(asString, "typeParameterName");
            if (asString == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            asString = asString.toLowerCase();
            h.d(asString, "(this as java.lang.String).toLowerCase()");
            aVar = eVar;
            bel = g.eBF.bel();
            mD = f.mD(asString);
            h.d(mD, "Name.identifier(name)");
            bdb = anVar.bdb();
            h.d(bdb, "typeParameter.defaultType");
            wVar = bdb;
            aiVar = ai.eAX;
            h.d(aiVar, "SourceElement.NO_SOURCE");
            return new ah(aVar, null, i, bel, mD, wVar, false, false, false, null, aiVar);
        }
    }

    public boolean bbN() {
        return false;
    }

    public boolean bcb() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public /* synthetic */ e(k kVar, e eVar, Kind kind, boolean z, f fVar) {
        this(kVar, eVar, kind, z);
    }

    private e(k kVar, e eVar, Kind kind, boolean z) {
        super(kVar, eVar, g.eBF.bel(), j.eWx, kind, ai.eAX);
        gv(true);
        gE(z);
        gF(false);
    }

    protected r a(kotlin.reflect.jvm.internal.impl.descriptors.impl.o.a aVar) {
        h.e(aVar, "configuration");
        e eVar = (e) super.a(aVar);
        if (eVar == null) {
            return null;
        }
        List bcS = eVar.bcS();
        h.d(bcS, "substituted.valueParameters");
        Iterable<aq> iterable = bcS;
        Object obj = 1;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (aq aqVar : iterable) {
                Object obj2;
                h.d(aqVar, "it");
                kotlin.reflect.jvm.internal.impl.types.w bai = aqVar.bai();
                h.d(bai, "it.type");
                if (kotlin.reflect.jvm.internal.impl.builtins.f.k(bai) != null) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    obj = null;
                    break;
                }
            }
        }
        if (obj != null) {
            return eVar;
        }
        bcS = eVar.bcS();
        h.d(bcS, "substituted.valueParameters");
        iterable = bcS;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (aq aqVar2 : iterable) {
            h.d(aqVar2, "it");
            kotlin.reflect.jvm.internal.impl.types.w bai2 = aqVar2.bai();
            h.d(bai2, "it.type");
            arrayList.add(kotlin.reflect.jvm.internal.impl.builtins.f.k(bai2));
        }
        return eVar.ca((List) arrayList);
    }

    protected o a(k kVar, r rVar, Kind kind, f fVar, g gVar, ai aiVar) {
        h.e(kVar, "newOwner");
        h.e(kind, "kind");
        h.e(gVar, "annotations");
        h.e(aiVar, b.SOURCE);
        return new e(kVar, (e) rVar, kind, bdq());
    }

    private final r ca(List<f> list) {
        int size = bcS().size() - list.size();
        boolean z = false;
        Object obj = (size == 0 || size == 1) ? 1 : null;
        if (m.etY && obj == null) {
            throw new AssertionError("Assertion failed");
        }
        List bcS = bcS();
        h.d(bcS, "valueParameters");
        Iterable<aq> iterable = bcS;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (aq aqVar : iterable) {
            h.d(aqVar, "it");
            f bdc = aqVar.bdc();
            int index = aqVar.getIndex();
            int i = index - size;
            if (i >= 0) {
                f fVar = (f) list.get(i);
                if (fVar != null) {
                    bdc = fVar;
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar = this;
            h.d(bdc, "newName");
            arrayList.add(aqVar.a(aVar, bdc, index));
        }
        List list2 = (List) arrayList;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.o.a h = h(TypeSubstitutor.eVk);
        Iterable<f> iterable2 = list;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            for (f fVar2 : iterable2) {
                if (fVar2 == null) {
                    obj = 1;
                    continue;
                } else {
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    z = true;
                    break;
                }
            }
        }
        r a = super.a(h.gI(z).cb(list2).i((CallableMemberDescriptor) beq()));
        if (a == null) {
            h.aXZ();
        }
        return a;
    }
}
