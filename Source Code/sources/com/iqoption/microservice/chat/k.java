package com.iqoption.microservice.chat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/microservice/chat/ChatMessageTransferAdapter;", "", "options", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "isTransferred", "", "()Z", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Responses.kt */
public final class k {
    private final boolean cQi;

    public k(JsonObject jsonObject) {
        boolean asBoolean;
        if (jsonObject != null) {
            JsonElement jsonElement = jsonObject.get("is_transferred");
            if (jsonElement != null) {
                asBoolean = jsonElement.getAsBoolean();
                this.cQi = asBoolean;
            }
        }
        asBoolean = false;
        this.cQi = asBoolean;
    }

    public final boolean arG() {
        return this.cQi;
    }
}
