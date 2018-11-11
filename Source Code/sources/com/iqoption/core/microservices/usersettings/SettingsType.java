package com.iqoption.core.microservices.usersettings;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.i;
import kotlin.jvm.internal.h;

@JsonAdapter(a.class)
@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\t\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/SettingsType;", "", "serverValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getServerValue", "()Ljava/lang/String;", "PRIVACY_SETTINGS", "UNKNOWN", "Adapter", "Companion", "core_release"})
/* compiled from: SettingsType.kt */
public enum SettingsType {
    PRIVACY_SETTINGS("privacy-settings"),
    UNKNOWN("_UNKNOWN_TYPE");
    
    public static final b Companion = null;
    private final String serverValue;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/SettingsType$Companion;", "", "()V", "fromServerValue", "Lcom/iqoption/core/microservices/usersettings/SettingsType;", "value", "", "core_release"})
    /* compiled from: SettingsType.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final SettingsType fromServerValue(String str) {
            for (SettingsType settingsType : SettingsType.values()) {
                if (u.m(settingsType.getServerValue(), str, true)) {
                    break;
                }
            }
            SettingsType settingsType2 = null;
            return settingsType2 != null ? settingsType2 : SettingsType.UNKNOWN;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/SettingsType$Adapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/iqoption/core/microservices/usersettings/SettingsType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "status", "core_release"})
    /* compiled from: SettingsType.kt */
    public static final class a extends TypeAdapter<SettingsType> {
        /* renamed from: a */
        public void write(JsonWriter jsonWriter, SettingsType settingsType) {
            h.e(jsonWriter, "out");
            jsonWriter.jsonValue(settingsType != null ? settingsType.getServerValue() : null);
        }

        /* renamed from: l */
        public SettingsType read(JsonReader jsonReader) {
            h.e(jsonReader, "reader");
            return SettingsType.Companion.fromServerValue(jsonReader.nextString());
        }
    }

    public static final SettingsType fromServerValue(String str) {
        return Companion.fromServerValue(str);
    }

    protected SettingsType(String str) {
        this.serverValue = str;
    }

    public final String getServerValue() {
        return this.serverValue;
    }

    static {
        Companion = new b();
    }
}
