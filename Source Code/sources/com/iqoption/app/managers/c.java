package com.iqoption.app.managers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.gl.Graph;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.position.Order;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.position.PositionAndOrder;
import com.iqoption.dto.entity.position.result.DeferredOrdersResult;
import com.iqoption.dto.entity.position.result.HistoryResult;
import com.iqoption.dto.entity.position.result.PositionsResult;
import com.iqoption.dto.entity.result.BuybackResult;
import com.iqoption.dto.entity.strike.Quote;
import com.iqoption.dto.entity.strike.Quote.Key;
import com.iqoption.gl.NativeHandler;
import com.iqoption.mobbtech.connect.request.api.Requests;
import com.iqoption.mobbtech.connect.request.api.Requests.OptionType;
import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse.Map;
import com.iqoption.mobbtech.connect.response.options.OptionEvents;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.TYPE_REMOVE_GROUP;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.k;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.m;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.p;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.q;
import com.iqoption.mobbtech.connect.response.options.i;
import com.iqoption.mobbtech.connect.response.options.j;
import com.iqoption.service.WebSocketHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: OptionManager */
public class c {
    private static final String TAG = "com.iqoption.app.managers.c";
    private static final n<c> amp = Suppliers.a(i.ajD);
    private final ConcurrentMap<com.iqoption.mobbtech.connect.response.d.a, com.iqoption.mobbtech.connect.response.d> amA = Maps.ut();
    private final ConcurrentMap<Key, Quote> amB = Maps.ut();
    private final ConcurrentMap<Integer, ActiveQuote> amC = Maps.ut();
    private final com.iqoption.util.b.a<Order> amD = new com.iqoption.util.b.a();
    private final ConcurrentHashMap<Long, com.iqoption.util.b.a<Order>> amE = new ConcurrentHashMap();
    private final ConcurrentLinkedQueue<OptionEvents> amF = new ConcurrentLinkedQueue();
    private ScheduledFuture<?> amG;
    private ScheduledFuture<?> amH;
    private final x amI = new x(new com.iqoption.app.managers.x.a() {
        public void GG() {
            c.this.amu.register();
            c.this.amv.register();
            c.this.amG = c.this.singleThreadExecutor.scheduleAtFixedRate(new j(this), 5000, 5000, TimeUnit.MILLISECONDS);
            c.this.amH = c.this.singleThreadExecutor.scheduleAtFixedRate(new k(this), 300, 300, TimeUnit.MILLISECONDS);
            c.this.update();
            com.iqoption.view.a.b.aIK().a(c.this.amJ, Integer.valueOf(5));
        }

        final /* synthetic */ void GJ() {
            c.this.Gt();
        }

        final /* synthetic */ void GI() {
            c.this.Gy();
        }

        public void GH() {
            com.iqoption.view.a.b.aIK().b(c.this.amJ);
            if (c.this.amG != null) {
                c.this.amG.cancel(true);
            }
            if (c.this.amH != null) {
                c.this.amH.cancel(true);
            }
            c.this.amu.unregister();
            c.this.amv.unregister();
        }
    });
    private com.iqoption.view.a.b.a amJ = new d(this);
    private final Runnable amK = new e(this);
    private g amL = new g();
    private final Runnable amM = new Runnable() {
        public void run() {
            Iterator sI = c.this.Gp().iterator();
            double d = 0.0d;
            double d2 = 0.0d;
            double d3 = d2;
            while (sI.hasNext()) {
                com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) sI.next();
                d += bVar.getSellPnl();
                d2 += bVar.getInvestSum().doubleValue();
                d3 += bVar.avl();
            }
            double d4 = (d / d2) * 100.0d;
            if (!c.this.amL.b(d, d4, d2, d3)) {
                IQApp.Dn().aE(c.this.amL.a(d, d4, d2, d3));
            }
        }
    };
    private s<List<Object>> amq;
    private boolean amr;
    private volatile boolean ams;
    private volatile y<Void> amt = y.wb();
    private final b amu = new b(this, null);
    private final f amv = new f(this, null);
    private final ConcurrentSkipListMap<i, com.iqoption.mobbtech.connect.response.options.b> amw = new ConcurrentSkipListMap(i.cWP);
    private final ConcurrentSkipListMap<i, com.iqoption.mobbtech.connect.response.options.a> amx = new ConcurrentSkipListMap(i.cWQ);
    private final ConcurrentSkipListMap<i, com.iqoption.mobbtech.connect.response.options.b> amy = new ConcurrentSkipListMap(i.cWP);
    private final ConcurrentMap<i, com.iqoption.mobbtech.connect.response.c> amz = Maps.ut();
    private final Context iG = IQApp.Dk();
    private final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();

    /* compiled from: OptionManager */
    public static final class g {
        private volatile double amX;
        private volatile double amY;
        private volatile double amZ;
        private volatile double ana;

        private g a(double d, double d2, double d3, double d4) {
            this.amX = d;
            this.amY = d2;
            this.amZ = d3;
            this.ana = d4;
            return this;
        }

        public boolean b(double d, double d2, double d3, double d4) {
            return com.google.common.c.a.b(this.amX, d, 0.01d) && com.google.common.c.a.b(this.amY, d2, 0.01d) && com.google.common.c.a.b(this.amZ, d3, 0.01d) && com.google.common.c.a.b(this.ana, d4, 0.01d);
        }

        public double GM() {
            return this.amX;
        }

        public double GN() {
            return this.amZ;
        }

        public double GO() {
            return (this.amZ + this.amX) + this.ana;
        }
    }

    /* compiled from: OptionManager */
    private class c implements com.google.common.util.concurrent.n<List<j>> {
        public void l(Throwable th) {
        }

        private c() {
        }

        /* synthetic */ c(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: B */
        public void onSuccess(List<j> list) {
            if (list != null) {
                for (j jVar : list) {
                    long longValue = com.iqoption.app.a.aL(IQApp.Dk()).getBalanceId().longValue();
                    if (jVar.userBalanceId == null || jVar.userBalanceId.equals(Long.valueOf(longValue))) {
                        for (com.iqoption.mobbtech.connect.response.options.e eVar : jVar.aHd) {
                            eVar.getOptionKey();
                            eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
                            c.this.c(eVar);
                        }
                        for (com.iqoption.mobbtech.connect.response.options.a a : jVar.cWS) {
                            c.this.a(a);
                        }
                    } else {
                        String GE = c.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("OptionResponseCallback balance id is not equal, position balance id: ");
                        stringBuilder.append(jVar);
                        stringBuilder.append(", current balance id:");
                        stringBuilder.append(longValue);
                        com.iqoption.core.i.d(GE, stringBuilder.toString());
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: OptionManager */
    private final class h implements com.google.common.util.concurrent.n<List<Object>> {
        private h() {
        }

        /* synthetic */ h(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: B */
        public void onSuccess(List<Object> list) {
            GP();
        }

        public void l(@NonNull Throwable th) {
            if (!(th instanceof CancellationException) || c.this.amq.isCancelled()) {
                fail();
            } else {
                com.iqoption.core.i.d(c.TAG, "Callback for task that was cancelled. But another one is in progress.");
            }
        }

        private void GP() {
            c.this.amr = false;
            p pVar = new p();
            pVar.setValue(Boolean.valueOf(true));
            c.this.amF.add(pVar);
            c.this.Gr();
            com.iqoption.core.i.d(c.TAG, "update finished - success");
            c.this.ams = true;
            c.this.amt.P(null);
            c.this.amt = y.wb();
        }

        private void fail() {
            c.this.amr = true;
            p pVar = new p();
            pVar.setValue(Boolean.valueOf(false));
            c.this.amF.add(pVar);
            com.iqoption.core.i.d(c.TAG, "update finished - error");
            c.this.ams = true;
            c.this.amt.P(null);
            c.this.amt = y.wb();
            c.this.clear();
        }
    }

    /* compiled from: OptionManager */
    private class a extends com.iqoption.system.c.a<List<DeferredOrdersResult>> {
        private a() {
        }

        /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: B */
        public void onSuccess(List<DeferredOrdersResult> list) {
            if (list != null) {
                List arrayList = new ArrayList();
                for (DeferredOrdersResult deferredOrdersResult : list) {
                    if (deferredOrdersResult != null) {
                        if (!com.iqoption.util.i.H(deferredOrdersResult.deferredOrders)) {
                            Iterator it = deferredOrdersResult.deferredOrders.iterator();
                            while (it.hasNext()) {
                                Order order = (Order) it.next();
                                if (Order.isDeferredOrder(order)) {
                                    arrayList.add(order);
                                }
                            }
                        }
                    }
                }
                c.this.A(arrayList);
            }
        }
    }

    /* compiled from: OptionManager */
    private class b extends com.iqoption.system.a.d {
        private final com.google.common.base.d<BuybackResult, Pair<BuybackResult, i>> amT;

        private b() {
            this.amT = l.$instance;
        }

        /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void onMapBuybackResponse(Map map) {
            if (map != null) {
                c.this.singleThreadExecutor.execute(new m(this, map));
            }
        }

        @com.google.common.b.e
        public void onTabChanged(com.iqoption.app.managers.tab.a.i iVar) {
            c.this.Gz();
        }
    }

    /* compiled from: OptionManager */
    private class d extends com.iqoption.system.c.a<List<HistoryResult>> {
        private d() {
        }

        /* synthetic */ d(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: B */
        public void onSuccess(List<HistoryResult> list) {
            if (list != null) {
                for (HistoryResult historyResult : list) {
                    if (historyResult != null) {
                        if (!com.iqoption.util.i.H(historyResult.history)) {
                            long longValue = com.iqoption.app.a.aL(IQApp.Dk()).getBalanceId().longValue();
                            Iterator it = historyResult.history.iterator();
                            while (it.hasNext()) {
                                com.iqoption.mobbtech.connect.response.options.e eVar = (Position) it.next();
                                if (eVar.getUserBalanceId() == null || eVar.getUserBalanceId().equals(Long.valueOf(longValue))) {
                                    c.this.e(eVar);
                                } else {
                                    String GE = c.TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("PositionHistoryResponseCallback balance id is not equal, position balance id: ");
                                    stringBuilder.append(eVar.getUserBalanceId());
                                    stringBuilder.append(", current balance id:");
                                    stringBuilder.append(longValue);
                                    com.iqoption.core.i.d(GE, stringBuilder.toString());
                                    return;
                                }
                            }
                            continue;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: OptionManager */
    private class e extends com.iqoption.system.c.a<List<PositionsResult>> {
        private e() {
        }

        /* synthetic */ e(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* renamed from: B */
        public void onSuccess(List<PositionsResult> list) {
            String GE = c.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("position response: ");
            stringBuilder.append(String.valueOf(list));
            com.iqoption.core.i.d(GE, stringBuilder.toString());
            if (list != null) {
                for (PositionsResult positionsResult : list) {
                    if (positionsResult != null) {
                        if (!com.iqoption.util.i.H(positionsResult.positions)) {
                            com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
                            Iterator it = positionsResult.positions.iterator();
                            while (it.hasNext()) {
                                com.iqoption.mobbtech.connect.response.options.e eVar = (PositionAndOrder) it.next();
                                sO.f(eVar.orders);
                                eVar.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
                                c.this.c(eVar);
                            }
                            it = sO.sP().iterator();
                            while (it.hasNext()) {
                                Order order = (Order) it.next();
                                if (Order.isTpslOrder(order)) {
                                    c.this.g(order);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: OptionManager */
    private class f extends com.iqoption.system.a.h {
        private f() {
        }

        /* synthetic */ f(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @com.google.common.b.e
        public void onChangeBalanceId(com.iqoption.service.e.a aVar) {
            com.iqoption.core.i.d(c.TAG, "event=IQAccountEvents.BalanceIdChanged");
            c.this.singleThreadExecutor.execute(new n(this));
        }

        final /* synthetic */ void GL() {
            c.this.clear();
            c.this.update();
        }

        @com.google.common.b.e
        public void onOpenWebSocket(com.iqoption.service.e.g gVar) {
            com.iqoption.core.i.d(c.TAG, "event=WebSocketEvents.OpenWebSocket");
            c.this.singleThreadExecutor.execute(new o(this));
        }

        final /* synthetic */ void GK() {
            c.this.clear();
            c.this.update();
        }
    }

    private boolean k(long j, long j2) {
        return j != -1 && (j * 1000) + 60000 < j2;
    }

    private void a(Order order) {
        if (order != null) {
            if ((this.amD.add(order) == null ? 1 : null) != null) {
                IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.d().setValue(order));
            }
            IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.c());
            Gr();
        }
    }

    private void A(List<Order> list) {
        if (list != null) {
            this.amD.addAll(list);
            IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.c());
        }
    }

    private boolean b(Order order) {
        boolean z = false;
        if (order == null) {
            return false;
        }
        if (this.amD.remove(order) != null) {
            z = true;
        }
        if (z) {
            IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.c());
        }
        return z;
    }

    public ImmutableList<Order> Gl() {
        return ImmutableList.m(this.amD.aGI());
    }

    public ImmutableList<Order> Gm() {
        com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
        for (com.iqoption.util.b.a aGI : this.amE.values()) {
            sO.f(aGI.aGI());
        }
        return sO.sP();
    }

    public ImmutableList<Order> i(Long l) {
        com.iqoption.util.b.a aVar = (com.iqoption.util.b.a) this.amE.get(l);
        if (aVar == null) {
            return ImmutableList.sL();
        }
        return ImmutableList.m(aVar.aGI());
    }

    public ImmutableList<Order> j(Long l) {
        com.iqoption.util.b.a aVar = (com.iqoption.util.b.a) this.amE.remove(l);
        if (aVar == null) {
            return ImmutableList.sL();
        }
        return ImmutableList.m(aVar.aGI());
    }

    private Order c(Order order) {
        com.iqoption.util.b.a aVar = (com.iqoption.util.b.a) this.amE.get(order.getPositionId());
        if (aVar == null) {
            aVar = new com.iqoption.util.b.a();
            this.amE.put(order.getPositionId(), aVar);
        }
        if (!a(aVar, order)) {
            return null;
        }
        aVar.add(order);
        return order;
    }

    private boolean a(com.iqoption.util.b.a<Order> aVar, Order order) {
        Order order2 = (Order) aVar.get(order);
        boolean z = true;
        if (order2 == null) {
            return true;
        }
        if (order2.getIndex() > order.getIndex()) {
            z = false;
        }
        return z;
    }

    private Order d(Order order) {
        com.iqoption.util.b.a aVar = (com.iqoption.util.b.a) this.amE.get(order.getPositionId());
        if (aVar != null) {
            aVar.remove(order);
        }
        return order;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    private void e(com.iqoption.dto.entity.position.Order r4) {
        /*
        r3 = this;
        r0 = r4.getStatus();
        r1 = r0.hashCode();
        r2 = -123173735; // 0xfffffffff8a88499 float:-2.7343602E34 double:NaN;
        if (r1 == r2) goto L_0x001d;
    L_0x000d:
        r2 = 108960; // 0x1a9a0 float:1.52685E-40 double:5.38334E-319;
        if (r1 == r2) goto L_0x0013;
    L_0x0012:
        goto L_0x0027;
    L_0x0013:
        r1 = "new";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        r0 = 0;
        goto L_0x0028;
    L_0x001d:
        r1 = "canceled";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0025:
        r0 = 1;
        goto L_0x0028;
    L_0x0027:
        r0 = -1;
    L_0x0028:
        switch(r0) {
            case 0: goto L_0x0030;
            case 1: goto L_0x002c;
            default: goto L_0x002b;
        };
    L_0x002b:
        goto L_0x0033;
    L_0x002c:
        r3.b(r4);
        goto L_0x0033;
    L_0x0030:
        r3.a(r4);
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.c.e(com.iqoption.dto.entity.position.Order):void");
    }

    private void f(Order order) {
        if (!"new".equals(order.getExecuteStatus())) {
            return;
        }
        if (b(order)) {
            IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.e().setValue(order));
        } else {
            j(c(order));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    private void g(com.iqoption.dto.entity.position.Order r4) {
        /*
        r3 = this;
        r0 = r4.getStatus();
        r1 = r0.hashCode();
        r2 = -123173735; // 0xfffffffff8a88499 float:-2.7343602E34 double:NaN;
        if (r1 == r2) goto L_0x001d;
    L_0x000d:
        r2 = 108960; // 0x1a9a0 float:1.52685E-40 double:5.38334E-319;
        if (r1 == r2) goto L_0x0013;
    L_0x0012:
        goto L_0x0027;
    L_0x0013:
        r1 = "new";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        r0 = 0;
        goto L_0x0028;
    L_0x001d:
        r1 = "canceled";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0025:
        r0 = 1;
        goto L_0x0028;
    L_0x0027:
        r0 = -1;
    L_0x0028:
        switch(r0) {
            case 0: goto L_0x0034;
            case 1: goto L_0x002c;
            default: goto L_0x002b;
        };
    L_0x002b:
        goto L_0x0052;
    L_0x002c:
        r4 = r3.d(r4);
        k(r4);
        goto L_0x0052;
    L_0x0034:
        r0 = r3.b(r4);
        if (r0 != 0) goto L_0x0042;
    L_0x003a:
        r4 = r3.c(r4);
        j(r4);
        goto L_0x0052;
    L_0x0042:
        r0 = com.iqoption.app.IQApp.Dn();
        r1 = new com.iqoption.mobbtech.connect.response.options.OptionEvents$e;
        r1.<init>();
        r4 = r1.setValue(r4);
        r0.aE(r4);
    L_0x0052:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.c.g(com.iqoption.dto.entity.position.Order):void");
    }

    private void h(Order order) {
        if (order.getInstrumentType() != null) {
            IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.f(order));
        }
    }

    private c() {
    }

    public static c Gn() {
        return (c) amp.get();
    }

    public void initialize() {
        this.amI.start();
    }

    final /* synthetic */ void aq(long j) {
        Gz();
        GC();
    }

    public ImmutableList<com.iqoption.mobbtech.connect.response.options.a> Go() {
        return ImmutableList.m(this.amx.values());
    }

    public ImmutableList<com.iqoption.mobbtech.connect.response.options.b> Gp() {
        return ImmutableList.m(this.amw.values());
    }

    @Nullable
    public com.iqoption.mobbtech.connect.response.options.b a(i iVar) {
        com.iqoption.mobbtech.connect.response.options.b bVar = iVar == null ? null : (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(iVar);
        return bVar != null ? bVar.avi() : bVar;
    }

    public boolean b(i iVar) {
        return this.amw.containsKey(iVar) ^ 1;
    }

    public boolean Gq() {
        return this.amw.isEmpty();
    }

    private void Gr() {
        com.iqoption.g.a aDm = WebSocketHandler.aDm();
        if (aDm.isAuthorized()) {
            WebSocketHandler.a(aDm);
        }
    }

    public void update() {
        com.iqoption.core.i.d(TAG, "update");
        if (WebSocketHandler.aDm().isAuthorized()) {
            long longValue = com.iqoption.app.a.aL(this.iG).getBalanceId().longValue();
            if (longValue == -1) {
                com.iqoption.core.i.d(TAG, "skip update, unknown balance id");
                return;
            }
            if (!Gv()) {
                com.iqoption.core.i.d(TAG, "preparing futures to get positions");
                this.ams = false;
                IQApp.Dn().aE(new q());
                s am = am(longValue);
                s ao = ao(longValue);
                s an = an(longValue);
                s ap = ap(longValue);
                Iterable arrayList = new ArrayList();
                if (am != null) {
                    arrayList.add(am);
                }
                if (ao != null) {
                    arrayList.add(ao);
                }
                if (ap != null) {
                    arrayList.add(ap);
                }
                if (an != null) {
                    arrayList.add(an);
                }
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("all position futures size is ");
                stringBuilder.append(arrayList.size());
                com.iqoption.core.i.d(str, stringBuilder.toString());
                if (arrayList.isEmpty()) {
                    com.iqoption.core.i.d(TAG, "update finished");
                    this.ams = true;
                    this.amt.P(null);
                    this.amt = y.wb();
                } else {
                    this.amq = o.E(arrayList);
                    o.a(this.amq, new h(this, null), this.singleThreadExecutor);
                }
            }
            return;
        }
        com.iqoption.core.i.d(TAG, "skip update, socket is not authorized");
    }

    public s<?> am(long j) {
        if (!com.iqoption.app.managers.feature.a.HJ() && !com.iqoption.app.managers.feature.a.HG()) {
            return null;
        }
        s a = Requests.a(this.iG, OptionType.turbo, 100, j);
        s a2 = Requests.a(this.iG, OptionType.binary, 100, j);
        s<?> a3 = o.a(a, a2);
        o.a(a3, new c(this, null), this.singleThreadExecutor);
        return a3;
    }

    public s<?> an(long j) {
        Iterable arrayList = new ArrayList();
        if (com.iqoption.app.managers.feature.a.HK()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.n(j, InstrumentType.CFD_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HL()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.n(j, InstrumentType.FOREX_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HM()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.n(j, InstrumentType.CRYPTO_INSTRUMENT));
        }
        s<?> E = o.E(arrayList);
        o.a(E, new a(this, null), this.singleThreadExecutor);
        return E;
    }

    public s<?> ao(long j) {
        Iterable arrayList = new ArrayList();
        if (com.iqoption.app.managers.feature.a.HH()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.m(j, InstrumentType.DIGITAL_INSTRUMENT));
            com.iqoption.core.i.d(TAG, "add position request for digital");
        }
        if (com.iqoption.app.managers.feature.a.HK()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.m(j, InstrumentType.CFD_INSTRUMENT));
            com.iqoption.core.i.d(TAG, "add position request for cfd");
        }
        if (com.iqoption.app.managers.feature.a.HL()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.m(j, InstrumentType.FOREX_INSTRUMENT));
            com.iqoption.core.i.d(TAG, "add position request for forex");
        }
        if (com.iqoption.app.managers.feature.a.HM()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.m(j, InstrumentType.CRYPTO_INSTRUMENT));
            com.iqoption.core.i.d(TAG, "add position request for crypto");
        }
        if (com.iqoption.app.managers.feature.a.HI()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.m(j, InstrumentType.FX_INSTRUMENT));
            com.iqoption.core.i.d(TAG, "add position request for fx");
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("open position futures size is ");
        stringBuilder.append(arrayList.size());
        com.iqoption.core.i.d(str, stringBuilder.toString());
        s<?> E = o.E(arrayList);
        o.a(E, new e(this, null), this.singleThreadExecutor);
        return E;
    }

    public s<?> ap(long j) {
        Iterable arrayList = new ArrayList();
        if (com.iqoption.app.managers.feature.a.HH()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.o(j, InstrumentType.DIGITAL_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HK()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.o(j, InstrumentType.CFD_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HL()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.o(j, InstrumentType.FOREX_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HM()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.o(j, InstrumentType.CRYPTO_INSTRUMENT));
        }
        if (com.iqoption.app.managers.feature.a.HI()) {
            arrayList.add(com.iqoption.mobbtech.connect.request.api.f.o(j, InstrumentType.FX_INSTRUMENT));
        }
        s<?> E = o.E(arrayList);
        o.a(E, new d(this, null), this.singleThreadExecutor);
        return E;
    }

    public void clear() {
        com.iqoption.core.i.d(TAG, "clear");
        IQApp.Dn().aE(this.amL.a(0.0d, 0.0d, 0.0d, 0.0d));
        if (Gv()) {
            this.amq.cancel(true);
        }
        this.amq = null;
        Gs();
        this.amz.clear();
        this.amA.clear();
        this.amB.clear();
        this.amE.clear();
        this.amD.clear();
        this.amw.clear();
        this.amx.clear();
        this.amy.clear();
        Gx();
    }

    private void Gs() {
        for (Entry entry : this.amw.entrySet()) {
            i iVar = (i) entry.getKey();
            switch (iVar.getInstrumentType()) {
                case DIGITAL_INSTRUMENT:
                case FX_INSTRUMENT:
                    a((com.iqoption.mobbtech.connect.response.options.b) entry.getValue());
                    break;
                case TURBO_INSTRUMENT:
                case BINARY_INSTRUMENT:
                    d(iVar);
                    break;
                default:
                    break;
            }
        }
    }

    private void a(com.iqoption.mobbtech.connect.response.options.e eVar) {
        switch (eVar.getInstrumentType()) {
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                a((Position) eVar);
                return;
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                c(eVar.getOptionKey());
                return;
            default:
                return;
        }
    }

    private void b(com.iqoption.mobbtech.connect.response.options.e eVar) {
        switch (eVar.getInstrumentType()) {
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                b((Position) eVar);
                return;
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                d(eVar.getOptionKey());
                return;
            default:
                return;
        }
    }

    private void c(i iVar) {
        com.iqoption.mobbtech.connect.response.d.a a = com.iqoption.mobbtech.connect.response.d.a(iVar.getActiveId(), iVar.avm());
        y.a(true, a);
        a.recycle();
    }

    private void d(i iVar) {
        com.iqoption.mobbtech.connect.response.d.a e = com.iqoption.mobbtech.connect.response.d.e(iVar);
        if (y.a(false, e)) {
            this.amA.remove(e);
        }
        e.recycle();
    }

    private void a(com.iqoption.mobbtech.connect.response.options.b bVar) {
        int groupId = com.iqoption.app.a.Cw().getGroupId();
        Iterator sI = bVar.avh().iterator();
        while (sI.hasNext()) {
            Position position = (Position) ((com.iqoption.mobbtech.connect.response.options.e) sI.next());
            y.a(false, position.getInstrumentId(), position.getInstrumentType(), groupId);
        }
    }

    private void a(Position position) {
        if (position.isSpotStrike()) {
            y.a(true, position.spotLowerInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
            y.a(true, position.spotUpperInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
            return;
        }
        y.a(true, position.getInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
    }

    private void b(Position position) {
        if (position.isSpotStrike()) {
            y.a(false, position.spotLowerInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
            y.a(false, position.spotUpperInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
            return;
        }
        y.a(false, position.getInstrumentId(), position.getInstrumentType(), com.iqoption.app.a.Cw().getGroupId());
    }

    private boolean a(i iVar, long j) {
        com.iqoption.mobbtech.connect.response.options.e bI;
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeClosedFromOpen, closedOptionKey=");
        stringBuilder.append(iVar);
        stringBuilder.append(", optionId=");
        stringBuilder.append(j);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(iVar);
        com.iqoption.mobbtech.connect.response.options.b bVar2 = (com.iqoption.mobbtech.connect.response.options.b) this.amy.get(iVar);
        boolean z = false;
        if (bVar != null) {
            bI = bVar.bI(j);
            if (bI != null) {
                z = true;
                if (bVar2 == null) {
                    bVar2 = new com.iqoption.mobbtech.connect.response.options.b(bI);
                    this.amy.put(iVar, bVar2);
                } else if (!bVar2.avh().contains(bI)) {
                    bVar2.s(bI);
                }
                if (bVar.isEmpty()) {
                    this.amw.remove(bVar.getOptionKey());
                    this.amy.remove(iVar);
                    this.amF.add(new k(Gp(), bVar2, TYPE_REMOVE_GROUP.SELL));
                    Gy();
                }
                b(bI);
            }
        } else {
            bI = null;
        }
        if (z && !bVar.isEmpty()) {
            this.amF.add(new OptionEvents.j(Gp(), bVar, bI));
        }
        return z;
    }

    private void Gt() {
        long Gu = Gu();
        List<i> arrayList = new ArrayList();
        for (i iVar : this.amw.keySet()) {
            if (k(iVar.avm().longValue(), Gu)) {
                arrayList.add(iVar);
            }
        }
        for (i iVar2 : arrayList) {
            com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amy.remove(iVar2);
            bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.remove(iVar2);
            if (bVar != null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("remove expired open option group, optionKey=");
                stringBuilder.append(iVar2);
                com.iqoption.core.i.d(str, stringBuilder.toString());
                this.amF.add(new k(Gp(), bVar, TYPE_REMOVE_GROUP.HOVERING));
            }
        }
        if (!arrayList.isEmpty()) {
            update();
        }
        Iterator it = this.amB.entrySet().iterator();
        while (it.hasNext()) {
            if (((Quote) ((Entry) it.next()).getValue()).isExpired()) {
                it.remove();
            }
        }
    }

    private long Gu() {
        return af.Hu().Hw();
    }

    public boolean Gv() {
        return (this.amq == null || this.amq.isDone() || this.amq.isCancelled()) ? false : true;
    }

    public boolean Gw() {
        return this.amr;
    }

    private void Gx() {
        IQApp.Dn().aE(new m());
        IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.b());
        IQApp.Dn().aE(new com.iqoption.mobbtech.connect.response.options.OptionEvents.c());
    }

    private void c(com.iqoption.mobbtech.connect.response.options.e eVar) {
        i optionKey = eVar.getOptionKey();
        long Gu = Gu();
        if (k(optionKey.avm().longValue(), Gu)) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("updateOrCreateOpenOptionGroup skip new option, option is expired. optionKey=");
            stringBuilder.append(optionKey);
            stringBuilder.append(", serverTime:");
            stringBuilder.append(Gu);
            com.iqoption.core.i.d(str, stringBuilder.toString());
            return;
        }
        com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(optionKey);
        if (bVar == null) {
            bVar = new com.iqoption.mobbtech.connect.response.options.b(eVar);
            this.amw.put(optionKey, bVar);
            this.amF.add(new com.iqoption.mobbtech.connect.response.options.OptionEvents.h(Gp(), bVar));
            Gy();
        } else {
            bVar.s(eVar);
            this.amF.add(new OptionEvents.i(Gp(), bVar, eVar));
            Gy();
        }
        a(eVar);
    }

    private void d(com.iqoption.mobbtech.connect.response.options.e eVar) {
        if (eVar != null) {
            Long balanceId = com.iqoption.app.a.Cw().getBalanceId();
            if (Objects.equals(balanceId, eVar.getUserBalanceId())) {
                if (eVar.isClosed()) {
                    e(eVar);
                } else {
                    c(eVar);
                }
                Gr();
                return;
            }
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("applyOption balance id is not equal, position balance id: ");
            stringBuilder.append(eVar.getUserBalanceId());
            stringBuilder.append(", current balance id:");
            stringBuilder.append(balanceId);
            com.iqoption.core.i.d(str, stringBuilder.toString());
        }
    }

    private void c(Position position) {
        if (position != null) {
            position.timeRecieved = Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d);
            if (position.isClosed() && position.isSold()) {
                d(position);
            } else {
                d((com.iqoption.mobbtech.connect.response.options.e) position);
            }
        }
    }

    private void d(Position position) {
        if (position != null) {
            long longValue = com.iqoption.app.a.aL(IQApp.Dk()).getBalanceId().longValue();
            if (position.getUserBalanceId() == null || position.getUserBalanceId().equals(Long.valueOf(longValue))) {
                this.amF.add(new OptionEvents.n(position));
                try {
                    i closeOptionKey = position.getCloseOptionKey();
                    com.iqoption.mobbtech.connect.response.options.a aVar = (com.iqoption.mobbtech.connect.response.options.a) this.amx.get(closeOptionKey);
                    if (aVar == null) {
                        aVar = com.iqoption.mobbtech.connect.response.options.a.l(position);
                        this.amx.put(closeOptionKey, aVar);
                        com.iqoption.mobbtech.connect.response.options.OptionEvents.g gVar = new com.iqoption.mobbtech.connect.response.options.OptionEvents.g();
                        gVar.setValue(Pair.create(Go(), aVar));
                        this.amF.add(gVar);
                    } else if (!aVar.A(position.getId())) {
                        aVar.m(position);
                        this.amF.add(new com.iqoption.mobbtech.connect.response.options.OptionEvents.a(Go(), aVar, position.getId()));
                    }
                    closeOptionKey = position.getOptionKey();
                    com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(closeOptionKey);
                    if (bVar != null) {
                        bVar.s((com.iqoption.mobbtech.connect.response.options.e) position);
                    }
                    a(closeOptionKey, position.getId().longValue());
                    Gr();
                } catch (Exception e) {
                    com.iqoption.core.i.d(e.getMessage());
                }
                return;
            }
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sellPosition balance id is not equal, position balance ud: ");
            stringBuilder.append(position.getUserBalanceId());
            stringBuilder.append(", current balance id:");
            stringBuilder.append(longValue);
            com.iqoption.core.i.d(str, stringBuilder.toString());
        }
    }

    private void a(i iVar, BuybackResult buybackResult) {
        if (iVar != null && buybackResult != null) {
            com.iqoption.mobbtech.connect.response.options.a aVar = (com.iqoption.mobbtech.connect.response.options.a) this.amx.get(iVar);
            if (aVar == null) {
                com.iqoption.mobbtech.connect.response.options.a b = com.iqoption.mobbtech.connect.response.options.a.b(buybackResult);
                this.amx.put(iVar, b);
                com.iqoption.mobbtech.connect.response.options.OptionEvents.g gVar = new com.iqoption.mobbtech.connect.response.options.OptionEvents.g();
                gVar.setValue(Pair.create(Go(), b));
                this.amF.add(gVar);
            } else if (!aVar.A(buybackResult.optionId)) {
                aVar.c(buybackResult);
                this.amF.add(new com.iqoption.mobbtech.connect.response.options.OptionEvents.a(Go(), aVar, buybackResult.optionId));
            }
        }
    }

    private void e(com.iqoption.mobbtech.connect.response.options.e eVar) {
        i closeOptionKey = eVar.getCloseOptionKey();
        com.iqoption.mobbtech.connect.response.options.a aVar = (com.iqoption.mobbtech.connect.response.options.a) this.amx.get(closeOptionKey);
        if (aVar == null) {
            aVar = com.iqoption.mobbtech.connect.response.options.a.q(eVar);
            this.amx.put(closeOptionKey, aVar);
            com.iqoption.mobbtech.connect.response.options.OptionEvents.g gVar = new com.iqoption.mobbtech.connect.response.options.OptionEvents.g();
            gVar.setValue(Pair.create(Go(), aVar));
            this.amF.add(gVar);
        } else if (!aVar.A(eVar.getId())) {
            aVar.s(eVar);
            this.amF.add(new com.iqoption.mobbtech.connect.response.options.OptionEvents.a(Go(), aVar, eVar.getId()));
        }
        com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amy.get(closeOptionKey);
        if (bVar == null) {
            bVar = new com.iqoption.mobbtech.connect.response.options.b(eVar);
            this.amy.put(closeOptionKey, bVar);
        } else if (!bVar.avh().contains(eVar)) {
            bVar.s(eVar);
        }
        com.iqoption.mobbtech.connect.response.options.b bVar2 = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(closeOptionKey);
        if (bVar2 != null) {
            com.iqoption.mobbtech.connect.response.options.e bI = bVar2.bI(eVar.getId().longValue());
            if (bI != null) {
                this.amF.add(new OptionEvents.j(Gp(), bVar2, bI));
                if (bVar2.isEmpty()) {
                    this.amw.remove(closeOptionKey);
                    this.amy.remove(closeOptionKey);
                    this.amF.add(new k(Gp(), bVar, TYPE_REMOVE_GROUP.EXPIRED));
                }
                b(eVar);
            }
        }
    }

    private void Gy() {
        ImmutableList Go = Go();
        ImmutableList Gp = Gp();
        OptionEvents optionEvents = (OptionEvents) this.amF.poll();
        while (optionEvents != null) {
            if (optionEvents.a(Go, Gp)) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sen pending event:");
                stringBuilder.append(optionEvents);
                com.iqoption.core.i.v(str, stringBuilder.toString());
                IQApp.Dn().aE(optionEvents);
            }
            optionEvents = (OptionEvents) this.amF.poll();
        }
    }

    private void a(com.iqoption.mobbtech.connect.response.options.a aVar) {
        i optionKey = aVar.getOptionKey();
        com.iqoption.mobbtech.connect.response.options.a aVar2 = (com.iqoption.mobbtech.connect.response.options.a) this.amx.get(optionKey);
        if (aVar2 == null) {
            this.amx.put(optionKey, aVar);
            com.iqoption.mobbtech.connect.response.options.OptionEvents.g gVar = new com.iqoption.mobbtech.connect.response.options.OptionEvents.g();
            gVar.setValue(Pair.create(Go(), aVar));
            this.amF.add(gVar);
        } else if (aVar2.size() < aVar.size()) {
            com.iqoption.core.i.v(TAG, "existed closed group is smaller than new one, replace by new");
            this.amx.replace(optionKey, aVar);
            OptionEvents.o oVar = new OptionEvents.o();
            oVar.setValue(Pair.create(Go(), aVar));
            this.amF.add(oVar);
        }
        com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(optionKey);
        if (bVar != null) {
            com.iqoption.mobbtech.connect.response.options.b bVar2 = (com.iqoption.mobbtech.connect.response.options.b) this.amy.get(optionKey);
            Iterator sI = aVar.avf().iterator();
            while (sI.hasNext()) {
                com.iqoption.mobbtech.connect.response.options.e bI = bVar.bI(((Long) sI.next()).longValue());
                if (bI != null) {
                    this.amF.add(new OptionEvents.j(Gp(), bVar, bI));
                }
                if (bVar2 == null) {
                    bVar2 = new com.iqoption.mobbtech.connect.response.options.b(bI);
                    this.amy.put(optionKey, bVar2);
                } else if (!bVar2.avh().contains(bI)) {
                    bVar2.s(bI);
                }
            }
            if (bVar.isEmpty()) {
                this.amw.remove(optionKey);
                this.amy.remove(optionKey);
                this.amF.add(new k(Gp(), bVar2, TYPE_REMOVE_GROUP.EXPIRED));
                Gy();
            }
        }
    }

    public void f(com.iqoption.mobbtech.connect.response.options.e eVar) {
        this.singleThreadExecutor.execute(new f(this, eVar));
    }

    public void c(ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList) {
        com.iqoption.core.i.d(TAG, "event=WebSocketEvents.ListInfoData. New positions have come from the server");
        this.singleThreadExecutor.execute(new g(this, immutableList));
    }

    public void e(Position position) {
        this.singleThreadExecutor.execute(new h(this, position));
    }

    public void a(int i, double d, double d2, double d3) {
        ActiveQuote activeQuote = (ActiveQuote) this.amC.get(Integer.valueOf(i));
        if (activeQuote != null) {
            activeQuote.update(d, d2, d3);
            return;
        }
        int i2 = i;
        this.amC.put(Integer.valueOf(i2), new ActiveQuote(i2, d, d2, d3, com.iqoption.app.helpers.a.FI().cX(i2)));
    }

    @Nullable
    public com.iqoption.mobbtech.connect.response.b a(Long l, Integer num, InstrumentType instrumentType) {
        return b(l, num, instrumentType);
    }

    public com.iqoption.mobbtech.connect.response.d b(Long l, Integer num, InstrumentType instrumentType) {
        com.iqoption.mobbtech.connect.response.d.a a = com.iqoption.mobbtech.connect.response.d.a(num, l);
        com.iqoption.mobbtech.connect.response.d dVar = (com.iqoption.mobbtech.connect.response.d) this.amA.get(a);
        a.recycle();
        return (dVar == null || !dVar.q(l.longValue(), instrumentType)) ? null : dVar;
    }

    public void a(com.iqoption.mobbtech.connect.response.d dVar) {
        com.iqoption.mobbtech.connect.response.d.a c = com.iqoption.mobbtech.connect.response.d.c(dVar);
        if (this.amA.containsKey(c)) {
            this.amA.put(c, dVar);
        } else {
            this.amA.put(com.iqoption.mobbtech.connect.response.d.b(dVar), dVar);
        }
        c.recycle();
    }

    public void a(com.iqoption.mobbtech.connect.response.c cVar) {
        i b = i.b(cVar);
        if (this.amz.containsKey(b)) {
            this.amz.put(b, cVar);
        } else {
            this.amz.put(cVar.getOptionKey(), cVar);
        }
        b.recycle();
    }

    public void d(ImmutableList<Quote> immutableList) {
        if (immutableList != null) {
            Iterator sI = immutableList.iterator();
            while (sI.hasNext()) {
                b((Quote) sI.next());
            }
        }
    }

    public void a(Quote[] quoteArr) {
        if (quoteArr != null) {
            for (Quote b : quoteArr) {
                b(b);
            }
        }
    }

    public void a(Quote quote) {
        if (quote != null) {
            b(quote);
        }
    }

    private void b(Quote quote) {
        if (quote != null) {
            quote.lastTimeUpdate = System.currentTimeMillis();
            Key obtain = Quote.obtain(quote.instrumentId, quote.instrumentType);
            Quote quote2 = (Quote) this.amB.get(obtain);
            obtain.recycle();
            if (quote2 != null) {
                this.amB.put(obtain, quote);
            } else {
                this.amB.put(new Key(quote.instrumentId, quote.instrumentType), quote);
            }
        }
    }

    public void b(String str, InstrumentType instrumentType) {
        Key obtain = Quote.obtain(str, instrumentType);
        this.amB.remove(obtain);
        obtain.recycle();
    }

    @Nullable
    public Quote c(String str, InstrumentType instrumentType) {
        Key obtain = Quote.obtain(str, instrumentType);
        Quote quote = (Quote) this.amB.get(obtain);
        obtain.recycle();
        return quote;
    }

    @Nullable
    public ActiveQuote da(int i) {
        return (ActiveQuote) this.amC.get(Integer.valueOf(i));
    }

    public void i(Order order) {
        if (Order.isMarketOrderFilled(order)) {
            h(order);
        } else if (Order.isTpslOrder(order)) {
            g(order);
        } else if (Order.isDeferredOrder(order)) {
            e(order);
        } else if (Order.mktOnOpenExecuting(order)) {
            f(order);
        }
    }

    private void Gz() {
        NativeHandler.instance().singleThreadExecutor.execute(this.amK);
    }

    final /* synthetic */ void GD() {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        if (Il.FW() && IC != null) {
            i a = i.a(Integer.valueOf(IC.getActiveId()), IC.getInstrumentType(), Long.valueOf(IC.IP()));
            com.iqoption.mobbtech.connect.response.options.b bVar = (com.iqoption.mobbtech.connect.response.options.b) this.amw.get(a);
            a.recycle();
            if (bVar != null) {
                Iterator sI;
                switch (bVar.instrumentType) {
                    case DIGITAL_INSTRUMENT:
                    case FX_INSTRUMENT:
                        bVar.avj();
                        break;
                    case TURBO_INSTRUMENT:
                    case BINARY_INSTRUMENT:
                        sI = bVar.avh().iterator();
                        while (sI.hasNext()) {
                            com.iqoption.mobbtech.connect.response.options.e eVar = (com.iqoption.mobbtech.connect.response.options.e) sI.next();
                            com.iqoption.gl.b.aow().glchTabOnBetsProfitChange(eVar.getId().longValue(), eVar.getCurrentProfitAmount().doubleValue());
                        }
                        break;
                    case FOREX_INSTRUMENT:
                    case CRYPTO_INSTRUMENT:
                    case CFD_INSTRUMENT:
                        break;
                }
                sI = bVar.avh().iterator();
                while (sI.hasNext()) {
                    h((Position) ((com.iqoption.mobbtech.connect.response.options.e) sI.next()));
                }
            }
        }
    }

    public g GA() {
        return this.amL;
    }

    public s<Void> GB() {
        return this.ams ? o.aR(null) : this.amt;
    }

    private void GC() {
        this.singleThreadExecutor.execute(this.amM);
    }

    public void g(com.iqoption.mobbtech.connect.response.options.e eVar) {
        long longValue = eVar.getExpired().longValue();
        if (longValue > 0) {
            longValue *= 1000;
        }
        InstrumentType instrumentType = eVar.getInstrumentType();
        com.iqoption.app.managers.tab.a.g a = com.iqoption.app.managers.tab.a.Il().a(eVar.getActiveId(), instrumentType, new Expiration(longValue, eVar.getExpirationPeriod() * 1000));
        switch (instrumentType) {
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
            case FOREX_INSTRUMENT:
            case CRYPTO_INSTRUMENT:
            case CFD_INSTRUMENT:
                if (a != null && (eVar instanceof Position)) {
                    com.iqoption.gl.b.aow().glchSetSelectedPosition(a.IM(), ((Position) eVar).getPositionSplitId());
                    return;
                }
                return;
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
                com.iqoption.gl.b.aow().glchTabOnBetSelected(eVar.getId().longValue());
                return;
            default:
                return;
        }
    }

    public static void h(com.iqoption.mobbtech.connect.response.options.e eVar) {
        a(true, ImmutableList.af(eVar), -1);
    }

    public static void e(ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList) {
        a(true, (ImmutableList) immutableList, -1);
    }

    public static void i(com.iqoption.mobbtech.connect.response.options.e eVar) {
        a(false, ImmutableList.af(eVar), -1);
    }

    public static void f(ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList) {
        a(false, (ImmutableList) immutableList, -1);
    }

    public static void j(com.iqoption.mobbtech.connect.response.options.e eVar) {
        a(false, ImmutableList.af(eVar), af.Hu().Hw());
    }

    public static void g(ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList) {
        a(false, (ImmutableList) immutableList, af.Hu().Hw());
    }

    private static void a(boolean z, ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList, long j) {
        ImmutableList immutableList2 = immutableList;
        if (immutableList2 != null) {
            int size = immutableList.size();
            if (size != 0) {
                int[] iArr = new int[size];
                long[] jArr = new long[size];
                int[] iArr2 = new int[size];
                int[] iArr3 = new int[size];
                double[] dArr = new double[size];
                long[] jArr2 = new long[size];
                long[] jArr3 = new long[size];
                long[] jArr4 = new long[size];
                double[] dArr2 = new double[size];
                double[] dArr3 = new double[size];
                double[] dArr4 = new double[size];
                int i = 0;
                while (i < size) {
                    com.iqoption.mobbtech.connect.response.options.e eVar = (com.iqoption.mobbtech.connect.response.options.e) immutableList2.get(i);
                    iArr[i] = eVar.getActiveId();
                    jArr[i] = eVar.getId().longValue();
                    iArr2[i] = eVar.getClientPlatformId() == null ? 17 : eVar.getClientPlatformId().intValue();
                    dArr[i] = eVar.getValue().doubleValue();
                    jArr2[i] = eVar.getCreated().longValue();
                    iArr3[i] = eVar.getDir().equals(NotificationCompat.CATEGORY_CALL);
                    jArr3[i] = eVar.getExpired().longValue();
                    jArr4[i] = j;
                    dArr4[i] = eVar.timeRecieved.doubleValue();
                    dArr2[i] = eVar.getInvestSum().doubleValue();
                    dArr3[i] = eVar.getCurrentProfitAmount().doubleValue();
                    i++;
                    ImmutableList<com.iqoption.mobbtech.connect.response.options.e> immutableList22 = immutableList;
                }
                if (z) {
                    com.iqoption.gl.b.aow().glchTabAddBets(size, iArr, jArr, iArr2, iArr3, dArr, jArr2, jArr3, jArr4, dArr2, dArr3, dArr4);
                } else {
                    com.iqoption.gl.b.aow().glchTabSetClosedBets(size, iArr, jArr, iArr2, iArr3, dArr, jArr2, jArr3, jArr4, dArr2, dArr3, dArr4);
                }
            }
        }
    }

    public static void j(Order order) {
        a(true, order);
    }

    public static void k(Order order) {
        a(false, order);
    }

    private static void a(boolean z, Order order) {
        if (order != null) {
            double d = -1.0d;
            if (z) {
                Graph aow = com.iqoption.gl.b.aow();
                String valueOf = String.valueOf(order.getId());
                int intValue = order.getInstrumentActiveId().intValue();
                String optionActiveOrInstrumentValue = order.getInstrumentType().getOptionActiveOrInstrumentValue();
                double doubleValue = order.getCountGL().doubleValue();
                double doubleValue2 = order.getAvgPriceGL().doubleValue();
                double doubleValue3 = order.getLimitPrice() == null ? -1.0d : order.getLimitPrice().doubleValue();
                if (order.getStopPrice() != null) {
                    d = order.getStopPrice().doubleValue();
                }
                double d2 = d;
                aow.glchAddOrder(valueOf, intValue, optionActiveOrInstrumentValue, doubleValue, doubleValue2, doubleValue3, d2, NotificationCompat.CATEGORY_CALL.equals(order.getInstrumentDir()), order.getCreateAt().longValue(), order.getInstrumentExpiration().longValue(), 0, order.createStrikeKey(), (double) order.getLeverageGL().intValue(), order.getStatus(), order.getExecuteStatus(), order.getType(), Position.createPositionSplitId(order.getInstrumentType(), order.getInstrumentActiveId(), order.getInstrumentExpiration(), order.getPositionId()));
            } else {
                Graph aow2 = com.iqoption.gl.b.aow();
                String valueOf2 = String.valueOf(order.getId());
                int intValue2 = order.getInstrumentActiveId().intValue();
                String optionActiveOrInstrumentValue2 = order.getInstrumentType().getOptionActiveOrInstrumentValue();
                double doubleValue4 = order.getCountGL().doubleValue();
                double doubleValue5 = order.getAvgPriceGL().doubleValue();
                double doubleValue6 = order.getLimitPrice() == null ? -1.0d : order.getLimitPrice().doubleValue();
                if (order.getStopPrice() != null) {
                    d = order.getStopPrice().doubleValue();
                }
                aow2.glchDeleteOrder(valueOf2, intValue2, optionActiveOrInstrumentValue2, doubleValue4, doubleValue5, doubleValue6, d, NotificationCompat.CATEGORY_CALL.equals(order.getInstrumentDir()), order.getCreateAt().longValue(), order.getInstrumentExpiration().longValue(), 0, order.createStrikeKey(), (double) order.getLeverageGL().intValue(), order.getStatus(), order.getExecuteStatus(), order.getType(), Position.createPositionSplitId(order.getInstrumentType(), order.getInstrumentActiveId(), order.getInstrumentExpiration(), order.getPositionId()));
            }
        }
    }

    public static void f(Position position) {
        a(0, position);
    }

    public static void g(Position position) {
        a(1, position);
    }

    public static void h(Position position) {
        a(2, position);
    }

    private static void a(int i, Position position) {
        if (position != null) {
            switch (i) {
                case 0:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("strikeId pos = ");
                    stringBuilder.append(position.createStrikeKey());
                    com.iqoption.core.i.d(stringBuilder.toString());
                    com.iqoption.gl.b.aow().glchAddPosition(position.getActiveId(), position.getPositionSplitId(), position.getInstrumentType().getOptionActiveOrInstrumentValue(), position.getCount().doubleValue(), position.getCountRealized().doubleValue(), position.getBuyAvgPrice().doubleValue(), position.getSellAvgPrice().doubleValue(), position.getBuyAvgPriceEnrolled().doubleValue(), position.getSellAvgPriceEnrolled().doubleValue(), position.getBidPrice(), position.getAskPrice(), position.isCallInt(), position.isCallInt(), position.getExpired().longValue(), position.getCreated().longValue(), position.getUpdated(), position.getClosed(), position.createStrikeKey(), position.getLeverage(), position.getStringTakeProfitOrderId(), position.getStringStopLoseOrderId(), position.getCloseReason(), position.getRate(), position.getSelfSwap(), position.getSelfMarginCall(), position.isAutoMarginCall(), position.getGLstopOutThreshold(), ((double) position.getInstrumentStrikeValue().longValue()) / 1000000.0d, position.isSpotStrike(), position.getExpirationPeriod());
                    break;
                case 1:
                    Graph aow = com.iqoption.gl.b.aow();
                    aow.glchDeletePosition(position.getActiveId(), position.getPositionSplitId(), position.getInstrumentType().getOptionActiveOrInstrumentValue(), position.getCount().doubleValue(), position.getCountRealized().doubleValue(), position.getBuyAvgPrice().doubleValue(), position.getSellAvgPrice().doubleValue(), position.getBuyAvgPriceEnrolled().doubleValue(), position.getSellAvgPriceEnrolled().doubleValue(), position.getBidPrice(), position.getAskPrice(), position.isCallInt(), position.isCallInt(), position.getExpired().longValue(), position.getCreated().longValue(), position.getUpdated(), position.getClosed(), position.createStrikeKey(), position.getLeverage(), position.getStringTakeProfitOrderId(), position.getStringStopLoseOrderId(), position.getCloseReason(), position.getRate(), position.getSelfMarginCall(), position.isAutoMarginCall(), position.getGLstopOutThreshold(), ((double) position.getInstrumentStrikeValue().longValue()) / 1000000.0d, position.isSpotStrike(), position.getExpirationPeriod());
                    break;
                case 2:
                    com.iqoption.gl.b.aow().glchUpdatePosition(position.getActiveId(), position.getPositionSplitId(), position.getInstrumentType().getOptionActiveOrInstrumentValue(), position.getCount().doubleValue(), position.getCountRealized().doubleValue(), position.getBuyAvgPrice().doubleValue(), position.getSellAvgPrice().doubleValue(), position.getBuyAvgPriceEnrolled().doubleValue(), position.getSellAvgPriceEnrolled().doubleValue(), position.getBidPrice(), position.getAskPrice(), position.isCallInt(), position.isCallInt(), position.getExpired().longValue(), position.getCreated().longValue(), position.getUpdated(), position.getClosed(), position.createStrikeKey(), position.getLeverage(), position.getStringTakeProfitOrderId(), position.getStringStopLoseOrderId(), position.getCloseReason(), position.getRate(), position.getSelfSwap(), position.getSelfMarginCall(), position.isAutoMarginCall(), position.getGLstopOutThreshold(), ((double) position.getInstrumentStrikeValue().longValue()) / 1000000.0d, position.isSpotStrike(), position.getExpirationPeriod());
                    break;
            }
        }
    }
}
