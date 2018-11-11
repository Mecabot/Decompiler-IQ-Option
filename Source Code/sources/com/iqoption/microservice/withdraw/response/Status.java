package com.iqoption.microservice.withdraw.response;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(Deserializer.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/Status;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STATUS_NEW", "KYC_CHECKING", "OP_CREATING", "APPROVE_REQUIRED", "PENDING", "APPROVE_PROCESSING", "PROCESSING_READY", "PROCESSING_STARTED", "CALLBACK_WAIT", "ANSWER_RECEIVED", "FAILED", "PROCESSING_FAILED", "SUCCESS", "SUCCESS_PROCESSING", "DECLINED", "CANCELED", "CANCEL_PROCESSING", "UNKNOWN", "Deserializer", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawPayout.kt */
public enum Status {
    STATUS_NEW("STATUS_NEW"),
    KYC_CHECKING("KYC_CHECKING"),
    OP_CREATING("OP_CREATING"),
    APPROVE_REQUIRED("APPROVE_REQUIRED"),
    PENDING("PENDING"),
    APPROVE_PROCESSING("APPROVE_PROCESSING"),
    PROCESSING_READY("PROCESSING_READY"),
    PROCESSING_STARTED("PROCESSING_STARTED"),
    CALLBACK_WAIT("CALLBACK_WAIT"),
    ANSWER_RECEIVED("ANSWER_RECEIVED"),
    FAILED("FAILED"),
    PROCESSING_FAILED("PROCESSING_FAILED"),
    SUCCESS("SUCCESS"),
    SUCCESS_PROCESSING("SUCCESS_PROCESSING"),
    DECLINED("DECLINED"),
    CANCELED("CANCELED"),
    CANCEL_PROCESSING("CANCEL_PROCESSING"),
    UNKNOWN("UNKNOWN");
    
    private final String value;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/microservice/withdraw/response/Status$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/microservice/withdraw/response/Status;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawPayout.kt */
    public static final class Deserializer implements JsonDeserializer<Status> {
        /* renamed from: i */
        public Status deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonElement, "json");
            h.e(type, "typeOfT");
            h.e(jsonDeserializationContext, "context");
            String asString = jsonElement.getAsString();
            for (Status status : Status.values()) {
                if (h.E(status.getValue(), asString)) {
                    break;
                }
            }
            Status status2 = null;
            return status2 != null ? status2 : Status.UNKNOWN;
        }
    }

    protected Status(String str) {
        h.e(str, b.VALUE);
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
