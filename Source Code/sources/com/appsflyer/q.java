package com.appsflyer;

import android.support.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class q {
    @Nullable
    static JSONObject az(String str) {
        JSONObject jSONObject;
        Throwable th;
        try {
            jSONObject = new JSONObject(str);
            try {
                if (jSONObject.optBoolean("monitor", false)) {
                    ah.ge().fO();
                } else {
                    ah.ge().gh();
                    ah.ge().fz();
                }
            } catch (JSONException unused) {
                ah.ge().gh();
                ah.ge().fz();
            } catch (Throwable th2) {
                th = th2;
                AFLogger.a(th.getMessage(), th);
                ah.ge().gh();
                ah.ge().fz();
            }
        } catch (JSONException unused2) {
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            jSONObject = null;
            AFLogger.a(th.getMessage(), th);
            ah.ge().gh();
            ah.ge().fz();
            return jSONObject;
        }
        return jSONObject;
    }

    public static String aA(String str) {
        return String.format(str, new Object[]{h.fA().getHost()});
    }
}
