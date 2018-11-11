package com.iqoption.core.data.c;

import com.iqoption.core.h.g;
import com.iqoption.core.microservices.configuration.a.d;
import com.iqoption.core.util.c;
import io.reactivex.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/data/mediators/BalanceMediator;", "", "()V", "observeBalances", "Lio/reactivex/Flowable;", "", "Lcom/iqoption/core/data/mediators/BalanceData;", "core_release"})
/* compiled from: BalanceMediator.kt */
public final class b {
    public static final b aOv = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "Lcom/iqoption/core/data/mediators/BalanceData;", "balances", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "currencies", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "apply"})
    /* compiled from: BalanceMediator.kt */
    static final class a<T1, T2, R> implements io.reactivex.c.b<List<? extends com.iqoption.core.microservices.internalbilling.a.a>, List<? extends d>, List<? extends a>> {
        public static final a aOw = new a();

        a() {
        }

        /* renamed from: e */
        public final List<a> apply(List<com.iqoption.core.microservices.internalbilling.a.a> list, List<d> list2) {
            h.e(list, "balances");
            h.e(list2, "currencies");
            Collection arrayList = new ArrayList();
            for (com.iqoption.core.microservices.internalbilling.a.a aVar : list) {
                Object obj;
                Object obj2;
                Iterator it = list2.iterator();
                do {
                    obj2 = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                } while (!h.E(((d) obj).getName(), aVar.getCurrency()));
                d dVar = (d) obj;
                if (dVar != null) {
                    String a = c.a(aVar.VZ(), dVar.getMinorUnits(), dVar.getMask(), false, false, null, 28, null);
                    boolean z = true;
                    if (aVar.getType() != 1) {
                        z = false;
                    }
                    obj2 = new a(z, a, dVar.getName());
                }
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            return (List) arrayList;
        }
    }

    private b() {
    }

    public final e<List<a>> SB() {
        return g.a(com.iqoption.core.data.repository.a.aOG.SK(), com.iqoption.core.data.repository.c.aOM.SP(), a.aOw);
    }
}
