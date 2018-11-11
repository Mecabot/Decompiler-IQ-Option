package com.iqoption.mobbtech.connect.response.options;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.iqoption.core.i;
import com.iqoption.util.ah;
import java.lang.reflect.Type;

public final class OpenOptionGroupSerializer implements JsonSerializer<b> {
    private static final String TAG = "com.iqoption.mobbtech.connect.response.options.OpenOptionGroupSerializer";

    /* renamed from: a */
    public JsonElement serialize(b bVar, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement toJsonTree = ah.aGh().toJsonTree(bVar);
        try {
            JsonElement toJsonTree2 = ah.aGh().toJsonTree(bVar.avh());
            if (toJsonTree2 != null) {
                toJsonTree.getAsJsonObject().add("options", toJsonTree2);
            }
        } catch (Throwable e) {
            i.w(TAG, e.getMessage(), e);
        }
        return toJsonTree;
    }
}
