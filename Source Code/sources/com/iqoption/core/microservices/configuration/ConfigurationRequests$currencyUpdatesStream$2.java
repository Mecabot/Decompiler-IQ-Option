package com.iqoption.core.microservices.configuration;

import com.iqoption.core.microservices.configuration.a.d;
import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ConfigurationRequests.kt */
final class ConfigurationRequests$currencyUpdatesStream$2 extends Lambda implements kotlin.jvm.a.a<e<com.iqoption.core.microservices.a<d>>> {
    public static final ConfigurationRequests$currencyUpdatesStream$2 aUI = new ConfigurationRequests$currencyUpdatesStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a aUJ = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<d> apply(d dVar) {
            h.e(dVar, "it");
            return new com.iqoption.core.microservices.a(1, dVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aUK = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<d> apply(d dVar) {
            h.e(dVar, "it");
            return new com.iqoption.core.microservices.a(3, dVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class c<T, R> implements f<T, R> {
        public static final c aUL = new c();

        c() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<d> apply(d dVar) {
            h.e(dVar, "it");
            return new com.iqoption.core.microservices.a(2, dVar);
        }
    }

    ConfigurationRequests$currencyUpdatesStream$2() {
        super(0);
    }

    /* renamed from: Jr */
    public final e<com.iqoption.core.microservices.a<d>> invoke() {
        h.d(com.iqoption.core.f.DT().c("currency-created", d.class).Hr().d((f) a.aUJ), "eventBuilderFactory\n    …Event.TYPE_CREATED, it) }");
        h.d(com.iqoption.core.f.DT().c("currency-updated", d.class).Hr().d((f) c.aUL), "eventBuilderFactory\n    …Event.TYPE_UPDATED, it) }");
        h.d(com.iqoption.core.f.DT().c("currency-deleted", d.class).Hr().d((f) b.aUK), "eventBuilderFactory\n    …Event.TYPE_DELETED, it) }");
        return e.K(m.listOf(r0, r1, r2));
    }
}
