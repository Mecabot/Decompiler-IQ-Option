package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient.c;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginLogger */
class i {
    private final AppEventsLogger Gy;
    private String Gz;
    private String applicationId;

    i(Context context, String str) {
        this.applicationId = str;
        this.Gy = AppEventsLogger.o(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0);
                if (packageInfo != null) {
                    this.Gz = packageInfo.versionName;
                }
            }
        } catch (NameNotFoundException unused) {
        }
    }

    public String it() {
        return this.applicationId;
    }

    static Bundle bV(String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", str);
        bundle.putString("3_method", "");
        bundle.putString("2_result", "");
        bundle.putString("5_error_message", "");
        bundle.putString("4_error_code", "");
        bundle.putString("6_extras", "");
        return bundle;
    }

    public void g(c cVar) {
        Bundle bV = bV(cVar.nt());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", cVar.nr().toString());
            jSONObject.put("request_code", LoginClient.nd());
            jSONObject.put("permissions", TextUtils.join(",", cVar.ip()));
            jSONObject.put("default_audience", cVar.ns().toString());
            jSONObject.put("isReauthorize", cVar.nu());
            if (this.Gz != null) {
                jSONObject.put("facebookVersion", this.Gz);
            }
            bV.putString("6_extras", jSONObject.toString());
        } catch (JSONException unused) {
            this.Gy.a("fb_mobile_login_start", null, bV);
        }
    }

    public void a(String str, Map<String, String> map, Code code, Map<String, String> map2, Exception exception) {
        Bundle bV = bV(str);
        if (code != null) {
            bV.putString("2_result", code.getLoggingValue());
        }
        if (!(exception == null || exception.getMessage() == null)) {
            bV.putString("5_error_message", exception.getMessage());
        }
        JSONObject jSONObject = !map.isEmpty() ? new JSONObject(map) : null;
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Entry entry : map2.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                if (jSONObject != null) {
                    bV.putString("6_extras", jSONObject.toString());
                }
                this.Gy.a("fb_mobile_login_complete", null, bV);
            }
        }
    }

    public void G(String str, String str2) {
        Bundle bV = bV(str);
        bV.putString("3_method", str2);
        this.Gy.a("fb_mobile_login_method_start", null, bV);
    }

    public void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Bundle bV = bV(str);
        if (str3 != null) {
            bV.putString("2_result", str3);
        }
        if (str4 != null) {
            bV.putString("5_error_message", str4);
        }
        if (str5 != null) {
            bV.putString("4_error_code", str5);
        }
        if (!(map == null || map.isEmpty())) {
            bV.putString("6_extras", new JSONObject(map).toString());
        }
        bV.putString("3_method", str2);
        this.Gy.a("fb_mobile_login_method_complete", null, bV);
    }

    public void H(String str, String str2) {
        Bundle bV = bV(str);
        bV.putString("3_method", str2);
        this.Gy.a("fb_mobile_login_method_not_tried", null, bV);
    }

    public void I(String str, String str2) {
        d(str, str2, "");
    }

    public void d(String str, String str2, String str3) {
        Bundle bV = bV("");
        bV.putString("2_result", Code.ERROR.getLoggingValue());
        bV.putString("5_error_message", str2);
        bV.putString("3_method", str3);
        this.Gy.a(str, null, bV);
    }
}
