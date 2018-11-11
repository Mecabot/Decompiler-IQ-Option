package com.iqoption.analytics.sla;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.b.e;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.w;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.b.c;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.ApiCallEventBusEvent;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.configuration.f;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.system.a.d;
import com.iqoption.util.Network;
import com.jumio.nv.data.NVStrings;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Sla implements LifecycleObserver {
    private static final String TAG = "com.iqoption.analytics.sla.Sla";
    private static final n<Sla> ajp = Suppliers.a(e.ajD);
    private static com.google.common.cache.b<String, String> ajy = CacheBuilder.qh().a(2, TimeUnit.SECONDS).qw();
    private static com.google.common.cache.b<String, ApiCallEventBusEvent> ajz = CacheBuilder.qh().a(2, TimeUnit.SECONDS).a(f.ajE).qw();
    private final b ajq = new b();
    private Map<String, a> ajr = Maps.us();
    private Map<String, HashMultiset<Object>> ajs = Maps.us();
    private w<String> ajt = HashMultiset.sH();
    private volatile boolean aju;
    private volatile boolean ajv;
    private ScheduledFuture<?> ajw;
    private ScheduledFuture<?> ajx;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static final class a {
        private final com.iqoption.core.util.i.b ajF;
        private final Builder ajG;
        private long ajH;
        private long ajI;
        private boolean ajJ;
        private boolean ajK;
        private long ajL;
        private ArrayList<Pair<Long, Double>> ajM = new ArrayList();
        private String type;

        public static a ee(String str) {
            return new a(Event.CATEGORY_SYSTEM, Event.MICROSERVICE_EVENT, str);
        }

        private a(String str, String str2, String str3) {
            this.ajG = Event.Builder(str, str2);
            this.ajG.setTechnicalLogs(Boolean.valueOf(true));
            this.type = str3;
            this.ajF = com.iqoption.core.util.i.b.aaa();
            this.ajF.l("feature", ef(str3));
            this.ajF.l(Param.TYPE, str3);
            this.ajF.l("endpoint", Cv());
            this.ajF.l(NVStrings.FRONT, WebSocketHandler.aDm().aDz());
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0029  */
        @android.support.annotation.Nullable
        private java.lang.String ef(java.lang.String r3) {
            /*
            r2 = this;
            r0 = r3.hashCode();
            r1 = -315056186; // 0xffffffffed389fc6 float:-3.5711498E27 double:NaN;
            if (r0 == r1) goto L_0x0019;
        L_0x0009:
            r1 = 599063490; // 0x23b4fbc2 float:1.9622263E-17 double:2.9597669E-315;
            if (r0 == r1) goto L_0x000f;
        L_0x000e:
            goto L_0x0023;
        L_0x000f:
            r0 = "quotes-digital";
            r3 = r3.equals(r0);
            if (r3 == 0) goto L_0x0023;
        L_0x0017:
            r3 = 1;
            goto L_0x0024;
        L_0x0019:
            r0 = "pricing";
            r3 = r3.equals(r0);
            if (r3 == 0) goto L_0x0023;
        L_0x0021:
            r3 = 0;
            goto L_0x0024;
        L_0x0023:
            r3 = -1;
        L_0x0024:
            switch(r3) {
                case 0: goto L_0x002c;
                case 1: goto L_0x0029;
                default: goto L_0x0027;
            };
        L_0x0027:
            r3 = 0;
            return r3;
        L_0x0029:
            r3 = "option-quote";
            return r3;
        L_0x002c:
            r3 = "spot-buyback-quote-generated";
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.analytics.sla.Sla.a.ef(java.lang.String):java.lang.String");
        }

        public a V(long j) {
            if (this.ajH != j) {
                long j2 = this.ajL;
                this.ajL = SystemClock.elapsedRealtime();
                if (this.ajI != 0) {
                    long j3 = this.ajL - j2;
                    this.ajM.add(Pair.create(Long.valueOf(j3), Double.valueOf(W(j3))));
                    this.ajI = 0;
                }
                this.ajH = j;
            }
            return this;
        }

        public a aE(boolean z) {
            this.ajK = z;
            return this;
        }

        public a aF(boolean z) {
            this.ajJ = z;
            return this;
        }

        private void Ct() {
            this.ajI++;
        }

        private double W(long j) {
            if (this.ajI == 0 || this.ajH == 0) {
                return 0.0d;
            }
            if (j < 10000) {
                return 100.0d;
            }
            return Math.min((double) (Math.round((((double) this.ajH) / (((double) j) / ((double) this.ajI))) * 10000.0d) / 100), 100.0d);
        }

        private double Cu() {
            double d = 100.0d;
            double d2 = 0.0d;
            if (this.ajJ) {
                if (!this.ajK) {
                    d = 0.0d;
                }
                return d;
            } else if (this.ajH == 0) {
                return 0.0d;
            } else {
                if (this.ajI == 0 && this.ajM.isEmpty()) {
                    return 0.0d;
                }
                if (this.ajM.isEmpty()) {
                    return W(this.ajG.currentDuration());
                }
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.ajL;
                this.ajM.add(Pair.create(Long.valueOf(elapsedRealtime), Double.valueOf(W(elapsedRealtime))));
                long currentDuration = this.ajG.currentDuration();
                Iterator it = this.ajM.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    d2 += ((Double) pair.second).doubleValue() * (((double) ((Long) pair.first).longValue()) / ((double) currentDuration));
                }
                return Math.min((double) (Math.round(d2 * 100.0d) / 100), 100.0d);
            }
        }

        private String Cv() {
            f Dl = IQApp.Dl();
            if (!Dl.isInitialized()) {
                return "";
            }
            try {
                return new URL(Dl.getClusterApi()).getHost();
            } catch (Exception unused) {
                return Dl.getClusterApi();
            }
        }

        public void send() {
            if (this.ajJ || this.ajH != 0) {
                this.ajF.l("percent", Double.valueOf(Cu()));
                this.ajG.setParameters(this.ajF.aab());
                EventManager.Bm().a(this.ajG.build());
            }
        }
    }

    private class b extends d {
        private b() {
        }

        @e
        public void onNetworkStateEvent(c cVar) {
            Sla.this.executor.execute(new g(this, cVar));
        }

        @e
        public void onAppForegroundEvent(com.iqoption.app.b.a aVar) {
            Sla.this.executor.execute(new h(this, aVar));
        }

        @e
        public void onInitializationCompletedEvent(com.iqoption.app.managers.tab.a.d dVar) {
            Sla.this.executor.execute(new i(this, dVar));
        }

        @e
        public void onApiCallEvent(ApiCallEventBusEvent apiCallEventBusEvent) {
            if (!apiCallEventBusEvent.apiName.contains("api/appsflyer/link") && !apiCallEventBusEvent.apiName.contains("appsflyer-initialization")) {
                ApiCallEventBusEvent apiCallEventBusEvent2 = (ApiCallEventBusEvent) Sla.ajz.I(apiCallEventBusEvent.apiName);
                if (apiCallEventBusEvent.apiCallEvent.duration == null && apiCallEventBusEvent.t == null) {
                    if (!Sla.this.ajv && apiCallEventBusEvent2 == null) {
                        Sla.ajz.put(apiCallEventBusEvent.apiName, apiCallEventBusEvent);
                    }
                    return;
                }
                if (apiCallEventBusEvent.apiCallEvent.duration != null && apiCallEventBusEvent.t == null && Sla.this.ajv) {
                    Sla.this.ajv = false;
                    Sla sla = Sla.this;
                    boolean z = IQApp.Dk().Do() && IQApp.Dk().isStarted();
                    sla.aD(z);
                }
                if (apiCallEventBusEvent2 != null) {
                    apiCallEventBusEvent2.isRemoved = true;
                    Sla.ajz.J(apiCallEventBusEvent.apiName);
                }
                if (Sla.ajy.I(apiCallEventBusEvent.apiName) == null) {
                    if (apiCallEventBusEvent.t instanceof IOException) {
                        Sla.this.ajv = true;
                        Sla.this.aD(false);
                        for (ApiCallEventBusEvent apiCallEventBusEvent22 : Sla.ajz.qg().values()) {
                            apiCallEventBusEvent22.isRemoved = true;
                        }
                        Sla.ajz.invalidateAll();
                    } else if (apiCallEventBusEvent.t == null) {
                        a.ee(apiCallEventBusEvent.apiName).aF(true).aE(true).send();
                        Sla.ajy.put(apiCallEventBusEvent.apiName, apiCallEventBusEvent.apiName);
                    }
                }
            }
        }
    }

    @OnLifecycleEvent(R = Lifecycle.Event.ON_START)
    public void onCreate() {
        Ci().initialize();
    }

    @OnLifecycleEvent(R = Lifecycle.Event.ON_STOP)
    public void onDestroy() {
        Ci().Cj();
    }

    public static Sla Ci() {
        return (Sla) ajp.get();
    }

    private Sla() {
    }

    private void initialize() {
        this.ajq.register();
        boolean z = Network.dwp.aGr() && IQApp.Dk().isStarted();
        aD(z);
    }

    private void Cj() {
        this.ajq.unregister();
        aD(false);
    }

    private void f(String str, Object obj) {
        if (this.aju) {
            this.ajt.add(str);
            HashMultiset hashMultiset = (HashMultiset) this.ajs.get(str);
            if (hashMultiset == null) {
                hashMultiset = HashMultiset.sH();
                hashMultiset.add(obj);
                this.ajs.put(str, hashMultiset);
            } else {
                hashMultiset.add(obj);
            }
            a aVar = (a) this.ajr.get(str);
            if (aVar == null) {
                ec(str);
            } else {
                aVar.V((long) (1000 / hashMultiset.se().size()));
            }
        }
    }

    public synchronized void a(String str, boolean z, Object obj) {
        if (this.aju) {
            this.executor.execute(new a(this, str, z, obj));
        }
    }

    final /* synthetic */ void b(String str, boolean z, Object obj) {
        if (z) {
            f(str, obj);
        } else {
            g(str, obj);
        }
    }

    public synchronized void ea(String str) {
        if (this.aju) {
            this.executor.execute(new b(this, str));
        }
    }

    @WorkerThread
    private void eb(String str) {
        a aVar = (a) this.ajr.get(str);
        if (aVar != null) {
            aVar.Ct();
        }
    }

    private void g(String str, Object obj) {
        HashMultiset hashMultiset = (HashMultiset) this.ajs.get(str);
        if (hashMultiset != null) {
            hashMultiset.remove(obj);
            if (!hashMultiset.contains(obj)) {
                this.ajs.remove(str);
            }
        }
        if (this.ajt.e(str, 1) <= 1) {
            this.ajr.remove(str);
            this.ajs.remove(str);
            return;
        }
        a aVar = (a) this.ajr.get(str);
        if (aVar != null && hashMultiset != null && !hashMultiset.isEmpty()) {
            aVar.V((long) (1000 / hashMultiset.se().size()));
        }
    }

    private void ec(String str) {
        a ee = a.ee(str);
        ee.V((long) (1000 / ((HashMultiset) this.ajs.get(str)).se().size()));
        this.ajr.put(str, ee);
    }

    private void aD(boolean z) {
        if (!com.iqoption.app.managers.feature.b.HT().ff("sla")) {
            z = false;
        }
        if (z != this.aju) {
            synchronized (this) {
                if (z) {
                    this.aju = true;
                    this.ajw = this.executor.scheduleWithFixedDelay(new c(this), 1, 1, TimeUnit.MINUTES);
                } else {
                    this.aju = false;
                    this.ajr.clear();
                    this.ajt.clear();
                    this.ajs.clear();
                    if (this.ajw != null) {
                        this.ajw.cancel(false);
                    }
                }
            }
        }
    }

    @WorkerThread
    private void Ck() {
        if (this.aju) {
            ImmutableList m;
            synchronized (this) {
                m = ImmutableList.m(this.ajr.values());
            }
            if (!m.isEmpty()) {
                Iterator sI = m.iterator();
                while (sI.hasNext()) {
                    ((a) sI.next()).send();
                }
                synchronized (this) {
                    Iterator sI2 = m.iterator();
                    while (sI2.hasNext()) {
                        ec(((a) sI2.next()).type);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:18:0x003f, code:
            return;
     */
    public synchronized void Cl() {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.aju;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r10);
        return;
    L_0x0007:
        r0 = com.iqoption.app.managers.tab.a.Il();	 Catch:{ all -> 0x0040 }
        r1 = r0.IE();	 Catch:{ all -> 0x0040 }
        r0 = r0.FW();	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x001f;
    L_0x0015:
        r0 = com.iqoption.app.managers.tab.a.aoY;	 Catch:{ all -> 0x0040 }
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x001f;
    L_0x001d:
        monitor-exit(r10);
        return;
    L_0x001f:
        r0 = r10.ajx;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x003e;
    L_0x0023:
        r0 = "history-quotes";
        r1 = 1;
        r2 = "";
        r10.a(r0, r1, r2);	 Catch:{ all -> 0x0040 }
        r3 = r10.executor;	 Catch:{ all -> 0x0040 }
        r4 = new com.iqoption.analytics.sla.d;	 Catch:{ all -> 0x0040 }
        r4.<init>(r10);	 Catch:{ all -> 0x0040 }
        r5 = 1;
        r7 = 1;
        r9 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x0040 }
        r0 = r3.scheduleWithFixedDelay(r4, r5, r7, r9);	 Catch:{ all -> 0x0040 }
        r10.ajx = r0;	 Catch:{ all -> 0x0040 }
    L_0x003e:
        monitor-exit(r10);
        return;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.analytics.sla.Sla.Cl():void");
    }

    public synchronized void Cm() {
        a("history-quotes", false, "");
        if (this.ajx != null) {
            this.ajx.cancel(true);
        }
    }

    @WorkerThread
    private void Cn() {
        String IE = com.iqoption.app.managers.tab.a.Il().IE();
        if (!com.iqoption.app.managers.tab.a.aoY.equals(IE) && com.iqoption.gl.b.aow().glchTabHasVisibleChartWithoutHoles(IE)) {
            eb("history-quotes");
        }
    }
}
