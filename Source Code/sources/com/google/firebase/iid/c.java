package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class c {
    private static final long XX = TimeUnit.DAYS.toMillis(7);
    final String XY;
    private long timestamp;
    private String zzina;

    private c(String str, String str2, long j) {
        this.XY = str;
        this.zzina = str2;
        this.timestamp = j;
    }

    static String a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put(Param.TIMESTAMP, j);
            return jSONObject.toString();
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 24);
            stringBuilder.append("Failed to encode token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    static c cV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new c(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(Param.TIMESTAMP));
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 23);
            stringBuilder.append("Failed to parse token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    final boolean cW(String str) {
        return System.currentTimeMillis() > this.timestamp + XX || !str.equals(this.zzina);
    }
}
