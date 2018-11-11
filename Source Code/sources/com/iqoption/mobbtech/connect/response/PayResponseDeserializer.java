package com.iqoption.mobbtech.connect.response;

import com.crashlytics.android.a;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.core.i;
import com.iqoption.mobbtech.connect.response.i.b;
import com.iqoption.util.k;
import java.lang.reflect.Type;

public class PayResponseDeserializer implements JsonDeserializer<i> {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.PayResponseDeserializer";

    /* renamed from: l */
    public i deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            return h(jsonElement.getAsJsonObject());
        } catch (Throwable e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error during deserialization PayResponse ");
            stringBuilder.append(jsonElement == null ? "null" : jsonElement.toString());
            i.e(str, stringBuilder.toString(), e);
            return null;
        }
    }

    private i h(JsonObject jsonObject) {
        try {
            i iVar = (i) new Gson().fromJson((JsonElement) jsonObject, i.class);
            try {
                if (jsonObject.has("errors")) {
                    JsonElement jsonElement = jsonObject.get("errors");
                    if (jsonElement.isJsonObject()) {
                        iVar.cVR = (b) new Gson().fromJson(jsonElement, b.class);
                    }
                }
                return iVar;
            } catch (Throwable e) {
                i.e(TAG, "error when deserializing pay response errors", e);
                a.log("error when deserializing pay response");
                k.c(e);
                if (iVar == null) {
                    iVar = new i();
                }
                return iVar;
            }
        } catch (Throwable e2) {
            i.e(TAG, "error when deserializing pay response", e2);
            a.log("error when deserializing pay response");
            k.c(e2);
            return new i();
        }
    }
}
