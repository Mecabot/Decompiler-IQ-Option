package com.iqoption.app.db;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class InterfaceAdapter<T> implements JsonDeserializer<T>, JsonSerializer<T> {
    public final JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.addProperty(Param.TYPE, t.getClass().getName());
        jsonObject.add("data", jsonSerializationContext.serialize(t));
        return jsonObject;
    }

    public final T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = (JsonObject) jsonElement;
        return jsonDeserializationContext.deserialize(a(jsonObject, "data"), a(a(jsonObject, Param.TYPE)));
    }

    private Type a(JsonElement jsonElement) {
        try {
            return Class.forName(jsonElement.getAsString());
        } catch (Throwable e) {
            throw new JsonParseException(e);
        }
    }

    private JsonElement a(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("no '");
        stringBuilder.append(str);
        stringBuilder.append("' member found in json file.");
        throw new JsonParseException(stringBuilder.toString());
    }
}
