package com.iqoption.mobbtech.connect.response.options;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.i;
import com.iqoption.util.ah;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public final class OpenOptionGroupDeserializer implements JsonDeserializer<b> {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.options.OpenOptionGroupDeserializer";

    /* renamed from: n */
    public b deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        b bVar = (b) ah.aGh().fromJson(jsonElement, type);
        try {
            if (jsonElement.getAsJsonObject().has("options")) {
                jsonElement = jsonElement.getAsJsonObject().get("options");
                if (jsonElement.isJsonArray()) {
                    bVar.F(g(jsonElement.getAsJsonArray()));
                }
            }
        } catch (Throwable e) {
            i.w(TAG, e.getMessage(), e);
        }
        return bVar;
    }

    private Collection<e> g(JsonArray jsonArray) {
        return (Collection) ah.aGg().fromJson((JsonElement) jsonArray, new TypeToken<List<e>>() {
        }.getType());
    }
}
