package com.iqoption.deposit.light.methods;

import com.iqoption.deposit.time.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "", "Lcom/iqoption/deposit/time/MethodTime;", "invoke"})
/* compiled from: MethodsLightViewModel.kt */
final class MethodsLightViewModel$methodsTimeMap$2 extends Lambda implements a<Map<Integer, ? extends com.iqoption.deposit.time.a>> {
    public static final MethodsLightViewModel$methodsTimeMap$2 cbd = new MethodsLightViewModel$methodsTimeMap$2();

    MethodsLightViewModel$methodsTimeMap$2() {
        super(0);
    }

    /* renamed from: adu */
    public final Map<Integer, com.iqoption.deposit.time.a> invoke() {
        Iterable<com.iqoption.deposit.time.a> aeg = b.aeg();
        Collection arrayList = new ArrayList(n.e(aeg, 10));
        for (com.iqoption.deposit.time.a aVar : aeg) {
            arrayList.add(j.D(aVar.Je(), aVar));
        }
        return ad.ae((List) arrayList);
    }
}
