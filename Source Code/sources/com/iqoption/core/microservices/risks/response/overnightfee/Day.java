package com.iqoption.core.microservices.risks.response.overnightfee;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/Day;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "convertToCalendarDay", "", "toString", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN", "UNKNOWN", "Adapter", "core_release"})
/* compiled from: Day.kt */
public enum Day {
    MON("mon"),
    TUE("tue"),
    WED("wed"),
    THU("thu"),
    FRI("fri"),
    SAT("sat"),
    SUN("sun"),
    UNKNOWN("_UNKNOWN");
    
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000f"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/overnightfee/Day$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/microservices/risks/response/overnightfee/Day;", "()V", "fromServerValue", "value", "", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "type", "core_release"})
    /* compiled from: Day.kt */
    public static final class a extends TypeAdapter<Day> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, Day day) {
            h.e(jsonWriter, "out");
            jsonWriter.value(day != null ? day.getServerValue() : null);
        }

        /* renamed from: j */
        public Day read(JsonReader jsonReader) {
            String nextString;
            h.e(jsonReader, "reader");
            if (jsonReader.peek() != JsonToken.NULL) {
                nextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
                nextString = null;
            }
            return gI(nextString);
        }

        public final Day gI(String str) {
            for (Day day : Day.values()) {
                if (h.E(day.getServerValue(), str)) {
                    break;
                }
            }
            Day day2 = null;
            return day2 != null ? day2 : Day.UNKNOWN;
        }
    }

    protected Day(String str) {
        h.e(str, "serverValue");
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    public final int convertToCalendarDay() {
        switch (this) {
            case SUN:
                return 1;
            case MON:
                return 2;
            case TUE:
                return 3;
            case WED:
                return 4;
            case THU:
                return 5;
            case FRI:
                return 6;
            case SAT:
                return 7;
            default:
                return 0;
        }
    }

    public String toString() {
        return this.serverValue;
    }
}
