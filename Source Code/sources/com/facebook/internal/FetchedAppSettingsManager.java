package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.internal.c;
import com.facebook.appevents.internal.d;
import com.facebook.appevents.internal.e;
import com.facebook.h;
import com.facebook.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FetchedAppSettingsManager {
    private static final String[] Dq = new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "gdpv4_chrome_custom_tabs_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "auto_event_setup_enabled", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url"};
    private static final Map<String, l> Dr = new ConcurrentHashMap();
    private static final AtomicReference<FetchAppSettingState> Ds = new AtomicReference(FetchAppSettingState.NOT_LOADED);
    private static final ConcurrentLinkedQueue<a> Dt = new ConcurrentLinkedQueue();
    private static boolean Du = false;
    private static final String TAG = FetchedAppSettingsManager.class.getCanonicalName();

    enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    public interface a {
        void a(l lVar);

        void onError();
    }

    public static synchronized void lP() {
        synchronized (FetchedAppSettingsManager.class) {
            final Context applicationContext = h.getApplicationContext();
            final String it = h.it();
            if (w.bc(it)) {
                Ds.set(FetchAppSettingState.ERROR);
                lQ();
            } else if (Dr.containsKey(it)) {
                Ds.set(FetchAppSettingState.SUCCESS);
                lQ();
            } else {
                Object obj = (Ds.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || Ds.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING)) ? 1 : null;
                if (obj == null) {
                    lQ();
                    return;
                }
                final String format = String.format("com.facebook.internal.APP_SETTINGS.%s", new Object[]{it});
                h.getExecutor().execute(new Runnable() {
                    public void run() {
                        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                        l lVar = null;
                        String string = sharedPreferences.getString(format, null);
                        if (!w.bc(string)) {
                            JSONObject jSONObject;
                            try {
                                jSONObject = new JSONObject(string);
                            } catch (Exception e) {
                                w.a("FacebookSDK", e);
                                jSONObject = null;
                            }
                            if (jSONObject != null) {
                                lVar = FetchedAppSettingsManager.c(it, jSONObject);
                            }
                        }
                        JSONObject bE = FetchedAppSettingsManager.bG(it);
                        if (bE != null) {
                            FetchedAppSettingsManager.c(it, bE);
                            sharedPreferences.edit().putString(format, bE.toString()).apply();
                        }
                        if (lVar != null) {
                            String lN = lVar.lN();
                            if (!(FetchedAppSettingsManager.Du || lN == null || lN.length() <= 0)) {
                                FetchedAppSettingsManager.Du = true;
                                Log.w(FetchedAppSettingsManager.TAG, lN);
                            }
                        }
                        c.kZ();
                        e.update();
                        FetchedAppSettingsManager.Ds.set(FetchedAppSettingsManager.Dr.containsKey(it) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
                        FetchedAppSettingsManager.lQ();
                    }
                });
            }
        }
    }

    public static l bF(String str) {
        return str != null ? (l) Dr.get(str) : null;
    }

    /* JADX WARNING: Missing block: B:23:0x0070, code:
            return;
     */
    private static synchronized void lQ() {
        /*
        r0 = com.facebook.internal.FetchedAppSettingsManager.class;
        monitor-enter(r0);
        r1 = Ds;	 Catch:{ all -> 0x0071 }
        r1 = r1.get();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState) r1;	 Catch:{ all -> 0x0071 }
        r2 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED;	 Catch:{ all -> 0x0071 }
        r2 = r2.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r2 != 0) goto L_0x006f;
    L_0x0013:
        r2 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.LOADING;	 Catch:{ all -> 0x0071 }
        r2 = r2.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r2 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x006f;
    L_0x001c:
        r2 = com.facebook.h.it();	 Catch:{ all -> 0x0071 }
        r3 = Dr;	 Catch:{ all -> 0x0071 }
        r2 = r3.get(r2);	 Catch:{ all -> 0x0071 }
        r2 = (com.facebook.internal.l) r2;	 Catch:{ all -> 0x0071 }
        r3 = new android.os.Handler;	 Catch:{ all -> 0x0071 }
        r4 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0071 }
        r3.<init>(r4);	 Catch:{ all -> 0x0071 }
        r4 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR;	 Catch:{ all -> 0x0071 }
        r1 = r4.equals(r1);	 Catch:{ all -> 0x0071 }
        if (r1 == 0) goto L_0x0054;
    L_0x0039:
        r1 = Dt;	 Catch:{ all -> 0x0071 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x0052;
    L_0x0041:
        r1 = Dt;	 Catch:{ all -> 0x0071 }
        r1 = r1.poll();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.FetchedAppSettingsManager.a) r1;	 Catch:{ all -> 0x0071 }
        r2 = new com.facebook.internal.FetchedAppSettingsManager$2;	 Catch:{ all -> 0x0071 }
        r2.<init>(r1);	 Catch:{ all -> 0x0071 }
        r3.post(r2);	 Catch:{ all -> 0x0071 }
        goto L_0x0039;
    L_0x0052:
        monitor-exit(r0);
        return;
    L_0x0054:
        r1 = Dt;	 Catch:{ all -> 0x0071 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x006d;
    L_0x005c:
        r1 = Dt;	 Catch:{ all -> 0x0071 }
        r1 = r1.poll();	 Catch:{ all -> 0x0071 }
        r1 = (com.facebook.internal.FetchedAppSettingsManager.a) r1;	 Catch:{ all -> 0x0071 }
        r4 = new com.facebook.internal.FetchedAppSettingsManager$3;	 Catch:{ all -> 0x0071 }
        r4.<init>(r1, r2);	 Catch:{ all -> 0x0071 }
        r3.post(r4);	 Catch:{ all -> 0x0071 }
        goto L_0x0054;
    L_0x006d:
        monitor-exit(r0);
        return;
    L_0x006f:
        monitor-exit(r0);
        return;
    L_0x0071:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.lQ():void");
    }

    /* JADX WARNING: Missing block: B:21:0x003b, code:
            return r3;
     */
    public static synchronized com.facebook.internal.l f(java.lang.String r2, boolean r3) {
        /*
        r0 = com.facebook.internal.FetchedAppSettingsManager.class;
        monitor-enter(r0);
        if (r3 != 0) goto L_0x0019;
    L_0x0005:
        r3 = Dr;	 Catch:{ all -> 0x0017 }
        r3 = r3.containsKey(r2);	 Catch:{ all -> 0x0017 }
        if (r3 == 0) goto L_0x0019;
    L_0x000d:
        r3 = Dr;	 Catch:{ all -> 0x0017 }
        r2 = r3.get(r2);	 Catch:{ all -> 0x0017 }
        r2 = (com.facebook.internal.l) r2;	 Catch:{ all -> 0x0017 }
        monitor-exit(r0);
        return r2;
    L_0x0017:
        r2 = move-exception;
        goto L_0x003c;
    L_0x0019:
        r3 = bG(r2);	 Catch:{ all -> 0x0017 }
        if (r3 != 0) goto L_0x0022;
    L_0x001f:
        r2 = 0;
        monitor-exit(r0);
        return r2;
    L_0x0022:
        r3 = c(r2, r3);	 Catch:{ all -> 0x0017 }
        r1 = com.facebook.h.it();	 Catch:{ all -> 0x0017 }
        r2 = r2.equals(r1);	 Catch:{ all -> 0x0017 }
        if (r2 == 0) goto L_0x003a;
    L_0x0030:
        r2 = Ds;	 Catch:{ all -> 0x0017 }
        r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.SUCCESS;	 Catch:{ all -> 0x0017 }
        r2.set(r1);	 Catch:{ all -> 0x0017 }
        lQ();	 Catch:{ all -> 0x0017 }
    L_0x003a:
        monitor-exit(r0);
        return r3;
    L_0x003c:
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.f(java.lang.String, boolean):com.facebook.internal.l");
    }

    private static l c(String str, JSONObject jSONObject) {
        h lB;
        JSONObject jSONObject2 = jSONObject;
        JSONArray optJSONArray = jSONObject2.optJSONArray("android_sdk_error_categories");
        if (optJSONArray == null) {
            lB = h.lB();
        } else {
            lB = h.d(optJSONArray);
        }
        h hVar = lB;
        int optInt = jSONObject2.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean optBoolean = jSONObject2.optBoolean("auto_event_setup_enabled", false);
        optJSONArray = jSONObject2.optJSONArray("auto_event_mapping_android");
        if (optJSONArray != null && o.md()) {
            com.facebook.appevents.codeless.internal.c.bs(optJSONArray.toString());
        }
        boolean optBoolean2 = jSONObject2.optBoolean("supports_implicit_sdk_logging", false);
        String optString = jSONObject2.optString("gdpv4_nux_content", "");
        boolean optBoolean3 = jSONObject2.optBoolean("gdpv4_nux_enabled", false);
        boolean optBoolean4 = jSONObject2.optBoolean("gdpv4_chrome_custom_tabs_enabled", false);
        int optInt2 = jSONObject2.optInt("app_events_session_timeout", d.lb());
        EnumSet parseOptions = SmartLoginOption.parseOptions(jSONObject2.optLong("seamless_login"));
        Map j = j(jSONObject2.optJSONObject("android_dialog_configs"));
        String optString2 = jSONObject2.optString("smart_login_bookmark_icon_url");
        String optString3 = jSONObject2.optString("smart_login_menu_icon_url");
        String optString4 = jSONObject2.optString("sdk_update_message");
        l lVar = r2;
        l lVar2 = new l(optBoolean2, optString, optBoolean3, optBoolean4, optInt2, parseOptions, j, z, hVar, optString2, optString3, z2, z3, optJSONArray, optString4, z4, optBoolean);
        Dr.put(str, lVar);
        return lVar;
    }

    private static JSONObject bG(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(Dq))));
        try {
            Class.forName("com.facebook.marketing.b");
            b Y = b.Y(h.getApplicationContext());
            if (!(Y == null || Y.lx() == null)) {
                bundle.putString("advertiser_id", Y.lx());
            }
        } catch (ClassNotFoundException unused) {
            i a = i.a(null, str, null);
            a.I(true);
            a.setParameters(bundle);
            return a.jq().jK();
        }
    }

    private static Map<String, Map<String, com.facebook.internal.l.a>> j(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.facebook.internal.l.a i2 = com.facebook.internal.l.a.i(optJSONArray.optJSONObject(i));
                    if (i2 != null) {
                        String lO = i2.lO();
                        Map map = (Map) hashMap.get(lO);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(lO, map);
                        }
                        map.put(i2.getFeatureName(), i2);
                    }
                }
            }
        }
        return hashMap;
    }
}
