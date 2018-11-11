package com.iqoption.core.microservices.livedeals;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "PT1M", "PT5M", "UNKNOWN", "Adapter", "Companion", "core_release"})
/* compiled from: ExpirationType.kt */
public enum ExpirationType {
    PT1M("PT1M"),
    PT5M("PT5M"),
    UNKNOWN("_UNKNOWN_TYPE");
    
    public static final b Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/ExpirationType$Companion;", "", "()V", "fromServerValue", "Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "value", "", "core_release"})
    /* compiled from: ExpirationType.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final ExpirationType fromServerValue(String str) {
            for (ExpirationType expirationType : ExpirationType.values()) {
                if (u.m(expirationType.getServerValue(), str, true)) {
                    break;
                }
            }
            ExpirationType expirationType2 = null;
            return expirationType2 != null ? expirationType2 : ExpirationType.UNKNOWN;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/livedeals/ExpirationType$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/microservices/livedeals/ExpirationType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "status", "core_release"})
    /* compiled from: ExpirationType.kt */
    public static final class a extends TypeAdapter<ExpirationType> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, ExpirationType expirationType) {
            h.e(jsonWriter, "out");
            jsonWriter.jsonValue(expirationType != null ? expirationType.getServerValue() : null);
        }

        /* renamed from: f */
        public ExpirationType read(JsonReader jsonReader) {
            h.e(jsonReader, "reader");
            return ExpirationType.Companion.fromServerValue(jsonReader.nextString());
        }
    }

    public static final ExpirationType fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    protected ExpirationType(String str) {
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new b();
    }
}
