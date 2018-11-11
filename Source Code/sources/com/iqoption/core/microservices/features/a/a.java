package com.iqoption.core.microservices.features.a;

import android.support.v4.app.NotificationCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bBA\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, aXE = {"Lcom/iqoption/core/microservices/features/response/Feature;", "", "()V", "name", "", "status", "version", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "id", "", "category", "params", "Lcom/google/gson/JsonElement;", "(JLjava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;ILjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getId", "()J", "isDisabled", "", "()Z", "isEnabled", "getName", "getParams", "()Lcom/google/gson/JsonElement;", "getStatus", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "core_release"})
/* compiled from: Feature.kt */
public final class a {
    public static final a aVL = new a();
    @SerializedName("category")
    private final String category;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;
    @SerializedName("params")
    private final JsonElement params;
    @SerializedName("status")
    private final String status;
    @SerializedName("version")
    private final int version;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/core/microservices/features/response/Feature$Companion;", "", "()V", "DEFAULT_VERSION", "", "STATUS_DISABLED", "", "STATUS_ENABLED", "core_release"})
    /* compiled from: Feature.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if ((this.id == aVar.id ? 1 : null) != null && h.E(this.name, aVar.name) && h.E(this.category, aVar.category) && h.E(this.params, aVar.params)) {
                return (this.version == aVar.version ? 1 : null) != null && h.E(this.status, aVar.status);
            }
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.category;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        JsonElement jsonElement = this.params;
        i = (((i + (jsonElement != null ? jsonElement.hashCode() : 0)) * 31) + this.version) * 31;
        str = this.status;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Feature(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", params=");
        stringBuilder.append(this.params);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, String str, String str2, JsonElement jsonElement, int i, String str3) {
        h.e(str, "name");
        h.e(str2, "category");
        h.e(jsonElement, "params");
        h.e(str3, NotificationCompat.CATEGORY_STATUS);
        this.id = j;
        this.name = str;
        this.category = str2;
        this.params = jsonElement;
        this.version = i;
        this.status = str3;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ a(long j, String str, String str2, JsonElement jsonElement, int i, String str3, int i2, f fVar) {
        JsonElement jsonElement2;
        long j2 = (i2 & 1) != 0 ? -1 : j;
        String str4 = (i2 & 2) != 0 ? "" : str;
        String str5 = (i2 & 4) != 0 ? "" : str2;
        if ((i2 & 8) != 0) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            h.d(jsonNull, "JsonNull.INSTANCE");
            jsonElement2 = jsonNull;
        } else {
            jsonElement2 = jsonElement;
        }
        this(j2, str4, str5, jsonElement2, (i2 & 16) != 0 ? 1 : i, (i2 & 32) != 0 ? "disabled" : str3);
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getStatus() {
        return this.status;
    }

    public final boolean isEnabled() {
        return h.E(this.status, "disabled") ^ 1;
    }

    public a() {
        this(-1, null, null, null, 0, null, 62, null);
    }
}
