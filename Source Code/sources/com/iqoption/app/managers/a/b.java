package com.iqoption.app.managers.a;

import com.google.common.base.Predicates;
import com.google.common.base.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.i;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.a.k.c;
import com.iqoption.app.managers.af;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.core.microservices.tradingengine.response.active.h;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.util.ag;
import com.iqoption.util.bf;
import com.iqoption.x.R;

/* compiled from: ExpirationCfdHelper */
public class b implements s {
    private final d<Iterable<Expiration>, Expiration> anV = c.$instance;

    public long i(a aVar) {
        return 0;
    }

    public void l(a aVar) {
    }

    private ImmutableList<Expiration> j(a aVar) {
        return (ImmutableList) h(aVar).get();
    }

    public s<ImmutableList<Expiration>> h(a aVar) {
        h hVar = (h) aVar;
        if (!hVar.isExpired()) {
            return o.aR(ImmutableList.sL());
        }
        return o.aR(i.c(hVar.Xq()).c(Predicates.pS()).b(d.$instance).c(new c(Integer.valueOf(aVar.getActiveId()), aVar.getInstrumentType(), af.Hu().Hw())).a(Expiration.orderingValue));
    }

    public s<Expiration> k(a aVar) {
        h hVar = (h) aVar;
        if (hVar.isExpired()) {
            return ag.a(h(hVar), this.anV);
        }
        return o.aR(Expiration.ignoredExpiration);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A:{Splitter: B:2:0x0009, ExcHandler: java.util.concurrent.ExecutionException (r10_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:18:0x0053, code:
            r10 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:0x0054, code:
            com.iqoption.core.i.w("ExpirationCfdHelper", "getNextExpirationTime Exception ", r10);
     */
    public com.iqoption.dto.entity.expiration.Expiration a(com.iqoption.core.microservices.tradingengine.response.active.a r10, com.iqoption.dto.entity.expiration.Expiration r11) {
        /*
        r9 = this;
        r0 = r10;
        r0 = (com.iqoption.core.microservices.tradingengine.response.active.h) r0;
        r0 = r0.isExpired();
        if (r0 == 0) goto L_0x005b;
    L_0x0009:
        r10 = r9.j(r10);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r10 = r10.iterator();	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r0 = 0;
        if (r11 != 0) goto L_0x001a;
    L_0x0015:
        r2 = java.lang.Long.valueOf(r0);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        goto L_0x0026;
    L_0x001a:
        r2 = r11.expValue;	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r2 = com.google.common.base.e.h(r2, r3);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r2 = (java.lang.Long) r2;	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
    L_0x0026:
        r3 = r10.hasNext();	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        if (r3 == 0) goto L_0x0052;
    L_0x002c:
        r3 = r10.next();	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r3 = (com.iqoption.dto.entity.expiration.Expiration) r3;	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        r4 = java.lang.Long.valueOf(r0);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        goto L_0x0045;
    L_0x0039:
        r4 = r3.expValue;	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r5 = java.lang.Long.valueOf(r0);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r4 = com.google.common.base.e.h(r4, r5);	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r4 = (java.lang.Long) r4;	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
    L_0x0045:
        r4 = r4.longValue();	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r6 = r2.longValue();	 Catch:{ ExecutionException -> 0x0053, ExecutionException -> 0x0053 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x0026;
    L_0x0051:
        return r3;
    L_0x0052:
        return r11;
    L_0x0053:
        r10 = move-exception;
        r11 = "ExpirationCfdHelper";
        r0 = "getNextExpirationTime Exception ";
        com.iqoption.core.i.w(r11, r0, r10);
    L_0x005b:
        r10 = com.iqoption.dto.entity.expiration.Expiration.ignoredExpiration;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.a.b.a(com.iqoption.core.microservices.tradingengine.response.active.a, com.iqoption.dto.entity.expiration.Expiration):com.iqoption.dto.entity.expiration.Expiration");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001e A:{Splitter: B:2:0x0009, ExcHandler: java.util.concurrent.ExecutionException (r2_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:5:0x001e, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:6:0x001f, code:
            com.iqoption.core.i.w("ExpirationCfdHelper", "checkExpiration Exception ", r2);
     */
    public boolean b(com.iqoption.core.microservices.tradingengine.response.active.a r2, com.iqoption.dto.entity.expiration.Expiration r3) {
        /*
        r1 = this;
        r0 = r2;
        r0 = (com.iqoption.core.microservices.tradingengine.response.active.h) r0;
        r0 = r0.isExpired();
        if (r0 == 0) goto L_0x0026;
    L_0x0009:
        r2 = r1.j(r2);	 Catch:{ ExecutionException -> 0x001e, ExecutionException -> 0x001e }
        r2 = com.google.common.collect.i.c(r2);	 Catch:{ ExecutionException -> 0x001e, ExecutionException -> 0x001e }
        r3 = com.google.common.base.Predicates.G(r3);	 Catch:{ ExecutionException -> 0x001e, ExecutionException -> 0x001e }
        r2 = r2.e(r3);	 Catch:{ ExecutionException -> 0x001e, ExecutionException -> 0x001e }
        r2 = r2.isPresent();	 Catch:{ ExecutionException -> 0x001e, ExecutionException -> 0x001e }
        return r2;
    L_0x001e:
        r2 = move-exception;
        r3 = "ExpirationCfdHelper";
        r0 = "checkExpiration Exception ";
        com.iqoption.core.i.w(r3, r0, r2);
    L_0x0026:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.a.b.b(com.iqoption.core.microservices.tradingengine.response.active.a, com.iqoption.dto.entity.expiration.Expiration):boolean");
    }

    public String a(a aVar, long j) {
        if (!((h) aVar).isExpired()) {
            return null;
        }
        if (j == 0) {
            return IQApp.Dk().getString(R.string.n_a);
        }
        return bf.cgr.format(Long.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A:{Splitter: B:3:0x000d, ExcHandler: java.util.concurrent.ExecutionException (r5_8 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:15:0x0042, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x0043, code:
            com.iqoption.core.i.w("ExpirationCfdHelper", "checkExpiration Exception ", r5);
     */
    /* JADX WARNING: Missing block: B:18:0x004c, code:
            return 0;
     */
    public long c(com.iqoption.core.microservices.tradingengine.response.active.a r5, com.iqoption.dto.entity.expiration.Expiration r6) {
        /*
        r4 = this;
        r0 = r5;
        r0 = (com.iqoption.core.microservices.tradingengine.response.active.h) r0;
        r0 = r0.isExpired();
        r1 = 0;
        if (r0 == 0) goto L_0x004c;
    L_0x000b:
        if (r6 == 0) goto L_0x004b;
    L_0x000d:
        r0 = r6.expValue;	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        if (r0 == 0) goto L_0x004b;
    L_0x0011:
        r0 = r6.expValue;	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r3 = java.lang.Long.valueOf(r1);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r0 = r0.equals(r3);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x004b;
    L_0x001e:
        r5 = r4.j(r5);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r5 = com.google.common.collect.i.c(r5);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r6 = com.google.common.base.Predicates.G(r6);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r5 = r5.e(r6);	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r5 = r5.pq();	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r5 = (com.iqoption.dto.entity.expiration.Expiration) r5;	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        if (r5 == 0) goto L_0x0041;
    L_0x0036:
        r6 = r5.deadTime;	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        if (r6 == 0) goto L_0x0041;
    L_0x003a:
        r5 = r5.deadTime;	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        r5 = r5.longValue();	 Catch:{ ExecutionException -> 0x0042, ExecutionException -> 0x0042 }
        return r5;
    L_0x0041:
        return r1;
    L_0x0042:
        r5 = move-exception;
        r6 = "ExpirationCfdHelper";
        r0 = "checkExpiration Exception ";
        com.iqoption.core.i.w(r6, r0, r5);
        goto L_0x004c;
    L_0x004b:
        return r1;
    L_0x004c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.a.b.c(com.iqoption.core.microservices.tradingengine.response.active.a, com.iqoption.dto.entity.expiration.Expiration):long");
    }
}
