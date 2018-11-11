package com.iqoption.service.websocket.a;

import android.text.TextUtils;
import com.google.common.util.concurrent.y;
import com.iqoption.mobbtech.connect.request.a.a.b;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SubscribeMessageIQBusRequest */
class d extends a {
    d(String str, Map<String, Object> map) {
        super("subscribeMessage", str, map, 15000);
    }

    d(b bVar, y yVar, String str, Map<String, Object> map) {
        super("subscribeMessage", bVar, yVar, str, (Map) map, 15000);
    }

    public JSONObject aDH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.apiName);
            jSONObject.put("version", this.version);
            if (!TextUtils.isEmpty(this.cUR)) {
                jSONObject.put("microserviceName", this.cUR);
            }
            if (!(this.anH == null || this.anH.isEmpty())) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                for (Entry entry : this.anH.entrySet()) {
                    jSONObject3.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject2.put("routingFilters", jSONObject3);
                jSONObject.put("params", jSONObject2);
            }
        } catch (JSONException unused) {
            return jSONObject;
        }
    }
}
