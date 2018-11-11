package com.iqoption.core.data.repository;

import io.reactivex.c.e;
import io.reactivex.c.f;
import io.reactivex.k;
import io.reactivex.o;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0012J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0014\u001a\u00020\u0015JC\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u001b0\u0019\"\u0004\b\u0000\u0010\u001c\"\u000e\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u001c0\u001d2\u0006\u0010\u0014\u001a\u0002H\u001cH\u0002¢\u0006\u0002\u0010\u001eJH\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u00050\u0004\"\f\b\u0000\u0010\u001a*\u0006\u0012\u0002\b\u00030\u001d2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u00050\u00102\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\"0\u0012R'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006#"}, aXE = {"Lcom/iqoption/core/data/repository/GeneralRepository;", "", "()V", "countriesStreamSupplier", "Lcom/iqoption/core/rx/LiveStreamSupplier;", "", "Lcom/iqoption/core/microservices/configuration/response/Country;", "getCountriesStreamSupplier", "()Lcom/iqoption/core/rx/LiveStreamSupplier;", "countriesStreamSupplier$delegate", "Lkotlin/Lazy;", "currenciesStream", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "getCurrenciesStream", "currenciesStream$delegate", "getCountriesHttp", "Lio/reactivex/Single;", "getCountry", "Lio/reactivex/Flowable;", "Lio/reactivex/Maybe;", "id", "", "getCurrencies", "getCurrency", "makeByIdMaybeMapper", "Lio/reactivex/functions/Function;", "T", "Lio/reactivex/MaybeSource;", "ID", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "(Ljava/lang/Object;)Lio/reactivex/functions/Function;", "makeStreamSupplier", "initialRequest", "updatesStream", "Lcom/iqoption/core/microservices/Event;", "core_release"})
/* compiled from: GeneralRepository.kt */
public final class c {
    private static final d aOK = g.f(GeneralRepository$countriesStreamSupplier$2.aON);
    private static final d aOL = g.f(GeneralRepository$currenciesStream$2.aOO);
    public static final c aOM = new c();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "countriesStreamSupplier", "getCountriesStreamSupplier()Lcom/iqoption/core/rx/LiveStreamSupplier;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "currenciesStream", "getCurrenciesStream()Lcom/iqoption/core/rx/LiveStreamSupplier;"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0004\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n¢\u0006\u0002\b\b"}, aXE = {"<anonymous>", "Lio/reactivex/MaybeSource;", "T", "kotlin.jvm.PlatformType", "ID", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "it", "", "apply"})
    /* compiled from: GeneralRepository.kt */
    static final class a<T, R> implements f<List<? extends T>, k<T>> {
        final /* synthetic */ Object aOP;

        a(Object obj) {
            this.aOP = obj;
        }

        /* renamed from: ah */
        public final k<T> apply(List<? extends T> list) {
            h.e(list, "it");
            for (Object next : list) {
                if (h.E(((com.iqoption.core.ui.widget.recyclerview.adapter.a.d) next).Jf(), this.aOP)) {
                    break;
                }
            }
            Object next2 = null;
            com.iqoption.core.ui.widget.recyclerview.adapter.a.d dVar = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) next2;
            if (dVar != null) {
                return io.reactivex.i.bZ(dVar);
            }
            return io.reactivex.i.aWe();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0006*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "T", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "it", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: GeneralRepository.kt */
    static final class b<T> implements e<List<? extends T>> {
        final /* synthetic */ AtomicReference aOI;

        b(AtomicReference atomicReference) {
            this.aOI = atomicReference;
        }

        /* renamed from: C */
        public final void accept(List<? extends T> list) {
            this.aOI.set(list);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "T", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "event", "Lcom/iqoption/core/microservices/Event;", "apply"})
    /* compiled from: GeneralRepository.kt */
    static final class c<T, R> implements f<T, R> {
        final /* synthetic */ AtomicReference aOI;

        c(AtomicReference atomicReference) {
            this.aOI = atomicReference;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
        /* renamed from: a */
        public final java.util.List<T> apply(com.iqoption.core.microservices.a<T> r8) {
            /*
            r7 = this;
            r0 = "event";
            kotlin.jvm.internal.h.e(r8, r0);
            r0 = r7.aOI;
            r0 = r0.get();
            r1 = "list.get()";
            kotlin.jvm.internal.h.d(r0, r1);
            r0 = (java.util.Collection) r0;
            r0 = kotlin.collections.u.O(r0);
            r1 = r8.getType();
            r2 = 0;
            r3 = -1;
            switch(r1) {
                case 1: goto L_0x0083;
                case 2: goto L_0x0050;
                case 3: goto L_0x0021;
                default: goto L_0x001f;
            };
        L_0x001f:
            goto L_0x00b5;
        L_0x0021:
            r8 = r8.getData();
            r8 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r8;
            r1 = r0.iterator();
        L_0x002b:
            r4 = r1.hasNext();
            if (r4 == 0) goto L_0x0049;
        L_0x0031:
            r4 = r1.next();
            r4 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r4;
            r4 = r4.Jf();
            r5 = r8.Jf();
            r4 = kotlin.jvm.internal.h.E(r4, r5);
            if (r4 == 0) goto L_0x0046;
        L_0x0045:
            goto L_0x004a;
        L_0x0046:
            r2 = r2 + 1;
            goto L_0x002b;
        L_0x0049:
            r2 = -1;
        L_0x004a:
            if (r2 == r3) goto L_0x00b5;
        L_0x004c:
            r0.remove(r2);
            goto L_0x00b5;
        L_0x0050:
            r8 = r8.getData();
            r8 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r8;
            r1 = r0.iterator();
        L_0x005a:
            r4 = r1.hasNext();
            if (r4 == 0) goto L_0x0078;
        L_0x0060:
            r4 = r1.next();
            r4 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r4;
            r4 = r4.Jf();
            r5 = r8.Jf();
            r4 = kotlin.jvm.internal.h.E(r4, r5);
            if (r4 == 0) goto L_0x0075;
        L_0x0074:
            goto L_0x0079;
        L_0x0075:
            r2 = r2 + 1;
            goto L_0x005a;
        L_0x0078:
            r2 = -1;
        L_0x0079:
            if (r2 != r3) goto L_0x007f;
        L_0x007b:
            r0.add(r8);
            goto L_0x00b5;
        L_0x007f:
            r0.set(r2, r8);
            goto L_0x00b5;
        L_0x0083:
            r1 = r8.getData();
            r1 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r1;
            r4 = r0.iterator();
        L_0x008d:
            r5 = r4.hasNext();
            if (r5 == 0) goto L_0x00ab;
        L_0x0093:
            r5 = r4.next();
            r5 = (com.iqoption.core.ui.widget.recyclerview.adapter.a.d) r5;
            r5 = r5.Jf();
            r6 = r1.Jf();
            r5 = kotlin.jvm.internal.h.E(r5, r6);
            if (r5 == 0) goto L_0x00a8;
        L_0x00a7:
            goto L_0x00ac;
        L_0x00a8:
            r2 = r2 + 1;
            goto L_0x008d;
        L_0x00ab:
            r2 = -1;
        L_0x00ac:
            if (r2 != r3) goto L_0x00b5;
        L_0x00ae:
            r8 = r8.getData();
            r0.add(r8);
        L_0x00b5:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.data.repository.c.c.a(com.iqoption.core.microservices.a):java.util.List<T>");
        }
    }

    private final com.iqoption.core.h.d<List<com.iqoption.core.microservices.configuration.a.c>> SL() {
        d dVar = aOK;
        j jVar = apP[0];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    private final com.iqoption.core.h.d<List<com.iqoption.core.microservices.configuration.a.d>> SO() {
        d dVar = aOL;
        j jVar = apP[1];
        return (com.iqoption.core.h.d) dVar.getValue();
    }

    private c() {
    }

    public final <T extends com.iqoption.core.ui.widget.recyclerview.adapter.a.d<?>> com.iqoption.core.h.d<List<T>> a(o<List<T>> oVar, io.reactivex.e<com.iqoption.core.microservices.a<T>> eVar) {
        h.e(oVar, "initialRequest");
        h.e(eVar, "updatesStream");
        AtomicReference atomicReference = new AtomicReference(m.emptyList());
        io.reactivex.e a = oVar.aWk().c((org.a.b) eVar.d((f) new c(atomicReference))).a((e) new b(atomicReference));
        h.d(a, "initial.concatWith(updat…doOnNext { list.set(it) }");
        return new com.iqoption.core.h.d(a, TimeUnit.SECONDS.toMillis(5), null, 4, null);
    }

    private final <ID, T extends com.iqoption.core.ui.widget.recyclerview.adapter.a.d<ID>> f<List<T>, k<T>> be(ID id) {
        return new a(id);
    }

    public final o<List<com.iqoption.core.microservices.configuration.a.c>> SM() {
        return com.iqoption.core.microservices.configuration.a.aUz.SM();
    }

    public final io.reactivex.e<List<com.iqoption.core.microservices.configuration.a.c>> SN() {
        return SL().Yg();
    }

    public final io.reactivex.i<com.iqoption.core.microservices.configuration.a.c> aP(long j) {
        io.reactivex.i<com.iqoption.core.microservices.configuration.a.c> h = SL().Yg().aVX().h(be(Long.valueOf(j)));
        h.d(h, "countriesStreamSupplier.…(makeByIdMaybeMapper(id))");
        return h;
    }

    public final io.reactivex.e<List<com.iqoption.core.microservices.configuration.a.d>> SP() {
        return SO().Yg();
    }
}
