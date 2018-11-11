package com.iqoption.app.managers.a;

import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.common.base.Predicates;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.k.c;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.result.ExpirationsResult;
import com.iqoption.dto.entity.result.StrikesResult;
import com.iqoption.dto.entity.strike.GroupStrikeKey;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.gl.b;
import com.iqoption.util.ag;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

/* compiled from: ExpirationDigitalHelper */
public class e implements s {
    private static final String TAG = "e";
    private static final d<Iterable<Expiration>, Expiration> anV = i.$instance;
    private static final long anW = TimeUnit.SECONDS.toMillis(10);
    private final ConcurrentHashMap<GroupStrikeKey, s<ConcurrentHashMap<String, Strike>>> anX = new ConcurrentHashMap();
    protected final ConcurrentHashMap<GroupStrikeKey, ConcurrentHashMap<String, Strike>> anY = new ConcurrentHashMap();
    private final ConcurrentHashMap<a, s<ImmutableList<Expiration>>> anZ = new ConcurrentHashMap();
    private final ConcurrentHashMap<a, ConcurrentSkipListSet<Expiration>> aoa = new ConcurrentHashMap();

    /* compiled from: ExpirationDigitalHelper */
    public static class a {
        public InstrumentType instrumentType;
        public String underlying;

        public a(InstrumentType instrumentType, String str) {
            this.instrumentType = instrumentType;
            this.underlying = str;
        }

        /* JADX WARNING: Missing block: B:6:0x001a, code:
            if (com.google.common.base.f.equal(r2.underlying, r3.underlying) != false) goto L_0x001f;
     */
        public boolean equals(java.lang.Object r3) {
            /*
            r2 = this;
            if (r3 == r2) goto L_0x001f;
        L_0x0002:
            r0 = r3 instanceof com.iqoption.app.managers.a.e.a;
            if (r0 == 0) goto L_0x001d;
        L_0x0006:
            r0 = r2.instrumentType;
            r3 = (com.iqoption.app.managers.a.e.a) r3;
            r1 = r3.instrumentType;
            r0 = com.google.common.base.f.equal(r0, r1);
            if (r0 == 0) goto L_0x001d;
        L_0x0012:
            r0 = r2.underlying;
            r3 = r3.underlying;
            r3 = com.google.common.base.f.equal(r0, r3);
            if (r3 == 0) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r3 = 0;
            goto L_0x0020;
        L_0x001f:
            r3 = 1;
        L_0x0020:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.a.e.a.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return f.hashCode(this.instrumentType, this.underlying);
        }
    }

    public long i(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return 10000;
    }

    private ConcurrentSkipListSet<Expiration> a(a aVar) {
        if (!this.aoa.containsKey(aVar)) {
            this.aoa.put(aVar, new ConcurrentSkipListSet(Expiration.ORDERING));
        }
        return (ConcurrentSkipListSet) this.aoa.get(aVar);
    }

    private ConcurrentSkipListSet<Expiration> m(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return a(new a(aVar.getInstrumentType(), aVar.Xf()));
    }

    public ImmutableList<Expiration> n(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return e(a(new a(aVar.getInstrumentType(), aVar.Xf())), new c(Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType(), af.Hu().Hw()));
    }

    public s<ImmutableList<Expiration>> h(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        final a aVar2 = new a(aVar.getInstrumentType(), aVar.Xf());
        Object a = a(aVar2);
        Object cVar = new c(Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType(), af.Hu().Hw());
        ImmutableList e = e(a, cVar);
        if (((s) this.anZ.get(aVar2)) != null) {
            return o.aR(e);
        }
        s a2 = ag.a(o(aVar), new f(this, a, cVar));
        this.anZ.put(aVar2, a2);
        ag.a(a2, new n<ImmutableList<Expiration>>() {
            /* renamed from: i */
            public void onSuccess(ImmutableList<Expiration> immutableList) {
                e.this.anZ.remove(aVar2);
            }

            public void l(Throwable th) {
                e.this.anZ.remove(aVar2);
            }
        });
        return a2;
    }

    protected s<ExpirationsResult> o(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return com.iqoption.mobbtech.connect.request.api.f.a(aVar.getInstrumentType(), aVar.Xf(), aVar.getActiveId());
    }

    private ImmutableList<Expiration> e(Iterable<Expiration> iterable, j<Expiration> jVar) {
        return i.c((Iterable) iterable).c((j) jVar).a(Expiration.ORDERING);
    }

    public s<Expiration> k(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return ag.a(h(aVar), anV);
    }

    public boolean b(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        return i.c(m(aVar)).e(Predicates.G(expiration)).isPresent();
    }

    public void l(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        a(aVar, m(aVar));
    }

    public long c(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        if (expiration == null || expiration.expValue.equals(Long.valueOf(0))) {
            return 0;
        }
        Expiration expiration2 = (Expiration) i.c(m(aVar)).e(Predicates.G(expiration)).pq();
        return (expiration2 == null || expiration2.deadTime == null) ? 15000 : expiration2.deadTime.longValue();
    }

    private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Set<Expiration> set) {
        long Hw = af.Hu().Hw() - anW;
        Collection arrayList = new ArrayList();
        for (Expiration expiration : set) {
            if (expiration.expValue.longValue() < Hw) {
                a(aVar, expiration, false);
                a(aVar, expiration, true);
                arrayList.add(expiration);
            }
        }
        if (!arrayList.isEmpty() && set.removeAll(arrayList)) {
            IQApp.Dn().aE(new com.iqoption.app.managers.a.k.e());
        }
    }

    private void a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration, boolean z) {
        Expiration expiration2 = expiration;
        ConcurrentHashMap a = a(aVar.getInstrumentType(), aVar.Xf(), expiration2.expValue, Long.valueOf(expiration2.expInterval.longValue() / 1000), z);
        if (a != null) {
            for (Entry entry : a.entrySet()) {
                Strike strike = (Strike) entry.getValue();
                String str = (String) entry.getKey();
                com.iqoption.app.managers.c.Gn().b(strike.call.id, aVar.getInstrumentType());
                com.iqoption.app.managers.c.Gn().b(strike.put.id, aVar.getInstrumentType());
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("glchTabDeleteStrike key=");
                stringBuilder.append(str);
                com.iqoption.core.i.v(str2, stringBuilder.toString());
                b.aow().glchTabDeleteStrike(str);
            }
            b(aVar.getInstrumentType(), aVar.Xf(), expiration2.expValue, Long.valueOf(expiration2.expInterval.longValue() / 1000), z);
        }
    }

    public Expiration a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        Iterator it = m(aVar).iterator();
        while (it.hasNext()) {
            Expiration expiration2 = (Expiration) it.next();
            if (expiration2.expValue.longValue() > expiration.expValue.longValue() && f.equal(Long.valueOf(expiration2.getDigitalExpirationPeriod()), Long.valueOf(expiration.getDigitalExpirationPeriod()))) {
                return expiration2;
            }
        }
        return new Expiration(0, expiration.getDigitalExpirationPeriod());
    }

    @WorkerThread
    public void b(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Set<Expiration> set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPOTP updateExpiration=");
        stringBuilder.append(set.toString());
        com.iqoption.core.i.d(stringBuilder.toString());
        Collection e = e(set, new c(Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType(), af.Hu().Hw()));
        if (e != null && !e.isEmpty() && m(aVar).addAll(e)) {
            IQApp.Dn().aE(new k.f());
        }
    }

    public String a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j) {
        if (j == 0) {
            return IQApp.Dk().getString(R.string.n_a);
        }
        return bf.cgr.format(Long.valueOf(j));
    }

    @Nullable
    public Strike a(InstrumentType instrumentType, String str, Long l, String str2, Long l2, boolean z) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.anY.get(new GroupStrikeKey(instrumentType, str, l, l2, z));
        return concurrentHashMap != null ? (Strike) concurrentHashMap.get(str2) : null;
    }

    @Nullable
    public ConcurrentHashMap<String, Strike> a(InstrumentType instrumentType, String str, Long l, Long l2, boolean z) {
        return (ConcurrentHashMap) this.anY.get(new GroupStrikeKey(instrumentType, str, l, l2, z));
    }

    private void b(InstrumentType instrumentType, String str, Long l, Long l2, boolean z) {
        this.anY.remove(new GroupStrikeKey(instrumentType, str, l, l2, z));
    }

    public s<ConcurrentHashMap<String, Strike>> a(final Integer num, InstrumentType instrumentType, String str, Long l, Long l2, boolean z) {
        final GroupStrikeKey groupStrikeKey = new GroupStrikeKey(instrumentType, str, l, l2, z);
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.anY.get(groupStrikeKey);
        if (concurrentHashMap != null) {
            return o.aR(concurrentHashMap);
        }
        s<ConcurrentHashMap<String, Strike>> sVar = (s) this.anX.get(groupStrikeKey);
        if (sVar == null) {
            sVar = ag.a(z ? b(groupStrikeKey) : a(groupStrikeKey), new g(z));
            s b = o.b((s) sVar, h.$instance, MoreExecutors.vV());
            long j = 0;
            com.iqoption.core.a.a.a aVar;
            if (z) {
                aVar = com.iqoption.core.a.a.a.aMG;
                if (num != null) {
                    j = num.longValue();
                }
                aVar.b(b, j, instrumentType);
            } else {
                aVar = com.iqoption.core.a.a.a.aMG;
                if (num != null) {
                    j = num.longValue();
                }
                aVar.a(b, j, instrumentType);
            }
            this.anX.put(groupStrikeKey, sVar);
            ag.a((s) sVar, new n<ConcurrentHashMap<String, Strike>>() {
                /* renamed from: c */
                public void onSuccess(ConcurrentHashMap<String, Strike> concurrentHashMap) {
                    for (Entry entry : concurrentHashMap.entrySet()) {
                        Strike strike = (Strike) entry.getValue();
                        String str = (String) entry.getKey();
                        e.this.a(strike, str, num);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("strikeId strike = ");
                        stringBuilder.append(str);
                        com.iqoption.core.i.d(stringBuilder.toString());
                    }
                    e.this.anY.put(groupStrikeKey, concurrentHashMap);
                    e.this.anX.remove(groupStrikeKey);
                }

                public void l(Throwable th) {
                    e.this.anX.remove(groupStrikeKey);
                }
            });
        }
        return sVar;
    }

    protected void a(Strike strike, String str, Integer num) {
        Strike strike2 = strike;
        Quote c = com.iqoption.app.managers.c.Gn().c(strike2.call.id, InstrumentType.DIGITAL_INSTRUMENT);
        Quote c2 = com.iqoption.app.managers.c.Gn().c(strike2.put.id, InstrumentType.DIGITAL_INSTRUMENT);
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("glchTabAddStrike strike=");
        stringBuilder.append(strike2);
        stringBuilder.append(", strikeId=");
        String str3 = str;
        stringBuilder.append(str3);
        stringBuilder.append(", idActive=");
        stringBuilder.append(num);
        com.iqoption.core.i.v(str2, stringBuilder.toString());
        b.aow().glchTabAddStrike(num.intValue(), (double) (strike2.expiration / 1000), strike2.optionType.getOptionActiveOrInstrumentValue(), str3, (int) strike2.period, strike.getValue().doubleValue(), Quote.selfAskPrice(c), Quote.selfBidPrice(c), Quote.selfAskPrice(c2), Quote.selfBidPrice(c2), 1, 1, strike2.isSpot);
    }

    protected s<StrikesResult> a(GroupStrikeKey groupStrikeKey) {
        return com.iqoption.mobbtech.connect.request.api.f.c(groupStrikeKey);
    }

    protected s<? extends StrikesResult> b(GroupStrikeKey groupStrikeKey) {
        return com.iqoption.mobbtech.connect.request.api.f.d(groupStrikeKey);
    }

    public void clear() {
        this.anX.clear();
        this.anY.clear();
        this.anZ.clear();
        this.aoa.clear();
    }
}
