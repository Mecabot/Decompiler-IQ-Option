package com.iqoption.core.microservices.busapi.response;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(Deserializer.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "NONE", "WAITING", "CANCELED", "BLOCKED", "DELETED", "UNKNOWN", "Companion", "Deserializer", "core_release"})
/* compiled from: ForgetUserStatus.kt */
public enum ForgetUserStatus {
    NONE("none"),
    WAITING("waiting"),
    CANCELED("canceled"),
    BLOCKED("blocked"),
    DELETED("deleted"),
    UNKNOWN("_UNKNOWN");
    
    public static final a Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus$Companion;", "", "()V", "fromServerValue", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;", "value", "", "core_release"})
    /* compiled from: ForgetUserStatus.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final ForgetUserStatus fromServerValue(String str) {
            for (ForgetUserStatus forgetUserStatus : ForgetUserStatus.values()) {
                if (h.E(forgetUserStatus.getServerValue(), str)) {
                    break;
                }
            }
            ForgetUserStatus forgetUserStatus2 = null;
            return forgetUserStatus2 != null ? forgetUserStatus2 : ForgetUserStatus.UNKNOWN;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus$Deserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserStatus;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "core_release"})
    /* compiled from: ForgetUserStatus.kt */
    public static final class Deserializer implements JsonDeserializer<ForgetUserStatus> {
        /* renamed from: b */
        public ForgetUserStatus deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            h.e(jsonElement, "json");
            h.e(type, "typeOfT");
            h.e(jsonDeserializationContext, "context");
            return ForgetUserStatus.Companion.fromServerValue(jsonElement.getAsString());
        }
    }

    public static final ForgetUserStatus fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    protected ForgetUserStatus(String str) {
        h.e(str, "serverValue");
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new a();
    }
}
