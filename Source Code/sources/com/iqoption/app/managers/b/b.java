package com.iqoption.app.managers.b;

import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0010R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/app/managers/markup/MarkupManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "disposables", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/iqoption/core/data/model/InstrumentType;", "Lio/reactivex/disposables/Disposable;", "eventHandler", "Lcom/iqoption/app/managers/markup/MarkupManager$EventHandler;", "markupCache", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "clearMarkupStreams", "", "getInstruments", "getMarkup", "", "instrumentType", "activeId", "", "leverage", "", "init", "Lcom/google/common/util/concurrent/ListenableFuture;", "instrument", "release", "EventHandler", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MarkupManager.kt */
public final class b {
    private static final String TAG = aoQ.getClass().getSimpleName();
    private static final ConcurrentHashMap<InstrumentType, io.reactivex.disposables.b> aoN = new ConcurrentHashMap();
    private static final a aoO = new a();
    private static final ConcurrentHashMap<InstrumentType, List<com.iqoption.core.microservices.risks.response.b.a>> aoP = new ConcurrentHashMap();
    public static final b aoQ = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "kotlin.jvm.PlatformType", "accept", "com/iqoption/app/managers/markup/MarkupManager$init$1$1"})
    /* compiled from: MarkupManager.kt */
    static final class b<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.risks.response.b.a>> {
        final /* synthetic */ InstrumentType aoT;
        final /* synthetic */ y aoU;

        b(InstrumentType instrumentType, y yVar) {
            this.aoT = instrumentType;
            this.aoU = yVar;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.core.microservices.risks.response.b.a> list) {
            this.aoU.P(this.aoT);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/iqoption/app/managers/markup/MarkupManager$init$1$2"})
    /* compiled from: MarkupManager.kt */
    static final class c<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ InstrumentType aoT;
        final /* synthetic */ y aoU;

        c(InstrumentType instrumentType, y yVar) {
            this.aoT = instrumentType;
            this.aoU = yVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            this.aoU.h(th);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/core/microservices/risks/response/markup/Active;", "kotlin.jvm.PlatformType", "accept", "com/iqoption/app/managers/markup/MarkupManager$init$1$3"})
    /* compiled from: MarkupManager.kt */
    static final class d<T> implements io.reactivex.c.e<List<? extends com.iqoption.core.microservices.risks.response.b.a>> {
        final /* synthetic */ InstrumentType aoT;
        final /* synthetic */ y aoU;

        d(InstrumentType instrumentType, y yVar) {
            this.aoT = instrumentType;
            this.aoU = yVar;
        }

        /* renamed from: C */
        public final void accept(List<com.iqoption.core.microservices.risks.response.b.a> list) {
            Map d = b.aoP;
            InstrumentType instrumentType = this.aoT;
            h.d(list, "it");
            d.put(instrumentType, list);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/iqoption/app/managers/markup/MarkupManager$init$1$4"})
    /* compiled from: MarkupManager.kt */
    static final class e<T> implements io.reactivex.c.e<Throwable> {
        final /* synthetic */ InstrumentType aoT;
        final /* synthetic */ y aoU;

        e(InstrumentType instrumentType, y yVar) {
            this.aoT = instrumentType;
            this.aoU = yVar;
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            String b = b.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to get markups for ");
            stringBuilder.append(this.aoT);
            com.iqoption.core.i.e(b, stringBuilder.toString(), th);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/app/managers/markup/MarkupManager$EventHandler;", "Lcom/iqoption/system/event/EventHandlerBase;", "()V", "onAccountGroupIdChange", "", "accountGroupId", "Lcom/iqoption/app/events/IQAccountEvents$GroupId;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MarkupManager.kt */
    public static final class a extends com.iqoption.system.a.d {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: MarkupManager.kt */
        static final class a implements Runnable {
            public static final a aoR = new a();

            a() {
            }

            public final void run() {
                b.aoQ.Ij();
                com.iqoption.core.i.d(b.TAG, "onAccountGroupIdChange, reinitialize markups");
                for (InstrumentType o : b.aoQ.Ik()) {
                    b.aoQ.o(o);
                }
            }
        }

        @com.google.common.b.e
        public final void onAccountGroupIdChange(com.iqoption.app.b.b.i iVar) {
            h.e(iVar, "accountGroupId");
            com.iqoption.core.d.a.aSc.execute(a.aoR);
        }
    }

    private b() {
    }

    public final s<InstrumentType> o(InstrumentType instrumentType) {
        h.e(instrumentType, "instrument");
        io.reactivex.disposables.b bVar = (io.reactivex.disposables.b) aoN.get(instrumentType);
        if (bVar != null) {
            bVar.dispose();
        }
        aoO.register();
        if (com.iqoption.app.managers.feature.a.eX("spread-by-leverage")) {
            com.iqoption.app.a Cw = com.iqoption.app.a.Cw();
            h.d(Cw, "IQAccount.instance()");
            long groupId = (long) Cw.getGroupId();
            y wb = y.wb();
            io.reactivex.e d = com.iqoption.asset.repository.b.aqu.a(instrumentType, groupId).d(com.iqoption.core.h.i.Yo());
            Map map = aoN;
            io.reactivex.disposables.b a = d.cQ(1).a((io.reactivex.c.e) new b(instrumentType, wb), (io.reactivex.c.e) new c(instrumentType, wb));
            h.d(a, "markups\n                …                       })");
            map.put(instrumentType, a);
            map = aoN;
            bVar = d.a((io.reactivex.c.e) new d(instrumentType, wb), (io.reactivex.c.e) new e(instrumentType, wb));
            h.d(bVar, "markups.subscribe({\n    …t)\n                    })");
            map.put(instrumentType, bVar);
            h.d(wb, "waitFoMarkupFuture");
            return wb;
        }
        s<InstrumentType> aR = o.aR(instrumentType);
        h.d(aR, "Futures.immediateFuture<…strumentType>(instrument)");
        return aR;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    public final double a(com.iqoption.core.data.model.InstrumentType r7, long r8, int r10) {
        /*
        r6 = this;
        r0 = "instrumentType";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = "spread-by-leverage";
        r0 = com.iqoption.app.managers.feature.a.eX(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = com.iqoption.app.managers.b.c.aoS;
        r3 = r7.ordinal();
        r0 = r0[r3];
        switch(r0) {
            case 1: goto L_0x001d;
            case 2: goto L_0x001d;
            case 3: goto L_0x001d;
            default: goto L_0x001c;
        };
    L_0x001c:
        goto L_0x0051;
    L_0x001d:
        r0 = aoP;
        r7 = r0.get(r7);
        r7 = (java.util.List) r7;
        if (r7 == 0) goto L_0x0051;
    L_0x0027:
        r7 = (java.lang.Iterable) r7;
        r7 = r7.iterator();
    L_0x002d:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0048;
    L_0x0033:
        r0 = r7.next();
        r3 = r0;
        r3 = (com.iqoption.core.microservices.risks.response.b.a) r3;
        r3 = r3.WF();
        r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0044;
    L_0x0042:
        r3 = 1;
        goto L_0x0045;
    L_0x0044:
        r3 = 0;
    L_0x0045:
        if (r3 == 0) goto L_0x002d;
    L_0x0047:
        goto L_0x0049;
    L_0x0048:
        r0 = 0;
    L_0x0049:
        r0 = (com.iqoption.core.microservices.risks.response.b.a) r0;
        if (r0 == 0) goto L_0x0051;
    L_0x004d:
        r1 = r0.dO(r10);
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.b.b.a(com.iqoption.core.data.model.InstrumentType, long, int):double");
    }

    private final void Ij() {
        Enumeration elements = aoN.elements();
        h.d(elements, "disposables.elements()");
        Iterator a = o.a(elements);
        while (a.hasNext()) {
            ((io.reactivex.disposables.b) a.next()).dispose();
        }
        aoN.clear();
    }

    private final List<InstrumentType> Ik() {
        List<InstrumentType> arrayList = new ArrayList();
        if (com.iqoption.app.managers.feature.a.HK()) {
            arrayList.add(InstrumentType.CFD_INSTRUMENT);
        }
        if (com.iqoption.app.managers.feature.a.HL()) {
            arrayList.add(InstrumentType.FOREX_INSTRUMENT);
        }
        if (com.iqoption.app.managers.feature.a.HM()) {
            arrayList.add(InstrumentType.CRYPTO_INSTRUMENT);
        }
        return arrayList;
    }
}
