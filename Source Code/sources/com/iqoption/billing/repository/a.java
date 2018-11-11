package com.iqoption.billing.repository;

import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¨\u0006\n"}, aXE = {"Lcom/iqoption/billing/repository/CashBoxMediator;", "", "()V", "getCounting", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "withKycLimit", "", "getSession", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "billing_release"})
/* compiled from: CashBoxMediator.kt */
public final class a {
    public static final a arj = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002 \u0003*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "kotlin.jvm.PlatformType", "session", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: CashBoxMediator.kt */
    static final class a<T, R> implements f<T, org.a.b<? extends R>> {
        final /* synthetic */ boolean ark;

        a(boolean z) {
            this.ark = z;
        }

        /* renamed from: b */
        public final e<com.iqoption.core.microservices.billing.response.deposit.b> apply(com.iqoption.core.microservices.billing.response.b.a aVar) {
            h.e(aVar, "session");
            return b.arq.c(aVar.getHost(), aVar.Uy(), this.ark).d((f) AnonymousClass1.arl);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "apply"})
    /* compiled from: CashBoxMediator.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b arm = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.billing.response.b.a apply(com.iqoption.core.microservices.billing.response.b bVar) {
            h.e(bVar, "it");
            return bVar.Ux();
        }
    }

    private a() {
    }

    public final e<com.iqoption.core.microservices.billing.response.b.a> JF() {
        e<com.iqoption.core.microservices.billing.response.b.a> d = e.ary.JF().d((f) b.arm);
        h.d(d, "SessionRepository.getSession().map { it.result }");
        return d;
    }

    public final e<com.iqoption.core.microservices.billing.response.deposit.b> bE(boolean z) {
        e<com.iqoption.core.microservices.billing.response.deposit.b> a = JF().a((f) new a(z));
        h.d(a, "getSession().flatMap { s…              }\n        }");
        return a;
    }
}
