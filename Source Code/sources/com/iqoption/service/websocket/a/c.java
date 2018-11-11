package com.iqoption.service.websocket.a;

import android.text.TextUtils;
import com.google.common.util.concurrent.y;
import com.iqoption.core.util.i;
import com.iqoption.mobbtech.connect.request.a.a.b;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SendMessageIQBusRequest */
class c extends a {
    c(String str, Map<String, Object> map) {
        super("sendMessage", str, map, 15000);
    }

    c(b bVar, y yVar, String str, Map<String, Object> map) {
        super("sendMessage", bVar, yVar, str, (Map) map, 15000);
    }

    c(b bVar, y yVar, String str, JSONObject jSONObject) {
        super("sendMessage", bVar, yVar, str, jSONObject, 15000);
    }

    public JSONObject aDH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.apiName);
            jSONObject.put("version", this.version);
            if (!TextUtils.isEmpty(this.cUR)) {
                jSONObject.put("microserviceName", this.cUR);
            }
            if (this.cVl != null) {
                jSONObject.put("body", this.cVl);
            } else if (this.anH == null || this.anH.isEmpty()) {
                jSONObject.put("body", new JSONObject());
            } else {
                JSONObject jSONObject2 = new JSONObject();
                for (Entry entry : this.anH.entrySet()) {
                    Object value = entry.getValue();
                    Object wrap = i.wrap(value);
                    if (wrap == null && value != null) {
                        wrap = value.toString();
                    }
                    jSONObject2.put((String) entry.getKey(), wrap);
                }
                jSONObject.put("body", jSONObject2);
            }
        } catch (JSONException unused) {
            return jSONObject;
        }
    }
}
