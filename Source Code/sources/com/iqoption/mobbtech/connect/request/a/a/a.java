package com.iqoption.mobbtech.connect.request.a.a;

import android.support.v4.util.Pair;
import com.google.common.util.concurrent.s;
import com.google.gson.stream.JsonReader;
import com.iqoption.mobbtech.connect.response.h;
import com.iqoption.util.ah;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONRequestTask */
public class a extends h<h> {
    public a(Request request, com.iqoption.mobbtech.connect.a.a aVar, String str) {
        super(null, request, aVar, str);
    }

    public static s<h> a(Request request, com.iqoption.mobbtech.connect.a.a aVar, String str) {
        return new a(request, aVar, str).auF();
    }

    /* renamed from: iD */
    protected h ig(String str) {
        h hVar;
        if (str.startsWith("{")) {
            JSONObject jSONObject = new JSONObject(str);
            this.success = jSONObject.optBoolean("isSuccessful", false);
            if (this.success) {
                hVar = new h(jSONObject);
                hVar.setTag(this.cVe.url().toString());
            } else {
                hVar = null;
            }
            return hVar;
        }
        hVar = new h(new JSONObject().put("data", new JSONArray(str)));
        hVar.setTag(this.cVe.url().toString());
        this.success = true;
        return hVar;
    }

    protected Pair<h, String> o(JsonReader jsonReader) {
        String jsonElement = ah.aGi().parse(jsonReader).toString();
        return new Pair(ig(jsonElement), jsonElement);
    }
}
