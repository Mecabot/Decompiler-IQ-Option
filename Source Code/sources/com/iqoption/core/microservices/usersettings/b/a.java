package com.iqoption.core.microservices.usersettings.b;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.f;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/response/UserSettingsConfig;", "", "name", "", "version", "", "config", "Lcom/google/gson/JsonElement;", "(Ljava/lang/String;ILcom/google/gson/JsonElement;)V", "getConfig", "()Lcom/google/gson/JsonElement;", "getName", "()Ljava/lang/String;", "getVersion", "()I", "asConfig", "T", "configClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: UserSettingsConfig.kt */
public final class a {
    @SerializedName("config")
    private final JsonElement aZx;
    @SerializedName("name")
    private final String name;
    @SerializedName("version")
    private final int version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (h.E(this.name, aVar.name)) {
                return (this.version == aVar.version ? 1 : null) != null && h.E(this.aZx, aVar.aZx);
            }
        }
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.version) * 31;
        JsonElement jsonElement = this.aZx;
        if (jsonElement != null) {
            i = jsonElement.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserSettingsConfig(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", config=");
        stringBuilder.append(this.aZx);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final <T> T y(Class<T> cls) {
        h.e(cls, "configClass");
        try {
            return f.RQ().Dq().fromJson(this.aZx, (Class) cls);
        } catch (JsonSyntaxException e) {
            com.iqoption.core.i.e(a.class.getName(), e.toString());
            return null;
        }
    }
}
