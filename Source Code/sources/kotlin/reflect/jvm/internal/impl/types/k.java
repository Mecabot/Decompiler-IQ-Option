package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ag;

/* compiled from: DescriptorSubstitutor */
public class k {
    public static TypeSubstitutor a(List<an> list, as asVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, List<an> list2) {
        TypeSubstitutor a = a(list, asVar, kVar, list2, null);
        if (a != null) {
            return a;
        }
        throw new AssertionError("Substitution failed");
    }

    public static TypeSubstitutor a(List<an> list, as asVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar, List<an> list2, boolean[] zArr) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        int i = 0;
        for (an anVar : list) {
            int i2 = i + 1;
            ag a = ag.a(kVar, anVar.bbQ(), anVar.bde(), anVar.bdd(), anVar.bdc(), i, ai.eAX);
            hashMap.put(anVar.bby(), new ar(a.bdb()));
            hashMap2.put(anVar, a);
            list2.add(a);
            i = i2;
        }
        TypeSubstitutor b = TypeSubstitutor.b(asVar, ao.O(hashMap));
        for (an anVar2 : list) {
            ag agVar = (ag) hashMap2.get(anVar2);
            for (w wVar : anVar2.aYq()) {
                w c = b.c(wVar, Variance.IN_VARIANCE);
                if (c == null) {
                    return null;
                }
                if (!(c == wVar || zArr == null)) {
                    zArr[0] = true;
                }
                agVar.U(c);
            }
            agVar.setInitialized();
        }
        return b;
    }
}
