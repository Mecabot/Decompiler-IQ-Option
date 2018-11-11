package com.iqoption.app.managers.a;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.managers.af;
import com.iqoption.core.microservices.tradingengine.response.active.k;
import com.iqoption.dto.entity.expiration.Expiration;
import java.util.Collection;
import java.util.List;

/* compiled from: ExpirationBinaryHelper */
public class a extends q {
    public long i(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return 60000;
    }

    public s<ImmutableList<Expiration>> h(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        k kVar = (k) aVar;
        if (kVar.Xy().getCount().intValue() > 4) {
            return o.aR(a(kVar));
        }
        return o.aR(c(kVar));
    }

    private ImmutableList<Expiration> a(k kVar) {
        long longValue;
        Collection f = Sets.f(k.ORDERING);
        long longValue2 = kVar.Xy().XB().longValue() * 1000;
        long Hw = af.Hu().Hw();
        if (kVar.Xy().XD() == null) {
            longValue = kVar.Xy().XC().longValue() * 1000;
        } else {
            longValue = kVar.Xy().XD().longValue();
        }
        long a = k.a(Hw, longValue, longValue2, (long) (kVar.Xz() * 1000));
        for (int i = 0; i < kVar.Xy().getCount().intValue(); i++) {
            long j = a + (((long) i) * longValue2);
            if (kVar.ba(j)) {
                Expiration expiration = new Expiration(j, longValue2);
                List findGroupExp = Expiration.findGroupExp(f, expiration);
                if (findGroupExp == null) {
                    Expiration createGroupExpiration = Expiration.createGroupExpiration(j, longValue2);
                    createGroupExpiration.expirationsInGroup.add(expiration);
                    f.add(createGroupExpiration);
                } else {
                    findGroupExp.add(expiration);
                }
            }
        }
        f.addAll(a(kVar, longValue2));
        return ImmutableList.m(f);
    }
}
