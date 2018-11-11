package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.kotlin.u;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithSpecialGenericSignature {
    private static final List<o> eEL;
    private static final List<String> eEM;
    private static final List<String> eEN;
    private static final Map<o, TypeSafeBarrierDescription> eEO;
    private static final Map<String, TypeSafeBarrierDescription> eEP;
    private static final Set<f> eEQ;
    private static final Set<String> eER;
    public static final BuiltinMethodsWithSpecialGenericSignature eES = new BuiltinMethodsWithSpecialGenericSignature();

    /* compiled from: specialBuiltinMembers.kt */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        protected SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    public enum TypeSafeBarrierDescription {
        NULL(null),
        INDEX(Integer.valueOf(-1)),
        FALSE(Boolean.valueOf(false));
        
        private final Object defaultValue;

        /* compiled from: specialBuiltinMembers.kt */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null);
            }
        }

        protected TypeSafeBarrierDescription(Object obj) {
            this.defaultValue = obj;
        }
    }

    static {
        String desc;
        Iterable<String> I = aj.I("containsAll", "removeAll", "retainAll");
        Collection arrayList = new ArrayList(n.e(I, 10));
        for (String e : I) {
            desc = JvmPrimitiveType.BOOLEAN.getDesc();
            h.d(desc, "JvmPrimitiveType.BOOLEAN.desc");
            arrayList.add(q.d("java/util/Collection", e, "Ljava/util/Collection;", desc));
        }
        eEL = (List) arrayList;
        Iterable<o> iterable = eEL;
        arrayList = new ArrayList(n.e(iterable, 10));
        for (o signature : iterable) {
            arrayList.add(signature.getSignature());
        }
        eEM = (List) arrayList;
        iterable = eEL;
        arrayList = new ArrayList(n.e(iterable, 10));
        for (o signature2 : iterable) {
            arrayList.add(signature2.bdc().asString());
        }
        eEN = (List) arrayList;
        u uVar = u.eJX;
        Pair[] pairArr = new Pair[10];
        String desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        h.d(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[0] = j.D(q.d(uVar.mv("Collection"), "contains", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE);
        desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        h.d(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[1] = j.D(q.d(uVar.mv("Collection"), ProductAction.ACTION_REMOVE, "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE);
        desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        h.d(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[2] = j.D(q.d(uVar.mv("Map"), "containsKey", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE);
        desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        h.d(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[3] = j.D(q.d(uVar.mv("Map"), "containsValue", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE);
        desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        h.d(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[4] = j.D(q.d(uVar.mv("Map"), ProductAction.ACTION_REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE);
        pairArr[5] = j.D(q.d(uVar.mv("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        pairArr[6] = j.D(q.d(uVar.mv("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        pairArr[7] = j.D(q.d(uVar.mv("Map"), ProductAction.ACTION_REMOVE, "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL);
        desc2 = JvmPrimitiveType.INT.getDesc();
        h.d(desc2, "JvmPrimitiveType.INT.desc");
        pairArr[8] = j.D(q.d(uVar.mv("List"), "indexOf", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.INDEX);
        desc = JvmPrimitiveType.INT.getDesc();
        h.d(desc, "JvmPrimitiveType.INT.desc");
        pairArr[9] = j.D(q.d(uVar.mv("List"), "lastIndexOf", "Ljava/lang/Object;", desc), TypeSafeBarrierDescription.INDEX);
        eEO = ad.a(pairArr);
        Map map = eEO;
        Map linkedHashMap = new LinkedHashMap(ad.jn(map.size()));
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(((o) entry.getKey()).getSignature(), entry.getValue());
        }
        eEP = linkedHashMap;
        iterable = ak.a(eEO.keySet(), eEL);
        arrayList = new ArrayList(n.e(iterable, 10));
        for (o bdc : iterable) {
            arrayList.add(bdc.bdc());
        }
        eEQ = u.Y((List) arrayList);
        arrayList = new ArrayList(n.e(iterable, 10));
        for (o signature3 : iterable) {
            arrayList.add(signature3.getSignature());
        }
        eER = u.Y((List) arrayList);
    }

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    private final boolean k(CallableMemberDescriptor callableMemberDescriptor) {
        return u.b((Iterable) eER, (Object) r.c(callableMemberDescriptor));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.r h(kotlin.reflect.jvm.internal.impl.descriptors.r rVar) {
        h.e(rVar, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = eES;
        f bdc = rVar.bdc();
        h.d(bdc, "functionDescriptor.name");
        if (builtinMethodsWithSpecialGenericSignature.m(bdc)) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.r) a.a(rVar, false, BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1.eET, 1, null);
        }
        return null;
    }

    public final boolean m(f fVar) {
        h.e(fVar, "$receiver");
        return eEQ.contains(fVar);
    }

    public static final SpecialSignatureInfo l(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        if (!eEQ.contains(callableMemberDescriptor.bdc())) {
            return null;
        }
        callableMemberDescriptor = a.a(callableMemberDescriptor, false, BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1.eEU, 1, null);
        if (callableMemberDescriptor != null) {
            String c = r.c(callableMemberDescriptor);
            if (c != null) {
                if (eEM.contains(c)) {
                    return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
                }
                SpecialSignatureInfo specialSignatureInfo;
                Object obj = eEP.get(c);
                if (obj == null) {
                    h.aXZ();
                }
                if (((TypeSafeBarrierDescription) obj) == TypeSafeBarrierDescription.NULL) {
                    specialSignatureInfo = SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
                } else {
                    specialSignatureInfo = SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
                }
                return specialSignatureInfo;
            }
        }
        return null;
    }
}
