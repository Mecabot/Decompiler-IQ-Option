package com.iqoption.microservice.chat;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.iqoption.core.f;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, aXE = {"Lcom/iqoption/microservice/chat/ChatMessageSuggestionsAdapter;", "", "options", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "suggestions", "", "Lcom/iqoption/core/microservices/chat/response/ChatSuggestion;", "getSuggestions", "()Ljava/util/List;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class j {
    private final List<com.iqoption.core.microservices.b.a.a> aLM;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, aXE = {"com/iqoption/core/ext/GsonExtensionsKt$typeOf$1", "Lcom/google/gson/reflect/TypeToken;", "core_release", "com/iqoption/core/ext/GsonExtensionsKt$fromGson$$inlined$typeOf$4"})
    /* compiled from: GsonExtensions.kt */
    public static final class a extends TypeToken<List<? extends com.iqoption.core.microservices.b.a.a>> {
    }

    public j(JsonObject jsonObject) {
        List list;
        if (jsonObject != null) {
            JsonElement jsonElement = jsonObject.get("suggestions");
            if (jsonElement != null) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                if (asJsonArray != null) {
                    jsonElement = asJsonArray;
                    Gson Dq = f.RQ().Dq();
                    Type type = new a().getType();
                    h.d(type, "object : TypeToken<T>() {}.type");
                    list = (List) Dq.fromJson(jsonElement, type);
                    this.aLM = list;
                }
            }
        }
        list = null;
        this.aLM = list;
    }

    public final List<com.iqoption.core.microservices.b.a.a> Vz() {
        return this.aLM;
    }
}
