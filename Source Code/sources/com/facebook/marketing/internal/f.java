package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.HttpMethod;
import com.facebook.h;
import com.facebook.i;
import com.facebook.internal.b;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RemoteConfigManager */
public class f {
    private static final Map<String, e> Hv = new ConcurrentHashMap();
    private static final String TAG = f.class.getCanonicalName();

    public static void nO() {
        h.getExecutor().execute(new Runnable() {
            public void run() {
                Context applicationContext = h.getApplicationContext();
                String it = h.it();
                b Y = b.Y(applicationContext);
                if (Y != null && Y.lx() != null) {
                    JSONObject K = f.J(it, Y.lx());
                    if (K != null) {
                        f.f(it, K);
                    }
                }
            }
        });
    }

    public static e cd(String str) {
        return str != null ? (e) Hv.get(str) : null;
    }

    private static JSONObject J(String str, String str2) {
        try {
            String format = String.format(Locale.US, "%s/button_auto_detection_device_selection", new Object[]{str});
            Bundle bundle = new Bundle();
            bundle.putString("device_id", str2);
            bundle.putString("fields", "is_selected");
            i iVar = new i(null, format, bundle, HttpMethod.GET, null);
            iVar.I(true);
            return iVar.jq().jK();
        } catch (Throwable e) {
            Log.e(TAG, "fail to request button sampling api", e);
            return new JSONObject();
        }
    }

    private static void f(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            jSONObject = optJSONArray.optJSONObject(0);
            if (jSONObject != null) {
                Hv.put(str, new e(jSONObject.optBoolean("is_selected", false)));
            }
        }
    }
}
