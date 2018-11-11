package com.iqoption.mobbtech.connect.response;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.iqoption.core.i;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map.Entry;

public class ProfileSaveDataResponseDeserializer implements JsonDeserializer<j> {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.ProfileSaveDataResponseDeserializer";

    /* renamed from: m */
    public j deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        try {
            JsonElement asJsonObject = jsonElement.getAsJsonObject();
            boolean asBoolean = asJsonObject.get("isSuccessful").getAsBoolean();
            JsonElement jsonElement2 = asJsonObject.get("message");
            if (jsonElement2.isJsonArray()) {
                return (j) new Gson().fromJson(asJsonObject, j.class);
            }
            j jVar = new j();
            jVar.isSuccessful = Boolean.valueOf(asBoolean);
            jVar.message = new ArrayList();
            for (Entry value : jsonElement2.getAsJsonObject().entrySet()) {
                jVar.message.add(((JsonElement) value.getValue()).getAsString());
            }
            return jVar;
        } catch (Throwable e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error during deserialization save data response ");
            stringBuilder.append(jsonElement == null ? "null" : jsonElement.toString());
            i.e(str, stringBuilder.toString(), e);
            return new j();
        }
    }
}
