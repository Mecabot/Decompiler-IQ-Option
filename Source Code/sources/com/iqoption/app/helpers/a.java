package com.iqoption.app.helpers;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.common.base.Suppliers;
import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.i;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.app.managers.af;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.g;
import com.iqoption.core.microservices.tradingengine.response.active.k;
import com.iqoption.core.util.l;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import com.iqoption.util.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ActiveSettingHelper */
public class a {
    private static final String TAG = "com.iqoption.app.helpers.a";
    public static final j<com.iqoption.core.microservices.tradingengine.response.active.a> alv = d.$instance;
    public static final com.google.common.base.d<com.iqoption.core.microservices.tradingengine.response.active.a, Integer> alw = e.$instance;
    public static final com.google.common.base.d<com.iqoption.core.microservices.tradingengine.response.active.a, ActiveType> alx = f.$instance;
    private static final n<a> aly = Suppliers.a(g.ajD);
    private HashMap<InstrumentType, SparseArray<com.iqoption.core.microservices.tradingengine.response.b.a>> alA = FK();
    public HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.a.a>> alB = FL();
    private HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.f.a.a.a>> alC = FM();
    private ImmutableList<g> alD = ImmutableList.sL();
    public com.iqoption.core.util.l.a alE = b.alV;
    private ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> alF;
    private volatile boolean alG = false;
    private volatile boolean alH = false;
    private volatile boolean alI = false;
    private volatile boolean alJ = false;
    private volatile boolean alK = false;
    private volatile boolean alL = false;
    private volatile boolean alM = true;
    private volatile boolean alN = false;
    private volatile boolean alO = false;
    private volatile boolean alP = true;
    private volatile boolean alQ = false;
    private volatile boolean alR = false;
    private volatile boolean alS = true;
    private com.iqoption.core.util.l.a alT = c.alV;
    private com.iqoption.core.util.l.a alU = h.alV;
    private final SharedPreferences alq = IQApp.Dk().getSharedPreferences("as_pref_name", 0);
    private HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.active.a>> alz = FJ();

    /* compiled from: ActiveSettingHelper */
    public static class a {
        public final ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> amd;
        public final InstrumentType instrumentType;

        public a(InstrumentType instrumentType, ArrayList<com.iqoption.core.microservices.tradingengine.response.a.a> arrayList) {
            this.instrumentType = instrumentType;
            this.amd = arrayList;
        }
    }

    /* compiled from: ActiveSettingHelper */
    public static class b {
        public final int activeId;
        public final ActiveType activeType;
        public final int commission;

        public b(int i, ActiveType activeType, int i2) {
            this.activeId = i;
            this.activeType = activeType;
            this.commission = i2;
        }
    }

    /* compiled from: ActiveSettingHelper */
    public static class c {
    }

    /* compiled from: ActiveSettingHelper */
    public static class e {
    }

    /* compiled from: ActiveSettingHelper */
    public static class d extends com.iqoption.system.a.c<InstrumentType> {
    }

    /* compiled from: ActiveSettingHelper */
    public static class f extends com.iqoption.system.a.c<InstrumentType> {
    }

    public static a FI() {
        return (a) aly.get();
    }

    private a() {
    }

    private void X(String str, String str2) {
        this.alq.edit().putString(str, str2).apply();
    }

    private String eR(String str) {
        return this.alq.getString(str, "");
    }

    private boolean eS(String str) {
        return this.alq.contains(str);
    }

    private static HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.active.a>> FJ() {
        HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.active.a>> hashMap = new HashMap();
        hashMap.put(InstrumentType.CRYPTO_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CRYPTO_INSTRUMENT)));
        hashMap.put(InstrumentType.CFD_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CFD_INSTRUMENT)));
        hashMap.put(InstrumentType.FOREX_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.FOREX_INSTRUMENT)));
        hashMap.put(InstrumentType.DIGITAL_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.DIGITAL_INSTRUMENT)));
        hashMap.put(InstrumentType.BINARY_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.BINARY_INSTRUMENT)));
        hashMap.put(InstrumentType.TURBO_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.TURBO_INSTRUMENT)));
        hashMap.put(InstrumentType.FX_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.FX_INSTRUMENT)));
        return hashMap;
    }

    private static HashMap<InstrumentType, SparseArray<com.iqoption.core.microservices.tradingengine.response.b.a>> FK() {
        HashMap<InstrumentType, SparseArray<com.iqoption.core.microservices.tradingengine.response.b.a>> hashMap = new HashMap();
        hashMap.put(InstrumentType.CFD_INSTRUMENT, new SparseArray());
        hashMap.put(InstrumentType.FOREX_INSTRUMENT, new SparseArray());
        hashMap.put(InstrumentType.CRYPTO_INSTRUMENT, new SparseArray());
        return hashMap;
    }

    private static HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.a.a>> FL() {
        HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.tradingengine.response.a.a>> hashMap = new HashMap();
        hashMap.put(InstrumentType.CFD_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CFD_INSTRUMENT)));
        hashMap.put(InstrumentType.FOREX_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.FOREX_INSTRUMENT)));
        hashMap.put(InstrumentType.CRYPTO_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CRYPTO_INSTRUMENT)));
        return hashMap;
    }

    private static HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.f.a.a.a>> FM() {
        HashMap<InstrumentType, ConcurrentHashMap<Integer, com.iqoption.core.microservices.f.a.a.a>> hashMap = new HashMap();
        hashMap.put(InstrumentType.CRYPTO_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CRYPTO_INSTRUMENT)));
        hashMap.put(InstrumentType.CFD_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.CFD_INSTRUMENT)));
        hashMap.put(InstrumentType.FOREX_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.FOREX_INSTRUMENT)));
        hashMap.put(InstrumentType.DIGITAL_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.DIGITAL_INSTRUMENT)));
        hashMap.put(InstrumentType.BINARY_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.BINARY_INSTRUMENT)));
        hashMap.put(InstrumentType.TURBO_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.TURBO_INSTRUMENT)));
        hashMap.put(InstrumentType.FX_INSTRUMENT, new ConcurrentHashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(InstrumentType.FX_INSTRUMENT)));
        return hashMap;
    }

    public Map<Integer, com.iqoption.core.microservices.tradingengine.response.active.a> c(InstrumentType instrumentType) {
        Map<Integer, com.iqoption.core.microservices.tradingengine.response.active.a> map = (Map) this.alz.get(instrumentType);
        return map == null ? Maps.us() : map;
    }

    public ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> d(InstrumentType instrumentType) {
        Map map = (Map) this.alz.get(instrumentType);
        if (map == null) {
            return ImmutableList.sL();
        }
        return ImmutableList.m(map.values());
    }

    public Collection<com.iqoption.core.microservices.tradingengine.response.active.a> FN() {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(InstrumentType.TURBO_INSTRUMENT);
        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) this.alz.get(InstrumentType.BINARY_INSTRUMENT);
        Object hashMap = new HashMap(com.iqoption.core.microservices.tradingengine.response.active.c.D(null));
        hashMap.putAll(concurrentHashMap2);
        l.a(hashMap, concurrentHashMap, this.alE);
        return hashMap.values();
    }

    public ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> FO() {
        if (this.alF == null) {
            this.alF = i.c(this.alz.keySet()).c(new i(this)).sA();
        }
        return this.alF;
    }

    final /* synthetic */ Collection l(InstrumentType instrumentType) {
        return ((ConcurrentHashMap) this.alz.get(instrumentType)).values();
    }

    public ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> a(InstrumentType instrumentType, ActiveType activeType) {
        return i.c(((ConcurrentHashMap) this.alz.get(instrumentType)).values()).c(new j(activeType)).sA();
    }

    public ImmutableList<com.iqoption.core.microservices.tradingengine.response.active.a> a(InstrumentType instrumentType, String str) {
        return i.c(((ConcurrentHashMap) this.alz.get(instrumentType)).values()).c(new k(str)).sA();
    }

    public void a(com.iqoption.core.microservices.tradingengine.response.active.e.a aVar) {
        if (aVar != null) {
            this.alz.put(InstrumentType.BINARY_INSTRUMENT, new ConcurrentHashMap(aVar.Xm().Xp()));
            this.alz.put(InstrumentType.TURBO_INSTRUMENT, new ConcurrentHashMap(aVar.Xl().Xp()));
            if (aVar.Xn() != null) {
                com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
                for (Entry entry : aVar.Xn().entrySet()) {
                    sO.ae(new g(((Integer) entry.getKey()).intValue(), (String) entry.getValue()));
                }
                this.alD = sO.sP();
            }
        }
        this.alH = true;
        FV();
    }

    public void a(InstrumentType instrumentType, Map<Integer, com.iqoption.core.microservices.tradingengine.response.active.a> map) {
        this.alF = null;
        ((ConcurrentHashMap) this.alz.get(instrumentType)).clear();
        if (map != null) {
            ((ConcurrentHashMap) this.alz.get(instrumentType)).putAll(map);
        }
        if (InstrumentType.DIGITAL_INSTRUMENT.equals(instrumentType)) {
            this.alI = true;
        } else if (InstrumentType.CFD_INSTRUMENT.equals(instrumentType)) {
            this.alK = true;
        } else if (InstrumentType.FOREX_INSTRUMENT.equals(instrumentType)) {
            this.alN = true;
        } else if (InstrumentType.CRYPTO_INSTRUMENT.equals(instrumentType)) {
            this.alQ = true;
        } else if (InstrumentType.FX_INSTRUMENT.equals(instrumentType)) {
            this.alJ = true;
        }
        FV();
    }

    private boolean FP() {
        return !com.iqoption.app.managers.feature.a.HK() || (this.alK && this.alL && this.alM);
    }

    private boolean FQ() {
        return !com.iqoption.app.managers.feature.a.HL() || (this.alN && this.alO && this.alP);
    }

    private boolean FR() {
        return !com.iqoption.app.managers.feature.a.HM() || (this.alQ && this.alR && this.alS);
    }

    private boolean FS() {
        return !com.iqoption.app.managers.feature.a.HH() || this.alI;
    }

    private boolean FT() {
        return !com.iqoption.app.managers.feature.a.HJ() || this.alH;
    }

    private boolean FU() {
        return !com.iqoption.app.managers.feature.a.HI() || this.alJ;
    }

    public void FV() {
        if (!this.alG && FT() && FS() && FP() && FR() && FQ() && FU()) {
            this.alG = true;
            com.iqoption.app.managers.tab.a.Il().Im().IK();
        }
    }

    public boolean FW() {
        return this.alG;
    }

    public void clear() {
        this.alG = false;
        this.alH = false;
        this.alI = false;
        this.alJ = false;
        this.alK = false;
        this.alL = false;
        this.alM = true;
        this.alN = false;
        this.alO = false;
        this.alP = true;
        this.alQ = false;
        this.alR = false;
        this.alS = true;
        this.alz = FJ();
        this.alD = ImmutableList.sL();
        this.alA = FK();
        this.alB = FL();
        this.alC = FM();
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a b(InstrumentType instrumentType, String str) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(instrumentType);
        if (concurrentHashMap == null) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown option type ");
            stringBuilder.append(instrumentType);
            com.iqoption.core.i.w(str, stringBuilder.toString());
            return null;
        }
        for (com.iqoption.core.microservices.tradingengine.response.active.a aVar : concurrentHashMap.values()) {
            if (aVar.Xf().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a a(Integer num, InstrumentType instrumentType) {
        if (instrumentType == null || num == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(instrumentType);
        if (concurrentHashMap != null) {
            return (com.iqoption.core.microservices.tradingengine.response.active.a) concurrentHashMap.get(num);
        }
        return null;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a a(String str, InstrumentType instrumentType) {
        if (instrumentType == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(instrumentType);
        if (concurrentHashMap != null) {
            for (com.iqoption.core.microservices.tradingengine.response.active.a aVar : concurrentHashMap.values()) {
                if (aw.equals(str, com.iqoption.util.e.a.s(aVar))) {
                    return aVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public String cW(int i) {
        com.iqoption.core.microservices.tradingengine.response.active.a cZ = cZ(i);
        return cZ != null ? com.iqoption.util.e.a.s(cZ) : null;
    }

    public int cX(int i) {
        com.iqoption.core.microservices.tradingengine.response.active.a cZ = cZ(i);
        return cZ != null ? cZ.getPrecision() : 6;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a FX() {
        return e(com.iqoption.app.managers.tab.a.Il().Iv());
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a e(InstrumentType instrumentType) {
        if (instrumentType != null) {
            if (com.iqoption.core.ext.c.b((Object) instrumentType, InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT)) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(instrumentType);
                if (l.x(concurrentHashMap)) {
                    return null;
                }
                return (com.iqoption.core.microservices.tradingengine.response.active.a) Collections.max(ImmutableList.m(concurrentHashMap.values()), new l(af.Hu().Hw()));
            }
        }
        return null;
    }

    public void d(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        if (aVar != null && com.iqoption.app.managers.feature.b.HT().fg("top-assets") && com.iqoption.app.af.DX().Fp()) {
            com.iqoption.core.microservices.tradingengine.response.active.a FX = FX();
            if (FX != null) {
                if (!(FX.getActiveId() == aVar.getActiveId() && aVar.Xi().equals(FX.Xi()))) {
                    com.iqoption.gl.b.aow().glchTabSetBestActiveId(com.iqoption.app.managers.tab.a.Il().IE(), FX.getActiveId(), com.iqoption.util.e.a.s(FX), FX.getInstrumentType().getOptionActiveOrInstrumentValue(), 100 - FX.Xi().intValue());
                }
            }
        }
    }

    public void a(InstrumentType instrumentType, HashMap<Integer, com.iqoption.core.microservices.tradingengine.response.active.a> hashMap) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(instrumentType);
        if (concurrentHashMap == null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unknown instrumentType ");
            stringBuilder.append(instrumentType);
            com.iqoption.core.i.w(str, stringBuilder.toString());
            return;
        }
        l.a(concurrentHashMap, hashMap, this.alT);
        IQApp.Dn().aE(new d().setValue(instrumentType));
    }

    public void a(ActiveType activeType, int i, int i2) {
        com.iqoption.app.managers.tab.a.g IC = com.iqoption.app.managers.tab.a.Il().IC();
        if (IC != null) {
            InstrumentType instrumentType = IC.getInstrumentType();
            int activeId = IC.getActiveId();
            InstrumentType toInstrumentType = activeType.toInstrumentType();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alz.get(toInstrumentType);
            if (concurrentHashMap == null) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unknown option type ");
                stringBuilder.append(activeType);
                com.iqoption.core.i.w(str, stringBuilder.toString());
                return;
            }
            com.iqoption.core.microservices.tradingengine.response.active.a FX = FX();
            com.iqoption.core.microservices.tradingengine.response.active.a aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) concurrentHashMap.get(Integer.valueOf(i));
            if (aVar instanceof k) {
                ((k) aVar).dR(i2);
            }
            if (activeId == i && instrumentType == toInstrumentType) {
                IQApp.Dn().aE(new c());
                d(FX);
            }
            IQApp.Dn().aE(new b(i, activeType, i2));
        }
    }

    public void a(HashMap<Integer, int[]> hashMap, ActiveType activeType) {
        if (hashMap != null && !hashMap.isEmpty()) {
            com.iqoption.core.microservices.tradingengine.response.active.a FX = FX();
            InstrumentType toInstrumentType = activeType.toInstrumentType();
            for (Entry entry : hashMap.entrySet()) {
                com.iqoption.core.microservices.tradingengine.response.active.a a = a((Integer) entry.getKey(), toInstrumentType);
                if (a != null && (a instanceof k)) {
                    ((k) a).k((int[]) entry.getValue());
                    d(FX);
                }
            }
            IQApp.Dn().aE(new d().setValue(toInstrumentType));
        }
    }

    @Nullable
    public InstrumentType cY(int i) {
        com.iqoption.core.microservices.tradingengine.response.active.a cZ = cZ(i);
        return cZ != null ? cZ.getInstrumentType() : null;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a cZ(int i) {
        com.iqoption.core.microservices.tradingengine.response.active.a a = a(Integer.valueOf(i), InstrumentType.TURBO_INSTRUMENT);
        if (a != null) {
            return a;
        }
        a = a(Integer.valueOf(i), InstrumentType.BINARY_INSTRUMENT);
        if (a != null) {
            return a;
        }
        a = a(Integer.valueOf(i), InstrumentType.DIGITAL_INSTRUMENT);
        if (a != null) {
            return a;
        }
        a = a(Integer.valueOf(i), InstrumentType.CFD_INSTRUMENT);
        if (a != null) {
            return a;
        }
        a = a(Integer.valueOf(i), InstrumentType.FOREX_INSTRUMENT);
        if (a != null) {
            return a;
        }
        a = a(Integer.valueOf(i), InstrumentType.CRYPTO_INSTRUMENT);
        if (a != null) {
            return a;
        }
        com.iqoption.core.microservices.tradingengine.response.active.a a2 = a(Integer.valueOf(i), InstrumentType.FX_INSTRUMENT);
        return a2 != null ? a2 : null;
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a f(InstrumentType instrumentType) {
        return (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(instrumentType)).values()).e(alv).pq();
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a a(InstrumentType instrumentType, List<com.iqoption.app.managers.tab.a.g> list) {
        return (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(instrumentType)).values()).c(new m(list)).e(alv).pq();
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.active.a FY() {
        com.iqoption.core.microservices.tradingengine.response.active.a aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.CRYPTO_INSTRUMENT)).values()).e(alv).pq();
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.FOREX_INSTRUMENT)).values()).e(alv).pq();
        }
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.TURBO_INSTRUMENT)).values()).e(alv).pq();
        }
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.BINARY_INSTRUMENT)).values()).e(alv).pq();
        }
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.DIGITAL_INSTRUMENT)).values()).e(alv).pq();
        }
        if (aVar == null) {
            aVar = (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.CFD_INSTRUMENT)).values()).e(alv).pq();
        }
        return aVar == null ? (com.iqoption.core.microservices.tradingengine.response.active.a) i.c(((ConcurrentHashMap) this.alz.get(InstrumentType.FX_INSTRUMENT)).values()).e(alv).pq() : aVar;
    }

    public s<Void> FZ() {
        return com.iqoption.core.d.a.aSc.c(new n(this));
    }

    final /* synthetic */ Void Ga() {
        g(InstrumentType.CRYPTO_INSTRUMENT);
        g(InstrumentType.FOREX_INSTRUMENT);
        g(InstrumentType.CFD_INSTRUMENT);
        return null;
    }

    private void g(InstrumentType instrumentType) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("COMMISSION_STORED_");
        stringBuilder.append(instrumentType.getServerValue());
        String eR = eR(stringBuilder.toString());
        if (!TextUtils.isEmpty(eR)) {
            HashMap hashMap = (HashMap) ah.aGh().fromJson(eR, new ActiveSettingHelper$1(this).getType());
            if (hashMap != null) {
                ((ConcurrentHashMap) this.alB.get(instrumentType)).putAll(hashMap);
            }
        }
    }

    public boolean h(InstrumentType instrumentType) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("COMMISSION_STORED_");
        stringBuilder.append(instrumentType);
        return eS(stringBuilder.toString());
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.a.a a(InstrumentType instrumentType, Integer num) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.alB.get(instrumentType);
        if (concurrentHashMap == null) {
            return null;
        }
        com.iqoption.core.microservices.tradingengine.response.a.a aVar = (com.iqoption.core.microservices.tradingengine.response.a.a) concurrentHashMap.get(num);
        if (!(aVar == null || aVar.XG())) {
            aVar = null;
        }
        return aVar;
    }

    public void b(InstrumentType instrumentType, HashMap<Integer, com.iqoption.core.microservices.tradingengine.response.a.a> hashMap) {
        if (hashMap != null && instrumentType != null) {
            ((ConcurrentHashMap) this.alB.get(instrumentType)).putAll(hashMap);
            IQApp.Dn().aE(new f().setValue(instrumentType));
            com.iqoption.core.d.a.aSc.execute(new o(this, instrumentType, hashMap));
        }
    }

    final /* synthetic */ void c(InstrumentType instrumentType, HashMap hashMap) {
        a FI = FI();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("COMMISSION_STORED_");
        stringBuilder.append(instrumentType);
        String eR = FI.eR(stringBuilder.toString());
        if (!TextUtils.isEmpty(eR)) {
            HashMap hashMap2 = (HashMap) ah.aGh().fromJson(eR, new ActiveSettingHelper$2(this).getType());
            if (hashMap2 != null) {
                Map b = l.b(hashMap2, hashMap);
                if (!l.x(b)) {
                    IQApp.Dn().aE(new a(instrumentType, com.iqoption.util.c.G(b.values())));
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("COMMISSION_STORED_");
        stringBuilder2.append(instrumentType);
        FI.X(stringBuilder2.toString(), ah.aGh().toJson(FI.alB.get(instrumentType)));
    }

    @Nullable
    public com.iqoption.core.microservices.tradingengine.response.b.a a(InstrumentType instrumentType, int i) {
        SparseArray sparseArray = (SparseArray) this.alA.get(instrumentType);
        if (sparseArray == null) {
            return null;
        }
        return (com.iqoption.core.microservices.tradingengine.response.b.a) sparseArray.get(i);
    }

    public void a(InstrumentType instrumentType, @Nullable SparseArray<com.iqoption.core.microservices.tradingengine.response.b.a> sparseArray) {
        if (sparseArray != null) {
            this.alA.put(instrumentType, sparseArray);
        }
        switch (instrumentType) {
            case CFD_INSTRUMENT:
                this.alL = true;
                FV();
                return;
            case FOREX_INSTRUMENT:
                this.alO = true;
                FV();
                return;
            case CRYPTO_INSTRUMENT:
                this.alR = true;
                FV();
                return;
            default:
                return;
        }
    }

    public boolean b(ActiveType activeType) {
        return ((ConcurrentHashMap) this.alC.get(activeType.toInstrumentType())).isEmpty() ^ 1;
    }

    public boolean i(InstrumentType instrumentType) {
        return ((ConcurrentHashMap) this.alC.get(instrumentType)).isEmpty() ^ 1;
    }

    @Nullable
    public com.iqoption.core.microservices.f.a.a.a a(int i, InstrumentType instrumentType) {
        return (com.iqoption.core.microservices.f.a.a.a) ((ConcurrentHashMap) this.alC.get(instrumentType)).get(Integer.valueOf(i));
    }

    public ImmutableMap<Integer, com.iqoption.core.microservices.f.a.a.a> c(ActiveType activeType) {
        return j(activeType.toInstrumentType());
    }

    public ImmutableMap<Integer, com.iqoption.core.microservices.f.a.a.a> j(InstrumentType instrumentType) {
        return ImmutableMap.n((Map) this.alC.get(instrumentType));
    }

    public void b(InstrumentType instrumentType, @NonNull Map<Integer, com.iqoption.core.microservices.f.a.a.a> map) {
        if (instrumentType != null && instrumentType != InstrumentType.UNKNOWN && map.size() != 0) {
            l.a((Map) this.alC.get(instrumentType), map, this.alU);
            IQApp.Dn().aE(new e());
        }
    }

    public void k(InstrumentType instrumentType) {
        ag.a(com.iqoption.core.h.g.a(com.iqoption.core.microservices.f.a.aYf.w(instrumentType)), new com.iqoption.system.c.a<com.iqoption.core.microservices.f.a.a.b>() {
            /* renamed from: a */
            public void onSuccess(com.iqoption.core.microservices.f.a.a.b bVar) {
                a.this.b(bVar.getInstrumentType(), bVar.Xd());
            }
        });
    }
}
