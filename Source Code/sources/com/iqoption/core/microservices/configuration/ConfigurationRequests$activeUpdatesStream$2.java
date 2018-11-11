package com.iqoption.core.microservices.configuration;

import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Active;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ConfigurationRequests.kt */
final class ConfigurationRequests$activeUpdatesStream$2 extends Lambda implements kotlin.jvm.a.a<e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.a>>> {
    public static final ConfigurationRequests$activeUpdatesStream$2 aUA = new ConfigurationRequests$activeUpdatesStream$2();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Active;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class a<T, R> implements f<T, R> {
        public static final a aUB = new a();

        a() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.a> apply(com.iqoption.core.microservices.configuration.a.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(1, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Active;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b aUC = new b();

        b() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.a> apply(com.iqoption.core.microservices.configuration.a.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(3, aVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/Event;", "Lcom/iqoption/core/microservices/configuration/response/Active;", "it", "apply"})
    /* compiled from: ConfigurationRequests.kt */
    static final class c<T, R> implements f<T, R> {
        public static final c aUD = new c();

        c() {
        }

        /* renamed from: a */
        public final com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.a> apply(com.iqoption.core.microservices.configuration.a.a aVar) {
            h.e(aVar, "it");
            return new com.iqoption.core.microservices.a(2, aVar);
        }
    }

    ConfigurationRequests$activeUpdatesStream$2() {
        super(0);
    }

    /* renamed from: Jr */
    public final e<com.iqoption.core.microservices.a<com.iqoption.core.microservices.configuration.a.a>> invoke() {
        h.d(com.iqoption.core.f.DT().c("active-created", com.iqoption.core.microservices.configuration.a.a.class).eT("2.0").Hr().d((f) a.aUB), "eventBuilderFactory\n    …Event.TYPE_CREATED, it) }");
        h.d(com.iqoption.core.f.DT().c("active-updated", com.iqoption.core.microservices.configuration.a.a.class).eT("2.0").Hr().d((f) c.aUD), "eventBuilderFactory\n    …Event.TYPE_UPDATED, it) }");
        h.d(com.iqoption.core.f.DT().c("active-deleted", com.iqoption.core.microservices.configuration.a.a.class).eT("2.0").Hr().d((f) b.aUC), "eventBuilderFactory\n    …Event.TYPE_DELETED, it) }");
        return e.K(m.listOf(r0, r1, r2));
    }
}
