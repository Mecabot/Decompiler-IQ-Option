package com.iqoption.mobbtech.connect.response.options;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iqoption.core.i;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.dto.entity.position.PositionAndOrder;
import com.iqoption.util.ah;
import java.lang.reflect.Type;

public class OptionDeserializer implements JsonDeserializer<e> {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.options.OptionDeserializer";

    /* renamed from: o */
    public e deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            if (jsonElement.isJsonObject()) {
                return i(jsonElement.getAsJsonObject());
            }
        } catch (Throwable e) {
            i.w(TAG, e.getMessage(), e);
        }
        return null;
    }

    private e i(JsonObject jsonObject) {
        if (jsonObject.has("orders")) {
            return (e) ah.aGh().fromJson((JsonElement) jsonObject, PositionAndOrder.class);
        }
        if (jsonObject.has("instrument_id")) {
            return (e) ah.aGh().fromJson((JsonElement) jsonObject, Position.class);
        }
        return (e) ah.aGh().fromJson((JsonElement) jsonObject, e.class);
    }
}
