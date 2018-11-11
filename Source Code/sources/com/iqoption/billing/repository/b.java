package com.iqoption.billing.repository;

import com.iqoption.core.h.d;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, aXE = {"Lcom/iqoption/billing/repository/CashBoxRepository;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "CASHBOX_EXPIRED_FIRST_TIMEOUT_MILLIS", "", "CASHBOX_EXPIRED_TIMEOUT_MILLIS", "DISPOSE_DELAY_MILLIS", "countingCache", "Lcom/iqoption/billing/repository/CountingCash;", "clearOnLogout", "", "createCountingLiveStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "sessionHost", "", "sessionId", "withKycLimit", "", "getCounting", "Lio/reactivex/Flowable;", "billing_release"})
/* compiled from: CashBoxRepository.kt */
public final class b implements com.iqoption.core.f.a.a {
    private static final long aqO = TimeUnit.MINUTES.toMillis(20);
    private static final long arn = TimeUnit.MINUTES.toMillis(30);
    private static final long aro = TimeUnit.HOURS.toMillis(1);
    private static d arp;
    public static final b arq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/billing/response/CashboxResult;", "it", "", "apply", "(Ljava/lang/Long;)Lio/reactivex/Single;"})
    /* compiled from: CashBoxRepository.kt */
    static final class a<T, R> implements f<T, s<? extends R>> {
        final /* synthetic */ o arr;

        a(o oVar) {
            this.arr = oVar;
        }

        /* renamed from: k */
        public final o<com.iqoption.core.microservices.billing.response.a> apply(Long l) {
            h.e(l, "it");
            return this.arr;
        }
    }

    static {
        b bVar = new b();
        arq = bVar;
        com.iqoption.core.f.a.a(bVar);
    }

    private b() {
    }

    public void Js() {
        d dVar = arp;
        if (dVar != null) {
            d Jv = dVar.Jv();
            if (Jv != null) {
                d.a(Jv, null, 1, null);
            }
        }
        arp = (d) null;
    }

    public final e<com.iqoption.core.microservices.billing.response.a> c(String str, String str2, boolean z) {
        h.e(str, "sessionHost");
        h.e(str2, "sessionId");
        c cVar = new c(str, str2, z);
        d dVar = arp;
        if (h.E(dVar != null ? dVar.JG() : null, cVar)) {
            return dVar.Jv().Yg();
        }
        d d = d(str, str2, z);
        arp = new d(cVar, d);
        return d.Yg();
    }

    private final d<com.iqoption.core.microservices.billing.response.a> d(String str, String str2, boolean z) {
        o e = com.iqoption.core.microservices.billing.a.aSZ.e(str, str2, z);
        e aWk = e.aWk();
        e c = e.a(arn, aro, TimeUnit.MILLISECONDS).c((f) new a(e));
        h.d(aWk, "init");
        h.d(c, "updates");
        return new d(aWk, c, aqO, null, 8, null);
    }
}
