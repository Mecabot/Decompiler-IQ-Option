package com.iqoption.mobbtech.connect.response;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(Deserializer.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/DeclineReason;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CARD_IS_NOT_SIGNED", "THERE_IS_NO_BACKSIDE", "NO_FRONT_SIDE", "BLACK_AND_WHITE_COPY", "WRONG_CARD", "COPY_IS_BLURRY", "INFO_IS_HIDDEN", "ANOTHER_REASON", "UNKNOWN", "Deserializer", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCard.kt */
public enum DeclineReason {
    CARD_IS_NOT_SIGNED("CARD_IS_NOT_SIGNED"),
    THERE_IS_NO_BACKSIDE("THERE_IS_NO_BACKSIDE"),
    NO_FRONT_SIDE("NO_FRONT_SIDE"),
    BLACK_AND_WHITE_COPY("BLACK_AND_WHITE_COPY"),
    WRONG_CARD("WRONG_CARD"),
    COPY_IS_BLURRY("COPY_IS_BLURRY"),
    INFO_IS_HIDDEN("INFO_IS_HIDDEN"),
    ANOTHER_REASON("ANOTHER_REASON"),
    UNKNOWN("UNKNOWN");
    
    private final String value;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/DeclineReason$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/mobbtech/connect/response/DeclineReason;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCard.kt */
    public static final class Deserializer implements JsonDeserializer<DeclineReason> {
        /* renamed from: k */
        public DeclineReason deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonElement, "json");
            h.e(type, "typeOfT");
            h.e(jsonDeserializationContext, "context");
            String asString = jsonElement.getAsString();
            for (DeclineReason declineReason : DeclineReason.values()) {
                if (h.E(declineReason.getValue(), asString)) {
                    break;
                }
            }
            DeclineReason declineReason2 = null;
            return declineReason2 != null ? declineReason2 : DeclineReason.UNKNOWN;
        }
    }

    protected DeclineReason(String str) {
        h.e(str, b.VALUE);
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
