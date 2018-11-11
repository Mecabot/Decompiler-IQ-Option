package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.h;
import com.facebook.i;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FetchedAppGateKeepersManager */
public class k {
    private static final Map<String, JSONObject> Cy = new ConcurrentHashMap();
    private static final String TAG = k.class.getCanonicalName();

    public static synchronized void lE() {
        synchronized (k.class) {
            final Context applicationContext = h.getApplicationContext();
            final String it = h.it();
            final String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", new Object[]{it});
            h.getExecutor().execute(new Runnable() {
                public void run() {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0);
                    JSONObject jSONObject = null;
                    String string = sharedPreferences.getString(format, null);
                    if (!w.bc(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (Exception e) {
                            w.a("FacebookSDK", e);
                        }
                        if (jSONObject != null) {
                            k.a(it, jSONObject);
                        }
                    }
                    JSONObject bE = k.bD(it);
                    if (bE != null) {
                        k.a(it, bE);
                        sharedPreferences.edit().putString(format, bE.toString()).apply();
                    }
                }
            });
        }
    }

    public static boolean a(String str, String str2, boolean z) {
        return (str == null || !Cy.containsKey(str)) ? z : ((JSONObject) Cy.get(str)).optBoolean(str2, z);
    }

    private static JSONObject bD(String str) {
        Bundle bundle = new Bundle();
        b Y = b.Y(h.getApplicationContext());
        String str2 = "";
        if (!(Y == null || Y.lx() == null)) {
            str2 = Y.lx();
        }
        String ja = h.ja();
        bundle.putString("platform", "android");
        bundle.putString("device_id", str2);
        bundle.putString("sdk_version", ja);
        bundle.putString("fields", "gatekeepers");
        i a = i.a(null, String.format("%s/%s", new Object[]{str, "mobile_sdk_gk"}), null);
        a.I(true);
        a.setParameters(bundle);
        return a.jq().jK();
    }

    private static void a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (Cy.containsKey(str)) {
            jSONObject2 = (JSONObject) Cy.get(str);
        } else {
            jSONObject2 = new JSONObject();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        JSONObject jSONObject3 = null;
        int i = 0;
        if (optJSONArray != null) {
            jSONObject3 = optJSONArray.optJSONObject(0);
        }
        if (!(jSONObject3 == null || jSONObject3.optJSONArray("gatekeepers") == null)) {
            optJSONArray = jSONObject3.optJSONArray("gatekeepers");
            while (i < optJSONArray.length()) {
                try {
                    jSONObject3 = optJSONArray.getJSONObject(i);
                    jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean(b.VALUE));
                } catch (Exception e) {
                    w.a("FacebookSDK", e);
                }
                i++;
            }
        }
        Cy.put(str, jSONObject2);
    }
}
