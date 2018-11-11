package com.iqoption.core.microservices.usersettings.a;

import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/microservices/usersettings/request/GetSetting;", "", "name", "", "version", "", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "core_release"})
/* compiled from: GetSetting.kt */
public final class a {
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
                if ((this.version == aVar.version ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.version;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetSetting(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(String str, int i) {
        h.e(str, "name");
        this.name = str;
        this.version = i;
    }

    public final String getName() {
        return this.name;
    }
}
