package com.iqoption.app.managers.tab;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.gson.annotations.SerializedName;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.app.managers.a.k;
import com.iqoption.app.managers.y;
import com.iqoption.charttools.j;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.gl.Graph;
import com.iqoption.core.util.l;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.Event;
import com.iqoption.dto.entity.ActiveQuote;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.fragment.cr;
import com.iqoption.gl.NativeHandler;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import com.iqoption.util.bf;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: TabHelper */
public class a implements com.iqoption.view.a.b.a {
    private static final String TAG = "com.iqoption.app.managers.tab.a";
    public static int aoX = -1;
    public static String aoY = String.valueOf(aoX);
    private static final n<a> aoZ = Suppliers.a(d.ajD);
    private com.iqoption.h.a.a aiI;
    private final b apa = new b();
    private final SparseArray<g> apb = new SparseArray();
    private volatile int apc = aoX;
    private volatile boolean apd = false;
    private WeakReference<cr> ape = new WeakReference(null);
    private final j apf = new j(com.iqoption.gl.b.aow());
    private Map<Integer, c> apg = new ConcurrentHashMap();
    private Map<Integer, f> aph = new ConcurrentHashMap();
    private Map<Integer, e> api = new ConcurrentHashMap();

    /* compiled from: TabHelper */
    public static class d {
    }

    /* compiled from: TabHelper */
    public static class g {
        @SerializedName("activeId")
        private volatile int activeId;
        @SerializedName("activeExpiration")
        private volatile long apo;
        @SerializedName("digitalExpirationPeriod")
        private volatile long app;
        @SerializedName("setting")
        private volatile h apq;
        private volatile transient Strike apr;
        @SerializedName("spotSwitcherState")
        private volatile boolean aps;
        private volatile transient boolean apt;
        private volatile transient boolean apu;
        private volatile transient boolean apv;
        public transient com.iqoption.app.managers.feature.g apw;
        private volatile Expiration apx;
        @SerializedName("id")
        private volatile int id;
        @SerializedName("instrumentType")
        private volatile InstrumentType instrumentType;
        private volatile transient double rate;

        public g() {
            this.activeId = 0;
            this.instrumentType = InstrumentType.TURBO_INSTRUMENT;
            this.apo = 0;
            this.app = 0;
            this.apq = new h();
            this.apt = true;
            init();
        }

        private g(InstrumentType instrumentType) {
            this.activeId = 0;
            this.instrumentType = InstrumentType.TURBO_INSTRUMENT;
            this.apo = 0;
            this.app = 0;
            this.apq = new h();
            this.apt = true;
            this.instrumentType = instrumentType;
            init();
        }

        public g(int i, InstrumentType instrumentType) {
            this(instrumentType);
            this.id = View.generateViewId();
            this.activeId = i;
            this.apq = new h(instrumentType);
            a(Expiration.notInitilizedExpiration, i, instrumentType);
        }

        public g(int i, InstrumentType instrumentType, Expiration expiration) {
            this(instrumentType);
            this.id = View.generateViewId();
            this.activeId = i;
            this.instrumentType = instrumentType;
            this.apq = new h(instrumentType);
            a(expiration, i, instrumentType);
        }

        private void init() {
            com.iqoption.app.managers.feature.g gVar = this.instrumentType == InstrumentType.DIGITAL_INSTRUMENT ? new com.iqoption.app.managers.feature.g("do-spot-switcher-instrument", new g(this)) : this.instrumentType == InstrumentType.FX_INSTRUMENT ? new com.iqoption.app.managers.feature.g("fx-spot-switcher-instrument", new h(this)) : com.iqoption.app.managers.feature.g.aoF.Ih();
            this.apw = gVar;
            IV();
        }

        final /* synthetic */ Boolean Ja() {
            return Boolean.valueOf(this.aps ^ 1);
        }

        final /* synthetic */ Boolean IZ() {
            return Boolean.valueOf(this.aps ^ 1);
        }

        public void b(int i, InstrumentType instrumentType, Expiration expiration) {
            InstrumentType instrumentType2 = this.instrumentType;
            Object obj = this.instrumentType != instrumentType ? 1 : null;
            this.apr = null;
            this.instrumentType = instrumentType;
            this.activeId = i;
            IV();
            if (obj != null) {
                init();
            }
            this.apq.a(this.instrumentType, instrumentType2);
            a(expiration, i, instrumentType);
        }

        private void a(Expiration expiration, int i, InstrumentType instrumentType) {
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(i), instrumentType);
            Object obj = (a == null || !a.isExpired()) ? null : 1;
            if (obj != null) {
                this.app = expiration.getDigitalExpirationPeriod();
                this.apo = expiration.expValue.longValue();
                return;
            }
            this.apo = -1;
            this.app = 0;
        }

        private boolean f(Expiration expiration) {
            return com.google.common.base.f.equal(Long.valueOf(this.apo), expiration.expValue) && com.google.common.base.f.equal(Long.valueOf(this.app), Long.valueOf(expiration.getDigitalExpirationPeriod()));
        }

        public com.iqoption.mobbtech.connect.response.options.i getOptionKey() {
            return new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(IP()), Integer.valueOf(this.activeId), this.instrumentType);
        }

        public String IM() {
            return String.valueOf(this.id);
        }

        private void IN() {
            this.id = View.generateViewId();
        }

        public int getId() {
            return this.id;
        }

        public synchronized int getActiveId() {
            return this.activeId;
        }

        public synchronized InstrumentType getInstrumentType() {
            return this.instrumentType;
        }

        public synchronized Expiration IO() {
            if (this.apx == null) {
                this.apx = Expiration.createTempObj(this.apo, this.app * 1000);
            } else {
                this.apx.expValue = Long.valueOf(this.apo);
                this.apx.expInterval = Long.valueOf(this.app * 1000);
            }
            return this.apx;
        }

        public synchronized long getExpiration() {
            return this.apo;
        }

        public synchronized long IP() {
            return this.apo > 0 ? this.apo / 1000 : this.apo;
        }

        public synchronized long q(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            long j;
            long c = k.HB().c(aVar, IO());
            j = 0;
            if (this.apo > 0) {
                j = (this.apo - c) / 1000;
            }
            return j;
        }

        private synchronized void g(Expiration expiration) {
            this.apo = expiration.expValue.longValue();
            this.app = expiration.getDigitalExpirationPeriod();
            IV();
            c(null);
        }

        public synchronized long IQ() {
            return this.app;
        }

        public synchronized Strike IR() {
            return this.apr;
        }

        /* JADX WARNING: Missing block: B:17:0x0096, code:
            return;
     */
        public synchronized void c(com.iqoption.dto.entity.strike.Strike r6) {
            /*
            r5 = this;
            monitor-enter(r5);
            r0 = com.iqoption.app.managers.tab.a.TAG;	 Catch:{ all -> 0x0097 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
            r1.<init>();	 Catch:{ all -> 0x0097 }
            r2 = "SPOTP set strike ";
            r1.append(r2);	 Catch:{ all -> 0x0097 }
            r1.append(r6);	 Catch:{ all -> 0x0097 }
            r1 = r1.toString();	 Catch:{ all -> 0x0097 }
            com.iqoption.core.i.d(r0, r1);	 Catch:{ all -> 0x0097 }
            r0 = r5.apr;	 Catch:{ all -> 0x0097 }
            if (r0 != 0) goto L_0x0021;
        L_0x001d:
            if (r6 != 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r5);
            return;
        L_0x0021:
            r0 = com.iqoption.app.IQApp.Dk();	 Catch:{ all -> 0x0097 }
            r0 = com.iqoption.app.a.aL(r0);	 Catch:{ all -> 0x0097 }
            r0 = r0.getGroupId();	 Catch:{ all -> 0x0097 }
            r1 = r5.apr;	 Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0044;
        L_0x0031:
            r2 = r1.call;	 Catch:{ all -> 0x0097 }
            r2 = r2.id;	 Catch:{ all -> 0x0097 }
            r3 = r1.optionType;	 Catch:{ all -> 0x0097 }
            r4 = 0;
            com.iqoption.app.managers.y.a(r4, r2, r3, r0);	 Catch:{ all -> 0x0097 }
            r2 = r1.put;	 Catch:{ all -> 0x0097 }
            r2 = r2.id;	 Catch:{ all -> 0x0097 }
            r3 = r1.optionType;	 Catch:{ all -> 0x0097 }
            com.iqoption.app.managers.y.a(r4, r2, r3, r0);	 Catch:{ all -> 0x0097 }
        L_0x0044:
            if (r6 == 0) goto L_0x0079;
        L_0x0046:
            r2 = r6.call;	 Catch:{ all -> 0x0097 }
            r2 = r2.id;	 Catch:{ all -> 0x0097 }
            r3 = r6.optionType;	 Catch:{ all -> 0x0097 }
            r4 = 1;
            com.iqoption.app.managers.y.a(r4, r2, r3, r0);	 Catch:{ all -> 0x0097 }
            r2 = r6.put;	 Catch:{ all -> 0x0097 }
            r2 = r2.id;	 Catch:{ all -> 0x0097 }
            r3 = r6.optionType;	 Catch:{ all -> 0x0097 }
            com.iqoption.app.managers.y.a(r4, r2, r3, r0);	 Catch:{ all -> 0x0097 }
            r0 = r6.optionType;	 Catch:{ all -> 0x0097 }
            r2 = r6.call;	 Catch:{ all -> 0x0097 }
            r2 = r2.id;	 Catch:{ all -> 0x0097 }
            r3 = r6.put;	 Catch:{ all -> 0x0097 }
            r3 = r3.id;	 Catch:{ all -> 0x0097 }
            r2 = com.google.common.collect.ImmutableList.o(r2, r3);	 Catch:{ all -> 0x0097 }
            com.iqoption.mobbtech.connect.request.api.f.a(r0, r2);	 Catch:{ all -> 0x0097 }
            r0 = com.iqoption.gl.b.aow();	 Catch:{ all -> 0x0097 }
            r2 = r5.IM();	 Catch:{ all -> 0x0097 }
            r3 = r6.getStrikeKey();	 Catch:{ all -> 0x0097 }
            r0.glchTabSelectStrike(r2, r3);	 Catch:{ all -> 0x0097 }
        L_0x0079:
            r5.apr = r6;	 Catch:{ all -> 0x0097 }
            r6 = com.google.common.base.f.equal(r1, r6);	 Catch:{ all -> 0x0097 }
            if (r6 != 0) goto L_0x0095;
        L_0x0081:
            r6 = com.iqoption.app.IQApp.Dn();	 Catch:{ all -> 0x0097 }
            r0 = new com.iqoption.app.managers.a.k$b;	 Catch:{ all -> 0x0097 }
            r1 = r5.id;	 Catch:{ all -> 0x0097 }
            r0.<init>(r1);	 Catch:{ all -> 0x0097 }
            r1 = r5.apr;	 Catch:{ all -> 0x0097 }
            r0 = r0.setValue(r1);	 Catch:{ all -> 0x0097 }
            r6.aE(r0);	 Catch:{ all -> 0x0097 }
        L_0x0095:
            monitor-exit(r5);
            return;
        L_0x0097:
            r6 = move-exception;
            monitor-exit(r5);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.tab.a.g.c(com.iqoption.dto.entity.strike.Strike):void");
        }

        public synchronized void IS() {
            ActiveQuote da = com.iqoption.app.managers.c.Gn().da(this.activeId);
            if (da != null) {
                int multiplier = getMultiplier();
                InstrumentType instrumentType = getInstrumentType();
                com.iqoption.gl.b.aow().glchSetBidAsk(IM(), da.getBid(instrumentType, multiplier), da.getAsk(instrumentType, multiplier));
            }
        }

        public synchronized void IT() {
            this.apt = false;
        }

        public synchronized void IU() {
            this.apu = false;
        }

        public final synchronized void IV() {
            this.apt = true;
            this.apu = this.apw.If();
        }

        public synchronized boolean by(boolean z) {
            if (this.apw.If()) {
                this.apt = z;
                return bA(z);
            }
            if (this.apt != z) {
                this.apt = z;
                String II = a.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("glchTabSetStrikesDisplayMode ");
                stringBuilder.append(z ? "0" : "1");
                com.iqoption.core.i.v(II, stringBuilder.toString());
                com.iqoption.gl.b.aow().glchTabSetStrikesDisplayMode(IM(), z ^ 1);
            }
            return this.apt;
        }

        public synchronized void bz(boolean z) {
            if (this.aps == z) {
                this.aps = z ^ 1;
                if (this.apu != z) {
                    this.apu = z;
                    String II = a.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("glchTabSetStrikesDisplayMode ");
                    stringBuilder.append(z ? "0" : "1");
                    com.iqoption.core.i.v(II, stringBuilder.toString());
                    com.iqoption.gl.b.aow().glchTabSetStrikesDisplayMode(IM(), z ^ 1);
                    c(null);
                }
                this.apv = true;
            }
        }

        public synchronized boolean IW() {
            return this.apt;
        }

        private synchronized boolean bA(boolean z) {
            if (this.apu == z) {
                return this.apu;
            }
            this.apu = z;
            String II = a.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("glchTabSetStrikesDisplayMode ");
            stringBuilder.append(z ? "0" : "1");
            com.iqoption.core.i.v(II, stringBuilder.toString());
            com.iqoption.gl.b.aow().glchTabSetStrikesDisplayMode(IM(), z ^ 1);
            IQApp.Dn().aE(new a().setValue(Boolean.valueOf(z)));
            if (!z) {
                c(null);
            }
            return this.apu;
        }

        private synchronized boolean isSpotStrike() {
            return this.apu;
        }

        public h IX() {
            return this.apq;
        }

        public void IY() {
            String IM = IM();
            Graph aow = com.iqoption.gl.b.aow();
            aow.glchSetTimeScaleBarType(IM, this.apq.apz);
            aow.glchTabSetTimes(IM, this.apq.chartType, this.apq.candleSize);
            if (this.apq.apA) {
                aow.glchTabSetMonochromeColor(IM);
            } else {
                aow.glchTabSetVariegatedColor(IM);
            }
            aow.glchTabSetHeikinashi(IM, this.apq.apB);
            aow.glchTabSetAutoScale(IM, this.apq.apC);
        }

        public void W(int i, int i2) {
            this.apq.chartType = i;
            this.apq.candleSize = i2;
            this.apv = true;
        }

        public void X(int i, int i2) {
            this.apq.chartType = i;
            this.apq.candleSize = i2;
            this.apv = true;
            com.iqoption.gl.b.aow().glchTabSetTimes(IM(), this.apq.chartType, this.apq.candleSize);
        }

        public void setChartType(int i) {
            this.apq.chartType = i;
            this.apv = true;
            com.iqoption.gl.b.aow().glchTabSetTimes(IM(), this.apq.chartType, this.apq.candleSize);
        }

        public void di(int i) {
            this.apq.candleSize = i;
            this.apv = true;
            com.iqoption.gl.b.aow().glchTabSetTimes(IM(), this.apq.chartType, this.apq.candleSize);
        }

        public void bB(boolean z) {
            this.apq.apA = z;
            this.apv = true;
            if (this.apq.apA) {
                com.iqoption.gl.b.aow().glchTabSetMonochromeColor(IM());
            } else {
                com.iqoption.gl.b.aow().glchTabSetVariegatedColor(IM());
            }
        }

        public void bC(boolean z) {
            this.apq.apB = z;
            this.apv = true;
            com.iqoption.gl.b.aow().glchTabSetHeikinashi(IM(), z);
        }

        public void bD(boolean z) {
            this.apq.apC = z;
            this.apv = true;
            com.iqoption.gl.b.aow().glchTabSetAutoScale(IM(), z);
        }

        public void a(String str, @Nullable Number number) {
            if (number != null) {
                if (this.apq.apD == null) {
                    this.apq.apD = new ArrayMap();
                }
                this.apq.apD.put(str, number);
            } else if (this.apq.apD != null) {
                this.apq.apD.remove(str);
            }
        }

        @Nullable
        public Number fj(String str) {
            return this.apq.apD != null ? (Number) this.apq.apD.get(str) : null;
        }

        public boolean isUpdate() {
            boolean z = this.apv;
            this.apv = false;
            return z;
        }

        private int getMultiplier() {
            Number number = this.apq.apD != null ? (Number) this.apq.apD.get("tabSetting.multiplier") : null;
            return number != null ? number.intValue() : 1;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Tab{id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", activeId=");
            stringBuilder.append(this.activeId);
            stringBuilder.append(", instrumentType='");
            stringBuilder.append(this.instrumentType);
            stringBuilder.append('\'');
            stringBuilder.append(", activeExpiration=");
            stringBuilder.append(this.apo);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: TabHelper */
    public static class h {
        @SerializedName("isMonochromeCandle")
        public boolean apA = false;
        @SerializedName("isHeikenAshi")
        public boolean apB = false;
        @SerializedName("isAutoScaling")
        public boolean apC = true;
        @SerializedName("numbers")
        Map<String, Number> apD;
        @SerializedName("timeScleBarType")
        public int apz = 1;
        @SerializedName("candleSize")
        public int candleSize = 1;
        @SerializedName("chartType")
        public int chartType = 0;

        public h(InstrumentType instrumentType) {
            r(instrumentType);
            q(instrumentType);
        }

        public void a(InstrumentType instrumentType, InstrumentType instrumentType2) {
            if (instrumentType != instrumentType2) {
                r(instrumentType);
                q(instrumentType);
            }
        }

        private void q(InstrumentType instrumentType) {
            switch (instrumentType) {
                case CFD_INSTRUMENT:
                case FOREX_INSTRUMENT:
                    this.candleSize = 5;
                    return;
                case CRYPTO_INSTRUMENT:
                    this.candleSize = ChartTimeInterval.CANDLE_1D;
                    return;
                case FX_INSTRUMENT:
                case DIGITAL_INSTRUMENT:
                case BINARY_INSTRUMENT:
                    this.candleSize = 5;
                    return;
                default:
                    this.candleSize = 1;
                    return;
            }
        }

        private void r(InstrumentType instrumentType) {
            if (instrumentType != null) {
                if (com.iqoption.core.ext.c.b((Object) instrumentType, InstrumentType.CFD_INSTRUMENT, InstrumentType.FOREX_INSTRUMENT, InstrumentType.CRYPTO_INSTRUMENT)) {
                    this.apz = 2;
                    return;
                }
            }
            this.apz = 1;
        }
    }

    /* compiled from: TabHelper */
    public static class i {
    }

    /* compiled from: TabHelper */
    private class c implements com.google.common.util.concurrent.n<Expiration> {
        private final com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
        private final int apn;

        public c(int i, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
            this.apn = i;
            this.aiJ = aVar;
        }

        /* renamed from: e */
        public void onSuccess(Expiration expiration) {
            g de = a.this.de(this.apn);
            if (de != null) {
                if (!(!com.iqoption.app.managers.c.Gn().b(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(de.IP()), Integer.valueOf(de.activeId), de.instrumentType)) || expiration.expValue.longValue() == de.apo || k.HB().b(this.aiJ, de.IO()))) {
                    de.g(expiration);
                    a.this.c(de.activeId, de.rate);
                }
                a.this.b(de);
            }
            a.this.apg.remove(Integer.valueOf(this.apn));
        }

        public void l(Throwable th) {
            a.this.apg.remove(Integer.valueOf(this.apn));
        }
    }

    /* compiled from: TabHelper */
    private class e implements com.google.common.util.concurrent.n<ConcurrentHashMap<String, Strike>> {
        private final int apn;
        private volatile double rate;

        public e(int i, double d) {
            this.apn = i;
            this.rate = d;
        }

        public void setRate(double d) {
            this.rate = d;
        }

        /* renamed from: c */
        public void onSuccess(ConcurrentHashMap<String, Strike> concurrentHashMap) {
            g de = a.this.de(this.apn);
            if (!(de == null || l.x(concurrentHashMap) || !de.isSpotStrike())) {
                a.this.a((ConcurrentHashMap) concurrentHashMap, de, true, this.rate);
            }
            a.this.api.remove(Integer.valueOf(this.apn));
        }

        public void l(Throwable th) {
            a.this.api.remove(Integer.valueOf(this.apn));
        }
    }

    /* compiled from: TabHelper */
    private class f implements com.google.common.util.concurrent.n<ConcurrentHashMap<String, Strike>> {
        private final int apn;
        private volatile double rate;

        public f(int i, double d) {
            this.apn = i;
            this.rate = d;
        }

        public void setRate(double d) {
            this.rate = d;
        }

        /* renamed from: c */
        public void onSuccess(ConcurrentHashMap<String, Strike> concurrentHashMap) {
            g de = a.this.de(this.apn);
            if (!(de == null || l.x(concurrentHashMap))) {
                a.this.a((ConcurrentHashMap) concurrentHashMap, de, this.rate, true);
            }
            a.this.aph.remove(Integer.valueOf(this.apn));
        }

        public void l(Throwable th) {
            a.this.aph.remove(Integer.valueOf(this.apn));
        }
    }

    /* compiled from: TabHelper */
    public static class a extends com.iqoption.system.a.c<Boolean> {
    }

    /* compiled from: TabHelper */
    public class b extends com.iqoption.system.a.d {
        @com.google.common.b.e
        public void onSelectStrikeFromGLEvent(NativeHandler.n nVar) {
            com.iqoption.core.d.a.aSc.execute(new e(this, nVar.id, nVar));
        }

        final /* synthetic */ void a(String str, NativeHandler.n nVar) {
            g IC = a.this.IC();
            if (IC != null) {
                int activeId = IC.getActiveId();
                InstrumentType instrumentType = IC.getInstrumentType();
                long expiration = IC.getExpiration();
                long IQ = IC.IQ();
                com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(activeId), instrumentType);
                com.iqoption.app.managers.a.e n = k.HB().n(instrumentType);
                if (a != null && n != null) {
                    Strike a2 = n.a(instrumentType, a.Xf(), Long.valueOf(expiration), str, Long.valueOf(IQ), nVar.isSpot);
                    if (a2 != null) {
                        if (!a2.isSpot) {
                            IC.IT();
                            IC.IU();
                        }
                        a.this.a(IC, a2);
                        EventManager.Bm().a(Event.Builder(Event.CATEGORY_BUTTON_PRESSED, "traderoom_choose-strike-right-panel").setParameters(com.iqoption.core.util.i.ZZ().l("strike_value", String.valueOf(a2.getValue())).l("instrument_type", a2.optionType).aab()).build());
                        if (af.eM("show_toast_first_disable_auto_select_strike")) {
                            cr.a((int) R.drawable.local_toast_type_indicator_grey, IQApp.Dk().getString(R.string.auto_selection_is_off_until_the_end_of_expiration), 10000);
                            af.i("show_toast_first_disable_auto_select_strike", false);
                        }
                    }
                }
            }
        }

        public void IK() {
            com.iqoption.core.d.a.aSc.execute(new f(this));
        }

        final /* synthetic */ void IL() {
            if (a.this.IH()) {
                IQApp.Dn().aE(new d());
            }
        }
    }

    private a() {
    }

    public static a Il() {
        return (a) aoZ.get();
    }

    @Nullable
    public g fh(String str) {
        Integer cM = Ints.cM(str);
        if (cM != null) {
            g gVar = (g) this.apb.get(cM.intValue());
            if (gVar != null && gVar.IM().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public boolean a(g gVar) {
        return this.apc == gVar.id;
    }

    public boolean FW() {
        return this.apd;
    }

    public void a(cr crVar) {
        this.apa.register();
        this.ape = new WeakReference(crVar);
        com.iqoption.view.a.b.aIK().a((com.iqoption.view.a.b.a) this);
    }

    public b Im() {
        return this.apa;
    }

    public void onStop() {
        this.apd = false;
        this.apa.unregister();
        this.aph.clear();
        this.api.clear();
        this.apg.clear();
        this.ape.clear();
        this.apf.dispose();
        Io();
        com.iqoption.view.a.b.aIK().b((com.iqoption.view.a.b.a) this);
        com.iqoption.f.a.aqE();
    }

    public void In() {
        g IC = IC();
        Object obj = (IC == null || IC.isUpdate()) ? 1 : null;
        if (obj != null) {
            Ip();
        }
    }

    private void Io() {
        ax(0);
    }

    private void Ip() {
        ax(700);
    }

    @SuppressLint({"ApplySharedPref"})
    private void ax(long j) {
        com.iqoption.core.d.a.aSc.a(new b(com.iqoption.util.d.b(this.apb)), j, TimeUnit.MILLISECONDS);
    }

    static final /* synthetic */ void F(List list) {
        try {
            IQApp.Dk().getSharedPreferences("tab_pref_name", 0).edit().putString("tab_manager", ah.aGg().toJson((Object) list)).commit();
        } catch (Throwable e) {
            com.iqoption.core.i.e(TAG, e);
        }
    }

    private List<g> Iq() {
        List<g> arrayList = new ArrayList();
        try {
            String Fh = af.DX().Fh();
            if (TextUtils.isEmpty(Fh)) {
                Fh = IQApp.Dk().getSharedPreferences("tab_pref_name", 0).getString("tab_manager", null);
            } else {
                af.DX().Fg();
            }
            if (!TextUtils.isEmpty(Fh)) {
                List<g> list = (List) ah.aGg().fromJson(Fh, new TabHelper$1(this).getType());
                if (list != null) {
                    com.iqoption.app.helpers.a FI = com.iqoption.app.helpers.a.FI();
                    for (g gVar : list) {
                        gVar.init();
                        com.iqoption.core.microservices.tradingengine.response.active.a a = FI.a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
                        if (a != null) {
                            a(gVar, a);
                            arrayList.add(gVar);
                        }
                    }
                }
                return arrayList;
            }
        } catch (Throwable e) {
            com.iqoption.core.i.d(TAG, e);
        }
        return arrayList;
    }

    private void a(g gVar, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        gVar.IN();
        gVar.IV();
        String IM = gVar.IM();
        com.iqoption.gl.b.aow().glchTabAdd(IM, (long) gVar.id);
        com.iqoption.gl.b.aow().glchTabSetActiveId(IM, gVar.activeId);
        com.iqoption.gl.b.aow().glchTabSetFinanceInstrument(IM, gVar.instrumentType.getOptionActiveOrInstrumentValue());
        com.iqoption.gl.b.aow().glchTabSetPrecision(IM, aVar.getPrecision());
        gVar.IY();
        this.apb.put(gVar.id, gVar);
    }

    public synchronized Set<Pair<Integer, Integer>> Ir() {
        Set<Pair<Integer, Integer>> uI;
        uI = Sets.uI();
        SparseArray clone = this.apb.clone();
        for (int i = 0; i < clone.size(); i++) {
            g gVar = (g) clone.valueAt(i);
            if (gVar != null) {
                uI.add(Pair.create(Integer.valueOf(gVar.activeId), Integer.valueOf(gVar.IX().candleSize)));
            }
        }
        return uI;
    }

    public synchronized Set<Pair<Integer, InstrumentType>> Is() {
        Set<Pair<Integer, InstrumentType>> uI;
        uI = Sets.uI();
        SparseArray clone = this.apb.clone();
        for (int i = 0; i < clone.size(); i++) {
            g gVar = (g) clone.valueAt(i);
            if (gVar != null) {
                uI.add(Pair.create(Integer.valueOf(gVar.activeId), gVar.instrumentType));
            }
        }
        return uI;
    }

    public int It() {
        g gVar = (g) this.apb.get(this.apc);
        return gVar != null ? gVar.activeId : 0;
    }

    private void dd(int i) {
        this.aiI = new com.iqoption.h.a.a(i);
    }

    public com.iqoption.h.a.a Iu() {
        if (this.aiI == null) {
            this.aiI = new com.iqoption.h.a.a();
        }
        return this.aiI;
    }

    @NonNull
    public InstrumentType Iv() {
        g gVar = (g) this.apb.get(this.apc);
        if (gVar != null) {
            return gVar.instrumentType;
        }
        return InstrumentType.UNKNOWN;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a Iw() {
        g gVar = (g) this.apb.get(this.apc);
        return gVar != null ? com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType) : null;
    }

    @Nullable
    public Strike Ix() {
        g IC = IC();
        if (IC == null) {
            return null;
        }
        return IC.apr;
    }

    public void a(g gVar, Strike strike) {
        if (gVar != null) {
            gVar.c(strike);
        }
    }

    public long Iy() {
        g IC = IC();
        if (IC == null) {
            return 0;
        }
        return IC.IQ();
    }

    public Expiration Iz() {
        g IC = IC();
        if (IC == null) {
            return Expiration.notInitilizedDigitalExpiration;
        }
        return IC.IO();
    }

    public long IA() {
        g IC = IC();
        if (IC == null) {
            return 0;
        }
        return IC.getExpiration();
    }

    @Nullable
    public Expiration IB() {
        com.iqoption.core.microservices.tradingengine.response.active.a Iw = Il().Iw();
        if (Iw == null) {
            return null;
        }
        Log.d("TEST___", "switch to next expiration");
        return p(Iw);
    }

    private Expiration p(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar == null) {
            return null;
        }
        Expiration a = k.HB().a(aVar, Iz());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("current ");
        stringBuilder.append(Iz());
        stringBuilder.append(" ");
        stringBuilder.append(a);
        Log.d("TEST___", stringBuilder.toString());
        d(a);
        return a;
    }

    private void b(g gVar) {
        if (gVar != null) {
            a(gVar, true);
        }
    }

    public void d(Expiration expiration) {
        g IC = IC();
        if (IC != null) {
            IC.g(expiration);
            a(IC, true);
        }
    }

    private void b(g gVar, com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar != null) {
            Expiration IO = gVar.IO();
            Expiration a = k.HB().a(aVar, IO);
            long j = 0;
            if (a.expValue.longValue() <= 0) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("absent expiration ");
                stringBuilder.append(a.toStringFullLog());
                com.iqoption.core.i.i(str, stringBuilder.toString());
                if (IO.expInterval != null) {
                    j = IO.expInterval.longValue() / 1000;
                }
                com.iqoption.core.a.a.a.aMG.a((long) aVar.getActiveId(), aVar.instrumentType, j);
            }
            a(gVar, a);
        }
    }

    private void a(g gVar, Expiration expiration) {
        com.iqoption.core.i.d(TAG, "SPOTP switchToExpiration and updateStrike");
        gVar.g(expiration);
        c(gVar);
        c(gVar.activeId, gVar.rate);
    }

    private void c(g gVar) {
        a(gVar, false);
    }

    private void a(g gVar, boolean z) {
        Log.d("TEST___", "set expiration");
        if (gVar != null && gVar.apo != 0 && gVar.apo != -1) {
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
            if (a != null && com.iqoption.util.e.a.G(a)) {
                if (a.isExpired()) {
                    com.iqoption.gl.b.aow().glchTabSetExpirationTime(gVar.IM(), (int) gVar.IQ(), (double) gVar.IP(), (double) gVar.q(a));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("glchTabSetExpirationTime = ");
                    stringBuilder.append(bf.dwJ.format(Long.valueOf(gVar.apo)));
                    com.iqoption.core.i.d(stringBuilder.toString());
                    if (z) {
                        com.iqoption.gl.b.aow().glchApplyAutoSize();
                    }
                } else {
                    com.iqoption.gl.b.aow().glchTabSetExpirationTime(gVar.IM(), 0, 0.0d, 0.0d);
                }
                IQApp.Dn().aE(new com.iqoption.app.managers.a.k.a(new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(gVar.IP()), Integer.valueOf(gVar.activeId), gVar.instrumentType), gVar.IO(), gVar.id, gVar.IW()));
            }
        }
    }

    public void onTick(long j) {
        if (this.apd) {
            for (int i = 0; i < this.apb.size(); i++) {
                g gVar = (g) this.apb.valueAt(i);
                if (!(gVar == null || gVar.apo == -1)) {
                    com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
                    if (a != null && com.iqoption.util.e.a.G(a)) {
                        if (gVar.apo == 0) {
                            d(gVar);
                        } else {
                            long c = k.HB().c(a, gVar.IO());
                            com.iqoption.mobbtech.connect.response.options.i iVar = new com.iqoption.mobbtech.connect.response.options.i(Long.valueOf(gVar.IP()), Integer.valueOf(gVar.activeId), gVar.instrumentType);
                            if (j <= gVar.apo - c || j >= gVar.apo || com.iqoption.app.managers.c.Gn().b(iVar)) {
                                if (j > gVar.apo - c) {
                                    b(gVar, a);
                                }
                                k.HB().l(a);
                                if (gVar.apo == 0) {
                                    com.iqoption.core.i.d(TAG, "SPOTP reset expiration");
                                    d(gVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            long expiration = gVar.getExpiration();
            com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
            Object obj = (a == null || !a.isExpired()) ? null : 1;
            if (obj != null) {
                if (expiration == 0) {
                    com.iqoption.gl.b.aow().glchTabSetExpirationTime(gVar.IM(), 0, 0.0d, 0.0d);
                }
                if (((c) this.apg.get(Integer.valueOf(gVar.id))) == null) {
                    Map map = this.apg;
                    Integer valueOf = Integer.valueOf(gVar.getId());
                    com.google.common.util.concurrent.n cVar = new c(gVar.getId(), a);
                    map.put(valueOf, cVar);
                    ag.a(k.HB().k(a), cVar);
                }
                return;
            }
            gVar.apo = -1;
            com.iqoption.gl.b.aow().glchTabSetExpirationTime(gVar.IM(), 0, 0.0d, 0.0d);
        }
    }

    @Nullable
    public g IC() {
        return this.apd ? (g) this.apb.get(this.apc) : null;
    }

    public int ID() {
        if (this.apd) {
            return this.apc;
        }
        return aoX;
    }

    public String IE() {
        if (this.apd) {
            return String.valueOf(this.apc);
        }
        return aoY;
    }

    public g de(int i) {
        return (g) this.apb.get(i);
    }

    private void df(int i) {
        for (int i2 = 0; i2 < this.apb.size(); i2++) {
            g gVar = (g) this.apb.valueAt(i2);
            if (gVar != null && gVar.getActiveId() == i) {
                gVar.IS();
            }
        }
    }

    private void a(int i, int i2, InstrumentType instrumentType, Expiration expiration) {
        g de = de(i);
        com.iqoption.core.microservices.tradingengine.response.active.a FX = com.iqoption.app.helpers.a.FI().FX();
        a(1, de, false);
        de.b(i2, instrumentType, expiration);
        de.IY();
        a(0, de, true);
        com.iqoption.app.helpers.a.FI().d(FX);
        fi(de.IM());
        f(de);
        cr crVar = (cr) this.ape.get();
        if (!(crVar == null || crVar.cru == null)) {
            crVar.cru.dCp.aIu();
        }
        Ip();
    }

    public void d(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        if (aVar != null && this.apd) {
            a(this.apc, aVar.getActiveId(), aVar.getInstrumentType(), expiration);
        }
    }

    public void c(int i, InstrumentType instrumentType) {
        if (this.apd) {
            a(this.apc, i, instrumentType, Expiration.notInitilizedExpiration);
        }
    }

    private synchronized boolean IF() {
        SparseArray clone = this.apb.clone();
        for (int i = 0; i < clone.size(); i++) {
            if (com.iqoption.core.ext.c.b(((g) clone.valueAt(i)).getInstrumentType(), InstrumentType.DIGITAL_INSTRUMENT, InstrumentType.FX_INSTRUMENT)) {
                return true;
            }
        }
        return false;
    }

    private void D(List<g> list) {
        cr crVar = (cr) this.ape.get();
        if (crVar != null && crVar.cru != null) {
            crVar.cru.dCp.bz(list);
        }
    }

    private void E(List<g> list) {
        for (g gVar : list) {
            a(1, gVar, false);
            a(0, gVar, false);
        }
        WebSocketHandler.a(WebSocketHandler.aDm());
    }

    public synchronized void e(g gVar) {
        b(gVar, false);
    }

    /* JADX WARNING: Missing block: B:17:0x0057, code:
            return;
     */
    public synchronized void b(com.iqoption.app.managers.tab.a.g r5, boolean r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.apd;	 Catch:{ all -> 0x0058 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);
        return;
    L_0x0007:
        r0 = 4;
        r1 = r4.apb;	 Catch:{ all -> 0x0058 }
        r1 = r1.size();	 Catch:{ all -> 0x0058 }
        if (r0 <= r1) goto L_0x0056;
    L_0x0010:
        r0 = com.iqoption.gl.b.aow();	 Catch:{ all -> 0x0058 }
        r1 = r5.IM();	 Catch:{ all -> 0x0058 }
        r2 = r5.id;	 Catch:{ all -> 0x0058 }
        r2 = (long) r2;	 Catch:{ all -> 0x0058 }
        r0.glchTabAdd(r1, r2);	 Catch:{ all -> 0x0058 }
        r0 = r4.apb;	 Catch:{ all -> 0x0058 }
        r1 = r5.id;	 Catch:{ all -> 0x0058 }
        r0.put(r1, r5);	 Catch:{ all -> 0x0058 }
        r5.IY();	 Catch:{ all -> 0x0058 }
        r4.f(r5);	 Catch:{ all -> 0x0058 }
        r0 = 0;
        r4.a(r0, r5);	 Catch:{ all -> 0x0058 }
        r0 = com.iqoption.gl.b.aow();	 Catch:{ all -> 0x0058 }
        r1 = r5.IM();	 Catch:{ all -> 0x0058 }
        r0.glchSetActiveTab(r1);	 Catch:{ all -> 0x0058 }
        r0 = r4.ape;	 Catch:{ all -> 0x0058 }
        r0 = r0.get();	 Catch:{ all -> 0x0058 }
        r0 = (com.iqoption.fragment.cr) r0;	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0053;
    L_0x0048:
        r1 = r0.cru;	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0053;
    L_0x004c:
        r0 = r0.cru;	 Catch:{ all -> 0x0058 }
        r0 = r0.dCp;	 Catch:{ all -> 0x0058 }
        r0.c(r5, r6);	 Catch:{ all -> 0x0058 }
    L_0x0053:
        r4.Ip();	 Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r4);
        return;
    L_0x0058:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.tab.a.b(com.iqoption.app.managers.tab.a$g, boolean):void");
    }

    public synchronized void dg(int i) {
        if (this.apd) {
            g de = de(i);
            this.apb.remove(i);
            if (de != null) {
                a(1, de);
                String IM = de.IM();
                com.iqoption.gl.b.aow().glchTabRemove(IM);
                fi(IM);
            }
            cr crVar = (cr) this.ape.get();
            if (!(crVar == null || crVar.cru == null)) {
                crVar.cru.dCp.gU(i);
            }
            Ip();
        }
    }

    private void fi(String str) {
        com.iqoption.charttools.f.arM.fp(str).b(com.iqoption.core.h.i.Yr()).aVS();
        this.apf.fw(str);
    }

    /* JADX WARNING: Missing block: B:16:0x004d, code:
            return;
     */
    public synchronized void dh(int r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.apd;	 Catch:{ all -> 0x004e }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);
        return;
    L_0x0007:
        r0 = r3.apb;	 Catch:{ all -> 0x004e }
        r0 = r0.get(r4);	 Catch:{ all -> 0x004e }
        r0 = (com.iqoption.app.managers.tab.a.g) r0;	 Catch:{ all -> 0x004e }
        if (r0 == 0) goto L_0x004c;
    L_0x0011:
        r3.g(r0);	 Catch:{ all -> 0x004e }
        r1 = com.iqoption.gl.b.aow();	 Catch:{ all -> 0x004e }
        r2 = r0.IM();	 Catch:{ all -> 0x004e }
        r1.glchSetActiveTab(r2);	 Catch:{ all -> 0x004e }
        r1 = r3.ape;	 Catch:{ all -> 0x004e }
        r1 = r1.get();	 Catch:{ all -> 0x004e }
        r1 = (com.iqoption.fragment.cr) r1;	 Catch:{ all -> 0x004e }
        if (r1 == 0) goto L_0x0034;
    L_0x0029:
        r2 = r1.cru;	 Catch:{ all -> 0x004e }
        if (r2 == 0) goto L_0x0034;
    L_0x002d:
        r1 = r1.cru;	 Catch:{ all -> 0x004e }
        r1 = r1.dCp;	 Catch:{ all -> 0x004e }
        r1.gT(r4);	 Catch:{ all -> 0x004e }
    L_0x0034:
        r4 = com.iqoption.app.IQApp.Dn();	 Catch:{ all -> 0x004e }
        r1 = new com.iqoption.app.managers.a.k$b;	 Catch:{ all -> 0x004e }
        r2 = r0.id;	 Catch:{ all -> 0x004e }
        r1.<init>(r2);	 Catch:{ all -> 0x004e }
        r0 = r0.IR();	 Catch:{ all -> 0x004e }
        r0 = r1.setValue(r0);	 Catch:{ all -> 0x004e }
        r4.aE(r0);	 Catch:{ all -> 0x004e }
    L_0x004c:
        monitor-exit(r3);
        return;
    L_0x004e:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.tab.a.dh(int):void");
    }

    private void a(int i, g gVar) {
        a(i, gVar, true);
    }

    private void a(int i, g gVar, boolean z) {
        if (this.apd && gVar != null) {
            if (InstrumentType.DIGITAL_INSTRUMENT == gVar.instrumentType || InstrumentType.FX_INSTRUMENT == gVar.instrumentType) {
                com.iqoption.core.microservices.tradingengine.response.active.h hVar = (com.iqoption.core.microservices.tradingengine.response.active.h) com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
                if (hVar != null) {
                    String str = InstrumentType.FX_INSTRUMENT == gVar.instrumentType ? "instruments-quotes-fx-option" : null;
                    int groupId = com.iqoption.app.a.Cw().getGroupId();
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_group_id", Integer.valueOf(groupId));
                    hashMap.put(Param.TYPE, hVar.getInstrumentType());
                    hashMap.put("underlying", hVar.Xf());
                    switch (i) {
                        case 0:
                            y.a(true, hashMap, str);
                            break;
                        case 1:
                            y.a(false, hashMap, str);
                            Strike m = gVar.apr;
                            if (m != null) {
                                y.a(false, m.call.id, m.optionType, groupId);
                                y.a(false, m.put.id, m.optionType, groupId);
                                break;
                            }
                            break;
                    }
                }
            }
            if (z) {
                WebSocketHandler.a(WebSocketHandler.aDm());
            }
        }
    }

    /* JADX WARNING: Missing block: B:20:0x002d, code:
            return r0;
     */
    public synchronized com.iqoption.app.managers.tab.a.g a(int r10, @android.support.annotation.Nullable com.iqoption.core.data.model.InstrumentType r11, com.iqoption.dto.entity.expiration.Expiration r12, boolean r13) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.apd;	 Catch:{ all -> 0x015e }
        if (r0 != 0) goto L_0x0008;
    L_0x0005:
        r10 = 0;
        monitor-exit(r9);
        return r10;
    L_0x0008:
        r0 = r9.IC();	 Catch:{ all -> 0x015e }
        r1 = 0;
        if (r0 == 0) goto L_0x002e;
    L_0x0010:
        r3 = r0.activeId;	 Catch:{ all -> 0x015e }
        if (r3 != r10) goto L_0x002e;
    L_0x0016:
        r3 = r0.instrumentType;	 Catch:{ all -> 0x015e }
        if (r3 != r11) goto L_0x002e;
    L_0x001c:
        r3 = r0.f(r12);	 Catch:{ all -> 0x015e }
        if (r3 != 0) goto L_0x002c;
    L_0x0022:
        r3 = r12.expValue;	 Catch:{ all -> 0x015e }
        r3 = r3.longValue();	 Catch:{ all -> 0x015e }
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r9);
        return r0;
    L_0x002e:
        r3 = 0;
        r4 = 0;
    L_0x0030:
        r5 = r9.apb;	 Catch:{ all -> 0x015e }
        r5 = r5.size();	 Catch:{ all -> 0x015e }
        if (r4 >= r5) goto L_0x0076;
    L_0x0038:
        r5 = r9.apb;	 Catch:{ all -> 0x015e }
        r5 = r5.valueAt(r4);	 Catch:{ all -> 0x015e }
        r5 = (com.iqoption.app.managers.tab.a.g) r5;	 Catch:{ all -> 0x015e }
        if (r5 == 0) goto L_0x0073;
    L_0x0042:
        r6 = r5.id;	 Catch:{ all -> 0x015e }
        r7 = r9.apc;	 Catch:{ all -> 0x015e }
        if (r6 == r7) goto L_0x0073;
    L_0x004a:
        r6 = r5.activeId;	 Catch:{ all -> 0x015e }
        if (r6 != r10) goto L_0x0073;
    L_0x0050:
        r6 = r5.instrumentType;	 Catch:{ all -> 0x015e }
        r6 = r6.equals(r11);	 Catch:{ all -> 0x015e }
        if (r6 == 0) goto L_0x0073;
    L_0x005a:
        r6 = r5.f(r12);	 Catch:{ all -> 0x015e }
        if (r6 != 0) goto L_0x006a;
    L_0x0060:
        r6 = r12.expValue;	 Catch:{ all -> 0x015e }
        r6 = r6.longValue();	 Catch:{ all -> 0x015e }
        r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r8 != 0) goto L_0x0073;
    L_0x006a:
        r10 = r5.id;	 Catch:{ all -> 0x015e }
        r9.dh(r10);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r5;
    L_0x0073:
        r4 = r4 + 1;
        goto L_0x0030;
    L_0x0076:
        if (r0 == 0) goto L_0x009b;
    L_0x0078:
        r1 = r0.activeId;	 Catch:{ all -> 0x015e }
        if (r1 != r10) goto L_0x009b;
    L_0x007e:
        r1 = r0.instrumentType;	 Catch:{ all -> 0x015e }
        r1 = r1.equals(r11);	 Catch:{ all -> 0x015e }
        if (r1 == 0) goto L_0x009b;
    L_0x0088:
        r1 = com.iqoption.app.managers.c.Gn();	 Catch:{ all -> 0x015e }
        r2 = r0.getOptionKey();	 Catch:{ all -> 0x015e }
        r1 = r1.b(r2);	 Catch:{ all -> 0x015e }
        if (r1 == 0) goto L_0x009b;
    L_0x0096:
        r9.d(r12);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r0;
    L_0x009b:
        r0 = 0;
    L_0x009c:
        r1 = r9.apb;	 Catch:{ all -> 0x015e }
        r1 = r1.size();	 Catch:{ all -> 0x015e }
        if (r0 >= r1) goto L_0x00e3;
    L_0x00a4:
        r1 = r9.apb;	 Catch:{ all -> 0x015e }
        r1 = r1.valueAt(r0);	 Catch:{ all -> 0x015e }
        r1 = (com.iqoption.app.managers.tab.a.g) r1;	 Catch:{ all -> 0x015e }
        if (r1 == 0) goto L_0x00e0;
    L_0x00ae:
        r2 = r1.activeId;	 Catch:{ all -> 0x015e }
        if (r2 != r10) goto L_0x00e0;
    L_0x00b4:
        r2 = r1.instrumentType;	 Catch:{ all -> 0x015e }
        r2 = r2.equals(r11);	 Catch:{ all -> 0x015e }
        if (r2 == 0) goto L_0x00e0;
    L_0x00be:
        r2 = r1.id;	 Catch:{ all -> 0x015e }
        r4 = r9.apc;	 Catch:{ all -> 0x015e }
        if (r2 == r4) goto L_0x00e0;
    L_0x00c6:
        r2 = com.iqoption.app.managers.c.Gn();	 Catch:{ all -> 0x015e }
        r4 = r1.getOptionKey();	 Catch:{ all -> 0x015e }
        r2 = r2.b(r4);	 Catch:{ all -> 0x015e }
        if (r2 == 0) goto L_0x00e0;
    L_0x00d4:
        r1.g(r12);	 Catch:{ all -> 0x015e }
        r10 = r1.id;	 Catch:{ all -> 0x015e }
        r9.dh(r10);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r1;
    L_0x00e0:
        r0 = r0 + 1;
        goto L_0x009c;
    L_0x00e3:
        r0 = r9.apb;	 Catch:{ all -> 0x015e }
        r0 = r0.size();	 Catch:{ all -> 0x015e }
        r1 = 4;
        if (r0 >= r1) goto L_0x00f6;
    L_0x00ec:
        r0 = new com.iqoption.app.managers.tab.a$g;	 Catch:{ all -> 0x015e }
        r0.<init>(r10, r11, r12);	 Catch:{ all -> 0x015e }
        r9.b(r0, r13);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r0;
    L_0x00f6:
        r13 = 0;
    L_0x00f7:
        r0 = r9.apb;	 Catch:{ all -> 0x015e }
        r0 = r0.size();	 Catch:{ all -> 0x015e }
        if (r13 >= r0) goto L_0x0137;
    L_0x00ff:
        r0 = r9.apb;	 Catch:{ all -> 0x015e }
        r0 = r0.valueAt(r13);	 Catch:{ all -> 0x015e }
        r0 = (com.iqoption.app.managers.tab.a.g) r0;	 Catch:{ all -> 0x015e }
        if (r0 == 0) goto L_0x0134;
    L_0x0109:
        r1 = r0.activeId;	 Catch:{ all -> 0x015e }
        if (r1 != r10) goto L_0x0134;
    L_0x010f:
        r1 = r9.apc;	 Catch:{ all -> 0x015e }
        r2 = r0.id;	 Catch:{ all -> 0x015e }
        if (r1 == r2) goto L_0x0134;
    L_0x0117:
        r1 = com.iqoption.app.managers.c.Gn();	 Catch:{ all -> 0x015e }
        r2 = r0.getOptionKey();	 Catch:{ all -> 0x015e }
        r1 = r1.b(r2);	 Catch:{ all -> 0x015e }
        if (r1 == 0) goto L_0x0134;
    L_0x0125:
        r0.g(r12);	 Catch:{ all -> 0x015e }
        r0.instrumentType = r11;	 Catch:{ all -> 0x015e }
        r10 = r0.id;	 Catch:{ all -> 0x015e }
        r9.dh(r10);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r0;
    L_0x0134:
        r13 = r13 + 1;
        goto L_0x00f7;
    L_0x0137:
        r13 = r9.apc;	 Catch:{ all -> 0x015e }
        r0 = aoX;	 Catch:{ all -> 0x015e }
        if (r13 != r0) goto L_0x0151;
    L_0x013d:
        r13 = r9.apb;	 Catch:{ all -> 0x015e }
        r0 = r9.apb;	 Catch:{ all -> 0x015e }
        r0 = r0.keyAt(r3);	 Catch:{ all -> 0x015e }
        r13 = r13.get(r0);	 Catch:{ all -> 0x015e }
        r13 = (com.iqoption.app.managers.tab.a.g) r13;	 Catch:{ all -> 0x015e }
        r13 = r13.id;	 Catch:{ all -> 0x015e }
        r9.apc = r13;	 Catch:{ all -> 0x015e }
    L_0x0151:
        r13 = r9.apc;	 Catch:{ all -> 0x015e }
        r9.a(r13, r10, r11, r12);	 Catch:{ all -> 0x015e }
        r10 = r9.apc;	 Catch:{ all -> 0x015e }
        r10 = r9.de(r10);	 Catch:{ all -> 0x015e }
        monitor-exit(r9);
        return r10;
    L_0x015e:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.tab.a.a(int, com.iqoption.core.data.model.InstrumentType, com.iqoption.dto.entity.expiration.Expiration, boolean):com.iqoption.app.managers.tab.a$g");
    }

    public synchronized g a(int i, InstrumentType instrumentType, boolean z) {
        return a(i, instrumentType, Expiration.notInitilizedExpiration, z);
    }

    public synchronized g d(int i, InstrumentType instrumentType) {
        return a(i, instrumentType, Expiration.notInitilizedExpiration, false);
    }

    public synchronized g a(int i, InstrumentType instrumentType, Expiration expiration) {
        return a(i, instrumentType, expiration, false);
    }

    @Nullable
    public synchronized g p(@NonNull InstrumentType instrumentType) {
        int size = this.apb.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.apb.valueAt(i);
            if (instrumentType.equals(gVar.getInstrumentType()) && com.iqoption.util.e.a.G(com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.getActiveId()), instrumentType))) {
                dh(gVar.id);
                return gVar;
            }
        }
        com.iqoption.core.microservices.tradingengine.response.active.a f = com.iqoption.app.helpers.a.FI().f(instrumentType);
        if (f == null) {
            return null;
        }
        return a(f.getActiveId(), instrumentType, Expiration.notInitilizedExpiration, false);
    }

    private void f(g gVar) {
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
        if (a != null) {
            String IM = gVar.IM();
            com.iqoption.gl.b.aow().glchTabSetActiveId(IM, gVar.activeId);
            com.iqoption.gl.b.aow().glchTabSetFinanceInstrument(IM, gVar.instrumentType.getOptionActiveOrInstrumentValue());
            com.iqoption.gl.b.aow().glchTabSetPrecision(IM, a.getPrecision());
            com.iqoption.gl.b.aow().glchTabSetStartTime(IM, a.getStartTime());
            com.iqoption.gl.b.aow().setLiveDealsEnabled(com.iqoption.settings.b.aDQ().MV());
            g(gVar);
            IQApp.Dn().aE(new com.iqoption.app.managers.a.k.b(gVar.id).setValue(gVar.IR()));
        }
    }

    private void g(g gVar) {
        com.iqoption.core.microservices.tradingengine.response.active.a a = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(gVar.activeId), gVar.instrumentType);
        if (a != null) {
            this.apc = gVar.id;
            af DX = af.DX();
            DX.b(gVar.instrumentType);
            DX.cK(gVar.activeId);
            dd(a.getPrecision());
            IQApp.Dn().aE(new i());
            this.apf.fv(gVar.IM());
            d(gVar);
        }
    }

    public int IG() {
        return this.apb.size();
    }

    @android.support.annotation.WorkerThread
    private boolean IH() {
        /*
        r11 = this;
        com.iqoption.core.gl.Graph.await();
        r0 = 0;
        r11.apd = r0;
        r1 = com.iqoption.gl.b.aow();
        r1.glchTabRemoveAll();
        r1 = r11.apb;
        r1.clear();
        r1 = aoX;
        r11.apc = r1;
        r1 = r11.Iq();	 Catch:{ Exception -> 0x01ad }
        r2 = com.iqoption.app.managers.feature.b.HT();	 Catch:{ Exception -> 0x01ad }
        r3 = com.iqoption.app.af.DX();	 Catch:{ Exception -> 0x01ad }
        r4 = r3.getInstrumentType();	 Catch:{ Exception -> 0x01ad }
        r5 = r3.getActiveId();	 Catch:{ Exception -> 0x01ad }
        r6 = 1;
        if (r4 != 0) goto L_0x00c3;
    L_0x002d:
        r7 = "default-instrument";
        r7 = r2.eY(r7);	 Catch:{ Exception -> 0x01ad }
        r8 = -1;
        r9 = r7.hashCode();	 Catch:{ Exception -> 0x01ad }
        switch(r9) {
            case -1388966911: goto L_0x006f;
            case -1351683903: goto L_0x0065;
            case 98401: goto L_0x005b;
            case 97618748: goto L_0x0051;
            case 110726686: goto L_0x0046;
            case 1660481048: goto L_0x003c;
            default: goto L_0x003b;
        };	 Catch:{ Exception -> 0x01ad }
    L_0x003b:
        goto L_0x0079;
    L_0x003c:
        r9 = "digital";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x0044:
        r7 = 2;
        goto L_0x007a;
    L_0x0046:
        r9 = "turbo";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x004f:
        r7 = 0;
        goto L_0x007a;
    L_0x0051:
        r9 = "forex";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x0059:
        r7 = 5;
        goto L_0x007a;
    L_0x005b:
        r9 = "cfd";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x0063:
        r7 = 3;
        goto L_0x007a;
    L_0x0065:
        r9 = "crypto";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x006d:
        r7 = 4;
        goto L_0x007a;
    L_0x006f:
        r9 = "binary";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0079;
    L_0x0077:
        r7 = 1;
        goto L_0x007a;
    L_0x0079:
        r7 = -1;
    L_0x007a:
        switch(r7) {
            case 0: goto L_0x00ba;
            case 1: goto L_0x00b1;
            case 2: goto L_0x009f;
            case 3: goto L_0x0094;
            case 4: goto L_0x0089;
            case 5: goto L_0x0080;
            default: goto L_0x007d;
        };	 Catch:{ Exception -> 0x01ad }
    L_0x007d:
        r4 = com.iqoption.core.data.model.InstrumentType.DIGITAL_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        goto L_0x00c2;
    L_0x0080:
        r7 = com.iqoption.app.managers.feature.a.HL();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x0086:
        r4 = com.iqoption.core.data.model.InstrumentType.FOREX_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        goto L_0x00c2;
    L_0x0089:
        r7 = com.iqoption.app.managers.feature.a.HM();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x008f:
        r4 = com.iqoption.core.data.model.InstrumentType.CRYPTO_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        r5 = 816; // 0x330 float:1.143E-42 double:4.03E-321;
        goto L_0x00c3;
    L_0x0094:
        r7 = com.iqoption.app.managers.feature.a.HK();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x009a:
        r4 = com.iqoption.core.data.model.InstrumentType.CFD_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        r5 = 298; // 0x12a float:4.18E-43 double:1.47E-321;
        goto L_0x00c3;
    L_0x009f:
        r7 = com.iqoption.app.managers.feature.a.HH();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x00a5:
        r4 = com.iqoption.app.managers.feature.a.HG();	 Catch:{ Exception -> 0x01ad }
        if (r4 == 0) goto L_0x00ae;
    L_0x00ab:
        r4 = com.iqoption.core.data.model.InstrumentType.BINARY_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        goto L_0x00c2;
    L_0x00ae:
        r4 = com.iqoption.core.data.model.InstrumentType.DIGITAL_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        goto L_0x00c2;
    L_0x00b1:
        r7 = com.iqoption.app.managers.feature.a.HJ();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x00b7:
        r4 = com.iqoption.core.data.model.InstrumentType.BINARY_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
        goto L_0x00c2;
    L_0x00ba:
        r7 = com.iqoption.app.managers.feature.a.HJ();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x00c3;
    L_0x00c0:
        r4 = com.iqoption.core.data.model.InstrumentType.TURBO_INSTRUMENT;	 Catch:{ Exception -> 0x01ad }
    L_0x00c2:
        r5 = 1;
    L_0x00c3:
        r7 = "four-tabs";
        r2 = r2.fd(r7);	 Catch:{ Exception -> 0x01ad }
        r7 = r1.size();	 Catch:{ Exception -> 0x01ad }
        if (r7 != 0) goto L_0x0159;
    L_0x00cf:
        if (r2 == 0) goto L_0x0159;
    L_0x00d1:
        r7 = r2.params;	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0159;
    L_0x00d5:
        r7 = "enabled";
        r8 = r2.status;	 Catch:{ Exception -> 0x01ad }
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0159;
    L_0x00df:
        r7 = com.iqoption.util.ah.aGh();	 Catch:{ Exception -> 0x01ad }
        r2 = r2.params;	 Catch:{ Exception -> 0x01ad }
        r8 = com.iqoption.dto.entity.FourTabsParam.List.class;
        r2 = r7.fromJson(r2, r8);	 Catch:{ Exception -> 0x01ad }
        r2 = (java.util.ArrayList) r2;	 Catch:{ Exception -> 0x01ad }
        r7 = com.iqoption.util.i.H(r2);	 Catch:{ Exception -> 0x01ad }
        if (r7 != 0) goto L_0x0159;
    L_0x00f3:
        r3 = r3.Dh();	 Catch:{ Exception -> 0x01ad }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x01ad }
    L_0x00fb:
        r7 = r2.hasNext();	 Catch:{ Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0159;
    L_0x0101:
        r7 = r2.next();	 Catch:{ Exception -> 0x01ad }
        r7 = (com.iqoption.dto.entity.FourTabsParam) r7;	 Catch:{ Exception -> 0x01ad }
        if (r3 == 0) goto L_0x010c;
    L_0x0109:
        r7 = r7.reg;	 Catch:{ Exception -> 0x01ad }
        goto L_0x010e;
    L_0x010c:
        r7 = r7.noReg;	 Catch:{ Exception -> 0x01ad }
    L_0x010e:
        r8 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x01ad }
        r9 = r7.assetId;	 Catch:{ Exception -> 0x01ad }
        r10 = r7.instrumentType;	 Catch:{ Exception -> 0x01ad }
        r8 = r8.a(r9, r10);	 Catch:{ Exception -> 0x01ad }
        if (r8 == 0) goto L_0x012a;
    L_0x011c:
        r9 = com.iqoption.app.managers.af.Hu();	 Catch:{ Exception -> 0x01ad }
        r9 = r9.Hw();	 Catch:{ Exception -> 0x01ad }
        r9 = r8.ba(r9);	 Catch:{ Exception -> 0x01ad }
        if (r9 != 0) goto L_0x0134;
    L_0x012a:
        r8 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x01ad }
        r7 = r7.instrumentType;	 Catch:{ Exception -> 0x01ad }
        r8 = r8.a(r7, r1);	 Catch:{ Exception -> 0x01ad }
    L_0x0134:
        if (r8 != 0) goto L_0x0137;
    L_0x0136:
        goto L_0x00fb;
    L_0x0137:
        r7 = r1.size();	 Catch:{ Exception -> 0x01ad }
        if (r7 != 0) goto L_0x0145;
    L_0x013d:
        r4 = r8.getInstrumentType();	 Catch:{ Exception -> 0x01ad }
        r5 = r8.getActiveId();	 Catch:{ Exception -> 0x01ad }
    L_0x0145:
        r7 = new com.iqoption.app.managers.tab.a$g;	 Catch:{ Exception -> 0x01ad }
        r9 = r8.getActiveId();	 Catch:{ Exception -> 0x01ad }
        r10 = r8.getInstrumentType();	 Catch:{ Exception -> 0x01ad }
        r7.<init>(r9, r10);	 Catch:{ Exception -> 0x01ad }
        r11.a(r7, r8);	 Catch:{ Exception -> 0x01ad }
        r1.add(r0, r7);	 Catch:{ Exception -> 0x01ad }
        goto L_0x00fb;
    L_0x0159:
        r2 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x01ad }
        r3 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x01ad }
        r2 = r2.a(r3, r4);	 Catch:{ Exception -> 0x01ad }
        if (r2 != 0) goto L_0x016f;
    L_0x0167:
        r2 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x01ad }
        r2 = r2.f(r4);	 Catch:{ Exception -> 0x01ad }
    L_0x016f:
        if (r2 != 0) goto L_0x0179;
    L_0x0171:
        r2 = com.iqoption.app.helpers.a.FI();	 Catch:{ Exception -> 0x01ad }
        r2 = r2.FY();	 Catch:{ Exception -> 0x01ad }
    L_0x0179:
        if (r2 == 0) goto L_0x018f;
    L_0x017b:
        r3 = r2.getActiveId();	 Catch:{ Exception -> 0x01ad }
        r2 = r2.getInstrumentType();	 Catch:{ Exception -> 0x01ad }
        r11.D(r1);	 Catch:{ Exception -> 0x01ad }
        r11.apd = r6;	 Catch:{ Exception -> 0x01ad }
        r11.E(r1);	 Catch:{ Exception -> 0x01ad }
        r11.d(r3, r2);	 Catch:{ Exception -> 0x01ad }
        goto L_0x01af;
    L_0x018f:
        r1 = TAG;	 Catch:{ Exception -> 0x01ad }
        r2 = "not found active!";
        com.iqoption.core.i.e(r1, r2);	 Catch:{ Exception -> 0x01ad }
        r1 = r11.ape;	 Catch:{ Exception -> 0x01ad }
        r1 = r1.get();	 Catch:{ Exception -> 0x01ad }
        r1 = (com.iqoption.fragment.cr) r1;	 Catch:{ Exception -> 0x01ad }
        if (r1 == 0) goto L_0x01a5;
    L_0x01a0:
        r2 = "...actives not loaded";
        r1.dQ(r2);	 Catch:{ Exception -> 0x01ad }
    L_0x01a5:
        r1 = new java.lang.Exception;	 Catch:{ Exception -> 0x01ad }
        r2 = "not found active!";
        r1.<init>(r2);	 Catch:{ Exception -> 0x01ad }
        throw r1;	 Catch:{ Exception -> 0x01ad }
    L_0x01ad:
        r11.apd = r0;
    L_0x01af:
        r0 = r11.apd;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.tab.a.IH():boolean");
    }

    private void a(ConcurrentHashMap<String, Strike> concurrentHashMap, g gVar, double d, boolean z) {
        if (!gVar.isSpotStrike()) {
            Strike a = a((ConcurrentHashMap) concurrentHashMap, d);
            if (a != null && (gVar.apr == null || !gVar.apr.equals(a))) {
                a(gVar, a);
            }
            if (z) {
                c(gVar);
            }
        }
    }

    @Nullable
    private Strike a(ConcurrentHashMap<String, Strike> concurrentHashMap, double d) {
        Strike strike = null;
        double d2 = d;
        for (Strike strike2 : concurrentHashMap.values()) {
            double abs = Math.abs(strike2.getValue().doubleValue() - d);
            if (abs < d2) {
                strike = strike2;
                d2 = abs;
            }
        }
        return strike;
    }

    private void a(ConcurrentHashMap<String, Strike> concurrentHashMap, g gVar, boolean z, double d) {
        Strike strike = concurrentHashMap.isEmpty() ? null : (Strike) concurrentHashMap.values().iterator().next();
        if (strike != null && (gVar.apr == null || !gVar.apr.equals(strike))) {
            a(gVar, strike);
        }
        if (!(gVar.apr == null || gVar.apr.getLastSpotValue().doubleValue() == d)) {
            gVar.IR().setLastSpotValue(d);
            IQApp.Dn().aE(new com.iqoption.app.managers.a.k.b(gVar.getId()).setValue(gVar.IR()));
        }
        if (z) {
            c(gVar);
        }
    }

    public void b(int i, double d) {
        c(i, d);
        df(i);
    }

    private void c(int i, double d) {
        if (this.apd && IF()) {
            com.iqoption.core.d.a.aSc.execute(new c(this, i, d));
        }
    }

    private void a(double d, int i, int i2, long j, InstrumentType instrumentType, long j2, com.iqoption.core.microservices.tradingengine.response.active.a aVar, com.iqoption.app.managers.a.e eVar) {
        int i3 = i;
        com.google.common.util.concurrent.n fVar = new f(i3, d);
        this.aph.put(Integer.valueOf(i3), fVar);
        ag.a(eVar.a(Integer.valueOf(i2), instrumentType, aVar.Xf(), Long.valueOf(j), Long.valueOf(j2), false), fVar);
    }

    private void b(double d, int i, int i2, long j, InstrumentType instrumentType, long j2, com.iqoption.core.microservices.tradingengine.response.active.a aVar, com.iqoption.app.managers.a.e eVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPOTP requestSpotStrike expirationValue=");
        stringBuilder.append(j);
        com.iqoption.core.i.d(str, stringBuilder.toString());
        com.google.common.util.concurrent.n eVar2 = new e(i, d);
        this.api.put(Integer.valueOf(i), eVar2);
        ag.a(eVar.a(Integer.valueOf(i2), instrumentType, aVar.Xf(), Long.valueOf(j), Long.valueOf(j2), true), eVar2);
    }
}
