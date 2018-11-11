package com.iqoption.billing.repository;

import com.iqoption.core.f.a.a;
import com.iqoption.core.microservices.billing.response.b;
import io.reactivex.processors.PublishProcessor;
import java.util.concurrent.TimeUnit;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, aXE = {"Lcom/iqoption/billing/repository/SessionRepository;", "Lcom/iqoption/core/manager/LogoutClearList$Clearable;", "()V", "DISPOSE_DELAY_MILLIS", "", "SESSION_EXPIRED_TIMEOUT_MILLIS", "refreshProcessor", "Lio/reactivex/processors/PublishProcessor;", "", "kotlin.jvm.PlatformType", "sessionStream", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "getSessionStream", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "sessionStream$delegate", "Lkotlin/Lazy;", "clearOnLogout", "", "getSession", "Lio/reactivex/Flowable;", "refreshSession", "billing_release"})
/* compiled from: SessionRepository.kt */
public final class e implements a {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "sessionStream", "getSessionStream()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};
    private static final long aqO = TimeUnit.MINUTES.toMillis(20);
    private static final long arv = TimeUnit.HOURS.toMillis(20);
    private static final PublishProcessor<Object> arw = PublishProcessor.aXq();
    private static final d arx = g.f(SessionRepository$sessionStream$2.arz);
    public static final e ary;

    private final com.iqoption.core.h.d<b> JH() {
        d dVar = arx;
        j jVar = apP[0];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    static {
        e eVar = new e();
        ary = eVar;
        com.iqoption.core.f.a.a(eVar);
    }

    private e() {
    }

    public void Js() {
        com.iqoption.core.h.d.a(JH(), null, 1, null);
    }

    public final io.reactivex.e<b> JF() {
        return JH().Yg();
    }

    public final void JI() {
        arw.e(new Object());
    }
}
