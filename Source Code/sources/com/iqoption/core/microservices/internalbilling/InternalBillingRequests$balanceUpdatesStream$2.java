package com.iqoption.core.microservices.internalbilling;

import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: InternalBillingRequests.kt */
final class InternalBillingRequests$balanceUpdatesStream$2 extends Lambda implements kotlin.jvm.a.a<e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a>>> {
    public static final InternalBillingRequests$balanceUpdatesStream$2 aWj = new InternalBillingRequests$balanceUpdatesStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "it", "apply"})
    /* compiled from: InternalBillingRequests.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a aWk = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a> apply(com.iqoption.core.microservices.internalbilling.a.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(1, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/internalbilling/response/Balance;", "it", "Lcom/iqoption/core/microservices/internalbilling/response/BalanceChanged;", "apply"})
    /* compiled from: InternalBillingRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aWl = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a> apply(com.iqoption.core.microservices.internalbilling.a.b bVar) {
            h.e(bVar, "it");
            com.iqoption.core.microservices.internalbilling.a.a Wa = bVar.Wa();
            if (Wa == null) {
                h.aXZ();
            }
            return new com.iqoption.core.microservices.a(2, Wa);
        }
    }

    InternalBillingRequests$balanceUpdatesStream$2() {
        super(0);
    }

    /* renamed from: Jr */
    public final e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.internalbilling.a.a>> invoke() {
        h.d(com.iqoption.core.f.DT().c("balance-created", com.iqoption.core.microservices.internalbilling.a.a.class).Hr().d((f) a.aWk), "eventBuilderFactory\n    …Event.TYPE_CREATED, it) }");
        h.d(com.iqoption.core.f.DT().c("balance-changed", com.iqoption.core.microservices.internalbilling.a.b.class).Hr().d((f) b.aWl), "eventBuilderFactory\n    …D, it.currentBalance!!) }");
        return e.K(m.listOf(r0, r1));
    }
}
