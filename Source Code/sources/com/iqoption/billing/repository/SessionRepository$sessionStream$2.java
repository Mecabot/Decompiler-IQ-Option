package com.iqoption.billing.repository;

import com.iqoption.core.h.d;
import com.iqoption.core.microservices.billing.response.b;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "invoke"})
/* compiled from: SessionRepository.kt */
final class SessionRepository$sessionStream$2 extends Lambda implements kotlin.jvm.a.a<d<b>> {
    public static final SessionRepository$sessionStream$2 arz = new SessionRepository$sessionStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult;", "it", "", "apply"})
    /* compiled from: SessionRepository.kt */
    static final class a<T, R> implements f<T, s<? extends R>> {
        public static final a arA = new a();

        a() {
        }

        /* renamed from: ba */
        public final o<b> apply(Object obj) {
            h.e(obj, "it");
            return com.iqoption.core.microservices.billing.a.aSZ.Uv();
        }
    }

    SessionRepository$sessionStream$2() {
        super(0);
    }

    /* renamed from: JJ */
    public final d<b> invoke() {
        e aWk = com.iqoption.core.microservices.billing.a.aSZ.Uv().aWk();
        e c = e.arw.d((org.a.b) e.a(e.arv, e.arv, TimeUnit.MILLISECONDS)).c(com.iqoption.core.h.i.Yo()).c((f) a.arA);
        h.d(aWk, "init");
        h.d(c, "updates");
        return new d(aWk, c, e.aqO, null, 8, null);
    }
}
