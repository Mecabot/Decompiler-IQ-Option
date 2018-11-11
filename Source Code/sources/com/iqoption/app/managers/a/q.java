package com.iqoption.app.managers.a;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.core.microservices.tradingengine.response.active.k;
import com.iqoption.core.microservices.tradingengine.response.active.k.d.c;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.dto.entity.expiration.Expiration;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeSet;

/* compiled from: ExpirationTurboBinaryHelper */
public abstract class q implements s {
    public void l(a aVar) {
    }

    public s<Expiration> k(a aVar) {
        return o.aR(b((k) aVar));
    }

    private Expiration b(k kVar) {
        long longValue;
        long longValue2 = kVar.Xy().XB().longValue() * 1000;
        int activeId = kVar.getActiveId();
        InstrumentType instrumentType = kVar.getInstrumentType();
        long Hv = af.Hu().Hv();
        if (kVar.Xy().XD() == null) {
            longValue = kVar.Xy().XC().longValue() * 1000;
        } else {
            longValue = kVar.Xy().XD().longValue();
        }
        long a = k.a(activeId, instrumentType, Hv, longValue, longValue2, (long) (kVar.Xz() * 1000));
        kVar.Xy().q(Long.valueOf(a));
        return new Expiration(a, longValue2);
    }

    public Expiration a(a aVar, Expiration expiration) {
        k kVar = (k) aVar;
        long longValue = kVar.Xy().XB().longValue() * 1000;
        Expiration expiration2 = new Expiration(expiration.expValue.longValue() + longValue, longValue);
        if (b(kVar, expiration2)) {
            return new Expiration(expiration2.expValue.longValue(), longValue);
        }
        return b(kVar);
    }

    public boolean b(a aVar, Expiration expiration) {
        if (expiration == null || expiration.expValue.longValue() == -1 || expiration.expValue.longValue() == 0) {
            return false;
        }
        Iterator sI = c((k) aVar).iterator();
        while (sI.hasNext()) {
            if (((Expiration) sI.next()).expValue.equals(expiration.expValue)) {
                return true;
            }
        }
        return false;
    }

    protected ImmutableList<Expiration> c(k kVar) {
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
                f.add(new Expiration(j, longValue2));
            }
        }
        f.addAll(a(kVar, longValue2));
        return ImmutableList.m(f);
    }

    protected TreeSet<Expiration> a(k kVar, long j) {
        TreeSet<Expiration> f = Sets.f(k.ORDERING);
        if (kVar.Xy().XE() != null) {
            for (Entry entry : kVar.Xy().XE().entrySet()) {
                Long l = (Long) entry.getKey();
                c cVar = (c) entry.getValue();
                if (cVar.getEnabled()) {
                    f.add(Expiration.special2expiration(l.longValue(), j, LocalizationUtil.translate(cVar.getTitle())));
                }
            }
        }
        return f;
    }

    public String a(a aVar, long j) {
        k kVar = (k) aVar;
        Iterator it = a(kVar, kVar.Xy().XB().longValue() * 1000).iterator();
        while (it.hasNext()) {
            Expiration expiration = (Expiration) it.next();
            if (expiration.expValue.longValue() == j) {
                return expiration.title;
            }
        }
        return k.aw(j);
    }

    public long c(a aVar, Expiration expiration) {
        return (long) (((k) aVar).Xz() * 1000);
    }
}
