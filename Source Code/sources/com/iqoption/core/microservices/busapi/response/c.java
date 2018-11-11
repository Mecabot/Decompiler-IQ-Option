package com.iqoption.core.microservices.busapi.response;

import android.support.v4.app.NotificationCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, aXE = {"parseStatus", "", "jsonObject", "Lcom/google/gson/JsonObject;", "key", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "core_release"})
/* compiled from: PersonalDataPolicy.kt */
public final class c {
    private static final Boolean b(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.getAsJsonObject(str).get(NotificationCompat.CATEGORY_STATUS);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
        h.d(asJsonPrimitive, "value.asJsonPrimitive");
        return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
    }
}
