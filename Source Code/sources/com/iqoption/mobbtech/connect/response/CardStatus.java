package com.iqoption.mobbtech.connect.response;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(nullSafe = false, value = a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0011\u0012B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/CardStatus;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "STATUS_NOT_REQUESTED", "NEW", "STARTED", "CALLBACK_WAIT", "UPLOAD_FAILED", "FAILED", "VERIFY_PENDING", "DECLINED", "VERIFIED", "UNKNOWN", "Adapter", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: VerifyCard.kt */
public enum CardStatus {
    STATUS_NOT_REQUESTED(null),
    NEW("new"),
    STARTED("started"),
    CALLBACK_WAIT("callback_wait"),
    UPLOAD_FAILED("upload_failed"),
    FAILED("failed"),
    VERIFY_PENDING("verify_pending"),
    DECLINED("declined"),
    VERIFIED("verified"),
    UNKNOWN("UNKNOWN");
    
    public static final b Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/CardStatus$Companion;", "", "()V", "fromServerValue", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "value", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCard.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final CardStatus fromServerValue(String str) {
            for (CardStatus cardStatus : CardStatus.values()) {
                if (u.m(cardStatus.getServerValue(), str, true)) {
                    break;
                }
            }
            CardStatus cardStatus2 = null;
            return cardStatus2 != null ? cardStatus2 : CardStatus.UNKNOWN;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/mobbtech/connect/response/CardStatus$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "status", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: VerifyCard.kt */
    public static final class a extends TypeAdapter<CardStatus> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, CardStatus cardStatus) {
            h.e(jsonWriter, "out");
            jsonWriter.jsonValue(cardStatus != null ? cardStatus.getServerValue() : null);
        }

        /* renamed from: q */
        public CardStatus read(JsonReader jsonReader) {
            String nextString;
            h.e(jsonReader, "reader");
            if (jsonReader.peek() != JsonToken.NULL) {
                nextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
                nextString = null;
            }
            return CardStatus.Companion.fromServerValue(nextString);
        }
    }

    public static final CardStatus fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    protected CardStatus(String str) {
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new b();
    }
}
