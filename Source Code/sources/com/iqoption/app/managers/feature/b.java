package com.iqoption.app.managers.feature;

import android.annotation.SuppressLint;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.common.base.Suppliers;
import com.google.common.base.e;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.a;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.i;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.util.l;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.dto.entity.Feature;
import com.iqoption.dto.entity.Feature.Key;
import com.iqoption.dto.entity.Feature.Result;
import com.iqoption.dto.entity.Feature.UpdateEvent;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.api.f;
import com.iqoption.service.websocket.IQBusException;
import com.iqoption.util.ag;
import com.iqoption.util.ah;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

/* compiled from: FeaturesToggledManager */
public class b {
    private static final String TAG = "com.iqoption.app.managers.feature.b";
    private static ImmutableMap<String, String> aot = ImmutableMap.sT();
    private static ImmutableSet<String> aou = ImmutableSet.ts().ae("fake-digital").ae("digital-instrument").ae("cfd-instrument").ae("binary-instrument").ae("forex-instrument").ae("crypto-instrument").ae("fx-options-instrument").ae("tournaments").tt();
    private static ImmutableSet<String> aov = ImmutableSet.ts().ae("").tt();
    private static ImmutableMap<String, Integer> aow = ImmutableMap.sU().r("price-movements", Integer.valueOf(3)).r("kyc-show-after-registration", Integer.valueOf(2)).r("video-education", Integer.valueOf(2)).r("otn-leaderboard", Integer.valueOf(2)).r("pending-order", Integer.valueOf(2)).r("margin-add-on", Integer.valueOf(4)).r("ws-new-lib", Integer.valueOf(2)).r("iq-quiz", Integer.valueOf(5)).r("fx-options-instrument", Integer.valueOf(2)).r("analytics-presets", Integer.valueOf(2)).r("select-registration-country", Integer.valueOf(2)).r("show-social-login", Integer.valueOf(2)).r("experimental-deposit-page", Integer.valueOf(1)).tc();
    private static final n<b> aoy = Suppliers.a(f.ajD);
    @SerializedName("features")
    private final ConcurrentMap<Key, Feature> aox = Maps.ut();
    private volatile s<?> aoz;

    public String eY(String str) {
        Feature fd = fd(str);
        return (fd == null || fd.status == null) ? "disabled" : fd.status;
    }

    private void HS() {
        a aVar = new a();
        Iterator sI = aou.iterator();
        while (sI.hasNext()) {
            String str = (String) sI.next();
            aVar.r(str, eY(str));
        }
        aot = aVar.tc();
    }

    protected static boolean fa(String str) {
        return "disabled".equalsIgnoreCase(str) ^ 1;
    }

    public static String fb(String str) {
        return (String) e.h(aov.contains(str) ? "disabled" : (String) aot.get(str), "disabled");
    }

    protected static int fc(String str) {
        return ((Integer) e.h(aow.get(str), Integer.valueOf(1))).intValue();
    }

    public static synchronized b HT() {
        b bVar;
        synchronized (b.class) {
            bVar = (b) aoy.get();
        }
        return bVar;
    }

    public synchronized s<?> HU() {
        if (this.aoz != null) {
            return this.aoz;
        }
        this.aoz = com.iqoption.core.d.a.aSc.i(new c(this));
        return this.aoz;
    }

    private synchronized void init() {
        String string = IQApp.Dk().getSharedPreferences("features_manager_pref_name", 0).getString("features_manager_pref_json", "");
        if (!TextUtils.isEmpty(string)) {
            a((Feature[]) ah.aGh().fromJson(string, Feature[].class));
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public synchronized void save() {
        com.iqoption.core.d.a.aSc.execute(new d(this));
    }

    final /* synthetic */ void Ib() {
        IQApp.Dk().getSharedPreferences("features_manager_pref_name", 0).edit().putString("features_manager_pref_json", ah.aGh().toJson(i.c(this.aox.values()).l(Feature.class))).commit();
    }

    private synchronized void clear() {
        IQApp.Dk().getSharedPreferences("features_manager_pref_name", 0).edit().putString("features_manager_pref_json", "").apply();
    }

    public synchronized void HV() {
        this.aox.clear();
        clear();
    }

    public ImmutableList<Feature> a(Feature[] featureArr) {
        for (Feature feature : featureArr) {
            Key obtain = Feature.obtain(feature.name, feature.version);
            if (this.aox.containsKey(obtain)) {
                this.aox.put(obtain, feature);
            } else {
                this.aox.put(new Key(feature.name, feature.version), feature);
            }
            obtain.recycle();
        }
        HS();
        return HX();
    }

    public static void bx(boolean z) {
        af.DX().DY().edit().putBoolean("debug_mode", z).apply();
    }

    public static boolean HW() {
        return af.DX().DY().getBoolean("debug_mode", false);
    }

    public ImmutableList<Feature> HX() {
        return i.c(this.aox.values()).sA();
    }

    public Feature fd(String str) {
        return aov.contains(str) ? null : v(str, fc(str));
    }

    public Feature fe(String str) {
        Feature feature = null;
        if (aov.contains(str)) {
            return null;
        }
        int fc = fc(str);
        int i = fc + 1;
        while (feature == null && i <= fc + 10) {
            feature = v(str, i);
            i++;
        }
        return feature;
    }

    private Feature v(String str, int i) {
        Feature w = w(str, i);
        return w == null ? x(str, i) : w;
    }

    private Feature w(String str, int i) {
        if (l.x(this.aox)) {
            return null;
        }
        Key obtain = Feature.obtain(str, i);
        Feature feature = (Feature) this.aox.get(obtain);
        obtain.recycle();
        return feature;
    }

    private com.iqoption.dto.entity.Feature x(java.lang.String r2, int r3) {
        /*
        r1 = this;
        r0 = r2.hashCode();
        switch(r0) {
            case -1918590323: goto L_0x0044;
            case -1306705706: goto L_0x003a;
            case -40334142: goto L_0x0030;
            case 113960: goto L_0x0026;
            case 229040601: goto L_0x001c;
            case 1127659230: goto L_0x0012;
            case 1500950221: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x004e;
    L_0x0008:
        r0 = "DEPRECATED-kyc-questionnaire-microservice";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x0010:
        r2 = 4;
        goto L_0x004f;
    L_0x0012:
        r0 = "splash-log";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x001a:
        r2 = 1;
        goto L_0x004f;
    L_0x001c:
        r0 = "show-social-login";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x0024:
        r2 = 6;
        goto L_0x004f;
    L_0x0026:
        r0 = "sla";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x002e:
        r2 = 2;
        goto L_0x004f;
    L_0x0030:
        r0 = "kyc-show-after-registration";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x0038:
        r2 = 0;
        goto L_0x004f;
    L_0x003a:
        r0 = "video-education";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x0042:
        r2 = 3;
        goto L_0x004f;
    L_0x0044:
        r0 = "more-trading-opportunities";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x004e;
    L_0x004c:
        r2 = 5;
        goto L_0x004f;
    L_0x004e:
        r2 = -1;
    L_0x004f:
        switch(r2) {
            case 0: goto L_0x008a;
            case 1: goto L_0x0081;
            case 2: goto L_0x0078;
            case 3: goto L_0x006f;
            case 4: goto L_0x0066;
            case 5: goto L_0x005d;
            case 6: goto L_0x0054;
            default: goto L_0x0052;
        };
    L_0x0052:
        r2 = 0;
        return r2;
    L_0x0054:
        r2 = "show-social-login";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x005d:
        r2 = "more-trading-opportunities";
        r0 = "disabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x0066:
        r2 = "DEPRECATED-kyc-questionnaire-microservice";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x006f:
        r2 = "video-education";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x0078:
        r2 = "sla";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x0081:
        r2 = "splash-log";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
    L_0x008a:
        r2 = "kyc-show-after-registration";
        r0 = "enabled";
        r2 = com.iqoption.dto.entity.Feature.createFeature(r2, r0, r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.feature.b.x(java.lang.String, int):com.iqoption.dto.entity.Feature");
    }

    public boolean ff(String str) {
        return a(fd(str), false);
    }

    public boolean fg(String str) {
        return a(fd(str), true);
    }

    private boolean a(Feature feature, boolean z) {
        return (feature == null || feature.status == null) ? z : fa(feature.status);
    }

    public static boolean HY() {
        return af.DX().Fz();
    }

    public static s<?> HZ() {
        return com.iqoption.core.d.a.aSd.i(e.alc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0110  */
    static final /* synthetic */ void Ia() {
        /*
        r0 = "system";
        r1 = "feature-toggling_request";
        r0 = com.iqoption.dto.Event.Builder(r0, r1);
        r1 = com.iqoption.app.IQApp.Dk();
        r1 = com.iqoption.mobbtech.connect.RequestManager.bC(r1);
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "category";
        r4 = "android-x";
        r2.put(r3, r4);
        r3 = com.iqoption.app.af.DX();
        r3 = r3.FA();
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x002a:
        r4 = "identity";
        r2.put(r4, r3);
    L_0x002f:
        r3 = 0;
        r4 = "features.";
        r5 = "api/v2/features";
        r4 = com.iqoption.mobbtech.connect.RequestManager.ar(r4, r5);	 Catch:{ Exception -> 0x00f1 }
        r5 = com.iqoption.app.IQApp.Dk();	 Catch:{ Exception -> 0x00f1 }
        r2 = com.iqoption.mobbtech.connect.RequestManager.a(r4, r2, r5);	 Catch:{ Exception -> 0x00f1 }
        r4 = TAG;	 Catch:{ Exception -> 0x00f1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f1 }
        r5.<init>();	 Catch:{ Exception -> 0x00f1 }
        r6 = "ApiPath call ";
        r5.append(r6);	 Catch:{ Exception -> 0x00f1 }
        r6 = r2.url();	 Catch:{ Exception -> 0x00f1 }
        r5.append(r6);	 Catch:{ Exception -> 0x00f1 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00f1 }
        com.iqoption.core.i.v(r4, r5);	 Catch:{ Exception -> 0x00f1 }
        r4 = com.iqoption.mobbtech.connect.RequestManager.atO();	 Catch:{ Exception -> 0x00f1 }
        r4 = r4.atQ();	 Catch:{ Exception -> 0x00f1 }
        r2 = r4.newCall(r2);	 Catch:{ Exception -> 0x00f1 }
        r2 = r2.execute();	 Catch:{ Exception -> 0x00f1 }
        r3 = r2.body();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        if (r3 != 0) goto L_0x0073;
    L_0x0070:
        r3 = "";
        goto L_0x0077;
    L_0x0073:
        r3 = r3.string();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
    L_0x0077:
        r4 = com.iqoption.core.util.i.ZZ();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r5 = "aff";
        r1 = r4.l(r5, r1);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r4 = "response_code";
        r5 = r2.code();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = r1.l(r4, r5);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r4 = "response";
        r1 = r1.l(r4, r3);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = r1.aab();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0.setParameters(r1);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = com.iqoption.analytics.EventManager.Bm();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0 = r0.calcDuration();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0 = r0.setTechnicalLogs(r4);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0 = r0.build();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1.a(r0);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0 = r2.isSuccessful();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        if (r0 != 0) goto L_0x00d1;
    L_0x00ba:
        r0 = new java.io.IOException;	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1.<init>();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r3 = "Unexpected code ";
        r1.append(r3);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1.append(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        throw r0;	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
    L_0x00d1:
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        if (r0 == 0) goto L_0x00df;
    L_0x00d7:
        r0 = new org.json.JSONException;	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        r1 = "Null string error.";
        r0.<init>(r1);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        throw r0;	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
    L_0x00df:
        r0 = 0;
        j(r3, r0);	 Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        if (r2 == 0) goto L_0x010d;
    L_0x00e5:
        r2.close();
        goto L_0x010d;
    L_0x00e9:
        r0 = move-exception;
        goto L_0x010e;
    L_0x00eb:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00f2;
    L_0x00ee:
        r0 = move-exception;
        r2 = r3;
        goto L_0x010e;
    L_0x00f1:
        r0 = move-exception;
    L_0x00f2:
        r1 = TAG;	 Catch:{ all -> 0x00ee }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ee }
        r2.<init>();	 Catch:{ all -> 0x00ee }
        r4 = "error when getting features ";
        r2.append(r4);	 Catch:{ all -> 0x00ee }
        r2.append(r0);	 Catch:{ all -> 0x00ee }
        r2 = r2.toString();	 Catch:{ all -> 0x00ee }
        com.iqoption.core.i.e(r1, r2, r0);	 Catch:{ all -> 0x00ee }
        if (r3 == 0) goto L_0x010d;
    L_0x010a:
        r3.close();
    L_0x010d:
        return;
    L_0x010e:
        if (r2 == 0) goto L_0x0113;
    L_0x0110:
        r2.close();
    L_0x0113:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.app.managers.feature.b.Ia():void");
    }

    @WorkerThread
    public static void j(String str, boolean z) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "feature-toggling_server_response").setParameters(com.iqoption.core.util.i.b.aaa().l("response", str).aab()).setTechnicalLogs(Boolean.valueOf(true)).build());
        Result result = (Result) ah.aGh().fromJson(str, Result.class);
        if (result != null) {
            af.DX().eK(result.identity);
            if (z) {
                af.DX().bq(true);
            }
            b(result.features);
            HT().save();
        }
    }

    @WorkerThread
    public static void a(JsonReader jsonReader) {
        EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "feature-toggling_server_update").setParameters(com.iqoption.core.util.i.b.aaa().l("update", ((Feature) ah.aGh().fromJson(jsonReader, (Type) Feature.class)).toEventString()).aab()).setTechnicalLogs(Boolean.valueOf(true)).build());
        a(y.wb());
    }

    @WorkerThread
    private static void b(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Object a = HT().a(featureArr);
            if (!com.iqoption.util.i.H(a)) {
                IQApp.Dn().aE(new UpdateEvent(a));
            }
            EventManager.Bm().a(Event.Builder(Event.CATEGORY_SYSTEM, "feature-toggling_actual").setParameters(ah.aGh().toJsonTree(a).getAsJsonArray()).setTechnicalLogs(Boolean.valueOf(true)).build());
        }
    }

    public static void a(final y<Object> yVar) {
        final Builder Builder = Event.Builder(Event.CATEGORY_SYSTEM, "feature-toggling_bus_request");
        ag.a(f.aux(), new com.google.common.util.concurrent.n<JsonElement>() {
            /* renamed from: b */
            public void onSuccess(JsonElement jsonElement) {
                if (jsonElement != null) {
                    String jsonElement2 = jsonElement.toString();
                    b.j(jsonElement2, true);
                    Builder.setParameters(com.iqoption.core.util.i.ZZ().l("aff", RequestManager.bC(IQApp.Dk())).l("response", jsonElement2).aab());
                    EventManager.Bm().a(Builder.calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                }
                com.iqoption.core.i.i(b.TAG, "future receive(2!) success");
                yVar.P(Boolean.valueOf(true));
            }

            public void l(Throwable th) {
                com.iqoption.core.i.e(b.TAG, "future receive(2!) error", th);
                String bC = RequestManager.bC(IQApp.Dk());
                if (th instanceof IQBusException) {
                    IQBusException iQBusException = (IQBusException) th;
                    Builder.setParameters(com.iqoption.core.util.i.ZZ().l("aff", bC).l("response_code", Integer.valueOf(iQBusException.status)).l("response", iQBusException.socketMessage).aab());
                } else {
                    Builder.setParameters(com.iqoption.core.util.i.ZZ().l("aff", bC).l("response_code", Integer.valueOf(-1)).l("response", "error").aab());
                }
                EventManager.Bm().a(Builder.calcDuration().setTechnicalLogs(Boolean.valueOf(true)).build());
                if (b.HY()) {
                    yVar.P(Boolean.valueOf(false));
                } else {
                    yVar.h(th);
                }
            }
        });
    }
}
