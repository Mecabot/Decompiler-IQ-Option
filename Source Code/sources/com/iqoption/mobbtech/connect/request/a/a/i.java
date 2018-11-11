package com.iqoption.mobbtech.connect.request.a.a;

import android.support.v4.util.Pair;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.iqoption.util.ah;
import okhttp3.Request;

/* compiled from: ResponseApiModelRequestTask */
public class i<T> extends b<T> {
    public i(Class<T> cls, Request request, String str) {
        super((Class) cls, request, str);
    }

    protected T ig(String str) {
        return ah.aGg().fromJson(ah.aGi().parse(str).getAsJsonObject().get("result"), this.type);
    }

    protected Pair<T, String> o(JsonReader jsonReader) {
        JsonObject asJsonObject = ah.aGi().parse(jsonReader).getAsJsonObject();
        return new Pair(ah.aGg().fromJson(asJsonObject.get("result"), this.type), asJsonObject.toString());
    }
}
